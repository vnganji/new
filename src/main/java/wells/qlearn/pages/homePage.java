package wells.qlearn.pages;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.log4testng.Logger;

import wells.qlearn.reusables.DriverManager;
import wells.qlearn.reusables.basePage;

public class homePage extends basePage {
	
	//private WebDriver driver = null;

	@FindBy(xpath = "//h3[text()='An Academy to learn Everything about Testing']")
	public WebElement text_homePage;

	public WebElement getHomePagetext() {
		return text_homePage;
	}

	@FindBy(xpath = "//span[text()='Login']")
	public WebElement btn_login;

	public WebElement getloginbtn() {
		return btn_login;
	}

	public homePage() {
		log = LogManager.getLogger("homePage");
		
		//PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
		PageFactory.initElements(driver, this);
		verifyPage(this);
	}

	public boolean verifyLinks(String str) {

		boolean retval = true;
		String[] expectedLinks = str.split("|");
		List<String> expectedLinksnames = Arrays.asList(expectedLinks);
		List<WebElement> actuallinks = driver.findElements(By.xpath("//ul[@class='nav navbar-nav navbar-right']/li"));
		if (actuallinks.size() == 8) {
			log.info("Number of links dispalyed 8");
			sAssert.assertTrue(true);
		} else {
			log.info("Number of links dispalyed on home page is not  8");
			sAssert.assertTrue(false);
		}

		for (WebElement lnks : actuallinks) {
			if (!(expectedLinksnames.contains(lnks))) {
				log.error(lnks + " link not displayed on the home page");
				sAssert.assertTrue(false);
				retval = false;
			}

		}
		sAssert.assertAll();
		return retval;

	}

	@Override
	public ExpectedCondition getPageCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(text_homePage);
	}

}
