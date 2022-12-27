package Project.Booking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class Flights {

	private static WebDriver webDriver;
	private static String baseUrl;
	private static Actions action;


	@BeforeAll
	static void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\zarab\\Downloads\\chromedriver_win32\\chromedriver.exe");
		webDriver=new ChromeDriver();
		baseUrl="https://booking.kayak.com/";
		action=new Actions(webDriver);
	}

	@AfterAll
	static void tearDown() {
		webDriver.quit();
	}
	
	
  @Test
  @Order(1)
  void testFlightOpenTab() throws InterruptedException {
	  webDriver.get(baseUrl);
	  webDriver.manage().window().maximize();
  }
 
  
  @Test
  @Order(2)
  void testStartPoint() throws InterruptedException {
	  webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/main/div[1]/div[1]/div/div[1]/div/div[2]/section[2]/div/div/div[2]/form[1]/div[1]/div/div[1]/div/div[1]/div/div/div/div")).click();
	  WebElement inputOrigin=webDriver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div[1]/div[1]/input"));
	  inputOrigin.clear();
	  inputOrigin.sendKeys("Zagreb");
	  Thread.sleep(2000); //treba pauza da se loadira
	  webDriver.findElement(By.cssSelector("ul.flight-smarty>li:first-child")).click(); //izabere first siggestion

	  Thread.sleep(1000);
	  
	
  }
  
  @Test
  @Order(3)
  void testDestination() throws InterruptedException {

	  //klikne field
	  webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/main/div[1]/div[1]/div/div[1]/div/div[2]/section[2]/div/div/div[2]/form[1]/div[1]/div/div[1]/div/div[3]/div/div/div")).click();
	  //izabere popup
	  WebElement inputDestination=webDriver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div[1]/div[1]/input"));
	  inputDestination.clear();
	  inputDestination.sendKeys("Ljubljana");
	  //izabere first siggestion
	  Thread.sleep(2000); //treba pauza da se loadira
	  webDriver.findElement(By.cssSelector("ul.flight-smarty>li:first-child")).click();

	  Thread.sleep(1000);  
	
  }
 
  @Test
  @Order(4)
  void testSwitch() throws InterruptedException {
	
	  webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/main/div[1]/div[1]/div/div[1]/div/div[2]/section[2]/div/div/div[2]/form[1]/div[1]/div/div[1]/div/div[2]/div")).click();
	  Thread.sleep(1000);  

  }
  
  @Test
  @Order(5)
  void testWay() throws InterruptedException {

	  webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/main/div[1]/div[1]/div/div[1]/div/div[2]/section[2]/div/div/div[1]/div[1]/div/div/div")).click();
	  Thread.sleep(1000); 
	  
	  //click option,one way
	  webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/ul/li[2]")).click();

  }
  
//  @Test
//  void testPassengers() throws InterruptedException {
//	  webDriver.get(baseUrl);
//	  webDriver.manage().window().maximize();
//	  webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/main/div[1]/div[1]/div/div[1]/div/div[2]/section[2]/div/div/div[1]/div[2]/div/button/div")).click();
//	 // izaberi student
//
//	  Thread.sleep(1000);
//
//
//  }
  
  @Test
  @Order(6)
  void testDate() throws InterruptedException {

	  webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/main/div[1]/div[1]/div/div[1]/div/div[2]/section[2]/div/div/div[2]/form[1]/div[1]/div/div[1]/div/div[4]/div/div[1]/div")).click();
  }
 
}
