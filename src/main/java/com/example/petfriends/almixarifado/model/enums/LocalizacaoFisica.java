package com.example.petfriends.almixarifado.model.enums;

import jakarta.persistence.Embeddable;

@Embeddable
public class LocalizacaoFisica {
    private String corredor;
    private String prateleira;
    private String posicao;

    public LocalizacaoFisica(String corredor, String prateleira, String posicao) {
        this.corredor = corredor;
        this.prateleira = prateleira;
        this.posicao = posicao;
    }

    protected LocalizacaoFisica() {

    }
}
