package com.selenium.scenarios;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.selenium.core.Driver;

public class CT01 {
	WebDriver driver;
	  // 1. Acessar o sistema (https://wpforms.com)
	  // 2. Selecionar o tipo de formulario
	  // 3. Clicar em "demo"
	  // 4. Preencher o formulário e enviar
	  // 5. Validar mensagem
	
	@Before
	public void before() {
		driver = new Driver().getDriver();
		Driver.acessarURL(driver, "https://wpforms.com/demo");
	//	Thread.sleep(40000);
		System.out.println("before");
	}
	
	@Test
	public void test() {
		System.out.println("test");
	}
	
	@After
	public void after() {
		Driver.Close(driver);
		System.out.println("after");
	}


}
