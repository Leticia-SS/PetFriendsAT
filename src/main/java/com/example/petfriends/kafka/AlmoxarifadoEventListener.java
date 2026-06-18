package com.example.petfriends.kafka;

import com.example.petfriends.events.PedidoEnviadoParaAlmoxarifadoEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static org.apache.kafka.common.requests.DeleteAclsResponse.log;

@Service
public class AlmoxarifadoEventListener {
    @KafkaListener(topics = "pedido.almoxarifado", groupId = "almoxarifado-group")
    public void reservarEstoque(PedidoEnviadoParaAlmoxarifadoEvent event) {
        log.info("Reservando estoque para pedido: {}", event.getPedidoId());
    }
}
