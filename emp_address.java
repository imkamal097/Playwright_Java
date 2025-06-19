package Final;


import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;
public class emp_address {

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
        p.locator("[ng-reflect-value='emp_address']").click();
        p.locator("button:has-text('continue')").click();
        p.locator("[ng-reflect-name='Address_Id']").click();
        p.locator("[ng-reflect-name='Address_Type']").click();
        p.locator("button:has-text('Main Screen')").click();
        
        
//        p.selectOption("#limitSelect", new SelectOption().setLabel("10"));   //---------------del(done)
//        p.locator("[type='checkbox']").nth(3).click();
//        p.locator(".delete-btn").click();
        
//        Locator check = p.locator("[type='checkbox']");  //----------------Edit
//        int c=check.count();
//        Locator last =check.nth(c-1); 
//        last.click();
//        p.locator("button:has-text('Edit')").click();
//        Locator L=p.locator("[type='text']");
//        L.click();
//       
//        p.locator(".form-control ng-valid ng-touched ng-dirty").click();
//        p.selectOption("//select[@class='form-control ng-untouched ng-pristine ng-valid']", new SelectOption().setLabel("Current"));
//        
//        
//        
//        p.locator("button:has-text('Save All')").click();
        
        p.selectOption("#limitSelect", new SelectOption().setLabel("10"));  //---------------Add new row(done)
        p.locator("button:has-text('Add New Row')").click();        
        p.selectOption("[ng-reflect-name='Address_Type']",new SelectOption().setLabel("Current"));
        p.locator("button:has-text('Submit')").click();
        
	}
	
	
	

}