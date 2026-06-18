package com.example.petfriends.events.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
public class ItemPedidoDTO {
    private final Long produtoId;
    private final Integer quantidade;

}
