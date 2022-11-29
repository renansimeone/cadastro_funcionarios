package com.java.cadastro.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pessoa")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pessoa {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    @Column(name = "email", length = 50, unique = true)
    private String email;
    @Column(name = "idade", nullable = false)
    private Integer idade;
    @Column(name = "telefone", length = 13, nullable = false)
    private String telefone;
    @Column(name = "ativo", nullable = false)
    private boolean ativo;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_profile")
    private Profile profile;
    @ManyToMany
    @JoinTable(name = "tb_pessoa_profissao", joinColumns = @JoinColumn(name = "pessoa_id"), inverseJoinColumns = @JoinColumn(name = "profissao_id"))
    private List<Profissao> profissao_list = new ArrayList<>();
    @OneToMany
    @JoinColumn(name = "id_pessoa")
    private List<Avaliacao> avaliacao_list = new ArrayList<>();
}
