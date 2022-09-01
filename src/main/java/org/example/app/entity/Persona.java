package org.example.app.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Persona {
    protected Integer id;
    protected String nombre;
    protected String apellido;
    protected String direccion;
    protected Integer edad;

    public Persona(Integer id) {
        this.id = id;
    }

    public Persona(String nombre, String apellido, String direccion, Integer edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.edad = edad;
    }


}
