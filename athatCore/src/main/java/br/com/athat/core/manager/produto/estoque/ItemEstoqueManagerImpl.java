package br.com.athat.core.manager.produto.estoque;

import br.com.athat.core.entity.produto.estoque.ItemEstoque;
import br.com.athat.core.manager.AbstractManagerImpl;
import org.springframework.transaction.annotation.Transactional;

public class ItemEstoqueManagerImpl extends AbstractManagerImpl implements ItemEstoqueManager{

	private static final long serialVersionUID = 1L;

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
