package wells.qlearn.reusables;

import java.util.concurrent.TimeoutException;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class basePage extends WFCustActions {



	public <T> void verifyPage(T page) {

		log = LogManager.getLogger("basePage");
		String pageName = page.getClass().getName();
		ExpectedCondition pageCondition = ((basePage) page).getPageCondition();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(pageCondition);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(pageName + " Not Displayed");
			sAssert.fail(pageName + " Not Displayed");
			System.exit(0);
		}
		log.error(pageName + " Displayed");
		sAssert.assertAll();

	}

	public abstract ExpectedCondition getPageCondition();

}
