package com.numpy_ninja.dsalgo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class login_Page {
	

	WebDriver driver;
	public login_Page(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	//Username textbox
	@FindBy(name="username")
	WebElement textbox_username;
	
	//password textbox
	@FindBy(name="password")
	WebElement textbox_password;
	
	//login button
	@FindBy(xpath="//input[ @type='submit']")
	WebElement login_btn;
	
	//method to enter username and password
	public void enter_username_password(String username , String password) throws InterruptedException
	{
		textbox_username.sendKeys(username);
		Thread.sleep(1000);
		textbox_password.sendKeys(password);
		Thread.sleep(1000);
	}
	
	//method to click login
	public void click_login()
	{
		login_btn.click();
	}

}
