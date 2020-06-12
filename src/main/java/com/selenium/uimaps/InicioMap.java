package com.selenium.uimaps;

import org.openqa.selenium.WebDriver;

import com.selenium.core.Element;
import com.selenium.core.enums.ByValue;
import com.selenium.pages.InicioPage;

public class InicioMap {
	WebDriver driver;
	
	String lista1[] = {"//input[@name='inputName']","//input[@name='address']", "//input[@name='city']", "//input[@name='state']"};
	
	public InicioMap(WebDriver driver) {
		this.driver = driver;
	}
	
	////div[@class='container']//select[@name='fromPort']
	public Element selectCidadeSaida = new Element (driver, ByValue.XPATH, "//div[@class='container']//select[@name='fromPort']");
	
	////div[@class='container']//select[@name='toPort']
	public Element selectDestino = new Element (driver, ByValue.XPATH, "//div[@class='container']//select[@name='toPort']");
	
	////input[@value='Find Flights']
	public Element submeterForm = new Element (driver, ByValue.XPATH, "//input[@value='Find Flights']");
	
	//input[@value=43]
	public Element selectPrimeiraOpcao = new Element (driver, ByValue.XPATH, "//input[@value='Choose This Flight']");

	//função que varre um vetor que contém xpath dos campos do formulário, que serão preenchidos com os itens da lista2
	public Element Teste (int i) {
	String lista1[] = {"//input[@name='inputName']","//input[@name='address']", "//input[@name='city']", "//input[@name='state']", "//input[@name='zipCode']", "//input[@name='creditCardNumber']", "//input[@name='creditCardMonth']", "//input[@name='creditCardYear']","//input[@name='nameOnCard']"};
		Element preencheFormulario = new Element (driver, ByValue.XPATH,lista1[i]);
		return preencheFormulario;
	}
	
	////input[@name='rememberMe']
	public Element selectRemember = new Element (driver, ByValue.XPATH,"//input[@name='rememberMe']");
	
	////input[@value='Purchase Flight']
	public Element clickPurchaseFlight = new Element (driver, ByValue.XPATH,"//input[@value='Purchase Flight']");
	
}
