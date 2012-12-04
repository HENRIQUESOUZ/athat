package br.com.athat.core.manager.movimentacao.venda;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.athat.core.entity.movimentacao.ItemProduto;
import br.com.athat.core.entity.movimentacao.enuns.SituacaoMovimentacaoType;
import br.com.athat.core.entity.movimentacao.venda.Venda;
import br.com.athat.core.manager.AbstractManagerImpl;
import br.com.athat.core.manager.produto.estoque.EstoqueManager;

public class VendaManagerImpl extends AbstractManagerImpl implements VendaManager {
    
	private static final long serialVersionUID = 1L;

	@Autowired
    private EstoqueManager estoqueManager;

    @Transactional
    public Venda salvar(Venda venda) {
    	 if (venda.getId() == null) {
             venda.setSituacaoMovimentacaoType(SituacaoMovimentacaoType.ABERTA);
             getEntityManager().persist(venda);
         } else {
             getEntityManager().merge(venda);
         }
         
        for(ItemProduto itemProduto : venda.getItensMovimentacao()){
            estoqueManager.sair(itemProduto);           
        }

        return venda;
    }

    @SuppressWarnings("unchecked")
    @Transactional
    public List<Venda> buscarTodas(Venda venda) {
        Criteria criteria = createSession().createCriteria(Venda.class);

        if (venda.getDataCadastro() != null) {
            criteria.add(Restrictions.eq("dataCadastro", venda.getDataCadastro()));
        }

        if (venda.getSituacaoMovimentacaoType() != null) {
            criteria.add(Restrictions.eq("situacaoMovimentacao", venda.getSituacaoMovimentacaoType()));
        }

        if (venda.getCliente().getId() != null) {
            criteria.createAlias("cliente", "cli");
            criteria.add(Restrictions.eq("cli.id", venda.getCliente().getId()));
        }
        
        return criteria.list();
    }
    
}
