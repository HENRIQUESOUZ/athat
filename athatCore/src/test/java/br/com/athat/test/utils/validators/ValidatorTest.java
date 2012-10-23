package br.com.athat.test.utils.validators;

import org.junit.Assert;
import org.junit.Test;

import br.com.athat.core.entity.pessoa.Pessoa;
import br.com.athat.utils.validators.CpfCnpjValidator;
import br.com.athat.utils.validators.ValidatorUtils;

public class ValidatorTest {
	
	@Test
	public void CpfCnpjValidatorTest(){
		Assert.assertTrue(CpfCnpjValidator.isValid("05.631.601/0001-16"));
		Assert.assertTrue(CpfCnpjValidator.isValid("630.246.690-35"));
		
		Assert.assertFalse(CpfCnpjValidator.isValid("000.000.000-00"));
		Assert.assertFalse(CpfCnpjValidator.isValid("99999999999"));
	}
	
	@Test
	public void isNotEmptyAndNotNullTest(){
		
		Pessoa pessoa = new Pessoa();
		Assert.assertFalse(ValidatorUtils.isNotEmptyAndNotNull(pessoa.getNomeRazao()));

		pessoa.setNomeRazao(null);
		Assert.assertFalse(ValidatorUtils.isNotEmptyAndNotNull(pessoa.getNomeRazao()));
		
		pessoa.setCpfCnpj("");
		Assert.assertFalse(ValidatorUtils.isNotEmptyAndNotNull(pessoa.getCpfCnpj()));
		
		pessoa.setCpfCnpj(" ");
		Assert.assertFalse(ValidatorUtils.isNotEmptyAndNotNull(pessoa.getCpfCnpj()));

		pessoa.setCpfCnpj("12312321");
		Assert.assertTrue(ValidatorUtils.isNotEmptyAndNotNull(pessoa.getCpfCnpj()));
		
	}

}
