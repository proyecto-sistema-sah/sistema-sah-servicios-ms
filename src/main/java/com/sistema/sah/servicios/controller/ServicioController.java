package com.sistema.sah.servicios.controller;

import com.sistema.sah.commons.dto.RespuestaGeneralDto;
import com.sistema.sah.servicios.service.IConsultaServicioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador para gestionar operaciones relacionadas con los servicios.
 * <p>
 * Este controlador expone un endpoint para consultar la lista de servicios disponibles.
 * </p>
 */
@RestController
@RequestMapping("/servicios")
@RequiredArgsConstructor
@Slf4j
public class ServicioController {

    private final IConsultaServicioService consultaServicioService;

    /**
     * Endpoint para consultar la lista de servicios disponibles.
     * <p>
     * Este método delega la lógica al servicio correspondiente y devuelve una
     * respuesta estructurada al cliente.
     * </p>
     *
     * @return una {@link ResponseEntity} con el estado HTTP y la lista de servicios.
     */
    @GetMapping("/consultar")
    public ResponseEntity<RespuestaGeneralDto> listadoServicios() {
        log.info("Inicio de la consulta de servicios");
        RespuestaGeneralDto respuesta = consultaServicioService.consultarServicios();
        log.info("Consulta de servicios completada con éxito");
        return ResponseEntity.status(respuesta.getStatus()).body(respuesta);
    }
}
