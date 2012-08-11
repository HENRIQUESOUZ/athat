package br.com.athat.core.cadastro.produto.categoria.manager;

import java.util.List;

import br.com.athat.core.cadastro.produto.categoria.entity.Categoria;

public interface CategoriaManager {
	
	void salvar(Categoria categoria);
	
	List<Categoria> buscar(Categoria categoria);

	Categoria buscarPorId(Long id);

}
