package br.com.athat.core.cadastro.pessoa.entity.enuns;

public enum EnderecoType {
	
	PRINCIPAL("Principal"),
	COBRANCA("Cobranca"),
	FINANCEIRO("Financeiro"),
	DIRETORIA("Diretoria"),
	ADMINISTRACAO("Administração");
	
	private String descricao;
	
	private EnderecoType(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}

}
