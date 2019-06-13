package com.RM.Scripts;

import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.awt.Robot;
import com.RM.Generic.GenericMethods2;
import com.RM.Generic.common_methods;
import com.RM.POM.XnarfMainPage_Obj;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


public class XnarfMainPage_Test {
	
	static WebDriver driver ;
	static GenericMethods2 gm = new GenericMethods2();
	common_methods cm = new common_methods();
	static ExtentReports reports ;
	static ExtentTest logger;
	
	//Go To Xnarf tak
	public static void go_to_MainPage(WebDriver driver, ExtentTest logger) throws Exception 
	{
		try
		{	
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			//hover on Xnarf logo
			WebElement ResourcePlanner= driver.findElement(XnarfMainPage_Obj.xnarf_logo);
			Actions action = new Actions(driver);
			action.moveToElement(ResourcePlanner).build().perform();
			gm.logInfo(logger, "We have hovered over Xnarf Menu");

			// Click on Xnarf task
			WebElement Xnarf_task=driver.findElement(XnarfMainPage_Obj.xnarf_task);
			Xnarf_task.click();
			gm.logInfo(logger, "We have clicked on Xnarf Task tab");
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			gm.logFail(logger, "Exception occured:"+e.getMessage(),driver);
		}
	}
	
		public void Split_Request(WebDriver driver, String Request_id, ExtentTest logger) throws Exception 
		{
			try
			{		
		// For Pending request count	
			WebElement Pending_Request = driver.findElement(XnarfMainPage_Obj.pending_req);
			String Pending_Request_Count = Pending_Request.getText();
			System.out.println(Pending_Request_Count);
			String Total_num=Pending_Request_Count.replaceAll("[^0-9]", "");
			int Current_Pending_Request_Count = Integer.parseInt(Total_num);
			System.out.println(Current_Pending_Request_Count);
			
		// for pending task	
			WebElement Pending_tasks = driver.findElement(XnarfMainPage_Obj.pending_tasks);
			String Pending_task_Count = Pending_tasks.getText();
			System.out.println(Pending_task_Count);
			String Total_num1=Pending_task_Count.replaceAll("[^0-9]", "");
			int Current_Pending_task_Count = Integer.parseInt(Total_num1);
			System.out.println(Current_Pending_task_Count);
			
		//for completed tasks
			WebElement completed_tasks = driver.findElement(XnarfMainPage_Obj.completed_tasks);
			String completed_tasks_Count = completed_tasks.getText();
			System.out.println(completed_tasks_Count);
			String Total_num2=completed_tasks_Count.replaceAll("[^0-9]", "");
			int Current_completed_tasks_Count = Integer.parseInt(Total_num2);
			System.out.println(Current_completed_tasks_Count);
			
		// for completed requests
			WebElement completed_request = driver.findElement(XnarfMainPage_Obj.completed_req);
			String completed_request_Count = completed_request.getText();
			System.out.println(completed_request_Count);
			String Total_num3=completed_request_Count.replaceAll("[^0-9]", "");
			int Current_completed_request_Count = Integer.parseInt(Total_num3);
			System.out.println(Current_completed_request_Count);
			Thread.sleep(3000);
			
			// search for a request id
			gm.logInfo(logger, "We are searching for the required Request_id ", driver);
			gm.enterText(driver, XnarfMainPage_Obj.request_id, Request_id, "Request_id", logger);
			Robot key = new Robot();
			key.keyPress(KeyEvent.VK_ENTER);
			driver.findElement(By.id("0")).sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			//click on the 1st option that appears matching to our search option
			gm.logInfo(logger, "We have clicked on the request id ");

			WebElement First_option = driver.findElement(XnarfMainPage_Obj.option1);
			First_option.click();
			Thread.sleep(2000);
			//click on radio button
			gm.logInfo(logger, "We are selecting the record which needs to be splitted ");
			WebElement Radio_button = driver.findElement(XnarfMainPage_Obj.radio_btn);
			Radio_button.click();
			gm.logInfo(logger, "", driver);
			
			//Click on split button
			WebElement Split_button = driver.findElement(XnarfMainPage_Obj.split_btn);
			gm.logInfo(logger, "", driver);
			Split_button.click();
			gm.logInfo(logger, "We have clicked on the split button ");

			//click on confirm button
			WebElement Confirm_button = driver.findElement(XnarfMainPage_Obj.cnf_btn);
			gm.logInfo(logger, "", driver);
			Confirm_button.click();
			gm.logInfo(logger, "We have clicked on the confirm button ");
			Thread.sleep(2000);
			
			//Click on back button
			WebElement back_button= driver.findElement(XnarfMainPage_Obj.back_btn);
			back_button.click();
			Thread.sleep(8000);
			gm.logInfo(logger, "", driver);
			
			gm.logInfo(logger, "Recording info to compare", driver);
			//For Pending request count	
			WebElement Pending_Request1 = driver.findElement(XnarfMainPage_Obj.pending_req);
			String Pending_Request_Count1 = Pending_Request1.getText();
			System.out.println(Pending_Request_Count1);
			String Actual_num=Pending_Request_Count1.replaceAll("[^0-9]", "");
			int Actual_Pending_Request_Count = Integer.parseInt(Actual_num);
			System.out.println(Actual_Pending_Request_Count);
			
		// for pending task	
			WebElement Pending_tasks1 = driver.findElement(XnarfMainPage_Obj.pending_tasks);
			String Pending_task_Count1 = Pending_tasks1.getText();
			System.out.println(Pending_task_Count1);
			String Actual_num1=Pending_task_Count1.replaceAll("[^0-9]", "");
			int Actual_Pending_task_Count = Integer.parseInt(Actual_num1);
			System.out.println(Actual_Pending_task_Count);
			
		//for completed tasks
			WebElement completed_tasks1 = driver.findElement(XnarfMainPage_Obj.completed_tasks);
			String completed_tasks_Count1 = completed_tasks1.getText();
			System.out.println(completed_tasks_Count1);
			String Actual_num2=completed_tasks_Count1.replaceAll("[^0-9]", "");
			int Actual_completed_tasks_Count = Integer.parseInt(Actual_num2);
			System.out.println(Actual_completed_tasks_Count);
			
		// for completed requests
			WebElement completed_request1 = driver.findElement(XnarfMainPage_Obj.completed_req);
			String completed_request_Count1 = completed_request1.getText();
			System.out.println(completed_request_Count1);
			String Actual_num3=completed_request_Count1.replaceAll("[^0-9]", "");
			int Actual_completed_request_Count = Integer.parseInt(Actual_num3);
			System.out.println(Actual_completed_request_Count);
		

		if((Current_Pending_Request_Count+1)== Actual_Pending_Request_Count && (Current_Pending_task_Count+1)==Actual_Pending_task_Count)
		{
			gm.logPass(logger, "The workflow has been splitted successfully", driver);
		}
		else
		{
			gm.logFail(logger, "The workflow falied", driver);
		}
	}
		catch(Exception e)
		{
			gm.logFail(logger, "Exception occured:"+e.getMessage(),driver);
		}
	}
		
