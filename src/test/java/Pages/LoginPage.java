package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import testcases.BaseClass;

public class LoginPage {
	WebDriver driver = BaseClass.driver;

	public void LoginFunction(String UserNameVal, String PasswordVal) {

		WebElement LoginLink = driver.findElement(By.linkText("Log in"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		LoginLink.click();

		WebElement UserName = driver.findElement(By.name("user_login"));
		WebElement Password = driver.findElement(By.id("password"));
		WebElement RememberMe = driver.findElement(By.className("rememberMe"));
		WebElement LoginBtn = driver.findElement(By.name("btn_login"));

		UserName.sendKeys(UserNameVal);
		Password.sendKeys(PasswordVal);
		RememberMe.click();
		LoginBtn.click();
	}

}
