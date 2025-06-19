package DemoPackage;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class KeyBoardactions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub 
           Browser br=Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
           Page p=br.newPage();
           p.navigate("https://www.saucedemo.com/");
           Locator l=p.locator("//input[@id='user-name']");
           l.fill("standard_user");
           l.press("Control+A");
           l.press("Control+C");
           Locator l1=p.locator("#password");
           l1.press("Tab"); 
           l1.press("Control+V");
           p.waitForTimeout(4000);
           p.close();
           br.close();
	}
}
