package TestNGPlaaywright;

import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.testng.annotations.*;

public class SigninTest {

    Playwright playwright;
    Browser browser;
    Page page;

    @BeforeClass
    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
            new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000)
        );
    }

    @BeforeMethod
    public void openLoginPage() {
        page = browser.newPage();
        page.evaluate("() => document.documentElement.requestFullscreen()");
        page.navigate("http://localhost:4200/login");
    }

    @Test(priority = 1)
    public void testLogin_ValidCredentials() {
        page.locator("[name='username']").fill("ka");
        page.locator("[name='password']").fill("Kamal@234");
        page.locator("[type='submit']").click();

        Locator successMessage = page.locator("text=Login successful!");
        successMessage.waitFor();
        PlaywrightAssertions.assertThat(successMessage).isVisible();
    }

    @Test(priority = 2)
    public void testLogin_BlankUsername() {
        page.locator("[name='username']").fill("");
        page.locator("[name='password']").fill("Kamal@234");
        //page.locator("[type='submit']").click();

        Locator errorMessage = page.locator("text=Username is required");
        errorMessage.waitFor();
        PlaywrightAssertions.assertThat(errorMessage).isVisible();
    }

    @Test(priority = 3)
    public void testLogin_InvalidCredentials() {
        page.locator("[name='username']").fill("kamal");
        page.locator("[name='password']").fill("Kamal@234");
        page.locator("[type='submit']").click();

        Locator failureMessage = page.locator("text=Login failed: Invalid username or password");
        failureMessage.waitFor();
        PlaywrightAssertions.assertThat(failureMessage).isVisible();
    }

    @AfterMethod
    public void afterEachTest() {
        if (page != null) {
            page.close();
        }
    }

    @AfterClass
    public void tearDown() {
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
    }
}
