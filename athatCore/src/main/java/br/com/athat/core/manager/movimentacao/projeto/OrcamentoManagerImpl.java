package br.com.athat.core.manager.movimentacao.projeto;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import br.com.athat.core.entity.movimentacao.enuns.SituacaoMovimentacaoType;
import br.com.athat.core.entity.movimentacao.projeto.Orcamento;
import br.com.athat.core.manager.AbstractManagerImpl;
import br.com.athat.core.vo.projeto.OrcamentoVO;

public class OrcamentoManagerImpl extends AbstractManagerImpl implements OrcamentoManager {

	private static final long serialVersionUID = 1L;

	@Override
	@Transactional
	public void salvar(Orcamento levantamento) {
		if(levantamento.getId() == null) {
			getEntityManager().persist(levantamento);
		} else {
			getEntityManager().merge(levantamento);
		}
	}

	@Override
	@SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
	public List<Orcamento> buscar(OrcamentoVO levantamento) {
		Criteria criteria = createSession().createCriteria(Orcamento.class)
			.add(Restrictions.between("dataCadastro", levantamento.getDataInicio(), levantamento.getDataFim()))
	    ;	
//        if (compra.getSituacaoMovimentacaoType() != null) {
//            criteria.add(Restrictions.eq("situacaoMovimentacaoType", compra.getSituacaoMovimentacaoType()));
//        }
			
		if(levantamento.getId() != null) {
			criteria.add(Restrictions.eq("id", levantamento.getId()));
		}
	   
		return criteria.list();
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)	
	public List<Orcamento> buscarOrcApresentacaoProjeto(Long idProjeto) {
		Criteria criteria = createSession().createCriteria(Orcamento.class, "o")
			.createAlias("projeto", "p")
			.add(Restrictions.eq("projeto.id", idProjeto))
			.add(Restrictions.ne("o.situacaoMovimentacaoType", SituacaoMovimentacaoType.CANCELADA))
		;
		
		for(Orcamento o : (List<Orcamento>) criteria.list()) {
			Hibernate.initialize(o.getItensMovimentacao());
		}
		return criteria.list();
	}
	
}
