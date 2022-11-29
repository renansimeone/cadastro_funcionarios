package com.java.cadastro.dto;


import lombok.Data;

@Data
public class AvaliacaoDTO {
    private Integer id_avaliacao;
    private Integer nota;
    private String avaliacao;
    private String cliente;
    private String dataservico;
    private Integer id_pessoa;
}
