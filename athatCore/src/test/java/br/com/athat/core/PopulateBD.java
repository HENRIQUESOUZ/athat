package br.com.athat.core;

import javax.persistence.EntityManager;

import br.com.athat.core.cadastro.empresa.entity.Empresa;
import br.com.athat.core.cadastro.pessoa.cliente.entity.Cliente;
import br.com.athat.core.cadastro.pessoa.entity.endereco.Cidade;
import br.com.athat.core.cadastro.pessoa.fornecedor.entity.Fornecedor;
import br.com.athat.core.cadastro.pessoa.funcionario.entity.Funcionario;
import br.com.athat.core.cadastro.produto.categoria.entity.Categoria;
import br.com.athat.core.cadastro.produto.entity.Produto;
import br.com.athat.core.cadastro.produto.tabelaPreco.entity.TabelaPreco;
import br.com.athat.core.movimentacao.ItemProduto;
import br.com.athat.core.movimentacao.compra.entity.Compra;
import br.com.athat.core.movimentacao.venda.entity.Venda;
import java.math.BigDecimal;
import java.util.List;

public class PopulateBD {
	
	public static Empresa populateEmpresa(EntityManager entityManager){
		Empresa empresa = Populate.populateEmpresa();
		entityManager.persist(empresa);
		
		return empresa;
	}
	
	public static Cidade populateCidade(EntityManager entityManager){
		Cidade cidade = Populate.populateCidade();
		entityManager.persist(cidade);
		
		return cidade;
	}
    
    public static Cliente populateCliente(EntityManager entityManager,Cidade cidade){
        Cliente cliente = Populate.populateCliente(cidade);
        entityManager.persist(cliente);
        
        return cliente;
    }
    
    public static Categoria populateCategoria(EntityManager entityManager){
    	Categoria categoria = Populate.populateCategoria();
    	entityManager.persist(categoria);
    	
    	return categoria;
    }
    
    public static Produto populateProduto(EntityManager entityManager,Categoria categoria){
    	Produto produto = Populate.populateProduto(categoria);
    	entityManager.persist(produto);
    	
    	return produto;
    }
    
    public static TabelaPreco populateTabelaPreco(EntityManager entityManager){
    	TabelaPreco tabelaPreco = new TabelaPreco();
    	entityManager.persist(tabelaPreco);
    	
    	return tabelaPreco;
    }

	public static Funcionario populateFuncionario(EntityManager entityManager,Cidade cidade) {
		Funcionario funcionario = Populate.populateFuncionario(cidade);
		entityManager.persist(funcionario);
		
		return funcionario;
	}
	
	public static Fornecedor populateFornecedor(EntityManager entityManager, Cidade cidade){
		Fornecedor fornecedor = Populate.populateFornecedor(cidade);
		entityManager.persist(fornecedor);
		
		return fornecedor;
	}
        
         public static Compra populateCompra(EntityManager entityManager,Fornecedor fornecedor,List<ItemProduto> produtos,BigDecimal valorTotal){
                Compra compra = Populate.populateCompra(fornecedor, produtos,valorTotal);
                entityManager.persist(compra);
                
                return compra;
         }
         
         public static Venda populateVenda(EntityManager entityManager,Cliente cliente,List<ItemProduto> produtos,BigDecimal valorTotal){
                Venda venda = Populate.populateVenda(cliente, produtos, valorTotal);
                entityManager.persist(venda);
                
                return venda;
                
         }
         
         public static ItemProduto populateItemProduto(EntityManager entityManager, Produto produto,int quantidade,BigDecimal valor){
                ItemProduto itemProduto = Populate.populateItemProduto(produto, quantidade, valor);
                entityManager.persist(itemProduto);
                
                return itemProduto;
         }
}
