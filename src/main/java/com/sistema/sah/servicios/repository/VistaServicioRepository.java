package com.sistema.sah.servicios.repository;

import com.sistema.sah.servicios.entity.VistaServiciosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VistaServicioRepository extends JpaRepository<VistaServiciosEntity, String> {

    List<VistaServiciosEntity> findAll();

}
