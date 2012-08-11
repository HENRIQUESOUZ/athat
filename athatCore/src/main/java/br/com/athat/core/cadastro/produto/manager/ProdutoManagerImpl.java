package br.com.athat.core.cadastro.produto.manager;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;
import br.com.athat.core.cadastro.produto.entity.Produto;
import br.com.athat.core.manager.AbstractManager;
import br.com.athat.utils.validators.ValidatorUtils;

public class ProdutoManagerImpl extends AbstractManager implements ProdutoManager{

	private static final long serialVersionUID = 1L;

	@Transactional
	public void salvar(Produto produto) {
		if(produto.getId() == null)
			getEntityManager().persist(produto);
		else
			getEntityManager().merge(produto);
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public List<Produto> buscar(Produto produto) {
		Criteria criteria = createSession().createCriteria(Produto.class,"p");
		
		if(produto.getCategoria() != null){
			criteria.createAlias("categoria", "c");
			criteria.add(Restrictions.eq("p.categoria", produto.getCategoria()));
		}	
			
		if(ValidatorUtils.isNotEmptyAndNotNull(produto.getDescricao()))
			criteria.add(Restrictions.like("p.descricao", produto.getDescricao()));
		
		return criteria.list();
	}

	@Transactional(readOnly = false)
	public Produto buscarPorId(Long id) {
		return getEntityManager().find(Produto.class, id);
	}
}
