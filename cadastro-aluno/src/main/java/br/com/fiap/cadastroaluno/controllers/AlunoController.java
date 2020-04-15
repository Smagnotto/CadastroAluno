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

import br.com.fiap.cadastroaluno.pojo.AlunoPojo;
import br.com.fiap.cadastroaluno.pojo.CreateAlunoPojo;
import br.com.fiap.cadastroaluno.service.AlunoService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("alunos")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService service) {
        this.alunoService = service;
    }
    
    @ApiResponse(code = 200, message= "Retorna uma lista de alunos cadastrados")
    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<AlunoPojo> getAll() {
        return alunoService.getAll();
    }

    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Retorna o aluno cadastrado"),
        @ApiResponse(code = 404, message = "Id do aluno informado não existe")
    })
    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public AlunoPojo getById(@PathVariable Long id) {
        return alunoService.findById(id);
    }

    @ApiResponse(code = 200, message = "Retorna o aluno criado")
    @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public AlunoPojo create(@RequestBody @Valid CreateAlunoPojo alunoPojo) {
        return alunoService.create(alunoPojo);
    }

    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Retorna o aluno atualizado"),
        @ApiResponse(code = 404, message = "Id do aluno informado não existe")
    })
    @PutMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public AlunoPojo update(@PathVariable Long id, @RequestBody @Valid CreateAlunoPojo alunoPojo) {
        return alunoService.update(id, alunoPojo);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        alunoService.delete(id);
    }
}