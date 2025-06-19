package FinalPack;

import com.microsoft.playwright.Browser;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;
 
public class Selectall {

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
        p.locator("[ng-reflect-value='department']").click();
        p.locator("button:has-text('Continue')").click();
        
        p.locator("#Dept_Id").click(); 
        p.locator("#Dept_Name").click();
        
        p.locator("button:has-text('Add Screen')").click();
        p.locator("//input[@type='text']").fill("CRO");
        p.locator("button:has-text('Submit')").click();
        
        
        p.locator("#Dept_Id").click();
        p.locator("#Dept_Name").click();
        p.locator("button:has-text('Main Screen')").click();
        
        Locator l1=p.locator("//input[@type='checkbox']");
        l1.last().click();
        
        p.locator("button:has-text('Select All')").click();     //select all button
        p.selectOption("#limitSelect", new SelectOption().setLabel("10"));
        p.waitForTimeout(5000);
        p.close();
        br.close();
	}
}
