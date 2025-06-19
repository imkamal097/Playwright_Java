package DemoPackage;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ShadowDOM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Browser br=Playwright.create().chromium().launch(new LaunchOptions().setHeadless(false).setSlowMo(200));
       Page p=br.newPage();
       p.navigate("https://selectorshub.com/xpath-practice-page/");
     
//       Locator l=p.locator("#userName");
//       Locator l1=l.locator("#kils");      //3 line process
//       l1.fill("kamal");
       
        
       Locator l2=p.locator("#userName #kils");                 //single line process
       l2.fill("kamal");
       
       Locator l3=p.locator("#userName #pizza");     // Here #username is the id in which the shadow DOM is einside that ID            
       l3.fill("Dominos");
	}
}
