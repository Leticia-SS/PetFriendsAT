package com.example.petfriends.almoxarifado.listener;

import com.example.petfriends.pedidos.event.PedidoEnviadoParaAlmoxarifadoEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static org.apache.kafka.common.requests.DeleteAclsResponse.log;

@Slf4j
@Service
public class AlmoxarifadoEventListener {

    @KafkaListener(
            topics = "pedido-enviado-almoxarifado",
            groupId = "almoxarifado-group",
            containerFactory = "almoxarifadoKafkaListenerContainerFactory"
    )
    public void processarEstoque(PedidoEnviadoParaAlmoxarifadoEvent event) {
        log.info("Separando estoque para pedido: {}", event.getPedidoId());
    }
}