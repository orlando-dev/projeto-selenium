package br.ce.orlando.tests;

import org.junit.Assert;
import org.junit.Test;

import br.ce.orlando.core.BaseTest;
import br.ce.orlando.pages.HomePage;

public class SaldoTest extends BaseTest {
	HomePage page = new HomePage();
	
	
	
	@Test
	public void testSaldoConta() {
		Assert.assertEquals("700.00", page.obterSaldoConta("Conta do Teste alterada"));
	}
}
