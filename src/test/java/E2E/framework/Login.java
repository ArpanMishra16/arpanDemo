package E2E.framework;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.QaClickLandingPage;
import resources.Base;

public class Login extends Base {
	WebDriver driver;
	
	private static Logger log = LogManager.getLogger(Login.class.getName());
	
	
	@BeforeMethod
	public void driverinit() throws IOException {
		driver=	driverIntializer();
		log.info("Driver Successfully Initialized");
		driver.get(pro.getProperty("url"));
		log.info("URL successfully open");
		driver.manage().window().maximize();
                System.out.println("Git test");
	
	}
	
	@AfterMethod
	public void close() {
		
		driver.close();
	}
	
	@Test(dataProvider= "getData")
	public void test1(String username, String pwd) throws IOException {
		
		
		QaClickLandingPage qa = new QaClickLandingPage(driver);
		LandingPage lp = new LandingPage(driver);
		WebDriverWait wa = new WebDriverWait(driver, 100000);
		wa.until(ExpectedConditions.visibilityOf(qa.loginbutton()));
		
		Assert.assertTrue(lp.getText().isDisplayed());
		//Assert.assertEquals(lp.getText().getText(), "Focused 123");
	qa.loginbutton().click();
	 
	log.debug("Successfully Clicked");
	qa.userIDTextBox().sendKeys(username); 
	log.debug("successfully Enter details");
	qa.userPwdTextBox().sendKeys(pwd);
	
	qa.submitButton().click();

	
		
		
	}
	
	@DataProvider
	public Object[][] getData() {
		
		Object[][] data = new Object[2][2];
		data[0][0] = "abc@gmail.com";
		data[0][1] = "abc123";
		data[1][0] = "text@123";
		data[1][1] = "321as";
		return data;
	}

}
