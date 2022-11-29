package com.java.cadastro.services;


import com.java.cadastro.models.Profissao;
import com.java.cadastro.repositories.ProfissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfissaoService {
    @Autowired
    ProfissaoRepository profissaoRepository;

    public List<Profissao> listar(){
        return profissaoRepository.findAll();
    }

    public void salvar(Profissao profissao)throws Exception{
        profissaoRepository.save(profissao);
    }

    public void deletar(Integer id){
        profissaoRepository.deleteById(id);
    }

    public Profissao buscarPorId(Integer id){
        return profissaoRepository.buscarPorId(id);
    }
}
