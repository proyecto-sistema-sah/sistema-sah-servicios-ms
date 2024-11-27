package com.sistema.sah.servicios.repository;

import com.sistema.sah.commons.entity.ReservaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Repository("servicio-reserva")
public interface ReservaRepository extends JpaRepository<ReservaEntity, String> {

    @Query("""
            SELECT COUNT(rc) > 0
                  FROM ReservaCuartoEntity rc
                  WHERE rc.codigoCuartoEntityFk.codigoCuarto = :codigoCuarto
                  AND (
                      (rc.codigoReservaEntityFk.fechaInicioReserva BETWEEN :fechaInicioReserva AND :fechaFinReserva)
                      OR (rc.codigoReservaEntityFk.fechaFinReserva BETWEEN :fechaInicioReserva AND :fechaFinReserva)
                      OR (:fechaInicioReserva BETWEEN rc.codigoReservaEntityFk.fechaInicioReserva AND rc.codigoReservaEntityFk.fechaFinReserva)
                      OR (:fechaFinReserva BETWEEN rc.codigoReservaEntityFk.fechaInicioReserva AND rc.codigoReservaEntityFk.fechaFinReserva)
                  )
    """)
    Boolean existsReserva(@Param("codigoCuarto") String codigoCuarto,
                          @Param("fechaInicioReserva") LocalDate fechaInicioReserva,
                          @Param("fechaFinReserva") LocalDate fechaFinReserva);


}
