import org.junit.After;
import org.junit.Test;
import org.junit.Assert;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;

public class UITests {
    private AndroidDriver driver;
    private Calculator calculator;
    public UITests() throws MalformedURLException {
        base.main(new String[]{});
        this.driver = base.driver;
        this.calculator = new Calculator();
    }

    @Test
    public void multiplyTest()
    {
        calculator.clickNumber("1").clickNumber("2").clickNumber("3").clickMultiply().clickNumber("4").clickNumber("5").clickNumber("6");
        Assert.assertTrue("preview text: " + calculator.getPreview(), calculator.getPreview().equals("56088"));
    }

    @Test
    public void divisionTest()
    {
        calculator.clickNumber("4").clickNumber("5").clickNumber("6").clickDivide().clickNumber("7").clickNumber("8").clickNumber("9");
        Assert.assertTrue("preview text: " + calculator.getPreview(), calculator.getPreview().equals("0.57794676806083"));
    }

    @Test
    public void additionTest()
    {
        calculator.clickNumbers("123456").clickPlus().clickNumbers("987654");
        Assert.assertTrue("preview text: " + calculator.getPreview(), calculator.getPreview().equals("1111110"));
    }

    @Test
    public void subtractionTest()
    {
        calculator.clickNumbers("753").clickMinus().clickNumbers("951");
        Assert.assertTrue("preview text: " + calculator.getPreview(), calculator.getPreview().equals("−198"));
    }

    @Test
    public void parenthesisTest()
    {
        calculator.clickNumbers("15").clickMinus().clickParenthesis().clickNumber("9").clickMinus().clickNumber("5").clickParenthesis();
        Assert.assertTrue("preview text: " + calculator.getPreview(), calculator.getPreview().equals("11"));
    }

    @Test
    public void openHelpTest() throws InterruptedException {
        calculator.clickMoreOptions().clickHelp();
        calculator.waitForElement(Selectors.popularHelpResourcesText, ".googlehelp.helpactivities.HelpActivity");
    }

    @After
    public void TearDown()
    {
        driver.getPageSource();
        driver.quit();
    }


}
