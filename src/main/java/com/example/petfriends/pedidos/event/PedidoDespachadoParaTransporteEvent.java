package com.example.petfriends.pedidos.event;

import com.example.petfriends.pedidos.dto.ItemPedidoDTO;
import com.example.petfriends.transporte.model.EnderecoDestino;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDespachadoParaTransporteEvent {
    private Long pedidoId;
    private EnderecoDestino endereco;
    private List<ItemPedidoDTO> itens;

    public Long getPedidoId() {
        return pedidoId;
    }
}