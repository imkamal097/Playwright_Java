//package play;
//
//import java.nio.file.Paths;
//
//import com.microsoft.playwright.Browser;
//import com.microsoft.playwright.BrowserType;
//import com.microsoft.playwright.Locator;
//import com.microsoft.playwright.Page;
//import com.microsoft.playwright.Playwright;
//import com.microsoft.playwright.options.SelectOption;
//
//public class class2 {
//
//	public static void main(String[] args) {
//		Browser br=Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
//        Page page=br.newPage();
//        page.navigate("http://localhost:4200/login");
//        page.locator("[name='username']").fill("nan");
//        page.locator("[name='password']").fill("nan@123");
//        page.locator("[type='submit']").click();
//        Locator locator=  page.getByPlaceholder("Enter Connection String Here");
//        locator.press("Control+A");
//        locator.press("Delete");
//        locator.fill("Server=localhost;Database=proj;Uid=root;Pwd=root@39");
//        page.locator("button:has-text('Connect')").click();
//        page.locator("[ng-reflect-value='role']").click();
//        page.locator("button:has-text('Continue')").click();
//        page.locator("[ng-reflect-name='role_Id']").click();
//        page.locator("[ng-reflect-name='Role_Name']").click();
//        page.locator("button:has-text('Add Screen')").click();
//        page.locator("[ng-reflect-name='Role_Name']").fill("automation testing");
//        page.locator("button:has-text('Submit')").click();
//        page.locator("[ng-reflect-name='role_Id']").click();
//        page.locator("[ng-reflect-name='Role_Name']").click();
//        page.locator("button:has-text('Main Screen')").click();
////        page.locator("input[type='checkbox']").uncheck(); 
//
//
////      Locator idLocator = page.locator("td:nth-child(2)", new Locator.LocatorOptions().setHasText("specificID")); 
//
////Locator idLocator = page.locator("td:nth-child(2)");
////Locator nameLocator = page.locator("td:nth-child(3)");
////idLocator.locator("57");
////nameLocator.locator("tester").click();
////        page.locator("button:has-text('Delete')").click();
//        page.selectOption("#limitSelect", new SelectOption().setLabel("10"));
//        page.close();
//        br.close();
//    }
//
//}
//
//package play;
//
//import com.microsoft.playwright.*;
//import com.microsoft.playwright.options.SelectOption;
//
//public class class2 {
//
//  public static void main(String[] args) {
//    Browser br = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
//    Page page = br.newPage();
//    page.navigate("http://localhost:4200/login");
//    page.locator("[name='username']").fill("nan");
//    page.locator("[name='password']").fill("nan@123");
//    page.locator("[type='submit']").click();
//    Locator locator = page.getByPlaceholder("Enter Connection String Here");
//    locator.press("Control+A");
//    locator.press("Delete");
//    locator.fill("Server=localhost;Database=proj;Uid=root;Pwd=root@39");
//    page.locator("button:has-text('Connect')").click();
//    page.locator("[ng-reflect-value='role']").click();
//    page.locator("button:has-text('Continue')").click();
//    page.locator("[ng-reflect-name='role_Id']").click();
//    page.locator("[ng-reflect-name='Role_Name']").click();
//    page.locator("button:has-text('Add Screen')").click();
//    page.locator("[ng-reflect-name='Role_Name']").fill("tester2");
//    page.locator("button:has-text('Submit')").click();
//    page.locator("[ng-reflect-name='role_Id']").click();
//    page.locator("[ng-reflect-name='Role_Name']").click();
//    page.locator("button:has-text('Main Screen')").click();
//    page.selectOption("#limitSelect", new SelectOption().setLabel("10"));
//    // Locate the row with role ID 57 and role name "automation testing"
//    Locator rowLocator = page.locator("[type='checkbox']");
//    rowLocator.last().click();
//    rowLocator.nth(5).click();
//                      page.waitForTimeout(3000);       
//                            
//    // Click the delete button
//    page.locator("button:has-text('Delete')").click();
//
////    page.selectOption("#limitSelect", new SelectOption().setLabel("10"));
//    page.close();
//    br.close();
//  }
//}
//package play;
//
//import com.microsoft.playwright.*;
//import org.testng.annotations.*;
//
//public class class2 {
//  Playwright playwright;
//  Browser browser;
//  Page page;
//
//  @BeforeClass
//  public void setUp() {
//    playwright = Playwright.create();
//    browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
//    page = browser.newPage();
//  }
//
//  @Test
//  public void loginToApplication() {
//    page.navigate("http://localhost:4200/login");
//    page.locator("[name='username']").fill("nan");
//    page.locator("[name='password']").fill("nan@123");
//    page.locator("[type='submit']").click();
//  }
//
//  public Page getPage() {
//    return page;
//  }
//
//  @AfterClass
//  public void tearDown() {
//    page.close();
//    browser.close();
//    playwright.close();
//  }
//}
package play;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;
import org.testng.annotations.*;

public class class2 {
    Playwright playwright;
    Browser browser;
    Page page;

    @BeforeClass
    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
        page = browser.newPage();
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
    public void testNavigateToSalarySection() {
        page.locator("[ng-reflect-value='salary']").click();
        page.locator("button:has-text('Continue')").click();
    }

    @Test(priority = 4, dependsOnMethods = "testNavigateToSalarySection")
    public void testAddSalaryDetails() {
        page.locator("[ng-reflect-name='Salary_Id']").click();
        page.locator("[ng-reflect-name='Sal_Basic']").click();
        page.locator("[ng-reflect-name='Total_CTC']").click();
        page.locator("button:has-text('Add Screen')").click();

        page.locator("[ng-reflect-name='Sal_Basic']").fill("25000");
        page.locator("[ng-reflect-name='Total_CTC']").fill("350000");
        page.locator("button:has-text('Submit')").click();
    }

    @Test(priority = 5, dependsOnMethods = "testAddSalaryDetails")
    public void testFinalizeAndSelectLimit() {
        page.locator("[ng-reflect-name='Salary_Id']").click();
        page.locator("[ng-reflect-name='Sal_Basic']").click();
        page.locator("[ng-reflect-name='Total_CTC']").click();
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
   

