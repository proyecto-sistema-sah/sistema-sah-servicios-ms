package com.sistema.sah.servicios.repository;

import com.sistema.sah.commons.entity.ReservaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

/**
 * Repositorio para gestionar operaciones relacionadas con la entidad {@link ReservaEntity}.
 * <p>
 * Proporciona métodos CRUD predeterminados y consultas personalizadas para verificar
 * la existencia de reservas dentro de un rango de fechas específicas.
 * </p>
 *
 * @see ReservaEntity
 * @see JpaRepository
 */
@Repository("servicio-reserva")
public interface ReservaRepository extends JpaRepository<ReservaEntity, String> {

    /**
     * Verifica si existe una reserva que coincida con un cuarto y un rango de fechas.
     * <p>
     * Este método realiza una consulta personalizada para determinar si hay conflictos
     * de reservas para un cuarto específico dentro del rango de fechas proporcionado.
     * </p>
     *
     * @param codigoCuarto        el código del cuarto a verificar.
     * @param fechaInicioReserva  la fecha de inicio del rango de reserva.
     * @param fechaFinReserva     la fecha de fin del rango de reserva.
     * @return {@code true} si existe al menos una reserva que coincide con los criterios; {@code false} en caso contrario.
     */
    @Query("""
            SELECT COUNT(rc) > 0
            FROM ReservaCuartoEntity rc
            WHERE rc.codigoCuartoEntityFk.codigoCuarto = :codigoCuarto
              AND (
                  (rc.codigoReservaEntityFk.fechaInicioReserva BETWEEN :fechaInicioReserva AND :fechaFinReserva)
                  OR (rc.codigoReservaEntityFk.fechaFinReserva BETWEEN :fechaInicioReserva AND :fechaFinReserva)
                  OR (:fechaInicioReserva BETWEEN rc.codigoReservaEntityFk.fechaInicioReserva AND rc.codigoReservaEntityFk.fechaFinReserva)
                  OR (:fechaFinReserva BETWEEN rc.codigoReservaEntityFk.fechaInicioReserva AND rc.codigoReservaEntityFk.fechaFinReserva)
              ) AND rc.codigoReservaEntityFk.estadoReservaEntityFk.id = 3
    """)
    Boolean existsReserva(@Param("codigoCuarto") String codigoCuarto,
                          @Param("fechaInicioReserva") LocalDate fechaInicioReserva,
                          @Param("fechaFinReserva") LocalDate fechaFinReserva);
}
