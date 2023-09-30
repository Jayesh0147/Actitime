package com.ActiTime.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	//decleration
	@FindBy(xpath = "//div[.='Tasks']")
	private WebElement tasktab;
	
	@FindBy(xpath = "//div[.='Reports']")
	private WebElement reportab ;
	
	@FindBy(id = "//div[.='Users']")
	private WebElement usertab;
	
	@FindBy(id = "logoutLink")
	private WebElement logoutlink;
	
	//initilization
	public HomePage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getTasktab() {
		return tasktab;
	}

	public WebElement getReportab() {
		return reportab;
	}

	public WebElement getUsertab() {
		return usertab;
	}

	public WebElement getLogoutlink() {
		return logoutlink;
	}
	
	
	
}
