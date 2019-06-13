package com.RM.Main_Scripts;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.RM.Generic.EnvironmentVariables;
import com.RM.Generic.GenericMethods2;
import com.RM.Generic.common_methods;
import com.RM.Scripts.Leave_Request_Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Leave_apply_test 
{
	GenericMethods2 gm = new GenericMethods2();
	common_methods cm = new common_methods();
	Leave_Request_Test LRT = new Leave_Request_Test();
	ExtentReports reports ;
	ExtentTest logger;
	

	@BeforeClass()
	public void Browser_set() throws InterruptedException 
	{
		try
		{
			//Open Browser
			cm.Open();
			Thread.sleep(20000);
			// Extend Reports 
			reports = new ExtentReports(EnvironmentVariables.reportPath);
			logger = reports.startTest("Leave Request");
		}
		catch(Exception e)
		{
			gm.logFail(logger, "Exception occured"+e,common_methods.driver);
		}
	}
		
	

	@Test(priority=1)
	//Go to Leave Request page
	public  void Menu_Navigation() throws Exception 
	{
		try
		{
			Leave_Request_Test.go_to_leave_request(common_methods.driver,logger);

			Thread.sleep(10000);
		}
		catch(Exception e)
		{
			gm.logFail(logger, "Exception occured"+e,common_methods.driver);
		}
	}


	//Apply Leave
	@Test(priority=2,dataProvider="LEAVE_REQUEST")
	public void Apply_Leave(String flag, String action_type,String fromDate,String toDate,String leaveType,String startTime,String duration,String CancelLeaveDate,String editdate,String newfromDate,String newtoDate,String newleaveType,String newstartTime,String newduration) throws Exception 
	{
		try
		{

			if(flag.equalsIgnoreCase("y") && action_type.equals("Apply Leave"))
			{
				try
				{
					
					LRT.Apply_New_Leave(common_methods.driver, fromDate, toDate, leaveType, startTime, duration, logger);
					
				}
				catch (Exception e) 
				{
					gm.logFail(logger, "Exception occured"+e,common_methods.driver);
				}
				
			}
				
				else if(flag.equalsIgnoreCase("y") && action_type.equals("Cancel Leave"))
		
					try
				{
				LRT.Cancel_Leave_Calendar(common_methods.driver,CancelLeaveDate,logger);
				}
			catch (Exception e) 
			{
				gm.logFail(logger, "Exception occured"+e,common_methods.driver);
			}
				
			
				else if(flag.equalsIgnoreCase("y") && action_type.equals("Edit Leave"))
				
					try
				{
				LRT.Edit_Leave_Calendar(common_methods.driver,editdate,newfromDate,newtoDate,newleaveType,newstartTime,newduration,logger);
				}
			catch (Exception e) 
			{
				gm.logFail(logger, "Exception occured"+e,common_methods.driver);
			}
					
			}
			catch(Exception e)
			{
				gm.logFail(logger, "Exception occured:"+e.getMessage(),common_methods.driver);
			}
		}
	@DataProvider(name="LEAVE_REQUEST")
	public Object[][] getData()
	{
		Object[][] c1 = gm.getExcelData(EnvironmentVariables.dataPoolPath, "Leave_Request");
		return c1;		
	}

	@Test(priority=3)
	public void tear() 
	{
		common_methods.driver.quit();
	}

	@AfterClass
	public void tearDown()
	{
		reports.endTest(logger);
		reports.flush();

	}
}
	

/*	@Test(priority=3)
	public  void Cancel_Leave_Calendar(WebDriver driver, ExtentTest logger) throws Exception 
	
	{
		String date="07-November-2017";
		
		
		//Split Date
		String splitter[] = date.split("-");
		String leaveMonth=splitter[1];
		String leaveDate=splitter[0];
		String leaveYear=splitter[2];
		
		try
		{
		
		
		
		for(int i=0; i<12;i++)
		{
			WebElement CurrentMonth = driver.findElement(Leave_Request_Obj.current_month);
			String CurrentMonth1=CurrentMonth.getText();
		
		
			if(CurrentMonth1.equalsIgnoreCase(leaveMonth))
			{
				gm.logInfo(logger, "We are in the required month");
		}
			else
			{
				//Click on Next month
				WebElement submit_btn=driver.findElement(Leave_Request_Obj.submit_btn);
				submit_btn.click();
				gm.logInfo(logger, "We have navigated to the required month");
			}
		}
		
		//get the year difference between current year and year to set in calendar
		int yearDiff = Integer.parseInt(leaveYear)- Calendar.getInstance().get(Calendar.YEAR);
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
		}
		
		catch(Exception e)
		{
			gm.logFail(logger, "Exception occured:"+e.getMessage(),driver);
		}
	}
		
	@Test(priority=4)
	public  void Edit_Leave_Calendar(WebDriver driver, ExtentTest logger) throws Exception {

		String date="07-November-2017";
		String newfromDate ="12/08/2017";
		String newtoDate="12/08/2017";
		String newleaveType="New";
		String newstartTime="06:00";
		String newduration="07:00";
		
		//Split Date
		String splitter[] = date.split("-");
		String leaveMonth=splitter[1];
		String leaveDate=splitter[0];
		String leaveYear=splitter[2];
		try
		{
		
		
		for(int i=0; i<12;i++)
		{
			WebElement CurrentMonth = driver.findElement(Leave_Request_Obj.current_month);
			String CurrentMonth1=CurrentMonth.getText();
		
		
			if(CurrentMonth1.equalsIgnoreCase(leaveMonth))
			{
				gm.logInfo(logger, "We are in the required month");
		}
			else
			{
				//Click on Next month
				WebElement submit_btn=driver.findElement(Leave_Request_Obj.submit_btn);
				submit_btn.click();
				gm.logInfo(logger, "We have navigated to the required month");
			}
		}
		
		//get the year difference between current year and year to set in calendar
		int yearDiff = Integer.parseInt(leaveYear)- Calendar.getInstance().get(Calendar.YEAR);
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
		 
		//Click on to date calendar
		 WebElement todate = driver.findElement(Leave_Request_Obj.to_date);
	     todate.click();
	     gm.logInfo(logger, "We have clicked on to date cleandar");
	     
	    //Select to date
		 cm.testDAtePicker(newtoDate);
		 
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
		
		//Click on Submit
		WebElement submit_btn=driver.findElement(Leave_Request_Obj.submit_btn);
		submit_btn.click();
		gm.logInfo(logger, "We have clicked on submit button");
		
}
		
		catch(Exception e)
		{
			gm.logFail(logger, "Exception occured:"+e.getMessage(),driver);
		}
	}*/
		



