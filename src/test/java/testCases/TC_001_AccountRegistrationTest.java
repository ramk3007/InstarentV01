package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration()
	{
		try
		{
		logger.info("Test Case TC_001_AccountRegistrationTest execution started");
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on My Account Link");
		hp.clickRegister();
		logger.info("Clicked on Register Link");
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		logger.info("Providing Customer Details");
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
		regpage.setTelephone(randomeNumber());
		
		String password=randomeAlphaNumberic();
		
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		logger.info("Validating Expected msg");
		String confmsg=regpage.getConfirmationMsg();
		if(confmsg.equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
		}else {
		
			logger.error("Test Failed");
			logger.debug("Debug Logs");
			
			Assert.assertTrue(false);
		}
//		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		
		} catch(Exception e)
		{
		
			Assert.fail();
		}
		logger.info("***Finished TC_001_AccountRegistrationTest***");
		
	}
	
	
	
	
}








