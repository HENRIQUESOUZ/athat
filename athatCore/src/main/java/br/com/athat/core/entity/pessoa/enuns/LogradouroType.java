package br.com.athat.core.entity.pessoa.enuns;

public enum LogradouroType {
	
	RUA("Rua"),
	AVENIDA("Avenida"),
	ESTRADA("Estada");
	
	private String descricao;
	
	private LogradouroType(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
