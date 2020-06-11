package com.selenium.pages;

import org.openqa.selenium.WebDriver;

import com.selenium.uimaps.InicioMap;

public class InicioPage {
	WebDriver driver;
	
	public InicioPage(WebDriver driver) {
		this.driver = driver;
	}
	InicioMap inicioMap = new InicioMap(driver);
	

	public void selecionarTipoFormulario() {
		inicioMap.selectTipoFormulario.select(driver, "Feedback");
		
	}
	
	public void selecionarDemoParametro() {
		inicioMap.selectDemoParameter.click(driver);
	}
}
