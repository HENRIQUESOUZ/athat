package br.com.athat.core.cadastro.pessoa.entity.enuns;

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
