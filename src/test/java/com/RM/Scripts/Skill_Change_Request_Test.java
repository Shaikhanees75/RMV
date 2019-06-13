package com.RM.Scripts;

import java.util.concurrent.TimeUnit;

import org.apache.commons.exec.ExecuteException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.RM.Generic.GenericMethods2;
import com.RM.Generic.common_methods;
import com.RM.POM.Instance_setup_Menus_obj;
import com.RM.POM.Skill_Change_Request_Obj;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
//import com.sun.net.httpserver.Authenticator.Success;

public class Skill_Change_Request_Test {

	
    static WebDriver driver;
	static GenericMethods2 gm = new GenericMethods2();
	common_methods cm = new common_methods();
	static ExtentReports reports ;
	static ExtentTest logger;
	
	
	//go to Skill change sub menu
	
	public  void go_to_Skill_Change_request(WebDriver driver,ExtentTest logger)throws Exception
		{
			/*try{
				*/
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			// hover on Instance set up
			WebElement resource_planner = driver.findElement(Skill_Change_Request_Obj.resource_planner);
			Actions action = new Actions(driver);
			action.moveToElement(resource_planner).build().perform();
			gm.logInfo(logger, "We have hovered on Resource_planner Menu", driver);
			
			
			
			// hover on Instance set up
						WebElement demand = driver.findElement(Skill_Change_Request_Obj.demand);
						Actions action1 = new Actions(driver);
						action1.moveToElement(demand).build().perform();
						gm.logInfo(logger, "We have hovered on demand Menu", driver);
						
			
						// hover on Instance set up
						WebElement Skill = driver.findElement(Skill_Change_Request_Obj.skill);
						Actions action2 = new Actions(driver);
						action1.moveToElement(Skill).build().perform();
						gm.logInfo(logger, "We have hovered on Skill Menu", driver);
						
						//Click on Skill change request
						WebElement skill_change = driver.findElement(Skill_Change_Request_Obj.skill_change);
						skill_change.click();
						gm.logFail(logger, "We have clicked on Skill change request sub menu", driver);
			

		
		}

	
	public  void Add_Skill(WebDriver driver, String Skill_type, String Skill,String Proficeincy, String Valid_from, String Valid_to,ExtentTest logger) throws Exception
	{
		try
		{
		//Click on Add button
		WebElement add_btn = driver.findElement(Skill_Change_Request_Obj.Add_btn);
		add_btn.click();
		Thread.sleep(2000);
		
		//enter skill type
		gm.selectValueFromListByText(driver, Skill_Change_Request_Obj.skill_type, Skill_type, "Skill type", logger);
		
		//select skill
		gm.selectValueFromListByText(driver, Skill_Change_Request_Obj.skill_drp_dwn, Skill, "Skill", logger);
		
		//select proficiency
		gm.selectValueFromListByText(driver, Skill_Change_Request_Obj.prof, Proficeincy, "Proficeincy", logger);
		
		//enter valid from date- auto populate
		
		//enter valid to date- auto populate
		
		//select record for approval
		WebElement record = driver.findElement(Skill_Change_Request_Obj.select);
		record.click();
		Thread.sleep(2000);
		//click on send for approval
		WebElement send_approval = driver.findElement(Skill_Change_Request_Obj.send_aapproval);
		send_approval.click();
		Thread.sleep(2000);
		
		String success_msg = driver.findElement(Skill_Change_Request_Obj.success_msg).getText();
		if(success_msg.contains("Success"))
		{
			gm.logPass(logger, "Skill Change Request was sent successfully", driver);
			
		}
		else
		{
			gm.logFail(logger, "Skill Change Request Failed", driver);
		}
		
	}
		catch(Exception e)
		{
			gm.logFail(logger, "Exception occured"+e,common_methods.driver);
		}
		
		
	}
	
	public void Edit_Skill(WebDriver driver, String Skill_type, String Skill,String Proficeincy, String Valid_from, String Valid_to,ExtentTest logger)
	{
		try
		{
				
			//enter skill type
			gm.selectValueFromListByText(driver, Skill_Change_Request_Obj.skill_type, Skill_type, "Skill type", logger);
			
			//select skill
			gm.selectValueFromListByText(driver, Skill_Change_Request_Obj.skill_drp_dwn, Skill, "Skill", logger);
			
			//select proficiency
			gm.selectValueFromListByText(driver, Skill_Change_Request_Obj.prof, Proficeincy, "Proficeincy", logger);
			
			//enter valid from date- auto populate
			WebElement valid_frm= driver.findElement(Skill_Change_Request_Obj.valid_frm);
			valid_frm.click();
			cm.TimeCardDatePicker(Valid_from);
			
			//enter valid to date- auto populate
			WebElement valid_to = driver.findElement(Skill_Change_Request_Obj.valid_to);
			valid_to.click();
			cm.TimeCardDatePicker(Valid_to);
			
			//select record for approval
			WebElement record = driver.findElement(Skill_Change_Request_Obj.select);
			record.click();
			Thread.sleep(2000);
			//click on send for approval
			WebElement send_approval = driver.findElement(Skill_Change_Request_Obj.send_aapproval);
			send_approval.click();
			Thread.sleep(2000);
			
			String success_msg = driver.findElement(Skill_Change_Request_Obj.success_msg).getText();
			if(success_msg.contains("Success"))
			{
				gm.logPass(logger, "Skill Change Request was sent successfully", driver);
				
			}
			else
			{
				gm.logFail(logger, "Skill Change Request Failed", driver);
			}
		}
		catch(Exception e)
		{
			gm.logFail(logger, "Exception occured"+e,common_methods.driver);
		}
	}
	
	public void Delete_Skill(WebDriver driver, ExtentTest logger)
	{
		try
		{
			//select the record
			WebElement select_record = driver.findElement(Skill_Change_Request_Obj.select);
			select_record.click();
			
			//click on delete icon
			WebElement delete_btn = driver.findElement(Skill_Change_Request_Obj.delete_btn);
			delete_btn.click();
			gm.logInfo(logger, "Clicked on Delete button", driver);
			
			//click on send for approval button
			WebElement send_approval = driver.findElement(Skill_Change_Request_Obj.send_aapproval);
			send_approval.click();
			Thread.sleep(2000);
			
			String success_msg = driver.findElement(Skill_Change_Request_Obj.success_msg).getText();
			if(success_msg.contains("Success"))
			{
				gm.logPass(logger, "Skill  was Deleted successfully", driver);
				
			}
			else
			{
				gm.logFail(logger, "Skill delete Request Failed", driver);
			}
			
		}
			catch(Exception e)
			{
				gm.logFail(logger, "Exception occured"+e,common_methods.driver);
			}
			
			
		}
	
}
