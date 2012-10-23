package br.com.athat.core.manager.pessoa.cliente;

import java.util.List;

import br.com.athat.core.entity.pessoa.cliente.Cliente;

public interface ClienteManager{
    
    void salvar(Cliente cliente);
    
    List<Cliente> buscarTodos(Cliente cliente);

	Cliente buscarPorId(Long id);
    
}
