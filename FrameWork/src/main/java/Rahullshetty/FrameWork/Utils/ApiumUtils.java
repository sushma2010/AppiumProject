package Rahullshetty.FrameWork.Utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class ApiumUtils {  
	AppiumDriver driver;
	public AppiumDriverLocalService service;
	
	public AppiumDriverLocalService StartAppiumServer(String IpAddress, int port) {
		 service =new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\User\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
					.withIPAddress(IpAddress).usingPort(port).build();
				service.start();
				return service; 
	}
	
	public double  formatedamount (String amountString) {
		Double Price= Double.parseDouble(amountString.substring(1));
		return Price;
	}
	
	public void waitforelementtoappear(WebElement ele,AppiumDriver driver) {
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeToBe((ele), "text", "Cart"));
		
	}
	 
	public List<HashMap<String,String>> getJsonData(String jsonFilePath) throws IOException{
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonContent= FileUtils.readFileToString(new File(jsonFilePath),StandardCharsets.UTF_8);
		List<HashMap<String,String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String,String>>>() {});
	return data;
	}
	
	public String getScreenshotpath(String TestCaseName,AppiumDriver driver) throws IOException {
		File source = driver.getScreenshotAs(OutputType.FILE);
	String destinationFile = System.getProperty("user.dir")+"\\report"+TestCaseName+".png";
		FileUtils.copyFile(source,new File( destinationFile));
	return destinationFile;
	}
	
	
	
	
	
}
