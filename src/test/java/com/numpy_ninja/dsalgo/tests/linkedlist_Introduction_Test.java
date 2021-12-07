package com.numpy_ninja.dsalgo.tests;
import org.testng.annotations.Test;

import com.numpy_ninja.utils.XLutils;
import com.numpy_ninja.utils.data_Textfile;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import com.numpy_ninja.dsalgo.pages.*;

public class linkedlist_Introduction_Test extends base{
	//WebDriver driver;
	portal_Page portal;
	home_Page home;
	login_Page login;
	linkedlist_Page list;
	linkedlist_intro_Page list_intro;
	tryeditor_Page editor;
	String file = dsalgo_config.file;
	String excelpath = dsalgo_config.excelpath;
	

	@BeforeTest()
	public void beforetest()
	{
		base.initialize_driver();
	}
	
	
	
	/*
	 * @Parameters("browsername")
	 * 
	 * @BeforeTest public void beforeTest(String browsername) {
	 * 
	 * if (browsername.equalsIgnoreCase("chrome")) {
	 * System.setProperty("webdriver.chrome.driver",
	 * ".\\Drivers\\chromedriver.exe"); driver= new ChromeDriver();
	 * driver.manage().window().maximize(); driver.get(dsalgo_config.url); } else
	 * if(browsername.equalsIgnoreCase("firefox")) {
	 * System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver.exe");
	 * driver= new FirefoxDriver(); driver.manage().window().maximize();
	 * driver.get(dsalgo_config.url); }
	 * 
	 * }
	 */
	 
  @Test(priority=1)
  //Test to Validate if user is able to launch Ds-algo Home page
  public void linkedlist_Introduction_testcase1() throws InterruptedException 
  {
	  Reporter.log("Test to Validate if user is able to launch Ds-algo Home page:");
	  portal = new portal_Page(driver);
	  portal.click_Getstarted();
	  Thread.sleep(2000);
	  String expected_title = "NumpyNinja";
	  Assert.assertEquals(driver.getTitle(), expected_title);
	  Reporter.log("User successfully navigated to home page");
  }
  
  @Test(dataProvider="logindata",priority=2)
  //Test to Validate if user is able to login and launch the Linked List page by clicking GET STARTED button
  public void linkedlist_Introduction_testcase2(String username,String password) throws InterruptedException 
  {
	  Reporter.log("Test to Validate if user is able to login and launch the Linked List page by clicking GET STARTED button:");
		/*
		 * String username = "jeyanthiv"; String password = "dsalgo123#";
		 */
	  home = new home_Page(driver);
	  home.click_signin();	;
	  String expected_title ="Login";
	  Assert.assertEquals(driver.getTitle(), expected_title);
	  Reporter.log("User successfully navigated to Login Page");
	  login = new login_Page(driver);
	  login.enter_username_password(username,password);
	  Thread.sleep(1000);
	  login.click_login();
	  Reporter.log("Login Button clicked successfully");
	  Thread.sleep(2000); 
      home.click_linkedlist_getstarted();
      Reporter.log("Get Started button clicked successfully");
      Thread.sleep(2000);
      String Expected_title1 = "Linked List";
      Assert.assertEquals(driver.getTitle(), Expected_title1);
      Reporter.log("User successfully navigated to Linked List Page by clicking Get Started Button");
 
  }
     
  @Test (priority=3)
  //test to validate if user is able to launch the Introduction page from linked list
  public void linkedlist_Introduction_testcase3() throws InterruptedException
  {
	  Reporter.log("Test to validate if user is able to launch the Introduction page from linked list");
	  list = new linkedlist_Page(driver);
	  list.click_introduction();
	  Reporter.log("Introduction link clicked successfully");
	  String Expected_Title ="Introduction";
	  Assert.assertEquals(driver.getTitle(), Expected_Title);
	  Reporter.log("User successfully navigated to Linked List Introduction page.");
	  Thread.sleep(2000);
  }
  
  
  @Test(priority=4)
  public void linkedlist_Introduction_testcase4() throws InterruptedException
  {
	  list.click_linkedlist_create();
	  String Expected_Title ="Creating Linked LIst";
	  Assert.assertEquals(driver.getTitle(), Expected_Title);
	  Reporter.log("User successfully navigated to Creating Linked List page from Introduction page.");
	  driver.navigate().back();
  }
   
  @Test(priority=5)
  //Test to validate if user able to launch Try Editor Page 
  public void linkedlist_Introduction_testcase5() throws InterruptedException
  {
	  Reporter.log("Test to validate if user able to launch Try Editor Page");
	  list_intro= new linkedlist_intro_Page(driver); 
	  list_intro.click_Tryhere();
	  Reporter.log("Try Here Button clicked successfully");
	  String Expected_Title ="Assessment";
	  Assert.assertEquals(driver.getTitle(), Expected_Title);
	  Reporter.log("User successfully navigated to Editor Page/Assessment page.");
  } 
  
