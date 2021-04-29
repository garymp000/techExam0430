package StepDefinitions;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import common.initWeb;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import userdefinedfunctions.SampleTestPage.FuncPage;

public class SampleTest_StepDef {
	FuncPage exec = new FuncPage();
//	initWeb gora = new initWeb();

	@Given("chrome browser is open")
	public void openBrowser() {

		exec.openBrowser();
		
	}
		
	
	
	@When("user access my account page with \"([^\"]*)\",\"([^\"]*)\"$")
	public void loginToSite(String amaysimNo, String amaysimPw) {
		try{exec.goToDashboard(amaysimNo, amaysimPw);
		} catch (Exception e){
			System.out.println(e);
			
		}
	}
	
	@And("user navigates to settings page")
	public void goToSettings() {
		try	{exec.goTomyAmaysimSettings();;
		} 
		catch (Exception e){
			System.out.println(e);
		}
		
	}
	
	@And("update sim nickname with \"([^\"]*)\"$")
	public void updateNick(String simNickname) {
		System.out.println(exec.updateSimNick(simNickname));
		
//		
//		try {
//			assertEquals("Update success", ));
//		}
//		catch (Exception e) {
//			assertEquals("Failed", false, true);
//		}
	
	}
	
	@And("update recharge pin with \"([^\"]*)\"$")
	public void updateRechargePin(String rechargepin) {
		System.out.println(exec.updateRechargePin(rechargepin));
		
	}
	
	@And("update caller id settings \"([^\"]*)\"$")
	public void updateCallerId(String callId) {
		System.out.println(exec.updateCallerId(callId));
		
	}
	
	@And("updates call forwarding option")
	public void callFwdFunc(DataTable dt) {
		
		List<Map<String, String>> lstTable = dt.asMaps(String.class, String.class);
		for(int i = 0; i < lstTable.size(); i++) {
			String callFwd = lstTable.get(i).get("callFwd").toString();
			String fwdTo = lstTable.get(i).get("fwdTo").toString();
			
			exec.callFwdOption(callFwd, fwdTo);
		}
	}

	
	
	@Then("all changes should work as expected")
	public void expectedBehaviour() {
		 //Final Validation here. DB checks, etc.
		 exec.closeBrowser();
}
}
