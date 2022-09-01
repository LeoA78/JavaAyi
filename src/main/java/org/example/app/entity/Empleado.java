package org.example.app.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Empleado extends Persona{
    private String legajo;
    private String cargo;

    public Empleado(Integer id, String nombre, String apellido, String direccion, Integer edad, String legajo, String cargo) {
        super(id, nombre, apellido, direccion, edad);
        this.legajo = legajo;
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "legajo='" + legajo + '\'' +
                ", cargo='" + cargo + '\'' +
                ", id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", direccion='" + direccion + '\'' +
                ", edad=" + edad +
                '}';
    }
}
