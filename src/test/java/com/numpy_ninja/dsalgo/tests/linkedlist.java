package com.numpy_ninja.dsalgo.tests;
import org.testng.annotations.Test;
import com.numpy_ninja.utils.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import java.io.IOException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import com.numpy_ninja.dsalgo.pages.*;

@Listeners(com.numpy_ninja.dsalgo.listeners.test_Listeners.class)
public class linkedlist extends base {
	// WebDriver driver;
	portal_Page portal;
	home_Page home;
	login_Page login;
	linkedlist_Page list;
	String excelpath = dsalgo_config.excelpath;

	@BeforeTest()
	public void beforetest() {
		base.initialize_driver();
	}

	@Test
	// Test to Validate if user is able to launch Ds-algo Home page
	public void linkedlist_testcase1() throws InterruptedException {
		Reporter.log("Test to Validate if user is able to launch Ds-algo Home page:");
		portal = new portal_Page(driver);
		portal.click_Getstarted();
		Thread.sleep(2000);
		String expected_title = "NumpyNinja";
		Assert.assertEquals(driver.getTitle(), expected_title);
		Reporter.log("User successfully navigated to home page");
	}

	@Test(dataProvider = "logindata")
	// Test to Validate if user is able to login and launch the Linked List page by
	// clicking GET STARTED button
	public void linkedlist_testcase2(String username, String password) throws InterruptedException {
		Reporter.log(
				"Test to Validate if user is able to login and launch the Linked List page by clicking GET STARTED button:");
		home = new home_Page(driver);
		home.click_signin();
		String expected_title = "Login";
		Assert.assertEquals(driver.getTitle(), expected_title);
		Reporter.log("User successfully navigated to Login Page");
		login = new login_Page(driver);
		login.enter_username_password(username, password);
		Thread.sleep(1000);
		login.click_login();
		Reporter.log("Login Button clicked successfully");
		Thread.sleep(5000);
		home.click_linkedlist_getstarted();
		Reporter.log("Get Started button clicked successfully");
		Thread.sleep(2000);
		String Expected_title1 = "Linked List";
		Assert.assertEquals(driver.getTitle(), Expected_title1);
		Reporter.log("User successfully navigated to Linked List Page by clicking Get Started Button");

	}

	@Test
	// Test to Validate if user is able to login and launch the Linked List page by
	// selecting the topic from dropdown
	public void linkedlist_testcase3() throws InterruptedException {

		Reporter.log(
				"Test to Validate if user is able to login and launch the Linked List page by selecting the topic from dropdown:");
		driver.navigate().back();
		home.select_Topic();
		Reporter.log("Linked list topic successfully selected from dropdown");
		Thread.sleep(2000);
		String Expected_title1 = "Linked List";
		Assert.assertEquals(driver.getTitle(), Expected_title1);
		Reporter.log("User successfully navigated to Linked List Page by selecting from dropdown");

	}

	@Test
	// test to validate if user is able to logout from Linked List page
	public void linkedlist_testcase4() throws InterruptedException {
		Reporter.log("Test to validate if user is able to logout from Linked List page:");
		list = new linkedlist_Page(driver);
		list.click_Signout();
		String expected_message = "Logged out successfully";
		String actual_message = home.capture_logout_message();
		Assert.assertTrue(false);
		Assert.assertEquals(actual_message, expected_message);
		Reporter.log("User is logged out Successfully");
	}

	@DataProvider(name = "logindata")
	public String[][] getdata() throws IOException {

		String sheetname = "Sheet1";

		int noofrows = XLutils.getrowcount(excelpath, sheetname);
		int noofcolumns = XLutils.getcellcount(excelpath, sheetname, 0);

		String logindata[][] = new String[noofrows][noofcolumns];
		for (int i = 1; i <= noofrows; i++) {
			for (int j = 0; j < noofcolumns; j++) {
				logindata[i - 1][j] = XLutils.getcelldata(excelpath, sheetname, i, j);

			}
		}

		return (logindata);
	}

	@AfterTest
	public void afterTest() {
		driver.close();
		driver.quit();
	}

}
