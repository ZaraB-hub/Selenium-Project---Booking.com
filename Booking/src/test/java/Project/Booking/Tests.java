package Project.Booking;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

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
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class Tests {
	private static WebDriver webDriver;
	private static String baseUrl;
	private static Actions action;


	@BeforeAll
	static void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\zarab\\Downloads\\chromedriver_win32\\chromedriver.exe");
		webDriver=new ChromeDriver();
		baseUrl="https://www.booking.com";
		action=new Actions(webDriver);
	}

	@AfterAll
	static void tearDown() {
		webDriver.quit();
	}
	
	
  @Test
  void testHelpCenter() throws InterruptedException {
	  webDriver.get(baseUrl);
	  webDriver.manage().window().maximize();
	  webDriver.findElement(By.xpath("/html/body/header/nav[1]/div[2]/div[3]/a/span")).click();
	  Thread.sleep(2000);
	  
  }
@Test
void testFlightTab() throws InterruptedException {
	  webDriver.get(baseUrl);
	  webDriver.manage().window().maximize();
	  webDriver.findElement(By.linkText("Flights")).click();
	  Thread.sleep(1000);
}

@Test
void testCarTab() throws InterruptedException {
	  webDriver.get(baseUrl);
	  webDriver.manage().window().maximize();
	  webDriver.findElement(By.linkText("Car rentals")).click();
	  Thread.sleep(1000);
}

@Test
void testAttractionTab() throws InterruptedException {
	  webDriver.get(baseUrl);
	  webDriver.manage().window().maximize();
	  webDriver.findElement(By.linkText("Attractions")).click();
	  Thread.sleep(1000);
}

@Test
void testtTaxiTab() throws InterruptedException {
	  webDriver.get(baseUrl);
	  webDriver.manage().window().maximize();
	  webDriver.findElement(By.linkText("Airport taxis")).click();
	  Thread.sleep(1000);
}

@Test
void testChangeCurrency() throws InterruptedException {
	  webDriver.get(baseUrl);
	  webDriver.manage().window().maximize();
	  webDriver.findElement(By.xpath("/html/body/header/nav[1]/div[2]/div[1]/button/span/span[1]")).click();
	  Thread.sleep(3000);
	  webDriver.findElement(By.xpath("//div[contains(text(),'Dollar')]")).click();
	  Thread.sleep(1000);
}

