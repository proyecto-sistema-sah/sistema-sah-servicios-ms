package com.sistema.sah.servicios.service;

import com.sistema.sah.commons.dto.RespuestaGeneralDto;
import com.sistema.sah.servicios.dto.CuartosDisponiblesDTO;

/**
 * Interfaz para el servicio de consulta de cuartos disponibles.
 * <p>
 * Proporciona un método para obtener la lista de cuartos disponibles en el sistema
 * según los criterios especificados.
 * </p>
 */
public interface IConsultarCuartoService {

    /**
     * Consulta la disponibilidad de cuartos en el sistema según los criterios especificados.
     * <p>
     * Este método utiliza el objeto {@link CuartosDisponiblesDTO} para filtrar cuartos
     * en base a tipo y rango de fechas, y devuelve una respuesta estructurada.
     * </p>
     *
     * @param cuartosDisponiblesDTO DTO que contiene los criterios para la consulta de cuartos disponibles.
     * @return un objeto {@link RespuestaGeneralDto} que contiene la lista de cuartos disponibles,
     * el estado de la operación y un mensaje descriptivo.
     */
    RespuestaGeneralDto consultarCuarto(CuartosDisponiblesDTO cuartosDisponiblesDTO);

}
