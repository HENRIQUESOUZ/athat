package br.com.athat.core.manager.produto.categoria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import br.com.athat.core.entity.produto.categoria.Categoria;
import br.com.athat.core.manager.AbstractManagerImpl;
import br.com.athat.utils.validators.ValidatorUtils;

public class CategoriaManagerImpl extends AbstractManagerImpl implements CategoriaManager {

	private static final long serialVersionUID = 1L;

	@Transactional
	public void salvar(Categoria categoria) {
		if(categoria.getId() == null)
			getEntityManager().persist(categoria);
		else
			getEntityManager().merge(categoria);
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public List<Categoria> buscar(Categoria categoria) {
		Criteria criteria = createSession().createCriteria(Categoria.class);
		
		if(ValidatorUtils.isNotEmptyAndNotNull(categoria.getDescricao()))
			criteria.add(Restrictions.like("descricao", categoria.getDescricao(),MatchMode.START));
		
		if(categoria.getProdutoType() != null)
			criteria.add(Restrictions.eq("produtoType", categoria.getProdutoType()));
		
		if(categoria.getUnidadeMedidaType() != null)
			criteria.add(Restrictions.eq("unidadeMedidaType", categoria.getUnidadeMedidaType()));
		
		if(categoria.getIdentificacaoType() != null)
			criteria.add(Restrictions.eq("identificacaoType", categoria.getIdentificacaoType()));
			
		return criteria.list();
	}
	
	@Transactional(readOnly = false)
	public Categoria buscarPorId(Long id) {
		return getEntityManager().find(Categoria.class, id);
	}
}
