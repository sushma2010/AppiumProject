package Rahullshetty.FrameWork.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class FormPages extends Rahullshetty.FrameWork.Utils.AndroidGuester {
	AndroidDriver driver;
	
	 public FormPages(AndroidDriver driver) {
		 super (driver);
		 this.driver= driver;
		 PageFactory.initElements(new AppiumFieldDecorator(driver), this);
			
	 }
	
	//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Sushma");
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	
	@AndroidFindBy(xpath ="//android.widget.RadioButton[@text='Female']")
	private WebElement femaleOption;
	
	@AndroidFindBy(xpath ="//android.widget.RadioButton[@text='Male']")
	private WebElement MaleOption;
	
	@AndroidFindBy(id ="android:id/text1")
	private WebElement countrySelection;
	
	@AndroidFindBy(id ="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement shopButton;
	
	
	
	
	public void setactivity() {
		
		Activity activity = new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.MainActivity");
		((JavascriptExecutor)driver).executeScript("mobile:startActivity",ImmutableMap.of("intent","com.androidsample.generalstore/com.androidsample.generalstore.MainActivity"
		));
	}
	
	
	
	public void   setNameField ( String name )
	{
		nameField.sendKeys(name);
		driver.hideKeyboard();
	}
	
	
	public void   setGender ( String gender )
	{
		if (gender.contains("Female"))
			femaleOption.click();
		else
			MaleOption.click();
		
	}
	
	public void  setCountrySelection(String CountryName)
	{
		countrySelection.click();
		Scroltotext(CountryName);
		//driver.findElement(By.xpath("//android.widet.TextView[@text='"+CountryName+"']")).click();
		
	}
	
	public productcatalog sumitbutton()
	{
		shopButton.click();
		return new productcatalog(driver);
	}
	
	
}
