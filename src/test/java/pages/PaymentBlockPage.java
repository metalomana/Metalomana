package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaymentBlockPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public PaymentBlockPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    private By paymentBlock =
            By.cssSelector("section.pay");

    private By cookieAcceptButton =
            By.xpath("//button[contains(text(),'Принять') or contains(text(),'Согласен')]");

    private By dropdown =
            By.xpath("//div[contains(@class,'select')]");

    private By communicationOption =
            By.xpath("//p[contains(text(),'Услуги связи')]");

    private By homeInternetOption =
            By.xpath("//p[contains(text(),'Домашний интернет')]");

    private By installmentOption =
            By.xpath("//p[contains(text(),'Рассрочка')]");

    private By debtOption =
            By.xpath("//p[contains(text(),'Задолженность')]");

    private By mainInput =
            By.xpath("//input[contains(@class,'phone') or contains(@placeholder,'Номер') or contains(@placeholder,'счета')]");

    private By amountInput =
            By.xpath("//input[@placeholder='Сумма']");

    private By emailInput =
            By.xpath("//input[contains(@placeholder,'E-mail')]");

    private By pageTitle = By.tagName("body");

    public void clickOutside() {
        driver.findElement(pageTitle).click();
    }
    public void acceptCookiesIfPresent() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(cookieAcceptButton)).click();
        } catch (Exception ignored) {}
    }

    public void scrollToBlock() {
        WebElement element = wait.until(
                ExpectedConditions.presenceOfElementLocated(paymentBlock));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void selectService(By option) {

        wait.until(ExpectedConditions.elementToBeClickable(dropdown)).click();

        WebElement opt = wait.until(ExpectedConditions.elementToBeClickable(option));
        opt.click();

        wait.until(ExpectedConditions.invisibilityOf(opt));

        ((JavascriptExecutor) driver).executeScript("document.body.click()");
    }
    public void selectCommunicationServices() {
        selectService(communicationOption);
    }

    public void selectHomeInternet() {

        wait.until(ExpectedConditions.elementToBeClickable(homeInternetOption)).click();

        clickOutside();
    }

    public void selectInstallment() {
        selectService(installmentOption);
    }

    public void selectDebt() {
        selectService(debtOption);
    }
    public String getMainPlaceholder() {

        WebElement element = wait.until(driver -> {
            WebElement el = driver.findElement(mainInput);
            String placeholder = el.getAttribute("placeholder");

            return (placeholder != null && !placeholder.isEmpty()) ? el : null;
        });

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", element);

        return element.getAttribute("placeholder");
    }
    public String waitForPlaceholder(String expectedText) {

        wait.until(driver -> {
            WebElement el = driver.findElement(mainInput);
            String placeholder = el.getAttribute("placeholder");

            return expectedText.equals(placeholder);
        });

        return driver.findElement(mainInput).getAttribute("placeholder");
    }

    public String getAmountPlaceholder() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(amountInput))
                .getAttribute("placeholder");
    }

    public String getEmailPlaceholder() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput))
                .getAttribute("placeholder");
    }
}
