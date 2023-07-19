package org.Ecommerce;


import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class flipkartLogin {
	@Test
	public void LoginPage()
	{
	WebDriverManager.firefoxdriver().setup();
	WebDriver driver = new FirefoxDriver();
	driver.get("https://www.flipkart.com/");
	driver.manage().window().maximize();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	WebElement closePopup= driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
	//closePopup.click();
	if(closePopup != null) {
		closePopup.click();
	}
	
	//driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']")).sendKeys("9096699691");
	//driver.findElement(By.xpath("//div/button[@class='_2KpZ6l _2HKlqd _3AWRsL']")).click();
	//after click otp-661319
	
	WebElement srchBx = driver.findElement(By.xpath("//input[@title='Search for products, brands and more']"));
	
	if(srchBx == null)
		srchBx = driver.findElement(By.xpath("//div/input[@class='_3704LK']"));
	
	srchBx.sendKeys("samsung 5g mobile");
	
	driver.findElement(By.cssSelector("input[class='_3704LK']")).sendKeys(Keys.ENTER);
	Actions act = new Actions(driver);
	
	WebElement mobilePhone = driver.findElement(By.xpath("(//div[@class='_4rR01T'])[1]"));
	act.moveToElement(mobilePhone);
	mobilePhone.click();
	
	String parentWindow = driver.getWindowHandle();
	Set<String> windowsList = driver.getWindowHandles();
	Iterator<String> itr = windowsList.iterator();
	
	String childwindow="";
	while(itr.hasNext()) {
		childwindow = itr.next();
		
		if(!parentWindow.equalsIgnoreCase(childwindow))
		{
			driver.switchTo().window(childwindow);
			break;
		}		
	}
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

	WebElement btnAddToCart = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']"));
	
	act = new Actions(driver);
	act.moveToElement(btnAddToCart).click().build().perform();
	
	if(btnAddToCart != null)
		System.out.println("Add To Cart Button");
	
	//btnAddToCart.click();
	
	//driver.findElement(By.cssSelector("button[class='_2KpZ6l _2U9uOA _3v1-ww']")).click();
	
	driver.findElement(By.xpath("(//div[@class='_3dsJAO'])[2]")).click();
	 driver.findElement(By.xpath("(//div[@class='exehdJ'])[1]")).click();
	
	WebElement logOut = driver.findElement(By.xpath("//div[@class='exehdJ']"));		//logout
	logOut.click();
	driver.findElement(By.xpath("//*[text()='Logout']")).click();
		
	
	driver.close();
	
	
	}
		
	
}
