package Rahullshetty.FrameWork;



import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Rahullshetty.FrameWork.pageobject.CartPage;
import Rahullshetty.FrameWork.pageobject.productcatalog;
import Rahullshetty.FrameWork.testUtils.BaseTest;


public class ecommerce_hybrid3 extends BaseTest{
	
	/*@BeforeMethod
    public void setup() {
		Activity activity = new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.SplashActivity");
		((JavascriptExecutor)driver).executeScript("mobile:startActivity",ImmutableMap.of("intent","com.androidsample.generalstore/com.androidsample.generalstore.SplashActivity"
		));
    }*/
	

	
	
	@Test(dataProvider="getData")
	public void fillform(HashMap<String,String> input) throws InterruptedException {
		
		//FormPages formPage = new FormPages(driver); initialize already taken care in base test
		
		formPage.setNameField(input.get("name"));
		formPage.setGender(input.get("gender"));
		formPage.setCountrySelection(input.get("country"));
		productcatalog productcatalog =formPage.sumitbutton();
		
		
		productcatalog.addItemsToCartByIndex(0);
		productcatalog.addItemsToCartByIndex(0);
		CartPage cartpage=productcatalog.gotocartpage();
		
		
		//WebElement valil= driver.findElement(By.id(""com.androidsample.generalstore:id/toolbar_title"")).click();
	
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeToBe((driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title"))), "text", "Cart"));
		
		
		
		Double totalsum= cartpage.getProcuctsum();
		Double displayedFormatedsum= cartpage.gettotalamount();
		
		
		AssertJUnit.assertEquals(totalsum, displayedFormatedsum);
		cartpage.acceptTerms();
		cartpage.Submiorder();	
		driver.navigate().back();
		
	
		
		
	}
	
	
	 
	@DataProvider
	 public Object[][] getData() throws IOException
	{
		List<HashMap<String,String>> data = getJsonData(System.getProperty("user.dir")+"\\src\\test\\java\\Rahullshetty\\FrameWork\\testdata\\ecommerce.json");
		return new Object[][] {{data.get(0)},{data.get(1)} };
	}
	
	//,
	
	
	
	

	}
