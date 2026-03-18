package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.HomePage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MtsPaymentBlockTest extends BaseTest {

    @Test
    public void checkPaymentBlockTitleTest() {

        HomePage homePage = new HomePage(driver);

        homePage.acceptCookiesIfPresent();
        homePage.scrollToPaymentBlock();

        String title = homePage.getPaymentBlockTitle();

        assertTrue(title.contains("Онлайн пополнение"),
                "Неверный заголовок блока");
    }
}
