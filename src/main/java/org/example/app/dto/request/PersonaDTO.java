package org.example.app.dto.request;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonaDTO {
        private String nombre;
        private String apellido;
        private Integer id;
        private Integer edad;
        private String direccion;
       /* private List<ClienteDTO> clienteDTO;*/
}
