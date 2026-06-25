package com.example.petfriends.pedidos.controller;

import com.example.petfriends.pedidos.model.Pedido;
import com.example.petfriends.pedidos.producer.PedidoEventProducer;
import com.example.petfriends.pedidos.repository.IPedidoRepository;
import com.example.petfriends.pedidos.dto.CriarPedidoRequest;
import com.example.petfriends.pedidos.event.PedidoEnviadoParaAlmoxarifadoEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final IPedidoRepository repository;
    private final PedidoEventProducer producer;

    @PostMapping
    public ResponseEntity<Pedido> criarPedido(@RequestBody CriarPedidoRequest request) {
        Pedido pedido = new Pedido(request.produtoId(), request.quantidade());
        pedido.fechar();
        repository.save(pedido);
        log.info("Pedido criado: id={}, produtoId={}", pedido.getId(), pedido.getProdutoId());

        producer.publicarParaAlmoxarifado(new PedidoEnviadoParaAlmoxarifadoEvent(
                pedido.getId(),
                pedido.getProdutoId(),
                pedido.getQuantidade()
        ));

        return ResponseEntity.ok(pedido);
    }

}


