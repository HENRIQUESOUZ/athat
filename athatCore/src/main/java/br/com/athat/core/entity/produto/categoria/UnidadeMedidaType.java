package br.com.athat.core.entity.produto.categoria;

public enum UnidadeMedidaType {

	UNIDADE("Unidade"),
	HORA("Hora"),
	METRO("Metro"),
	PACOTE("Pacote"),
	LOTE("Lote"),
	;
	
	private String descricao;
	
	private UnidadeMedidaType(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}
