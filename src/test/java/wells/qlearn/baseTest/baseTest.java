package wells.qlearn.baseTest;

import java.io.IOException;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import wells.qlearn.reusables.DriverManager;
import wells.qlearn.reusables.WFCustActions;

public class baseTest extends WFCustActions {

	@BeforeSuite
	public void setUp() throws IOException {

		setPropertiesfile();
		setDriver();
		if (prop.getProperty("grid").equalsIgnoreCase("true")) {
			DriverManager.setDriver(RemoteDriver.get(prop.getProperty("browser")));
		} else {
			DriverManager.setDriver(LocalDriver.get(prop.getProperty("browser")));
		}
		driver = DriverManager.getDriver();
		System.out.println("hi");
	}


}
