package br.com.athat.core.entity.usuario;

public enum PerfilType {

	PERMISSAO("Permissão"),
	NEGACAO("Negação");
	
	private String descricao;
	
	private PerfilType(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}
