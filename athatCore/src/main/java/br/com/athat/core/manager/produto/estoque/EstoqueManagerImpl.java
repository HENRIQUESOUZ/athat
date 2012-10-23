package br.com.athat.core.manager.produto.estoque;

import br.com.athat.core.entity.movimentacao.ItemProduto;
import br.com.athat.core.entity.produto.estoque.Estoque;
import br.com.athat.core.entity.produto.estoque.ItemEstoque;

import org.springframework.transaction.annotation.Transactional;
import br.com.athat.core.manager.AbstractManager;
import br.com.athat.utils.validators.ValidatorUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class EstoqueManagerImpl extends AbstractManager implements EstoqueManager {

	private static final long serialVersionUID = 1L;
        
        @Autowired
        private ItemEstoqueManager itemEstoqueManager;

	@Transactional
	public void entrar(ItemProduto itemProduto) {
            final Estoque estoque = itemProduto.getProduto().getEstoque();
            
            estoque.setQuantidade(estoque.getQuantidade() + itemProduto.getQuantidade());
            
            if(ValidatorUtils.isNotEmptyAndNotNull(estoque.getItemEstoqueList())){
                for(ItemEstoque item : estoque.getItemEstoqueList()) {
                    itemEstoqueManager.salvar(item);
                }
            }
            
            getEntityManager().merge(estoque);
            
	}
	
	@Transactional
	public void sair(ItemProduto itemProduto) {
             final Estoque estoque = itemProduto.getProduto().getEstoque();
            
             //TODO validar se tem o produto em estoques
            if(itemProduto.getQuantidade() <= estoque.getQuantidade()) {
                estoque.setQuantidade(estoque.getQuantidade() - itemProduto.getQuantidade());
            }
            
            if(ValidatorUtils.isNotEmptyAndNotNull(estoque.getItemEstoqueList())){
                for(ItemEstoque item : estoque.getItemEstoqueList()) {
                    itemEstoqueManager.salvar(item);
                }
            }
            
            getEntityManager().merge(estoque);
	}
}
