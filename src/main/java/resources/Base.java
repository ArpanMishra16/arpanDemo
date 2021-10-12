package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Base {
	
	 public WebDriver driver;
	public Properties pro;
	public WebDriver driverIntializer() throws IOException {
		
		
		FileInputStream fis = new FileInputStream("C:\\Users\\ARPAN MISHRA\\Framework\\framework\\src\\main\\java\\resources\\data.properties");
		 pro = new Properties();
		pro.load(fis);
	String browsername =	System.getProperty("browser");
	//String browsername =	pro.getProperty("browser");
	System.out.println(System.getProperty("browser"));
    String urlname = 	pro.getProperty("url");
		
		if(browsername.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\ARPAN MISHRA\\chromedriver.exe");
			ChromeOptions option = new ChromeOptions();
			EdgeOptions eo = new EdgeOptions();
			if(browsername.contains("headless")) {
			option.addArguments("--headless");
			}
			 driver = new ChromeDriver(option);
		}
		else if(browsername.contains("IE")) {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\ARPAN MISHRA\\Documents\\chromedriver\\msedgedriver.exe");
			EdgeOptions eo = new EdgeOptions();
			if(browsername.contains("headless")) {
			eo.addArguments("--headless");
			}
			 driver = new EdgeDriver(eo);
		}
		driver.manage().timeouts().getImplicitWaitTimeout();
		return driver;
	}
	
	public String getScreenShot(String testCaseName, WebDriver driver) throws Exception{
		
		TakesScreenshot ts =	(TakesScreenshot) driver;
	File src =	ts.getScreenshotAs(OutputType.FILE);
	System.out.println(System.getProperty("user.dir"));
	String path = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
	//String path1 = "C:\\Users\\ARPAN MISHRA\\Framework\\framework\\reports\\abv.jpg";
		FileUtils.copyFile(src, new File(path));
		return path;
	}

}
