package FinalPack;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;

public class Employee {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Browser br=Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
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
        p.locator("[ng-reflect-value='employee']").click();
        p.locator("button:has-text('Continue')").click();
        
        p.locator("#emp_Id").click();
        p.locator("#First_Name").click();
        p.locator("#Last_Name").click();
        p.locator("#Email_Id").click();
        p.locator("button:has-text('Add Screen')").click();
        
        p.locator("[ng-reflect-name='First_Name']").fill("Kamal");
        p.locator("[ng-reflect-name='Last_Name']").fill("S");
        p.locator("[ng-reflect-name='Email_Id']").fill("unique123@gmail.com");
        //p.locator("//button[@class='btn']").click();
        p.locator("button:has-text('Submit')").click();
        
        p.locator("#emp_Id").click();
        p.locator("#First_Name").click();
        p.locator("#Last_Name").click();
        p.locator("#Email_Id").click();
        p.locator("button:has-text('Main Screen')").click();
        p.selectOption("#limitSelect", new SelectOption().setLabel("10"));
        
           
        p.waitForTimeout(5000);
        p.locator(".logout-button").click();
        p.close();
        br.close();
	}

}

