package Project.Booking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;

class Attractions {

	private static WebDriver webDriver;
	private static String baseUrl;
	private static Actions action;


	@BeforeAll
	static void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\zarab\\Downloads\\chromedriver_win32\\chromedriver.exe");
		webDriver=new ChromeDriver();
		baseUrl="https://www.booking.com/attractions/index.html";
		action=new Actions(webDriver);
	}

	@AfterAll
	static void tearDown() {
		webDriver.quit();
	}
	
	
  @Test
  void testAttractions() throws InterruptedException {
	  webDriver.get(baseUrl);
	  webDriver.manage().window().maximize();
	  WebElement query=webDriver.findElement(By.name("query"));
	  query.sendKeys("sarajevo");
	  
	  //ne radi
	  Thread.sleep(3000);
	  webDriver.findElement(RelativeLocator.with(By.tagName("li")).below(query)).click();
	  Thread.sleep(1000);  
	  
	  //search
	  webDriver.findElement(By.xpath("//span[contains(text(),'Search')]")).click();
	  Thread.sleep(10000); 
  }
}
