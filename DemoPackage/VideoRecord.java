package DemoPackage;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class VideoRecord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Browser br=Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext bc=br.newContext(new Browser.NewContextOptions().setRecordVideoSize(800, 800).setRecordVideoDir(Paths.get("Video/")));
        Page p=bc.newPage();
        p.navigate("https://www.saucedemo.com/");
        p.waitForTimeout(5000);
        p.locator("//input[@id='user-name']").fill("standard_user");
        p.waitForTimeout(3000);
        bc.close();
        p.close();
	}

}
