package genOne;

import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;

public class NaviDrawerOne {
	
	AndroidDriver drv;
	DesiredCapabilities cap;
  
  @BeforeTest
  public void beforeTest() throws MalformedURLException {
	  
	  cap=new DesiredCapabilities();
	  cap.setCapability(MobileCapabilityType.APP_ACTIVITY, "MainActivity");
	  cap.setCapability(MobileCapabilityType.APP_PACKAGE, "com.wingtech.filemanager");
	  cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Lenovo A6000");
	  cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	  cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "200");
	 	  
	  drv=new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
	  drv.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  
	  
  }
  
  @Test
  public void f() throws InterruptedException {
	  
	  drv.findElement(By.id("com.wingtech.filemanager:id/titlebar_sliderImage")).click();
	  Thread.sleep(3000);
	  drv.findElement(By.id("com.wingtech.filemanager:id/dirlistitem_text_quit")).click();
	  
	  
  }

  @AfterTest
  public void afterTest() {
	  drv.quit();
	  
  }

}
