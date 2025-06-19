package Final;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;

public class depdel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Browser br=Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
        Page p=br.newPage();
        p.evaluate("() => document.documentElement.requestFullscreen()");  //for fullscreen
        p.navigate("http://localhost:4200/login");
        p.locator("[name='username']").fill("arch");
        p.locator("[name='password']").fill("arc@123");
        p.locator("[type='submit']").click();
        p.waitForTimeout(3000);
        Locator input=p.getByPlaceholder("Enter Connection String Here");
        input.click(); 
        input.press("Control+A");    
        input.press("Delete");
        input.fill("Server=localhost;Database=proj;Uid=root;Pwd=root@39");
        p.locator("button:has-text('Connect')").click();
        p.locator("[ng-reflect-value='department']").click();
        p.locator("button:has-text('Continue')").click();
        p.locator("[ng-reflect-name='Dept_Id']").click();
        p.locator("[ng-reflect-name='Dept_Name']").click();
        p.locator("button:has-text('Main Screen')").click();
        p.selectOption("#limitSelect", new SelectOption().setLabel("10"));
        p.locator("[type='checkbox']").nth(2).click();
        p.locator(".delete-btn").click();				//-----------------delete
        
        
        Locator check = p.locator("[type='checkbox']");  //----------------Edit
        int c=check.count();
        Locator last =check.nth(c-1); 
        last.click();
        p.locator("button:has-text('Edit')").click();
        Locator L=p.locator("[type='text']");
        L.click();
        L.press("Control+A");
        L.press("Delete");
        L.fill("MBA");
        p.locator("button:has-text('Save')").click();
      
      
      
       
        
        
        
	}

}
