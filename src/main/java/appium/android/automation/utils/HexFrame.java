package appium.android.automation.utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HexFrame {

    public static AndroidDriver androidDriver;

    public static void capabilitiesContactAndroid(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "11");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("deviceName", "Android SDK built for x86");
        capabilities.setCapability("appPackage", "com.android.contacts");
        capabilities.setCapability("appActivity", ".activities.PeopleActivity");
        try {
            androidDriver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static void hexClick(By by){
        hexVisibleComponentAssert(by);
        androidDriver.findElement(by).click();
    }

    public static void hexWrite(By by, CharSequence charSequence){
        hexVisibleComponentAssert(by);
        androidDriver.findElement(by).sendKeys(charSequence);
    }

    public static void hexVisibleComponentAssert(By by){
        androidDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        assertTrue(androidDriver.findElement(by).isEnabled());
    }

    public static void hexCompareTextAssert(By by, String expectedString){
        hexVisibleComponentAssert(by);
        assertEquals(androidDriver.findElement(by).getText().trim(), expectedString);
    }
}
