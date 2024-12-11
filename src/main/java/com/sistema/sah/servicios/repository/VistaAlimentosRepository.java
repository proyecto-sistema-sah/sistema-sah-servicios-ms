package com.sistema.sah.servicios.repository;

import com.sistema.sah.servicios.entity.VistaAlimentosEntity;
import com.sistema.sah.servicios.entity.VistaServiciosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VistaAlimentosRepository extends JpaRepository<VistaAlimentosEntity, String> {

    List<VistaAlimentosEntity> findAll();

}

