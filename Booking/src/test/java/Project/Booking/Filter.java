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

class Filter {
	private static WebDriver webDriver;
	private static String baseUrl;
	private static Actions action;


	@BeforeAll
	static void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\zarab\\Downloads\\chromedriver_win32\\chromedriver.exe");
		webDriver=new ChromeDriver();
		baseUrl="https://www.booking.com/searchresults.html?label=gen173nr-1FCAEoggI46AdIM1gEaBKIAQGYATG4ARfIAQzYAQHoAQH4AQKIAgGoAgO4As7anZ0GwAIB0gIkMjY5OGQ5NjYtMmRmMi00NTlkLTlmZmItOGRiYzkzYmExZjlm2AIF4AIB&sid=53671f12217b3948deb34c8606515412&sb=1&sb_lp=1&src=index&src_elem=sb&error_url=https%3A%2F%2Fwww.booking.com%2Findex.html%3Flabel%3Dgen173nr-1FCAEoggI46AdIM1gEaBKIAQGYATG4ARfIAQzYAQHoAQH4AQKIAgGoAgO4As7anZ0GwAIB0gIkMjY5OGQ5NjYtMmRmMi00NTlkLTlmZmItOGRiYzkzYmExZjlm2AIF4AIB%26sid%3D53671f12217b3948deb34c8606515412%26sb_price_type%3Dtotal%26%26&ss=Milan&is_ski_area=0&ssne=Neum&ssne_untouched=Neum&dest_id=-90058&dest_type=city&checkin_year=2023&checkin_month=1&checkin_monthday=4&checkout_year=2023&checkout_month=1&checkout_monthday=5&group_adults=2&group_children=0&no_rooms=1&b_h4u_keep_filters=&from_sf=1";
		action=new Actions(webDriver);
	}

	@AfterAll
	static void tearDown() {
		webDriver.quit();
	}
	
	
 
	@Test
	@Order(3)
	void sortBy()throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.manage().window().maximize();
		
		webDriver.findElement(By.xpath("//*[@id=\"search_results_table\"]/div[2]/div/div/div/div[2]/span/button/span[1]")).click();
		Thread.sleep(1000);
		webDriver.findElement(By.xpath("//span[contains(text(),'Stars (highest')]")).click();
		Thread.sleep(2000);
	
		Thread.sleep(2000);
		webDriver.findElement(By.id("filter-style-switch-pri")).click();
		Thread.sleep(2000);
		
		Thread.sleep(2000);

		webDriver.findElement(By.name("popular_activities=54")).click();
		Thread.sleep(3000);
		webDriver.findElement(By.name("hotelfacility=46")).click();
		Thread.sleep(4000);

		
		Thread.sleep(2000);

		webDriver.findElement(By.name("distance=5000")).click();
		Thread.sleep(2000);

		
		Thread.sleep(3000);
		webDriver.findElement(By.name("privacy_type=3")).click();
		Thread.sleep(3000);
		webDriver.findElement(By.name("ht_id=201")).click();

		
		Thread.sleep(2000);

		webDriver.findElement(By.name("popular_activities=103")).click();
		Thread.sleep(3000);


		
		webDriver.findElement(By.name("hotelfacility=107")).click();
		Thread.sleep(5000);
		webDriver.findElement(By.name("hotelfacility=16")).click();
		
		
	
	}
		
		
		

}
