package br.com.athat.core.cadastro.empresa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import br.com.athat.core.entity.AbstractEntity;

@Entity
public class Empresa extends AbstractEntity{
	private static final long serialVersionUID = 1L;

	private String nome;

    @Column(length = 200)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
