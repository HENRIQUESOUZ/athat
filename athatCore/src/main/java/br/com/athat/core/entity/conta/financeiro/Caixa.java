package br.com.athat.core.entity.conta.financeiro;

import java.math.BigDecimal;

import javax.persistence.Entity;

import br.com.athat.core.entity.AbstractEntity;

@Entity
public class Caixa extends AbstractEntity {
	
	private static final long serialVersionUID = 1L;

	private BigDecimal entrada = BigDecimal.ZERO;
	
	private BigDecimal saida = BigDecimal.ZERO;
	
	private BigDecimal saldoDiario = BigDecimal.ZERO;
	
	private BigDecimal saldoAtual = BigDecimal.ZERO;
	
	public BigDecimal getEntrada() {
		return entrada;
	}
	public void setEntrada(BigDecimal entrada) {
		this.entrada = entrada;
	}
	public BigDecimal getSaida() {
		return saida;
	}
	public void setSaida(BigDecimal saida) {
		this.saida = saida;
	}
	public BigDecimal getSaldoDiario() {
		return saldoDiario;
	}
	public void setSaldoDiario(BigDecimal saldoDiario) {
		this.saldoDiario = saldoDiario;
	}
	public BigDecimal getSaldoAtual() {
		return saldoAtual;
	}
	public void setSaldoAtual(BigDecimal saldoAtual) {
		this.saldoAtual = saldoAtual;
	}
}
