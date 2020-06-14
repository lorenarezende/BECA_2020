package com.selenium.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.selenium.core.Element;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.core.Driver;
import com.selenium.uimaps.FreteMap;

public class FretePage {

	WebDriver driver;
	Element teste;

	public FretePage(WebDriver driver) {
		this.driver = driver;

	}

	FreteMap freteMap = new FreteMap(driver);

	public void digitarNCEP(String value) {
		freteMap.sendCEP.click(driver);
		freteMap.sendCEP.sendKey(driver, value);
	}

	public void clicarCalcularFrete() {
		freteMap.selectCalcularFrete.click(driver);
	}

	public void validarFrete(String[] valorFrete) {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(freteMap.listaValoresFrete));
			java.util.List<WebElement> valoresFretePagina = driver.findElements(freteMap.listaValoresFrete);

			for (int i = 0; i < valorFrete.length; i++) {
				Assert.assertEquals("FALHA ao validar frete!", valorFrete[i], valoresFretePagina.get(i).getText());
			}
			System.out.println("Valores de frete ok");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("FALHA!");

		}
	}
}
