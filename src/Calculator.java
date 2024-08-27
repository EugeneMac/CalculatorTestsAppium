import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.Objects;
import java.util.function.Function;


public class Calculator {
    private AndroidDriver driver;

    public Calculator() {
        this.driver = base.driver;
    }

    public Calculator clickNumber(String number) {
        driver.findElement(AppiumBy.xpath(Selectors.numberButton.replace("%number%", number))).click();
        return this;
    }

    public Calculator clickNumbers(String number) {
        number.chars().forEachOrdered(n -> {
            driver.findElement(AppiumBy.xpath(Selectors.numberButton.replace("%number%", Character.toString(n)))).click();
        });
        return this;
    }

    public Calculator clickMultiply() {
        driver.findElement(AppiumBy.xpath(Selectors.multiplyButton)).click();
        return this;
    }

    public Calculator clickDivide() {
        driver.findElement(AppiumBy.xpath(Selectors.divideButton)).click();
        return this;
    }

    public Calculator clickPlus() {
        driver.findElement(AppiumBy.xpath(Selectors.plusButton)).click();
        return this;
    }

    public Calculator clickMinus() {
        driver.findElement(AppiumBy.xpath(Selectors.minusButton)).click();
        return this;
    }

    public Calculator clickParenthesis() {
        driver.findElement(AppiumBy.xpath(Selectors.parenthesisButton)).click();
        return this;
    }

    public String getPreview()
    {
        return driver.findElement(AppiumBy.xpath(Selectors.resultPreview)).getText();
    }

    public Calculator clickMoreOptions()
    {
        driver.findElement(AppiumBy.xpath(Selectors.moreOptionButton)).click();
        return this;
    }

    public Calculator clickHelp()
    {
        driver.findElement(AppiumBy.xpath(Selectors.helpOption)).click();
        return this;
    }

    public Calculator waitForElement(String locator, String activityRequired) throws InterruptedException {
        if (!activityRequired.isEmpty())
        {
            int i = 10;
            while(--i > 0)
            {
                if (Objects.requireNonNull(driver.currentActivity()).equals(activityRequired)) break;
                Thread.sleep(1000);
            }
        }

        Wait<AndroidDriver> wait = new FluentWait<AndroidDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(2));

        wait.until(new Function<AndroidDriver, WebElement>() {
            public WebElement apply(AndroidDriver driver) {
                return driver.findElement(AppiumBy.xpath(locator));
            }
        });
    return this;
    }

}
