package week4.day2.assignments;

import static org.testng.Assert.assertEquals;


import java.io.File;


import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Amazon {
	

	public static void main(String[] args) throws IOException, InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro",Keys.ENTER);
		String price= driver.findElement(By.xpath("//div[@class='a-row a-size-base a-color-base']//a//span[@class='a-price-whole']")).getText();
		System.out.println("One Plus 9 Pro price is: "+price);
		String rating= driver.findElement(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style']//span[@class='a-size-base s-underline-text']")).getText();
		System.out.println("Customer rating is: "+rating);
		driver.findElement(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']")).click();
		File sourceimage = driver.findElement(By.xpath("(//img)[16]")).getScreenshotAs(OutputType.FILE);
		File finalimage = new File("./jk/IMG2.png");
		FileUtils.copyFile(sourceimage, finalimage);
		System.out.println("File captured");
		
		Set<String> allWindowHandles = driver. getWindowHandles();
		 List<String> windowHandleList=new ArrayList<>(allWindowHandles);   // convert to list bcz set doesnt have get()
		 driver.switchTo().window(windowHandleList.get(1));
		
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		
		Thread.sleep(3000);
		String tect= driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']")).getText();
		System.out.println(tect);
		
		if((price).equals(tect)) {
			System.out.println("Cart total is verified");
		}
		
		
		
}}
