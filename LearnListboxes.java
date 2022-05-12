package week4.day2.assignments;

import java.util.List;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnListboxes {
	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Select index=new Select(driver.findElement(By.id("dropdown1")));
		index.selectByIndex(1);
		Select text=new Select(driver.findElement(By.name("dropdown2")));
		text.selectByVisibleText("Selenium");
		Select value=new Select(driver.findElement(By.id("dropdown3")));
		value.selectByValue("1");
		Select count = new Select(driver.findElement(By.xpath("//Select[@class='dropdown']")));
		List<WebElement> cc=count.getOptions();
		System.out.println("The number of dropdown options are "+cc.size());
		driver.findElement(By.xpath("(//div[@class='example']/select/option[@value=1])[5]")).click();
		driver.findElement(By.xpath("(//div[@class='example']/select/option[@value=1])[6]")).click();
		
		
		
		

}}
