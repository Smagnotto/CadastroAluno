package br.com.fiap.cadastroaluno.pojo;

import java.util.Date;

import br.com.fiap.cadastroaluno.domain.Aluno;
import io.swagger.annotations.ApiModelProperty;

public class CreateTransacaoCartaoPojo {

    @ApiModelProperty(value = "Id do Aluno", required = true, allowEmptyValue = false, dataType = "long")
    private Long idAluno;
    @ApiModelProperty(value = "Data da transacao.", required = true, allowEmptyValue = false, dataType = "data")
    private Date data;
    @ApiModelProperty(value = "Descricao da transacao.", required = true, allowEmptyValue = false, dataType = "texto")
    private String descricao;
    @ApiModelProperty(value = "Valor.", required = true, allowEmptyValue = false, dataType = "Double")
    private Double valor;
	
	public Long getIdAluno() {
		return idAluno;
	}
	public void setIdAluno(Long idAluno) {
		this.idAluno = idAluno;
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