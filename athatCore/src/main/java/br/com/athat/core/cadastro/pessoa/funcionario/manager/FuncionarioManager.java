package br.com.athat.core.cadastro.pessoa.funcionario.manager;

import java.util.List;

import br.com.athat.core.cadastro.pessoa.funcionario.entity.Funcionario;

public interface FuncionarioManager{
    
    void salvar(Funcionario funcionario);
    
    List<Funcionario> buscarTodos(Funcionario funcionario);

	Funcionario buscarPorId(Long id);
    
}
