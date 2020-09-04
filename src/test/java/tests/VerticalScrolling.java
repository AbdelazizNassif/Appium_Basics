
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

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class VerticalScrolling {

	private static AndroidDriver<AndroidElement> driver;


	@Test
	public void test1() throws MalformedURLException, InterruptedException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("automationName", "UiAutomator2");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "8.0.0");
		capabilities.setCapability("deviceName", "emulator-5554");
		capabilities.setCapability("app", System.getProperty("user.dir") + "\\application\\ApiDemos-debug.apk");
		
		driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		AndroidElement viewBtn = driver.findElement(By.xpath("//android.widget.TextView[@text='Views']"));
		viewBtn.click();
		
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)"
				+ ".instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + "Switches" + "\").instance(0))"));
		
		
		AndroidElement switchBtn = driver.findElement(By.xpath("//android.widget.TextView[@text='Switches']"));
		System.out.println(switchBtn.getLocation());
		switchBtn.click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//android.widget.TextView[@text='Views/Switches']")).isDisplayed());
		
		driver.findElement(By.xpath("//android.widget.Switch[@resource-id='io.appium.android.apis:id/monitored_switch']")).click();
		
		driver.findElement(By.xpath("//android.widget.Switch[@text='Customized text NO']")).click();

	}


}

