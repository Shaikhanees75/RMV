package com.RM.Main_Scripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.RM.Generic.EnvironmentVariables;
import com.RM.Generic.GenericMethods2;
import com.RM.Generic.common_methods;
import com.RM.Scripts.RM_NewHire_Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class RM_NewHire__Main {



	GenericMethods2 gm = new GenericMethods2();
	common_methods cm = new common_methods();
	RM_NewHire_Test RNT = new RM_NewHire_Test();
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
			logger = reports.startTest("XnarfTask");
		}
		catch(Exception e)
		{
			gm.logFail(logger, "Exception occured"+e,common_methods.driver);
		}
	}

	@Test(priority=1)
	//Go to Xnarf Task page
	public  void Menu_Navigation() throws Exception 
	{
		try
		{
			RNT.go_to_RMPage(common_methods.driver,logger);
			Thread.sleep(10000);
		}
		catch(Exception e)
		{
			gm.logFail(logger, "Exception occured"+e,common_methods.driver);
		}
	}

	@Test(priority=2,dataProvider="XNARF_RM_TASK")
	public void RM_Single(String flag, String action_type, String Request_id,String First,String Personnel_Number,String Enterprise_id,String comments,String Email_id,String New_personnel_number) throws Exception 
	{
		try
		{	
			if(flag.equalsIgnoreCase("y") && action_type.equals("Single"))
			{
				try
				{
					RNT.RM_Single(common_methods.driver, Request_id, First,Personnel_Number,Enterprise_id, comments, Email_id, New_personnel_number, logger);
				}
				catch(Exception e)
				{
					gm.logFail(logger, "Exception occured"+e,common_methods.driver);
				}
			}
			else if(flag.equalsIgnoreCase("y") && action_type.equals("Multiple"))
			{
				try
				{
					RNT.RM_Multiple(common_methods.driver, Request_id, First,Personnel_Number,Enterprise_id, comments, Email_id, New_personnel_number, logger);
				}
				catch(Exception e)
				{
					gm.logFail(logger, "Exception occured"+e,common_methods.driver);
				}
			}

			else if(flag.equalsIgnoreCase("y") && action_type.equals("MultipleComplete"))
			{
				try
				{
					RNT.MultipleComplete(common_methods.driver, Request_id, First,Personnel_Number,Enterprise_id, comments, Email_id, New_personnel_number, logger);
				}
				catch(Exception e)
				{
					gm.logFail(logger, "Exception occured"+e,common_methods.driver);
				}
			}


		}
		catch(Exception e)
		{
			gm.logFail(logger, "Exception occured"+e,common_methods.driver);
		}
	}
	@DataProvider(name="XNARF_RM_TASK")
	public Object[][] getData()
	{
		Object[][] c1 = gm.getExcelData(EnvironmentVariables.dataPoolPath, "Xnarf_RM");
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
