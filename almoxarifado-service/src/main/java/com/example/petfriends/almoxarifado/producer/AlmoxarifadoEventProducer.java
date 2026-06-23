package com.example.petfriends.almoxarifado.producer;

import com.example.petfriends.almoxarifado.event.PedidoDespachadoParaTransporteEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class AlmoxarifadoEventProducer {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void publicarParaTransporte(PedidoDespachadoParaTransporteEvent event) {
        log.info("Publicando evento para Transporte: pedidoId={}", event.getPedidoId());
        kafkaTemplate.send("pedido-despachado-transporte", event.getPedidoId().toString(), event);
    }
}