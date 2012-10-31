package br.com.athat.core.enuns;

public enum ContaType {
	
	CONTAS_PAGAR("Conta a Pagar"),
	CONTAS_RECEBER("Conta a Receber");
	
	private String descricao;

	private ContaType(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
