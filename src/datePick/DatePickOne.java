package datePick;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DatePickOne {
  
	AndroidDriver<MobileElement> drv;
	DesiredCapabilities cap;
	
  @BeforeTest
  public void beforeTest() throws MalformedURLException, InterruptedException {
	  
	  	cap=new DesiredCapabilities();
	  	cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi");
		cap.setCapability("appPackage", "com.android.settings");
		cap.setCapability("appActivity", "MainSettings");
		//cap.setCapability("appWaitActivity","requestSplashScreen");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 3000);
		  
		  
		drv=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		Thread.sleep(3000);
	  
  }
  
  @Test(priority=1)
  public void f() {
	  
	
	  String uiSel="new UiSelector().text(\"Additional settings\")";
	  String command="new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("+uiSel+")";
	  
	  drv.findElementByAndroidUIAutomator(command).click();
	  drv.findElementByAndroidUIAutomator("new UiSelector().text(\"Date & time\")").click();
	  
	  //list all the checkbox elements in the current view.
	  List<MobileElement> togButtons=drv.findElements(By.xpath("//android.widget.ListView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.CheckBox"));
	  System.out.println("No of Toggle Buttons on current view is :"+togButtons.size());
	  //togButtons.get(0).click();
	  
	  if(togButtons.get(0).getAttribute("checked").toString().equals("true")){
		  System.out.println("Automatic Date and Time Update is Enabled");
		  togButtons.get(0).click();
	  }else{
		  System.out.println("Automatic Date and Time Update is Disabled");
	  }
  }
  
  @Test(priority=2)
  public void changeDate() throws InterruptedException{
	  
	  drv.findElement(By.xpath("//android.widget.ListView/"
	  		+ "android.widget.LinearLayout[@index='2']/"
	  		+ "android.widget.RelativeLayout[@index='0']")).click();
	  
	  Thread.sleep(3000);
	
	  List<MobileElement> dateFields=drv.findElements(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'miui:id/pickers')]/miui.widget.NumberPicker"));
	  System.out.println("NO of elements in date Fields are : "+dateFields.size());
	  List<MobileElement> dateButtons =dateFields.get(0).findElements(By.className("android.widget.Button"));
	  System.out.println("NO of elements in date Fields are : "+dateButtons.size());
	  
	  for(MobileElement x : dateButtons){
		  System.out.println("Elements are : "+x.getText());
	  }
	  dateButtons.get(0).tap(1, 1);
	  
	   	    
  }

  @AfterTest
  public void afterTest() {
	  drv.quit();
  }

}
