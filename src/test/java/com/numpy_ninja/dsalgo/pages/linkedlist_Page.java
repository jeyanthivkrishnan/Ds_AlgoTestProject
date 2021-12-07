package com.numpy_ninja.dsalgo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class linkedlist_Page
{


	WebDriver driver;
	//constructor
	public linkedlist_Page(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	//signout link
	@FindBy(linkText="Sign out")
    WebElement link_signout;
	
	//Introduction link
	@FindBy(linkText="Introduction")
	WebElement link_introduction;
	
	//Creating Linked list link
	@FindBy(linkText="Creating Linked LIst")
	WebElement link_create;
	
	//Types of Linked list link
	@FindBy(linkText="Types of Linked List")
	WebElement link_types;
	
	//Implement Linked List in Python link
	@FindBy(linkText="Implement Linked List in Python")
	WebElement link_implementinpython;
	
	
	//Traversal link
	@FindBy(linkText="Traversal")
	WebElement link_traversal;
	
	//Insertion link
	@FindBy(linkText="Insertion")
	WebElement link_insertion;
	
	//Insertion link
	@FindBy(linkText="Deletion")
	WebElement link_deletion;
	
	//Method to click the sign out link
	public void click_Signout() throws InterruptedException
	{
		link_signout.click();
		Thread.sleep(2000);
	}
	
	//Method to click the introduction link
	public void click_introduction() throws InterruptedException
	{
		link_introduction.click();
		Thread.sleep(2000);
	}
	
	//Method to click the Creating linked list page link
	public void click_linkedlist_create() throws InterruptedException
	{
		link_create.click();
		Thread.sleep(2000);
	}
	
	//Method to click the Types of linked list link
	public void click_linkedlist_types() throws InterruptedException
	{
		link_types.click();
		Thread.sleep(2000);
	}
	

	//Method to click Implement Linked List in Python link
	public void click_linkedlist_implementpython() throws InterruptedException
	{
		link_implementinpython.click();
		Thread.sleep(2000);
	}
	
	//Method to click Traversal link
	public void click_Traversal() throws InterruptedException
	{
		link_traversal.click();
		Thread.sleep(2000);
	}
	
	//Method to click Insertion link
	public void click_Insertion() throws InterruptedException
	{
		link_insertion.click();
		Thread.sleep(2000);
	}
	
	//Method to click Deletion link 
	public void click_Deletion() throws InterruptedException
	{
		link_deletion.click();
		Thread.sleep(2000);
	}
	
	
	
}
