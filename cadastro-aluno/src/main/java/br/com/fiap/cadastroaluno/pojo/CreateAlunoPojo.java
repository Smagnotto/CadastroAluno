package br.com.fiap.cadastroaluno.pojo;

import io.swagger.annotations.ApiModelProperty;

/**
 * CreateAlunoPojo
 */
public class CreateAlunoPojo {

    @ApiModelProperty(value = "Nome do aluno.", required = true, allowEmptyValue = false, dataType = "texto")
    private String nome;
    @ApiModelProperty(value = "Sobrenome do aluno.", required = true, allowEmptyValue = false, dataType = "texto")
    private String sobrenome;
    @ApiModelProperty(value = "CPF do aluno ex.: 12345678901", required = true, allowEmptyValue = false, dataType = "texto")
    private String cpf;
    
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
}