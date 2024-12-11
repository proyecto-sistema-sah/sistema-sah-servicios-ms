package com.sistema.sah.servicios.util.mapper;

import com.sistema.sah.commons.dto.AlimentoDto;
import com.sistema.sah.commons.helper.mapper.TipoAlimentoMapper;
import com.sistema.sah.servicios.entity.VistaAlimentosEntity;
import com.sistema.sah.servicios.repository.TipoAlimentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class VistaAlimentoMapperImpl implements VistaAlimentoMapper {

    private final TipoAlimentoRepository tipoAlimentoRepository;

    private final TipoAlimentoMapper tipoAlimentoMapper;

    @Override
    public List<AlimentoDto> entityListToDtoList(List<VistaAlimentosEntity> vistaAlimentos) {
        List<AlimentoDto> alimentoDtos = new ArrayList<>();
        for(VistaAlimentosEntity vistaAlimento : vistaAlimentos) {
            alimentoDtos.add(AlimentoDto.builder()
                            .codigoAlimento(vistaAlimento.getCodigoAlimento())
                            .codigoImagen(vistaAlimento.getCodigoImagen())
                            .detalleAlimento(vistaAlimento.getDetalleAlimento())
                            .nombreAlimento(vistaAlimento.getNombreAlimento())
                            .tiempoPreparacionAlimento(vistaAlimento.getTiempoPreparacionAlimento())
                            .tipoAlimentoDtoFk(tipoAlimentoMapper.entityToDto(tipoAlimentoRepository.findById(vistaAlimento.getTipoAlimentoEntityFk()).orElse(null)))
                    .build());
        }
        return alimentoDtos;
    }
}
