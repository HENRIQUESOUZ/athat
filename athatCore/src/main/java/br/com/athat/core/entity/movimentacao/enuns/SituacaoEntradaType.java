package br.com.athat.core.entity.movimentacao.enuns;

public enum SituacaoEntradaType {
	
	AGUARDANDO("Aguardando"),
	EFETIVADO("Efetivado")
	;
	
	private String descricao;
		
	private SituacaoEntradaType(String descricao) {
		this.descricao = descricao;
	}
		
	public String getDescricao() {
		return descricao;
	}

}
