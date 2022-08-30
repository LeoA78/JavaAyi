package org.example.app.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Persona {
    protected String nombre;
    protected String apellido;
    protected String dni;
}
