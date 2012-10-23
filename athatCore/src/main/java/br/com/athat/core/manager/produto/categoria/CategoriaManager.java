package br.com.athat.core.manager.produto.categoria;

import java.util.List;

import br.com.athat.core.entity.produto.categoria.Categoria;

public interface CategoriaManager {
	
	void salvar(Categoria categoria);
	
	List<Categoria> buscar(Categoria categoria);

	Categoria buscarPorId(Long id);

}
