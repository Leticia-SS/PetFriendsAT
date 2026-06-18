package com.example.petfriends.kafka;

import com.example.petfriends.events.PedidoDespachadoParaTransporteEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static org.apache.kafka.common.requests.DeleteAclsResponse.log;

@Service
public class TransporteEventListener {
    @KafkaListener(topics = "pedido.transporte", groupId = "transporte-group")
    public void processarDespacho(PedidoDespachadoParaTransporteEvent event) {
        log.info("Processando despacho para pedido: {}", event.getPedidoId());
    }
}
