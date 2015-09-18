package com.flipkart.testcases;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.flipkart.setup.Setup;
import com.flipkart.utility.SeleniumUtil;

public class Sprint_RequirmentID_01 implements Setup{
	WebDriver driver;
	SeleniumUtil seleniumUtil;

//	@BeforeTest
	public void setup()
	{
		driver= new FirefoxDriver();
		seleniumUtil = new SeleniumUtil(driver);
		driver.get(sURL);
	}
	
	@Test
	public void TC_01()
	{
		driver.findElement(By.name("q")).sendKeys("roadster");
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		String expected=driver.findElement(By.xpath("//span[contains(text(),'Rs. 849')]")).getText();
		System.out.println("expected Result"+expected);
		Assert.assertEquals("Rs. 849", expected);
		
	}
	@Test
	public void TC_02() throws InterruptedException
	{
		driver.findElement(By.name("q")).sendKeys("laptops");
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Dell')]")).click();
		Thread.sleep(5000);
		
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='pu-final']/span[contains(text(),'Rs')]"));
		System.out.println("elements size"+elements.size());
		LinkedList<Integer> integers = new LinkedList<Integer>();

		for (int i = 0; i < elements.size()-1; i++) {
			
			int j=Integer.parseInt(elements.get(i).getText().replace("," ,"").replace("Rs.", "").trim());
			if(j>29999){
				System.out.println("The price ---->"+j);
			integers.add(j);
			}
		}
		Assert.assertEquals(true, integers.size()>9);
		

		
	}
	@Test
	public void login() throws InterruptedException
	{
		driver= new FirefoxDriver();
		seleniumUtil = new SeleniumUtil(driver);
		driver.get(sURL);
		driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click(); // login link
		driver.findElement(By.xpath("//*[@placeHolder='Enter email/mobile']")).sendKeys("9004633688");
		driver.findElement(By.xpath("//*[@placeHolder='Enter password']")).sendKeys("deepthi");
		Thread.sleep(5000);;
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
	}
	
	
	
}
