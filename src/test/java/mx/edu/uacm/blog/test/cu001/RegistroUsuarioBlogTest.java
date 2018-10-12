package mx.edu.uacm.blog.test.cu001;

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

public class RegistroUsuarioBlogTest {
	private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @Before
	  public void setUp() throws Exception {
		  System.setProperty("webdriver.gecko.driver", 
				  System.getProperty("user.di")+"/geckoDriver/geckodriver.exe");
	    driver = new FirefoxDriver();
	    baseUrl = "https://www.katalon.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testUntitledTestCase() throws Exception {
	    driver.get("http://blog-curso.herokuapp.com/");
	    driver.findElement(By.linkText("Regrístrate")).click();
	    driver.findElement(By.id("nombre")).click();
	    driver.findElement(By.id("nombre")).clear();
	    driver.findElement(By.id("nombre")).sendKeys("Josue");
	    driver.findElement(By.id("ciudad")).clear();
	    driver.findElement(By.id("ciudad")).sendKeys("CDMX, Mexico");
	    driver.findElement(By.id("email")).clear();
	    driver.findElement(By.id("email")).sendKeys("hola@gmail.com");
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys("123");
	    driver.findElement(By.id("confirm-password")).clear();
	    driver.findElement(By.id("confirm-password")).sendKeys("123");
	    driver.findElement(By.id("register-submit")).click();
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
