package com.selenium.uimaps;

import org.openqa.selenium.WebDriver;

import com.selenium.core.Element;
import com.selenium.core.enums.ByValue;

public class CT3Map {
WebDriver driver;
		
	public CT3Map(WebDriver driver) {
		this.driver = driver;
	}
	
	////div[@class='container']//select[@name='fromPort']
	public Element selectCidadeSaida = new Element (driver, ByValue.XPATH, "//div[@class='container']//select[@name='fromPort']");
	
	////div[@class='container']//select[@name='toPort']
	public Element selectDestino = new Element (driver, ByValue.XPATH, "//div[@class='container']//select[@name='toPort']");

	public Element clickButtom(String value) {
	Element item = new Element (driver, ByValue.XPATH,"//input[@value='"+value+"\']");
	return item;
	}
	
	public Element validarCampo(String value) {
		Element item = new Element (driver, ByValue.XPATH,"//input[@name='"+value+"\']");
		return item;
		}
	
	//td[contains(text(),'12')]//preceding::input[@value='Choose This Flight'][1]
	public Element selecionaVoo (String value) {
		Element item = new Element (driver, ByValue.XPATH,"//td[contains(text(),'"+value+"\')]//preceding::input[@value='Choose This Flight'][1]");
		return item;
	}
	public Element selecionaCampo(String value) {
		Element item = new Element (driver, ByValue.XPATH,"//option[@value="+value+"\']");
		return item;
	}
	
	////input[@name='rememberMe']
	public Element selectRemember = new Element (driver, ByValue.XPATH,"//input[@name='rememberMe']");

	
}
