package org.example.app.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Empleado{
    private Integer id;
    private String legajo;
    private String cargo;
    private Integer idPersona;


    public Empleado(String legajo, String cargo, Integer idPersona) {
        this.legajo = legajo;
        this.cargo = cargo;
        this.idPersona = idPersona;
    }

}
