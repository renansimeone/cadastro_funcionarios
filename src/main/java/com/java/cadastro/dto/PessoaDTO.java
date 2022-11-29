package com.java.cadastro.dto;

import com.java.cadastro.models.Avaliacao;
import com.java.cadastro.models.Endereco;
import com.java.cadastro.models.Profile;
import com.java.cadastro.models.Profissao;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PessoaDTO {
    private Integer id;
    private String nome;
    private String email;
    private Integer idade;
    private String telefone;
    private boolean ativo;
    private Endereco endereco;
    private Profile profile;
    private List<Profissao> profissao_list = new ArrayList<>();
    private List<Avaliacao> avaliacao_list = new ArrayList<>();
}
