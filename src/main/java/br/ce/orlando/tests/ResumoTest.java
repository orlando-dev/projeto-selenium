package br.ce.orlando.tests;

import org.junit.Assert;
import org.junit.Test;

import br.ce.orlando.core.BaseTest;
import br.ce.orlando.pages.MenuPage;
import br.ce.orlando.pages.ResumoPage;

public class ResumoTest extends BaseTest {
	
	private MenuPage menuPage = new MenuPage();
	private ResumoPage resumoPage = new ResumoPage();
	
	@Test
	public void testExcluirMovimentacao() {
		menuPage.acessarTelaResumo();
		
		resumoPage.excluirMovimentacao();
		
		Assert.assertEquals("Movimentação removida com sucesso!", resumoPage.obterMensagemSucesso());
	}
}
