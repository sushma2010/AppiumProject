package Rahullshetty.FrameWork.testdata;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Rahullshetty.FrameWork.testUtils.BaseTest;
import io.appium.java_client.AppiumBy;

public class errortest extends BaseTest {
	@Test(groups= {"Smoke"})
	public void fillformerror() throws InterruptedException {
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.androidUIAutomator( "new UiScrollable(new UiSelector()).scrollIntoView(text(\"Austria\"));"
				 )).click();
			
		
		//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Sushma");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	String message = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		Assert.assertEquals(message, "Pleas  enter your ");
		}
	
	
}
