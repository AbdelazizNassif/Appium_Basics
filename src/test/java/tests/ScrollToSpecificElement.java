
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

public class ScrollToSpecificElement {

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
		

		AndroidElement viewBtn = driver.findElement(By.xpath("//android.widget.TextView[@text='Views']"));
		viewBtn.click();
        Thread.sleep(5000);
       
        
        Dimension dimensions = driver.manage().window().getSize();
        Double point = dimensions.getHeight() * 0.45;
        int pointAsAnInteger = point.intValue();
        
        int spinner_Count = driver.findElements(By.xpath("//android.widget.TextView[@text='Spinner']")).size();
        System.out.println("Spinner count is : " + spinner_Count);
        
        do {
        	TouchAction action = new TouchAction(driver);
            action.press(PointOption.point(0 , pointAsAnInteger * 2))
            .moveTo(PointOption.point(0 , pointAsAnInteger))
            .release()
            .perform();
        	spinner_Count = driver.findElements(By.xpath("//android.widget.TextView[@text='Spinner']")).size();
        	System.out.println("Spinner count is : " + spinner_Count);
        }
        while(spinner_Count == 0);
        AndroidElement spinnerButton = driver.findElement(By.xpath("//android.widget.TextView[@text='Spinner']"));
        spinnerButton.click();
        Thread.sleep(3000);
        
      
   
	}


}

