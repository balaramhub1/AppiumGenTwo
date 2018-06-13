package genOne;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AssertionOne {
	
	AndroidDriver<MobileElement> drv;
	DesiredCapabilities cap;
  
	@BeforeTest
	public void beforeTest() {
	}
	
	@Test
	public void f() {
	}
  

	@AfterTest
	public void afterTest() {
	}

}
