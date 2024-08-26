import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;


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

}
