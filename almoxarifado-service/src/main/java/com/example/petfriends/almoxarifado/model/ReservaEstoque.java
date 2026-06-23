package com.example.petfriends.almoxarifado.model;

import com.example.petfriends.almoxarifado.model.enums.StatusReservaEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reserva_estoque")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReservaEstoque {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private Long pedidoId;
    private Long produtoId;
    private Integer quantidade;
    @Enumerated(EnumType.STRING)
    private StatusReservaEnum status;
    @Embedded
    private LocalizacaoFisica localizacao;

    public ReservaEstoque(Long pedidoId, Long produtoId, Integer quantidade, LocalizacaoFisica localizacao) {
        this.pedidoId = pedidoId;
        this.produtoId = produtoId;
        this.quantidade = quantidade;
        this.localizacao = localizacao;
        this.status = StatusReservaEnum.RESERVADO;
    }

    public void separarItens() {
        if (this.status != StatusReservaEnum.RESERVADO) {
            throw new IllegalStateException("Só é possível separar itens com status RESERVADO");
        }
        this.status = StatusReservaEnum.SEPARADO;
    }

    public void expedir() {
        if (this.status != StatusReservaEnum.SEPARADO) {
            throw new IllegalStateException("Só é possível expedir itens com status SEPARADO");
        }
        this.status = StatusReservaEnum.EXPEDIDO;
    }
}