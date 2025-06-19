package DemoPackage;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class SliderHandle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Browser br=Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
        Page p=br.newPage();
        p.navigate("https://jqueryui.com/slider/");
        FrameLocator frame=p.frameLocator(".demo-frame");
        Locator l=frame.locator("//div[@id='slider']/span[@class='ui-slider-handle ui-corner-all ui-state-default']");
        //in frame.locator the class name is also a unique but it is not working,instead of use xpath......
        l.focus();
        for(int i=0;i<=10;i++) {
        	p.keyboard().press("ArrowRight");
        }
	}

}
