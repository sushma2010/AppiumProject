package Rahullshetty.FrameWork.pageobject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class productcatalog extends Rahullshetty.FrameWork.Utils.AndroidGuester {

	AndroidDriver driver;
	
	 public productcatalog(AndroidDriver driver) {
		 super (driver);
		 this.driver= driver;
		 PageFactory.initElements(new AppiumFieldDecorator(driver), this);
			
	 }
	 //findelements
	 
	 @AndroidFindBy(xpath ="//android.widget.TextView[@text='ADD TO CART']")
		private List< WebElement>  Addtocartbutton;
	 
	 @AndroidFindBy(id ="com.androidsample.generalstore:id/appbar_btn_cart")
		private WebElement cart;
	 
	 public void addItemsToCartByIndex(int index) {
		 Addtocartbutton.get(index).click();
	 }
	 
	 public CartPage gotocartpage() throws InterruptedException {
		 cart.click();
		 Thread.sleep(2000);
		 return new CartPage(driver);
	 }
	 
	 
}
