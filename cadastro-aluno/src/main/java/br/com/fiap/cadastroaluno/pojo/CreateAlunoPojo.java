package br.com.fiap.cadastroaluno.pojo;

import io.swagger.annotations.ApiModelProperty;

public class CreateAlunoPojo {

    @ApiModelProperty(value = "Nome do aluno.", required = true, allowEmptyValue = false, dataType = "texto")
    private String nome;
    @ApiModelProperty(value = "Id do aluno", required = true, allowEmptyValue = false, dataType = "long")
    private long idAluno;
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

	public long getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(long idAluno) {
		this.idAluno = idAluno;
	}


}