
package tests;

import org.openqa.selenium.Dimension;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class SwipingR_L {

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
		
		Thread.sleep(3000);
		TouchAction action = new TouchAction(driver);

		AndroidElement animationButton = driver.findElement(By.xpath("//android.widget.TextView[@text='Animation']"));
        animationButton.click();
        Thread.sleep(5000);
        
        AndroidElement bouncingBallsButton = driver.findElement(By.xpath("//android.widget.TextView[@text='Bouncing Balls']"));
        bouncingBallsButton.click();
        Thread.sleep(3000);
        
        Dimension dimensions = driver.manage().window().getSize();
        System.out.println("Device X and Y are: " + dimensions);
        
        Double point = dimensions.getWidth() * 0.45;
        System.out.println("45% of the screen width will be : " + point);
        
        int pointAsAnInteger = point.intValue();
        System.out.println(pointAsAnInteger);
        System.out.println(pointAsAnInteger * 2);
        
        
        action.press(PointOption.point(0 , pointAsAnInteger))
        .waitAction(new WaitOptions().withDuration(Duration.ofMillis(5000)))
        .moveTo(PointOption.point(pointAsAnInteger*2 , pointAsAnInteger))
        .release()
        .perform();
        
        action.press(PointOption.point(pointAsAnInteger*2 , pointAsAnInteger))
        .waitAction(new WaitOptions().withDuration(Duration.ofMillis(5000)))
        .moveTo(PointOption.point( 0, pointAsAnInteger))
        .release()
        .perform();
        

	}


}

