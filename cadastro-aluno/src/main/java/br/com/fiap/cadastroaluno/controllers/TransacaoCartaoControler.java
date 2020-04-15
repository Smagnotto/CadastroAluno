package br.com.fiap.cadastroaluno.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.cadastroaluno.pojo.CreateTransacaoCartaoPojo;
import br.com.fiap.cadastroaluno.pojo.TransacaoCartaoPojo;
import br.com.fiap.cadastroaluno.service.TransacaoCartaoService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("transacaocartoes")
public class TransacaoCartaoControler {

    private final TransacaoCartaoService service;
	
	public TransacaoCartaoControler(TransacaoCartaoService service) {
        this.service = service;
    }
    

    @ApiResponse(code = 200, message= "Retorna uma lista de transacoes do aluno")
    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<TransacaoCartaoPojo> getAll() {
        return service.getAll();
    }

    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Retorna transacao"),
        @ApiResponse(code = 404, message = "Id da transacao nao existe")
    })
    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public TransacaoCartaoPojo getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @ApiResponse(code = 200, message = "Retorna transacao criada")
    @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public TransacaoCartaoPojo create(@RequestBody @Valid CreateTransacaoCartaoPojo transacaoCartaoPojo) {
        return service.create(transacaoCartaoPojo);
    }

    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Retorna transacao atualizada"),
        @ApiResponse(code = 404, message = "Id da transacao nao existe")
    })
    @PutMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public TransacaoCartaoPojo update(@PathVariable Long id, @RequestBody @Valid CreateTransacaoCartaoPojo transacaoCartaoPojo) {
        return service.update(id, transacaoCartaoPojo);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}