package com.Actime.TestScript;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ActiTime.GenricLibrary.Baseclass;
import com.ActiTime.GenricLibrary.fileLibrary;
import com.ActiTime.Pom.HomePage;
import com.ActiTime.Pom.TaskPage;

//@Listeners(Listnerimplmentation.class)
public class CreateCustomer extends Baseclass{
	

	@Test
	public void createCustomer() throws EncryptedDocumentException, IOException, InterruptedException {
HomePage hp=new HomePage(driver);

hp.getTasktab().click();

TaskPage tp= new TaskPage(driver);
tp.getAddnewcust().click();
tp.getNewcust().click();
fileLibrary f=new fileLibrary();
String name= f.readDataFromExcel("Sheet1", 2, 1);

tp.getCustname().sendKeys(name);
String desp  = f.readDataFromExcel("Sheet1", 2, 2);
tp.getCustdesc().sendKeys(desp);
tp.getCreatecust().click();

String expectedresult = name;
String actualresult = driver.findElement(By.xpath("(//div[.='"+name+"'])[2]")).getText();
SoftAssert s= new SoftAssert();
s.assertEquals(expectedresult, actualresult);
s.assertAll();

	}
	}







