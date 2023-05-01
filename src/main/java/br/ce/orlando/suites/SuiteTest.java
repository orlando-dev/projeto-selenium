package br.ce.orlando.suites;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ce.orlando.pages.LoginPage;
import br.ce.orlando.tests.ContaTest;
import br.ce.orlando.tests.MovimentacaoTest;
import br.ce.orlando.tests.RemoverMovimentacaoContaTest;
import br.ce.orlando.tests.ResumoTest;
import br.ce.orlando.tests.SaldoTest;

@RunWith(Suite.class)
@SuiteClasses({ 
		ContaTest.class, 
		MovimentacaoTest.class, 
		RemoverMovimentacaoContaTest.class, 
		SaldoTest.class,
		ResumoTest.class })
public class SuiteTest {
	private static LoginPage loginPage = new LoginPage();
	
	@BeforeClass
	public static void reset() {
		loginPage.acessarTelaInicial();
		
		loginPage.logar("orlando@7", "1234567");
		
		loginPage.resertar();
	}
}
