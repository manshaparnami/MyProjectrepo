package com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCommands {
	 WebDriver driver;
	 String returnvalue;
	 
	  public String readconfig(String value) throws IOException{
		  File configFile = new File("config.properties");
		   	 InputStream inputStream = new FileInputStream(configFile);
		   	 Properties props = new Properties();
		   	 props.load(inputStream);
		   returnvalue = props.getProperty(value);
		   System.out.println("file return value is "+returnvalue);
		   return returnvalue;
	  }

	    // Webdriver initialisation
	    public void initWebdriver() throws IOException {
	   
	 if(returnvalue.equalsIgnoreCase("Chrome")) {
		 System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
     driver = new ChromeDriver();
	 }
	        
	    }
	    // Launch chrome browser
	   public void launchBrowser(){

	        driver.get("https://login.salesforce.com/");

	    }
	   public void click() {}
	   public void nowwait() {}

}

