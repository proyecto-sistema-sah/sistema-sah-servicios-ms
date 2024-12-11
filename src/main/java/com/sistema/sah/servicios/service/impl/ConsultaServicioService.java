package com.sistema.sah.servicios.service.impl;

import com.sistema.sah.commons.dto.RespuestaGeneralDto;
import com.sistema.sah.commons.dto.ServicioDto;
import com.sistema.sah.commons.helper.mapper.ServicioMapper;
import com.sistema.sah.servicios.repository.ServicioRepository;
import com.sistema.sah.servicios.repository.VistaServicioRepository;
import com.sistema.sah.servicios.service.IConsultaServicioService;
import com.sistema.sah.servicios.util.mapper.VistaServicioMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementación del servicio para la consulta de servicios.
 * <p>
 * Este servicio se encarga de recuperar la lista de servicios disponibles en el sistema
 * y estructurar la respuesta de manera adecuada.
 * </p>
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class ConsultaServicioService implements IConsultaServicioService {

    private final VistaServicioRepository vistaServicioRepository;
    private final VistaServicioMapper vistaServicioMapper;

    /**
     * Consulta la lista de servicios disponibles.
     * <p>
     * Este método recupera todos los servicios de la base de datos, los mapea a DTOs
     * y devuelve una respuesta estructurada con el estado, los datos y un mensaje.
     * </p>
     *
     * @return un objeto {@link RespuestaGeneralDto} con la lista de servicios disponibles.
     */
    @Override
    public RespuestaGeneralDto consultarServicios() {
        log.info("Iniciando consulta de servicios");

        try {
            // Recuperar y mapear la lista de servicios
            List<ServicioDto> servicios = vistaServicioMapper.entityListToDtoList(vistaServicioRepository.findAll());

            log.info("Consulta de servicios completada con éxito. Total de servicios: {}", servicios.size());
            return RespuestaGeneralDto.builder()
                    .data(servicios)
                    .message("Consulta realizada correctamente")
                    .status(HttpStatus.OK)
                    .build();

        } catch (Exception e) {
            log.error("Error al consultar servicios", e);
            return RespuestaGeneralDto.builder()
                    .message("Hubo un error al consultar los servicios")
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }
}
