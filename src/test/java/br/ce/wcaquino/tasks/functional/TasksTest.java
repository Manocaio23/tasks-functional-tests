package br.ce.wcaquino.tasks.functional;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TasksTest {
    
    @Test
    public void cadastrarTarefaSucesso() throws InterruptedException {
        // Define o caminho do ChromeDriver
        System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");

        // Inicializa o WebDriver
        WebDriver driver = new ChromeDriver();

        // Navega para o Google
        driver.navigate().to("http://localhost:8001/tasks");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        driver.findElement(By.xpath("//*[@id=\"addTodo\"]")).click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        
        driver.findElement(By.xpath("//*[@id=\"task\"]")).sendKeys("Teste");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        
        driver.findElement(By.xpath("//*[@id=\"dueDate\"]")).sendKeys("23/12/2029");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        
        driver.findElement(By.xpath("//*[@id=\"saveButton\"]")).click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        
       //sucesso
       String	message= driver.findElement(By.xpath("//*[@id=\"message\"]")).getText();
       Assert.assertEquals("Sucess!", message);
        
        // Fecha o navegador
        driver.quit();
        
        
    }
}