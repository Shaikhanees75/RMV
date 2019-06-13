package com.RM.Main_Scripts;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.RM.Generic.EnvironmentVariables;
import com.RM.Generic.GenericMethods2;
import com.RM.Generic.common_methods;
import com.RM.Scripts.Project_Project_POC_Test;
import com.RM.Scripts.Project_Project_type_Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Project_Project_POC_Main {

	GenericMethods2 gm = new GenericMethods2();
	common_methods cm = new common_methods();
	Project_Project_POC_Test PPT = new Project_Project_POC_Test();
	ExtentReports reports;
	ExtentTest logger;
	// WebDriver driver;

	@BeforeClass()
	public void Browser_set() throws InterruptedException {
		try {
			// Open Browser
			cm.Open();
			Thread.sleep(10000);
			// Extend Reports
			reports = new ExtentReports(EnvironmentVariables.reportPath);
			logger = reports.startTest("Project POC Type");
		} catch (Exception e) {
			System.out.println("Message" + e);
			gm.logFail(logger, "Exception occured" + e, cm.driver);
		}
	}

	@Test(priority = 1)
	// Go to Skill change page
	public void Menu_Navigation() throws Exception {
		try {
			PPT.navigate_to_Project_POC_Type(cm.driver, logger);
		} catch (Exception e) {
			System.out.println("Message" + e);
			gm.logFail(logger, "Exception occured" + e, cm.driver);
		}
	}

	@Test(priority = 2, dataProvider = "Project_POC_Type")
	public void Project_POC_type(String Flag, String Action, String POC_type_name, String Role, String RM_User,
			String Status, String Search) throws Exception {
		try {
			if (Flag.equalsIgnoreCase("y") && Action.equals("Add")) {
				try {
					PPT.add(cm.driver, POC_type_name, Role, RM_User, Status, Search, logger);
				} catch (Exception e) {
					gm.logFail(logger, "Exception occured" + e, cm.driver);
				}
			} else if (Flag.equalsIgnoreCase("y") && Action.equals("Edit")) {
				try {
					PPT.Edit(cm.driver, POC_type_name, Role, RM_User, Status, Search, logger);
				} catch (Exception e) {
					gm.logFail(logger, "Exception occured" + e, cm.driver);
				}
			}

		} catch (Exception e) {

			System.out.println("Message" + e);
			gm.logFail(logger, "Exception occured" + e, cm.driver);
		}

	}

	@DataProvider(name = "Project_POC_Type")
	public Object[][] getData() {
		Object[][] c1 = gm.getExcelData(EnvironmentVariables.dataPoolPath, "Project_POC_Type");
		return c1;
	}

	@Test(priority = 3)
	public void tear() {
		cm.driver.quit();
	}

	@AfterClass
	public void tearDown() {
		reports.endTest(logger);
		reports.flush();

	}

}
