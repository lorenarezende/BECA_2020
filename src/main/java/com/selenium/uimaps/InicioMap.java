package com.selenium.uimaps;

import org.openqa.selenium.WebDriver;

import com.selenium.core.Element;
import com.selenium.core.enums.ByValue;

public class InicioMap {
	WebDriver driver;
	
	public InicioMap(WebDriver driver) {
		this.driver = driver;
	}
	
////div[@class='nav']/select
	public Element selectTipoFormulario = new Element(driver, ByValue.XPATH, "//div[@class='nav']/select");
	
	////a[@href='https://wpforms.com/demo/neighborhood-events-questionnaire-form-demo/']/
	public Element selectDemoParameter = new Element (driver, ByValue.XPATH, "//a[@href='https://wpforms.com/demo/neighborhood-events-questionnaire-form-demo/']");
}
