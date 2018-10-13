import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InsertaComentarioTest {
	private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @Before
	  public void setUp() throws Exception {
		  System.setProperty("webdriver.gecko.driver",System.getProperty(
				  "user.dir")+"/geckoDriver/geckodriver.exe");
	    driver = new FirefoxDriver();
	    baseUrl = "https://www.katalon.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testComentarios() throws Exception {
	    driver.get("http://blog-curso.herokuapp.com/");
	    driver.findElement(By.linkText("Login")).click();
	    driver.findElement(By.id("inputEmail")).click();
	    driver.findElement(By.id("inputEmail")).clear();
	    driver.findElement(By.id("inputEmail")).sendKeys("jorgeG@gmail.com");
	    driver.findElement(By.id("inputPassword")).clear();
	    driver.findElement(By.id("inputPassword")).sendKeys("holamundo");
	    driver.findElement(By.id("userLogin")).submit();
	    driver.findElement(By.id("inputEmail")).click();
	    driver.findElement(By.id("inputEmail")).clear();
	    driver.findElement(By.id("inputEmail")).sendKeys("jorgen@gmail.com");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Formulario de acceso'])[1]/following::button[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='UACM Blog'])[2]/following::div[1]")).click();
	    driver.findElement(By.id("inputEmail")).click();
	    driver.findElement(By.id("inputEmail")).clear();
	    driver.findElement(By.id("inputEmail")).sendKeys("jorgeN@gmail.com");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Formulario de acceso'])[1]/following::button[1]")).click();
	    driver.findElement(By.linkText("MI PRIMER POST")).click();
	    driver.findElement(By.id("contenido")).click();
	    driver.findElement(By.id("contenido")).click();
	    driver.findElement(By.id("contenido")).clear();
	    driver.findElement(By.id("contenido")).sendKeys("Jajajaja saludos");
	    driver.findElement(By.linkText("Comentar")).click();
	    driver.findElement(By.linkText("Inicio")).click();
	  }

	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
}
