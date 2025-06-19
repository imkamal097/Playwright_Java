package Final;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;

public class role {
		 
		  public static void main(String[] args) {
			  Browser br=Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
		        Page p=br.newPage();
		        p.evaluate("() => document.documentElement.requestFullscreen()");  //for fullscreen
		        p.navigate("http://localhost:4200/login");
		        p.locator("[name='username']").fill("arch");
		        p.locator("[name='password']").fill("arc@123");
		    p.locator("[type='submit']").click();
		    Locator locator = p.getByPlaceholder("Enter Connection String Here");
		    locator.press("Control+A");
		    locator.press("Delete");
		    locator.fill("Server=localhost;Database=proj;Uid=root;Pwd=root@39");
		    p.locator("button:has-text('Connect')").click();
		    p.locator("[ng-reflect-value='role']").click();
		    p.locator("button:has-text('Continue')").click();
		    p.locator("[ng-reflect-name='role_Id']").click();
		    p.locator("[ng-reflect-name='Role_Name']").click();
		    p.locator("button:has-text('Add Screen')").click();
		    p.locator("[ng-reflect-name='Role_Name']").fill("tester2");
		    p.locator("button:has-text('Submit')").click();
		    p.locator("[ng-reflect-name='role_Id']").click();
		    p.locator("[ng-reflect-name='Role_Name']").click();
		    p.locator("button:has-text('Main Screen')").click();
		    p.selectOption("#limitSelect", new SelectOption().setLabel("10"));
		   
		    Locator check =  p.locator("[type='checkbox']");//============to check
		    
		   check.nth(2).click();
		    p.waitForTimeout(2000);       
		 
		    p.locator("button:has-text('Delete')").click();//-------delete
		    
		    
		    
		 
		    //----------------Edit
	        int c=check.count();
	        Locator last =check.nth(c-1); 
	        last.click();
	        p.locator("button:has-text('Edit')").click();
	        
	        Locator text=p.locator("[type='text']");
	        
	        text.locator("//input[@type='text']").click();
	        locator.press("Control+A");
	        locator.press("Delete");
	        locator.fill("Data Scientist");
	        
//		    p.close();
//		    br.close();
		  }
		
		
		
		
	}
	
	
	


