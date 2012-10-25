package br.com.athat.core.entity.conta.financeiro;

public enum FormaPagamentoType {
	CARTAO_DEBITO("Cartao Debito"),
	CARTAO_CREDITO("Cartao Credito"),
	CHEQUE("Cheque"),
	DINHEIRO("Dinheiro"),
	BANCARIO("Bancario");
	
	private String descricao;

	private FormaPagamentoType(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	
}
