package testcases;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

	public static WebDriver driver;

	@BeforeMethod
	public void SetUp() throws MalformedURLException {
		// launch application
		// System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		// driver = new FirefoxDriver();
		// driver.get("https://www.simplilearn.com/");
		// driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// launch application

		String browserType = System.getProperty("Browser");

		if (browserType.contains("firefox")) {

			// System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserType.contains("remote")) {
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setPlatform(Platform.WIN10);
			cap.setBrowserName("firefox");
			// cap.setVersion("125.0.6422.141");
			// ChromeOptions chromeOptions = new ChromeOptions();
			// chromeOptions.setCapability("browserVersion", "125.0.6422.141");
			// chromeOptions.setCapability("platformName", "Windows");
			// Showing a test name instead of the session id in the Grid UI
			// chromeOptions.setCapability("se:name", "My simple test");
			// Other type of metadata can be seen in the Grid UI by clicking on the
			// session info or via GraphQL
			// chromeOptions.setCapability("se:sampleMetadata", "Sample metadata value");
			driver = new RemoteWebDriver(new URL("http://192.168.1.133:4444"), cap);

		} else {
			// System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
		}

		driver.get("https://www.simplilearn.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@AfterMethod
	public void QuitBrowser() {
		driver.quit();
	}

}
