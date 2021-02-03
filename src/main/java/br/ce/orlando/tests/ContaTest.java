package br.ce.orlando.tests;

import org.junit.Assert;
import org.junit.Test;

import br.ce.orlando.core.BaseTest;
import br.ce.orlando.pages.ContasPage;
import br.ce.orlando.pages.MenuPage;

public class ContaTest extends BaseTest {
	
	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();
	
	@Test
	public void testInserirConta() {
		menuPage.acessarTelaInserirConta();
		
		contasPage.setNome("Conta do Teste");
		contasPage.salvar();
		
		Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obterMensagemSucesso());
	}
	
	@Test
	public void testAlterarConta() {
		menuPage.acessarTelaListarConta();
		
		contasPage.clicarAlterarConta("Conta do Teste");
		contasPage.setNome("Conta do Teste alterada");
		contasPage.salvar();
		
		Assert.assertEquals("Conta alterada com sucesso!", contasPage.obterMensagemSucesso());
	}
	
	@Test
	public void testInserirContaMesmoNome() {
		menuPage.acessarTelaInserirConta();
		
		contasPage.setNome("Conta do Teste alterada");
		contasPage.salvar();
		
		Assert.assertEquals("Já existe uma conta com esse nome!", contasPage.obterMensagemErro());
	}
	
	@Test
	public void testExcluirContaComMovimentacao() {
		menuPage.acessarTelaListarConta();
		
		contasPage.clicarExcluirConta("Conta do Teste alterada");
		
		Assert.assertEquals("Conta em uso na movimentações", contasPage.obterMensagemErro());
	}
}
