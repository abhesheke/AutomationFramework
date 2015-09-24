package com.flipkart.utility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtil {
	WebDriver driver;
WebDriverWait driverWait;
	public SeleniumUtil(WebDriver driver)
	{
		System.out.println("this driver"+this.driver);
		System.out.println( "driver"+driver);

		this.driver = driver;
		
		System.out.println("After this driver"+this.driver);
		System.out.println( "After driver"+driver);
		driverWait = new WebDriverWait(driver,10);
	}

	
	public void enterText(String stext,String sobjectProperty)
	{
		List<WebElement>elements = driver.findElements(By.tagName("a"));
		for(int i=0;i<=elements.size();i++)
		{
			elements.get(i).click();
			driver.navigate().back();
			if(driver.findElement(By.xpath("//body")).getText().contains("404"))
			{
				
			}
		}
		
	}
	public void click(String sobjectProperty)
	{
		
		driver.findElement(By.xpath(sobjectProperty)).click();

	}
	
	
	
	public void get(String sURl) {
		driver.get(sURl);

	}

}
