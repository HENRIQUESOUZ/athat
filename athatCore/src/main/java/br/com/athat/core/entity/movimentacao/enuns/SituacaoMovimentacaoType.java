package br.com.athat.core.entity.movimentacao.enuns;

public enum SituacaoMovimentacaoType {

	ABERTA("Aberta"),
    FECHADA("Finalizada"),
    CANCELADA("Cancelada");
    
    private String descricao;
	
	private SituacaoMovimentacaoType(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}

}	
