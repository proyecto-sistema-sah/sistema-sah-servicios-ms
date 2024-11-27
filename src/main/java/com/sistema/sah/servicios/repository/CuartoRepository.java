package com.sistema.sah.servicios.repository;

import com.sistema.sah.commons.entity.CuartoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio para gestionar operaciones relacionadas con la entidad {@link CuartoEntity}.
 * <p>
 * Proporciona métodos CRUD predeterminados para interactuar con la tabla de cuartos
 * en la base de datos, además de consultas personalizadas para filtrar por tipo de cuarto.
 * </p>
 *
 * @see CuartoEntity
 * @see JpaRepository
 */
@Repository("servicios")
public interface CuartoRepository extends JpaRepository<CuartoEntity, String> {

    /**
     * Busca todos los cuartos que coincidan con un tipo de cuarto específico.
     * <p>
     * Este método permite filtrar cuartos según su relación con el tipo de cuarto
     * especificado por su identificador.
     * </p>
     *
     * @param idTipoCuarto identificador del tipo de cuarto.
     * @return una lista de {@link CuartoEntity} que pertenecen al tipo de cuarto especificado.
     */
    List<CuartoEntity> findAllByTipoCuartoEntityFk_Id(Integer idTipoCuarto);
}
