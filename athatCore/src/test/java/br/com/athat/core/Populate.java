package br.com.athat.core;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import br.com.athat.core.cadastro.empresa.entity.Empresa;
import br.com.athat.core.cadastro.pessoa.cliente.entity.Cliente;
import br.com.athat.core.cadastro.pessoa.entity.Endereco;
import br.com.athat.core.cadastro.pessoa.entity.Pessoa;
import br.com.athat.core.cadastro.pessoa.entity.Telefone;
import br.com.athat.core.cadastro.pessoa.entity.endereco.Cidade;
import br.com.athat.core.cadastro.pessoa.entity.endereco.EstadoType;
import br.com.athat.core.cadastro.pessoa.entity.enuns.EnderecoType;
import br.com.athat.core.cadastro.pessoa.entity.enuns.FornecedorType;
import br.com.athat.core.cadastro.pessoa.entity.enuns.LogradouroType;
import br.com.athat.core.cadastro.pessoa.entity.enuns.PessoaType;
import br.com.athat.core.cadastro.pessoa.fornecedor.entity.Fornecedor;
import br.com.athat.core.cadastro.pessoa.funcionario.entity.Funcionario;
import br.com.athat.core.cadastro.produto.categoria.entity.Categoria;
import br.com.athat.core.cadastro.produto.categoria.entity.IdentificacaoType;
import br.com.athat.core.cadastro.produto.categoria.entity.UnidadeMedidaType;
import br.com.athat.core.cadastro.produto.entity.Produto;
import br.com.athat.core.cadastro.produto.entity.ProdutoType;
import br.com.athat.core.cadastro.produto.estoque.entity.Estoque;
import br.com.athat.core.cadastro.produto.tabelaPreco.entity.TabelaPreco;

public class Populate {
	
	public static Empresa populateEmpresa(){
		Empresa empresa = new Empresa();
		empresa.setNome("Compustar");
		
		return empresa;
	}
    
	public static Cidade populateCidade(){
		Cidade cidade = new Cidade();
		cidade.setIbge("13213");
		cidade.setNome("Cianorte");
		cidade.setEstadoType(EstadoType.PR);
		cidade.setDataCadastro(new Date());
		
		return cidade;
	}
    
    public static Endereco populateEndereco(Cidade cidade){
        Endereco endereco = new Endereco();
        endereco.setCidade(new Cidade());
        endereco.setEnderecoType(EnderecoType.PRINCIPAL);
        endereco.setLogradouroType(LogradouroType.RUA);
        endereco.setBairro("Centro");
        endereco.setCep("87200000");
        endereco.setLogradouro("São Paulo");
        endereco.setNumero("12345");
        endereco.setCidade(cidade);
        
        return endereco;
    }
    
    public static Telefone populateTelefone(){
        Telefone telefone = new Telefone();
        telefone.setEnderecoType(EnderecoType.PRINCIPAL);
        telefone.setNumero("4499000983");
        
        return telefone;
    }
    
    public static Pessoa populatePessoa(Cidade cidade){
        Pessoa pessoa = new Pessoa();
        pessoa.setPessoaType(PessoaType.FISICA);
        pessoa.setTelefones(new ArrayList<Telefone>());
        pessoa.setEnderecos(new ArrayList<Endereco>());
        pessoa.setCpfCnpj("303.0394.4943");
        pessoa.setNomeRazao("Teste");
        pessoa.setDataCadastro(new Date());
        pessoa.getTelefones().add(populateTelefone());
        pessoa.getEnderecos().add(populateEndereco(cidade));
        
        return pessoa;
    }
    
    public static Cliente populateCliente(Cidade cidade){
        Cliente cliente = new Cliente();
        cliente.setPessoa(populatePessoa(cidade));
        cliente.setDataAniversario(new Date());
        
        return cliente;
    }
    
    public static Categoria populateCategoria(){
    	Categoria categoria = new Categoria();
    	categoria.setDescricao("Hardware");
    	categoria.setUnidadeMedidaType(UnidadeMedidaType.UNIDADE);
    	categoria.setProdutoType(ProdutoType.MATERIAL);
    	categoria.setIdentificacaoType(IdentificacaoType.LOTE);
    	
    	return categoria;
    }
    
    public static Produto populateProduto(Categoria categoria){
    	Estoque estoque = new Estoque();
    	Produto produto = new Produto();
    	produto.setEstoque(estoque);
    	produto.setCategoria(categoria);
    	produto.setDescricao("Cabo de Rede");
    	estoque.setProduto(produto);
    	
    	return produto;
    }
    
    public static TabelaPreco populateTabelaPreco(){
    	TabelaPreco tabelaPreco = new TabelaPreco();
    	tabelaPreco.setNome("A vista");
    	tabelaPreco.setPorcentagem(BigDecimal.valueOf(50).setScale(2));
    	
    	return tabelaPreco;
    }

	public static Funcionario populateFuncionario(Cidade cidade) {
		Funcionario funcionario = new Funcionario();
		funcionario.setPessoa(populatePessoa(cidade));
		funcionario.setDataContratacao(new Date());
		
		return funcionario;
	}
	
	public static Fornecedor populateFornecedor(Cidade cidade) {
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setFornecedorType(FornecedorType.REDES);
		fornecedor.setPessoa(populatePessoa(cidade));
		
		return fornecedor;
	}
    
}
