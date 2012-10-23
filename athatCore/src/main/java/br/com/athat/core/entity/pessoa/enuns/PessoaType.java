package br.com.athat.core.entity.pessoa.enuns;

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
