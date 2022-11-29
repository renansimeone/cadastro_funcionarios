package com.java.cadastro.dto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.java.cadastro.models.Pessoa;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class ProfissaoDTO {
    private Integer id_profissao;
    private String nome;
    private String descricao;
    @JsonIgnore
    private List<Pessoa> pessoas_list = new ArrayList<>();
}
