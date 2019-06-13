package com.RM.Scripts;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.RM.Generic.GenericMethods2;
import com.RM.Generic.common_methods;
import com.RM.POM.Leave_Approval_Obj;
import com.RM.POM.Leave_Request_Obj;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


public class Leave_Approval_Test {

	static WebDriver driver ;
	static GenericMethods2 gm = new GenericMethods2();
	common_methods cm = new common_methods();
	static ExtentReports reports ;
	static ExtentTest logger;

	//Go To Leave Approval
	public static void go_to_leave_approval(WebDriver driver, ExtentTest logger) throws Exception 
	{
		try
		{	
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			//open menu
			WebElement menu_scrl=driver.findElement(Leave_Approval_Obj.menu_scrl);
			menu_scrl.click();
			gm.logInfo(logger, "We have clicked on Menu scroll");
			Thread.sleep(5000);

			WebElement element =
					driver.findElement(By.xpath(".//*[@id='mainmenu']/li[7]/a/span"));
			((JavascriptExecutor)
					driver).executeScript("arguments[0].scrollIntoView();", element); 


			//hover on Resource Planner
			WebElement ResourcePlanner= driver.findElement(Leave_Approval_Obj.resource_planner);
			Actions action = new Actions(driver);
			action.moveToElement(ResourcePlanner).build().perform();
			gm.logInfo(logger, "We have hovered over Resource Planner Menu");
			Thread.sleep(3000);	

			// Click on Leave Approval
			WebElement leave_approval=driver.findElement(Leave_Approval_Obj.leave_approval);
			leave_approval.click();
			gm.logInfo(logger, "We have clicked on Leave Approval tab");
			Thread.sleep(5000);	

		}

		catch(Exception e)
		{
			gm.logFail(logger, "Exception occured:"+e.getMessage(),driver);
		}
	}

	//------------------------Approve Leave or Deny Leave------------------------------------------//

