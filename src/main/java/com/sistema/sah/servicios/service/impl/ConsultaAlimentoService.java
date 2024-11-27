package com.sistema.sah.servicios.service.impl;

import com.sistema.sah.commons.dto.AlimentoDto;
import com.sistema.sah.commons.dto.RespuestaGeneralDto;
import com.sistema.sah.commons.dto.ServicioDto;
import com.sistema.sah.commons.helper.mapper.AlimentoMapper;
import com.sistema.sah.servicios.repository.AlimentoRepository;
import com.sistema.sah.servicios.service.IConsultaAlimentoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ConsultaAlimentoService implements IConsultaAlimentoService {

    private final AlimentoRepository alimentoRepository;

    private final AlimentoMapper alimentoMapper;

    public ConsultaAlimentoService(
            @Qualifier("servicio-alimento") AlimentoRepository alimentoRepository,
            AlimentoMapper alimentoMapper
    ) {
        this.alimentoRepository = alimentoRepository;
        this.alimentoMapper = alimentoMapper;
    }

    @Override
    public RespuestaGeneralDto consultarAlimentos() {
        RespuestaGeneralDto respuestaGeneralDto = new RespuestaGeneralDto();
        try{
            List<AlimentoDto> alimentos = alimentoMapper.listEntityTolistDto(alimentoRepository.findAll());
            respuestaGeneralDto.setData(alimentos);
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
