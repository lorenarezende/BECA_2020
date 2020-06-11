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
	// 1. Acessar o sistema 
	// 2. Selecionar em "Viewing All Templates" a opção “Feedback”
	// 3. Clicar em “View Demo” do card “Neighborhood Events Questionnaire Form
	// Demo”
	// 4. Preencher todos os campos (radio button e textbox) do formulário
	// 5. Enviar (Submit) o formulário
	// 6. Validar que o formulário foi enviado

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

			// Preencher todos os campos (radio button e textbox) do formulário: How often
			// do you attend events in this neighborhood?
			driver.findElement(By.id("wpforms-260271-field_1_2")).click();

			// Preencher todos os campos (radio button e textbox) do formulário: If you do
			// not attend events in this neighborhood, why not?
			driver.findElement(By.id("wpforms-260271-field_2")).sendKeys("TESTE QUESTAO 02");

			// Preencher todos os campos (radio button e textbox) do formulário: What types
			// of events would you attend if they were held in this neighborhood?
			driver.findElement(By.id("wpforms-260271-field_3")).sendKeys("TESTE QUESTAO 03");

			// Preencher todos os campos (radio button e textbox) do formulário: How often
			// do you participate in activities in this neighborhood?
			driver.findElement(By.id("wpforms-260271-field_4_5")).click();

			// Preencher todos os campos (radio button e textbox) do formulário: If you do
			// not participate in activities in this neighborhood, why not?
			driver.findElement(By.id("wpforms-260271-field_5")).sendKeys("TESTE QUESTAO 05");

			// Preencher todos os campos (radio button e textbox) do formulário: What types
			// of activities would you participate in if they were available in this
			// neighborhood?
			driver.findElement(By.id("wpforms-260271-field_6")).sendKeys("TESTE QUESTAO 06");

			// Enviar (Submit) o formulário
			driver.findElement(By.xpath("//button[text()='Submit']")).click();


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
			System.out.println("Formulário enviado com sucesso");
			Thread.sleep(10000);
			Driver.Close(driver);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("FALHA!");
			Driver.Close(driver);
		}

	}
}
