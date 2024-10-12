package Rahullshetty.FrameWork.testUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import Rahullshetty.FrameWork.Utils.ApiumUtils;
import Rahullshetty.FrameWork.pageobject.FormPages;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseTest extends ApiumUtils {
	public  AndroidDriver driver;
	public AppiumDriverLocalService service;
	 public FormPages formPage;
	
	@BeforeClass(alwaysRun=true)
	public void ConfigureAppium() throws URISyntaxException, IOException {
		Properties pro= new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Rahullshetty\\FrameWork\\resources\\data.properties");
		pro.load(fis);
		String Ipaddress= System.getProperty("ipAddress")!= null?System.getProperty("ipAddress"):pro.getProperty("ipAddress");
		//String Ipaddress = pro.getProperty("ipAddress");
		String port =pro.getProperty("Port");
		service= StartAppiumServer(Ipaddress, Integer.parseInt(port));
		
		UiAutomator2Options options =new UiAutomator2Options();
		options.setDeviceName("sushmaemulator");
		//options.setDeviceName("android device");
		//options.setApp("C:\\Users\\User\\eclipse-workspace\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");
		options.setApp(System.getProperty("user.dir")+"\\src\\test\\java\\resource\\General-Store.apk");
		
		driver = new AndroidDriver(service.getUrl(),options);
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 	 formPage = new FormPages(driver);
	}
	
	
	@AfterClass(alwaysRun=true)
	public void tearDown()
	 {
		driver.quit();
		service.stop();

}
}
