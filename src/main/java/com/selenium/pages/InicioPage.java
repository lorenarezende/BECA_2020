package com.selenium.pages;

import org.openqa.selenium.WebDriver;

import com.selenium.uimaps.InicioMap;

public class InicioPage {
	WebDriver driver;
	
	public InicioPage(WebDriver driver) {
		this.driver = driver;
	}
	InicioMap inicioMap = new InicioMap(driver);
	
	public void selecionarCidadeSaida() {
		//San Diego
		inicioMap.selectCidadeSaida.select(driver, "San Diego");
	}
	
	public void selecionarDestino() {
		//New York
		inicioMap.selectDestino.select(driver, "New York");
	}
	
	public void submeterFormulario() {
		//Submit
		inicioMap.submeterForm.click(driver);
	}
	
	public void selecionarTipoFormulario() {
		inicioMap.selectTipoFormulario.select(driver, "Feedback");
		
	}
	
	
	public void selecionarDemoParametro() {
		inicioMap.selectDemoParameter.click(driver);
	}
}
