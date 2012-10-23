package br.com.athat.core.entity.produto;

public enum ProdutoType {
	
	MATERIAL("Material"),
	SERViCO("Serviço")
	;
	
	private String descricao;
	
	private ProdutoType(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
