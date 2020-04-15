package br.com.fiap.cadastroaluno.service;

import java.util.List;

import br.com.fiap.cadastroaluno.pojo.CreateTransacaoCartaoPojo;
import br.com.fiap.cadastroaluno.pojo.TransacaoCartaoPojo;

/**
 * AlunoService
 */
public interface TransacaoCartaoService {

     List<TransacaoCartaoPojo> getAll();
     TransacaoCartaoPojo findById(long id);
     TransacaoCartaoPojo create(CreateTransacaoCartaoPojo transacaoCartao);
     TransacaoCartaoPojo update(Long id, CreateTransacaoCartaoPojo transacaoCartaoPojo);
     void delete(Long id);
}