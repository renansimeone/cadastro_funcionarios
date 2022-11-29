package com.java.cadastro.repositories;

import com.java.cadastro.models.Avaliacao;
import com.java.cadastro.models.Profissao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Integer> {
    @Query("select p from Avaliacao p where p.id_avaliacao = :id")
    Avaliacao buscarPorId(@Param("id") Integer id);
}
