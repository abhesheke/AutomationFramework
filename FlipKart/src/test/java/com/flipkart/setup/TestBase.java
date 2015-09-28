package com.flipkart.setup;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase implements Setup
{

	public  String getFilePath(String sFilepath) {
		char cforwardslash = (char) 47;
		char cbackslash = (char) 92;
		String sPath = System.getProperty("user.dir").replace(cbackslash,
				cforwardslash)
				+ sFilepath;

		File file = new File(sPath);
		if (file.exists()) {
			sPath = file.getAbsolutePath();
			System.out.println("The File Path is " + sPath);
		} else {
			System.out.println("File not Found");
		}
		return sPath;
	}
	
	public WebDriver initializeDriver(String sbrowser) {
		WebDriver driver = null;
		if (sbrowser.equalsIgnoreCase("FF")) {
			driver = new FirefoxDriver();
		}
		if (sbrowser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", getFilePath(CHROMEDRIVER));
			driver = new ChromeDriver();
		} else {

		}
		return driver;

	}
}
