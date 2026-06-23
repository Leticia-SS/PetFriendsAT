package com.example.petfriends.almoxarifado.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoEnviadoParaAlmoxarifadoEvent {
    private Long pedidoId;
    private Long produtoId;
    private Integer quantidade;
}