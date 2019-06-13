package com.RM.Scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.RM.Generic.GenericMethods2;
import com.RM.Generic.common_methods;
import com.RM.POM.Skill_Change_Request_Obj;
import com.RM.POM.Skill_Workflow_Obj;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Skill_Workflow_Test {
	
	 static WebDriver driver;
		static GenericMethods2 gm = new GenericMethods2();
		common_methods cm = new common_methods();
		static ExtentReports reports ;
		static ExtentTest logger;

	public  void go_to_Skill_Approval(WebDriver driver,ExtentTest logger)throws Exception
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
					action2.moveToElement(Skill).build().perform();
					gm.logInfo(logger, "We have hovered on Skill Menu", driver);
					
					//hover on Skill change request
					WebElement skill_change = driver.findElement(Skill_Change_Request_Obj.skill_change);
					Actions action3 = new Actions(driver);
					action3.moveToElement(Skill).build().perform();
					gm.logPass(logger, "We have clicked on Skill change request sub menu", driver);
		
					//click on skill approval
					WebElement skill_appproval = driver.findElement(Skill_Workflow_Obj.skill_workflow);
					skill_appproval.click();
					gm.logInfo(logger, "We have clicked on Skill Approval", driver);
					Thread.sleep(3000);
	
	}


public  void Skill_Approve(WebDriver driver, String Search, ExtentTest logger) throws Exception
{
	try
	{
		
		//click on competency search
		WebElement competency_search = driver.findElement(Skill_Workflow_Obj.competency_search);
		gm.waitForObject(driver, Skill_Workflow_Obj.competency_search);
		gm.enterText(driver, Skill_Workflow_Obj.competency_search, Search, "Search", logger);
			
		//click on the check box
		WebDriverWait wait = new WebDriverWait(driver,20);
		WebElement checkbox = driver.findElement(By.xpath(".//*[@id='fixTable']/tbody/tr/td[5][text()='"+Search+"']//..//td[1]//input[@id='ddl0']"));
		wait.until(ExpectedConditions.elementToBeClickable(checkbox));
		checkbox.click();
		Thread.sleep(2000);
		
		//click on Approve button
		WebElement approve = driver.findElement(Skill_Workflow_Obj.approve_btn);
		approve.click();
		Thread.sleep(1000);
		
		//Validation on approve
		Select skill_status = new Select (driver.findElement(Skill_Workflow_Obj.skill_status));
		skill_status.selectByValue("3993");
		
		
		//search for competency
		gm.enterText(driver, Skill_Workflow_Obj.competency_search, Search, "Search", logger);
		
		//status
		String status = driver.findElement(By.xpath(".//*[@id='fixTable']/tbody/tr[1]/td[9]")).getText();
		
		if(status.contains("Approved"))
		{
			gm.logPass(logger, "The Skill was succesfully approved", driver);
		}
		else
		{
			gm.logFail(logger, "Error occured", driver);
		}
	}
		catch(Exception e)
		{
			gm.logfail(logger, "Exception occured:"+e.getMessage());
		}
	}


public  void Skill_Reject(WebDriver driver, String Search, ExtentTest logger) throws Exception
{
	try
	{
		
		//click on competency search
		WebElement competency_search = driver.findElement(Skill_Workflow_Obj.competency_search);
		gm.waitForObject(driver, Skill_Workflow_Obj.competency_search);
		gm.enterText(driver, Skill_Workflow_Obj.competency_search, Search, "Search", logger);
			
		//click on the check box
		WebDriverWait wait = new WebDriverWait(driver,20);
		WebElement checkbox = driver.findElement(By.xpath(".//*[@id='fixTable']/tbody/tr/td[5][text()='"+Search+"']//..//td[1]//input[@id='ddl0']"));
		wait.until(ExpectedConditions.elementToBeClickable(checkbox));
		checkbox.click();
		Thread.sleep(2000);
		
		//click on Reject button
		WebElement reject = driver.findElement(Skill_Workflow_Obj.reject_btn);
		reject.click();
		Thread.sleep(1000);
		
		
	}
		catch(Exception e)
		{
			gm.logfail(logger, "Exception occured:"+e.getMessage());
		}
	}
}
