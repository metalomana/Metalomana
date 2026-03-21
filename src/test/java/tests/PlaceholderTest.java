package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.PaymentBlockPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlaceholderTest extends BaseTest {

    @Test
    public void checkAllPlaceholders() {

        PaymentBlockPage page = new PaymentBlockPage(driver);

        page.acceptCookiesIfPresent();
        page.scrollToBlock();

        page.selectCommunicationServices();
        assertEquals("Номер телефона",
                page.waitForPlaceholder("Номер телефона"));

        page.selectHomeInternet();
        assertEquals("Номер абонента",
                page.waitForPlaceholder("Номер абонента"));

        page.selectInstallment();
        assertEquals("Номер счета на 44",
                page.waitForPlaceholder("Номер счета на 44"));

        page.selectDebt();
        assertEquals("Номер счета на 2073",
                page.waitForPlaceholder("Номер счета на 2073"));
    }
}
