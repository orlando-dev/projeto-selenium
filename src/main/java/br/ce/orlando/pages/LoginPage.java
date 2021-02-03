package br.ce.orlando.pages;

import org.openqa.selenium.By;

import br.ce.orlando.core.BasePage;
import br.ce.orlando.core.DriverFactory;

public class LoginPage extends BasePage {
	
	public void acessarTelaInicial() {
		DriverFactory.getDriver().get("https://seubarriga.wcaquino.me/login");
	}
	
	public void setEmail(String email) {
		escrever("email", email);
	}
	
	public void setSenha(String senha) {
		escrever("senha", senha);
	}
	
	public void entrar() {
		clicarBotao(By.xpath("//button[text()='Entrar']"));
//		clicarBotao(By.xpath("//button[.='Entrar']"));
	}
	
	public void logar(String email, String senha) {
		setEmail(email);
		setSenha(senha);
		entrar();
	}
}
