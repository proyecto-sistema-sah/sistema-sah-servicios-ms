package com.sistema.sah.servicios.service;

import com.sistema.sah.commons.dto.RespuestaGeneralDto;

/**
 * Interfaz para el servicio de consulta de servicios.
 * <p>
 * Proporciona un método para obtener información sobre los servicios disponibles
 * en el sistema.
 * </p>
 */
public interface IConsultaServicioService {

    /**
     * Consulta la lista de servicios disponibles en el sistema.
     * <p>
     * Este método recupera información sobre todos los servicios registrados y la estructura
     * en un objeto {@link RespuestaGeneralDto}.
     * </p>
     *
     * @return un objeto {@link RespuestaGeneralDto} que contiene la lista de servicios,
     * el estado de la operación y un mensaje descriptivo.
     */
    RespuestaGeneralDto consultarServicios();

}
