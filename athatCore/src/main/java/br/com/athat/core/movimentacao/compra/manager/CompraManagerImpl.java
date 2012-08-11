package br.com.athat.core.movimentacao.compra.manager;

import java.awt.image.RescaleOp;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import br.com.athat.core.manager.AbstractManager;
import br.com.athat.core.movimentacao.compra.entity.Compra;

public class CompraManagerImpl extends AbstractManager implements CompraManager{

	private static final long serialVersionUID = 1L;

	@Transactional
	public void salvar(Compra compra) {
		if(compra != null)
			getEntityManager().persist(compra);
		else
			getEntityManager().merge(compra);
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Compra> buscar(Compra compra) {
		Criteria criteria = createSession().createCriteria(Compra.class);
		
		if(compra.getDataCadastro() != null)
			criteria.add(Restrictions.eq("dataCadastro", compra.getDataCadastro()));
		
		if(compra.getDataEmissaoNF() != null)
			criteria.add(Restrictions.eq("dataEmissaoNF", compra.getDataEmissaoNF()));
		
		if(compra.getDataEncerramento() != null)
			criteria.add(Restrictions.eq("dataEncerramento", compra.getDataEncerramento()));
		
		if(compra.getSituacaoMovimentacaoType() != null)
			criteria.add(Restrictions.eq("situacaoMovimentacao", compra.getSituacaoMovimentacaoType()));
		
		if(compra.getFornecedor().getId() != null){
			criteria.createAlias("fornecedor", "for");
			criteria.add(Restrictions.eq("for.id", compra.getFornecedor().getId()));
		}	
		
		return criteria.list();
	}

}
