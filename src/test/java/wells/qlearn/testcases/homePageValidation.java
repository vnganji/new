package wells.qlearn.testcases;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import wells.qlearn.baseTest.baseTest;
import wells.qlearn.pages.homePage;

public class homePageValidation extends baseTest {
	
	@BeforeTest
	public void testbed() {
		
		log=LogManager.getLogger("homepagevalidation");
				
	}
	
	@Test(priority=1)
	public void verifyHomePage() {
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		homePage hp = new homePage();
		System.out.println(hp.getloginbtn().isDisplayed());
		log.info("page displayed");
		System.out.println("home opened");		
	}

}
