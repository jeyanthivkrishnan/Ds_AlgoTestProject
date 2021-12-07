package com.numpy_ninja.dsalgo.pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class base {

 public static WebDriver driver;
	 
 	String folderpath =dsalgo_config.folderpath;
 
	 public static void initialize_driver()
	 {
		  System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get(dsalgo_config.url);
	 }
	 
	
	  String filepath = folderpath;
	  
	 //Method to capture screenshots under screenshots folder. 
	 public void failed(String methodName) 
	 {
       	 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            
               try {
   				FileUtils.copyFile(scrFile, new File(filepath+methodName+".png"));
   			} catch (IOException e) { 
   				e.printStackTrace();
   			}
	
}
	
	
}
