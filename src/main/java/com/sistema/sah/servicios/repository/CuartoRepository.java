package com.sistema.sah.servicios.repository;

import com.sistema.sah.commons.entity.CuartoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("servicios")
public interface CuartoRepository extends JpaRepository<CuartoEntity, String> {

    List<CuartoEntity> findAllByTipoCuartoEntityFk_Id(Integer idTipoCuarto);

}
