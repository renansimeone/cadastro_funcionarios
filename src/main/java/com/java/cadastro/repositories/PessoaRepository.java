package com.java.cadastro.repositories;

import com.java.cadastro.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
    @Query("select p from Pessoa p where p.id = :id")
    Pessoa buscarPorId(@Param("id") Integer id);
}
