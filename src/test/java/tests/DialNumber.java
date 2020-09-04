
package tests;

import org.openqa.selenium.Dimension;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class DialNumber {

	private static AndroidDriver<AndroidElement> driver;


	@Test
	public void test1() throws MalformedURLException, InterruptedException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("automationName", "UiAutomator2");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "8.0.0");
		capabilities.setCapability("deviceName", "emulator-5554");
		//capabilities.setCapability("app", System.getProperty("user.dir") + "\\application\\APK Info_v1.15.00_apkpure.com.apk");
		capabilities.setCapability("appPackage", "com.google.android.dialer");
		capabilities.setCapability("appActivity", "com.google.android.dialer.DialtactsActivity");

		driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		AndroidElement x = driver.findElement(By.xpath("//android.widget.ImageButton[@resource-id='com.google.android.dialer:id/floating_action_button']"));
		x.click();
		AndroidElement zero = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.google.android.dialer:id/dialpad_key_number']"));
		zero.click();
		AndroidElement contact = driver.findElement(By.xpath("//android.widget.ImageButton[@resource-id='com.google.android.dialer:id/dialpad_floating_action_button']"));
		contact.click();
		
		
	
	}


}

