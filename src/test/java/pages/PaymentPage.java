package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PaymentPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    
            By.xpath("//button[contains(text(),'Принять') or contains(text(),'Согласен')]");

    public void acceptCookiesIfPresent() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(cookieAcceptButton)).click();
        } catch (Exception ignored) {}
    }


    private By paymentBlock =
            By.cssSelector("section.pay");

    public void scrollToPaymentBlock() {
        WebElement element = wait.until(
                ExpectedConditions.presenceOfElementLocated(paymentBlock));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", element);
    }
    
    private By serviceDropdown =
            By.cssSelector(".select__header");

    private By serviceOptions =
            By.cssSelector(".select__option");

    public void selectServiceByName(String serviceName) {
        wait.until(ExpectedConditions.elementToBeClickable(serviceDropdown)).click();

        List<WebElement> options = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(serviceOptions));

        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase(serviceName)) {
                option.click();
                break;
            }
        }
    }
    
    private By phoneField =
            By.xpath("//input[@placeholder='Номер телефона']");

    private By sumField =
            By.xpath("//input[@placeholder='Сумма']");

    private By emailField =
            By.xpath("//input[@placeholder='E-mail для отправки чека']");

    public void enterPhoneNumber(String number) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(phoneField));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", input);
        input.clear();
        input.sendKeys(number);
    }

    public void enterSum(String sum) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(sumField));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", input);
        input.clear();
        input.sendKeys(sum);
    }

    public void enterEmail(String email) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", input);
        input.clear();
        input.sendKeys(email);
    }
    
    private By continueButton =
            By.xpath("//button[contains(text(),'Продолжить')]");

    public void clickContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }
    
    private By paymentIframe =
            By.cssSelector("iframe[src*='bepaid']");

    public void switchToPaymentFrame() {

        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("iframe")));

        List<WebElement> frames = driver.findElements(By.tagName("iframe"));

        for (WebElement frame : frames) {
            driver.switchTo().defaultContent();

            try {
                driver.switchTo().frame(frame);
                
                if (driver.findElements(By.xpath("//*[contains(text(),'BYN')]")).size() > 0) {
                    return; 
                }

            } catch (Exception ignored) {}
        }

        throw new RuntimeException("Не найден iframe с оплатой");
    }
    
    private By amountText =
            By.xpath("//*[contains(text(),'BYN')]");

    private By payButton =
            By.xpath("//button[contains(text(),'Оплатить')]");

    private By paymentInfo =
            By.xpath("//div[contains(text(),'Оплата')]");

    public String getAmountText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(amountText)).getText();
    }

    public String getPayButtonText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(payButton)).getText();
    }

    public String getPaymentInfoText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(paymentInfo)).getText();
    }
    private By cardNumberField =
            By.xpath("//input[@placeholder='Номер карты']");

    private By cardDateField =
            By.xpath("//input[@placeholder='Срок действия']");

    private By cardCvcField =
            By.xpath("//input[@placeholder='CVC']");

    private By cardNameField =
            By.xpath("//input[contains(@placeholder,'Имя')]");

    public boolean isCardFormDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cardNumberField)).isDisplayed()
                && driver.findElement(cardDateField).isDisplayed()
                && driver.findElement(cardCvcField).isDisplayed()
                && driver.findElement(cardNameField).isDisplayed();
    }
    
    private By visaIcon =
            By.xpath("//img[contains(@src,'visa')]");

    private By masterCardIcon =
            By.xpath("//img[contains(@src,'mastercard')]");

    private By mirIcon =
            By.xpath("//img[contains(@src,'mir')]");

    public boolean arePaymentIconsDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(visaIcon)).isDisplayed()
                && driver.findElement(masterCardIcon).isDisplayed()
                && driver.findElement(mirIcon).isDisplayed();
    }
}
