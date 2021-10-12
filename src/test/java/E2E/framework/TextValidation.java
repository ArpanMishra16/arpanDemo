package E2E.framework;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class TextValidation extends Base{
	WebDriver driver;
	
	@Test
	public void textValid() throws IOException {
		
		driver = driverIntializer();
		driver.get(pro.getProperty("url"));
		LandingPage l = new LandingPage(driver);
		Assert.assertEquals(l.getText().getText(), "FEATURED COURSES");
		driver.close();
	}

}
