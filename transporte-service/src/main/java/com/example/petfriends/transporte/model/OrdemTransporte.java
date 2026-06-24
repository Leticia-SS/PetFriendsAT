package com.example.petfriends.transporte.model;

import com.example.petfriends.transporte.model.enums.StatusEntregaEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "ordem_transporte")
@Getter
@NoArgsConstructor
public class OrdemTransporte {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private Long pedidoId;
    @Column(nullable = false, unique = true)
    private String codigoRastreio;
    @Enumerated(EnumType.STRING)
    private StatusEntregaEnum status;
    @Embedded
    private EnderecoDestino endereco;
    private LocalDateTime dataPrevisaoEntrega;

    public OrdemTransporte(Long pedidoId, EnderecoDestino endereco) {
        this.pedidoId = pedidoId;
        this.endereco = endereco;
        this.codigoRastreio = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        this.status = StatusEntregaEnum.AGUARDANDO_RETIRADA;
        this.dataPrevisaoEntrega = LocalDateTime.now().plusDays(7);
    }

    public void iniciarTransito() {
        this.status = StatusEntregaEnum.EM_TRANSITO;
    }

    public void confirmarEntrega() {
        this.status = StatusEntregaEnum.ENTREGUE;
    }

    public void registrarDevolucao() {
        this.status = StatusEntregaEnum.DEVOLVIDO;
    }
}