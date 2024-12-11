package com.sistema.sah.servicios.entity;

import com.sistema.sah.commons.entity.TipoServicioEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "vista_servicios", schema = "sah")
public class VistaServiciosEntity {

    /**
     * Código único del servicio.
     * Este campo es la clave primaria de la entidad y representa el identificador único del servicio en la tabla `servicio`.
     * El valor se genera automáticamente mediante una secuencia en la base de datos.
     */
    @Id
    @Column(name = "codigo_servicio")
    private String codigoServicio;

    /**
     * Nombre del servicio.
     * Este campo almacena el nombre del servicio, como "Wi-Fi", "Desayuno", etc. Es un campo obligatorio.
     */
    @Column(name = "nombre_servicio")
    private String nombreServicio;

    /**
     * Valor del servicio.
     * Este campo almacena el costo asociado con el servicio. Es un campo obligatorio con precisión de 10 y escala de 2.
     */
    @Column(name = "valor_servicio")
    private BigDecimal valorServicio;

    /**
     * Código de la imagen del servicio.
     * Este campo almacena el código de la imagen asociada al servicio, para ser mostrado en la interfaz de usuario. Es un campo obligatorio.
     */
    @Column(name = "codigo_imagen_servicio")
    private String codigoImagenServicio;

    /**
     * Detalles del servicio.
     * Este campo almacena una descripción adicional del servicio. Este campo es opcional.
     */
    @Column(name = "detalle_servicio")
    private String detalleServicio;

    /**
     * Tipo de servicio.
     * Este campo establece una relación de muchos a uno con la entidad {@link TipoServicioEntity}, indicando el tipo de servicio
     * (por ejemplo, "Comida", "Transporte", "Entretenimiento").
     */
    @Column(name = "tipo_servicio_fk")
    private Integer tipoServicioEntityFk;

}
