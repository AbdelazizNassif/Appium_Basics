package olx;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.touch.offset.PointOption;

public class Olx_PlaceAd {
	private static AndroidDriver<AndroidElement> driver;
	Wait wait ;


	public void allowAppPermission(){
		while (driver.findElements(MobileBy.xpath("//*[@class='android.widget.Button'][2]")).size()>0) 
		{  
			driver.findElement(MobileBy.xpath("//*[@class='android.widget.Button'][2]")).click();
		}
	}

	@Test
	public void test1() throws MalformedURLException, InterruptedException {


		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("automationName", "UiAutomator2");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "8.0.0");
		capabilities.setCapability("deviceName", "emulator-5554");
		capabilities.setCapability("app", System.getProperty("user.dir") + "\\application\\com.olxmena.horizontal_2020-08-16.apk");

		driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), capabilities);
		wait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		Thread.sleep(3000);

		driver.findElement(By.xpath("//android.widget.TextView[@text='Egypt']")).click();

		AndroidElement Register = driver.findElement(By.xpath("//android.widget.TextView[@text='Register Here']"));

		Assert.assertTrue(Register.isDisplayed());

		driver.pressKey(new KeyEvent(AndroidKey.BACK));


		allowAppPermission();

		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Place an Ad']")).click();
		
		allowAppPermission();
		
		allowAppPermission();
		
		// flaky
		driver.findElement(By.xpath("//android.widget.TextView[@text='Properties']")).click();
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Villas For Sale']")).click();
		
		driver.findElement(By.xpath("//android.widget.EditText[@text='Title']")).sendKeys("My Vila For Sale");
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Ad Type']")).click();
		
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='For Sale']")).click();
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Type']")).click();
		
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Stand Alone Villa']")).click();
		
		driver.findElement(By.xpath("//android.widget.Button[@text='Price (EGP)']")).click();
		
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.olxmena.horizontal:id/value']")).sendKeys("20000");
		
		driver.findElement(By.xpath("//android.widget.CheckBox[@text='Price Negotiable']")).click();
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='OK']")).click();
		
		// scroll to payment option
		
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)"
				+ ".instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + "Payment Option" + "\").instance(0))"));
		
		
		driver.findElement(By.xpath("//android.widget.Button[@text='Amenities']")).click();
		
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Balcony']")).click();
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='READY']")).click();
		
		
		
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)"
				+ ".instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + "Phone" + "\").instance(0))"));

		//   dcdcdcdcdscdcdcscddscdscdscdscdscscddc
		


		
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)"
				+ ".instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + "Submit" + "\").instance(0))"));
		
		driver.findElement(By.xpath("//android.widget.Button[@text='Submit']")).click();
		
		driver.quit();
		
		
		
		


	}
}
