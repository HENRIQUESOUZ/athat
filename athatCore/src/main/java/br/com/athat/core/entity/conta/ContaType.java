package br.com.athat.core.entity.conta;

public enum ContaType {
	PAGAR("Pagar"), 
	RECEBER("Receber");
	private String descricao;

	private ContaType(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
