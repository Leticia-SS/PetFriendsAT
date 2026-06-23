package com.example.petfriends.pedidos.controller;

import com.example.petfriends.pedidos.producer.PedidoEventProducer;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
@AllArgsConstructor
public class PedidoController {
    private final PedidoEventProducer producer;

    public PedidoController(PedidoEventProducer producer) {
        this.producer = producer;
    }
}