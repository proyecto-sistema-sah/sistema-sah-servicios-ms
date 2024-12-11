package com.sistema.sah.servicios.repository;

import com.sistema.sah.commons.entity.TipoAlimentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoAlimentoRepository extends JpaRepository<TipoAlimentoEntity,Integer> {

    TipoAlimentoEntity findById(int id);

}
