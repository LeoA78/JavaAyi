package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long idCliente;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 50)
    private String apellido;

    @Column(name = "forma_pago", nullable = false, length = 15)
    private String formaPago;

    @Embedded
    private Auditoria audit = new Auditoria();

    //cascade = CascadeType.ALL - Las acciones que afecten a Cliente tambien afectan a la tabla intermedia
    //orphanRemoval = true - En caso de borrar también borra en la tabla intermedia para que no queden datos huerfanos
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinTable(name = "tbl_clientes_direcciones", joinColumns = @JoinColumn(name="id_cliente"),
            inverseJoinColumns = @JoinColumn(name = "id_direccion")
            ,uniqueConstraints = @UniqueConstraint(columnNames={"id_direccion"}))
    //uniqueConstraints = @UniqueConstraint(columnNames={"id_direccion"}) - Hace que no repita la clave en la tabla intermedia
    private List<Direccion> direcciones;

    public Cliente(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }
}
