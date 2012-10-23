package br.com.athat.core.entity.produto.categoria;

public enum IdentificacaoType {
	
	LOTE("Lote"),
	SERIAL("Serial"),
	SEMIDENTIFICACAO("Sem Identificação"),
	;
	
	private String descricao;
	
	private IdentificacaoType(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}

}
