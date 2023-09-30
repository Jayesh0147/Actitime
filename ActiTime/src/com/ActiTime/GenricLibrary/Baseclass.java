package com.ActiTime.GenricLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.ActiTime.Pom.LoginPage;

public class Baseclass {
fileLibrary f= new fileLibrary();
public	static WebDriver driver;


@BeforeSuite
public void databasecoonectToDatabase() {
	Reporter.log("database connected",true);
} 
@BeforeClass
public void launcBrowser() throws IOException {
	
	 driver=new ChromeDriver();
	 driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	String Link = f.readDataFromPropertyFile("url");
	driver.get(Link);
	//driver.get("https://demo.actitime.com/login.do");
	Reporter.log("browser launched successfully",true);
}

@BeforeMethod
public void loginToActitime() throws IOException {
	
	LoginPage lp= new LoginPage(driver);
	String un =f.readDataFromPropertyFile("username");
	lp.getUntbx().sendKeys(un);
	String pw = f.readDataFromPropertyFile("password");
	lp.getPwtbx().sendKeys(pw);
	lp.getLgbtn().click();

	Reporter.log("logged in successfully",true);

	
	//driver.findElement(By.id("username")).sendKeys("admin");
	//driver.findElement(By.name("pwd")).sendKeys("manager");
	//driver.findElement(By.xpath("//div[.='Login ']")).click();
	//Reporter.log("logged in successfully",true);	
}
@AfterMethod
public void logoutFromActitime() {
	driver.findElement(By.id("logoutLink"));
	Reporter.log("Logged out successfully",true);
	
}
@AfterClass
public void closeBrowser() {
	driver.close();
	Reporter.log("Browser closed successfully",true);
	
}
@AfterSuite
public void closedatabaseConnection() {
	Reporter.log("database disconnected",true);
}

}