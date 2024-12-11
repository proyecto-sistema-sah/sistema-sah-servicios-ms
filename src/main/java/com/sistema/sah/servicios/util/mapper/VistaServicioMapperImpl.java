package com.sistema.sah.servicios.util.mapper;

import com.sistema.sah.commons.dto.AlimentoDto;
import com.sistema.sah.commons.dto.ServicioDto;
import com.sistema.sah.commons.helper.mapper.TipoServicioMapper;
import com.sistema.sah.servicios.entity.VistaAlimentosEntity;
import com.sistema.sah.servicios.entity.VistaServiciosEntity;
import com.sistema.sah.servicios.repository.ServicioRepository;
import com.sistema.sah.servicios.repository.TipoServicioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class VistaServicioMapperImpl implements VistaServicioMapper {

    private final TipoServicioRepository tipoServicioRepository;

    private final TipoServicioMapper tipoServicioMapper;

    @Override
    public List<ServicioDto> entityListToDtoList(List<VistaServiciosEntity> vistaServicio) {
        List<ServicioDto> servicioDtos = new ArrayList<>();
        for(VistaServiciosEntity vistaServicios : vistaServicio) {
            servicioDtos.add(ServicioDto.builder()
                    .codigoServicio(vistaServicios.getCodigoServicio())
                            .nombreServicio(vistaServicios.getNombreServicio())
                            .valorServicio(vistaServicios.getValorServicio())
                    .codigoImagenServicio(vistaServicios.getCodigoImagenServicio())
                            .detalleServicio(vistaServicios.getDetalleServicio())
                            .tipoServicioDtoFk(tipoServicioMapper.entityToDto(tipoServicioRepository.findById(vistaServicios.getTipoServicioEntityFk()).orElse(null)))
                    .build());
        }
        return servicioDtos;
    }
}
