	package chrome;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import org.zeroturnaround.zip.ZipUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {


	RemoteWebDriver driver;

	@Test
	public void loginToLeafTaps() {
		// Read the param                             

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();
		driver.findElementById("username").sendKeys("DemoSalesManager");
		driver.findElementById("password").sendKeys("crmsfa");
		try {
			FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE), new File("./images/1.png"));
		}catch (IOException e) {}
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByClassName("decorativeSubmit").click();
		
		driver.close();
	}
	
	@AfterSuite
	public void getZip() {
		ZipUtil.pack(new File("./images"), new File("./images.zip"));
	}













}
