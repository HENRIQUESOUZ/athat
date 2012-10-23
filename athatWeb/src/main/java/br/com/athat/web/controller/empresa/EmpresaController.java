package br.com.athat.web.controller.empresa;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.athat.core.entity.empresa.Empresa;
import br.com.athat.core.manager.empresa.EmpresaManager;
import br.com.athat.web.utils.AbstractController;

public class EmpresaController extends AbstractController {
    
	private static final long serialVersionUID = 1L;

	private Empresa empresa;
	private List<Empresa> empresas;
    
    @Autowired
    private EmpresaManager empresaManager;

    public EmpresaController() {
        empresa = new br.com.athat.core.entity.empresa.Empresa();
        empresas = new ArrayList<Empresa>();
    }
    
    @PostConstruct
    public void init(){
		String id = getParametro("id");
		if (id != null) 
			empresa = empresaManager.buscarPorId(Long.valueOf(id));
    }
            
    public String salvar(){
        empresaManager.salvar(empresa);
        getMessageCadastroSucesso();
        
        return "/pages/cadastro/cadastroEmpresa";
    }
    
    public String limpar(){
    	empresa = new Empresa();
    	
    	return "cadastroEmpresa?faces-redirect=true";
    }
    
    public void buscar(){
    	empresas = empresaManager.buscar(empresa);
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}
    
}
