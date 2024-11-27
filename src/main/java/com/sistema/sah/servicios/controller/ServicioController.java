package com.sistema.sah.servicios.controller;

import com.sistema.sah.commons.dto.RespuestaGeneralDto;
import com.sistema.sah.servicios.service.IConsultaServicioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/servicios")
@RequiredArgsConstructor
public class ServicioController {

    private final IConsultaServicioService consultaServicioService;

    @GetMapping("/consultar")
    public ResponseEntity<RespuestaGeneralDto> listadoServicios() {
        RespuestaGeneralDto respuestaGeneralDto = consultaServicioService.consultarServicios();
        return ResponseEntity.status(respuestaGeneralDto.getStatus()).body(respuestaGeneralDto);
    }

}
