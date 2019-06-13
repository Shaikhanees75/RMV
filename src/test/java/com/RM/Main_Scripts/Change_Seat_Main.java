package com.RM.Main_Scripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.RM.Generic.EnvironmentVariables;
import com.RM.Generic.GenericMethods2;
import com.RM.Generic.common_methods;
import com.RM.Scripts.Change_Seat_Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Change_Seat_Main {
	
	GenericMethods2 gm = new GenericMethods2();
	common_methods cm = new common_methods();
	Change_Seat_Test CST = new Change_Seat_Test();
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
			logger = reports.startTest("Change_Seat");
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
			CST.go_to_Main_Page(common_methods.driver,logger);
			Thread.sleep(10000);
		}
		catch(Exception e)
		{
			gm.logFail(logger, "Exception occured"+e,common_methods.driver);
		}
	}
	
	@Test(priority=2,dataProvider="CHANGE_SEAT")
	public void Change_Seat(String flag, String action_type,String Request_id,String First,String Personnel_Number, String comments) throws Exception 
	{
		try
		{	
			if(flag.equalsIgnoreCase("y") && action_type.equals("Single"))
			{
				try
				{
				 CST.Change_seat(common_methods.driver, Request_id,First,Personnel_Number, comments, logger);
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
					CST.Change_seat_Multiple(common_methods.driver, Request_id,First, Personnel_Number ,comments,  logger);
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
						CST.MultipleComplete(common_methods.driver, Request_id,First, Personnel_Number ,comments,  logger);
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
	@DataProvider(name="CHANGE_SEAT")
	public Object[][] getData()
	{
		Object[][] c1 = gm.getExcelData(EnvironmentVariables.dataPoolPath, "Change_Seat");
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




	
	
	


