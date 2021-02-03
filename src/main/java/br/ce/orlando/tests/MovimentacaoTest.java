package br.ce.orlando.tests;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.ce.orlando.core.BaseTest;
import br.ce.orlando.pages.MenuPage;
import br.ce.orlando.pages.MovimentacaoPage;
import br.ce.orlando.utils.DataUtils;


public class MovimentacaoTest extends BaseTest{
	private MenuPage menuPage = new MenuPage();
	private MovimentacaoPage movPage = new MovimentacaoPage();
	
	@Test
	public void testInserirMovimentacao() {
		menuPage.acessarTelaCriarMovimentacao();
		
		movPage.setDataMovimentação("01/09/2019");
		movPage.setDataPagamento("02/09/2019");
		movPage.setDescricao("Movimentação do Teste");
		movPage.setInteressado("Interessado Qualquer");
		movPage.setValor("700");
		movPage.setConta("Conta do Teste alterada");
		movPage.setStatusPago();
		movPage.salvar();
		
		Assert.assertEquals("Movimentação adicionada com sucesso!", movPage.obterMensagemSucesso());
		
	}
	
	@Test
	public void testCamposObrigatorio() {
		menuPage.acessarTelaCriarMovimentacao();
		
		movPage.salvar();
		List<String> erros = movPage.obterErros();
		
		Assert.assertEquals("Data da Movimentação é obrigatório", erros.get(0));
		Assert.assertTrue(erros.contains("Data da Movimentação é obrigatório"));
		Assert.assertTrue(erros.containsAll(Arrays.asList(
				"Data da Movimentação é obrigatório",
				"Data do pagamento é obrigatório",
				"Descrição é obrigatório",
				"Interessado é obrigatório",
				"Valor é obrigatório",
				"Valor deve ser um número")));
		
		Assert.assertEquals(6, erros.size());
	}
	
	@Test
	public void testInserirMovimentacaoFutura() {
		menuPage.acessarTelaCriarMovimentacao();
		
		Date dataFutura = DataUtils.obterDataComDiferencaDias(5);
		
		movPage.setDataMovimentação(DataUtils.obterDataFormatada(dataFutura));
		movPage.setDataPagamento(DataUtils.obterDataFormatada(dataFutura));
		movPage.setDescricao("Movimentação do Teste");
		movPage.setInteressado("Interessado Qualquer");
		movPage.setValor("700");
		movPage.setConta("Conta do Teste alterada");
		movPage.setStatusPago();
		movPage.salvar();
		
		List<String> erros = movPage.obterErros();
		Assert.assertTrue(
				erros.contains("Data da Movimentação deve ser menor ou igual à data atual"));
		Assert.assertEquals(1, erros.size());
	}
}
