package com.RM.Main_Scripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.RM.Generic.EnvironmentVariables;
import com.RM.Generic.GenericMethods2;
import com.RM.Generic.common_methods;
import com.RM.Scripts.Leave_Approval_Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Leave_Approval_Main {
	GenericMethods2 gm = new GenericMethods2();
	common_methods cm = new common_methods();
	Leave_Approval_Test LAT = new Leave_Approval_Test();
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
			logger = reports.startTest("Leave Approval Page");
		}
		catch(Exception e)
		{
			gm.logFail(logger, "Exception occured"+e,common_methods.driver);
		}
	}



	@Test(priority=1)
	//Go to Leave Approval page
	public  void Menu_Navigation() throws Exception 
	{
		try
		{
			Leave_Approval_Test.go_to_leave_approval(common_methods.driver,logger);

			Thread.sleep(10000);
		}
		catch(Exception e)
		{
			gm.logFail(logger, "Exception occured"+e,common_methods.driver);
		}
	}

	// Leave Approval
	@Test(priority=2,dataProvider="LEAVE_REQUEST")
	public void Apply_Leave(String flag,String Approval,String EmployeeID,String LeaveDate,String EmployeeName,String FromDate,String comments) throws Exception 
	{
		try
		{

			if(flag.equalsIgnoreCase("y"))
			{
				try
				{

					LAT.Approve_New_Leave(common_methods.driver, Approval, EmployeeID, LeaveDate, EmployeeName, FromDate,comments, logger);

				}
				catch (Exception e) 
				{
					gm.logFail(logger, "Exception occured"+e,common_methods.driver);
				}
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
		Object[][] c1 = gm.getExcelData(EnvironmentVariables.dataPoolPath, "Leave_Approval");
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




