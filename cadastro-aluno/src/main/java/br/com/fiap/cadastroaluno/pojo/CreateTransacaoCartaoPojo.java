package br.com.fiap.cadastroaluno.pojo;

import java.util.Date;

import br.com.fiap.cadastroaluno.domain.Aluno;
import io.swagger.annotations.ApiModelProperty;

public class CreateTransacaoCartaoPojo {

    @ApiModelProperty(value = "Id do Aluno", required = true, allowEmptyValue = false, dataType = "aluno")
    private Aluno aluno;
    @ApiModelProperty(value = "Data da transacao.", required = true, allowEmptyValue = false, dataType = "data")
    private Date data;
    @ApiModelProperty(value = "Descricao da transacao.", required = true, allowEmptyValue = false, dataType = "texto")
    private String descricao;
    @ApiModelProperty(value = "Valor.", required = true, allowEmptyValue = false, dataType = "Double")
    private Double valor;
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