package com.example.petfriends.pedidos.model;

import com.example.petfriends.pedidos.model.enums.StatusPedidoEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "pedidos")
@Getter
@NoArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long produtoId;

    @Column(nullable = false)
    private Integer quantidade;

    @Enumerated(EnumType.STRING)
    private StatusPedidoEnum status;

    private LocalDateTime criadoEm;

    public Pedido(Long produtoId, Integer quantidade) {
        this.produtoId = produtoId;
        this.quantidade = quantidade;
        this.status = StatusPedidoEnum.NOVO;
        this.criadoEm = LocalDateTime.now();
    }

    public void fechar() {
        this.status = StatusPedidoEnum.FECHADO;
    }
}