package userdefinedfunctions.SampleTestPage;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FuncPage {
	WebDriver driver = null;
//	WebDriverWait wait = new WebDriverWait(driver, 10);
	String SaveButton = "//input[@type='submit' and @value='Save']";
	
	
//	public FuncPage(WebDriver driver) {
//		this.driver = driver;
//	}
	
	
	
	public void openBrowser() {

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
	
	
	public void goToDashboard(String amaysimNo, String amaysimPw) {
		driver.findElement(By.xpath("//*[@href='/my-account/login']")).click();
		driver.findElement(By.id("username")).sendKeys(amaysimNo);;
		driver.findElement(By.id("password")).sendKeys(amaysimPw);;
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	}
	
	public void goTomyAmaysimSettings() {
		driver.findElement(By.xpath("//*[@id='service_tile_mobile']/child::div[1]")).click();
		driver.findElement(By.xpath("//*[@id='menu_list']/li[8]/child::a[@href='/my-account/my-amaysim/settings']")).click();
		
	}
	
	public String updateSimNick(String simNickname) {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.findElement(By.xpath("//*[@id='edit_settings_phone_label']")).click();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//input[@id='my_amaysim2_setting_phone_label']")));
		driver.findElement(By.xpath("//input[@id='my_amaysim2_setting_phone_label']")).clear();
		driver.findElement(By.xpath("//input[@id='my_amaysim2_setting_phone_label']")).sendKeys(simNickname);
		driver.findElement(By.xpath(SaveButton)).click();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@class='small-12 columns margin-top-half bold setting-option-details-text' and contains(text(),'"+simNickname+"')]")));
		String newNick = driver.findElement(By.xpath("//*[@class='small-12 columns margin-top-half bold setting-option-details-text' and contains(text(),'"+simNickname+"')]")).getText();
		return newNick;
	}
	
	public String updateRechargePin(String rechargePin) {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.findElement(By.xpath("//*[@id='edit_settings_recharge_pin']")).click();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//input[@id='my_amaysim2_setting_topup_pw']")));
		driver.findElement(By.xpath("//input[@id='my_amaysim2_setting_topup_pw']")).clear();
		driver.findElement(By.xpath("//input[@id='my_amaysim2_setting_topup_pw']")).sendKeys(rechargePin);
		driver.findElement(By.xpath(SaveButton)).click();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@class='small-12 columns margin-top-half bold setting-option-details-text' and contains(text(),'"+rechargePin+"')]")));
		String newRechargePin = driver.findElement(By.xpath("//*[@class='small-12 columns margin-top-half bold setting-option-details-text' and contains(text(),'"+rechargePin+"')]")).getText();
		return newRechargePin;
	}
	
	public boolean updateCallerId(String callId) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		boolean res = false;
		if(callId.equalsIgnoreCase("no") == driver.findElement(By.xpath("//*[@id='my_amaysim2_setting_caller_id_out']")).isSelected()) { 
			driver.findElement(By.xpath("//*[@for='my_amaysim2_setting_caller_id_out']")).click();
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@class='ama-hero-heading popup-success white']/following-sibling::a")));
			driver.findElement(By.xpath("//*[@class='ama-hero-heading popup-success white']/following-sibling::a")).click();
			res = false;
		}else if(callId.equalsIgnoreCase("yes") != driver.findElement(By.xpath("//*[@id='my_amaysim2_setting_caller_id_out']")).isSelected()) { 
			driver.findElement(By.xpath("//*[@for='my_amaysim2_setting_caller_id_out']']")).click();
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@class='ama-hero-heading popup-success white']/following-sibling::a")));
			driver.findElement(By.xpath("//*[@class='ama-hero-heading popup-success white']/following-sibling::a")).click();
			res = true;
		}else {
			if(callId.equalsIgnoreCase("no")) {
				res = false;
			} else if (callId.equalsIgnoreCase("yes")) {
				res = true;
			};
		}
		return res;
	}
	
	public String callFwdOption(String callFwd, String fwdTo) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		String condi;
		
		driver.findElement(By.xpath("//*[@href='/my-account/my-amaysim/settings/17584877/edit?partial=edit_call_forwarding']")).click();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@class='confirm_popup_confirm button-green-action small-12 columns text-center']")));
		driver.findElement(By.xpath("//*[@class='confirm_popup_confirm button-green-action small-12 columns text-center']")).click();
		
		if(callFwd.equalsIgnoreCase("No")) {
			driver.findElement(By.xpath("//*[@for='my_amaysim2_setting_call_divert_false']")).click();
		} else {
		
		driver.findElement(By.xpath("//*[@for='my_amaysim2_setting_call_divert_true']")).click();
		driver.findElement(By.xpath("//*[@id='my_amaysim2_setting_call_divert_number']")).clear();
		driver.findElement(By.xpath("//*[@id='my_amaysim2_setting_call_divert_number']")).sendKeys(fwdTo);
			}
		
		driver.findElement(By.xpath(SaveButton)).click();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@class='ama-hero-heading popup-success white']/following-sibling::a")));
		driver.findElement(By.xpath("//*[@class='ama-hero-heading popup-success white']/following-sibling::a")).click();
		
		condi = driver.findElement(By.xpath("//*[@id=\"settings_call_forwarding\"]/div/div[1]/div[2]")).getText();
		return condi;
	}
	
	}



