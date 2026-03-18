package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.HomePage;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MoreAboutServiceTest extends BaseTest {

    @Test
    public void checkMoreAboutServiceLinkTest() {

        HomePage homePage = new HomePage(driver);

        homePage.acceptCookiesIfPresent();

        String originalWindow = driver.getWindowHandle();

        homePage.clickMoreAboutService();

        for (String window : driver.getWindowHandles()) {
            if (!window.equals(originalWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }

        assertTrue(driver.getCurrentUrl().contains("poryadok-oplaty"));
    }
}
