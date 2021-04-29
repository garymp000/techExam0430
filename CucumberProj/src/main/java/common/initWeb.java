package common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class initWeb {
	WebDriver driver = null;
	
	
	public void webChrome() {
	
	String projPath = System.getProperty("user.dir");
	System.out.println(projPath);
	System.setProperty("webdriver.chrome.driver", projPath+"/src/test/resources/browserdriver/chromedriver");
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().fullscreen();
	driver.navigate().to("https://www.amaysim.com.au/");
	}
	
	
	public void closeBrowser() {
		driver.manage().deleteAllCookies();
		driver.close();
	}

}
