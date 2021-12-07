package com.numpy_ninja.dsalgo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class home_Page {

	WebDriver driver;
	public home_Page(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	//Getstarted button under Linked list topic
	@FindBy(xpath="//a[contains(@href,'linked-list') and (@class='align-self-end btn btn-lg btn-block btn-primary')]")
	WebElement btn_linkedlist_getstarted;
	
	//Sign-In button 
	@FindBy(linkText="Sign in")
	WebElement link_signin;
	
	//Alert message for logout 
	@FindBy(xpath="//div[@role='alert']")
	WebElement logout_message;
	
	//Dropdown containing topics
	@FindBy(xpath="//a[@class='nav-link dropdown-toggle']")
	WebElement dropdown_topics;
	
	//Linked List element from dropdown
	@FindBy(linkText="Linked List")
	WebElement link_linkedlist;
	
	//method to click the sign-in button
	public void click_signin()
	{
		link_signin.click();
	}
	
	//method to click the Get Started button under Linked List topic
	public void click_linkedlist_getstarted()
	{
		btn_linkedlist_getstarted.click();
		
	}
	
	//method to capture the logout message 
	public String capture_logout_message()
	{
		String message = logout_message.getText();
		return message;
	}
	
	//method to select a topic from topics dropdown
	public void select_Topic() throws InterruptedException
	{
		dropdown_topics.click();
		Thread.sleep(1000);
		link_linkedlist.click();
	}
}
