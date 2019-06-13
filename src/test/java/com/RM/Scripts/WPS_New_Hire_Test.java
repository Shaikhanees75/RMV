package com.RM.Scripts;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.RM.Generic.GenericMethods2;
import com.RM.Generic.common_methods;
import com.RM.POM.OB_NewHire_Obj;
import com.RM.POM.WPS_New_Hire_Obj;
import com.RM.POM.WP_New_Hire_Obj;
import com.RM.POM.XnarfMainPage_Obj;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class WPS_New_Hire_Test {
	static WebDriver driver;
	static GenericMethods2 gm = new GenericMethods2();
	 common_methods cm = new common_methods();
	static ExtentTest logger;
	static ExtentReports reports;
	
	public void go_to_Main_Page(WebDriver driver, ExtentTest logger)throws Exception
	{
		try
		{
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			//hover on Xnarf logo
			WebElement ResourcePlanner= driver.findElement(OB_NewHire_Obj.xnarf_logo);
			Actions action = new Actions(driver);
			action.moveToElement(ResourcePlanner).build().perform();
			gm.logInfo(logger, "We have hovered over Xnarf Menu");

			// Click on Xnarf task
			WebElement Xnarf_task=driver.findElement(OB_NewHire_Obj.xnarf_task);
			Xnarf_task.click();
			gm.logInfo(logger, "We have clicked on Xnarf Task tab");
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			gm.logFail(logger, "Exception occured:"+e.getMessage(),driver);
		}
	
			
	}
	
	public void WPS_Single(WebDriver driver, String Request_id,String Personnel_Number,String comments,ExtentTest logger) throws Exception
	{
		try
		{
		
				//click on pending task tab
		WebElement Pending_task = driver.findElement(OB_NewHire_Obj.pending_tasks);
		Pending_task.click();
		gm.logPass(logger, "We have clicked on Pending Task tab.",driver);
		Thread.sleep(3000);
		
					
				// Click on WPS button
					WebElement WP_button = driver.findElement(OB_NewHire_Obj.WPS_btn);
					WP_button.click();
					Thread.sleep(3000);
					//Click on request id and search for the id from the excel sheet
					gm.logInfo(logger, "We are searching for the required Request_id ", driver);
					gm.enterText(driver, OB_NewHire_Obj.request_id, Request_id, "Request_id", logger);
					Robot key = new Robot();
					key.keyPress(KeyEvent.VK_ENTER);
					driver.findElement(By.id("0")).sendKeys(Keys.ENTER);
					//click on the 1st option that appears matching to our search option
					gm.logInfo(logger, "We have clicked on the request id ");
					Thread.sleep(5000);
					
					//click on first option
					WebElement First_option = driver.findElement(OB_NewHire_Obj.option1);
					First_option.click();
					Thread.sleep(3000);
					
					//click on complete button and capture the mandatory fields
					WebElement complete_button = driver.findElement(OB_NewHire_Obj.complete_btn);
					complete_button.click();
					gm.logInfo(logger, "We Have clicked on Complete button to capture the mandatory field check", driver);
					Thread.sleep(5000);
					
					//capture pop up msg
					WebElement popup_msg= driver.findElement(By.xpath("html/body/div[3]/div/div/div[1]/div/p"));
					String pop_up_msg = popup_msg.getText();
					System.out.println(pop_up_msg);
						if(pop_up_msg.contains("Please Select at least one Employee!."))
						{
							//click on ok button
							driver.findElement(By.xpath("html/body/div[3]/div/div/div[2]/button")).click();
							gm.logInfo(logger, "We have clicked on OK button");
						}
						else
						{
							gm.logFail(logger, "Some error occured..Please check",driver);
						}
					
						if(Personnel_Number.equalsIgnoreCase("Null"))
						{
							gm.logInfo(logger, "We are executing Single case");
						}
						else
						{
							
						gm.logInfo(logger, "We are executing Multiple WPS scenario");
						//click on personnel number block
						gm.enterText(driver, WPS_New_Hire_Obj.personnel_number, Personnel_Number, "Personnel_Number", logger);
						Robot key1 = new Robot();
						key1.keyPress(KeyEvent.VK_ENTER);
						driver.findElement(By.id("0")).sendKeys(Keys.ENTER);
						}
						
					//click on the request id searched for
					driver.findElement(By.id("1")).click();
					Thread.sleep(2000);
					
					//enter comments
					gm.enterText(driver, WPS_New_Hire_Obj.comments, comments, "comments", logger);
					gm.logInfo(logger, "We have entered the comments", driver);
					
					//check if //order has been placed check box is selected or not
					if(driver.findElement(WPS_New_Hire_Obj.order_placed_checkbox).isSelected())
					{
						gm.logPass(logger, "Order has been placed check box is selected, We are good to complete WPS task.", driver);
					}
					else
					{
						gm.logFail(logger, "order has been placed check box is not selected", driver);
					}
					
					//click on save button
					WebElement save_btn = driver.findElement(WP_New_Hire_Obj.save_btn);
					save_btn.click();
					Thread.sleep(2000);
					
					//Click on Ok button
					WebElement ok_btn = driver.findElement(OB_NewHire_Obj.Ok_btn);
					ok_btn.click();
					gm.logInfo(logger, "We have clicked on OK button", driver);
					Thread.sleep(2000);
				

					cm.Complete_count();
					
					//-------------to check if the request id worked on is completed
					//click on completed tab
					WebElement completed_task = driver.findElement(XnarfMainPage_Obj.completed_tasks);
					completed_task.click();
					gm.logInfo(logger, "We have clicked on completed tasks tab", driver);
					Thread.sleep(5000);
					
					//click on Ob button
					//click on OB radio button
					WebElement Ob_button = driver.findElement(OB_NewHire_Obj.WPS_btn);
					Ob_button.click();
					gm.logPass(logger, "We have clicked on OB radio button", driver);
					Thread.sleep(3000);
					
					//Click on request id and search for the id from the excel sheet
					gm.logInfo(logger, "We are searching for the required Request_id ", driver);
					gm.enterText(driver, OB_NewHire_Obj.request_id, Request_id, "Request_id", logger);
					Robot key1 = new Robot();
					key1.keyPress(KeyEvent.VK_ENTER);
					driver.findElement(By.id("0")).sendKeys(Keys.ENTER);
					Thread.sleep(8000);
					
					
					//to verify if the status is completed
					
					String Status = driver.findElement(OB_NewHire_Obj.status).getText();
					
					if(Status.equals("COMPLETED"))
					{
						gm.logPass(logger, "The request id" + Request_id + "for OB is completed", driver);
					}
					else
					{
						gm.logfail(logger, "The request failed");
					}
					
		}
		catch(Exception e)
		{
			gm.logFail(logger, "Exception occured:"+e.getMessage(),driver);
		}
	
			
	}	
	
	
	public void WPS_Multiple(WebDriver driver, String Request_id,String First,String Personnel_Number,String comments,ExtentTest logger) throws Exception
	{
		try
		{
			if(First.equalsIgnoreCase("Null"))
			{
				gm.logInfo(logger, "We have a single entry");
			}
			else
			{
		//to capture the current count of the requests and tasks
		
		//click on pending task tab
		WebElement Pending_task = driver.findElement(OB_NewHire_Obj.pending_tasks);
		Pending_task.click();
		gm.logPass(logger, "We have clicked on Pending Task tab.",driver);
		Thread.sleep(3000);
		
					//Click on request id and search for the id from the excel sheet
					gm.logInfo(logger, "We are searching for the required Request_id ", driver);
					gm.enterText(driver, OB_NewHire_Obj.request_id, Request_id, "Request_id", logger);
					Robot key = new Robot();
					key.keyPress(KeyEvent.VK_ENTER);
					driver.findElement(By.id("0")).sendKeys(Keys.ENTER);
					//click on the 1st option that appears matching to our search option
					gm.logInfo(logger, "We have clicked on the request id ");
					Thread.sleep(5000);
					
					//click on first option
					WebElement First_option = driver.findElement(OB_NewHire_Obj.option1);
					First_option.click();
					Thread.sleep(3000);
					
					//click on complete button and capture the mandatory fields
					WebElement complete_button = driver.findElement(OB_NewHire_Obj.complete_btn);
					complete_button.click();
					gm.logInfo(logger, "We Have clicked on Complete button to capture the mandatory field check", driver);
					
					//capture pop up msg
					WebElement popup_msg= driver.findElement(By.xpath("html/body/div[3]/div/div/div[1]/div/p"));
					String pop_up_msg = popup_msg.getText();
					System.out.println(pop_up_msg);
						if(pop_up_msg.contains("Please Select at least one Employee!."))
						{
							//click on ok button
							driver.findElement(By.xpath("html/body/div[3]/div/div/div[2]/button")).click();
							gm.logInfo(logger, "We have clicked on OK button");
						}
						else
						{
							gm.logFail(logger, "Some error occured..Please check",driver);
						}
			}
				//to click on personnel number	
						
						if(Personnel_Number.equalsIgnoreCase("Null"))
						{
							gm.logInfo(logger, "We are executing Single case");
						}
						else
						{
							
						gm.logInfo(logger, "We are executing Multiple WPS scenario");
						//click on personnel number block
						gm.enterText(driver, WPS_New_Hire_Obj.personnel_number, Personnel_Number, "Personnel_Number", logger);
						Robot key1 = new Robot();
						key1.keyPress(KeyEvent.VK_ENTER);
						driver.findElement(By.id("4")).sendKeys(Keys.ENTER);
						Thread.sleep(2000);
						}
						
					//click on the request id searched for
					driver.findElement(By.id("1")).click();
					Thread.sleep(2000);
					
					//enter comments
					gm.enterText(driver, WPS_New_Hire_Obj.comments, comments, "comments", logger);
					gm.logInfo(logger, "We have entered the comments", driver);
					
					//check if //order has been placed check box is selected or not
					if(driver.findElement(WPS_New_Hire_Obj.order_placed_checkbox).isSelected())
					{
						gm.logPass(logger, "Order has been placed check box is selected, We are good to complete WPS task.", driver);
					}
					else
					{
						gm.logFail(logger, "order has been placed check box is not selected", driver);
					}
					
					//click on save button
					WebElement save_btn = driver.findElement(WP_New_Hire_Obj.save_btn);
					save_btn.click();
					Thread.sleep(2000);
					
					//Click on Ok button
					WebElement ok_btn = driver.findElement(OB_NewHire_Obj.Ok_btn);
					ok_btn.click();
					gm.logInfo(logger, "We have clicked on OK button", driver);
					Thread.sleep(2000);
		}
		catch(Exception e)
		{
			gm.logFail(logger, "Exception occured:"+e.getMessage(),driver);

		}
	}
					
				//------------------------------------------------------------------------
					public void MultipleComplete(WebDriver driver, String Request_id,String First,String Personnel_Number,String comments,ExtentTest logger) throws Exception
	{
		try
		{
			cm.Complete_count();
					
					//-------------to check if the request id worked on is completed
					//click on completed tab
					WebElement completed_task = driver.findElement(XnarfMainPage_Obj.completed_tasks);
					completed_task.click();
					gm.logInfo(logger, "We have clicked on completed tasks tab", driver);
					Thread.sleep(5000);
					
					
					//click on WPS radio button
					WebElement WPS_button = driver.findElement(WPS_New_Hire_Obj.completed_WPS);
					WPS_button.click();
					gm.logPass(logger, "We have clicked on WPS radio button", driver);
					Thread.sleep(3000);
					
					//Click on request id and search for the id from the excel sheet
					gm.logInfo(logger, "We are searching for the required Request_id ", driver);
					gm.enterText(driver, OB_NewHire_Obj.request_id, Request_id, "Request_id", logger);
					Robot key = new Robot();
					key.keyPress(KeyEvent.VK_ENTER);
					driver.findElement(By.id("0")).sendKeys(Keys.ENTER);
					Thread.sleep(8000);
					
					//to verify if the status is completed
					
					String Status = driver.findElement(OB_NewHire_Obj.status).getText();
					
					if(Status.equals("COMPLETED"))
					{
						gm.logPass(logger, "The request id" + Request_id + "for OB is completed", driver);
					}
					else
					{
						gm.logfail(logger, "The request failed");
					}
		}
		catch(Exception e)
		{
			gm.logFail(logger, "Exception occured:"+e.getMessage(),driver);

		}
		}
	
				
	
	}
	

	
	
	


