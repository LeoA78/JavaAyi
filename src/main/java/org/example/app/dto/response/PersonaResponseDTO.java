package org.example.app.dto.response;

import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonaResponseDTO {
        private String nombre;
        private String apellido;
        private String dni;
        private Integer id;
}
