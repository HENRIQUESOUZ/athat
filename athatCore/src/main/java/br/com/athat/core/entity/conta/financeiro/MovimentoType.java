package br.com.athat.core.entity.conta.financeiro;

public enum MovimentoType {
	CREDITO("Credito"), DEBITO("Debito");

	private String descricao;

	private MovimentoType(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
