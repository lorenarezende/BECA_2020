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
	
	InicioMap inicioMap = new InicioMap(driver);

	public void procurarItem(String value) {
		inicioMap.findItem.sendKey(driver, value);
	}

	public void clicarBusca() {
		inicioMap.selectBusca.click(driver);
	}
	
}
