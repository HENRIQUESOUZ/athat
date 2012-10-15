package br.com.athat.core.movimentacao.venda.manager;

import br.com.athat.core.cadastro.produto.estoque.EstoqueManager;
import br.com.athat.core.manager.AbstractManager;
import br.com.athat.core.movimentacao.ItemProduto;
import br.com.athat.core.movimentacao.compra.entity.Compra;
import br.com.athat.core.movimentacao.enuns.SituacaoMovimentacaoType;
import br.com.athat.core.movimentacao.venda.entity.Venda;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class VendaManagerImpl extends AbstractManager implements VendaManager {
    
    @Autowired
    private EstoqueManager estoqueManager;

    @Transactional
    public Venda salvar(Venda venda) {
        
        for(ItemProduto itemProduto : venda.getItensMovimentacao()){
            estoqueManager.entrar(itemProduto);           
        }
        
        if (venda != null) {
            venda.setSituacaoMovimentacaoType(SituacaoMovimentacaoType.ABERTA);
            getEntityManager().persist(venda);
        } else {
            getEntityManager().merge(venda);
        }
        
        return venda;
        
    }

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
