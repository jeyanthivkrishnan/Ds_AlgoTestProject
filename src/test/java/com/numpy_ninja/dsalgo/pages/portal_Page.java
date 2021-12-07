package com.numpy_ninja.dsalgo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class portal_Page
{
	WebDriver driver;
	public portal_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	} 
	
	//Get Started button
	@FindBy(className="btn")
	WebElement button_getstarted;
	
	//Method to click Get Started button
	public void click_Getstarted()
	{
		button_getstarted.click();
		
	}
	
}
