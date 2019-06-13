package com.RM.Main_Scripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.RM.Generic.EnvironmentVariables;
import com.RM.Generic.GenericMethods2;
import com.RM.Generic.common_methods;
import com.RM.Scripts.OB_NewHire_Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class OB_NewHire_Main {
	
	
	
	GenericMethods2 gm = new GenericMethods2();
	common_methods cm = new common_methods();
	OB_NewHire_Test ONT = new OB_NewHire_Test();
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
			OB_NewHire_Test.go_to_MainPage(common_methods.driver,logger);
			Thread.sleep(10000);
		}
		catch(Exception e)
		{
			gm.logFail(logger, "Exception occured"+e,common_methods.driver);
		}
	}
	
	@Test(priority=2,dataProvider="XNARF_OB_TASK")
	public void Xnarf_OB(String flag, String action_type,String Request_id,String First,String Employee_id,String search_seat,String Comments, String job_need_comment,String tree_search,String ob_wbs,String Delegte, String Delegate1) throws Exception 
	{
		try
		{	
			if(flag.equalsIgnoreCase("y") && action_type.equals("Single"))
			{
				try
				{
					ONT.OB_Single(common_methods.driver, Request_id,First,Employee_id,search_seat,Comments,job_need_comment,tree_search,ob_wbs,Delegte,Delegate1, logger);
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
					ONT.RM_Multiple(common_methods.driver, Request_id,First,Employee_id,search_seat,Comments,job_need_comment,tree_search,ob_wbs,Delegte,Delegate1, logger);
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
						ONT.MultipleComplete(common_methods.driver, Request_id,First,Employee_id,search_seat,Comments,job_need_comment,tree_search,ob_wbs,Delegte,Delegate1, logger);
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
	@DataProvider(name="XNARF_OB_TASK")
	public Object[][] getData()
	{
		Object[][] c1 = gm.getExcelData(EnvironmentVariables.dataPoolPath, "Xnarf_OB");
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
