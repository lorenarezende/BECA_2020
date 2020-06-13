package com.selenium.pages;

import org.openqa.selenium.WebDriver;

import com.selenium.core.Element;
import com.selenium.uimaps.InicioMap;

public class InicioPage {
	WebDriver driver;
	Element teste;

	public InicioPage(WebDriver driver) {
		this.driver = driver;
	}

	String lista2[] = { "Lorena", "Rua Teste, 148", "Uberlândia", "MG", "75740000", "8675734567", "09", "2020",
			"LORENA TESTE" };
	InicioMap inicioMap = new InicioMap(driver);

	public void selecionarCidadeSaida() {
		// San Diego
		inicioMap.selectCidadeSaida.select(driver, "San Diego");
	}

	public void selecionarDestino() {
		// New York
		inicioMap.selectDestino.select(driver, "New York");
	}

	public void submeterFormulario() {
		// Submit
		inicioMap.submeterForm.click(driver);
	}

	public void selecionarPrimeiraOpcao() {
		// Clicar na primeira opção de vôo
		inicioMap.selectPrimeiraOpcao.click(driver);
	}

	public void preencherFormulario() {
		for (int i = 0; i < lista2.length; i++) {
			inicioMap.preencheForm(i).sendKey(driver, lista2[i]);
		}
		inicioMap.selectRemember.click(driver);
	}

	public void clicaPurchaseFlight() {
		inicioMap.clickPurchaseFlight.click(driver);
	}

}
