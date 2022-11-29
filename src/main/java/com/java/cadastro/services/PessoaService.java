package com.java.cadastro.services;


import com.java.cadastro.models.Pessoa;
import com.java.cadastro.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PessoaService {
    @Autowired
    PessoaRepository pessoaRepository;

    public List<Pessoa> listarTodos(){
        return pessoaRepository.findAll();
    }

    public void salvar(Pessoa pessoa)throws Exception{
        pessoaRepository.save(pessoa);
    }

    public void deletar(Integer id){
        pessoaRepository.deleteById(id);
    }

    public Pessoa buscarPorId(Integer id){
        return pessoaRepository.buscarPorId(id);
    }
}
