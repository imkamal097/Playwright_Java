package DemoPackage;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class DragandDrop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Browser br=Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
        Page p=br.newPage();
        p.navigate("https://jqueryui.com/droppable/");
        FrameLocator frame=p.frameLocator(".demo-frame");
       // frame.locator("#draggable").dragTo(frame.locator("#droppable"));    //straight forward approach!
        
        frame.locator("#draggable").hover();
        p.mouse().down();
        frame.locator("#droppable").hover();           //simple understandle approachh
        p.mouse().up();
	}

}
