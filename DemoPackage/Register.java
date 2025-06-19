package DemoPackage;

import com.microsoft.playwright.Browser;

import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Register {
  public static void main(String args[]) {
	// TODO Auto-generated method stub
    Browser br=Playwright.create().chromium().launch(new LaunchOptions().setHeadless(false));
    Page page=br.newPage();
    page.navigate("https://demowebshop.tricentis.com/login");
    //page.pause();  //wait for user to resume the steps....
    page.locator("xpath=//div[@class='header-links']/ul/li/a[@href='/register']").click();
    page.locator("xpath=//div[@class='gender']/input[@id='gender-male']").click();
    page.locator("xpath=//input[@id='FirstName']").fill("play");
    page.locator("xpath=//input[@id='LastName']").fill("wright");
    page.locator("xpath=//input[@id='Email']").fill("playwright1233@gmail.com");
    page.locator("xpath=//input[@id='Password']").fill("#mdkshai#123"); 
    page.locator("xpath=//input[@id='ConfirmPassword']").fill("#mdkshai#123");
    page.waitForTimeout(5000);
    page.locator("xpath=//input[@id='register-button']").click();
}
}
