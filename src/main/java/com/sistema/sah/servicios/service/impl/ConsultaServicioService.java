package com.sistema.sah.servicios.service.impl;

import com.sistema.sah.commons.dto.RespuestaGeneralDto;
import com.sistema.sah.commons.dto.ServicioDto;
import com.sistema.sah.commons.helper.mapper.ServicioMapper;
import com.sistema.sah.servicios.repository.ServicioRepository;
import com.sistema.sah.servicios.service.IConsultaServicioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ConsultaServicioService implements IConsultaServicioService {

    private final ServicioRepository servicioRepository;

    private final ServicioMapper servicioMapper;

    public ConsultaServicioService(
            @Qualifier("servicio") ServicioRepository servicioRepository,
            ServicioMapper servicioMapper
    ) {
        this.servicioRepository = servicioRepository;
        this.servicioMapper = servicioMapper;
    }

    @Override
    public RespuestaGeneralDto consultarServicios() {
        RespuestaGeneralDto respuestaGeneralDto = new RespuestaGeneralDto();
        try{
            List<ServicioDto> servicios = servicioMapper.listEntityTolistDto(servicioRepository.findAll());
            respuestaGeneralDto.setData(servicios);
            respuestaGeneralDto.setMessage("Se consultaron correctamente");
            respuestaGeneralDto.setStatus(HttpStatus.OK);
        }catch (Exception e){
            log.error("Error ", e);
            respuestaGeneralDto.setMessage("Hubo un error en consultar");
            respuestaGeneralDto.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return respuestaGeneralDto;
    }
}
