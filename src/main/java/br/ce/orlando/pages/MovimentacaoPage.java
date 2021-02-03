package br.ce.orlando.pages;

import org.openqa.selenium.By;

import br.ce.orlando.core.BasePage;

public class MovimentacaoPage extends BasePage {
	
	public void setDataMovimentação(String dataMovimentacao) {
		escrever("data_transacao", dataMovimentacao);
	}
	
	public void setDataPagamento(String dataPagamento) {
		escrever("data_pagamento", dataPagamento);
	}
	
	public void setDescricao(String descricao) {
		escrever("descricao", descricao);
	}
	
	public void setInteressado(String interessado) {
		escrever("interessado", interessado);
	}
	
	public void setValor(String valor) {
		escrever("valor", valor);
	}
	
	public void setConta(String contaCombo) {
		selecionarCombo("conta", contaCombo);
	}
	
	public void setStatusPago() {
		clicarRadio("status_pago");
	}
	
	public void salvar() {
		clicarBotaoPorTexto("Salvar");
	}
	
	public String obterMensagemSucesso() {
		return obterTexto(By.xpath("//div[@class='alert alert-success']"));
	}
}
