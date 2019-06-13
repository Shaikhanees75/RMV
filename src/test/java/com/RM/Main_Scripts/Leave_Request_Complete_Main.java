package com.RM.Main_Scripts;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.RM.Generic.EnvironmentVariables;
import com.RM.Generic.GenericMethods2;
import com.RM.Generic.common_methods;
import com.RM.Scripts.Leave_Request_Complete_Test;
import com.RM.Scripts.Leave_Request_Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Leave_Request_Complete_Main 
{
	GenericMethods2 gm = new GenericMethods2();
	common_methods cm = new common_methods();
	Leave_Request_Complete_Test LRT = new Leave_Request_Complete_Test();
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
	public void Apply_Leave(String flag, String action_type,String EmployeeID,String LeaveFDate,String fromDate,String LeaveTDate,String toDate,String leaveType,String startTime,String duration,String CancelLeaveDate,String editdate,String editFdate,String newfromDate,String editTdate,String newtoDate,String newleaveType,String newstartTime,String newduration) throws Exception 
	{
		try
		{

			if(flag.equalsIgnoreCase("y") && action_type.equals("Apply Leave"))
			{
				try
				{
					
					LRT.Apply_New_Leave(common_methods.driver,EmployeeID,LeaveFDate, fromDate,LeaveTDate, toDate, leaveType, startTime, duration, logger);
					
				}
				catch (Exception e) 
				{
					gm.logFail(logger, "Exception occured"+e,common_methods.driver);
				}
				
			}
				
				else if(flag.equalsIgnoreCase("y") && action_type.equals("Cancel Leave"))
		
					try
				{
				LRT.Cancel_Leave_Calendar(common_methods.driver,EmployeeID,CancelLeaveDate,logger);
				}
			catch (Exception e) 
			{
				gm.logFail(logger, "Exception occured"+e,common_methods.driver);
			}
				
			
				else if(flag.equalsIgnoreCase("y") && action_type.equals("Edit Leave"))
				
					try
				{
				LRT.Edit_Leave_Calendar(common_methods.driver,EmployeeID,editdate,editFdate,newfromDate,editTdate,newtoDate,newleaveType,newstartTime,newduration,logger);
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
		Object[][] c1 = gm.getExcelData(EnvironmentVariables.dataPoolPath, "Leave_Request_cmp");
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




