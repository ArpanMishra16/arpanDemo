package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QaClickLandingPage {
	
	WebDriver driver;
	
	
 private By loginButton =	By.xpath("//span[text()='Login']");
 private By userIDTextBox = By.id("user_email");
 private By userPwdTextBox = By.id("user_password");
  By submitButton = By.cssSelector("input.btn.btn-primary.btn-md.login-button");

public QaClickLandingPage(WebDriver driver) {
	this.driver =driver;
}




public WebElement loginbutton() {
	return driver.findElement(loginButton);
}
public WebElement userIDTextBox() {
	return driver.findElement(userIDTextBox);
}
public WebElement userPwdTextBox() {
	return driver.findElement(userPwdTextBox);
}
public WebElement submitButton() {
	return driver.findElement(submitButton);
}


}
