package week4.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class chercher {
	public static void main(String[] args) {
		
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver=new ChromeDriver();
	driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	//WebElement iframe = driver.findElement(By.id("frame1"));
	 driver.switchTo().frame("frame1");
	 driver.findElement(By.xpath("//input")).sendKeys("jk");
	//WebElement iframe2 = driver.findElement(By.id("frame3"));
	 driver.switchTo().frame("frame3");
	 driver.findElement(By.xpath("//input[@id='a']")).click();
	 //WebElement iframe3 = driver.findElement(By.id("frame2"));
	 //driver.switchTo().frame("frame1");
	 driver.switchTo().defaultContent(); 
	 driver.switchTo().frame("frame2");
	 
	 Select frame4= new Select(driver.findElement(By.xpath("//select[@id='animals']")));
	 frame4.selectByValue("babycat");


}}
