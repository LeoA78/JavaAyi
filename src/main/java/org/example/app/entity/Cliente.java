package org.example.app.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class Cliente extends Persona{
    private Integer idCliente;
    private String vip;
}