@Test
void testChangeLanguage() throws InterruptedException {
	  webDriver.get(baseUrl);
	  webDriver.manage().window().maximize();
	  //open possible languages
	  webDriver.findElement(By.xpath("/html/body/header/nav[1]/div[2]/div[2]/button")).click();
	  Thread.sleep(5000);
	  //change to Croatia
	  webDriver.findElement(By.xpath("//div[contains(text(),'Hrvatski')]")).click();
	  Thread.sleep(1000);
	  webDriver.findElement(By.xpath("/html/body/header/nav[1]/div[2]/div[2]/button")).click();
	  Thread.sleep(2000);
	  //change back to English
	  webDriver.findElement(By.xpath("//div[contains(text(),'(US)')]")).click();
	  Thread.sleep(1000);
}
	
	@Test
	@Order(1)
	void whereAreWeGoingBar() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.manage().window().maximize();
		   
		WebElement place=webDriver.findElement(By.name("ss"));
		place.sendKeys("Sarajevo");	
		Thread.sleep(1000);
		webDriver.findElement(RelativeLocator.with(By.tagName("li")).below(place)).click();
		
	}
	@Test
	void datePicker() throws InterruptedException {
		
		
		//webDriver.findElement(By.cssSelector(".xp__input-group:nth-child(2) .sb-date-field__icon")).click(); //date table
		Thread.sleep(1000);
		//move 2 months forward
		WebElement monthForward=webDriver.findElement(By.cssSelector(".bui-calendar__control--next > svg"));
		action.doubleClick(monthForward).perform();
		Thread.sleep(10000);
		
		//move one month back from current 
		webDriver.findElement(By.cssSelector(".bui-calendar__control--prev > svg"));
		
		//pick two dates
		
		List<WebElement> allDates = webDriver.findElements(By.tagName("td"));
		  //FROM this date
		  for(WebElement date1:allDates) {
			  String dateText=date1.getText();					
			  if (dateText.equals("28")){
				  date1.click();
				  break;
			  }
		  }
		  
		  //TO THIS DATE
		  for(WebElement date2:allDates) {
			  String dateText=date2.getText();					
			  if (dateText.equals("30")){
				  date2.click();
				  break;
			  }
		  }
		  
		Thread.sleep(4000);
		
		
	}
	
	@Test

	 void AdultOccupancy() throws InterruptedException {
		
	
		webDriver.findElement(By.cssSelector(".xp__guests__count > span:nth-child(1)")).click(); //occupancy
		Thread.sleep(1000);//sleep so it can load the chose tab
		//subtract one adult
		webDriver.findElement(By.xpath("//*[@id=\"xp__guests__inputs-container\"]/div/div/div[1]/div/div[2]/button[1]")).click();
		//add two adult
		WebElement addAdults = webDriver.findElement(By.xpath("//*[@id=\"xp__guests__inputs-container\"]/div/div/div[1]/div/div[2]/button[2]")); 
		action.doubleClick(addAdults).perform();
		Thread.sleep(1000);

}
	@Test

	 void ChildOccupancy() throws InterruptedException {
		
		webDriver.findElement(By.cssSelector(".xp__guests__count > span:nth-child(1)")).click(); //occupancy
		Thread.sleep(1000);//sleep so it can load the chose tab
		//add two children
		WebElement addChild=webDriver.findElement(By.xpath("//*[@id=\"xp__guests__inputs-container\"]/div/div/div[2]/div/div[2]/button[2]"));
		action.doubleClick(addChild).perform();
		//subtract one child
		 webDriver.findElement(By.xpath("//*[@id=\"xp__guests__inputs-container\"]/div/div/div[2]/div/div[2]/button[1]")).click();
		//enter their age in the field
		 Select age=new Select(webDriver.findElement(By.name("age")));
		 age.selectByValue("15");
//		 Select age2=new Select(webDriver.findElement(RelativeLocator.with(By.tagName("select")).toRightOf(webDriver.findElement(By.name("age")))));
//		 age2.selectByValue("17"); -- ako ima +1 child 
		
		Thread.sleep(1000);

}
	
	@Test

	void RoomOccupancy()throws InterruptedException {
		
		webDriver.findElement(By.cssSelector(".xp__guests__count > span:nth-child(1)")).click(); //occupancy
		Thread.sleep(1000);//sleep so it can load the chose tab
		//add two more rooms
		WebElement addRoom=webDriver.findElement(By.xpath("//*[@id=\"xp__guests__inputs-container\"]/div/div/div[4]/div/div[2]/button[2]"));
		action.doubleClick(addRoom).perform();
		//subtract one room
		webDriver.findElement(By.xpath("//*[@id=\"xp__guests__inputs-container\"]/div/div/div[4]/div/div[2]/button[1]")).click();
		Thread.sleep(1000);
	}
	
	@Test
	@Order(2)
	void searchButton()throws InterruptedException {
		
		webDriver.findElement(By.cssSelector("#frm > div.xp__fieldset.js--sb-fieldset.accommodation > div.xp__button > div.sb-searchbox-submit-col.-submit-button > button")).click();
		Thread.sleep(1000);
		
	}
	@Test
	@Order(3)
	void sortBy()throws InterruptedException {
		
		webDriver.findElement(By.xpath("//*[@id=\"search_results_table\"]/div[2]/div/div/div/div[2]/span/button/span[1]")).click();
		Thread.sleep(1000);
		webDriver.findElement(By.xpath("//span[contains(text(),'Stars (highest')]")).click();
		
	}
	@Test
	@Order(4)
	void budgetFilter()throws InterruptedException {
		
		webDriver.findElement(By.name("pri=3")).click();
		Thread.sleep(2000);
	}
	
	@Test
	@Order(5)
	void popularFilters()throws InterruptedException {
		
		webDriver.findElement(By.name("popular_activities=54")).click();
		Thread.sleep(1000);
		webDriver.findElement(By.name("hotelfacility=46")).click();
		Thread.sleep(2000);
		
	}
	
	@Test
	@Order(6)
	void distanceFilter()throws InterruptedException {
		
		webDriver.findElement(By.name("distance=5000")).click();
		Thread.sleep(2000);
		
	}
	
	@Test
	@Order(7)
	void propertyTypeFilter()throws InterruptedException {
		
		webDriver.findElement(By.name("privacy_type=3")).click();
		Thread.sleep(2000);
		webDriver.findElement(By.name("ht_id=201")).click();
		Thread.sleep(2000);
		webDriver.findElement(By.name("ht_id=204")).click();
		Thread.sleep(2000);

		
	}
	
	@Test
	@Order(8)
	void funFilter()throws InterruptedException {
		
		webDriver.findElement(By.name("popular_activities=103")).click();
		Thread.sleep(2000);
	}
	@Test
	@Order(9)
	void facilitiesFilter()throws InterruptedException {
		
		webDriver.findElement(By.name("hotelfacility=107")).click();
		Thread.sleep(2000);
		webDriver.findElement(By.name("hotelfacility=16")).click();
		Thread.sleep(2000);
		
	
	}
		
		
		

}
