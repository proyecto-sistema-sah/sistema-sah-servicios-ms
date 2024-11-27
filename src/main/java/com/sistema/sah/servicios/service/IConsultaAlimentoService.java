package com.sistema.sah.servicios.service;

import com.sistema.sah.commons.dto.RespuestaGeneralDto;

/**
 * Interfaz para el servicio de consulta de alimentos.
 * <p>
 * Proporciona un método para obtener información sobre los alimentos disponibles
 * en el sistema.
 * </p>
 */
public interface IConsultaAlimentoService {

    /**
     * Consulta la lista de alimentos disponibles en el sistema.
     * <p>
     * Este método recupera información sobre todos los alimentos y la estructura
     * en un objeto {@link RespuestaGeneralDto}.
     * </p>
     *
     * @return un objeto {@link RespuestaGeneralDto} que contiene la lista de alimentos,
     * el estado de la operación y un mensaje descriptivo.
     */
    RespuestaGeneralDto consultarAlimentos();

}
