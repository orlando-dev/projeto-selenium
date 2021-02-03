package br.ce.orlando.suites;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ce.orlando.core.DriverFactory;
import br.ce.orlando.pages.LoginPage;
import br.ce.orlando.tests.ContaTest;
import br.ce.orlando.tests.MovimentacaoTest;
import br.ce.orlando.tests.RemoverMovimentacaoContaTest;
import br.ce.orlando.tests.ResumoTest;
import br.ce.orlando.tests.SaldoTest;

@RunWith(Suite.class)
@SuiteClasses({ ContaTest.class, MovimentacaoTest.class, RemoverMovimentacaoContaTest.class, SaldoTest.class,
		ResumoTest.class })
public class SuiteGeral {
	private static LoginPage page = new LoginPage();

	@BeforeClass
	public static void inicializa() {
		page.acessarTelaInicial();
		page.setEmail("orlando@7");
		page.setSenha("1234567");
		page.entrar();
	}

	@AfterClass
	public static void finaliza() {
		DriverFactory.killDriver();
	}
}
