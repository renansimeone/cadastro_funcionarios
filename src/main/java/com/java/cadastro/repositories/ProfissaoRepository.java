package com.java.cadastro.repositories;

import com.java.cadastro.models.Profissao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfissaoRepository extends JpaRepository<Profissao, Integer> {
    @Query("select p from Profissao p where p.id_profissao = :id")
    Profissao buscarPorId(@Param("id") Integer id);
}
