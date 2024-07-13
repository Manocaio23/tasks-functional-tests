package br.ce.wcaquino.tasks.prod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class HealthCheckIt {
	
	@Test
    public void cadastrarTarefaSucesso() throws InterruptedException, MalformedURLException {
		 System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");

         // Inicializa o WebDriver com o RemoteWebDriver e a URL correta
         DesiredCapabilities cap = DesiredCapabilities.chrome();
         WebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.116:4444/wd/hub"), cap);
         
        try {
        	// Define o caminho do ChromeDriver
           
            // Navega para a aplicação de tarefas com a URL correta
            driver.navigate().to("http://192.168.0.116:9999/tasks");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            String version = driver.findElement(By.id("version")).getText();
            Assert.assertTrue(version.startsWith("build"));
		} finally {
			 driver.quit();
		}
        
       
    }
    
		
}
