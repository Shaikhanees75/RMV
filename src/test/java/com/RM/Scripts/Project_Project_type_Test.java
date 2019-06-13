package com.RM.Scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.RM.Generic.GenericMethods2;
import com.RM.Generic.common_methods;
import com.RM.POM.Project_Project_type_Obj;
import com.RM.POM.Skill_WTCG_Obj;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Project_Project_type_Test {
	
	static WebDriver driver;
	static GenericMethods2 gm = new GenericMethods2();
	common_methods cm = new common_methods();
	static ExtentTest logger;
	static ExtentReports reports;
	
	public void navigate_to_Project_Type(WebDriver driver, ExtentTest logger)
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
								
								
								//hover on industry
								WebElement project_type = driver.findElement(Project_Project_type_Obj.project_type);
								project_type.click();								
								gm.logInfo(logger, "We have clicked on project_type sub menu", driver);
								
								
					}
	
	public void Add(WebDriver driver, String Search, String Project_Type,String Status, ExtentTest logger) throws Exception
	{
		
		//click on Add btn
		WebElement add_btn = driver.findElement(Project_Project_type_Obj.add_btn);
		gm.waitForObject(driver, Project_Project_type_Obj.add_btn);
		add_btn.click();
		
		//Enter Project type
		gm.enterText(driver, Project_Project_type_Obj.project_type_name, Project_Type, "Project_Type", logger);
		
		Thread.sleep(2000);
		//click on cancel
		WebElement cancel_btn = driver.findElement(Project_Project_type_Obj.cancel_btn);
		cancel_btn.click();
		
		//click on Add btn
				WebElement add_btn1 = driver.findElement(Project_Project_type_Obj.add_btn);
				gm.waitForObject(driver, Project_Project_type_Obj.add_btn);
				add_btn1.click();
				
				//Enter Project type
				gm.enterText(driver, Project_Project_type_Obj.project_type_name, Project_Type, "Project_Type", logger);
		
		//Select Active status
		gm.selectValueFromListByText(driver, Project_Project_type_Obj.status_drpdown, Status, "Status", logger);
		
		//click on save btn
		WebElement save_btn = driver.findElement(Project_Project_type_Obj.save_btn);
		save_btn.click();
		gm.logInfo(logger, "Click on save button", driver);
		
		String success_msg = driver.findElement(Project_Project_type_Obj.success_msg).getText();
		
		if(success_msg.contains("Success"))
		{
			gm.logPass(logger, "Project Type was created successfully", driver);
		}
		else
		{
			gm.logFail(logger, "Error occured, please review:", driver);
		}
		
		//validation on save
		
		gm.waitForObject(driver, Project_Project_type_Obj.project_type_search_box);
		
		WebElement search_text = driver.findElement(Project_Project_type_Obj.project_type_search_box);
				
		gm.enterText(driver, Project_Project_type_Obj.project_type_search_box, Search, "Search", logger);
		search_text.sendKeys(Keys.ENTER);
		
		gm.waitForObject(driver, Project_Project_type_Obj.project_type_search_result);
		Thread.sleep(3000);
		
		String verify = driver.findElement(Project_Project_type_Obj.project_type_search_result).getText();
		
		if(verify.equals(Search))
		{
			gm.logPass(logger, "Validation successful", driver);
			System.out.println("Test cases for Project type creation -- Passed");
		}
		else
		{
			gm.logFail(logger, "Test case failed, check for error", driver);
			System.out.println("Test case Failed");
		}
	}
	
	
	public void Edit(WebDriver driver, String Search, String Project_Type,String Status, ExtentTest logger) throws Exception
	{	
		//Clear search for Project type
		WebElement search_text = driver.findElement(Project_Project_type_Obj.project_type_search_box);
		search_text.clear();
		
		gm.enterText(driver, Project_Project_type_Obj.project_type_search_box, Search, "Search", logger);
		search_text.sendKeys(Keys.ENTER);
		
		//click on Edit
		WebElement edit = driver.findElement(By.xpath(".//*[@id='fixTable']/tbody/tr/td[2][text()='"+Search+"']//..//td[1]//a[@id='Edit0']"));
		edit.click();
		Thread.sleep(2000);
		
		//edit project type Active status-- No
		gm.selectValueFromListByText(driver, Project_Project_type_Obj.status_drpdown, Status, "Status", logger);
		
		//click on save btn
				WebElement update_btn = driver.findElement(Project_Project_type_Obj.update_btn);
				update_btn.click();
				gm.logInfo(logger, "Click on Update button", driver);
				
				String success_msg = driver.findElement(Project_Project_type_Obj.success_msg).getText();
				
				if(success_msg.contains("Success"))
				{
					gm.logPass(logger, "Project Type was Update successfully", driver);
					System.out.println("Scenario for Edit completed");
				}
				else
				{
					gm.logFail(logger, "Error occured, please review:", driver);
				}
	
	
	}


}

	
	


