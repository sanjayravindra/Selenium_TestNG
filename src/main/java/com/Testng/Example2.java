package com.Testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

//@Listeners(FeatureTest.class)
public class Example2 {
	         //DO NOT remove or alter this line. REQUIRED FOR TESTING
           //DO NOT Change the class Name
		
		
		public static WebDriver driver;
		String name;
		String password;
		
	    @BeforeSuite
	    public void createDriver() {                  //DO NOT change the method signature
			//Create driver and assign it to 'static' driver variable
	    	System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\sanjay.ravindra\\eclipse-workspace\\Selenium_Assessments\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("http://webapps.tekstac.com/Shopify/");
		}
		@BeforeMethod
		public void resetName() {                   //DO NOT change the method signature
			//NO implementation required. ONLY proper annotation is required.
		}	
		@Test
		public void signin() {                       //DO NOT change the method signature
			System.out.println("signin");
		}
		@Test(priority = 1)
	    public void initializeName() {                //DO NOT change the method signature
			name="Tom";
			System.out.println("name");
		}
		@Test(priority = 0)
		public void initializePassword() {           //DO NOT change the method signature
			password="Tom";
			System.out.println("pass");
		}
		@AfterSuite
		public void closeBrowser() {                //DO NOT change the method signature
			//close the driver
			driver.close();
		}
		
		public void invokeTest() {                 //DO NOT change the method signature
			//Implement code to invoke test using TestNG
			
		}

		public static void main(String[] args) {
//		    Ex2TestNG ex2=new Ex2TestNG();
		    //Implement any required code.
		}


}
