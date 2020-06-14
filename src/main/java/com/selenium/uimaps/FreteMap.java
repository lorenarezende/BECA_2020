package com.selenium.uimaps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.selenium.core.Element;
import com.selenium.core.enums.ByValue;

public class FreteMap {
	WebDriver driver;

	public FreteMap(WebDriver driver) {
		this.driver = driver;
	}

	//// input[@id='calc_cep']
	public Element sendCEP = new Element(driver, ByValue.XPATH, "//input[@id='calc_cep']");

	//// input[@value='Calcular Frete']
	public Element selectCalcularFrete = new Element(driver, ByValue.XPATH, "//input[@value='Calcular Frete']");

	// Pegar lista dos valores dos Fretes
	public By listaValoresFrete = new By.ByXPath("//tbody[@id='table-calcular']//tr/td[contains(text(), 'R$')]");
}
