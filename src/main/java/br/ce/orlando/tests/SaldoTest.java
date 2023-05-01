package br.ce.orlando.tests;

import org.junit.Assert;
import org.junit.Test;

import br.ce.orlando.core.BaseTest;
import br.ce.orlando.pages.HomePage;
import br.ce.orlando.pages.MenuPage;

public class SaldoTest extends BaseTest {
	HomePage homePage = new HomePage();
	MenuPage menuPage = new MenuPage();
	
	@Test
	public void deveObterSaldoTest() {
		menuPage.acessarTelaPrincipal();
		Assert.assertEquals("534.00", homePage.obterSaldoConta("Conta para saldo"));
		
	}
}
