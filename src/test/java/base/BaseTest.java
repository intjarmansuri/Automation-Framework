package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {
	
	public WebDriver driver;
	public Logger logger;
	public Properties p;
	
	@BeforeClass
	@Parameters({"browser"})
	public void setup(String br) throws IOException {
		FileInputStream file = new FileInputStream(".//src//test//resources//config.properties");
		p = new Properties();
		p.load(file);
		
		// logs
		logger = LogManager.getLogger(this.getClass());
		
		switch(br.toLowerCase()) {
		case "chrome":
			ChromeOptions coptions = new ChromeOptions();
//			coptions.addArguments("--headless=true");
			coptions.addArguments("--window-size=1920,1080");
			driver = new ChromeDriver(coptions);
			break;
		
		case "firefox":
			FirefoxOptions foptions = new FirefoxOptions();
			foptions.addArguments("--headless=true");
			foptions.addArguments("--window-size=1920,1080");
			driver = new FirefoxDriver(foptions);
			break;
			
		default: System.out.println("No matching browser..."); 
			return;
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appURL"));
	}
	
	public String capstureScreen(WebDriver driver, String tname) throws IOException {
		System.out.println("Capturing screnshot....");
		
		String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String targetDir = System.getProperty("user.dir") + "/screenshots/";
		File dir = new File(targetDir);
			if(!dir.exists()) {
				dir.mkdir();
			}
			
			String targetFilePath = targetDir + tname + "_" + timeStamp + ".png";
			File targetFile = new File(targetFilePath);
			
			FileUtils.copyFile(sourceFile, targetFile);
			System.out.println("Screenshot saved at: " + targetFilePath);
			return targetFilePath;
		}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}