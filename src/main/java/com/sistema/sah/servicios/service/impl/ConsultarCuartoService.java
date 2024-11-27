package com.sistema.sah.servicios.service.impl;

import com.sistema.sah.commons.dto.CuartoDto;
import com.sistema.sah.commons.dto.RespuestaGeneralDto;
import com.sistema.sah.commons.helper.mapper.CuartoMapper;
import com.sistema.sah.servicios.dto.CuartosDisponiblesDTO;
import com.sistema.sah.servicios.repository.CuartoRepository;
import com.sistema.sah.servicios.repository.ReservaRepository;
import com.sistema.sah.servicios.service.IConsultarCuartoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementación del servicio para consultar cuartos disponibles.
 * <p>
 * Este servicio recupera la lista de cuartos según los criterios especificados
 * y verifica su disponibilidad en el sistema.
 * </p>
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class ConsultarCuartoService implements IConsultarCuartoService {

    private final @Qualifier("servicios") CuartoRepository cuartoRepository;
    private final @Qualifier("servicio-reserva") ReservaRepository reservaRepository;
    private final CuartoMapper cuartoMapper;

    /**
     * Consulta la lista de cuartos disponibles según los criterios especificados.
     * <p>
     * Este método filtra los cuartos por tipo y verifica su disponibilidad según
     * el rango de fechas proporcionado.
     * </p>
     *
     * @param cuartosDisponiblesDTO DTO que contiene los criterios de búsqueda.
     * @return un objeto {@link RespuestaGeneralDto} con los cuartos disponibles.
     */
    @Override
    public RespuestaGeneralDto consultarCuarto(CuartosDisponiblesDTO cuartosDisponiblesDTO) {
        log.info("Iniciando consulta de cuartos con criterios: {}", cuartosDisponiblesDTO);

        try {
            List<CuartoDto> cuartos = obtenerCuartosPorTipo(cuartosDisponiblesDTO.getIdTipoCuarto());
            List<CuartoDto> cuartosDisponibles = filtrarCuartosDisponibles(cuartos, cuartosDisponiblesDTO);

            log.info("Consulta de cuartos completada. Cuartos disponibles encontrados: {}", cuartosDisponibles.size());
            return RespuestaGeneralDto.builder()
                    .message("Se consultaron correctamente los cuartos")
                    .status(HttpStatus.OK)
                    .data(cuartosDisponibles)
                    .build();

        } catch (Exception e) {
            log.error("Error al consultar cuartos", e);
            return RespuestaGeneralDto.builder()
                    .message("Hubo un error en la consulta de los cuartos")
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    /**
     * Obtiene la lista de cuartos según el tipo especificado.
     *
     * @param idTipoCuarto identificador del tipo de cuarto (0 para todos los tipos).
     * @return una lista de cuartos mapeados a DTO.
     */
    private List<CuartoDto> obtenerCuartosPorTipo(Integer idTipoCuarto) {
        if (idTipoCuarto == 0) {
            log.info("Consultando todos los cuartos sin filtro de tipo.");
            return cuartoMapper.listEntityTolistDto(cuartoRepository.findAll());
        }
        log.info("Consultando cuartos por tipo: {}", idTipoCuarto);
        return cuartoMapper.listEntityTolistDto(cuartoRepository.findAllByTipoCuartoEntityFk_Id(idTipoCuarto));
    }

    /**
     * Filtra los cuartos disponibles según el rango de fechas y su estado.
     *
     * @param cuartos               lista de cuartos a filtrar.
     * @param cuartosDisponiblesDTO DTO con los criterios de rango de fechas.
     * @return una lista de cuartos disponibles.
     */
    private List<CuartoDto> filtrarCuartosDisponibles(List<CuartoDto> cuartos, CuartosDisponiblesDTO cuartosDisponiblesDTO) {
        LocalDate fechaInicio = cuartosDisponiblesDTO.getFechaInicioReserva().toLocalDate();
        LocalDate fechaFinal = cuartosDisponiblesDTO.getFechaFinReserva().toLocalDate();

        log.info("Filtrando cuartos disponibles entre {} y {}", fechaInicio, fechaFinal);

        return cuartos.stream()
                .filter(cuarto -> esCuartoDisponible(cuarto, fechaInicio, fechaFinal))
                .collect(Collectors.toList());
    }

    /**
     * Verifica si un cuarto está disponible según el rango de fechas y su estado.
     *
     * @param cuarto       el cuarto a verificar.
     * @param fechaInicio  fecha de inicio del rango.
     * @param fechaFinal   fecha de fin del rango.
     * @return {@code true} si el cuarto está disponible; de lo contrario, {@code false}.
     */
    private boolean esCuartoDisponible(CuartoDto cuarto, LocalDate fechaInicio, LocalDate fechaFinal) {
        boolean estaReservado = reservaRepository.existsReserva(cuarto.getCodigoCuarto(), fechaInicio, fechaFinal);
        boolean estaDisponible = cuarto.getEstadoCuartoDtoFk().getId() == 2; // Estado 2 indica disponible
        return !estaReservado && estaDisponible;
    }
}
