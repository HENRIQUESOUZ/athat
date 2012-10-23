package br.com.athat.core.manager.pessoa.fornecedor;

import java.util.List;

import br.com.athat.core.entity.pessoa.fornecedor.Fornecedor;

public interface FornecedorManager{
    
    void salvar(Fornecedor fornecedor);

    List<Fornecedor> buscarTodos(Fornecedor fornecedor);

	Fornecedor buscarPorId(Long id);
    
}
