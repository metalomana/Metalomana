package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.HomePage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContinueButtonTest extends BaseTest {

    @Test
    public void checkContinueButtonTest() {

        HomePage homePage = new HomePage(driver);

        homePage.acceptCookiesIfPresent();
        homePage.scrollToPaymentBlock();

        homePage.selectCommunicationServices();
        homePage.enterPhoneNumber("297777777");

        assertTrue(homePage.isContinueButtonEnabled(),
                "Кнопка Продолжить не активна");

        homePage.clickContinue();


        assertTrue(homePage.isContinueButtonEnabled(),
                "После нажатия кнопка стала неактивной");
    }
}
