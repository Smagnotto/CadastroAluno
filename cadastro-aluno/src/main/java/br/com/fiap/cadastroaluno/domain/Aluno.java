package br.com.fiap.cadastroaluno.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.fiap.cadastroaluno.pojo.CreateAlunoPojo;

@Entity
@Table(name = "aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "idAluno", nullable = false, length = 11)
    private long idAluno;
 	
    public Aluno() { }

    public Aluno(CreateAlunoPojo aluno) {
        this.nome = aluno.getNome();
        this.idAluno = aluno.getIdAluno();

    }

    public Aluno(CreateAlunoPojo aluno, Long id) {
        this.id  = id;
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