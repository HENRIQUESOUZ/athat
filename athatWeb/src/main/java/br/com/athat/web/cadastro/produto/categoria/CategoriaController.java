package br.com.athat.web.cadastro.produto.categoria;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.athat.core.cadastro.produto.categoria.entity.Categoria;
import br.com.athat.core.cadastro.produto.categoria.manager.CategoriaManager;
import br.com.athat.web.utils.AbstractController;

public class CategoriaController extends AbstractController{
	
	private static final long serialVersionUID = 1L;

	private Categoria categoria;
    private List<Categoria> categorias;
    
    @Autowired
    private CategoriaManager categoriaManager;

    public CategoriaController() {
        categoria = new Categoria();
        categorias = new ArrayList<Categoria>();
    }
    
	@PostConstruct
    public void init(){
		String id = getParametro("id");
		if (id != null) 
        	categoria = categoriaManager.buscarPorId(Long.valueOf(id));
    }
    
    public String salvar() {
        categoriaManager.salvar(categoria);
        getMessageCadastroSucesso();
        
        return "cadastroCategoria";
    }
    public void buscar() {
        categorias = categoriaManager.buscar(categoria);
    }
    
    public String limpar() {
    	categoria = new Categoria();
    	
    	return "cadastroCategoria?faces-redirect=true";
    }

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
