package com.sistema.sah.servicios.repository;

import com.sistema.sah.commons.entity.AlimentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("servicio-alimento")
public interface AlimentoRepository extends JpaRepository<AlimentoEntity, String> {
}
