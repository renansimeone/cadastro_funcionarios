package com.java.cadastro.controllers;

import com.java.cadastro.dto.PessoaDTO;
import com.java.cadastro.enums.MensagemEnum;
import com.java.cadastro.models.Pessoa;
import com.java.cadastro.services.PessoaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cadastro")
public class PessoaController {
    @Autowired
    PessoaService pessoaService;

    ModelMapper modelMapper = new ModelMapper();

    @GetMapping("/listar")
    public List<PessoaDTO> listar(){
        List<Pessoa> pessoas = pessoaService.listarTodos();
        List<PessoaDTO> pessoasDTO = new ArrayList<>();
        for(Pessoa p: pessoas){
            PessoaDTO pessoaDTO = modelMapper.map(p, PessoaDTO.class);
            pessoasDTO.add(pessoaDTO);
        }
        return pessoasDTO;
    }

    @GetMapping("/buscar/{id}")
    public PessoaDTO buscar(@PathVariable Integer id){
        Pessoa pessoa = pessoaService.buscarPorId(id);
        return modelMapper.map(pessoa, PessoaDTO.class);
    }

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public String cadastrar(@RequestBody PessoaDTO pessoaDTO){
        try{
            Pessoa pessoa = modelMapper.map(pessoaDTO, Pessoa.class);
            pessoaService.salvar(pessoa);
            return MensagemEnum.CADASTRO_CRIADO.value;
        }catch (Exception e){
            return e.getMessage();
        }

    }

    @PostMapping("/alterar")
    @ResponseStatus(HttpStatus.CREATED)
    public String alterar(@RequestBody PessoaDTO pessoaDTO){
        try{
            Pessoa pessoa = modelMapper.map(pessoaDTO, Pessoa.class);
            pessoaService.salvar(pessoa);
            return MensagemEnum.CADASTRO_ALTERADO.value;
        }catch (Exception e){
            return e.getMessage();
        }

    }

    @DeleteMapping("/deletar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deletar(@PathVariable Integer id){
        pessoaService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
