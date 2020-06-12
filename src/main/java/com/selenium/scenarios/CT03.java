package com.selenium.scenarios;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.core.Driver;
import com.selenium.pages.InicioPage;

public class CT03 {
////td[2][text()=43]
	WebDriver driver;
	InicioPage inicioPage;
	// 1. Acessar o sistema (https://blazedemo.com/)
	// 2. Em select “Choose your departure city:” selecionar qualquer valor passado por parâmetro
	// 3. Em select “Choose your destination city:” selecionar qualquer valor passado por parâmetro
	// 4. Clicar em “Find Flights”
	// 5. Escolher a viagem baseada no “Flight#”, ou seja clicar no botão “Choose This Flight” do “Flight#” passado por parâmetro
	// 6. Preencher todos os campos do formulário
	// 7. Enviar (Purchase Flight) o formulário
	// 8. Validar mensagem de sucesso

	@Before
	public void before() {
		driver = new Driver().getDriver();
		// 1. Acessar o sistema (https://blazedemo.com/)
		Driver.acessarURL(driver, " https://blazedemo.com/");
		inicioPage = new InicioPage(driver);
	}

	@Test
	public void test() {
		System.out.println("Iniciando Teste");
		// 2. No select “Choose your departure city:” selecionar “San Diego”
		inicioPage.selecionarCidadeSaida();

		// 3. No select “Choose your destination city:” selecionar “New York”
		inicioPage.selecionarDestino();

		// 4. Clicar em “Find Flights”
		inicioPage.submeterFormulario();

		// 5. Escolher a primeira viagem, ou seja clicar no primeiro botão “Choose This
		// Flight”
		inicioPage.selecionarPrimeiraOpcao();
		
		// 6. Preencher todos os campos do formulário
		inicioPage.preencherFormulario();

		// 7. Enviar (Purchase Flight) o formulário
		inicioPage.clicaPurchaseFlight();
	}

	@After
	public void after() {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		// 8. Validar mensagem de sucesso

		try {////h1[text()='Thank you for your purchase today!']
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//h1[text()='Thank you for your purchase today!']")));
			System.out.println("Formulário enviado com sucesso");
			Thread.sleep(1000);
			Driver.Close(driver);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("FALHA!");
			Driver.Close(driver);
		}

	}
}
