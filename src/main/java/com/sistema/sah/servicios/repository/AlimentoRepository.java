package com.sistema.sah.servicios.repository;

import com.sistema.sah.commons.entity.AlimentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para gestionar operaciones relacionadas con la entidad {@link AlimentoEntity}.
 * <p>
 * Proporciona métodos CRUD predeterminados para interactuar con la tabla de alimentos
 * en la base de datos. Extiende {@link JpaRepository} para heredar funcionalidades
 * avanzadas de JPA.
 * </p>
 *
 * @see AlimentoEntity
 * @see JpaRepository
 */
@Repository("servicio-alimento")
public interface AlimentoRepository extends JpaRepository<AlimentoEntity, String> {
}
