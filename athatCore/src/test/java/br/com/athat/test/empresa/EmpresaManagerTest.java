package br.com.athat.test.empresa;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.athat.core.AbstractTest;
import br.com.athat.core.Populate;
import br.com.athat.core.PopulateBD;
import br.com.athat.core.cadastro.empresa.entity.Empresa;
import br.com.athat.core.empresa.manager.EmpresaManager;

public class EmpresaManagerTest extends AbstractTest{

	@Autowired
	private EmpresaManager empresaManager;
	
	@Test
	public void salvar(){
		Empresa empresa = Populate.populateEmpresa();
		
		empresaManager.salvar(empresa);
		
		Assert.assertNotNull(empresa.getId());
	    Assert.assertEquals(1, find(Empresa.class).size());
	}
	
	@Test
	public void buscar(){
		salvar();
		Empresa empresa = new Empresa();
		
		empresaManager.buscar(empresa);
		Assert.assertEquals(1, empresaManager.buscar(empresa).size());
		
		empresa.setNome("C");
		empresaManager.buscar(empresa);
		Assert.assertEquals(1, empresaManager.buscar(empresa).size());
		
		empresa.setNome("aaaaa");
		Assert.assertEquals(0, empresaManager.buscar(empresa).size());
	}
	
	@Test
	public void buscarPorId(){
		Empresa empresa = PopulateBD.populateEmpresa(entityManager);
		
		Assert.assertNotNull(empresaManager.buscarPorId(empresa.getId()));
		Assert.assertEquals("Compustar", empresaManager.buscarPorId(empresa.getId()).getNome());
	}
}
