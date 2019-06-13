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
import com.RM.POM.XnarfMainPage_Obj;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class OB_NewHire_Test {
	
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
	
	public void OB_Single(WebDriver driver, String Request_id,String First,String Employee_id,String Search_seat,String comments, String Job_need_comment,String Tree_search,String Ob_wbs,String Delegate,String Delegate1,ExtentTest logger) throws Exception 
	{
		try
		{
			
			if(First.equalsIgnoreCase("Null"))
			{
				gm.logInfo(logger, "We have a single entry");
			}
			else
			{
						
			//click on pending task tab
			WebElement Pending_task = driver.findElement(OB_NewHire_Obj.pending_tasks);
			Pending_task.click();
			gm.logPass(logger, "We have clicked on Pending Task tab.",driver);
			Thread.sleep(3000);
			
			//click on OB radio button
			WebElement Ob_button = driver.findElement(OB_NewHire_Obj.OB_btn);
			Ob_button.click();
			gm.logPass(logger, "We have clicked on OB radio butoon", driver);
			Thread.sleep(5000);
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
					gm.logfail(logger, "Some error occured..Please check");
				}
			}
			//to click on employee_id	
					
					if(Employee_id.equalsIgnoreCase("Null"))
					{
						gm.logInfo(logger, "We are executing Single case");
					}
					else
					{
						
					gm.logInfo(logger, "We are executing Multiple WPS scenario");
					//click on personnel number block
					gm.enterText(driver, OB_NewHire_Obj.employee_id, Employee_id, "Employee_id", logger);
					Robot key1 = new Robot();
					key1.keyPress(KeyEvent.VK_ENTER);
					driver.findElement(By.id("4")).sendKeys(Keys.ENTER);
					Thread.sleep(2000);
					}
			//click on the request id searched for
			driver.findElement(By.id("1")).click();
			Thread.sleep(2000);
			//XNARF On boarding New Hire Transaction Screen
			
			//to test reset button
			WebElement jsn = driver.findElement(OB_NewHire_Obj.job_need_comment);
			jsn.clear();
			Thread.sleep(2000);
			gm.enterText(driver, OB_NewHire_Obj.job_need_comment, Job_need_comment, "Job_need_comment" , logger);
			
			WebElement reset_button = driver.findElement(OB_NewHire_Obj.reset_btn);
			reset_button.click();
			Thread.sleep(2000);
			gm.logPass(logger, "Reset button was clicked..", driver);
			
			WebElement jsn1 = driver.findElement(OB_NewHire_Obj.job_need_comment);
			jsn1.clear();
			Thread.sleep(2000);
			gm.enterText(driver, OB_NewHire_Obj.job_need_comment, Job_need_comment, "Job_need_comment" , logger);
			
			//click on office location
			WebElement office_location = driver.findElement(OB_NewHire_Obj.Search_icon);
			office_location.click();
			driver.findElement(OB_NewHire_Obj.advanced_search).click();
			Thread.sleep(2000);
			gm.logInfo(logger,"We have clicked on advanced search button for office location", driver);
			
			//Enter location name
			gm.enterText(driver, OB_NewHire_Obj.tree_search, Tree_search, "Tree_search", logger);
			WebElement tree_search_icon = driver.findElement(OB_NewHire_Obj.tree_search_icon);
			tree_search_icon.click();
			gm.logInfo(logger, "We have clicked on the tree search icon ", driver);
			Thread.sleep(2000);
			//click on the searched item
			WebElement loc= driver.findElement(OB_NewHire_Obj.loc);
			loc.click();
			Thread.sleep(2000);
			
			//Validation--- click on save button
			WebElement save_button = driver.findElement(OB_NewHire_Obj.Save_btn);
			save_button.click();
			gm.logInfo(logger, "We have clicked on save button to check validations--");
			Thread.sleep(2000);
			
			WebElement Error_msg = driver.findElement(By.xpath(".//*[@id='alertsection']/div"));
			String error_msg = Error_msg.getText();
			System.out.println(error_msg);
		
				if(error_msg.contains("Error! Please select a Seat Number."))
				{
					gm.logInfo(logger, "Validation captured successfully---'for selecting a Seat Number after location change'", driver);
				}
				else
				{
					gm.logFail(logger, "Validation step failed", driver);
				}
				//Search seat
				WebElement seat_search = driver.findElement(OB_NewHire_Obj.seat_search_icon);
				seat_search.click();
				driver.findElement(OB_NewHire_Obj.seat_advanced_search).click();
				Thread.sleep(3000);
				gm.enterText(driver, OB_NewHire_Obj.search_seat, Search_seat, "Search_seat", logger);
				driver.findElement(OB_NewHire_Obj.search_btn).click();
				Thread.sleep(3000);
				
				//select training seat from the table
				driver.findElement(By.xpath(".//*[@id='seat-table-modal']/tbody/tr/td[2]")).click();
				
			
			//Enter on boarding wbs 
			gm.enterText(driver, OB_NewHire_Obj.OB_Wbs, Ob_wbs, "Ob_wbs", logger);
			Thread.sleep(2000);
			
			//Select drop down for phone request
			
			WebElement phone_req = driver.findElement(OB_NewHire_Obj.Phone_request_dropdown);
			phone_req.click();
			gm.logInfo(logger, "We have clicked on phone request dropdown", driver);
			Thread.sleep(2000);
			driver.findElement(OB_NewHire_Obj.optn_select_all).click();
			gm.logInfo(logger, "We have selected 'Select all' option from this dropdown", driver);
			phone_req.click();
			Thread.sleep(2000);
			
			//select drop down for requests
			WebElement requests = driver.findElement(OB_NewHire_Obj.request_dropdwon);
			requests.click();
			gm.logInfo(logger, "We have clicked on Requests dropdown");
			driver.findElement(OB_NewHire_Obj.Req_select_all).click();
			gm.logInfo(logger, "We have clicked on 'Select all' option for this dropdpown", driver);
			Thread.sleep(2000);
			
			//enter comments
			gm.enterText(driver, OB_NewHire_Obj.comments, comments, "comments", logger);
			Thread.sleep(2000);
			//click on save button
			WebElement save_button1 = driver.findElement(OB_NewHire_Obj.Save_btn);
			save_button1.click();
			Thread.sleep(3000);
			
			//Click on Ok button
			WebElement ok_btn = driver.findElement(OB_NewHire_Obj.Ok_btn);
			ok_btn.click();
			gm.logInfo(logger, "We have clicked on OK button", driver);
			Thread.sleep(2000);
			
			// select record to be delegated
			WebElement select = driver.findElement(OB_NewHire_Obj.select_all_check_box);
			select.click();
						
			//select a value from the delegate drop down			
			gm.selectValueFromListByText(driver, OB_NewHire_Obj.delegate_dropdown, Delegate, "Delegate", logger);
			gm.logInfo(logger, "Delegate Selected: "+ Delegate);
			Thread.sleep(3000);		
			
			//Click on delegate button
			WebElement delegate_btn = driver.findElement(OB_NewHire_Obj.delegate_btn);
			delegate_btn.click();
			gm.logInfo(logger, "We have click on delegate button", driver);
			Thread.sleep(2000);
			
			//click on ok button
			WebElement ok_btn1 = driver.findElement(OB_NewHire_Obj.Ok_btn);
			ok_btn1.click();
			gm.logInfo(logger, "We have clicked on OK button", driver);
			Thread.sleep(2000);
			
			//capture the delegated name
			WebElement delegate = driver.findElement(By.xpath(".//*[@id='fixTable']/tbody/tr[1]/td[22]"));
			String delegate_name = delegate.getText();
			System.out.println(delegate_name);
			
			//Verify if the delegated name is on screen
				if(delegate_name.contains(Delegate1))
				{
					gm.logPass(logger, "The Onboarding task has been delegated to" +Delegate , driver);
				}
				else
				{
					gm.logFail(logger, "The delegation task Failed", driver);
				}
				
				
				cm.Complete_count();
			
			//-------------to check if the request id worked on is completed
			//click on completed tab
			WebElement completed_task = driver.findElement(XnarfMainPage_Obj.completed_tasks);
			completed_task.click();
			gm.logInfo(logger, "We have clicked on completed tasks tab", driver);
			Thread.sleep(5000);
			
			//click on Ob button
			//click on OB radio button
			WebElement Ob_button = driver.findElement(OB_NewHire_Obj.OB_btn);
			Ob_button.click();
			gm.logPass(logger, "We have clicked on OB radio button", driver);
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
	
	public void RM_Multiple(WebDriver driver, String Request_id,String First,String Employee_id,String Search_seat,String comments, String Job_need_comment,String Tree_search,String Ob_wbs,String Delegate,String Delegate1,ExtentTest logger) throws Exception
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
		
					
				// Click on OB button
					WebElement OB_button = driver.findElement(OB_NewHire_Obj.OB_btn);
					OB_button.click();
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
				//to click on employee_id	
						
						if(Employee_id.equalsIgnoreCase("Null"))
						{
							gm.logInfo(logger, "We are executing Single case");
						}
						else
						{
							
						gm.logInfo(logger, "We are executing Multiple WPS scenario");
						//click on personnel number block
						gm.enterText(driver, OB_NewHire_Obj.employee_id, Employee_id, "Employee_id", logger);
						Robot key1 = new Robot();
						key1.keyPress(KeyEvent.VK_ENTER);
						driver.findElement(By.id("4")).sendKeys(Keys.ENTER);
						Thread.sleep(2000);
						}
						
					//click on the request id searched for
					driver.findElement(By.id("1")).click();
					Thread.sleep(2000);
					
					//to test reset button
					WebElement jsn = driver.findElement(OB_NewHire_Obj.job_need_comment);
					jsn.clear();
					Thread.sleep(2000);
					gm.enterText(driver, OB_NewHire_Obj.job_need_comment, Job_need_comment, "Job_need_comment" , logger);
					
					WebElement reset_button = driver.findElement(OB_NewHire_Obj.reset_btn);
					reset_button.click();
					Thread.sleep(2000);
					gm.logPass(logger, "Reset button was clicked..", driver);
					
					WebElement jsn1 = driver.findElement(OB_NewHire_Obj.job_need_comment);
					jsn1.clear();
					Thread.sleep(2000);
					gm.enterText(driver, OB_NewHire_Obj.job_need_comment, Job_need_comment, "Job_need_comment" , logger);
					
					//click on office location
					WebElement office_location = driver.findElement(OB_NewHire_Obj.Search_icon);
					office_location.click();
					driver.findElement(OB_NewHire_Obj.advanced_search).click();
					Thread.sleep(2000);
					gm.logInfo(logger,"We have clicked on advanced search button for office location", driver);
					
					//Enter location name
					gm.enterText(driver, OB_NewHire_Obj.tree_search, Tree_search, "Tree_search", logger);
					WebElement tree_search_icon = driver.findElement(OB_NewHire_Obj.tree_search_icon);
					tree_search_icon.click();
					gm.logInfo(logger, "We have clicked on the tree search icon ", driver);
					Thread.sleep(2000);
					//click on the searched item
					WebElement loc= driver.findElement(OB_NewHire_Obj.loc);
					loc.click();
					Thread.sleep(2000);
					
					//Validation--- click on save button
					WebElement save_button = driver.findElement(OB_NewHire_Obj.Save_btn);
					save_button.click();
					gm.logInfo(logger, "We have clicked on save button to check validations--");
					Thread.sleep(2000);
					
					WebElement Error_msg = driver.findElement(By.xpath(".//*[@id='alertsection']/div"));
					String error_msg = Error_msg.getText();
					System.out.println(error_msg);
				
						if(error_msg.contains("Error! Please select a Seat Number."))
						{
							gm.logInfo(logger, "Validation captured successfully---'for selecting a Seat Number after location change'", driver);
						}
						else
						{
							gm.logFail(logger, "Validation step failed", driver);
						}
						//Search seat
						WebElement seat_search = driver.findElement(OB_NewHire_Obj.seat_search_icon);
						seat_search.click();
						driver.findElement(OB_NewHire_Obj.seat_advanced_search).click();
						Thread.sleep(3000);
						gm.enterText(driver, OB_NewHire_Obj.search_seat, Search_seat, "Search_seat", logger);
						driver.findElement(OB_NewHire_Obj.search_btn).click();
						Thread.sleep(3000);
						
						//select training seat from the table
						driver.findElement(By.xpath(".//*[@id='seat-table-modal']/tbody/tr/td[2]")).click();
						
					
					//Enter on boarding wbs 
					gm.enterText(driver, OB_NewHire_Obj.OB_Wbs, Ob_wbs, "Ob_wbs", logger);
					Thread.sleep(2000);
					
					//Select drop down for phone request
					
					WebElement phone_req = driver.findElement(OB_NewHire_Obj.Phone_request_dropdown);
					phone_req.click();
					gm.logInfo(logger, "We have clicked on phone request dropdown", driver);
					Thread.sleep(2000);
					driver.findElement(OB_NewHire_Obj.optn_select_all).click();
					gm.logInfo(logger, "We have selected 'Select all' option from this dropdown", driver);
					phone_req.click();
					Thread.sleep(2000);
					
					//select dropdown for requests
					WebElement requests = driver.findElement(OB_NewHire_Obj.request_dropdwon);
					requests.click();
					gm.logInfo(logger, "We have clicked on Requests dropdown");
					Thread.sleep(2000);
					driver.findElement(OB_NewHire_Obj.Req_select_all).click();
					gm.logInfo(logger, "We have clicked on 'Select all' option for this dropdpown", driver);
					Thread.sleep(2000);
					
					//enter comments
					gm.enterText(driver, OB_NewHire_Obj.comments, comments, "comments", logger);
					Thread.sleep(2000);
					//click on save button
					WebElement save_button1 = driver.findElement(OB_NewHire_Obj.Save_btn);
					save_button1.click();
					Thread.sleep(3000);
					
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
					public void MultipleComplete(WebDriver driver, String Request_id,String First,String Employee_id,String Search_seat,String comments, String Job_need_comment,String Tree_search,String Ob_wbs,String Delegate,String Delegate1,ExtentTest logger
							) throws Exception
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
					
					
					//click on OB radio button
					WebElement Ob_button = driver.findElement(OB_NewHire_Obj.completed_OB);
					Ob_button.click();
					gm.logPass(logger, "We have clicked on OB radio button", driver);
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
	
	
	
	


