package com.RM.Main_Scripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.RM.Generic.EnvironmentVariables;
import com.RM.Generic.GenericMethods2;
import com.RM.Generic.common_methods;
import com.RM.Scripts.WP_New_Hire_Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class WP_New_Hire_Main {
	GenericMethods2 gm = new GenericMethods2();
	common_methods cm = new common_methods();
	WP_New_Hire_Test WNT = new WP_New_Hire_Test();
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
			WNT.go_to_Main_Page(common_methods.driver,logger);
			Thread.sleep(10000);
		}
		catch(Exception e)
		{
			gm.logFail(logger, "Exception occured"+e,common_methods.driver);
		}
	}
	
	@Test(priority=2,dataProvider="XNARF_WP_TASK")
	public void RM_Single(String flag, String action_type, String Request_id,String First,String Personnel_Number,String Badge_Number,String comments,String Access_type) throws Exception 
	{
		try
		{	
			if(flag.equalsIgnoreCase("y") && action_type.equals("Single"))
			{
				try
				{
				 WNT.WP_Single(common_methods.driver, Request_id, First, Personnel_Number,Badge_Number, comments, Access_type, logger);
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
					WNT.WP_Multiple(common_methods.driver, Request_id, First,Personnel_Number, Badge_Number, comments, Access_type, logger);
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
						WNT.MultipleComplete(common_methods.driver, Request_id,First, Personnel_Number ,Badge_Number,comments, Access_type, logger);
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
	@DataProvider(name="XNARF_WP_TASK")
	public Object[][] getData()
	{
		Object[][] c1 = gm.getExcelData(EnvironmentVariables.dataPoolPath, "Xnarf_WP");
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
