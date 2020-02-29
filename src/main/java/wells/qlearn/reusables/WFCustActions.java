package wells.qlearn.reusables;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.asserts.SoftAssert;

public class WFCustActions {

	public static Logger log = LogManager.getLogger(WFCustActions.class.getName());
	public static SoftAssert sAssert = new SoftAssert();
	public static WebDriver driver;
	public static String rootPath = System.getProperty("user.dir");
	public static Properties prop = new Properties();
	
	public static Map<String,RemoteWebDriver> RemoteDriver = new HashMap<String,RemoteWebDriver>();
	public static Map<String,WebDriver> LocalDriver = new HashMap<String,WebDriver>();
	
	public void setPropertiesfile() throws IOException{
		FileInputStream file = new FileInputStream(rootPath+"\\src\\main\\resources\\Properties\\config.properties");
		prop.load(file);
	}
	
	public void setDriver() throws IOException{
		
		DesiredCapabilities dc = new DesiredCapabilities();
		ChromeOptions ch = new ChromeOptions();
		if (prop.getProperty("browser").equalsIgnoreCase("chrome")){
			//building for remotedriver
			/*dc.setBrowserName("chrome");
			dc.setPlatform(Platform.WINDOWS);
			//driver = new RemoteWebDriver(new URL(prop.getProperty("gridClient")),dc);
			RemoteDriver.put("chrome", (new RemoteWebDriver(new URL(prop.getProperty("gridClient")),dc)));*/
			//building for driver
			//System.setProperty("webdriver.chrome.driver", rootPath+"\\src\\main\\resources\\Executables\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver","C:\\Users\\ADMIN\\Jars2020\\chromedriver_win3\\chromedriver.exe");
			//driver= new ChromeDriver();
			//adding local driver
			LocalDriver.put("chrome", new ChromeDriver());
			
			
		}
			
	}

	public void setText(WebElement obj, String str, String Desc) {
		try {
			obj.sendKeys(str);
			log.info(Desc + " set with value " + str + " successfully");

		} catch (Exception e) {
			e.printStackTrace();
			log.error(Desc + " not found on the page");
		}

	}

	public void click(WebElement obj,String Desc) {
		try {
			obj.click();
			log.info(Desc + " clicked successfully");

		} catch (Exception e) {
			e.printStackTrace();
			log.error(Desc + " not found on the page");
		}

	}
}
