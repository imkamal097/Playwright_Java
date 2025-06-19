package DemoPackage; 
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
public class Login {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Browser br=null;
		Page page=null;
		try {
        	 br=Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        	//Browser.NewContextOptions contextOptions = new Browser.NewContextOptions().setIgnoreHTTPSErrors(true);
        	//Page page = browser.newContext(contextOptions).newPage(); //used for only webkit
        	page=br.newPage();    //used for expect webkit
        	page.navigate("https://www.saucedemo.com/");
        	PlaywrightAssertions.assertThat(page).hasTitle("Swag Labs");
        	//page.locator("#user-name").fill("standard_user");
        	page.locator("xpath=//input[@id='user-name']").fill("standard_user"); //by using xpath
        	page.locator("#password").fill("secret_sauce");
        	page.getByText("Login").click();
        	PlaywrightAssertions.assertThat(page.locator(".title")).containsText("Products");
            page.locator("#react-burger-menu-btn").click();
            page.getByText("Logout").click();
            PlaywrightAssertions.assertThat(page).hasTitle("Swag Labs");
        	page.waitForTimeout(5000);
		}
		finally {
        	page.close();
        	br.close();
		}
	}
}
