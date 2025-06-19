package DemoPackage;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class TraceViewer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Browser br=null;
		Page page=null;
		BrowserContext bc=null;
		try {
        	 br=Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        	 bc=br.newContext();
        	 bc.tracing().start(new Tracing.StartOptions().setScreenshots(true).setSources(true));
        	 page=bc.newPage();    
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
		}
		finally {
			bc.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("Tracing.zip")));
        	page.close();
        	br.close();
		}
	}

}
