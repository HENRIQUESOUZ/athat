package br.com.athat.core.entity.usuario;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

public enum PermissaoUsuarioType {
	
	ROLE_URL_PRINCIPAL("Pagina inicial", "/pages/principal.jsf"),
	
	ROLE_URL_CADASTRO_CATEGORIA("Cadastro categoria", "/pages/cadastro/cadastroCategoria.jsf"),
	ROLE_URL_CADASTRO_CIDADE("Cadastro cidade", "/pages/cadastro/cadastroCidade.jsf"),
	ROLE_URL_CADASTRO_CLIENTE("Cadastro cliente", "/pages/cadastro/cadastroCliente.jsf"),
	ROLE_URL_CADASTRO_EMPRESA("Cadastro empresa", "/pages/cadastro/cadastroEmpresa.jsf"),
	ROLE_URL_CADASTRO_FORNECEDOR("Cadastro fornecedor", "/pages/cadastro/cadastroFornecedor.jsf"),
	ROLE_URL_CADASTRO_FUNCIONARIO("Cadastro funcionario", "/pages/cadastro/cadastroFuncionario.jsf"),
	ROLE_URL_CADASTRO_PESSOA("Cadastro pessoa", "/pages/cadastro/cadastroPessoa.jsf"),
	ROLE_URL_CADASTRO_PRODUTO("Cadastro funcionario", "/pages/cadastro/cadastroProduto.jsf"),
	ROLE_URL_CADASTRO_TABELA_PRECO("Cadastro tabela preco", "/pages/cadastro/cadastroTabelaPreco.jsf"),
	ROLE_URL_CADASTRO_USUARIO("Cadastro usuario", "/pages/cadastro/cadastroUsuario.jsf"),
	
	ROLE_URL_LISTAGEM_CATEGORIA("Cadastro listagem categoria", "/pages/cadastro/listagemCategoria.jsf"),
	ROLE_URL_LISTAGEM_CIDADE("Cadastro listagem cidade", "/pages/cadastro/listagemCidade.jsf"),
	ROLE_URL_LISTAGEM_CLIENTE("Cadastro listagem cliente", "/pages/cadastro/listagemCliente.jsf"),
	ROLE_URL_LISTAGEM_EMPRESA("Cadastro listagem empresa", "/pages/cadastro/listagemEmpresa.jsf"),
	ROLE_URL_LISTAGEM_FORCENEDOR("Cadastro listagem fornecedor", "/pages/cadastro/listagemFornecedor.jsf"),
	ROLE_URL_LISTAGEM_FUNCIONARIO("Cadastro listagem funcioario", "/pages/cadastro/listagemFuncionario.jsf"),
	ROLE_URL_LISTAGEM_PRODUTO("Cadastro listagem produto", "/pages/cadastro/listagemProduto.jsf"),
	ROLE_URL_LISTAGEM_TABELA_PRECO("Cadastro listagem tabela preco", "/pages/cadastro/listagemTabelaPreco.jsf"),
	
	ROLE_URL_MOVIMENTACAO_COMPRA("Compra", "/pages/movimentacao/compra.jsf"),
	ROLE_URL_MOVIMENTACAO_ENTRADA("Entrada", "/pages/movimentacao/entrada.jsf")
	
	;

	private static final Map<String, PermissaoUsuarioType> uriMap;

    static {
        Builder<String, PermissaoUsuarioType> builder = ImmutableMap.builder();
        for (PermissaoUsuarioType permissao : values()) {
            if (permissao.uri != null) {
                builder.put(permissao.uri, permissao);
            }
        }
        uriMap = builder.build();
    }

    public static PermissaoUsuarioType fromUri(String uri) {
        return uriMap.get(uri);
    }
    private final String descricao;
    private final String uri;

    private PermissaoUsuarioType(String descricao, String uri) {
        this.descricao = descricao;
        this.uri = uri;
    }

    private PermissaoUsuarioType(String descricao) {
        this(descricao, null);
    }

    public String getDescricao() {
        return descricao;
    }

    public String getUri() {
        return uri;
    }
}
