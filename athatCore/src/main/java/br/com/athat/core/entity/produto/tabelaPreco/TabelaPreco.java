package br.com.athat.core.entity.produto.tabelaPreco;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.athat.core.entity.AbstractEntity;

@Entity
public class TabelaPreco extends AbstractEntity{

	private static final long serialVersionUID = 1L;
	
	@Column(length = 70 , nullable = false)
	private String nome; 
	
	private BigDecimal porcentagem;
	
	@Temporal(TemporalType.DATE)
	private Date dataInicio;
	
	@Temporal(TemporalType.DATE)
	private Date dataFim;
	
	private String observacao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPorcentagem() {
		return porcentagem;
	}

	public void setPorcentagem(BigDecimal porcentagem) {
		this.porcentagem = porcentagem;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
}
