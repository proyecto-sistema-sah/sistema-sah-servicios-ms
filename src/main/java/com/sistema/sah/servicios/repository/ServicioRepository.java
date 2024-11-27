package com.sistema.sah.servicios.repository;

import com.sistema.sah.commons.entity.ServicioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("servicio")
public interface ServicioRepository extends JpaRepository<ServicioEntity, String> {
}
