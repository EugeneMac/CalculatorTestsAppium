import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.io.File;
import java.time.Duration;
import java.net.MalformedURLException;
import java.net.URL;

public class base {
public static AndroidDriver driver;
    public static void main(String[] args) throws MalformedURLException {
        String filePath = new File("").getAbsolutePath();
        UiAutomator2Options options = new UiAutomator2Options()
                .setUdid("emulator-5554")
                .setPlatformName("Android")
                .setNewCommandTimeout(Duration.ofSeconds(600))
                .setFullReset(false)
                .setNoReset(false)
                .setAppPackage("com.google.android.calculator")
                .setApp(filePath + "\\src\\Calculator_8.6.1.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);


    }
}