package br.com.athat.core.cadastro.pessoa.fornecedor.manager;

import java.util.List;

import br.com.athat.core.cadastro.pessoa.fornecedor.entity.Fornecedor;

public interface FornecedorManager{
    
    void salvar(Fornecedor fornecedor);

    List<Fornecedor> buscarTodos(Fornecedor fornecedor);

	Fornecedor buscarPorId(Long id);
    
}
