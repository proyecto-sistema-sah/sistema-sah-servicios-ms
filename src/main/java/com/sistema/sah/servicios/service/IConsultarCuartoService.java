package com.sistema.sah.servicios.service;

import com.sistema.sah.commons.dto.RespuestaGeneralDto;
import com.sistema.sah.servicios.dto.CuartosDisponiblesDTO;

public interface IConsultarCuartoService {

    RespuestaGeneralDto consultarCuarto(CuartosDisponiblesDTO cuartosDisponiblesDTO);

}
