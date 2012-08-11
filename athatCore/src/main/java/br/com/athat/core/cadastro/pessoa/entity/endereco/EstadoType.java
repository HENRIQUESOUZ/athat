
package br.com.athat.core.cadastro.pessoa.entity.endereco;


public enum EstadoType {
    PR("Paraná"),
    SC("Santa Catarina"),
    RS("Rio Grande do Sul");
    
    private String descricao;

    private EstadoType(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
}