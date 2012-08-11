package br.com.athat.core.cadastro.pessoa.cliente.manager;

import java.util.List;

import br.com.athat.core.cadastro.pessoa.cliente.entity.Cliente;

public interface ClienteManager{
    
    void salvar(Cliente cliente);
    
    List<Cliente> buscarTodos(Cliente cliente);

	Cliente buscarPorId(Long id);
    
}
