package play;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;
import org.testng.annotations.*;

public class class5 {

  Playwright playwright;
  Browser browser;
  Page page;

  @BeforeClass
  public void setUp() {
    playwright = Playwright.create();
    browser = playwright.chromium().launch(
      new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000)
    );
    page = browser.newPage();
    page.evaluate("() => document.documentElement.requestFullscreen()");
  }

  @Test(priority = 1)
  public void testLogin() {
      page.navigate("http://localhost:4200/login");
      page.locator("[name='username']").fill("nan");
      page.locator("[name='password']").fill("nan@123");
      page.locator("[type='submit']").click();
  }

  @Test(priority = 2, dependsOnMethods = "testLogin")
  public void testConnectToDatabase() {
      Locator locator = page.getByPlaceholder("Enter Connection String Here");
      locator.press("Control+A");
      locator.press("Delete");
      locator.fill("Server=localhost;Database=proj;Uid=root;Pwd=root@39");
      page.locator("button:has-text('Connect')").click();
  }


  @Test(priority = 3, dependsOnMethods = "testConnectToDatabase")
  public void testNavigateToEmpAddressSection() {
      page.locator("[ng-reflect-value='emp_address']").click();
      page.locator("button:has-text('Continue')").click();
  }


  @Test(priority = 4, dependsOnMethods = "testNavigateToEmpAddressSection")
  public void testAddEmpAddressDetails() {
    page.locator("#Address_Id").click();
    page.locator("#Address_Type").click();
    page.locator("button:has-text('Add Screen')").click();
    page.selectOption("//select[@ng-reflect-name='Address_Type']", new SelectOption().setLabel("Permanent"));
    page.locator("button:has-text('Submit')").click();
  }

  @Test(priority = 5, dependsOnMethods = "testAddEmpAddressDetails")
  public void testReturnToMainScreenAndSetLimit() {
    page.locator("#Address_Id").click();
    page.locator("#Address_Type").click();
    page.locator("button:has-text('Main Screen')").click();
    page.selectOption("#limitSelect", new SelectOption().setLabel("10"));
  }

  @AfterClass
  public void tearDown() {
    page.close();
    browser.close();
    playwright.close();
  }
}
