package org.example.app.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Empleado extends Persona{
    private String legajo;
    private String cargo;

    public Empleado(String nombre, String apellido, String dni, String legajo, String cargo) {
        super(nombre, apellido, dni);
        this.legajo = legajo;
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "legajo='" + legajo + '\'' +
                ", cargo='" + cargo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }
}