	public void Delete_Request(WebDriver driver, String Request_id,ExtentTest logger)throws Exception
	{
		try
		{
			 //For Pending request count	
				WebElement Pending_Request = driver.findElement(XnarfMainPage_Obj.pending_req);
				String Pending_Request_Count = Pending_Request.getText();
				System.out.println(Pending_Request_Count);
				String Total_num=Pending_Request_Count.replaceAll("[^0-9]", "");
				int Current_Pending_Request_Count = Integer.parseInt(Total_num);
				System.out.println(Current_Pending_Request_Count);
				
			// for pending task	
				WebElement Pending_tasks = driver.findElement(XnarfMainPage_Obj.pending_tasks);
				String Pending_task_Count = Pending_tasks.getText();
				System.out.println(Pending_task_Count);
				String Total_num1=Pending_task_Count.replaceAll("[^0-9]", "");
				int Current_Pending_task_Count = Integer.parseInt(Total_num1);
				System.out.println(Current_Pending_task_Count);
				
			//for completed tasks
				WebElement completed_tasks = driver.findElement(XnarfMainPage_Obj.completed_tasks);
				String completed_tasks_Count = completed_tasks.getText();
				System.out.println(completed_tasks_Count);
				String Total_num2=completed_tasks_Count.replaceAll("[^0-9]", "");
				int Current_completed_tasks_Count = Integer.parseInt(Total_num2);
				System.out.println(Current_completed_tasks_Count);
				
			// for completed requests
				WebElement completed_request = driver.findElement(XnarfMainPage_Obj.completed_req);
				String completed_request_Count = completed_request.getText();
				System.out.println(completed_request_Count);
				String Total_num3=completed_request_Count.replaceAll("[^0-9]", "");
				int Current_completed_request_Count = Integer.parseInt(Total_num3);
				System.out.println(Current_completed_request_Count);
				Thread.sleep(3000);
				
				// search for a request id
				gm.logInfo(logger, "We are searching for the required Request_id ");
				gm.enterText(driver, XnarfMainPage_Obj.request_id, Request_id, "Request_id", logger);
				Robot key = new Robot();
				key.keyPress(KeyEvent.VK_ENTER);
				driver.findElement(By.id("0")).sendKeys(Keys.ENTER);
				//click on the 1st option that appears matching to our search option
				gm.logInfo(logger, "We have clicked on the request id ", driver);
				Thread.sleep(3000);

				//CLick on the 1st option
				WebElement First_option = driver.findElement(XnarfMainPage_Obj.option1);
				First_option.click();
				Thread.sleep(2000);
				//click on radio button
				gm.logInfo(logger, "We are selecting the record which needs to be deleted ");
				WebElement Radio_button = driver.findElement(XnarfMainPage_Obj.radio_btn);
				Radio_button.click();
				gm.logInfo(logger, "", driver);
				
				//Click on delete button
				WebElement Delete_button = driver.findElement(XnarfMainPage_Obj.delete_btn);
				gm.logInfo(logger, "", driver);
				Delete_button.click();
				gm.logInfo(logger, "We have clicked on the delete button ");

				//click on confirm button
				WebElement Confirm_button = driver.findElement(XnarfMainPage_Obj.cnf_btn);
				gm.logInfo(logger, "", driver);
				Confirm_button.click();
				gm.logInfo(logger, "We have clicked on the confirm button ");
				Thread.sleep(2000);
				
				if(driver.findElements(XnarfMainPage_Obj.ok_btn).isEmpty())
				{
					//Click on back button
					WebElement back_button= driver.findElement(XnarfMainPage_Obj.back_btn);
					back_button.click();
					Thread.sleep(8000);
				}
				
				else
				{
				//click on ok button
					WebElement Ok_button = driver.findElement(XnarfMainPage_Obj.ok_btn);
					Ok_button.click();
					Thread.sleep(2000);
				}
				//hover on Xnarf logo
				WebElement ResourcePlanner= driver.findElement(XnarfMainPage_Obj.xnarf_logo);
				Actions action = new Actions(driver);
				action.moveToElement(ResourcePlanner).build().perform();
				gm.logInfo(logger, "We have hovered over Xnarf Menu");

				// Click on Xnarf task
				WebElement Xnarf_task=driver.findElement(XnarfMainPage_Obj.xnarf_task);
				Xnarf_task.click();
				gm.logInfo(logger, "We have clicked on Xnarf Task tab");
				Thread.sleep(5000);
				
				
				gm.logInfo(logger, "Recording info to compare", driver);
				//For Pending request count	
				WebElement Pending_Request1 = driver.findElement(XnarfMainPage_Obj.pending_req);
				String Pending_Request_Count1 = Pending_Request1.getText();
				System.out.println(Pending_Request_Count1);
				String Actual_num=Pending_Request_Count1.replaceAll("[^0-9]", "");
				int Actual_Pending_Request_Count = Integer.parseInt(Actual_num);
				System.out.println(Actual_Pending_Request_Count);
				
			// for pending task	
				WebElement Pending_tasks1 = driver.findElement(XnarfMainPage_Obj.pending_tasks);
				String Pending_task_Count1 = Pending_tasks1.getText();
				System.out.println(Pending_task_Count1);
				String Actual_num1=Pending_task_Count1.replaceAll("[^0-9]", "");
				int Actual_Pending_task_Count = Integer.parseInt(Actual_num1);
				System.out.println(Actual_Pending_task_Count);
				
			//for completed tasks
				WebElement completed_tasks1 = driver.findElement(XnarfMainPage_Obj.completed_tasks);
				String completed_tasks_Count1 = completed_tasks1.getText();
				System.out.println(completed_tasks_Count1);
				String Actual_num2=completed_tasks_Count1.replaceAll("[^0-9]", "");
				int Actual_completed_tasks_Count = Integer.parseInt(Actual_num2);
				System.out.println(Actual_completed_tasks_Count);
				
			// for completed requests
				WebElement completed_request1 = driver.findElement(XnarfMainPage_Obj.completed_req);
				String completed_request_Count1 = completed_request1.getText();
				System.out.println(completed_request_Count1);
				String Actual_num3=completed_request_Count1.replaceAll("[^0-9]", "");
				int Actual_completed_request_Count = Integer.parseInt(Actual_num3);
				System.out.println(Actual_completed_request_Count);
			

			if((Current_Pending_Request_Count-1)== Actual_Pending_Request_Count && (Current_Pending_task_Count-1)==Actual_Pending_task_Count)
			{
				gm.logPass(logger, "The workflow has been Deleted successfully", driver);
			}
			else
			{
				gm.logFail(logger, "The workflow falied", driver);
			}
			}
			
			catch(Exception e)
			{
				gm.logFail(logger, "Exception occured:"+e.getMessage(),driver);
			}
		}

		
	}
	
	












