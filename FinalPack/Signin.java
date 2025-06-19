package FinalPack;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Signin {
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Browser br=Playwright.create().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
        Page p=br.newPage();
        p.evaluate("() => document.documentElement.requestFullscreen()");  //for fullscreen
        p.navigate("http://localhost:4200/login");
        p.locator("[name='username']").fill("ka");
        p.locator("[name='password']").fill("Kamal@234");
        p.locator("[type='submit']").click();
        p.waitForTimeout(3000);    
        Locator input=p.getByPlaceholder("Enter Connection String Here");
        input.click();
        input.press("Control+A");     
        input.press("Delete"); 
        input.fill("Server=localhost;Database=proj;Uid=root;Pwd=root");
        p.locator("button:has-text('Connect')").click();
        p.close(); 
        br.close();
	}
}
