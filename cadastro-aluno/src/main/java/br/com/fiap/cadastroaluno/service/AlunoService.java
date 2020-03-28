package br.com.fiap.cadastroaluno.service;

import java.util.List;

import br.com.fiap.cadastroaluno.pojo.AlunoPojo;
import br.com.fiap.cadastroaluno.pojo.CreateAlunoPojo;

/**
 * AlunoService
 */
public interface AlunoService {

     List<AlunoPojo> getAll();
     AlunoPojo findById(long id);
     AlunoPojo create(CreateAlunoPojo aluno);
     AlunoPojo update(Long id, CreateAlunoPojo alunoPojo);
     void delete(Long id);
}