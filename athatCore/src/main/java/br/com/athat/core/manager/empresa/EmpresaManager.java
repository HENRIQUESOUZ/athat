package br.com.athat.core.manager.empresa;

import java.util.List;

import br.com.athat.core.entity.empresa.Empresa;
import br.com.athat.core.manager.AbstractManager;

public interface EmpresaManager extends AbstractManager {
    
    void salvar(Empresa empresa);

	List<Empresa> buscar(Empresa empresa);

	Empresa buscarPorId(Long id);
    
}
