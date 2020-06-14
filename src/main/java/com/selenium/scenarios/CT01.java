package com.selenium.scenarios;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.selenium.core.Driver;
import com.selenium.pages.FretePage;
import com.selenium.pages.InicioPage;
import com.selenium.pages.ItemPage;

public class CT01 {
	WebDriver driver;
	InicioPage inicioPage;
	ItemPage itemPage;
	FretePage fretePage;
	String[] valorFrete = {"R$ 24,38", "R$ 27,04", "R$ 44,79", "R$ 53,82"};

	/**
	 * 1. Acessar o sistema (https://www.kabum.com.br/) 
	 * 2. No input “buscar”, pesquisar: Capa Targus Ipad Mini Rotating Versavu THZ668 Grafite 
	 * 3.Clicar em “Buscar” 
	 * 4. Clicar no Link do produto pesquisado 
	 * 5. No campo “Digite seu CEP” preencher com o CEP: 38413-108 
	 * 6. Clicar em “Calcular Frete” 
	 * 7. Validar se os 4 valores de frete são: "R$ 23,39", "R$ 40,97","R$ 51,79"
	 */

	@Before
	public void before() {
		driver = new Driver().getDriver();

		// 1. Acessar o sistema (https://www.kabum.com.br/)
		Driver.acessarURL(driver, "https://www.kabum.com.br/");
		inicioPage = new InicioPage(driver);
		itemPage = new ItemPage(driver);
		fretePage = new FretePage(driver);

	}

	@Test
	public void test() {

		System.out.println("Iniciando Teste");
		// 2. No input “buscar”, pesquisar: Capa Targus Ipad Mini Rotating Versavu
		// THZ668 Grafite
		inicioPage.procurarItem("Mouse Gamer Redragon 10000DPI Chroma Cobra M711");

		// 3. Clicar em “Buscar”
		inicioPage.clicarBusca();

		// 4. Clicar no Link do produto pesquisado
		itemPage.clicarLink();

		// 5. No campo “Digite seu CEP” preencher com o CEP: 38413-108
		fretePage.digitarNCEP("38413-108");

		// 6. Clicar em “Calcular Frete”
		fretePage.clicarCalcularFrete();// validaFrete();//

	}

	@After
	public void after() {

		fretePage.validarFrete(valorFrete);
		Driver.Close(driver);

	}
}
