package com.RM.Scripts;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.RM.Generic.GenericMethods2;
import com.RM.Generic.common_methods;
import com.RM.POM.Leave_Request_Obj;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Leave_Request_Test {

	static WebDriver driver ;
	static GenericMethods2 gm = new GenericMethods2();
	common_methods cm = new common_methods();
	static ExtentReports reports ;
	static ExtentTest logger;

	//Go To Leave Request
	public static void go_to_leave_request(WebDriver driver, ExtentTest logger) throws Exception 
	{
		try
		{	
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			//hover on Resource Planner
			WebElement ResourcePlanner= driver.findElement(Leave_Request_Obj.resource_planner);
			Actions action = new Actions(driver);
			action.moveToElement(ResourcePlanner).build().perform();
			gm.logInfo(logger, "We have hovered on Resource Planner Menu");

			// Click on Leave Request
			WebElement leave_request=driver.findElement(Leave_Request_Obj.leave_request);
			leave_request.click();
			gm.logInfo(logger, "We have clicked on Leave Request tab");
			Thread.sleep(5000);	

		}

		catch(Exception e)
		{
			gm.logFail(logger, "Exception occured:"+e.getMessage(),driver);
		}
	}


	//--------------------------------------Apply Leave----------------------------------------//
	public void Apply_New_Leave(WebDriver driver,String fromDate,String toDate,String leaveType,String startTime,String duration,ExtentTest logger) throws Exception 
	{
		try
		{

			//Click on apply leave
			WebElement ApplyLeave=driver.findElement(Leave_Request_Obj.apply_leave);
			ApplyLeave.click();
			gm.logInfo(logger, "We have clicked Apply leave to open pop up");
					
			//Click on From date calendar
			WebElement selectDate = driver.findElement(Leave_Request_Obj.from_date);
			selectDate.click();
			gm.logInfo(logger, "We have clicked on from date cleandar");
		
			//Select from date
			cm.testDAtePicker(fromDate);
			gm.logInfo(logger, "We have selected the required From date: "+fromDate); 

			//Click on to date calendar
			WebElement todate = driver.findElement(Leave_Request_Obj.to_date);
			todate.click();
			gm.logInfo(logger, "We have clicked on to date cleandar.");

			//Select to date
			cm.testDAtePicker(toDate);
			gm.logInfo(logger, "We have selected the required From date: "+todate);

			//Select Leave type from dropdown
			gm.selectValueFromListByText(driver, Leave_Request_Obj.leave_type, leaveType, "leaveType", logger);
			gm.logInfo(logger, "Leave Type Selected: "+leaveType);

			//Clear existing time
			WebElement start_time= driver.findElement(Leave_Request_Obj.start_time);
			start_time.clear();

			//Enter required start time
			gm.enterText(driver,Leave_Request_Obj.start_time , startTime, "startTime", logger);
			gm.logInfo(logger, "Leave start time is: "+ startTime);

			//Clear Existing duration
			WebElement leave_duration= driver.findElement(Leave_Request_Obj.leave_duration);
			leave_duration.clear();

			//Enter required Leave Duration
			gm.enterText(driver,Leave_Request_Obj.leave_duration , duration, "duration", logger);
			gm.logInfo(logger, "Leave duration per day is: "+ duration);
			
			//Check Box check
			WebElement i_certify=driver.findElement(Leave_Request_Obj.i_certify);
			i_certify.click();
			gm.logInfo(logger, "We have checked i certify checkbox");

			//Click on Submit
			WebElement submit_btn=driver.findElement(Leave_Request_Obj.submit_btn);
			submit_btn.click();
			gm.logInfo(logger, "We have clicked on submit button");

			// Check all the validations
			WebElement Successmsg= driver.findElement(Leave_Request_Obj.warn_msg);
			String SuccessLblMsg=Successmsg.getText();
			System.out.println(SuccessLblMsg);

			if(SuccessLblMsg.contains("Leave Request Auto Approved by System."))
			{
				gm.logPass(logger, "Leave Request was raised and auto approved for the following dates, From date:" +fromDate+" ,To Date: " +toDate+", Start Time: "+startTime+" ,Leave Duration:"+duration, driver);

			}
			else if(SuccessLblMsg.contains("Leave Request Raised and Sent for Approval."))
			{
				gm.logPass(logger, "Leave Request has been raised and sent for approval for date from " +fromDate+" to "+toDate+" Start Time: "+startTime+" Leave Duration: "+duration, driver);

			}
			else if(SuccessLblMsg.contains("Error!To date should be greater than or equal to From date!"))
			{
				gm.logPass(logger, "Enter To date greater than from date,date entered is from" +fromDate+" to "+toDate, driver);
			}
			else if(SuccessLblMsg.contains("Error!Kindly Select Leave Type!"))
			{
				gm.logPass(logger, "User is notified that atleast one Leave Type should be selected", driver);

			}
			else if(SuccessLblMsg.contains("Error!Please select I Certify Checkbox!"))
			{
				gm.logPass(logger, "User is notified that i certify checkbox isnt ticked",driver);
			}
			else if(SuccessLblMsg.contains("Error!Max duration cannot be more than 9"))
			{
				gm.logPass(logger, "User notified that the entered leave duration is more than entered. Leave duration entered: "+duration, driver);
			}

			else if(SuccessLblMsg.contains("Error!Leave requested on Day off, please review your schedule with you supervisor"))
			{
				gm.logPass(logger, "User is notified that he is trying to apply leave on day off,date entered is from "+fromDate+" to "+toDate, driver);
			}

			else if(SuccessLblMsg.contains("Error!Leave can not be applied for the range ,schedule roster not done properly"))
			{
				gm.logPass(logger, "User is notified that rostering isnt done properly for the dates entered,date entered is from "+fromDate+" to "+toDate, driver);
			}
			else if(SuccessLblMsg.contains("Error!Multiple Schedules have been detected within the time period selected, please enter one PTO request at a time when the schedules did not match for the time period"))
			{
				gm.logPass(logger, "User is notified that different types of schedule are present for the dates entered,date entered is from "+fromDate+" to "+toDate, driver);
			}
			else
			{
				gm.logFail(logger, "Record cannot be saved.The error while saving the record is:::"+SuccessLblMsg, driver);
			}		

		}

		catch(Exception e)
		{
			gm.logFail(logger, "Exception occured:"+e.getMessage(),driver);
		}
	}

	//--------------------------------Cancel Leave--------------------------------------------------//
	public  void Cancel_Leave_Calendar(WebDriver driver,String CancelLeaveDate,ExtentTest logger) throws Exception 

	{

		//Split Date
		String splitter[] = CancelLeaveDate.split("-");
		String leaveMonth=splitter[1];
		String leaveDate=splitter[0];
		String leaveYear=splitter[2];
		
		System.out.println(leaveDate);
		System.out.println(leaveMonth);
		System.out.println(leaveYear);
		
		try
		{

			for(int i=0; i<12;i++)
			{
				WebElement CurrentMonth = driver.findElement(Leave_Request_Obj.current_month);
				String CurrentMonth1=CurrentMonth.getText();


				if(CurrentMonth1.equalsIgnoreCase(leaveMonth))
				{
					gm.logInfo(logger, "We are in the required month: "+leaveMonth);
					break;
				}
				else
				{
					gm.logInfo(logger, "Calendar is being displayed for the month:"+CurrentMonth1);
					//Click on Next month
					WebElement nxt_month=driver.findElement(Leave_Request_Obj.nxt_month);
					nxt_month.click();
					gm.logInfo(logger, "We have navigated to the required month:"+leaveMonth);
				}
			}
			//Save data for the year being displayed in the calendar
			WebElement current_year= driver.findElement(Leave_Request_Obj.current_year);
			String current_year1=current_year.getText();
			System.out.println(current_year1);
			
			//get the year difference between current year and year to set in calendar
			int yearDiff = Integer.parseInt(leaveYear)- Integer.parseInt(current_year1);
			if(yearDiff!=0){

				//if you have to move next year
				if(yearDiff>0){

					for(int i=0;i< yearDiff;i++){

						System.out.println("Year Diff->"+i);

						WebElement nxt_cld_yr = driver.findElement(Leave_Request_Obj.nxt_cld_yr);
						nxt_cld_yr.click();


					}

				}

				//if you have to move previous year

				else if(yearDiff<0){

					for(int i=0;i< (yearDiff*(-1));i++){

						System.out.println("Year Diff->"+i);

						WebElement prev_cld_yr = driver.findElement(Leave_Request_Obj.prev_cld_yr);
						prev_cld_yr.click();
					}

				}

			}

			Thread.sleep(1000);

			//Click on require leave Date from calendar
			WebElement edit_popup=driver.findElement(By.xpath(".//*[@id='ExeclJquery']/tbody/tr/td/div/a[text()='"+leaveDate+"']"));
			edit_popup.click();
			Thread.sleep(1000);

			//Click on Cancel Leave
			WebElement cancelLeave=driver.findElement(Leave_Request_Obj.cancel_leave);
			cancelLeave.click();
			// Check all the validations
			WebElement Successmsg= driver.findElement(Leave_Request_Obj.warn_msg);
			String SuccessLblMsg=Successmsg.getText();
			System.out.println(SuccessLblMsg);
			if(SuccessLblMsg.contains("Leave Cancelled Successfully."))
			{
				gm.logPass(logger, "Leave was canceleld for the leave applies with date" +CancelLeaveDate, driver);

			}

			else
				gm.logFail(logger, "Leave cannot be cancelled.The error while saving the record is:::"+SuccessLblMsg, driver);

		}

		catch(Exception e)
		{
			gm.logFail(logger, "Exception occured:"+e.getMessage(),driver);
		}
	}

	//---------------------------------------Edit Leave-----------------------------------------------//
	public  void Edit_Leave_Calendar(WebDriver driver,String editdate,String newfromDate,String newtoDate,String newleaveType,String newstartTime,String newduration,ExtentTest logger) throws Exception
	{
		//Split Date
		String splitter[] = editdate.split("-");
		String leaveMonth=splitter[1];
		String leaveDate=splitter[0];
		String leaveYear=splitter[2];
		try
		{

			for(int i=0; i<12;i++)
			{
				WebElement CurrentMonth = driver.findElement(Leave_Request_Obj.current_month);
				String CurrentMonth1=CurrentMonth.getText();
                System.out.println(CurrentMonth1);

				if(CurrentMonth1.equalsIgnoreCase(leaveMonth))
				{
					gm.logInfo(logger, "We are in the required month: "+leaveMonth);
					break;
				}
				else
				{
					gm.logInfo(logger, "Calendar is being displayed for the month:"+CurrentMonth1);
					//Click on Next month
					WebElement nxt_month=driver.findElement(Leave_Request_Obj.nxt_month);
					nxt_month.click();
					gm.logInfo(logger, "We have navigated to the required month:"+leaveMonth);
				}
			}
			
			//Save data for the year being displayed in the calendar
			WebElement current_year= driver.findElement(Leave_Request_Obj.current_year);
			String current_year1=current_year.getText();
			System.out.println(current_year1);
			
			//get the year difference between current year and year to set in calendar
			int yearDiff = Integer.parseInt(leaveYear)- Integer.parseInt(current_year1);
			if(yearDiff!=0){

				//if you have to move next year
				if(yearDiff>0){

					for(int i=0;i< yearDiff;i++){

						System.out.println("Year Diff->"+i);

						WebElement nxt_cld_yr = driver.findElement(Leave_Request_Obj.nxt_cld_yr);
						nxt_cld_yr.click();


					}

				}

				//if you have to move previous year

				else if(yearDiff<0){

					for(int i=0;i< (yearDiff*(-1));i++){

						System.out.println("Year Diff->"+i);

						WebElement prev_cld_yr = driver.findElement(Leave_Request_Obj.prev_cld_yr);
						prev_cld_yr.click();
					}

				}

			}

			Thread.sleep(1000);

			//Click on require leave Date from calendar
			WebElement edit_popup=driver.findElement(By.xpath(".//*[@id='ExeclJquery']/tbody/tr/td/div/a[text()='"+leaveDate+"']"));
			edit_popup.click();

			//Click on From date calendar
			WebElement selectDate = driver.findElement(Leave_Request_Obj.from_date);
			selectDate.click();
			gm.logInfo(logger, "We have clicked on from date cleandar");


			//Select from date
			cm.testDAtePicker(newfromDate);
			Thread.sleep(5000);

			//Click on to date calendar
			WebElement todate = driver.findElement(Leave_Request_Obj.to_date);
			todate.click();
			gm.logInfo(logger, "We have clicked on to date cleandar");

			//Select to date
			cm.testDAtePicker(newtoDate);
			Thread.sleep(5000);

			//Select Leave type from dropdown
			gm.selectValueFromListByText(driver, Leave_Request_Obj.leave_type, newleaveType, "leaveType", logger);
			gm.logInfo(logger, "Leave Type Selected: "+ newleaveType);

			//Clear existing time
			WebElement start_time= driver.findElement(Leave_Request_Obj.start_time);
			start_time.clear();

			//Enter required start time
			gm.enterText(driver,Leave_Request_Obj.start_time , newstartTime, "startTime", logger);
			gm.logInfo(logger, "Leave start time is: "+ newstartTime);

			//Clear Existing duration
			WebElement leave_duration= driver.findElement(Leave_Request_Obj.leave_duration);
			leave_duration.clear();

			//Enter required Leave Duration
			gm.enterText(driver,Leave_Request_Obj.leave_duration , newduration, "duration", logger);
			gm.logInfo(logger, "Leave duration per day is: "+ newduration);
			
			//Check Box check
			WebElement i_certify=driver.findElement(Leave_Request_Obj.i_certify);
			i_certify.click();
			gm.logInfo(logger, "We have checked i certify checkbox");

			//Click on Submit
			WebElement submit_btn=driver.findElement(Leave_Request_Obj.submit_btn);
			submit_btn.click();
			gm.logInfo(logger, "We have clicked on submit button");

			// Check all the validations
			WebElement Successmsg= driver.findElement(Leave_Request_Obj.warn_msg);
			String SuccessLblMsg=Successmsg.getText();
			System.out.println(SuccessLblMsg);

			if(SuccessLblMsg.contains("Leave updated successfully."))
			{
				gm.logPass(logger, "Leave Request was updated to following date for "+editdate+" ,changed leave dates: from " +newfromDate+" to "+newtoDate+"Leave type: "+newleaveType+ "Start Time: "+newstartTime+" Leave Duration: "+newduration, driver);

			}

			else if(SuccessLblMsg.contains("Error!To date should be greater than or equal to From date!"))
			{
				gm.logPass(logger, "Enter To date greater than from date,date entered is from" +newfromDate+" to "+newtoDate, driver);
			}
			else if(SuccessLblMsg.contains("Error!Kindly Select Leave Type!"))
			{
				gm.logPass(logger, "User is notified that atleast one Leave Type should be selected", driver);

			}
			else if(SuccessLblMsg.contains("Error!Please select I Certify Checkbox!"))
			{
				gm.logPass(logger, "User is notified that i certify checkbox isnt ticked",driver);
			}
			else if(SuccessLblMsg.contains("Error!Max duration cannot be more than 9"))
			{
				gm.logPass(logger, "User notified that the entered leave duration is more than entered. Leave duration entered: "+newduration, driver);
			}

			else if(SuccessLblMsg.contains("Error!Leave requested on Day off, please review your schedule with you supervisor"))
			{
				gm.logPass(logger, "User is notified that he is trying to apply leave on day off,date entered is from "+newfromDate+" to "+newtoDate, driver);
			}

			else if(SuccessLblMsg.contains("Error!Leave can not be applied for the range ,schedule roster not done properly"))
			{
				gm.logPass(logger, "User is notified that rostering isnt done properly for the dates entered,date entered is from "+newfromDate+" to "+newtoDate, driver);
			}
			else if(SuccessLblMsg.contains("Error!Multiple Schedules have been detected within the time period selected, please enter one PTO request at a time when the schedules did not match for the time period"))
			{
				gm.logPass(logger, "User is notified that different types of schedule are present for the dates entered,date entered is from "+newfromDate+" to "+newtoDate, driver);
			}
			else if(SuccessLblMsg.contains("Error!Cannot update/modify two approved leave request simultaneously"))
			{
				gm.logPass(logger, "User is notified that cannot update two approved leave simultaneously,date entered is from "+newfromDate+" to "+newtoDate, driver);
			}
			else
			{
				gm.logFail(logger, "Record cannot be saved.The error while saving the record is:::"+SuccessLblMsg, driver);
			}		

		}

		catch(Exception e)

		{
			gm.logFail(logger, "Exception occured:"+e.getMessage(),driver);
		}

	}

}



