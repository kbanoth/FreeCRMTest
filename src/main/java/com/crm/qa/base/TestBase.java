package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
	  static WebDriver  driver;
	  static Properties prop;
	
	
	public TestBase() {
		try {
		FileInputStream ip=new FileInputStream("C:\\selenium_webdriver\\FreeCRMTest\\src\\main\\java\\"
				+ "com\\crm\\qa\\config\\config.properties");
		prop.load(ip);
		
		}catch(FileNotFoundException fnf) {
		
			fnf.printStackTrace();
	}catch (IOException e) {
		e.printStackTrace();
	}
			
			
	}
	public void initialization() {
		String browsweName=prop.getProperty("brower");
		if(browsweName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
			driver =new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
		}
	}
}


