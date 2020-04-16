package br.com.fiap.cadastroaluno.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.cadastroaluno.domain.TransacaoCartao;

public interface TransacaoCartaoRepository extends JpaRepository<TransacaoCartao, Long> {    
	List<TransacaoCartao> findByidAlunoOrderByDataDesc(long idAluno);	
}