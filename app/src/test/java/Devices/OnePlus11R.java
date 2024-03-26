package Devices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.remote.MobileCapabilityType;

public class OnePlus11R
{
    static WebDriver driver;
    public static final String Username = "prasadjoshi_C7gTQx";
    public static final String AutomateKey = "4mysHqgfggypGJ4xfJca";
    public static final String URL = "https://"+Username+":"+AutomateKey+"@hub-cloud.browserstack.com/wd/hub";

    @BeforeTest
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "OnePlus11R");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.0");
        caps.setCapability("build", "CoffeeWeb_Script");
        caps.setCapability("name", "CoffeeWeb");
        caps.setCapability("app", "bs://5e36575b6f6f290457269e8315234ac518a136df");
        caps.setCapability("interactiveDebugging", true);

        driver = new RemoteWebDriver(new URL(URL), caps);
    }


    @Test
    public void App_Launch() throws InterruptedException {
        Thread.sleep(10000);
        WebElement Allow = driver.findElement(By.xpath("//android.widget.Button[@text='Allow']"));
        Allow.click();
        WebElement Phone = driver.findElement(By.xpath("//android.widget.EditText[@index='5']"));
        Phone.click();
        Thread.sleep(2000);
        Phone.sendKeys("9008367080");
        Thread.sleep(2000);
        WebElement Password = driver.findElement(By.xpath("//android.widget.EditText[@index='8']"));
        Password.click();
        Thread.sleep(2000);
        Password.sendKeys("Abcd@1234");
        Thread.sleep(2000);
        //driver.pressKey(new KeyEvent(AndroidKey.ENTER));

        WebElement Login = driver.findElement(By.xpath("//android.view.View[@index='10']"));
        Login.click();
        Thread.sleep(5000);

        try {
            WebElement elementonpopup = driver.findElement(By.xpath("//android.view.View[@content-desc='OK Login']"));

            if (elementonpopup.isDisplayed()) {
                Thread.sleep(5000);
                elementonpopup.click();
                Thread.sleep(5000);
            }
        } catch (Exception e) {
            System.out.println("PopUp Message is not displayed.");
        }

        Thread.sleep(15000);

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

//        WebElement MyFavorite = driver.findElement(By.xpath("//android.view.View[@content-desc='My Favourite Tab 2 of 2']"));
////        WebElement MyFavorite = driver.findElement(By.xpath("//android.view.View[@index='1']"));
//        MyFavorite.click();
//        Thread.sleep(3000);
//        System.out.println("MyFavorite Button Clicked Succeessfully");
//        WebElement ReadMore1 = driver.findElement(By.xpath("//android.view.View[@content-desc='Read More']"));
//        ReadMore1.click();
//        Thread.sleep(3000);
//        System.out.println("ReadMore1 Button Clicked Succeessfully");
//        WebElement GoBack1 = driver.findElement(By.xpath("//android.view.View[@content-desc='Go Back']"));
//        GoBack1.click();
//        Thread.sleep(3000);

        WebElement Menu = driver.findElement(By.xpath("//android.view.View[@content-desc=\"Coffee News Feeds\"]/android.view.View[1]"));
        Menu.click();
        Thread.sleep(5000);
        System.out.println("Menu Button Clicked Succeessfully");

        WebElement Support = driver.findElement(By.xpath("//android.view.View[@content-desc='Support']"));
        Support.click();
        Thread.sleep(3000);
        System.out.println("Support Button Clicked Succeessfully");
        WebElement GoBack_Support = driver.findElement(By.xpath("//android.view.View[@content-desc='Go Back']"));
        GoBack_Support.click();
        Thread.sleep(5000);

        WebElement Menu1 = driver.findElement(By.xpath("//android.view.View[@content-desc=\"Coffee News Feeds\"]/android.view.View[1]"));
        Menu1.click();
        Thread.sleep(5000);
        System.out.println("Menu1 Button Clicked Succeessfully");

        WebElement Profile = driver.findElement(By.xpath("//android.view.View[@content-desc='Profile']"));
        Profile.click();
        Thread.sleep(8000);
        System.out.println("Profile Button Clicked Succeessfully");

        WebElement Menu2 = driver.findElement(By.xpath("//android.view.View[@content-desc=\"Profile\"]/android.view.View"));
        Menu2.click();
        Thread.sleep(5000);
        System.out.println("Menu1 Button Clicked Succeessfully");

        WebElement Logout = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Log out\"]"));
        Logout.click();
        Thread.sleep(3000);
        System.out.println("Logout Button clicked Succeessfully");

        //android.view.View[@content-desc="Ok"]
        WebElement Logout_OK = driver.findElement(By.xpath("//android.view.View[@content-desc=\"Ok\"]"));
        Logout_OK.click();
        Thread.sleep(3000);
        System.out.println("Logout Succeessfully");

    }

    @AfterTest
    public void TearDown() {
        driver.quit();
    }
}
