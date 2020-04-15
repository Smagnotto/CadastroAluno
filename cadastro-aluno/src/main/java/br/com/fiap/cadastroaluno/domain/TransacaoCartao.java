package br.com.fiap.cadastroaluno.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.fiap.cadastroaluno.pojo.CreateTransacaoCartaoPojo;

@Entity
@Table(name = "transacao_cartao")
public class TransacaoCartao {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "aluno_id")
	private Aluno aluno;
    
    @Column(name = "data", nullable = false)
    private Date data;

    @Column(name = "descricao", nullable = false, length = 50)
    private String descricao;

    @Column(name = "valor", nullable = false)
    private Double valor;

    
    
    public TransacaoCartao() {};
    
    public TransacaoCartao(CreateTransacaoCartaoPojo transacaoCartao) {
    	this.aluno = transacaoCartao.getAluno();
		this.data = transacaoCartao.getData();
		this.descricao = transacaoCartao.getDescricao();
		this.valor = transacaoCartao.getValor();
		
    }
    
	public TransacaoCartao(CreateTransacaoCartaoPojo transacaoCartao, long id) {
		this.id = id;
		this.aluno = transacaoCartao.getAluno();
		this.data = transacaoCartao.getData();
		this.descricao = transacaoCartao.getDescricao();
		this.valor = transacaoCartao.getValor();
	}
		
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	
	
	}