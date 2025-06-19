package DemoPackage;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.WaitForSelectorState;

public class Waits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Browser br=Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page p=br.newPage(); 
        
        // This website doesn't work in all browsers..............
        p.navigate("https://practice.expandtesting.com/slow",new Page.NavigateOptions().setTimeout(10000));
        p.setDefaultTimeout(3000);   //change the default waiting time from 30 seconds to 3 seconds;
        p.locator("//p[@class='alert alert-info']").waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(20000));
        //wait for 20 seconds for particular text and it should be visible for previous line only
        p.close();
        br.close();
        
        
	}

}
