package TestNGPlaaywright;

import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.SelectOption;
import org.testng.annotations.*;

public class DepartmentTest {

    Playwright playwright;
    Browser browser;
    BrowserContext context;
    Page page;

    @BeforeClass
    public void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
    }

    @BeforeMethod
    public void createContextAndPage() {
        context = browser.newContext();
        page = context.newPage();
    }

    @Test
    public void testDepartmentFlow() {
        page.evaluate("() => document.documentElement.requestFullscreen()");
        page.navigate("http://localhost:4200/login");

        // Login
        page.locator("[name='username']").fill("ka");
        page.locator("[name='password']").fill("Kamal@234");
        page.locator("[type='submit']").click();
        page.waitForTimeout(3000);

        // Assert connection input is visible
        Locator input = page.getByPlaceholder("Enter Connection String Here");
        PlaywrightAssertions.assertThat(input).isVisible();

        // Connect to DB
        input.click();
        input.press("Control+A");
        input.press("Delete");
        input.fill("Server=localhost;Database=proj;Uid=root;Pwd=root");
        page.locator("button:has-text('Connect')").click();

        // Select department
        page.locator("[ng-reflect-value='department']").click();
        page.locator("button:has-text('Continue')").click();

        // Click fields
        page.locator("#Dept_Id").click();
        page.locator("#Dept_Name").click();

        // Add a department
        page.locator("button:has-text('Add Screen')").click();
        Locator textInput = page.locator("//input[@type='text']");
        textInput.fill("CRRO");
        page.locator("button:has-text('Submit')").click();

        // Return to main screen
        page.locator("#Dept_Id").click();
        page.locator("#Dept_Name").click();
        page.locator("button:has-text('Main Screen')").click();

        // Select dropdown option
        page.selectOption("#limitSelect", new SelectOption().setLabel("10"));

        // Assertion: Dropdown is set to "10"
        Locator dropdown = page.locator("#limitSelect");
        PlaywrightAssertions.assertThat(dropdown).hasValue("10");

        page.waitForTimeout(3000);
    }

    @Test
    public void testDepartment1st() {
        page.evaluate("() => document.documentElement.requestFullscreen()");
        page.navigate("http://localhost:4200/login");

        // Login
        page.locator("[name='username']").fill("ka");
        page.locator("[name='password']").fill("Kamal@234");
        page.locator("[type='submit']").click();
        page.waitForTimeout(3000);

        // Assert connection input is visible
        Locator input = page.getByPlaceholder("Enter Connection String Here");
        PlaywrightAssertions.assertThat(input).isVisible();

        // Connect to DB
        input.click();
        input.press("Control+A");
        input.press("Delete");
        input.fill("Server=localhost;Database=proj;Uid=root;Pwd=root");
        page.locator("button:has-text('Connect')").click();

        // Select department
        page.locator("[ng-reflect-value='department']").click();
        page.locator("button:has-text('Continue')").click();

        // Only click Dept_Name (not Dept_Id)
        page.locator("#Dept_Name").click();
        page.locator("button:has-text('Add Screen')").click();

        // Validate error message
        Locator errorMsg = page.locator("text=Please select all required fields before proceeding");
        errorMsg.waitFor();
        PlaywrightAssertions.assertThat(errorMsg).isVisible();
    }

    @Test
    public void testDepartment2nd() {
        page.evaluate("() => document.documentElement.requestFullscreen()");
        page.navigate("http://localhost:4200/login");

        // Login
        page.locator("[name='username']").fill("ka");
        page.locator("[name='password']").fill("Kamal@234");
        page.locator("[type='submit']").click();
        page.waitForTimeout(3000);

        // Assert connection input is visible
        Locator input = page.getByPlaceholder("Enter Connection String Here");
        PlaywrightAssertions.assertThat(input).isVisible();

        // Connect to DB
        input.click();
        input.press("Control+A");
        input.press("Delete");
        input.fill("Server=localhost;Database=proj;Uid=root;Pwd=root");
        page.locator("button:has-text('Connect')").click();

        // Select department
        page.locator("[ng-reflect-value='department']").click();
        page.locator("button:has-text('Continue')").click();

        // Only click Dept_Id (not Dept_Name)
        page.locator("#Dept_Id").click();
        page.locator("button:has-text('Add Screen')").click();

        // Validate error message
        Locator errorMsg = page.locator("text=Please select all required fields before proceeding");
        errorMsg.waitFor();
        PlaywrightAssertions.assertThat(errorMsg).isVisible();
    }

    @AfterMethod
    public void afterEach() {
        if (page != null) {
            page.close();
        }
        if (context != null) {
            context.close();
        }
    }

    @AfterClass
    public void teardown() {
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
    }
}
