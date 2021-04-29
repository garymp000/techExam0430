package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class otherElements {
	
	WebDriver driver = null;
	WebDriverWait wait = null;
	public void waitToLoad() {
		while(driver.findElement(By.xpath("//*[@id='ajax_loading']")).isDisplayed()) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
