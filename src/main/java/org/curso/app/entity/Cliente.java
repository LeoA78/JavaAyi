package org.curso.app.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter

@Entity
@Table (name = "clientes")
public class Cliente {

    @Id //Marcamos que es la llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Este sería el auto increment
    private Long id;

    @Column (name="nombre", nullable = false, length = 25)
    private String nombre;

    @Column (name="apellido", nullable = false, length = 25)
    private String apellido;

    @Column (name="forma_pago", nullable = false, length = 15)
    private String formaPago;

    @Column (name= "fecha_creacion", nullable = false) //nullable = false: para que no pueda ser nulo.
    private LocalDate fechaCreacion;

    public Cliente(String nombre, String apellido, String formaPago, LocalDate fechaCreacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.formaPago = formaPago;
        this.fechaCreacion = fechaCreacion;
    }

}
