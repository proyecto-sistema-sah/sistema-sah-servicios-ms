package com.sistema.sah.servicios.service.impl;

import com.sistema.sah.commons.dto.CuartoDto;
import com.sistema.sah.commons.dto.RespuestaGeneralDto;
import com.sistema.sah.commons.helper.mapper.CuartoMapper;
import com.sistema.sah.servicios.dto.CuartosDisponiblesDTO;
import com.sistema.sah.servicios.repository.CuartoRepository;
import com.sistema.sah.servicios.repository.ReservaRepository;
import com.sistema.sah.servicios.repository.ServicioRepository;
import com.sistema.sah.servicios.service.IConsultarCuartoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ConsultarCuartoService implements IConsultarCuartoService {

    private final CuartoRepository cuartoRepository;

    private final ReservaRepository reservaRepository;

    private final CuartoMapper cuartoMapper;

    public ConsultarCuartoService(@Qualifier("servicios") CuartoRepository cuartoRepository,
                                  @Qualifier("servicio-reserva") ReservaRepository reservaRepository,
                                  CuartoMapper cuartoMapper) {
        this.cuartoRepository = cuartoRepository;
        this.cuartoMapper = cuartoMapper;
        this.reservaRepository = reservaRepository;
    }


    @Override
    public RespuestaGeneralDto consultarCuarto(CuartosDisponiblesDTO cuartosDisponiblesDTO) {
        RespuestaGeneralDto respuestaGeneralDto = new RespuestaGeneralDto();
        List<CuartoDto> cuartos;
        List<CuartoDto> cuartosResultados = new ArrayList<>();
        LocalDate fechaInicio = cuartosDisponiblesDTO.getFechaInicioReserva().toLocalDate();
        LocalDate fechaFinal = cuartosDisponiblesDTO.getFechaFinReserva().toLocalDate();
        try{
            if(cuartosDisponiblesDTO.getIdTipoCuarto() == 0){
                cuartos = cuartoMapper.listEntityTolistDto(cuartoRepository.findAll());
            }else{
                cuartos = cuartoMapper.listEntityTolistDto(cuartoRepository.findAllByTipoCuartoEntityFk_Id(cuartosDisponiblesDTO.getIdTipoCuarto()));
            }
            for(CuartoDto cuarto : cuartos){
                if(!reservaRepository.existsReserva(cuarto.getCodigoCuarto(),fechaInicio, fechaFinal) && cuarto.getEstadoCuartoDtoFk().getId() == 2){
                    cuartosResultados.add(cuarto);
                }
            }
            respuestaGeneralDto.setMessage("Se consultaron correctamente los cuartos");
            respuestaGeneralDto.setStatus(HttpStatus.OK);
            respuestaGeneralDto.setData(cuartosResultados);
        }catch (Exception e){
            log.error("Error ", e);
            respuestaGeneralDto.setMessage("Hubo un error en la consulta de los cuartos");
            respuestaGeneralDto.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return respuestaGeneralDto;
    }
}
