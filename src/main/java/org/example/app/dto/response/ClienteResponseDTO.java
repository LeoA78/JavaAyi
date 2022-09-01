package org.example.app.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class ClienteResponseDTO{
    private Integer idCliente;
    private String vip;
    private PersonaResponseDTO personaResponseDTO;
}