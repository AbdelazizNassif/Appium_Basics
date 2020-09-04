
package tests;

import org.openqa.selenium.Dimension;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
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
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class DropDown {

	private static AndroidDriver<AndroidElement> driver;


	@Test
	public void test1() throws MalformedURLException, InterruptedException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("automationName", "UiAutomator2");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "8.0.0");
		capabilities.setCapability("deviceName", "emulator-5554");
		capabilities.setCapability("app", System.getProperty("user.dir") + "\\application\\com.mobeta.android.demodslv_3.apk");
		//capabilities.setCapability("appPackage", "com.android.calculator2");
		//capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

		driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//android.widget.TextView
		driver.findElement(By.id("com.mobeta.android.demodslv:id/activity_title")).click();
		
		List<AndroidElement> results =  driver.findElements(By.id("com.mobeta.android.demodslv:id/drag_handle"));
		AndroidElement source = results.get(2);
		AndroidElement target = results.get(6);
		TouchAction action = new TouchAction(driver);
		action.longPress(ElementOption.element(source))
		.moveTo(ElementOption.element(target)).release().perform();
		
		System.out.println("3aaaash Dropped Sucessfully");
		
		
	}


}

