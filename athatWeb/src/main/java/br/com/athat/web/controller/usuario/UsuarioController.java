package br.com.athat.web.controller.usuario;



import br.com.athat.core.usuario.builder.UsuarioBuilder;
import br.com.athat.core.usuario.entity.Usuario;
import br.com.athat.web.utils.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;

public class UsuarioController extends AbstractController{
    
	private static final long serialVersionUID = 1L;

	private Usuario usuario = new Usuario();
    
    @Autowired
    private UsuarioBuilder usuarioBuilder;


    public String salvar(){
        
        //try{  
            usuarioBuilder.build(usuario);
            setMessage("Usuario Cadastrado com Sucesso!");
            
       // }catch(Exception e){
       //    setMessage("Erro!");
       // }
        
        
        
        return "cadastroUsuario";
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
