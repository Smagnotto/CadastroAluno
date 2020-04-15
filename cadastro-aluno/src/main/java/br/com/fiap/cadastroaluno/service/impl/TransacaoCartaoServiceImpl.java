package br.com.fiap.cadastroaluno.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.cadastroaluno.domain.Aluno;
import br.com.fiap.cadastroaluno.domain.TransacaoCartao;
import br.com.fiap.cadastroaluno.pojo.AlunoPojo;
import br.com.fiap.cadastroaluno.pojo.CreateAlunoPojo;
import br.com.fiap.cadastroaluno.pojo.CreateTransacaoCartaoPojo;
import br.com.fiap.cadastroaluno.pojo.TransacaoCartaoPojo;
import br.com.fiap.cadastroaluno.repository.AlunoRepository;
import br.com.fiap.cadastroaluno.repository.TransacaoCartaoRepository;
import br.com.fiap.cadastroaluno.service.AlunoService;
import br.com.fiap.cadastroaluno.service.TransacaoCartaoService;

@Service
public class TransacaoCartaoServiceImpl implements TransacaoCartaoService {

    private final TransacaoCartaoRepository repository;

    public TransacaoCartaoServiceImpl(TransacaoCartaoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TransacaoCartaoPojo> getAll() {
        List<TransacaoCartao> transacaoCartao = repository.findAll();

        return transacaoCartao.stream()
                .map(TransacaoCartaoPojo::new)
                .collect(Collectors.toList());
    }
     
    @Override
    public TransacaoCartaoPojo findById(long id) {
    	TransacaoCartao transacaoCartao = getTransacaoCartaoById(id);
        return new TransacaoCartaoPojo(transacaoCartao);
    }

    @Override
    public TransacaoCartaoPojo create(CreateTransacaoCartaoPojo transacaoCartaoPojo) {
    	TransacaoCartao transacaoCartao = new TransacaoCartao(transacaoCartaoPojo);
    	TransacaoCartao transacaoCartaoSaved = repository.save(transacaoCartao);
        return new TransacaoCartaoPojo(transacaoCartaoSaved);
    }

    @Override
    public TransacaoCartaoPojo update(Long id, CreateTransacaoCartaoPojo transacaoCartaoPojo) {
    	TransacaoCartao transacaoCartao = getTransacaoCartaoById(id);
    	
    	transacaoCartao.setData(transacaoCartaoPojo.getData());
    	transacaoCartao.setDescricao(transacaoCartaoPojo.getDescricao());
    	transacaoCartao.setValor(transacaoCartaoPojo.getValor());
    	transacaoCartao.setAluno(transacaoCartaoPojo.getAluno());

        TransacaoCartao updatedTransacaoCartao = repository.save(transacaoCartao);
        return new TransacaoCartaoPojo(updatedTransacaoCartao);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private TransacaoCartao getTransacaoCartaoById(long id) {
        return repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}