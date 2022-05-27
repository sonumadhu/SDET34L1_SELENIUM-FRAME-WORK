package com.vtiger.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganiZation7Test {

	public static void main(String[] args) throws SQLException {
		String username=null;
		String password=null;
		String organizationaName=null;
		Connection connection=null;
		
		try{
			Driver d = new Driver();
		
		DriverManager.registerDriver(d);
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vtiger","root","root");
		Statement statement = connection.createStatement();
		ResultSet result= statement.executeQuery("select * from vtiger_data");
		
		while(result.next())
		{
		 username = result.getString("user_name");
		 password = result.getString("password");
		 organizationaName = result.getString("organization_name");
		}
		}
		
		finally {
			connection.close();
		}
		
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.get("http://localhost:8888");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(organizationaName);
		driver.findElement(By.xpath("//input[@accesskey='S']")).click();
		WebElement ele= driver.findElement(By.xpath("//td[@id='mouseArea_Organization Name']"));
		String text= ele.getText();
		System.out.println(text);
		if(text.contains(organizationaName))
		{
			System.out.println(text);
		}
		else {
			System.out.println("not present");
		}
		WebElement ele1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(ele1).perform();
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		driver.close();


	}

}
