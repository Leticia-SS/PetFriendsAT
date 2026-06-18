package com.example.petfriends.events;

import com.example.petfriends.events.dto.ItemPedidoDTO;
import com.example.petfriends.transporte.model.EnderecoDestino;

import java.util.List;

public class PedidoDespachadoParaTransporteEvent {
    private Long pedidoId;
    private EnderecoDestino endereco;
    private List<ItemPedidoDTO> itens;


}
