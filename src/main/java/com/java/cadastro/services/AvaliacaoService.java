package com.java.cadastro.services;

import com.java.cadastro.models.Avaliacao;
import com.java.cadastro.repositories.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoService {
    @Autowired
    AvaliacaoRepository avaliacaoRepository;
    public List<Avaliacao> listar(){
        return avaliacaoRepository.findAll();
    }

    public void salvar(Avaliacao avaliacao)throws Exception{
        avaliacaoRepository.save(avaliacao);
    }

    public void deletar(Integer id){
        avaliacaoRepository.deleteById(id);
    }

    public Avaliacao buscarPorId(Integer id){
        return avaliacaoRepository.buscarPorId(id);
    }
}
