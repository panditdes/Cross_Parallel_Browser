package testClasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import baseClasses.BaseClass;
import pomClasses.HomePage;
import pomClasses.LogInPage;
import pomClasses.ProfilePage;

public class AddNewAddress {

	                            //Pending not completed
	WebDriver driver;
	LogInPage lp;
    HomePage hp;
	ProfilePage pp;
	
	
	@Parameters
	
	@BeforeClass
	
	public void beforeclass(String a) 
	{
		driver = BaseClass.getWebDriver(a);
	}

	
	@BeforeMethod
	
	public void beforemethod()
	{
		lp = new LogInPage(driver);
		hp = new HomePage(driver);
		pp = new ProfilePage(driver);
	}
	
	@Test
	
	public void VerifyUserCanLogIn() throws InterruptedException
	{
		lp.EnterEmailID();
		Reporter.log("User Entered EmailID");
		lp.EnterPassword();
		Reporter.log("User Entered PassWord");
		lp.ClickOnSubmitButton();
		Reporter.log("User Click on Submit Button");
		hp.hoverToProfileName();
		
		String text = hp.GetLogOutText();
		
			if(text.equals("Logout"))
			{
				System.out.println("TestPassed");
			}
		else
		{
			Assert.fail();
		}
		
	}
	
	
	@Test(priority=1)
	
	public void UserCanAddNewAddress() throws InterruptedException, EncryptedDocumentException, IOException
	{
		
		hp.MovePointer();
		hp.hoverToProfileName();
		hp.ClickOnMyProfileText();
		pp.ClickOnManageAddress();
		pp.ClickOnAddNewAddress();
		pp.GetDataForAddress();
		pp.AdressField();
		pp.ClickOnRadio();
		//pp.ClickOnSave();
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("After Method");
	}
	
	@AfterClass
	public void afterClass()
	{
		//driver.quit();
	}
}
