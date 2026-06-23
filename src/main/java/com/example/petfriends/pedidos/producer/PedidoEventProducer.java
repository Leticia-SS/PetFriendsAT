package com.example.petfriends.pedidos.producer;

import com.example.petfriends.pedidos.event.PedidoEnviadoParaAlmoxarifadoEvent;
import com.example.petfriends.pedidos.event.PedidoDespachadoParaTransporteEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class PedidoEventProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public PedidoEventProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publicarPedidoEnviado(PedidoEnviadoParaAlmoxarifadoEvent event) {
        kafkaTemplate.send("pedido-enviado-almoxarifado", event);
    }

    public void publicarPedidoDespachado(PedidoDespachadoParaTransporteEvent event) {
        kafkaTemplate.send("pedido-despachado-transporte", event);
    }
}