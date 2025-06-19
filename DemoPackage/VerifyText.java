package DemoPackage;

import java.util.regex.Pattern;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class VerifyText {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Browser br=Playwright.create().chromium().launch(new LaunchOptions().setHeadless(false));
		Page p=br.newPage();
		//p.pause();
		p.navigate("https://www.saucedemo.com/");
		p.locator("#login-button").click();
		String s=p.locator("[data-test='error']").textContent();
		// PlaywrightAssertions.assertThat(p.locator("[data-test='error']")).containsText("Epic sadface: Username is required"); //check for exact text
		PlaywrightAssertions.assertThat(p.locator("[data-test='error']")).containsText(Pattern.compile("is")); //check for partial text
//		p.close();
//		br.close();
		
		
		
	}

}
