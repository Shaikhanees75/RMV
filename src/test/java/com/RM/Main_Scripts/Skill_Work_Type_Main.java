package com.RM.Main_Scripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.RM.Generic.EnvironmentVariables;
import com.RM.Generic.GenericMethods2;
import com.RM.Generic.common_methods;
import com.RM.Scripts.Skill_Competency_Test;
import com.RM.Scripts.Skill_Work_Type_Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Skill_Work_Type_Main {
	GenericMethods2 gm = new GenericMethods2();
	common_methods cm = new common_methods();
	Skill_Work_Type_Test SWT = new Skill_Work_Type_Test();
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
			Thread.sleep(5000);
			// Extend Reports 
			reports = new ExtentReports(EnvironmentVariables.reportPath);
			logger = reports.startTest("Skill_Work_type");
		}
		catch(Exception e)
		{
			System.out.println("Message" + e);
			gm.logFail(logger, "Exception occured"+e,cm.driver);
		}
	}
	
	@Test(priority=1)
	//Go to Xnarf Task page
	public  void Menu_Navigation() throws Exception 
	{
		try
		{
			SWT.go_to_Skill_Master_menu(cm.driver,logger);

			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			System.out.println("Message" + e);
			gm.logFail(logger, "Exception occured"+e,cm.driver);
		}
	}
	
	@Test(priority=2,dataProvider="Skill_Work_type")
	public void Skill_Competency(String Flag,String Action,String WorkType_name,String WorkType_desc,String Industry_type,String WorkType_group,String tag) throws Exception
	{
		try
		{	
			if(Flag.equalsIgnoreCase("y") && Action.equals("Mandatory Check"))
			{
				try
				{
					SWT.Mandatory_check(cm.driver, logger);;
				}
				catch(Exception e)
				{
					gm.logFail(logger, "Exception occured"+e,cm.driver);
				}
			}
//			else if(Flag.equalsIgnoreCase("y") && Action.equals("Add"))
//			{
//				try
//				{
//					SCT.Add_Competency(cm.driver, Competency_details, Competency_name, Competency_desc, Industry_type, Validity_days, min_prof, max_prof, tag, Competency_type, Competency, Proficiency, logger);
//				}
//				catch(Exception e)
//				{
//					gm.logFail(logger, "Exception occured"+e,cm.driver);
//				}
//			}
//			else if(Flag.equalsIgnoreCase("y") && Action.equals("Edit"))
//				{
//					try
//					{
//						SCT.Edit_Competency(cm.driver, Competency_details, Competency_name, Competency_desc, Industry_type, Validity_days, min_prof, max_prof, tag, Competency_type, Competency, Proficiency, logger);
//						}
//					catch(Exception e)
//					{
//						gm.logFail(logger, "Exception occured"+e,common_methods.driver);
//					}
//				}
							
		}
		catch(Exception e)
		{
			
			System.out.println("Message" + e);
			gm.logFail(logger, "Exception occured"+e,cm.driver);
		}
	
	
	}
	@DataProvider(name="Skill_Work_type")
	public Object[][] getData()
	{
		Object[][] c1 = gm.getExcelData(EnvironmentVariables.dataPoolPath, "Skill_Work_type");
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





