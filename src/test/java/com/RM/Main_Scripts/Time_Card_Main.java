package com.RM.Main_Scripts;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.RM.Generic.EnvironmentVariables;
import com.RM.Generic.GenericMethods2;
import com.RM.Generic.common_methods;
import com.RM.Scripts.Time_Card_Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Time_Card_Main {
	GenericMethods2 gm = new GenericMethods2();
	common_methods cm = new common_methods();
	Time_Card_Test TCT = new Time_Card_Test();
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
			logger = reports.startTest("TimeCard");
		}
		catch(Exception e)
		{
			gm.logFail(logger, "Exception occured"+e,common_methods.driver);
		}
	}
	
	
	@Test(priority=1)
	//Go to Time Card page
	public  void Menu_Navigation() throws Exception 
	{
		try
		{
			Time_Card_Test.go_to_time_card(common_methods.driver,logger);

			Thread.sleep(10000);
		}
		catch(Exception e)
		{
			gm.logFail(logger, "Exception occured"+e,common_methods.driver);
		}
	}
	//Fill Time card
	
		@Test(priority=2,dataProvider="TIME_CARD")
		public void Time_Card( String flag, String action_type,String Date,String Sub_Activity,String StartTime,String EndTime,String SearchTime) throws Exception 
		{
			try
			{

				if(flag.equalsIgnoreCase("y") && action_type.equals("add"))
				{
					try
					{
						
						TCT.Add_Time_Card(common_methods.driver,Date,Sub_Activity,StartTime,EndTime,SearchTime,logger);
						
					}
					catch (Exception e)
					{
						gm.logFail(logger, "Exception occured"+e,common_methods.driver);
					}
					
				}
					
				else if (flag.equalsIgnoreCase("y") && action_type.equals("edit"))
				{
				try
					{
						TCT.Edit_Time_Card(common_methods.driver,Date,Sub_Activity,StartTime, EndTime,SearchTime, logger);
					}
				catch (Exception e) 
				{
					gm.logFail(logger, "Exception occured"+e,common_methods.driver);
				}
				}
				else if (flag.equalsIgnoreCase("y") && action_type.equals("delete"))
				{
					TCT.Delete_Time_Card(common_methods.driver,Date,Sub_Activity,StartTime, EndTime,SearchTime, logger);
				}
				else
				{
					gm.logInfo(logger, "All scenarios covered");
				}
			}
			catch(Exception e)
				{
					
					gm.logFail(logger, "Exception occured:"+e.getMessage(),common_methods.driver);
				}
			
			
		}		
@DataProvider(name="TIME_CARD")
public Object[][] getData()
{
	Object[][] c1 = gm.getExcelData(EnvironmentVariables.dataPoolPath, "Time_Card");
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
		
			
			
			
			
			
			
			
			
			