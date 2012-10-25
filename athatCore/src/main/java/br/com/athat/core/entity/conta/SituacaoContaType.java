package br.com.athat.core.entity.conta;

public enum SituacaoContaType {
	ABERTA("Aberta"),
    QUITADA("Quitada"),
    VENCIDA("Vencida"),
    CANCELADA("Cancelada");
    private String descricao;
	
	private SituacaoContaType(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
