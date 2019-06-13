package com.RM.Main_Scripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.RM.Generic.EnvironmentVariables;
import com.RM.Generic.GenericMethods2;
import com.RM.Generic.common_methods;
import com.RM.Scripts.Skill_Competency_Test;
import com.RM.Scripts.WPS_New_Hire_Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Skill_Competency_Main {
	GenericMethods2 gm = new GenericMethods2();
	common_methods cm = new common_methods();
	Skill_Competency_Test SCT = new Skill_Competency_Test();
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
			logger = reports.startTest("XnarfTask");
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
			SCT.go_to_Skill_Master_menu(cm.driver,logger);

			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			System.out.println("Message" + e);
			gm.logFail(logger, "Exception occured"+e,cm.driver);
		}
	}
	
	@Test(priority=2,dataProvider="Skill_Competency")
	public void Skill_Competency(String Flag,String Action,String Competency_details,String Competency_name,String Competency_desc,String Industry_type,String Validity_days,String min_prof,String max_prof,String tag,String Competency_type,String Competency,String Proficiency) throws Exception
	{
		try
		{	
			if(Flag.equalsIgnoreCase("y") && Action.equals("Mandatory Check"))
			{
				try
				{
					SCT.Mandatory_check(cm.driver, Competency_details, logger);
				}
				catch(Exception e)
				{
					gm.logFail(logger, "Exception occured"+e,cm.driver);
				}
			}
			else if(Flag.equalsIgnoreCase("y") && Action.equals("Add"))
			{
				try
				{
					SCT.Add_Competency(cm.driver, Competency_details, Competency_name, Competency_desc, Industry_type, Validity_days, min_prof, max_prof, tag, Competency_type, Competency, Proficiency, logger);
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
						SCT.Edit_Competency(cm.driver, Competency_details, Competency_name, Competency_desc, Industry_type, Validity_days, min_prof, max_prof, tag, Competency_type, Competency, Proficiency, logger);
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
	@DataProvider(name="Skill_Competency")
	public Object[][] getData()
	{
		Object[][] c1 = gm.getExcelData(EnvironmentVariables.dataPoolPath, "Skill_Competency");
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



