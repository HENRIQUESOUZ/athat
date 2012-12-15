package br.com.athat.core.vo.compra;

import java.io.Serializable;
import java.util.Date;

import br.com.athat.core.entity.movimentacao.enuns.SituacaoEntradaType;
import br.com.athat.core.entity.movimentacao.enuns.SituacaoMovimentacaoType;
import br.com.athat.core.entity.pessoa.fornecedor.Fornecedor;
import br.com.athat.utils.validators.DateUtils;

public class CompraVO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	private String numeroNF;
	private Date dataInicioNF;
	private Date dataFimNF;
	private Date dataInicioCompra;
	private Date dataFimCompra;
	private Fornecedor fornecedor;
	private SituacaoEntradaType situacaoEntradaType;
	private SituacaoMovimentacaoType situacaoMovimentacaoType;
	
	public CompraVO() {
		dataInicioNF = DateUtils.obterDataMenosDias(new Date(), 30);
		dataFimNF = DateUtils.obterDataMaisDias(new Date(), 30);
		dataInicioCompra = DateUtils.obterDataMenosDias(new Date(), 30);
		dataFimCompra = DateUtils.obterDataMaisDias(new Date(), 30);
		fornecedor = new Fornecedor();
		situacaoEntradaType = null;
		situacaoMovimentacaoType = null;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNumeroNF() {
		return numeroNF;
	}
	
	public void setNumeroNF(String numeroNF) {
		this.numeroNF = numeroNF;
	}
	
	public Date getDataInicioNF() {
		return dataInicioNF;
	}
	
	public void setDataInicioNF(Date dataInicioNF) {
		this.dataInicioNF = dataInicioNF;
	}
	
	public Date getDataFimNF() {
		return dataFimNF;
	}
	
	public void setDataFimNF(Date dataFimNF) {
		this.dataFimNF = dataFimNF;
	}
	
	public Date getDataInicioCompra() {
		return dataInicioCompra;
	}
	
	public void setDataInicioCompra(Date dataInicioCompra) {
		this.dataInicioCompra = dataInicioCompra;
	}
	
	public Date getDataFimCompra() {
		return dataFimCompra;
	}
	
	public void setDataFimCompra(Date dataFimCompra) {
		this.dataFimCompra = dataFimCompra;
	}
	
	public SituacaoEntradaType getSituacaoEntradaType() {
		return situacaoEntradaType;
	}
	
	public SituacaoMovimentacaoType getSituacaoMovimentacaoType() {
		return situacaoMovimentacaoType;
	}
	
	public void setSituacaoEntradaType(SituacaoEntradaType situacaoEntradaType) {
		this.situacaoEntradaType = situacaoEntradaType;
	}
	
	public void setSituacaoMovimentacaoType(
			SituacaoMovimentacaoType situacaoMovimentacaoType) {
		this.situacaoMovimentacaoType = situacaoMovimentacaoType;
	}
	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
}
