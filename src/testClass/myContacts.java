package testClass;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;

public class myContacts {
	
	AndroidDriver drv;
	DesiredCapabilities cap;
	
  
  @BeforeTest
  public void beforeTest() throws MalformedURLException {
	  
	  cap=new DesiredCapabilities();
	  cap.setCapability(MobileCapabilityType.APP_PACKAGE,"com.android.contacts");
	  cap.setCapability(MobileCapabilityType.APP_ACTIVITY,"activities.PeopleActivity");
	  cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	  cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi");
	  
	  drv=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
	  
  }
  
  @Test
  public void f() throws InterruptedException {
	  
	  drv.findElement(By.id("android:id/icon")).click();
	  
	  drv.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'com.android.contacts:id/name_container')]/"
	  		+ "android.widget.LinearLayout[@index='0']")).sendKeys("abcd");
	  
	  Thread.sleep(3000);
  }

  @AfterTest
  public void afterTest() {
	  drv.quit();
  }

}
