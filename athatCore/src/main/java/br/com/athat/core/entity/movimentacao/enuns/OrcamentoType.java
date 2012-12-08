package br.com.athat.core.entity.movimentacao.enuns;

public enum OrcamentoType {
	
	ORCAMENTO("Orçamento"),
	LEVANTAMENTO("Levantamento");
	
	private String descricao;
	
	private OrcamentoType(String descricao) {
		this.descricao = descricao;
	}
		
	public String getDescricao() {
		return descricao;
	}

}
