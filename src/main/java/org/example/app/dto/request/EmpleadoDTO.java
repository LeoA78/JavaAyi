package org.example.app.dto.request;

import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmpleadoDTO extends PersonaDTO{
    private String legajo;
    private String cargo;
}
