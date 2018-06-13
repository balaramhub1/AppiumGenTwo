package genOne;

import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;

public class HideKeyBoardOne {
	
	//AndroidDriver drv;
	AndroidDriver<MobileElement> drv;
	// to supress the warning.
	DesiredCapabilities cap;
  
  // test done on contacts app, mi redmi prime
	
  @BeforeTest
  public void beforeTest() throws MalformedURLException, InterruptedException {
	  
	  	cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi");
		cap.setCapability("appPackage", "com.android.contacts");
		cap.setCapability("appActivity", "activities.PeopleActivity");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 200);
		  
		  
		drv=new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		Thread.sleep(3000);
  }
  
  
  @Test
  public void f() throws InterruptedException {
	  drv.findElement(By.id("android:id/input")).click();
	  Thread.sleep(3000);
	  drv.hideKeyboard();
	  Thread.sleep(3000);
	  
	  
  }

  @AfterTest
  public void afterTest() {
	  drv.quit();
  }

}
