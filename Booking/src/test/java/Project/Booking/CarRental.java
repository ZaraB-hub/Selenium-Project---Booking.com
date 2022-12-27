package Project.Booking;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
		class CarRental {
	

		private static WebDriver webDriver;
		private static String baseUrl;
		private static Actions action;


		@BeforeAll
		static void setUp() {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\zarab\\Downloads\\chromedriver_win32\\chromedriver.exe");
			webDriver=new ChromeDriver();
			baseUrl="https://www.booking.com/cars/index.html";
			action=new Actions(webDriver);
		}

		@AfterAll
		static void tearDown() {
			webDriver.quit();
		}
		
		
	  @Test
	  void testCarLocation() throws InterruptedException {
		  webDriver.get(baseUrl);
		  webDriver.manage().window().maximize();
		 
		  Thread.sleep(2000);
		  //different location 
		  webDriver.findElement(By.cssSelector(".bui-radio:nth-child(2) > .bui-radio__label")).click();

		  //pickup location
		  webDriver.findElement(By.id("ss_origin")).sendKeys("sarajevo");
		  Thread.sleep(1000);
		  webDriver.findElement(By.xpath("//div/ul/li")).click();
		  Thread.sleep(1000);
		
		  //drop off location
		  WebElement drop=webDriver.findElement(By.id("ss"));
		  drop.sendKeys("mostar");
		  Thread.sleep(1000);
		  webDriver.findElement(RelativeLocator.with(By.tagName("li")).below(drop)).click();
		  
	
		  //drivers age check-box
		  webDriver.findElement(By.xpath("//div[3]/label/span")).click();
		  webDriver.findElement(By.id("driverAgeInput")).sendKeys("22");
		  
		  
		  
		  //date table
		  webDriver.findElement(By.cssSelector(".xp__group:nth-child(1) .sb-date-field__icon-text")).click();
		  		  
		  //time
		  Select time=new Select(webDriver.findElement(By.name("checkinTime")));
		  time.selectByValue("12");
		  //date
			  List<WebElement> allDates = webDriver.findElements(By.tagName("td"));
				  
			  //TO THIS DATE
			  for(WebElement date2:allDates) {
				  String dateText=date2.getText();					
				  if (dateText.equals("30")){
					  date2.click();
					  break;
				  }
			  }
			  
			Thread.sleep(4000);
			
			
			  
			//search button
			webDriver.findElement(By.cssSelector("#frm > div.xp__fieldset.js--sb-fieldset.rentalcars > div.xp__button.xp-button__no_age > div.sb-searchbox-submit-col.-submit-button > button")).click();
			  
			Thread.sleep(4000);

	  }
}
