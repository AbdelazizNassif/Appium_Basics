
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

public class Calculator {

	private static AndroidDriver<AndroidElement> driver;


	@Test
	public void test1() throws MalformedURLException, InterruptedException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("automationName", "UiAutomator2");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "8.0.0");
		capabilities.setCapability("deviceName", "emulator-5554");
		//capabilities.setCapability("app", System.getProperty("user.dir") + "\\application\\APK Info_v1.15.00_apkpure.com.apk");
		capabilities.setCapability("appPackage", "com.android.calculator2");
		capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

		driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		AndroidElement x = (AndroidElement) driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.android.calculator2:id/digit_7']"));
		AndroidElement y = (AndroidElement)driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.android.calculator2:id/op_add']"));
		AndroidElement z = (AndroidElement)driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.android.calculator2:id/digit_5']"));
		AndroidElement e = (AndroidElement)driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.android.calculator2:id/eq']"));
		x.click();
		y.click();
		z.click();
		e.click();
		AndroidElement res = (AndroidElement)driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.android.calculator2:id/result']"));
		System.out.println(res.getText());
		Assert.assertTrue(res.isDisplayed());
		Assert.assertEquals(res.getText(), "12");
		Thread.sleep(2000);
		
		
		//android.widget.TextView
		
	
	}


}

