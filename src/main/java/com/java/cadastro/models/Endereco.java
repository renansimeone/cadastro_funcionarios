package com.java.cadastro.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "endereco")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Endereco {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    @Column(name = "cep", length = 9, nullable = false)
    private String cep;
    @Column(name = "numero", nullable = true)
    private Integer numero;
    @Column(name = "bairro", length = 20, nullable = false)
    private String bairro;
    @Column(name = "complemento", length = 50,nullable = true)
    private String complemento;
    @Column(name = "cidade", length = 20, nullable = false)
    private String cidade;
    @Column(name = "pais", length = 20, nullable = false)
    private String pais;
}
