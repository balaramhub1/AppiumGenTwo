package appNoReset;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

/*
 * java-client 3.2.0
 */

public class AppNoResetOne {
	
	MobileDriver drv;
	DesiredCapabilities cap;
  
  @BeforeTest
  public void beforeTest() throws MalformedURLException {
	  
	  File appDir=new File("D:\\Appium_TR\\APKfiles\\");
	  File appName=new File(appDir,"vehicleRegistrationInd.apk");
	  
	  cap=new DesiredCapabilities();
	  cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi");
	  cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	  cap.setCapability(MobileCapabilityType.APP, appName.getAbsolutePath());
	  cap.setCapability("noReset", true);
	  
	  
	  //Below 2 desiredCapabilities are not applicable in java-client 4.0
	  //cap.setCapability(MobileCapabilityType.APP_PACKAGE, "com.finessCalculator");
	  //cap.setCapability(MobileCapabilityType.APP_ACTIVITY, "FitnessCalculatorActivity");
	  
	  drv=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
	  
	  
  }
  
  
  @Test
  public void f() {
	  
  }

  @AfterTest
  public void afterTest() {
	  drv.quit();
  }

}
