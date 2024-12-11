package com.sistema.sah.servicios.repository;

import com.sistema.sah.commons.entity.TipoServicioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoServicioRepository extends JpaRepository<TipoServicioEntity, Integer> {
}
