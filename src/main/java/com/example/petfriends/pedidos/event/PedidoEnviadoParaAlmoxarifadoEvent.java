package com.example.petfriends.pedidos.event;

import com.example.petfriends.pedidos.dto.ItemPedidoDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PedidoEnviadoParaAlmoxarifadoEvent {
    private Long pedidoId;
    private List<ItemPedidoDTO> itens;
    private LocalDateTime ocorridoEm;

    public Long getPedidoId() {
        return pedidoId;
    }
}