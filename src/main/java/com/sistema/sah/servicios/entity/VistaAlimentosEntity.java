package com.sistema.sah.servicios.entity;

import com.sistema.sah.commons.entity.TipoAlimentoEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;

@Data
@Entity
@Table(name = "vista_alimentos", schema = "sah")
public class VistaAlimentosEntity {


    /**
     * Código único del alimento.
     * Este campo representa el identificador único del alimento en el sistema, almacenado en la columna `codigo_alimento`.
     */
    @Id
    @Column(name = "codigo_alimento")
    private String codigoAlimento;

    /**
     * Tiempo de preparación del alimento.
     * Este campo representa el tiempo necesario para preparar el alimento, almacenado como un valor de tipo {@link LocalTime}.
     */
    @Column(name = "tiempo_preparacion_alimento")
    private LocalTime tiempoPreparacionAlimento;

    /**
     * Nombre del alimento.
     * Este campo almacena el nombre del alimento, como "Ensalada", "Pizza", etc., con un máximo de 30 caracteres.
     */
    @Column(name = "nombre_alimento")
    private String nombreAlimento;

    /**
     * Detalles del alimento.
     * Este campo almacena información adicional sobre el alimento, como ingredientes o preparación especial.
     * El tamaño de la columna es indefinido (hasta el tamaño máximo de un {@link Integer}).
     */
    @Column(name = "detalle_alimento")
    private String detalleAlimento;

    /**
     * Código de la imagen asociada al alimento.
     * Este campo representa el código o referencia a la imagen visual del alimento.
     */
    @Column(name = "codigo_imagen")
    private String codigoImagen;

    /**
     * Tipo de alimento al que pertenece este alimento.
     * Este campo establece una relación de muchos a uno con la entidad {@link TipoAlimentoEntity}, que define el tipo
     * de alimento (por ejemplo, "Fruta", "Bebida", "Postre").
     */
    @Column(name = "tipo_alimento_fk")
    private Integer tipoAlimentoEntityFk;


}
