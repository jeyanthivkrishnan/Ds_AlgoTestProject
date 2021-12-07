package com.numpy_ninja.dsalgo.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class tryeditor_Page {

	 WebDriver driver;
	public tryeditor_Page(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	//code area form
	//
	//@FindBy(xpath="*//div[@class='CodeMirror-code']//pre [@class=' CodeMirror-line ']")
	//@FindBy(xpath="//div[@class='container']//div[@class='code-area']//form[@id='answer_form']//div[@class='CodeMirror cm-s-default']//div[@class='CodeMirror-scroll']//div[@class='CodeMirror-sizer']//div[@class='CodeMirror-lines']//div[@class='CodeMirror-code']//pre [@class=' CodeMirror-line ']")
//	//@FindBy(xpath="/html/body/div/div/form/div/div/div[6]/div[1]/div/div/div/div[5]/div/pre/span")
	//@FindBy(css="#answer_form > div > div > div.CodeMirror-scroll > div.CodeMirror-sizer > div > div > div > div.CodeMirror-code")
	//List <WebElement> form_codearea;
	//WebElement form_codearea;
	// codemirror element 
	/*
	 * @FindBy(className="CodeMirror") WebElement textarea_codemirror;
	 * 
	 * //CodeLine Element
	 * 
	 * @FindBy({@FindBy(className="CodeMirror-line.get(0)")}) WebElement
	 * textarealine_codeline;
	 */
	  
	//WebElement
	//@FindBy(css ="div.CodeMirror cm-s-default")
	@FindBy(css ="textarea")
	WebElement textarea;
	 
	//Run button
	@FindBy(xpath="//button[@type='button']")
	WebElement button_run;

	//Output 
	@FindBy(id="output")
	WebElement txtarea_output;
	
	

	//method to click the run button
	public void click_run()
	{
		button_run.click();
	}
	
	//Method to check if output is displayed
	public boolean check_output()
	{
		Boolean output = txtarea_output.isDisplayed();
		return output;
	}
	
	//Method to catch if alert is displayed
	public Boolean check_alert() 
	{
		//Boolean output;
//		String alert_msg =driver.switchTo().alert().getText();
//		if (alert_msg.length()> 0)
//			output = true;
//		else output = false;
		
		/*
		 * Alert alert = driver.switchTo().alert().accept(); alert.accept(); String
		 * alert_msg = alert.getText(); if (alert_msg.length()> 0) output = true; else
		 * output = false;
		 */
		
		//return output;
		try {
		Alert alert = driver.switchTo().alert();
		alert.accept();
		return true;
		}
		catch (NoAlertPresentException e)
		{
		return false;
		}

	}
	
	
	  public void  write_code_tryeditor(String code) throws InterruptedException
	  {
		 
		  WebElement codeMirror = driver.findElement(By.className("CodeMirror"));

		  /* getting the first line of code inside codemirror and clicking it to bring it in focus */
		  WebElement codeLine = codeMirror.findElements(By.className("CodeMirror-line")).get(0);
		  codeLine.click();
	  
		  /* sending keystokes to textarea once codemirror is in focus */
		  WebElement txtbx = codeMirror.findElement(By.cssSelector("textarea"));
		 // txtbx.clear();
		  txtbx.sendKeys(code);
		  Thread.sleep(3000);
	  }
	
	
	
}
