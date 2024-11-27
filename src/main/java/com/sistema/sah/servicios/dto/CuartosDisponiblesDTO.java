package com.sistema.sah.servicios.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * DTO que representa los criterios para consultar cuartos disponibles.
 * <p>
 * Este objeto encapsula los parámetros necesarios para filtrar los cuartos
 * en base al tipo y rango de fechas de reserva.
 * </p>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CuartosDisponiblesDTO {

    /**
     * Identificador del tipo de cuarto.
     * <p>
     * Representa el tipo de cuarto que se desea consultar.
     * Por ejemplo: estándar, suite, deluxe, etc.
     * </p>
     */
    private Integer idTipoCuarto;

    /**
     * Fecha y hora de inicio de la reserva.
     * <p>
     * Indica a partir de qué momento se busca disponibilidad de cuartos.
     * </p>
     */
    private LocalDateTime fechaInicioReserva;

    /**
     * Fecha y hora de fin de la reserva.
     * <p>
     * Indica hasta qué momento se busca disponibilidad de cuartos.
     * </p>
     */
    private LocalDateTime fechaFinReserva;
}
