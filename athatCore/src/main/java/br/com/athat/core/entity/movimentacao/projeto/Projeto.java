package br.com.athat.core.entity.movimentacao.projeto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import br.com.athat.core.entity.AbstractEntity;
import br.com.athat.core.entity.pessoa.cliente.Cliente;

@Entity
public class Projeto extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
	@Column(length=200, nullable = false)
	private String nome;
	
	private Date previsaoEntrega;
	
	@ManyToOne(optional = false)
	private Cliente cliente;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getPrevisaoEntrega() {
		return previsaoEntrega;
	}

	public void setPrevisaoEntrega(Date previsaoEntrega) {
		this.previsaoEntrega = previsaoEntrega;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
