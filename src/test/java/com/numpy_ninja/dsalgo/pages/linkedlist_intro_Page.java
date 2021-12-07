package com.numpy_ninja.dsalgo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class linkedlist_intro_Page
{
 
	WebDriver driver;
	public linkedlist_intro_Page(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	//logout link
	@FindBy(linkText="Sign out")
	WebElement link_signout;
	
	//Try Here button
	@FindBy(xpath="//a[@class='btn btn-info']")
	WebElement button_tryhere;
	
	//Practice questions
	@FindBy(linkText="Practice Questions")
	WebElement link_practicequestions;
	
	//Creating linked List on the side 
	@FindBy(xpath="//*[@id=\"content\"]/li[2]/a")
	WebElement link_createlist;
	
	//Method to click the logout button 
	public void click_Signout() throws InterruptedException
	{
		link_signout.click();
		Thread.sleep(1000);
	}
	
	//Method to click Try Here button
	public void click_Tryhere() throws InterruptedException
	{
		button_tryhere.click();
		Thread.sleep(1000);
	}
	
	//Method to click the practice questions link 
		public void click_practice_question() throws InterruptedException
		{
			link_practicequestions.click();
			Thread.sleep(1000);
		}
		
		//Method to click the Create Linked list
				public void click_createlinkedlist() throws InterruptedException
				{
					link_practicequestions.click();
					Thread.sleep(1000);
				}
	
}
