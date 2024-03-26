package com.example.coffeeweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BrowseStack {
    WebDriver driver;
//    public static final String Username = "prasadjoshi_C7gTQx";
//    public static final String AutomateKey = "4mysHqgfggypGJ4xfJca";
//    public static final String URL = "https://"+Username+":"+AutomateKey+"@hub-cloud.browserstack.com/wd/hub";

    @BeforeTest
    public void setup() throws MalformedURLException
    {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAUTOMATOR2");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "f535686");
        caps.setCapability("platformNAme", "android");
        caps.setCapability("platformVersion", "12.0");
        caps.setCapability("ignoreUnimportantViews", true);
        caps.setCapability("disableAndroidWatchers", true);
        caps.setCapability("appPackage", "com.coffeeweb.app");
        caps.setCapability("appActivity", "com.coffeeweb.app.MainActivity");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(url,caps);

    }

    @Test
    public void LaunchChrome1() throws InterruptedException
    {
        Thread.sleep(15000);
//        WebDriverWait wait = new WebDriverWait(driver, 20);
//        WebElement Phone = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@index='5']")));
        MobileElement Phone = driver.findElement(By.xpath("//android.widget.EditText[@index='5']"));
        Phone.click();
        Phone.sendKeys("9008367080");
        Thread.sleep(3000);
        MobileElement Password = driver.findElement(By.xpath("//android.widget.EditText[@index='8']"));
        Password.click();
        Password.sendKeys("Abcd@1234");
        MobileElement Login = driver.findElement(By.xpath("//android.view.View[@index='10']"));
        Login.click();
        Thread.sleep(5000);

        try
        {
            MobileElement elementonpopup = driver.findElement(By.xpath("//android.view.View[@content-desc='OK Login']"));

            if(elementonpopup.isDisplayed())
            {
                Thread.sleep(5000);
                elementonpopup.click();
                Thread.sleep(5000);
            }
        }
        catch(Exception e)
        {
            System.out.println("PopUp Message is not displayed.");
        }

        Thread.sleep(8000);

        WebElement ReadMore = driver.findElement(By.xpath("//android.view.View[@content-desc='Read More']"));
        ReadMore.click();
        Thread.sleep(3000);
        System.out.println("ReadMore Button Clicked Succeessfully");
        WebElement GoBack = driver.findElement(By.xpath("//android.view.View[@content-desc='Go Back']"));
        GoBack.click();
        WebElement Favorite = driver.findElement(By.xpath("//android.view.View[@index='3']"));
        Favorite.click();
        Thread.sleep(15000);
        System.out.println("Favorite Button Clicked Succeessfully");

        //WebElement MyFavorite = driver.findElement(By.xpath("//android.view.View[@content-desc='My Favourite Tab 2 of 2']"));
        WebElement MyFavorite = driver.findElement(By.xpath("//android.view.View[@index='1']"));
        MyFavorite.click();
        Thread.sleep(3000);
        System.out.println("MyFavorite Button Clicked Succeessfully");
        WebElement ReadMore1 = driver.findElement(By.xpath("//android.view.View[@content-desc='Read More']"));
        ReadMore1.click();
        Thread.sleep(3000);
        System.out.println("ReadMore1 Button Clicked Succeessfully");
        WebElement GoBack1 = driver.findElement(By.xpath("//android.view.View[@content-desc='Go Back']"));
        GoBack1.click();
        Thread.sleep(3000);

        WebElement Menu = driver.findElement(By.xpath("//android.view.View[@content-desc=\"Coffee News Feeds\"]/android.widget.ImageView[1]"));
        Menu.click();
        Thread.sleep(5000);
        System.out.println("Menu Button Clicked Succeessfully");

        WebElement Support = driver.findElement(By.xpath("//android.view.View[@content-desc='Support']"));
        Support.click();
        Thread.sleep(3000);
        System.out.println("Support Button Clicked Succeessfully");
        WebElement GoBack_Support = driver.findElement(By.xpath("//android.view.View[@content-desc='Go Back']"));
        GoBack_Support.click();
        Thread.sleep(3000);

        WebElement Menu1 = driver.findElement(By.xpath("//android.view.View[@index='0']"));
        Menu1.click();
        Thread.sleep(5000);
        System.out.println("Menu1 Button Clicked Succeessfully");

        WebElement Profile = driver.findElement(By.xpath("//android.view.View[@content-desc='Profile']"));
        Profile.click();
        Thread.sleep(3000);
        System.out.println("Profile Button Clicked Succeessfully");

        WebElement Menu2 = driver.findElement(By.xpath("//android.view.View[@index='0']"));
        Menu2.click();
        Thread.sleep(5000);
        System.out.println("Menu2 Button Clicked Succeessfully");

        WebElement Logout = driver.findElement(By.xpath("//android.view.View[@content-desc='Log out']"));
        Logout.click();
        Thread.sleep(3000);
        System.out.println("Logout Succeessfully");


    }

    @AfterTest
    public void TearDown()
    {
        driver.quit();
    }
}
