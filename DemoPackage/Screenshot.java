package DemoPackage;

import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.ScreenshotOptions;
import com.microsoft.playwright.Playwright;

public class Screenshot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Browser br=Playwright.create().chromium().launch(new LaunchOptions().setHeadless(false));
     Page p=br.newPage();
     p.navigate("https://www.saucedemo.com/");
     SimpleDateFormat simple=new SimpleDateFormat("dd-MM-yy-HH-mm-ss");
     Date date=new Date();
     String s=simple.format(date);
     p.screenshot(new ScreenshotOptions().setFullPage(true).setPath(Paths.get("Screenshot/"+s+".png")));
     p.close();
     br.close();
	}

}
