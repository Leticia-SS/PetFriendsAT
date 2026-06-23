package com.example.petfriends.transporte.listener;

import com.example.petfriends.pedidos.event.PedidoDespachadoParaTransporteEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static org.apache.kafka.common.requests.FetchMetadata.log;

@Slf4j
@Service
public class TransporteEventListener {

    @KafkaListener(
            topics = "pedido-despachado-transporte",
            groupId = "transporte-group",
            containerFactory = "transporteKafkaListenerContainerFactory"
    )
    public void processarDespacho(PedidoDespachadoParaTransporteEvent event) {
        log.info("Processando despacho para pedido: {}", event.getPedidoId());
    }
}