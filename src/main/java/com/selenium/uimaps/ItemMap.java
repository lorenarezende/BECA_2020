package com.selenium.uimaps;

import org.openqa.selenium.WebDriver;

import com.selenium.core.Element;
import com.selenium.core.enums.ByValue;

public class ItemMap {
	WebDriver driver;
	
	public ItemMap(WebDriver driver) {
		this.driver = driver;
	}
	////a[@class='sc-fzoLsD gnrNhT item-nome']
	public Element clicaLink = new Element(driver, ByValue.XPATH, "//a[@class='sc-fzoLsD gnrNhT item-nome']");
	
}
