package Final;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;
 

public class salary {


		

		 
			public static void main(String[] args) {
				Browser br=Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
		        Page p=br.newPage();
		        p.navigate("http://localhost:4200/login");
		        p.locator("[name='username']").fill("arch");
		        p.locator("[name='password']").fill("arc@123");
		        p.locator("[type='submit']").click();
		    Locator locator = p.getByPlaceholder("Enter Connection String Here");
		        locator.press("Control+A");
		        locator.press("Delete");
		        locator.fill("Server=localhost;Database=proj;Uid=root;Pwd=root@39");
		        p.locator("button:has-text('Connect')").click();
		        p.locator("[ng-reflect-value='salary']").click();
		        p.locator("button:has-text('Continue')").click();
		        p.locator("[ng-reflect-name='Salary_Id']").click();
		        p.locator("[ng-reflect-name='Sal_Basic']").click();
		        p.locator("[ng-reflect-name='Total_CTC']").click();
		        p.locator("button:has-text('Add Screen')").click();
		        p.locator("[ng-reflect-name='Sal_Basic']").fill("25000");
		        p.locator("[ng-reflect-name='Total_CTC']").fill("350000");
		        p.locator("button:has-text('Submit')").click();
		        p.locator("[ng-reflect-name='Salary_Id']").click();
		        p.locator("[ng-reflect-name='Sal_Basic']").click();
		        p.locator("[ng-reflect-name='Total_CTC']").click();
		        p.locator("button:has-text('Main Screen')").click();
		        p.selectOption("#limitSelect", new SelectOption().setLabel("10"));
		        Locator check =  p.locator("[type='checkbox']");//============to check
			    
				   check.nth(2).click();
				    p.waitForTimeout(2000);       
				 
				    p.locator("button:has-text('Delete')").click(); 
				    
				    
				    
				    int c=check.count();
			        Locator last =check.nth(c-1); 
			        last.click();
			        p.locator("button:has-text('Edit')").click();
		        Locator l=p.locator("//input[@type='number']");
		        l.last();
		        Locator locator1 = p.getByPlaceholder("//input[@type='number']");
		        locator1.press("Control+A");
		        locator1.press("Delete");
		        locator1.fill("10000");
		        p.setDefaultTimeout(4000);
//		        p.close();
//		        br.close();
			}
		 
		
	}


