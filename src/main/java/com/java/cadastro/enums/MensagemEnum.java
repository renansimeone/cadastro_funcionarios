package com.java.cadastro.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum MensagemEnum {
    CADASTRO_ALTERADO("Cadastro alterado com sucesso."),
    CADASTRO_DELETADO("Cadastro deletado com sucesso."),
    CADASTRO_CRIADO("Cadastro realizado com sucesso.");

    @Getter
    public String value;
}
