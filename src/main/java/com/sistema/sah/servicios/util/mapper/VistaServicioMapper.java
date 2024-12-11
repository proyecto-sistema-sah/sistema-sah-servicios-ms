package com.sistema.sah.servicios.util.mapper;

import com.sistema.sah.commons.dto.ServicioDto;
import com.sistema.sah.servicios.entity.VistaServiciosEntity;

import java.util.List;

public interface VistaServicioMapper {

    List<ServicioDto> entityListToDtoList(List<VistaServiciosEntity> vistaServicio);


}
