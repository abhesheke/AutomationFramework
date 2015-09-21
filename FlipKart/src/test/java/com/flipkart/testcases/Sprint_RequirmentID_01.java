package com.flipkart.testcases;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

	@BeforeTest
	public void setup()
	{
		driver= new FirefoxDriver();
		seleniumUtil = new SeleniumUtil(driver);
	//	driver.get(sURL);
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
				driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click(); // login link
		driver.findElement(By.xpath("//*[@placeHolder='Enter email/mobile']")).sendKeys("arjun.abhesheke@compugain.com");
	//	driver.findElement(By.xpath("//*[@placeHolder='Enter password']")).sendKeys("deepthi");
		//Thread.sleep(5000);;
		//driver.findElement(By.xpath("//input[@value='Login']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//*[@placeHolder='Enter email/mobile']")).getAttribute("value"), "arjun.abhesheke@compugain.com");
		
	}
	
	
	public void highlight(WebElement element)
	{
		
			for (int i = 0; i < 2; i++) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript(
						"arguments[0].setAttribute('style', arguments[1]);",
						element, "color: red; border: 3px solid red;");
				js.executeScript(
						"arguments[0].setAttribute('style', arguments[1]);",
						element, "");
			}
		}
	
	//Frame
	//Alert
	//Pop-up
	@Test
	public void testAlertBox() throws InterruptedException
	{
		driver.get(sAlertBox);
		Thread.sleep(5000);
		driver.switchTo().frame(driver.findElement(By.id("iframeResult")));
		WebElement element = driver.findElement(By.xpath("//body/button"));
		for(int i=0;i<=10;i++){
		highlight(element);
		}
		element.click(); 
		Alert alert=driver.switchTo().alert(); // shift to alert
		alert.accept();
		driver.switchTo().defaultContent(); // 101 and 109 are linked
		System.out.println(driver.findElement(By.id("textareaCode")).getText());

	}
	
	@Test
	public void verifyPopUp() throws InterruptedException
	{
		driver.get("http://rip747.github.io/popupwindow/");
		driver.findElement(By.xpath("//dt[contains(text(),'Custom settings:')]/../dd/a[contains(text(),'Example 1')]")).click();
		Thread.sleep(5000);
		Set<String> a=driver.getWindowHandles();
			System.out.println("Size"+a.size());
			System.out.println(a);
			List< String> arrayList = new ArrayList<String>(a);
			for (int i = 0; i < arrayList.size(); i++) {
				System.out.println("---------"+arrayList.get(i));
			}
			System.out.println("Page Title"+driver.getTitle());
			
			WebDriver driver1=driver.switchTo().window(arrayList.get(1));
		System.out.println("@@@@"+driver1.findElement(By.xpath("//body")).getText());
	//	driver1.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES); // implicet wait
	}
	
}
