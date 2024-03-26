import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;

public class Login {
    public static void main(String[]args) throws IOException, InterruptedException {

        FileInputStream file = new FileInputStream("C:\\Users\\Shuchitha\\Desktop\\LoginData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet("Sheet1");

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

        AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(url,dc);



        int noofrows = sheet.getLastRowNum();
        System.out.println("No of records in the Excel Sheet: " + noofrows);

        for(int row=1; row<= noofrows; row++)
        {
            XSSFRow current_row = sheet.getRow(row);

            DataFormatter dataformatter = new DataFormatter();

            String Email = dataformatter.formatCellValue(current_row.getCell(0));
            String Password = dataformatter.formatCellValue(current_row.getCell(1));

            Thread.sleep(10000);
            MobileElement Email1 = (MobileElement) driver.findElement(By.xpath("//android.widget.EditText[@index='3']"));
            Email1.click();
            Thread.sleep(1000);
            Email1.clear();
            Thread.sleep(1000);
            Email1.sendKeys(Email);
            Thread.sleep(2000);

            MobileElement Password1 = (MobileElement) driver.findElement(By.xpath("//android.widget.EditText[@index='5']"));
            Password1.click();
            Thread.sleep(1000);
            Password1.clear();
            Thread.sleep(1000);
            Password1.sendKeys(Password);
            Thread.sleep(1000);

            driver.pressKey(new KeyEvent(AndroidKey.ENTER));

            MobileElement Login = (MobileElement) driver.findElement(By.xpath("//android.view.View[@index='7']"));
            Login.click();
            Thread.sleep(4000);


            if (driver.getPageSource().contains("Coffee News Feeds")) {
                System.out.println("Login Completed for " + row + " record ");
                MobileElement Menu = (MobileElement) driver.findElement(By.xpath("//android.view.View[@content-desc=\"Coffee News Feeds\"]/android.widget.ImageView[1]"));
                Menu.click();
                Thread.sleep(2000);

                MobileElement Profile = (MobileElement) driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Profile\"]"));
                Profile.click();
                Thread.sleep(2000);

                MobileElement Logout = (MobileElement) driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Logout\"]"));
                Logout.click();
                Thread.sleep(2000);

                MobileElement Ok = (MobileElement) driver.findElement(By.xpath("//android.view.View[@content-desc=\"Ok\"]"));
                Ok.click();
            }
            else
            {
                System.out.println("Login Failed for " + row + " record ");
            }
        }

        System.out.println("Test Completed");
        driver.closeApp();
        file.close();
    }
}
