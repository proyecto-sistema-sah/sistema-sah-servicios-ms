package com.sistema.sah.servicios.controller;

import com.sistema.sah.commons.dto.RespuestaGeneralDto;
import com.sistema.sah.servicios.service.IConsultaAlimentoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador para gestionar operaciones relacionadas con los alimentos.
 * <p>
 * Este controlador expone endpoints para la consulta de alimentos disponibles.
 * </p>
 */
@RestController
@RequestMapping("/alimentos")
@RequiredArgsConstructor
@Slf4j
public class AlimentoController {

    private final IConsultaAlimentoService consultaAlimentoService;

    /**
     * Endpoint para consultar la lista de alimentos disponibles.
     * <p>
     * Este método llama al servicio correspondiente para obtener la lista de alimentos y
     * devuelve una respuesta estructurada.
     * </p>
     *
     * @return una {@link ResponseEntity} con el estado HTTP y la lista de alimentos en el cuerpo.
     */
    @GetMapping("/consultar")
    public ResponseEntity<RespuestaGeneralDto> listadoAlimento() {
        RespuestaGeneralDto respuesta = consultaAlimentoService.consultarAlimentos();
        return ResponseEntity.status(respuesta.getStatus()).body(respuesta);
    }
}
