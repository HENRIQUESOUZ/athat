package br.com.athat.test.compra;

import br.com.athat.core.AbstractTest;
import br.com.athat.core.Populate;
import br.com.athat.core.PopulateBD;
import br.com.athat.core.entity.movimentacao.ItemProduto;
import br.com.athat.core.entity.movimentacao.compra.Compra;
import br.com.athat.core.entity.pessoa.endereco.Cidade;
import br.com.athat.core.entity.pessoa.fornecedor.Fornecedor;
import br.com.athat.core.entity.produto.Produto;
import br.com.athat.core.entity.produto.categoria.Categoria;
import br.com.athat.core.entity.produto.estoque.Estoque;
import br.com.athat.core.manager.movimentacao.compra.CompraManager;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import junit.framework.Assert;

public class CompraManagerTest extends AbstractTest{
    
    private Fornecedor fornecedor;
    private Cidade cidade;
    private Categoria categoria;
    private Produto produto1,produto2;
    private ItemProduto itemProduto1,itemProduto2;
    
    @Autowired
    private CompraManager compraManager;
    
    @Before
    public void before(){
        cidade = PopulateBD.populateCidade(entityManager);
        fornecedor = PopulateBD.populateFornecedor(entityManager, cidade);
        categoria = PopulateBD.populateCategoria(entityManager);
        produto1 = PopulateBD.populateProduto(entityManager, categoria);
        produto2 = PopulateBD.populateProduto(entityManager, categoria);
        itemProduto1 = PopulateBD.populateItemProduto(entityManager, produto1, 5, BigDecimal.valueOf(100));
        itemProduto2 = PopulateBD.populateItemProduto(entityManager, produto2, 5, BigDecimal.valueOf(100));
    }
    
//    @Test
//    public void salvar(){
//        List<ItemProduto> itensProduto = new ArrayList<ItemProduto>();
//        itensProduto.add(itemProduto1);
//        itensProduto.add(itemProduto2);
//        //Compra compra = Populate.populateCompra(fornecedor, itensProduto);
//        
//        compraManager.salvar(compra);
//        
//        Assert.assertEquals(1,find(Compra.class).size());
//        Assert.assertEquals(2,find(Produto.class).size());
//        Assert.assertEquals(2,find(ItemProduto.class).size());
//        Assert.assertEquals(2,find(Estoque.class).size());
//       
//        List<Produto> produtos = find(Produto.class);
//        
//        for(Produto p : produtos){
//            Assert.assertNull(p.getEstoque().getItemEstoqueList());
//            Assert.assertEquals(Integer.valueOf(5), p.getEstoque().getQuantidade());
//        }  
//    }
    
}
