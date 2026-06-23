package com.example.petfriends.almoxarifado.listener;

import com.example.petfriends.almoxarifado.event.PedidoEnviadoParaAlmoxarifadoEvent;
import com.example.petfriends.almoxarifado.model.LocalizacaoFisica;
import com.example.petfriends.almoxarifado.model.ReservaEstoque;
import com.example.petfriends.almoxarifado.producer.AlmoxarifadoEventProducer;
import com.example.petfriends.almoxarifado.event.PedidoDespachadoParaTransporteEvent;
import com.example.petfriends.almoxarifado.repository.IReservaEstoqueRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AlmoxarifadoEventListener {
    private final IReservaEstoqueRepository repository;
    private final AlmoxarifadoEventProducer producer;

    @KafkaListener(
            topics = "pedido-enviado-almoxarifado",
            groupId = "almoxarifado-group"
    )
    public void processarEstoque(PedidoEnviadoParaAlmoxarifadoEvent event) {
        log.info("Evento recebido do Pedidos: pedidoId={}, produtoId={}, quantidade={}",
                event.getPedidoId(), event.getProdutoId(), event.getQuantidade());
        ReservaEstoque reserva = new ReservaEstoque(
                event.getPedidoId(),
                event.getProdutoId(),
                event.getQuantidade(),
                new LocalizacaoFisica("A", "3", "2")
        );

        reserva.separarItens();
        repository.save(reserva);

        log.info("Itens separados com sucesso. Despachando para transporte: pedidoId={}", event.getPedidoId());

        producer.publicarParaTransporte(new PedidoDespachadoParaTransporteEvent(
                event.getPedidoId(),
                event.getProdutoId(),
                event.getQuantidade()
        ));
    }
}