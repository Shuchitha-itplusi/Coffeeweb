package com.example.coffeeweb;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Sample1 {
    AndroidDriver driver;
    @BeforeTest
    public void setup() throws MalformedURLException
    {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAUTOMATOR2");
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "R9ZT10L3KMZ");
        dc.setCapability("platformNAme", "android");
        dc.setCapability("platformVersion", "12.0");
        dc.setCapability("ignoreUnimportantViews", true);
        dc.setCapability("disableAndroidWatchers", true);
        dc.setCapability("appPackage", "com.coffeeweb.app");
        dc.setCapability("appActivity", "com.coffeeweb.app.MainActivity");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<AndroidElement>(url, dc);

    }

    @Test
    public void main() throws InterruptedException {
        Thread.sleep(10000);
        MobileElement Phone = (MobileElement) driver.findElement(By.xpath("//android.widget.EditText[@index='5']"));
        Phone.click();
        Phone.sendKeys("9008367080");
        Thread.sleep(2000);
        MobileElement Password = (MobileElement) driver.findElement(By.xpath("//android.widget.EditText[@index='8']"));
        Password.click();
        Thread.sleep(2000);
        Password.sendKeys("Abcd@1234");
        Thread.sleep(2000);
        MobileElement Login = (MobileElement) driver.findElement(By.xpath("//android.view.View[@index='10']"));
        Login.click();
        Thread.sleep(5000);
    }

    @AfterTest
    public void close()
    {
        driver.closeApp();
    }
}
