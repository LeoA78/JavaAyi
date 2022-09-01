package org.example.app.dto.request;

import lombok.*;
import org.example.app.entity.Persona;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class ClienteDTO extends PersonaDTO {
    private Integer idCliente;
    private String vip;

}
