package br.com.fiap.cadastroaluno.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.cadastroaluno.domain.Aluno;
import br.com.fiap.cadastroaluno.pojo.AlunoPojo;
import br.com.fiap.cadastroaluno.pojo.CreateAlunoPojo;
import br.com.fiap.cadastroaluno.repository.AlunoRepository;
import br.com.fiap.cadastroaluno.service.AlunoService;

/**
 * AlunoServiceImpl
 */
@Service
public class AlunoServiceImpl implements AlunoService {

    private final AlunoRepository repository;

    public AlunoServiceImpl(AlunoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<AlunoPojo> getAll() {
        List<Aluno> alunos = repository.findAll();

        return alunos.stream()
                .map(AlunoPojo::new)
                .collect(Collectors.toList());
    }
     
    @Override
    public AlunoPojo findById(long id) {
        Aluno aluno = getAlunoById(id);
        return new AlunoPojo(aluno);
    }

    @Override
    public AlunoPojo create(CreateAlunoPojo alunoPojo) {
        Aluno aluno = new Aluno(alunoPojo);
        Aluno alunoSaved = repository.save(aluno);
        return new AlunoPojo(alunoSaved);
    }

    @Override
    public AlunoPojo update(Long id, CreateAlunoPojo alunoPojo) {
        Aluno aluno = getAlunoById(id);

        aluno.setNome(alunoPojo.getNome());
        aluno.setSobrenome(alunoPojo.getSobrenome());
        aluno.setCpf(alunoPojo.getCpf());

        Aluno updatedAluno = repository.save(aluno);
        return new AlunoPojo(updatedAluno);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private Aluno getAlunoById(long id) {
        return repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}