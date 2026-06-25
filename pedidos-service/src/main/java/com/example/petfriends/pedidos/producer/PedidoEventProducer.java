package com.example.petfriends.pedidos.producer;

import com.example.petfriends.pedidos.event.PedidoEnviadoParaAlmoxarifadoEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PedidoEventProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void publicarParaAlmoxarifado(PedidoEnviadoParaAlmoxarifadoEvent event) {
        log.info("Publicando evento para Almoxarifado: pedidoId={}", event.getPedidoId());
        kafkaTemplate.send("pedido-enviado-almoxarifado", event.getPedidoId().toString(), event);
    }
}