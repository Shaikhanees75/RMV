package com.RM.Main_Scripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.RM.Generic.EnvironmentVariables;
import com.RM.Generic.GenericMethods2;
import com.RM.Generic.common_methods;
import com.RM.Scripts.Skill_Workflow_Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Skill_Workflow_Main {
	GenericMethods2 gm = new GenericMethods2();
	common_methods cm = new common_methods();
	Skill_Workflow_Test SCT = new Skill_Workflow_Test();
	ExtentReports reports ;
	ExtentTest logger;
//	WebDriver driver;
	
	@BeforeClass()
	public void Browser_set() throws InterruptedException 
	{
		try
		{
			//Open Browser 
			cm.Open();
			Thread.sleep(10000);
			// Extend Reports 
			reports = new ExtentReports(EnvironmentVariables.reportPath);
			logger = reports.startTest("Skill Change Request");
		}
		catch(Exception e)
		{
			System.out.println("Message" + e);
			gm.logFail(logger, "Exception occured"+e,cm.driver);
		}
	}
	
	@Test(priority=1)
	//Go to Skill change page
	public  void Menu_Navigation() throws Exception 
	{
		try
		{
			SCT.go_to_Skill_Approval(cm.driver,logger);

			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			System.out.println("Message" + e);
			gm.logFail(logger, "Exception occured"+e,cm.driver);
		}
	}
	
	@Test(priority=2,dataProvider="Skill_Workflow")
	public void Skill_Competency(String Flag,String Action,String Search) throws Exception
	{
		try
		{	
			if(Flag.equalsIgnoreCase("y") && Action.equals("Approve"))
			{
				try
				{
					SCT.Skill_Approve(cm.driver, Search,logger);
				}
				catch(Exception e)
				{
					gm.logFail(logger, "Exception occured"+e,cm.driver);
				}
			}
			else if(Flag.equalsIgnoreCase("y") && Action.equals("Edit"))
			{
				try
				{
					//SCT.Edit_Skill(cm.driver, Skill_type, Skill, Proficeincy, Valid_from, Valid_to, logger);
				}
				catch(Exception e)
				{
					gm.logFail(logger, "Exception occured"+e,cm.driver);
				}
			}
			else if(Flag.equalsIgnoreCase("y") && Action.equals("Delete"))
				{
					try
					{
						//SCT.Delete_Skill(cm.driver, logger);
						}
					catch(Exception e)
					{
						gm.logFail(logger, "Exception occured"+e,common_methods.driver);
					}
				}
							
		}
		catch(Exception e)
		{
			
			System.out.println("Message" + e);
			gm.logFail(logger, "Exception occured"+e,cm.driver);
		}
	
	}	
	
	@DataProvider(name="Skill_Workflow")
	public Object[][] getData()
	{
		Object[][] c1 = gm.getExcelData(EnvironmentVariables.dataPoolPath, "Skill_Workflow");
		return c1;		
	}

	@Test(priority=3)
	public void tear() 
	{
		cm.driver.quit();
	}

	@AfterClass
	public void tearDown()
	{
		reports.endTest(logger);
		reports.flush();

	}
	
}




	
	
	
	
	




