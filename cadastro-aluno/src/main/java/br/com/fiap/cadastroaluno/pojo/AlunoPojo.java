package br.com.fiap.cadastroaluno.pojo;

import br.com.fiap.cadastroaluno.domain.Aluno;
import io.swagger.annotations.ApiModelProperty;

public class AlunoPojo {

    @ApiModelProperty(value="Id do aluno", readOnly = true)
    private long id;
    @ApiModelProperty(value = "Nome do aluno", required = true, allowEmptyValue = false, dataType = "texto")
    private String nome;
    @ApiModelProperty(value = "Id Aluno", required = true, allowEmptyValue = false, dataType = "long")
    private long idAluno;
    
    public AlunoPojo(Aluno aluno) {
        this.id = aluno.getId();
        this.nome = aluno.getNome();
        this.idAluno = aluno.getIdAluno();
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
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