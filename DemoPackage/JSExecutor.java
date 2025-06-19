package DemoPackage;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class JSExecutor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          Browser br=Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
          Page p=br.newPage();
          p.navigate("https://login.yahoo.com/");
          System.out.println(p.locator("#persistent").boundingBox().height);
          System.out.println(p.locator("#persistent").boundingBox().width);//here the both height and width are less than size of 1 so playwright takes it as non visible 
          //    p.evaluate("document.getElementById('persistent').click()");  //by using js 
          Locator l=p.locator("#persistent");
          l.evaluate("checkbox => checkbox.click()");       //by using locator reference for evaluation
          
	}

}
