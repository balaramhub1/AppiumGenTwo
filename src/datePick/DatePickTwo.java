package datePick;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DatePickTwo {
	
	DesiredCapabilities cap;
	AndroidDriver drv;
 
  @BeforeTest
  public void beforeTest() throws MalformedURLException, InterruptedException {
	  
	  cap=new DesiredCapabilities();
	  cap.setCapability(MobileCapabilityType.APP_PACKAGE, "com.android.settings");
	  cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	  cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi");
	  cap.setCapability(MobileCapabilityType.APP_ACTIVITY, "MainSettings");
	  cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 3000);
	  
	  drv=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
	  Thread.sleep(3000);
	  	  
	  
  }
  
  
  @Test
  public void f() {
	  
	  drv.findElementByAndroidUIAutomator("new UiSelector().text(\"Display\")").click();
	  
	  
  }

  @AfterTest
  public void afterTest() {
	  
	  drv.quit();
  }

}
