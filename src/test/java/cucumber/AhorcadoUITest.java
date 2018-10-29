package test.java.cucumber;

import cucumber.api.java.en.*;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import main.java.Ahorcado;
import main.java.Jugador;
import main.java.Opciones;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class AhorcadoUITest {

	WebDriver driver;	

    @Before
    public void setUp() throws Throwable {
    	System.setProperty("webdriver.gecko.driver","C:\\Users\\Agustin\\eclipse-workspace\\ahorcado\\driver\\geckodriver.exe");
		
		FirefoxOptions options = new FirefoxOptions();
		options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe"); //This is the location where you have installed Firefox on your machine
 
		driver = new FirefoxDriver(options);
		driver.get("http://localhost:8080/ahorcado/index.html");		
    }
    
    @Given("^Comienza el juego$")
    public void Comienza_el_juego() throws Throwable {    	
    	WebElement btnIniciar = driver.findElement(By.name("iniciar"));
		btnIniciar.click();		
		
		Assert.assertTrue(true);
    }

    @When("^Ingreso las letras correctas")
    public void Ingreso_letras_correctas() throws Throwable {
		WebElement btnIntentar, boxLetra;
		TimeUnit.SECONDS.sleep(1);
		btnIntentar= driver.findElement(By.name("intentar"));
		boxLetra = driver.findElement(By.name("letra"));		
		
		boxLetra.sendKeys("a");
		TimeUnit.SECONDS.sleep(1);
		btnIntentar.click();
		TimeUnit.SECONDS.sleep(1);		
		btnIntentar= driver.findElement(By.name("intentar"));
		boxLetra = driver.findElement(By.name("letra"));
		boxLetra.sendKeys("o");
		TimeUnit.SECONDS.sleep(1);
		btnIntentar.click();
		TimeUnit.SECONDS.sleep(1);
		btnIntentar= driver.findElement(By.name("intentar"));
		boxLetra = driver.findElement(By.name("letra"));
		boxLetra.sendKeys("h");
		TimeUnit.SECONDS.sleep(1);
		btnIntentar.click();
		TimeUnit.SECONDS.sleep(1);
		btnIntentar= driver.findElement(By.name("intentar"));
		boxLetra = driver.findElement(By.name("letra"));
		boxLetra.sendKeys("r");
		TimeUnit.SECONDS.sleep(1);
		btnIntentar.click();
		TimeUnit.SECONDS.sleep(1);
		btnIntentar= driver.findElement(By.name("intentar"));
		boxLetra = driver.findElement(By.name("letra"));
		boxLetra.sendKeys("c");
		TimeUnit.SECONDS.sleep(1);
		btnIntentar.click();
		TimeUnit.SECONDS.sleep(1);
		btnIntentar= driver.findElement(By.name("intentar"));
		boxLetra = driver.findElement(By.name("letra"));
		boxLetra.sendKeys("d");
		TimeUnit.SECONDS.sleep(1);
		btnIntentar.click();		
		
		Assert.assertTrue(true);
    }

    @Then("^Gano el juego$")
    public void Gano() throws Throwable {    	
    	WebElement lblEstado= driver.findElement(By.id("estado"));
    	Assert.assertEquals("Estado: Ganaste!", lblEstado.getText());
    }

    @After
    public void teardown() {
        driver.close();
    }
}