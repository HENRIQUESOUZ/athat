package br.com.athat.core.empresa.manager;

import java.util.List;
import br.com.athat.core.cadastro.empresa.entity.Empresa;

public interface EmpresaManager {
    
    void salvar(Empresa empresa);

	List<Empresa> buscar(Empresa empresa);

	Empresa buscarPorId(Long id);
    
}
