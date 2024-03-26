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

import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;

    public class Android_Launch
    {
        WebDriver driver;
        public static final String Username = "prasadjoshi_C7gTQx";
        public static final String AutomateKey = "4mysHqgfggypGJ4xfJca";
        public static final String URL = "https://"+Username+":"+AutomateKey+"@hub-cloud.browserstack.com/wd/hub";

        @BeforeTest
        public void setup() throws MalformedURLException {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Google Pixel3");
            caps.setCapability(MobileCapabilityType.BROWSER_NAME, MobileBrowserType.CHROME);
            caps.setCapability("build", "chrome browser script");
            caps.setCapability("name", "Run chrome in device");

            driver = new RemoteWebDriver(new URL(URL), caps);

        }

        @Test
        public void LaunchChrome()
        {
            driver.get("https://www.google.com");
            WebElement search = driver.findElement(By.name("q"));
            System.out.println(driver.getTitle());
            search.sendKeys("Browserstack");
            search.submit();
            System.out.println(driver.getTitle());
        }

        @AfterTest
        public void TearDown()
        {
            driver.quit();
        }
    }


