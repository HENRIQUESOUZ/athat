package br.com.athat.core.cadastro.pessoa.entity.enuns;

public enum PessoaType {
    
    FISICA("Física"),
    JURIDICA("Jurídica");
    
    private String descricao;
	
	private PessoaType(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
