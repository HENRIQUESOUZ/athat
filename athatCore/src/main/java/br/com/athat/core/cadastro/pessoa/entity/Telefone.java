package br.com.athat.core.cadastro.pessoa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.athat.core.cadastro.pessoa.entity.enuns.EnderecoType;
import br.com.athat.core.entity.AbstractEntity;

@Entity
public class Telefone extends AbstractEntity{

	private static final long serialVersionUID = 1L;
	
	@Column(length = 20, nullable=false)
	private String numero;
	
	@Enumerated(EnumType.STRING)
	private EnderecoType enderecoType;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public EnderecoType getEnderecoType() {
		return enderecoType;
	}

	public void setEnderecoType(EnderecoType enderecoType) {
		this.enderecoType = enderecoType;
	}
}
