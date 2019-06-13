package com.RM.Main_Scripts;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.RM.Generic.EnvironmentVariables;
import com.RM.Generic.GenericMethods2;
import com.RM.Generic.common_methods;
import com.RM.Scripts.XnarfMainPage_Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class XnarfMainPage_Main {

	
	GenericMethods2 gm = new GenericMethods2();
	common_methods cm = new common_methods();
	XnarfMainPage_Test XMT = new XnarfMainPage_Test();
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
			XnarfMainPage_Test.go_to_MainPage(common_methods.driver,logger);
			Thread.sleep(10000);
		}
		catch(Exception e)
		{
			gm.logFail(logger, "Exception occured"+e,common_methods.driver);
		}
	}
	// for split function
	@Test(priority=2,dataProvider="XNARF_TASK")
	
	public void Xnarf_Task(String flag, String action_type, String Request_id) throws Exception 
	{
		try
		{	
			if(flag.equalsIgnoreCase("y") && action_type.equals("Split"))
			{
				try
				{
				XMT.Split_Request(common_methods.driver, Request_id, logger);
				}
				catch(Exception e)
				{
					gm.logFail(logger, "Exception occured"+e,common_methods.driver);
				}
			}
			else if(flag.equalsIgnoreCase("y") && action_type.equals("delete"))
			{
				try
				{
				XMT.Delete_Request(common_methods.driver, Request_id, logger);
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
	@DataProvider(name="XNARF_TASK")
	public Object[][] getData()
	{
		Object[][] c1 = gm.getExcelData(EnvironmentVariables.dataPoolPath, "XNARF_Task");
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
