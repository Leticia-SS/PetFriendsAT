package com.example.petfriends.pedidos.event;

import com.example.petfriends.pedidos.dto.ItemPedidoDTO;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
public class PedidoEnviadoParaAlmoxarifadoEvent {
    private final Long pedidoId;
    private final List<ItemPedidoDTO> itens;
    private final LocalDateTime ocorridoEm;


}
