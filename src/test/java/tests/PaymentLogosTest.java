package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.HomePage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PaymentLogosTest extends BaseTest {

    @Test
    public void checkPaymentSystemsLogosTest() {

        HomePage homePage = new HomePage(driver);

        int logosCount = homePage.getPaymentLogos().size();

        assertTrue(logosCount > 0,
                "Логотипы платёжных систем отсутствуют");
    }
}
