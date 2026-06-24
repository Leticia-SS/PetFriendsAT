package com.example.petfriends.pedidos.dto;

public record CriarPedidoRequest(
        Long produtoId,
        Integer quantidade
) {}