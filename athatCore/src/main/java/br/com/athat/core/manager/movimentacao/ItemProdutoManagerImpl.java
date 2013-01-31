package br.com.athat.core.manager.movimentacao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import br.com.athat.core.entity.movimentacao.ItemProduto;
import br.com.athat.core.manager.AbstractManagerImpl;

public class ItemProdutoManagerImpl extends AbstractManagerImpl implements ItemProdutoManager {

	private static final long serialVersionUID = 1L;

	@Override
	@Transactional
	public void salvar(List<ItemProduto> itensProduto) {
            for(ItemProduto it : itensProduto) {
                if(it.getId() == null) {
                    getEntityManager().persist(it);
                } else {
                    getEntityManager().merge(it);
		}
            }
	}

}
