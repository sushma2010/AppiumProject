package Rahullshetty.FrameWork.Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;

public class AndroidGuester extends ApiumUtils {

	 AndroidDriver driver;
	public AndroidGuester(AndroidDriver driver) {
		
		this.driver= driver;
	}
	
	public void Scroltotext(String text) {
		driver.findElement(AppiumBy.androidUIAutomator( "new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));")).click();
	}
	
	public void longpressactive(WebElement ele) 
	{
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement)ele).getId(),"duration",2000));
	}
	
	public void SwipeAction(WebElement ele1 , String  direction ) 
	{
		((JavascriptExecutor)driver).executeScript("mobile: swipeGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement)ele1).getId(),"direction",direction, "percent",0.75));
		//after swipe
	}
	public void Dragdrop(WebElement ele2) 
	{
		((JavascriptExecutor)driver).executeScript("mobile: dragGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement)ele2).getId(),
						"endX",619,"endY",560
						));
		//after swipe
	}
	
	
	
	
	
}
