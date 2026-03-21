package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.PaymentPage;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentFlowTest extends BaseTest {

    @Test
    public void checkPaymentFlowForCommunicationServices() {

        PaymentPage homePage = new PaymentPage(driver);

        homePage.acceptCookiesIfPresent();
        homePage.scrollToPaymentBlock();

        homePage.selectServiceByName("Услуги связи");

        homePage.enterPhoneNumber("297777777");
        homePage.enterSum("100");
        homePage.enterEmail("test@test.com");

        homePage.clickContinue();

        homePage.switchToPaymentFrame();

        String amountText = homePage.getAmountText();
        assertTrue(amountText.contains("100.00"),
                "Сумма отображается неверно: " + amountText);

        String payButtonText = homePage.getPayButtonText();
        assertTrue(payButtonText.contains("100.00"),
                "Сумма на кнопке неверная: " + payButtonText);

        String paymentInfo = homePage.getPaymentInfoText();
        assertTrue(paymentInfo.contains("375297777777"),
                "Номер телефона отображается неверно: " + paymentInfo);

        assertTrue(homePage.isCardFormDisplayed(),
                "Поля карты не отображаются");

        assertTrue(homePage.arePaymentIconsDisplayed(),
                "Иконки платёжных систем отсутствуют");
    }
}
