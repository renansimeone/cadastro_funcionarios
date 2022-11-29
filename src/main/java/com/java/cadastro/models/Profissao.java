package com.java.cadastro.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "profissao")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Profissao {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id_profissao;
    @Column(name = "nome", length = 50, unique = true)
    private String nome;
    @Column(name = "descricao", length = 300, nullable = false)
    private String descricao;
    @JsonIgnore
    @ManyToMany(mappedBy = "profissao_list")
    private List<Pessoa> pessoas_list = new ArrayList<>();


}
