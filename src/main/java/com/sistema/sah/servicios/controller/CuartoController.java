package com.sistema.sah.servicios.controller;


import com.sistema.sah.commons.dto.RespuestaGeneralDto;
import com.sistema.sah.servicios.dto.CuartosDisponiblesDTO;
import com.sistema.sah.servicios.service.IConsultarCuartoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cuartos")
@RequiredArgsConstructor
public class CuartoController {

    private final IConsultarCuartoService consultarCuartoService;

    @PostMapping("/consultar")
    public ResponseEntity<RespuestaGeneralDto> listadoCuartos(@RequestBody CuartosDisponiblesDTO cuartosDisponiblesDTO) {
        RespuestaGeneralDto respuestaGeneralDto = consultarCuartoService.consultarCuarto(cuartosDisponiblesDTO);
        return ResponseEntity.status(respuestaGeneralDto.getStatus()).body(respuestaGeneralDto);
    }

}
