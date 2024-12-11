package com.sistema.sah.servicios.util.mapper;

import com.sistema.sah.commons.dto.AlimentoDto;
import com.sistema.sah.servicios.entity.VistaAlimentosEntity;

import java.util.List;

public interface VistaAlimentoMapper {

    List<AlimentoDto> entityListToDtoList(List<VistaAlimentosEntity> vistaAlimentos);

}
