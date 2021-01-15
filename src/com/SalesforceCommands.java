package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SalesforceCommands extends TestCommands{
	public void Login(){
		   // driver.get("https://test.salesforce.com/");
		        WebElement name = driver.findElement(By.id("username"));
		        name.click();
		        name.sendKeys("mmansha.training@appirio.com");
		        WebElement pwd= driver.findElement(By.id ("password"));
		                pwd.click();
		        pwd.sendKeys("Mansha@1234");

		    WebElement Login= driver.findElement(By.id ("Login"));
		    Login.click();

		}

		// Account creation
		public void createAccount() throws InterruptedException {
		        Thread.sleep(8000);
		        driver.findElement(By.xpath("//li[@id='Account_Tab']//child::a[@title='Accounts Tab']")).click();
		      // AccountTab.click();
		}
		
		
}
