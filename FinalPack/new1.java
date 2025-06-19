package FinalPack;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class new1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Browser br=Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
        Page page=br.newPage();
        page.navigate("http://localhost:4200/login");
        page.locator("[name='username']").fill("Ka");
        page.locator("[name='password']").fill("Kamal@234");
        page.locator("[type='submit']").click();
      Locator locator=  page.getByPlaceholder("Enter Connection String Here");
       locator.press("Control+A");
       locator.press("Delete");
       locator.fill("Server=localhost;Database=proj;Uid=root;Pwd=root");
       page.locator("button:has-text('Connect')").click();
        page.close();
        br.close();
        
	}

}
