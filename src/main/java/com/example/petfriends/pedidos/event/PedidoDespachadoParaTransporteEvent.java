package com.example.petfriends.pedidos.event;

import com.example.petfriends.pedidos.dto.ItemPedidoDTO;
import com.example.petfriends.transporte.model.EnderecoDestino;

import java.util.List;

public class PedidoDespachadoParaTransporteEvent {
    private Long pedidoId;
    private EnderecoDestino endereco;
    private List<ItemPedidoDTO> itens;


}
