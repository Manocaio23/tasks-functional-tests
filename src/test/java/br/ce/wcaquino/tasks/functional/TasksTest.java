package br.ce.wcaquino.tasks.functional;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TasksTest {
    
    @Test
    public void cadastrarTarefaSucesso() throws InterruptedException, MalformedURLException {
        // Define o caminho do ChromeDriver
        System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");

        // Inicializa o WebDriver com o RemoteWebDriver e a URL correta
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.116:4444/wd/hub"), cap);

        // Navega para a aplicação de tarefas com a URL correta
        driver.navigate().to("http://192.168.0.116:8001/tasks");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        driver.findElement(By.id("addTodo")).click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        
        driver.findElement(By.id("task")).sendKeys("Teste");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        
        driver.findElement(By.id("dueDate")).sendKeys("23/12/2029");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        
        driver.findElement(By.id("saveButton")).click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        
        // Verifica a mensagem de sucesso
        String message = driver.findElement(By.id("message")).getText();
        Assert.assertEquals("Sucesss!", message);
        
        // Fecha o navegador
        driver.quit();
    }
    
    @Test
    public void cadastrarTarefaSucesso2() throws InterruptedException, MalformedURLException {
        // Define o caminho do ChromeDriver
        System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");

        // Inicializa o WebDriver com o RemoteWebDriver e a URL correta
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.116:4444/wd/hub"), cap);

        // Navega para a aplicação de tarefas com a URL correta
        driver.navigate().to("http://192.168.0.116:8001/tasks");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        driver.findElement(By.id("addTodo")).click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        
        driver.findElement(By.id("task")).sendKeys("Teste QA");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        
        driver.findElement(By.id("dueDate")).sendKeys("23/12/2029");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        
        driver.findElement(By.id("saveButton")).click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        
        // Verifica a mensagem de sucesso
        String message = driver.findElement(By.id("message")).getText();
        Assert.assertEquals("Sucess!", message);
        
        // Fecha o navegador
        driver.quit();
    }
    @Test
    public void removerTarefaComSucesso() throws InterruptedException, MalformedURLException {
        // Define o caminho do ChromeDriver
        System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");

        // Inicializa o WebDriver com o RemoteWebDriver e a URL correta
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.116:4444/wd/hub"), cap);

        // Navega para a aplicação de tarefas com a URL correta
        driver.navigate().to("http://192.168.0.116:8001/tasks");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        driver.findElement(By.id("addTodo")).click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        
        driver.findElement(By.id("task")).sendKeys("1 - Teste QA");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        
        driver.findElement(By.id("dueDate")).sendKeys("23/12/2029");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        
        driver.findElement(By.id("saveButton")).click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        
        // Verifica a mensagem de sucesso
        String message = driver.findElement(By.id("message")).getText();
        Assert.assertEquals("Sucess!", message);
        
        driver.findElement(By.xpath("//*[@id=\"todoTable\"]/tbody/tr[1]/td[3]/a")).click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
      
     
        driver.quit();
    }
}
