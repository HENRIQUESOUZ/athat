package br.com.athat.core.manager.produto.estoque;

import br.com.athat.core.entity.produto.estoque.ItemEstoque;
import br.com.athat.core.manager.AbstractManager;
import org.springframework.transaction.annotation.Transactional;

public class ItemEstoqueManagerImpl extends AbstractManager implements ItemEstoqueManager{

    @Transactional
    public void salvar(ItemEstoque itemEstoque) {
        if(itemEstoque != null) {
            getEntityManager().persist(itemEstoque);
        }
        else {
            getEntityManager().merge(itemEstoque);
        }
       
    }
    
}
