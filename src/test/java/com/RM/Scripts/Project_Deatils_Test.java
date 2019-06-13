package com.RM.Scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.RM.Generic.GenericMethods2;
import com.RM.Generic.common_methods;
import com.RM.POM.Project_Deatils_Obj;
import com.RM.POM.Project_Project_POC_Obj;
import com.RM.POM.Project_Project_type_Obj;
import com.RM.POM.Skill_WTCG_Obj;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Project_Deatils_Test {
	
	
	static WebDriver driver;
	static GenericMethods2 gm = new GenericMethods2();
	common_methods cm = new common_methods();
	static ExtentTest logger;
	static ExtentReports reports;
	
	public void navigate_to_Project_Details(WebDriver driver, ExtentTest logger)
	{
		// hover on Instance set up
					WebElement instance_setup = driver.findElement(Skill_WTCG_Obj.instance_setup);
					Actions action = new Actions(driver);
					action.moveToElement(instance_setup).build().perform();
					gm.logInfo(logger, "We have hovered on Resource_planner Menu", driver);
					
					
					
					// hover on demographics
								WebElement demographics = driver.findElement(Project_Project_type_Obj.demographics);
								Actions action1 = new Actions(driver);
								action1.moveToElement(demographics).build().perform();
								
								
					
								//hover on project_masters
								WebElement project_masters = driver.findElement(Project_Project_type_Obj.project_masters);
								Actions action2 = new Actions(driver);
								action1.moveToElement(project_masters).build().perform();
								gm.logInfo(logger, "We have hovered on project_masters Menu", driver);
								
								//hover on industry
								WebElement industry = driver.findElement(Project_Project_type_Obj.industry);
								Actions action3 = new Actions(driver);
								action3.moveToElement(industry).build().perform();
								
								
								//hover on project poc type
								WebElement project_details = driver.findElement(Project_Deatils_Obj.project_details);
								project_details.click();								
								gm.logInfo(logger, "We have clicked on project_POC_type sub menu", driver);
								
								
					}
	
	public void mandatory_check(WebDriver driver, ExtentTest logger) throws Exception
	{
		//click on add button
		gm.waitForObject(driver, Project_Deatils_Obj.add_btn);
		
		WebElement add_btn = driver.findElement(Project_Deatils_Obj.add_btn);
		add_btn.click();
		
		WebElement save_btn = driver.findElement(Project_Deatils_Obj.save_btn);
		save_btn.click();
		Thread.sleep(2000);
		
		
		
		
	}

	public void add_project(WebDriver driver, String Project_name, String Client,String Industry, String Project_hrs, String Start_date,String End_date,String Project_group,String Project_Type,ExtentTest logger) throws Exception
	{
		//add btn
		gm.waitForObject(driver, Project_Deatils_Obj.add_btn);
		WebElement add_btn = driver.findElement(Project_Deatils_Obj.add_btn);
		add_btn.click();
		gm.logInfo(logger, "We have clicked on Add button", driver);
		
		//Enter project name
		gm.enterText(driver, Project_Deatils_Obj.project_name, Project_name, "Project_name", logger);
		
		//select client
		gm.selectValueFromListByText(driver, Project_Deatils_Obj.client_drpdown, Client, "Client", logger);
		
		//select industry
		WebElement industry_search_icon = driver.findElement(Project_Deatils_Obj.industry_icon);
		industry_search_icon.click();
		
		//enter indystry
		gm.enterText(driver, Project_Deatils_Obj.industry_search, Industry, "Industry", logger);
		
		//clickon search
		WebElement industry_search = driver.findElement(Project_Deatils_Obj.search_btn);
		industry_search.click();
		
		//click on search result
		WebElement industry_search_result = driver.findElement(By.xpath(".//*[@id='industrytreeview']/ul/li[text()='"+Industry+"']"));
		gm.logInfo(logger, "we have selected the desired industry " +Industry, driver);
		industry_search_result.click();
		gm.waitForObject(driver, Project_Deatils_Obj.project_name);
		
		//enter project work hrs
		gm.enterText(driver, Project_Deatils_Obj.project_work_hrs, Project_hrs, "Project_hrs", logger);
		
		//select start date
		WebElement start_date= driver.findElement(Project_Deatils_Obj.start_date);
		start_date.click();
		cm.TimeCardDatePicker1(Start_date);
		
		//select end date
		WebElement end_date= driver.findElement(Project_Deatils_Obj.end_date);
		end_date.click();
		cm.TimeCardDatePicker1(End_date);
		
		//select project group
		WebElement project_group_icon = driver.findElement(Project_Deatils_Obj.project_group);
		project_group_icon.click();
		
		//enter project group
		gm.enterText(driver, Project_Deatils_Obj.project_group_search_box, Project_group, "Project_group", logger);
		
		//click on search
		WebElement project_group_search = driver.findElement(Project_Deatils_Obj.project_grp_search);
		project_group_search.click();
		
		//click on the search result
		WebElement project_grp_search_result = driver.findElement(By.xpath(".//*[@id='projectgrptreeview']/ul/li[text()='"+Project_group+"']"));
		gm.logInfo(logger, "we have selected the desired Project grp " +Project_group, driver);
		project_grp_search_result.click();
		
		gm.waitForObject(driver, Project_Deatils_Obj.project_name);
		
		//select project type
		gm.selectValueFromListByText(driver, Project_Deatils_Obj.project_type, Project_Type, "Project_Type", logger);
		
		//click on save
		WebElement save_btn = driver.findElement(Project_Deatils_Obj.save_btn);
		save_btn.click();
		Thread.sleep(1000);
		
		//cpature success msg
		String success_msg = driver.findElement(Project_Deatils_Obj.success_msg).getText();
		
		if(success_msg.contains("Success"))
			{
				gm.logPass(logger, "Project was created successfully", driver);
			}
		
		else
			{
				gm.logFail(logger, "Error occured", driver);
			}
		
		
	
	//-----------------------------------delivery location
	//click on delivery location
	WebElement delivery_loc = driver.findElement(Project_Deatils_Obj.deliver_location);
	delivery_loc.click();
	gm.logInfo(logger, "We have clicked on Delivery location", driver);
	
	
}
}
