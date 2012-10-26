package br.com.athat.core.entity.empresa;

import javax.persistence.Column;
import javax.persistence.Entity;

import br.com.athat.core.entity.AbstractEntity;

@Entity
public class Empresa extends AbstractEntity{
	private static final long serialVersionUID = 1L;

	@Column(length = 200, nullable = false)
	private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
