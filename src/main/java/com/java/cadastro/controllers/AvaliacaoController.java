package com.java.cadastro.controllers;

import com.java.cadastro.dto.AvaliacaoDTO;
import com.java.cadastro.dto.ProfissaoDTO;
import com.java.cadastro.enums.MensagemEnum;
import com.java.cadastro.models.Avaliacao;
import com.java.cadastro.services.AvaliacaoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoController {
    @Autowired
    AvaliacaoService avaliacaoService;

    ModelMapper modelMapper = new ModelMapper();

    @GetMapping("/listar")
    public List<AvaliacaoDTO> listar(){
        List<Avaliacao> avaliacao_list = avaliacaoService.listar();
        List<AvaliacaoDTO> avaliacaodto_list = new ArrayList<>();
        for(Avaliacao a: avaliacao_list){
            AvaliacaoDTO avaliacaoDTO = modelMapper.map(a, AvaliacaoDTO.class);
            avaliacaodto_list.add(avaliacaoDTO);
        }
        return avaliacaodto_list;
    }

    @GetMapping("/buscar/{id}")
    public AvaliacaoDTO listar(@PathVariable Integer id){
        Avaliacao avaliacao = avaliacaoService.buscarPorId(id);
        return modelMapper.map(avaliacao, AvaliacaoDTO.class);
    }

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public String cadastrar(@RequestBody AvaliacaoDTO avaliacaoDTO){
        try{
            Avaliacao avaliacao = modelMapper.map(avaliacaoDTO, Avaliacao.class);
            avaliacaoService.salvar(avaliacao);
            return MensagemEnum.CADASTRO_CRIADO.value;
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @PostMapping("/alterar")
    @ResponseStatus(HttpStatus.CREATED)
    public String alterar(@RequestBody AvaliacaoDTO avaliacaoDTO){
        try{
            Avaliacao avaliacao = modelMapper.map(avaliacaoDTO, Avaliacao.class);
            avaliacaoService.salvar(avaliacao);
            return MensagemEnum.CADASTRO_ALTERADO.value;
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @DeleteMapping("/deletar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deletar(@PathVariable Integer id){
        avaliacaoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
