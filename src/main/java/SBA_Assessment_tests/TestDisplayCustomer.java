package SBA_Assessment_tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SBA_Assessment_pages.CustomerForm;
import SBA_Assessment_setup.DriverSetup;
import SBA_Assessment_setup.ExcelUtils;

	public class TestDisplayCustomer extends DriverSetup {

		public static String titletxt;
	    public static String customerNametxt;
	    public static String agetxt;
	    public static String addresstxt;
	    public static String numbertxt;
	    public static String emailtxt;
	//Implement code here
	    
	    
		@BeforeClass
		
		public void setUp()
		{
		    getDriver();
		}
		
		@DataProvider(name="customerValid")
		public void getExcelData() throws Exception
		{
			ExcelUtils.readExcelData("Sheet2");
		}
		
		
		@Test(dataProvider="customerValid")
		public void testValidCustomerDetails(String Testcasename, String name, String age, String address, String phonenumber, String email)
		{
			CustomerForm c = new CustomerForm(driver);
		    c.setCustomerName(name);
		    c.setAge(age);
		    c.setAddress(address);
		    c.setPhoneNumber(phonenumber);
		    c.setEmail(email);
		    c.submitForm();
		}
		
//		public  void customer() {
//		    //Invoke the test using TestNG ONLY HERE.
//		    	TestNG testsuite=new TestNG();
//	        testsuite.setTestClasses(new Class[] {
//	        		TestDisplayCustomer.class
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
		    
		}
	}

