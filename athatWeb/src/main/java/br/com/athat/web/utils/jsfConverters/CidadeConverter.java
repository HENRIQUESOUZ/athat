package br.com.athat.web.utils.jsfConverters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import org.springframework.web.jsf.FacesContextUtils;
import br.com.athat.core.cadastro.pessoa.entity.endereco.Cidade;
import br.com.athat.core.cadastro.pessoa.manager.CidadeManager;

public class CidadeConverter implements Converter{
	
    public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
        CidadeManager factory = (CidadeManager) FacesContextUtils
                .getRequiredWebApplicationContext(facesContext).getBean("cidadeManager");
        if (submittedValue != null && submittedValue.isEmpty()) {
            return null;
        }
        try {
            return factory.buscarPorId(Long.valueOf(submittedValue));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
        if (value == null || value.equals("")) {
            return "";
        }
        return String.valueOf(((Cidade) value).getId());
    }

}
