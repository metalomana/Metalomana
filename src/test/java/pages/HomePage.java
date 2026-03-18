package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    private By cookieAcceptButton =
            By.xpath("//button[contains(text(),'Принять') or contains(text(),'Согласен')]");

    private By paymentBlock =
            By.cssSelector("section.pay");

    private By paymentBlockTitle =
            By.cssSelector("section.pay h2");

    private By paymentLogos =
            By.cssSelector("section.pay img");

    private By moreAboutServiceLink =
            By.xpath("//a[contains(text(),'Подробнее о сервисе')]");

    private By communicationServicesOption =
            By.xpath("//span[contains(text(),'Услуги связи')]");

    private By phoneNumberField =
            By.xpath("//input[@placeholder='Номер телефона']");

    private By continueButton =
            By.xpath("//button[contains(text(),'Продолжить')]");

    private By paymentForm =
            By.cssSelector("form");


    public void acceptCookiesIfPresent() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(cookieAcceptButton)).click();
        } catch (Exception ignored) {}
    }

    public void scrollToPaymentBlock() {
        WebElement element = wait.until(
                ExpectedConditions.presenceOfElementLocated(paymentBlock));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public String getPaymentBlockTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(paymentBlockTitle))
                .getText();
    }

    public List<WebElement> getPaymentLogos() {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(paymentLogos));
    }

    public void clickMoreAboutService() {
        wait.until(ExpectedConditions.elementToBeClickable(moreAboutServiceLink)).click();
    }

    public void selectCommunicationServices() {
        wait.until(ExpectedConditions.elementToBeClickable(communicationServicesOption)).click();
    }

    public void enterPhoneNumber(String number) {
        WebElement input = wait.until(
                ExpectedConditions.visibilityOfElementLocated(phoneNumberField));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", input);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", input);

        input.clear();
        input.sendKeys(number);

        input.sendKeys(Keys.TAB);
    }

    public boolean isContinueButtonEnabled() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(continueButton))
                .isEnabled();
    }

    public void clickContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }

    public boolean isPaymentFormDisplayed() {
        try {
            return wait.until(
                            ExpectedConditions.visibilityOfElementLocated(paymentForm))
                    .isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
