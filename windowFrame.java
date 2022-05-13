package week4.day2.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class windowFrame {
public static void main(String[] args) throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("home")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList(windowHandles);
		driver.switchTo().window(windowHandlesList.get(1));
		driver.findElement(By.xpath("//a[@class='wp-categories-link maxheight']")).click();
		
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> windowHandlesList1 = new ArrayList(windowHandles1);
		driver.switchTo().window(windowHandlesList1.get(0));
		driver.findElement(By.xpath("//button[@id='color']")).click();
		
		Set<String> closewindowHandles = driver.getWindowHandles();
		List<String> closewindowHandlesList = new ArrayList(closewindowHandles);
//		String[] window=new String[5];
//		for (int i = 0; i < closewindowHandlesList.size(); i++) {
//			window[i]=closewindowHandlesList.get(i);
//			if(i!=closewindowHandlesList.size()-1){
//				driver.close();
//			}
//			
//		}
		driver.switchTo().window(closewindowHandlesList.get(1));
		driver.close();
		
		driver.switchTo().window(closewindowHandlesList.get(2));
		driver.close();
		driver.switchTo().window(closewindowHandlesList.get(3));
		driver.close();
		
		driver.switchTo().window(windowHandlesList1.get(0));
	
		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']"));
		Set<String> allWindowHandles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<String>(allWindowHandles);
		System.out.println("No. of opened windows: " + tabs.size());
		
		driver.findElement(By.xpath("(//button[@id='color'])[2]")).click();
		Thread.sleep(3000);
		
		
		
}}
