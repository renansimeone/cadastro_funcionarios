package com.java.cadastro.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "avaliacao")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Avaliacao {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id_avaliacao;
    @Column(name = "nota", nullable = false)
    private Integer nota;
    @Column(name = "avaliacao", length = 300, nullable = false)
    private String avaliacao;
    @Column(name = "cliente", length = 50, nullable = false)
    private String cliente;
    @Column(name = "dataservico", length = 10, nullable = false)
    private String dataservico;
    @Column(name = "id_pessoa", nullable = false)
    private Integer id_pessoa;
}
