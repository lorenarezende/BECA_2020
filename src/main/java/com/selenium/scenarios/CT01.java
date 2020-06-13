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

public class CT01 {
	WebDriver driver;
	InicioPage inicioPage;
	// 1. Acessar o sistema (https://blazedemo.com/)
	// 2. No select “Choose your departure city:” selecionar “San Diego”
	// 3. No select “Choose your destination city:” selecionar “New York”
	// 4. Clicar em “Find Flights”
	// 5. Validar se no cabeçalho da tabela tem as informações: "Departs: San Diego"
	// e "Arrives: New York"

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
		
	}

	@After
	public void after() {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		// 5. Validar se no cabeçalho da tabela tem as informações: "Departs: San Diego"
		// e "Arrives: New York"
		try {
			//// h3[text()='Flights from San Diego to New York: ']
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//h3[text()='Flights from San Diego to New York: ']")));
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
