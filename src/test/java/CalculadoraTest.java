

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.options.BaseOptions;
import io.appium.java_client.AppiumBy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {

    private AndroidDriver driver;

    @BeforeEach
    public void setUp() {
        var options = new BaseOptions()
            .amend("platformName", "Android")
            .amend("appium:platformVersion", "9.0")
            .amend("appium:deviceName", "Samsung Galaxy S9 FHD GoogleAPI Emulator")
            .amend("appium:deviceOrientation", "portrait")
            .amend("appium:app", "storage:filename=Calculator (2).apk")
            .amend("appium:appPackage", "com.google.android.calculator")
            .amend("appium:appActivity", "com.android.calculator2.Calculator")
            .amend("appium:automationName", "UiAutomator2")
            .amend("browserName", "")
            .amend("appium:ensureWebviewsHavePages", true)
            .amend("appium:nativeWebScreenshot", true)
            .amend("appium:noReset", true)
            .amend("appium:fullReset", false)
            .amend("sauce:options", Map.of("name", "Appium Desktop Session -- Jan 24, 2025 11:25 PM"))
            .amend("appium:newCommandTimeout", 3600)
            .amend("appium:connectHardwareKeyboard", true);

        try {
            driver = new AndroidDriver(getUrl(), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException("https://josejuniorc:be97a49e-247d-4a59-8202-29c77950cb2d@ondemand.us-west-1.saucelabs.com:443/wd/hub");
        }
    }

    private URL getUrl() throws MalformedURLException {
        return new URL("https://josejuniorc:be97a49e-247d-4a59-8202-29c77950cb2d@ondemand.us-west-1.saucelabs.com:443/wd/hub");
    }

    @Test
    public void sampleTest() {
      var el1 = driver.findElement(AppiumBy.accessibilityId("clear"));
      el1.click();

      el1.click();
      var el2 = driver.findElement(AppiumBy.accessibilityId("1"));
      el2.click();
      var el3 = driver.findElement(AppiumBy.accessibilityId("plus"));
      el3.click();
      var el4 = driver.findElement(AppiumBy.accessibilityId("3"));
      el4.click();
      var el5 = driver.findElement(AppiumBy.accessibilityId("equals"));
      el5.click();
      
      assertEquals("4", driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_final")).getText());

      var el6 = driver.findElement(AppiumBy.accessibilityId("clear"));
      el6.click();

      var el7 = driver.findElement(AppiumBy.accessibilityId("9"));
      el7.click();
      var el8 = driver.findElement(AppiumBy.accessibilityId("minus"));
      el8.click();
      var el9 = driver.findElement(AppiumBy.accessibilityId("6"));
      el9.click();
      var el10 = driver.findElement(AppiumBy.accessibilityId("equals"));
      el10.click();

      assertEquals("3", driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_final")).getText());

      var el11 = driver.findElement(AppiumBy.accessibilityId("clear"));
      el11.click();

      var el12 = driver.findElement(AppiumBy.accessibilityId("9"));
      el12.click();      
      var el13 = driver.findElement(AppiumBy.accessibilityId("multiply"));
      el13.click();
      var el14 = driver.findElement(AppiumBy.accessibilityId("5"));
      el14.click();
      var el15 = driver.findElement(AppiumBy.accessibilityId("equals"));
      el15.click();

      assertEquals("45", driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_final")).getText());

      var el16 = driver.findElement(AppiumBy.accessibilityId("clear"));
      el16.click();
      
      var el17 = driver.findElement(AppiumBy.accessibilityId("8"));
      el17.click();
      var el18 = driver.findElement(AppiumBy.accessibilityId("divide"));
      el18.click();
      var el19 = driver.findElement(AppiumBy.accessibilityId("4"));
      el19.click();
      var el20 = driver.findElement(AppiumBy.accessibilityId("equals"));
      el20.click();

      assertEquals("2", driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_final")).getText());
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
