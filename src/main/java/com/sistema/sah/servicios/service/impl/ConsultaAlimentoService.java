package com.sistema.sah.servicios.service.impl;

import com.sistema.sah.commons.dto.AlimentoDto;
import com.sistema.sah.commons.dto.RespuestaGeneralDto;
import com.sistema.sah.commons.helper.mapper.AlimentoMapper;
import com.sistema.sah.servicios.repository.AlimentoRepository;
import com.sistema.sah.servicios.repository.VistaAlimentosRepository;
import com.sistema.sah.servicios.service.IConsultaAlimentoService;
import com.sistema.sah.servicios.util.mapper.VistaAlimentoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementación del servicio para la consulta de alimentos.
 * <p>
 * Este servicio se encarga de recuperar la lista de alimentos disponibles en el sistema
 * y estructurar la respuesta de manera adecuada.
 * </p>
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class ConsultaAlimentoService implements IConsultaAlimentoService {

    private final VistaAlimentosRepository vistaAlimentosRepository;
    private final VistaAlimentoMapper vistaAlimentoMapper;

    /**
     * Consulta la lista de alimentos disponibles.
     * <p>
     * Este método recupera todos los alimentos de la base de datos, los mapea a DTOs
     * y devuelve una respuesta estructurada con el estado, los datos y un mensaje.
     * </p>
     *
     * @return un objeto {@link RespuestaGeneralDto} con la lista de alimentos disponibles.
     */
    @Override
    public RespuestaGeneralDto consultarAlimentos() {
        log.info("Iniciando consulta de alimentos");
        try {
            // Recuperar y mapear la lista de alimentos
            List<AlimentoDto> alimentos = vistaAlimentoMapper.entityListToDtoList(vistaAlimentosRepository.findAll());

            log.info("Consulta de alimentos completada con éxito. Total de alimentos: {}", alimentos.size());
            return RespuestaGeneralDto.builder()
                    .data(alimentos)
                    .message("Consulta realizada correctamente")
                    .status(HttpStatus.OK)
                    .build();
        } catch (Exception e) {
            log.error("Error al consultar alimentos", e);
            return RespuestaGeneralDto.builder()
                    .message("Hubo un error al consultar los alimentos")
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }
}
