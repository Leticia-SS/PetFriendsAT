package com.example.petfriends.almoxarifado.model;

import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.util.Objects;

@Embeddable
@Getter
public class LocalizacaoFisica {
    private String corredor;
    private String prateleira;
    private String posicao;

    public LocalizacaoFisica(String corredor, String prateleira, String posicao) {
        this.corredor = corredor;
        this.prateleira = prateleira;
        this.posicao = posicao;
    }

    protected LocalizacaoFisica() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LocalizacaoFisica that)) return false;
        return Objects.equals(corredor, that.corredor)
                && Objects.equals(prateleira, that.prateleira)
                && Objects.equals(posicao, that.posicao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(corredor, prateleira, posicao);
    }
}