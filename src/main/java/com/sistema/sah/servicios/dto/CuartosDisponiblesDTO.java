package com.sistema.sah.servicios.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CuartosDisponiblesDTO {

    private Integer idTipoCuarto;

    private LocalDateTime fechaInicioReserva;

    private LocalDateTime fechaFinReserva;

}
