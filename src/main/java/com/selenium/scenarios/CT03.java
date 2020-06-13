package com.selenium.scenarios;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.core.Driver;
import com.selenium.pages.CT3Page;

public class CT03 {
	
	WebDriver driver;
	CT3Page ct3Page;
	// 1. Acessar o sistema (https://blazedemo.com/)
	// 2. Em select �Choose your departure city:� selecionar qualquer valor passado
	// por par�metro
	// 3. Em select �Choose your destination city:� selecionar qualquer valor
	// passado por par�metro
	// 4. Clicar em �Find Flights�
	// 5. Escolher a viagem baseada no �Flight#�, ou seja clicar no bot�o �Choose
	// This Flight� do �Flight#� passado por par�metro
	// 6. Preencher todos os campos do formul�rio (passar as informa��es por
	// par�metro)
	// 7. Enviar (Purchase Flight) o formul�rio
	// 8. Validar mensagem de sucesso

	@Before
	public void before() {
		driver = new Driver().getDriver();
		// 1. Acessar o sistema (https://blazedemo.com/)
		Driver.acessarURL(driver, " https://blazedemo.com/");
		ct3Page = new CT3Page(driver);
	}

	@Test
	public void test() {
		System.out.println("Iniciando Teste");

		// 2. Em select �Choose your departure city:� selecionar qualquer valor passado
		// por par�metro
		ct3Page.selecionarCidadeSaida("Portland");

		// 3. Em select �Choose your destination city:� selecionar qualquer valor
		// passado por par�metro
		// ct3Page.selecionarDestino("London");
		ct3Page.selecionarDestino("London");

		// 4. Clicar em �Find Flights�
		ct3Page.submeterOpcao("Find Flights");

		// 5. Escolher a viagem baseada no �Flight#�, ou seja clicar no bot�o �Choose
		// This Flight� do �Flight#� passado por par�metro
		ct3Page.submeterOpcaoVoo("12");

		// 6. Preencher todos os campos do formul�rio (passar as informa��es por
		// par�metro)
		// ct3Page.preencherFormulario();
		String lista1[] = { "Lorena", "Rua Teste, 148", "Uberl�ndia", "MG", "75740000", "8675734567", "09", "2020",
				"LORENA TESTE" };
		String listaXpath[] = { "inputName", "address", "city", "state", "zipCode", "creditCardNumber",
				"creditCardMonth", "creditCardYear", "nameOnCard" };

		for (int i = 0; i < lista1.length; i++) {
			// inicioMap.preencheFormulario.sendKey(driver, lista2[i]);
			ct3Page.preencherCampo(listaXpath[i], lista1[i]);

		}

		ct3Page.selecionarRember();
		// 7. Enviar (Purchase Flight) o formul�rio
		ct3Page.submeterOpcao("Purchase Flight");
	}

	@After
	public void after() {
		WebDriverWait wait = new WebDriverWait(driver, 10);

		// 8. Validar mensagem de sucesso ////h1[text()='Thank you for your purchase
		// today!']
		try {
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//h1[text()='Thank you for your purchase today!']")));
			System.out.println("Formul�rio enviado com sucesso");
			Thread.sleep(1000);
			Driver.Close(driver);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("FALHA!");
			Driver.Close(driver);
		}

	}
}