	public void Approve_New_Leave(WebDriver driver,String Approval,String EmployeeID,String LeaveDate,String EmployeeName,String FromDate,String comments,ExtentTest logger) throws Exception 
	{
		try
		{
			//Click on employee Search pop up
			WebElement employee_search_btn=driver.findElement(Leave_Approval_Obj.employee_search_btn);
			employee_search_btn.click();
			gm.logInfo(logger, "We have clicked on Employee search pop up");

			//Enter required employee ID
			gm.enterText(driver,Leave_Approval_Obj.employee_id , EmployeeID, "EmployeeID", logger);
			gm.logInfo(logger, "Employee Id of the required user is entered: "+ EmployeeID);

			//Click on Search button
			WebElement employee_search=driver.findElement(Leave_Approval_Obj.employee_search);
			employee_search.click();
			gm.logInfo(logger, "We have clicked on Employee search");

			//Select the first employee
			WebElement employee_select=driver.findElement(Leave_Approval_Obj.employee_select);
			employee_select.click();
			gm.logInfo(logger, "We have selected the required employee");

			//Navigate to the required month
			//Split Date
			String splitter[] = LeaveDate.split("-");

			String leaveDate=splitter[0];
			String leaveMonth=splitter[1];
			String leaveYear=splitter[2];

			System.out.println(leaveDate);
			System.out.println(leaveMonth);
			System.out.println(leaveYear);

			for(int i=0; i<12;i++)
			{
				WebElement CurrentMonth = driver.findElement(Leave_Approval_Obj.current_month);
				String CurrentMonth1=CurrentMonth.getText();


				if(CurrentMonth1.equalsIgnoreCase(leaveMonth))
				{
					gm.logInfo(logger, "We are in the required month: "+leaveMonth);
					break;
				}
				else
				{
					gm.logInfo(logger, "Calendar is being displayed for the month: "+CurrentMonth1);
					//Click on Next month
					WebElement nxt_month=driver.findElement(Leave_Approval_Obj.nxt_month);
					nxt_month.click();
					gm.logInfo(logger, "We are navigating to the required month: "+leaveMonth);
				}
			}
			//Save data for the year being displayed in the calendar
			WebElement current_year= driver.findElement(Leave_Approval_Obj.current_year);
			String current_year1=current_year.getText();
			System.out.println(current_year1);

			//get the year difference between current year and year to set in calendar
			int yearDiff = Integer.parseInt(leaveYear)- Integer.parseInt(current_year1);
			if(yearDiff!=0){

				//if you have to move next year
				if(yearDiff>0){

					for(int i=0;i< yearDiff;i++){

						System.out.println("Year Diff->"+i);

						WebElement nxt_cld_yr = driver.findElement(Leave_Approval_Obj.nxt_cld_yr);
						nxt_cld_yr.click();


					}

				}

				//if you have to move previous year

				else if(yearDiff<0){

					for(int i=0;i< (yearDiff*(-1));i++){

						System.out.println("Year Diff->"+i);

						WebElement prev_cld_yr = driver.findElement(Leave_Approval_Obj.prev_cld_yr);
						prev_cld_yr.click();
					}

				}

			}

			Thread.sleep(1000);

			//Take Screenshot
			gm.logPass(logger, "Calendar before approving the leave",driver);


			//Click on Leave Workflow
			WebElement leave_workflow=driver.findElement(Leave_Approval_Obj.leave_workflow);
			leave_workflow.click();
			gm.logInfo(logger, "We have clicked on Leave Workflow tab");


			Thread.sleep(5000);
			//Click on Leave Approval pop up
			/*for(int j=2;j<10;j++)		
			{
				//----------------Normal method------------------------------//
					WebElement workflow_ppup=driver.findElement(By.xpath(".//*[@id='leaveWFTable']/tbody/tr/td[7][text()='"+FromDate+"']/../td[3][text()='"+EmployeeName+"']/../td/button"));	

				Thread.sleep(2000);
				workflow_ppup.click();
				Thread.sleep(1000);
				gm.logPass(logger, "Leave request was found. Clicked on leave pop up",driver);


				//----------------Enhancements to be done(logic not working currently)------------------------------//
				//----------------Enhancements done(working currently)(12/29/2017 Varun D C)------------------------------//

				if(driver.findElements(By.xpath(".//*[@id='leaveWFTable']/tbody/tr/td[7][text()='"+FromDate+"']/../td[3][text()='"+EmployeeName+"']")).size() != 0)
				{
					WebElement workflow_ppup=driver.findElement(By.xpath(".//*[@id='leaveWFTable']/tbody/tr/td[7][text()='"+FromDate+"']/../td[3][text()='"+EmployeeName+"']/../td/button"));
					workflow_ppup.click();
					Thread.sleep(1000);
					gm.logPass(logger, "Leave request was found. Clicked on leave pop up",driver);
					break;
				}
				else if(driver.findElements(By.xpath(".//*[@id='schedulePager']/li[2]/a[text()='"+j+"']")).size() != 0)
				{
					WebElement page_count =driver.findElement(By.xpath(".//*[@id='schedulePager']/li[2]/a[text()='"+j+"']"));
					page_count.click();
					Thread.sleep(1000);	
					gm.logInfo(logger, "Clicked on next page to search the request");
					break;
				}
				else
				{
					gm.logInfo(logger, "Leave request not found for the searched user");

				}
			}
			 */

			WebElement total_record=driver.findElement(Leave_Request_Obj.Leave_count);
			String Total= total_record.getText();
			String Total_num=Total.replace("Pending Approval","");
			System.out.println(Total_num); 
			Thread.sleep(1000);

			String removeBracketqueue1Count;
			removeBracketqueue1Count=Total_num.replaceAll("[\\(\\)\\[\\]\\{\\}]","");
			//removeBracket=removeBracket.replaceAll(")", "");
			System.out.println(removeBracketqueue1Count);
			String s=removeBracketqueue1Count.trim();
			int removeBracketqueue1Count1=Integer.parseInt(s);

			int jmax;
			Thread.sleep(1000);

			if(removeBracketqueue1Count1!=0) {

				double Leave_Count= (removeBracketqueue1Count1/10);

				jmax=(int)Math.ceil(Leave_Count);
				System.out.println(jmax);


				for(int j=2;j<(jmax+1);j++)		
				{
					if(driver.findElements(By.xpath(".//*[@id='leaveWFTable']/tbody/tr/td[7][text()='"+FromDate+"']/../td[3][text()='"+EmployeeName+"']")).size() != 0)
					{

						WebElement workflow_ppup=driver.findElement(By.xpath(".//*[@id='leaveWFTable']/tbody/tr/td[7][text()='"+FromDate+"']/../td[3][text()='"+EmployeeName+"']/../td/button"));
						workflow_ppup.click();
						Thread.sleep(1000);
						gm.logPass(logger, "Leave request was found. Clicked on leave pop up",driver);


						//Enter comments in the approval pop up
						gm.enterText(driver,Leave_Approval_Obj.commetns_field , comments, "comments", logger);
						gm.logInfo(logger, "Comment for the action is: "+ comments);
						Thread.sleep(1000);

						//Click on Approve leave	
						if(Approval.equalsIgnoreCase("T"))
						{
							WebElement approve_leave=driver.findElement(Leave_Approval_Obj.approve_leave);
							approve_leave.click();
							gm.logInfo(logger, "We have clicked on Approve Leave button");

						}
						else if(Approval.equalsIgnoreCase("F"))
						{
							WebElement deny_leave=driver.findElement(Leave_Approval_Obj.deny_leave);
							deny_leave.click();
							gm.logInfo(logger, "We have clicked on Deny Leave button");			
						}

						else {
							WebElement close_btn=driver.findElement(Leave_Approval_Obj.close_btn);
							close_btn.click();
							gm.logInfo(logger, "We have clicked on Close button as there was no action specified");			
						}

						Thread.sleep(2000);
						// Check all the validations
						WebElement Successmsg= driver.findElement(Leave_Approval_Obj.alert_msg);
						String SuccessLblMsg=Successmsg.getText();
						System.out.println(SuccessLblMsg);


						if(Approval.equalsIgnoreCase("T") && SuccessLblMsg.contains("Leave Approved Successfully."))
						{
							gm.logPass(logger, "Leave was Apprvoed for the Employee " +EmployeeName+" with leave from date: "+FromDate, driver);

						}

						else if(Approval.equalsIgnoreCase("F") && SuccessLblMsg.contains("Leave Denied Successfully."))
						{
							gm.logPass(logger, "Leave was denied for the Employee" +EmployeeName+" with leave from date: "+FromDate, driver);
						}
						else
						{
							gm.logFail(logger, "Record cannot be saved.The error while saving the record is:::"+SuccessLblMsg, driver);
						}

						Thread.sleep(5000);

						if(Approval.equalsIgnoreCase("F")||Approval.equalsIgnoreCase("T")) {
							//Click on close button
							WebElement close_btn=driver.findElement(Leave_Approval_Obj.close_btn);
							close_btn.click();
							gm.logInfo(logger, "We have clicked on Close button.");	
							Thread.sleep(3000);	


							//Click on User Metrics tab
							WebElement user_metrics=driver.findElement(Leave_Approval_Obj.user_metrics);
							user_metrics.click();
							Thread.sleep(8000);
							gm.logInfo(logger, "We have opened the user metrics tab to record the current leave data.", driver);	


							//Click on Roster Calendar tab
							WebElement roster_calendar=driver.findElement(Leave_Approval_Obj.roster_calendar);
							roster_calendar.click();
							Thread.sleep(8000);	
							gm.logInfo(logger, "We have opened the Roster calednar for the period to verify approval staus.", driver);	

							//Click on calendar tab
							WebElement leave_calendar=driver.findElement(Leave_Approval_Obj.leave_calendar);
							leave_calendar.click();
							Thread.sleep(8000);
							gm.logInfo(logger, "We have opened the leave calednar for the period to verify approval staus.", driver);	


						}

						break;
					}

					else if(driver.findElements(By.xpath(".//*[@id='schedulePager']/li[2]/a[text()='"+j+"']")).size() != 0)
					{
						WebElement page_count =driver.findElement(By.xpath(".//*[@id='schedulePager']/li[2]/a[text()='"+j+"']"));
						page_count.click();
						Thread.sleep(1000);	
						gm.logInfo(logger, "Clicked on next page to search the request");

						if(driver.findElements(By.xpath(".//*[@id='leaveWFTable']/tbody/tr/td[7][text()='"+FromDate+"']/../td[3][text()='"+EmployeeName+"']")).size() != 0)
						{

							WebElement workflow_ppup=driver.findElement(By.xpath(".//*[@id='leaveWFTable']/tbody/tr/td[7][text()='"+FromDate+"']/../td[3][text()='"+EmployeeName+"']/../td/button"));
							workflow_ppup.click();
							Thread.sleep(1000);
							gm.logPass(logger, "Leave request was found. Clicked on leave pop up",driver);



							//Enter comments in the approval pop up
							gm.enterText(driver,Leave_Approval_Obj.commetns_field , comments, "comments", logger);
							gm.logInfo(logger, "Comment for the action is: "+ comments);

							//Click on Approve leave	
							if(Approval.equalsIgnoreCase("T"))
							{
								WebElement approve_leave=driver.findElement(Leave_Approval_Obj.approve_leave);
								approve_leave.click();
								gm.logInfo(logger, "We have clicked on Approve Leave button");

							}
							else if(Approval.equalsIgnoreCase("F"))
							{
								WebElement deny_leave=driver.findElement(Leave_Approval_Obj.deny_leave);
								deny_leave.click();
								gm.logInfo(logger, "We have clicked on Deny Leave button");			
							}

							else {
								WebElement close_btn=driver.findElement(Leave_Approval_Obj.close_btn);
								close_btn.click();
								gm.logInfo(logger, "We have clicked on Close button as there was no action specified");			
							}

							Thread.sleep(2000);
							// Check all the validations
							WebElement Successmsg= driver.findElement(Leave_Approval_Obj.alert_msg);
							String SuccessLblMsg=Successmsg.getText();
							System.out.println(SuccessLblMsg);


							if(Approval.equalsIgnoreCase("T") && SuccessLblMsg.contains("Leave Approved Successfully."))
							{
								gm.logPass(logger, "Leave was Apprvoed for the Employee " +EmployeeName+" with leave from date: "+FromDate, driver);

							}

							else if(Approval.equalsIgnoreCase("F") && SuccessLblMsg.contains("Leave Denied Successfully."))
							{
								gm.logPass(logger, "Leave was denied for the Employee" +EmployeeName+" with leave from date: "+FromDate, driver);
							}
							else
							{
								gm.logFail(logger, "Record cannot be saved.The error while saving the record is:::"+SuccessLblMsg, driver);
							}

							Thread.sleep(5000);
							if(Approval.equalsIgnoreCase("T") || Approval.equalsIgnoreCase("F"))
							{
								//Click on close button
								WebElement close_btn=driver.findElement(Leave_Approval_Obj.close_btn);
								close_btn.click();
								gm.logInfo(logger, "We have clicked on Close button.");	
								Thread.sleep(3000);	

								//Click on User Metrics tab
								WebElement user_metrics=driver.findElement(Leave_Approval_Obj.user_metrics);
								user_metrics.click();
								Thread.sleep(5000);
								gm.logInfo(logger, "We have opened the user metrics tab to record the current leave data.", driver);	


								//Click on Roster Calendar tab
								WebElement roster_calendar=driver.findElement(Leave_Approval_Obj.roster_calendar);
								roster_calendar.click();
								Thread.sleep(5000);	
								gm.logInfo(logger, "We have opened the Roster calednar for the period to verify approval staus.", driver);	

								//Click on calendar tab
								WebElement leave_calendar=driver.findElement(Leave_Approval_Obj.leave_calendar);
								leave_calendar.click();
								Thread.sleep(5000);
								gm.logInfo(logger, "We have opened the leave calednar for the period to verify approval staus.", driver);	


							}
						}
						break;
					}

					else
					{
						gm.logFail(logger, "Leave Request Not Found",driver);
						//Click on calendar tab
						WebElement leave_calendar=driver.findElement(Leave_Approval_Obj.leave_calendar);
						leave_calendar.click();
						Thread.sleep(5000);

					}

				}

			}
			else
			{

				gm.logFail(logger, "No Leave Request found",driver);
				//Click on calendar tab
				WebElement leave_calendar=driver.findElement(Leave_Approval_Obj.leave_calendar);
				leave_calendar.click();
				Thread.sleep(5000);

			}


		}

		catch(Exception e)
		{
			gm.logFail(logger, "Exception occured:"+e.getMessage(),driver);
		}

	}
}




