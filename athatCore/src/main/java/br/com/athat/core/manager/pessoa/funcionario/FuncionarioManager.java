package br.com.athat.core.manager.pessoa.funcionario;

import java.util.List;

import br.com.athat.core.entity.pessoa.funcionario.Funcionario;

public interface FuncionarioManager{
    
    void salvar(Funcionario funcionario);
    
    List<Funcionario> buscarTodos(Funcionario funcionario);

	Funcionario buscarPorId(Long id);
    
}
