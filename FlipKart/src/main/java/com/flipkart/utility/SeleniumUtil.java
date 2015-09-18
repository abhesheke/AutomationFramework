package com.flipkart.utility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumUtil {
	WebDriver driver;

	public SeleniumUtil(WebDriver driver)
	{
		System.out.println("this driver"+this.driver);
		System.out.println( "driver"+driver);

		this.driver = driver;
		
		System.out.println("After this driver"+this.driver);
		System.out.println( "After driver"+driver);
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
