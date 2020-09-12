package SBA_Assessment_tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SBA_Assessment_pages.CustomerForm;
import SBA_Assessment_setup.DriverSetup;
import SBA_Assessment_setup.ExcelUtils;

	public class TestCustomerForm extends DriverSetup {
		public static String blankErrtxt;
		//Implement code here
		WebDriver driver;
		@BeforeClass
		public void setUp()
		{
		    driver = getDriver();
		}
		
		
//		@DataProvider(name = "customerInvalid")
		public void getExcelData() throws Exception 
		{
//			ExcelUtils.readExcelData("Sheet3");
		}
		
		
//		@Test(dataProvider = "customerInvalid")
		public void testInvalidCustomerDetails(String testcasename, String name, String age, String address, String phoneNumber, String email)
		{
		    CustomerForm c = new CustomerForm(driver);
		    c.setCustomerName(name);
		    c.setAge(age);
		    c.setAddress(address);
		    c.setPhoneNumber(phoneNumber);
		    c.setEmail(email);
		    c.submitForm();
		}
		
//		public  void customer() {
//		    //Invoke the test using TestNG ONLY HERE.
//		    	TestNG testsuite=new TestNG();
//	        testsuite.setTestClasses(new Class[] {
//	        		TestCustomerForm.class
//	    });
	//
//	        try {
//	    	testsuite.run();
//	    	} catch(Exception e) {
	//   
//	    	}
//		}
		
		@AfterClass
		
		public void closeBrowser()
		{
		   driver.close(); 
		}

	}
