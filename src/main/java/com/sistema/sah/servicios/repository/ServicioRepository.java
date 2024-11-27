package com.sistema.sah.servicios.repository;

import com.sistema.sah.commons.entity.ServicioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para gestionar operaciones relacionadas con la entidad {@link ServicioEntity}.
 * <p>
 * Proporciona métodos CRUD predeterminados para interactuar con la tabla de servicios
 * en la base de datos. Extiende {@link JpaRepository} para heredar funcionalidades avanzadas
 * de JPA.
 * </p>
 *
 * @see ServicioEntity
 * @see JpaRepository
 */
@Repository("servicio")
public interface ServicioRepository extends JpaRepository<ServicioEntity, String> {
}
