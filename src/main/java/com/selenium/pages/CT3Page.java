package com.selenium.pages;

import org.openqa.selenium.WebDriver;

import com.selenium.core.Element;
import com.selenium.uimaps.CT3Map;

public class CT3Page {
	WebDriver driver;
	Element teste;

	public CT3Page(WebDriver driver) {
		this.driver = driver;
	}

	CT3Map ct3Map = new CT3Map(driver);

	public void selecionarOpcao(String value) {
		ct3Map.selecionaCampo(value).select(driver, value);
	}

	public void selecionarCidadeSaida(String value) {
		ct3Map.selectCidadeSaida.select(driver, value);
	}

	public void selecionarDestino(String value) {
		ct3Map.selectDestino.select(driver, value);
	}

	public void preencherCampo(String value, String text) {
		ct3Map.validarCampo(value).sendKey(driver, text);
	}

	public void submeterOpcao(String value) {
		ct3Map.clickButtom(value).click(driver);

	}

	public void submeterOpcaoVoo(String value) {
		ct3Map.selecionaVoo(value).click(driver);
	}

	public void selecionarRember() {
		ct3Map.selectRemember.click(driver);
	}

}
