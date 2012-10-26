package br.com.athat.core.entity.pessoa.enuns;

public enum FornecedorType {
    
    INFORMATICA("Informática"),
    REDES("Redes"),
    ELETRICA("Elétrica");
    
    private String descricao;
	
	private FornecedorType(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
    
}
