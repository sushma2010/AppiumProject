package Rahullshetty.FrameWork.pageobject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage extends Rahullshetty.FrameWork.Utils.AndroidGuester {
	AndroidDriver driver;
	
	 public CartPage(AndroidDriver driver) {
		 super (driver);
		 this.driver= driver;
		 PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		 
	 }
		 @AndroidFindBy (id ="com.androidsample.generalstore:id/productPrice")
			private List< WebElement> prodcutlist ;
		 
		 @AndroidFindBy(id ="com.androidsample.generalstore:id/totalAmountLbl")
			private WebElement totalAmount;
			
		 
		 @AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
			private WebElement tems;
		 
		 @AndroidFindBy(id ="android:id/button1")
			private WebElement acceptButton;
		 
		 @AndroidFindBy(className ="android.widget.CheckBox")
			private WebElement checkbox;
		 
		 @AndroidFindBy(id ="com.androidsample.generalstore:id/btnProceed")
			private WebElement proceed;
		 
		 public List<WebElement> getProductList()
		 {
			 
			 return prodcutlist;
		 }
		 
	  public double getProcuctsum() {
		  int count= prodcutlist.size();
			double sum = 0;
			for(int i=0;i<count;i++) {
				String amountString=  prodcutlist.get(i).getText();
				//Double Price= Double.parseDouble(amountString.substring(1));
				Double price=formatedamount(amountString);
				sum = sum + price;
			}
		  return sum;
	  }
	public Double gettotalamount() {
		
	return formatedamount(totalAmount.getText());
	}
	 public void acceptTerms() throws InterruptedException {
		 longpressactive(tems);
		 acceptButton.click();
		 Thread.sleep(3000);
	 }

	 
	 public void Submiorder() {
		 checkbox.click();
		 //driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		 proceed.click();
	 }
	 
}
