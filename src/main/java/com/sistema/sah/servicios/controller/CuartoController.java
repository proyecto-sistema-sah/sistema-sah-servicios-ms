package com.sistema.sah.servicios.controller;

import com.sistema.sah.commons.dto.RespuestaGeneralDto;
import com.sistema.sah.servicios.dto.CuartosDisponiblesDTO;
import com.sistema.sah.servicios.service.IConsultarCuartoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador para gestionar operaciones relacionadas con los cuartos.
 * <p>
 * Este controlador expone endpoints para consultar cuartos disponibles
 * basados en los criterios proporcionados.
 * </p>
 */
@RestController
@RequestMapping("/cuartos")
@RequiredArgsConstructor
@Slf4j
public class CuartoController {

    private final IConsultarCuartoService consultarCuartoService;

    /**
     * Endpoint para consultar la disponibilidad de cuartos.
     * <p>
     * Este método recibe un objeto {@link CuartosDisponiblesDTO} que contiene los criterios
     * de búsqueda y llama al servicio correspondiente para obtener la información.
     * </p>
     *
     * @param cuartosDisponiblesDTO DTO con los criterios para consultar cuartos disponibles.
     * @return una {@link ResponseEntity} con el estado HTTP y la lista de cuartos disponibles en el cuerpo.
     */
    @PostMapping("/consultar")
    public ResponseEntity<RespuestaGeneralDto> listadoCuartos(@RequestBody CuartosDisponiblesDTO cuartosDisponiblesDTO) {
        RespuestaGeneralDto respuesta = consultarCuartoService.consultarCuarto(cuartosDisponiblesDTO);
        return ResponseEntity.status(respuesta.getStatus()).body(respuesta);
    }
}
