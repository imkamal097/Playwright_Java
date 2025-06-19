package FinalPack;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;

public class emp_address {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Browser br=Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
	        Page p=br.newPage();
	        p.evaluate("() => document.documentElement.requestFullscreen()");  //for fullscreen
	        p.navigate("http://localhost:4200/login");
	        p.locator("[name='username']").fill("ka");
	        p.locator("[name='password']").fill("Kamal@234");
	        p.locator("[type='submit']").click();
	        p.waitForTimeout(3000);
	        Locator input=p.getByPlaceholder("Enter Connection String Here");
	        input.click();
	        input.press("Control+A");    
	        input.press("Delete");
	        input.fill("Server=localhost;Database=proj;Uid=root;Pwd=root");
	        p.locator("button:has-text('Connect')").click();
	        p.locator("[ng-reflect-value='emp_address']").click();
	        p.locator("button:has-text('Continue')").click();
	        
	        p.locator("#Address_Id").click();
	        p.locator("#Address_Type").click();
	        p.locator("button:has-text('Add Screen')").click();
	        
	        
	        p.selectOption("//select[@ng-reflect-name='Address_Type']", new SelectOption().setLabel("Permanent"));
	        p.locator("button:has-text('Submit')").click();

	        
	        p.locator("#Address_Id").click();
	        p.locator("#Address_Type").click();
	        p.locator("button:has-text('Main Screen')").click();
	        p.selectOption("#limitSelect", new SelectOption().setLabel("10"));
	       
	        p.close();
	        br.close();

	}

}
