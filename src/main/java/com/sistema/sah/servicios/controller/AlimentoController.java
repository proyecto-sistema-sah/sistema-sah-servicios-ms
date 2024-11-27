package com.sistema.sah.servicios.controller;

import com.sistema.sah.commons.dto.RespuestaGeneralDto;
import com.sistema.sah.servicios.service.IConsultaAlimentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alimentos")
@RequiredArgsConstructor
public class AlimentoController {

    private final IConsultaAlimentoService consultaAlimentoService;

    @GetMapping("/consultar")
    public ResponseEntity<RespuestaGeneralDto> listadoAlimento() {
        RespuestaGeneralDto respuestaGeneralDto = consultaAlimentoService.consultarAlimentos();
        return ResponseEntity.status(respuestaGeneralDto.getStatus()).body(respuestaGeneralDto);
    }


}
