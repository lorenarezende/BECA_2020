package com.selenium.scenarios;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.core.Driver;
import com.selenium.pages.InicioPage;

public class AT01_CT01 {
	WebDriver driver;
	InicioPage inicioPage;
	// 1. Acessar o sistema (https://wpforms.com/demo/)
	// 2. Selecionar em "Viewing All Templates" a op��o �Feedback�
	// 3. Clicar em �View Demo� do card �Neighborhood Events Questionnaire Form
	// Demo�
	// 4. Preencher todos os campos (radio button e textbox) do formul�rio
	// 5. Enviar (Submit) o formul�rio
	// 6. Validar que o formul�rio foi enviado

	@Before
	public void before() {
		driver = new Driver().getDriver();
		Driver.acessarURL(driver, "https://wpforms.com/demo/");
		inicioPage = new InicioPage(driver);
	}

	@Test
	public void test() {
		
		System.out.println("Iniciando Teste");
		inicioPage.selecionarTipoFormulario();
		try {
			Thread.sleep(100);
			inicioPage.selecionarDemoParametro();
			Thread.sleep(200);

			// Preencher todos os campos (radio button e textbox) do formul�rio: How often
			// do you attend events in this neighborhood?
			driver.findElement(By.id("wpforms-260271-field_1_2")).click();
			Thread.sleep(200);

			// Preencher todos os campos (radio button e textbox) do formul�rio: If you do
			// not attend events in this neighborhood, why not?
			driver.findElement(By.id("wpforms-260271-field_2")).sendKeys("TESTE QUESTAO 02");
			Thread.sleep(200);

			// Preencher todos os campos (radio button e textbox) do formul�rio: What types
			// of events would you attend if they were held in this neighborhood?
			driver.findElement(By.id("wpforms-260271-field_3")).sendKeys("TESTE QUESTAO 03");
			Thread.sleep(200);

			// Preencher todos os campos (radio button e textbox) do formul�rio: How often
			// do you participate in activities in this neighborhood?
			driver.findElement(By.id("wpforms-260271-field_4_5")).click();
			Thread.sleep(200);

			// Preencher todos os campos (radio button e textbox) do formul�rio: If you do
			// not participate in activities in this neighborhood, why not?
			driver.findElement(By.id("wpforms-260271-field_5")).sendKeys("TESTE QUESTAO 05");
			Thread.sleep(200);

			// Preencher todos os campos (radio button e textbox) do formul�rio: What types
			// of activities would you participate in if they were available in this
			// neighborhood?
			driver.findElement(By.id("wpforms-260271-field_6")).sendKeys("TESTE QUESTAO 06");
			Thread.sleep(200);

			// Enviar (Submit) o formul�rio
			driver.findElement(By.xpath("//button[text()='Submit']")).click();
			Thread.sleep(200);


		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@After
	public void after() {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		System.out.println("Sucesso!");
		try {
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//h3[text()='Congrats, You Completed the First Step!']")));
			System.out.println("Formul�rio enviado com sucesso");
			Driver.Close(driver);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("FALHA!");
			Driver.Close(driver);
		}

	}
}
