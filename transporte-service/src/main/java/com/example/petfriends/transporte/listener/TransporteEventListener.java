package com.example.petfriends.transporte.listener;

import com.example.petfriends.transporte.event.PedidoDespachadoParaTransporteEvent;
import com.example.petfriends.transporte.model.EnderecoDestino;
import com.example.petfriends.transporte.model.OrdemTransporte;
import com.example.petfriends.transporte.repository.IOrdemTransporteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransporteEventListener {

    private final IOrdemTransporteRepository repository;

    @KafkaListener(
            topics = "pedido-despachado-transporte",
            groupId = "transporte-group"
    )
    public void processarDespacho(PedidoDespachadoParaTransporteEvent event) {
        log.info("Evento recebido do Almoxarifado: pedidoId={}", event.getPedidoId());

        EnderecoDestino endereco = new EnderecoDestino(
                "Rua Exemplo", "123", "",
                "Centro", "Rio de Janeiro", "RJ", "20000-000"
        );

        OrdemTransporte ordem = new OrdemTransporte(event.getPedidoId(), endereco);
        repository.save(ordem);

        log.info("Ordem de transporte criada: pedidoId={}, rastreio={}, previsão={}",
                ordem.getPedidoId(), ordem.getCodigoRastreio(), ordem.getDataPrevisaoEntrega());
    }
}