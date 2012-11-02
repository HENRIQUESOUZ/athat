package br.com.athat.core.entity.movimentacao.compra;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.athat.core.entity.conta.ContaAPagar;
import br.com.athat.core.entity.movimentacao.Movimentacao;
import br.com.athat.core.entity.pessoa.fornecedor.Fornecedor;

@Entity

public class Compra extends Movimentacao {

	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false , length=100)
	private String notaFiscal;
	
	@Temporal(TemporalType.DATE)
	private Date dataEmissaoNF;	
	
	@Temporal(TemporalType.DATE)
	private Date previsaoEntrega;
	
	@ManyToOne(optional = false)
	private Fornecedor fornecedor;
	
	@OneToOne
	private ContaAPagar contaAPagar;

	public String getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(String notaFiscal) {
		this.notaFiscal = notaFiscal;
	}

	public Date getDataEmissaoNF() {
		return dataEmissaoNF;
	}

	public void setDataEmissaoNF(Date dataEmissaoNF) {
		this.dataEmissaoNF = dataEmissaoNF;
	}

	public Date getPrevisaoEntrega() {
		return previsaoEntrega;
	}

	public void setPrevisaoEntrega(Date previsaoEntrega) {
		this.previsaoEntrega = previsaoEntrega;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public ContaAPagar getContaAPagar() {
		return contaAPagar;
	}

	public void setContaAPagar(ContaAPagar contaAPagar) {
		this.contaAPagar = contaAPagar;
	}
	

}
