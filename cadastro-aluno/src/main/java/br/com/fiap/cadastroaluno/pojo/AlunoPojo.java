package br.com.fiap.cadastroaluno.pojo;

import br.com.fiap.cadastroaluno.domain.Aluno;
import io.swagger.annotations.ApiModelProperty;

public class AlunoPojo {

    @ApiModelProperty(value="Id do aluno", readOnly = true)
    private long id;
    @ApiModelProperty(value = "Nome do aluno", required = true, allowEmptyValue = false, dataType = "texto")
    private String nome;
    @ApiModelProperty(value = "Sobrenome do aluno", required = true, allowEmptyValue = false, dataType = "texto")
    private String sobrenome;
    @ApiModelProperty(value = "CPF do aluno", required = true, allowEmptyValue = false, dataType = "texto")
    private String cpf;
    
    public AlunoPojo(Aluno aluno) {
        this.id = aluno.getId();
        this.nome = aluno.getNome();
        this.sobrenome = aluno.getSobrenome();
        this.cpf = aluno.getCpf();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}