import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.ElementOption;

public class Coffee_Quotes {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAUTOMATOR2");
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "f535686");
        dc.setCapability("platformNAme", "android");
        dc.setCapability("platformVersion", "12.0");
        dc.setCapability("ignoreUnimportantViews", true);
        dc.setCapability("disableAndroidWatchers", true);
        dc.setCapability("appPackage", "com.coffeeweb.app");
        dc.setCapability("appActivity", "com.coffeeweb.app.MainActivity");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(url, dc);

        Thread.sleep(10000);
        MobileElement Phone = (MobileElement) driver.findElement(By.xpath("//android.widget.EditText[@index='3']"));
        Phone.click();
        Thread.sleep(2000);
        Phone.sendKeys("7847803912");
        Thread.sleep(2000);
        MobileElement Password = (MobileElement) driver.findElement(By.xpath("//android.widget.EditText[@index='5']"));
        Password.click();
        Thread.sleep(2000);
        Password.sendKeys("Abcd@123");
        Thread.sleep(2000);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));

        MobileElement Login = (MobileElement) driver.findElement(By.xpath("//android.view.View[@index='7']"));
        Login.click();
        Thread.sleep(5000);

//        MobileElement SelectCurrency = (MobileElement) driver.findElement(By.xpath("//android.view.View[@index='5']"));
//        SelectCurrency.click();
//        Thread.sleep(5000);

        AndroidTouchAction android = new AndroidTouchAction(driver);

        AndroidElement SelectCurrency = (AndroidElement) driver.findElement(By.xpath("//android.view.View[@index='5']"));
        android.tap(ElementOption.element(SelectCurrency)).perform();
        Thread.sleep(2000);


    }
}
