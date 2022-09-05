package org.example.app.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class Cliente{
    private Integer idCliente;
    private Boolean vip;
    private Double deuda;
    private Integer idPersonaCliente;

    public Cliente(Boolean vip, Double deuda, Integer idPersonaCliente) {
        this.vip = vip;
        this.deuda = deuda;
        this.idPersonaCliente = idPersonaCliente;
    }

}


