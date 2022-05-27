package com.vtiger.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.ClickAction;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreatecontactsforPropertyfile3Test {

	public static void main(String[] args) throws IOException {
	    FileInputStream fis= new FileInputStream("./src/test/resources/CommonData.Properties");
	    Properties property=new Properties();
	    property.load(fis);
		String url= property.getProperty("url");
         String userName = property.getProperty("userName");
          String password = property.getProperty("password");
          String browser = property.getProperty("browser");
          String timeout = property.getProperty("timeout");
          
          long longTimeout = Long.parseLong(timeout);
          WebDriver driver=null;
          
         // switch(browser) {
         // case "chrome":
        	//  WebDriverManager.chromedriver().setup();
        	 // driver=new ChromeDriver();
        	 // break;
         // case "Firefox":
        
         WebDriverManager.firefoxdriver().setup();
         driver=new FirefoxDriver();
         driver.get(url);
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(longTimeout,TimeUnit.SECONDS);
        
         driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin"); 
         driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
         driver.findElement(By.xpath("//input[@id='submitButton']")).click();
         
         //creating contacts
         driver.findElement(By.xpath("//a[.='Contacts']")).click();
         driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
         String lastname = "alex";
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("lastname");		
          String ActualLastName = driver.findElement(By.xpath("dtlview_Last Name")).getText();
        //driver.findElement(By.xpath("//input[@class='crmButton small save']")).click(); 
         //logout
        // driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
         
        	 
          }
		
			
		

	}


