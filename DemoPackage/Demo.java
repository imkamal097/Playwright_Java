package DemoPackage;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Playwright pw=Playwright.create();
      BrowserType browsertype =pw.chromium();
      Browser browser = browsertype.launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
      Page page=browser.newPage(); //used expect webkit

//Browser.NewContextOptions contextOptions = new Browser.NewContextOptions().setIgnoreHTTPSErrors(true);
//Page page = browser.newContext(contextOptions).newPage(); //used for only webkit

      page.navigate("https://playwright.dev/java/docs/intro");
	  String title=page.title();
	  System.out.println("Title is : "+title);
//	  page.close();
//	  browser.close();
//	  pw.close();
	
	}

}
