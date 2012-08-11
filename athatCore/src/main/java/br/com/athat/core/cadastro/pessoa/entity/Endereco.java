package br.com.athat.core.cadastro.pessoa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import br.com.athat.core.cadastro.pessoa.entity.endereco.Cidade;
import br.com.athat.core.cadastro.pessoa.entity.enuns.EnderecoType;
import br.com.athat.core.cadastro.pessoa.entity.enuns.LogradouroType;
import br.com.athat.core.entity.AbstractEntity;

@Entity
public class Endereco extends AbstractEntity{
	
	private static final long serialVersionUID = 1L;

	@Column(length = 70, nullable=false)
	private String logradouro;
	
	@Column(length = 70, nullable=false)
	private String bairro;
	
	@Column(length = 10, nullable=false)
	private String numero;
	
	@Column(length = 20, nullable=false)
	private String cep;
	
	@Column(length = 70)
	private String complemento;
	
	@ManyToOne(optional=false)
	private Cidade cidade;
	
	@Enumerated(EnumType.STRING)
	private LogradouroType logradouroType;
	
	@Enumerated(EnumType.STRING)
	private EnderecoType enderecoType;

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public LogradouroType getLogradouroType() {
		return logradouroType;
	}

	public void setLogradouroType(LogradouroType logradouroType) {
		this.logradouroType = logradouroType;
	}

	public EnderecoType getEnderecoType() {
		return enderecoType;
	}

	public void setEnderecoType(EnderecoType enderecoType) {
		this.enderecoType = enderecoType;
	}
	
	public Cidade getCidade() {
		return cidade;
	}
	
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
}
