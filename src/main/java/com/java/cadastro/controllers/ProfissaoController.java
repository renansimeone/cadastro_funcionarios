package com.java.cadastro.controllers;

import com.java.cadastro.dto.ProfissaoDTO;
import com.java.cadastro.enums.MensagemEnum;
import com.java.cadastro.models.Profissao;
import com.java.cadastro.services.ProfissaoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/profissao")
public class ProfissaoController {
    @Autowired
    ProfissaoService profissaoService;

    ModelMapper modelMapper = new ModelMapper();

    @GetMapping("/listar")
    public List<ProfissaoDTO> listar(){
        List<Profissao> profissao_list = profissaoService.listar();
        List<ProfissaoDTO> profissaodto_list = new ArrayList<>();
        for(Profissao p: profissao_list){
            ProfissaoDTO profissaoDTO = modelMapper.map(p, ProfissaoDTO.class);
            profissaodto_list.add(profissaoDTO);
        }
        return profissaodto_list;
    }

    @GetMapping("/buscar/{id}")
    public ProfissaoDTO listar(@PathVariable Integer id){
        Profissao profissao = profissaoService.buscarPorId(id);
        return modelMapper.map(profissao, ProfissaoDTO.class);
    }

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public String cadastrar(@RequestBody ProfissaoDTO profissaoDTO){
        try{
            Profissao profissao = modelMapper.map(profissaoDTO, Profissao.class);
            profissaoService.salvar(profissao);
            return MensagemEnum.CADASTRO_CRIADO.value;
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @PostMapping("/alterar")
    @ResponseStatus(HttpStatus.CREATED)
    public String alterar(@RequestBody ProfissaoDTO profissaoDTO){
        try{
            Profissao profissao = modelMapper.map(profissaoDTO, Profissao.class);
            profissaoService.salvar(profissao);
            return MensagemEnum.CADASTRO_ALTERADO.value;
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @DeleteMapping("/deletar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deletar(@PathVariable Integer id){
        profissaoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
