package com.selenium.uimaps;

import org.openqa.selenium.WebDriver;

import com.selenium.core.Element;
import com.selenium.core.enums.ByValue;
import com.selenium.pages.InicioPage;

public class InicioMap {
	WebDriver driver;

	public InicioMap(WebDriver driver) {
		this.driver = driver;
	}

	//// input[@class='sprocura']
	public Element findItem = new Element(driver, ByValue.XPATH, "//input[@class='sprocura']");

	//// input[@id='bt-busca']
	public Element selectBusca = new Element(driver, ByValue.XPATH, "//input[@id='bt-busca']");

}