  @Test (priority=6)
  //Test to validate if alert popped if user tries to run without enterig code
  public void linkedlist_Introduction_testcase6() throws InterruptedException
  {
	  Reporter.log("Test to validate if alert popped if user tries to run without enterig code");
	  editor = new tryeditor_Page(driver);
	  Thread.sleep(1000);
	  editor.click_run();
	  Reporter.log("Run Button clicked successfully");
	  Thread.sleep(2000);
	  boolean expected_output = true;
	  editor.check_alert();
	  Assert.assertEquals(editor.check_output()	, expected_output); 
	  Reporter.log("Alert is popped successfully");
  }
  
  
  @Test (priority=7)
  //Test to validate if user able to enter valid code , click Run and see the output
  public void linkedlist_Introduction_testcase7() throws InterruptedException, IOException
  {
	  Reporter.log("Test to validate if user able to enter valid code , click Run and see the output");
	  editor = new tryeditor_Page(driver);
	  Thread.sleep(1000);
	  String code = data_Textfile.readFile(file);
	  editor.write_code_tryeditor(code);
	  Thread.sleep(2000);
	  Reporter.log("Code is written successfully in the editor form");
	  editor.click_run();
	  Reporter.log("Run Button clicked successfully");
	  Thread.sleep(2000);
	  boolean expected_output = true;
	  editor.check_alert();
	  Assert.assertEquals(editor.check_output()	, expected_output); 
	  Reporter.log("Output for the code is displayed successfully");
  }
  
   
  
  
  @Test (priority=8)
  //Test to validate if alert is popped when user tries to run invalid code
  public void linkedlist_Introduction_testcase8() throws InterruptedException
  {
	  Reporter.log("Test to validate if alert is popped when user tries to run invalid code");
	  editor = new tryeditor_Page(driver);
	  Thread.sleep(1000);
	  String invalidcode = "print(Hello World)";
	  editor.write_code_tryeditor(invalidcode);
	  Thread.sleep(2000);
	  Reporter.log("Code is written successfully in the editor form");
	  editor.click_run();
	  Reporter.log("Run Button clicked successfully");
	  Thread.sleep(2000);
	 // editor.check_alert();
	  boolean expected_output = true;
	  boolean actual_output = editor.check_alert();
	  Assert.assertEquals(actual_output, expected_output); 
	  Reporter.log("Alert is popped successfully");
  }
  
  
  @Test(priority=9)
  //Test to validate if user able to launch Practice questions Page
  public void linkedlist_Introduction_testcase9() throws InterruptedException
  {
	  driver.navigate().back();
	  list_intro.click_practice_question();
	  String Expected_Title ="Practice Questions";
	  Assert.assertEquals(driver.getTitle(), Expected_Title);
	  Reporter.log("User successfully navigated to Practice questions Page.");
	  driver.navigate().back();
  }
  
  
  @Test(priority=10)
  //test to validate if user is able to logout from Linked List Introduction page
	public void linkedlist_Introduction_testcase10() throws InterruptedException
	{
	  	Reporter.log("Test to validate if user is able to logout from Linked List introduction page:");
		//list = new linkedlist_Page(driver);
	  	Reporter.log("Navigating back to Introduction page");
	  	driver.navigate().back();
	  	Thread.sleep(2000);
	  	list_intro.click_Signout();
		String expected_message ="Logged out successfully";
		String actual_message=home.capture_logout_message();
		Assert.assertEquals(actual_message, expected_message);
		Reporter.log("User is logged out Successfully from Linked List Introduction Page");
	}
  
  
	
  
  
  @AfterTest
  public void afterTest() 
  {
	  driver.close();
	  driver.quit();
  }


  @DataProvider(name="logindata")
  public String[][] getdata() throws IOException
  {
	  	String projectpath = System.getProperty("user.dir");
	//  	System.out.println(projectpath);
		String excelpath = projectpath+"//Testdata/Ds-AlgoTestData.xlsx";
		String sheetname = "Sheet1";
		
		int noofrows = XLutils.getrowcount(excelpath, sheetname);
		int noofcolumns = XLutils.getcellcount(excelpath, sheetname, 0);
		///System.out.println("No of rows:"+noofrows);
		//System.out.println("No of columns:"+noofcolumns);
	
	String logindata[][] =new  String[noofrows][noofcolumns];
	for (int i=1;i<=noofrows;i++)
	{
		for (int j=0;j<noofcolumns;j++)
		{
			logindata[i-1][j] =XLutils.getcelldata(excelpath, sheetname, i, j);
	        // System.out.println("data"+i+j);
	         	         
		}
	}	
	
	return (logindata);
  }
  	
  
   
  
}
