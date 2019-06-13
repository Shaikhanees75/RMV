package com.RM.Scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.RM.Generic.GenericMethods2;
import com.RM.Generic.common_methods;
import com.RM.POM.Project_Project_POC_Obj;
import com.RM.POM.Project_Project_type_Obj;
import com.RM.POM.Skill_WTCG_Obj;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Project_Project_POC_Test {

	static WebDriver driver;
	static GenericMethods2 gm = new GenericMethods2();
	common_methods cm = new common_methods();
	static ExtentTest logger;
	static ExtentReports reports;

	public void navigate_to_Project_POC_Type(WebDriver driver, ExtentTest logger) {
		// hover on Instance set up
		WebElement instance_setup = driver.findElement(Skill_WTCG_Obj.instance_setup);
		Actions action = new Actions(driver);
		action.moveToElement(instance_setup).build().perform();
		gm.logInfo(logger, "We have hovered on Resource_planner Menu", driver);

		// hover on demographics
		WebElement demographics = driver.findElement(Project_Project_type_Obj.demographics);
		Actions action1 = new Actions(driver);
		action1.moveToElement(demographics).build().perform();

		// hover on project_masters
		WebElement project_masters = driver.findElement(Project_Project_type_Obj.project_masters);
		Actions action2 = new Actions(driver);
		action1.moveToElement(project_masters).build().perform();
		gm.logInfo(logger, "We have hovered on project_masters Menu", driver);

		// hover on industry
		WebElement industry = driver.findElement(Project_Project_type_Obj.industry);
		Actions action3 = new Actions(driver);
		action3.moveToElement(industry).build().perform();

		// hover on project poc type
		WebElement project_Poc_type = driver.findElement(Project_Project_POC_Obj.project_POC_type);
		project_Poc_type.click();
		gm.logInfo(logger, "We have clicked on project_POC_type sub menu", driver);

	}

	public void add(WebDriver driver, String POC_type_name, String Role, String RM_User, String Status, String Search,
			ExtentTest logger) throws Exception {

		// click on Add btn
		WebElement add_btn = driver.findElement(Project_Project_POC_Obj.add_btn);
		gm.waitForObject(driver, Project_Project_POC_Obj.add_btn);
		add_btn.click();
		Thread.sleep(1000);

		// enter poc name
		gm.enterText(driver, Project_Project_POC_Obj.poc_type_name, POC_type_name, "POC_type_name", logger);
		Thread.sleep(1000);

		// click on cancel button
		WebElement cancel_btn = driver.findElement(Project_Project_POC_Obj.cancel_btn);
		cancel_btn.click();
		gm.logInfo(logger, "We have clicked on cancel button", driver);
		Thread.sleep(1000);

		// click on Add btn
		WebElement add_btn1 = driver.findElement(Project_Project_POC_Obj.add_btn);
		gm.waitForObject(driver, Project_Project_POC_Obj.add_btn);
		add_btn1.click();
		Thread.sleep(1000);

		// enter poc name
		gm.enterText(driver, Project_Project_POC_Obj.poc_type_name, POC_type_name, "POC_type_name", logger);
		Thread.sleep(1000);

		// select role
		gm.selectValueFromListByText(driver, Project_Project_POC_Obj.role, Role, "Role", logger);
		Thread.sleep(1000);

		// select rm user
		gm.selectValueFromListByText(driver, Project_Project_POC_Obj.rm_user, RM_User, "RM_User", logger);
		Thread.sleep(1000);

		// select Active
		gm.selectValueFromListByText(driver, Project_Project_POC_Obj.active, Status, "Status", logger);
		Thread.sleep(1000);

		// Click on save button
		WebElement save_btn = driver.findElement(Project_Project_POC_Obj.save_btn);
		save_btn.click();
		gm.logInfo(logger, "We have clicked on save button", driver);
		Thread.sleep(2000);

		String success_msg = driver.findElement(Project_Project_POC_Obj.success_msg).getText();

		if (success_msg.contains("Success")) {
			gm.logPass(logger, "POC type was sucessfully saved", driver);
		}

		else {
			gm.logFail(logger, "Error occured while saving kindly review the record", driver);
		}

		// validation on save
		// go to poc type dearch box
		gm.enterText(driver, Project_Project_POC_Obj.search_poc_type, POC_type_name, "POC_type_name", logger);
		WebElement search = driver.findElement(Project_Project_POC_Obj.search_poc_type);
		search.sendKeys(Keys.ENTER);

		// verify text with the search result
		String verify = driver
				.findElement(By.xpath(".//*[@id='fixTable']/tbody/tr/td[3][text()='" + POC_type_name + "']")).getText();
		System.out.println(verify);
		Thread.sleep(3000);

		if (verify.contains(POC_type_name)) {
			gm.logPass(logger, "Validation successful", driver);
			System.out.println("Test cases for Project type creation -- Passed");
		} else {
			gm.logFail(logger, "Test case failed, check for error", driver);
			System.out.println("Test case Failed");
		}

	}

	public void Edit(WebDriver driver, String POC_type_name, String Role, String RM_User, String Status, String Search,
			ExtentTest logger) throws Exception {
		WebElement search = driver.findElement(Project_Project_POC_Obj.search_poc_type);
		search.clear();
		Thread.sleep(1000);
		// search for the record to be edited
		gm.enterText(driver, Project_Project_POC_Obj.search_poc_type, POC_type_name, "POC_type_name", logger);

		// click on Edit
		WebElement edit_btn = driver
				.findElement(By.xpath(".//*[@id='fixTable']/tbody/tr/td[text()='" + POC_type_name + "']//..//td[1]"));
		edit_btn.click();
		gm.logInfo(logger, "We have clicked on Edit button", driver);

		// change RM user
		gm.selectValueFromListByText(driver, Project_Project_POC_Obj.rm_user, RM_User, "RM_User", logger);
		Thread.sleep(1000);

		// change status
		gm.selectValueFromListByText(driver, Project_Project_POC_Obj.active, Status, Status, logger);

		// click on update button
		WebElement update_btn = driver.findElement(Project_Project_POC_Obj.update_btn);
		update_btn.click();
		gm.logInfo(logger, "We have clicked on update button", driver);

		String success_msg = driver.findElement(Project_Project_POC_Obj.success_msg).getText();

		if (success_msg.contains("Success")) {
			gm.logPass(logger, "POC type was sucessfully Updated", driver);
		}

		else {
			gm.logFail(logger, "Error occured while saving kindly review the record", driver);
		}

		// check current status for the updated record
		// validate update
		gm.enterText(driver, Project_Project_POC_Obj.search_poc_type, POC_type_name, "POC_type_name", logger);
		WebElement search1 = driver.findElement(Project_Project_POC_Obj.search_poc_type);
		search1.sendKeys(Keys.ENTER);

		// verify text with the search result
		String verify = driver
				.findElement(By.xpath(".//*[@id='fixTable']/tbody/tr/td[3][text()='" + Status + "']//..//td[6]"))
				.getText();
		System.out.println(verify);
		Thread.sleep(3000);

		if (verify.contains(Status)) {
			gm.logPass(logger, "Validation for update successful", driver);
			System.out.println("Test cases for Project type Update -- Passed");
		} 
		else {
			gm.logFail(logger, "Test case failed, check for error", driver);
			System.out.println("Test case Failed");
		}

	}

}
