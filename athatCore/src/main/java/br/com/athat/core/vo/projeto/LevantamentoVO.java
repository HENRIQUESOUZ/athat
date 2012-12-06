package br.com.athat.core.vo.projeto;

import java.io.Serializable;
import java.util.Date;

import br.com.athat.core.entity.movimentacao.enuns.SituacaoMovimentacaoType;
import br.com.athat.utils.validators.DateUtils;

public class LevantamentoVO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	private Date dataInicio;
	private Date dataFim;
	private SituacaoMovimentacaoType situacaoMovimentacaoType;
	
	public LevantamentoVO() {
		dataInicio = DateUtils.obterDataMenosDias(new Date(), 30);
		dataFim = DateUtils.obterDataMaisDias(new Date(), 30);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public SituacaoMovimentacaoType getSituacaoMovimentacaoType() {
		return situacaoMovimentacaoType;
	}

	public void setSituacaoMovimentacaoType(
			SituacaoMovimentacaoType situacaoMovimentacaoType) {
		this.situacaoMovimentacaoType = situacaoMovimentacaoType;
	}
}
