package com.selenium.pages;

import org.openqa.selenium.WebDriver;

import com.selenium.core.Element;
import com.selenium.uimaps.ItemMap;

public class ItemPage {
	WebDriver driver;
	Element teste;

	public ItemPage(WebDriver driver) {
		this.driver = driver;

	}
	
	ItemMap itemMap = new ItemMap(driver);
	
	public void clicarLink() {
		itemMap.clicaLink.click(driver);
	}
}
