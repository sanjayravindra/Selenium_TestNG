package SBA_Assessment_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DisplayCustomer {

	
	WebDriver driver;
    //Declare required variables
    
    public DisplayCustomer(WebDriver driver){
        this.driver = driver;        
    } 
	//Implement code here
	
	String getTitle()
	{
		return driver.findElement(By.xpath("/html/body/h2")).getText();
	    
	}
	
	String getName()
	{
		return driver.findElement(By.xpath("//tr[1]/td[2]")).getText();
	    
	}
    String getAge()
    {
    	return driver.findElement(By.xpath("//tr[2]/td[2]")).getText();
        
    }
    String getEmail()
    {
    	return driver.findElement(By.xpath("//tr[3]/td[2]")).getText();
        
    }
    String getAddress()
    {
    	return driver.findElement(By.xpath("//tr[4]/td[2]")).getText();
        
    }
    String getPhoneNumber()
    {
    	return driver.findElement(By.xpath("//tr[5]/td[2]")).getText();
        
    }
}
