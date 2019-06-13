//package com.RM.Main_Scripts;
//
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//import com.RM.Generic.EnvironmentVariables;
//import com.RM.Generic.GenericMethods2;
//import com.RM.Generic.common_methods;
//import com.RM.Scripts.XNARF_CS_Script;
//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//
//public class XNARF_CS_Main {
//	GenericMethods2 gm = new GenericMethods2();
//	common_methods cm= new common_methods();
//	XNARF_CS_Script XTF = new XNARF_CS_Script();
//	ExtentReports reports ;
//	ExtentTest logger;
//
//	@BeforeClass()
//	public void Set_UP() throws InterruptedException 
//	{
//		try
//		{
//			//Open Browser
//			cm.Open();
//			Thread.sleep(10000);
//			// Extend Reports 
//			reports = new ExtentReports(EnvironmentVariables.reportPath);
//			logger = reports.startTest("XNARF Task");
//		}
//		catch(Exception e)
//		{
//			gm.logFail(logger, "Exception occured"+e,common_methods.driver);
//		}
//		reports.endTest(logger);
//	}
//	@Test(priority=1)
//	public void Go_to_Menu() throws Exception 
//	{
//		logger = reports.startTest("Menu Navigation");
//		try
//		{
//			common_methods.go_to_xnarf_task(common_methods.driver, logger);
//		}
//		catch(Exception e)
//		{
//			gm.logFail(logger, "Exception occured"+e,common_methods.driver);
//		}
//		reports.endTest(logger);
//	}
//
//
//	@Test(priority=2,dataProvider="XNARF_Task")
//	public void XNARF_Task_WF(String Flag,String Action,String Scenario,String Type,String Task,String Request_ID,String Sap_id,String Client_Name,String Preferred_Name,String Effective_date,String Seat_number,String Comments,String Delgate_To,String Locked_by) throws Exception 
//	{
//		try
//		{
//			
//			if(Flag.equalsIgnoreCase("y") && Action.equals("Navigate"))
//			{
//				logger = reports.startTest("Navigating to following Request ID: "+Type+"-"+Task+"-"+Request_ID);
//				
//				try
//
//				{
//					common_methods.go_to_required_task(common_methods.driver,Type,Task,Request_ID, logger);
//				}
//
//				catch(Exception e)
//				{
//					gm.logFail(logger, "Exception occured"+e,common_methods.driver);
//				}
//				reports.endTest(logger);
//			}
//
//			
//			if(Flag.equalsIgnoreCase("y") && Action.equals("Mandatory Check"))
//			{
//				logger = reports.startTest("Mandatory Check for following request: "+Type+"-"+Task+"-"+Request_ID);
//				
//				try
//
//				{
//					XTF.Main_Screen_Mandatory_Check(common_methods.driver,logger);
//					
//				}
//
//				catch(Exception e)
//				{
//					gm.logFail(logger, "Exception occured"+e,common_methods.driver);
//				}
//				reports.endTest(logger);
//			}
//			
//			if(Flag.equalsIgnoreCase("y") && Action.equals("Transfer SOW-Add Data"))
//			{
//				logger = reports.startTest("Adding data for following request: "+Type+"-"+Task+"-"+Request_ID);
//				
//				try
//
//				{
//					XTF.XNARF_CS_Enter(common_methods.driver, Sap_id, Client_Name, Preferred_Name, Effective_date, Seat_number, Comments, Locked_by, logger);
//					
//				}
//
//				catch(Exception e)
//				{
//					gm.logFail(logger, "Exception occured"+e,common_methods.driver);
//				}
//				reports.endTest(logger);
//			}
//			
//			if(Flag.equalsIgnoreCase("y") && Action.equals("Select and Delegate"))
//			{
//				logger = reports.startTest("Delegating record "+Sap_id+" to "+Delgate_To+" - "+Request_ID);
//				
//				try
//
//				{
//					common_methods.select_delegate(common_methods.driver,Request_ID, Sap_id, Delgate_To, Locked_by, logger);
//					
//				}
//
//				catch(Exception e)
//				{
//					gm.logFail(logger, "Exception occured"+e,common_methods.driver);
//				}
//				reports.endTest(logger);
//			}
//			
//			if(Flag.equalsIgnoreCase("y") && Action.equals("Multi-Select and Complete"))
//			{
//				logger = reports.startTest("Comppleting all the records for request- "+Request_ID);
//				
//				try
//
//				{
//					common_methods.multiselect_complete(common_methods.driver, logger);
//					
//				}
//
//				catch(Exception e)
//				{
//					gm.logFail(logger, "Exception occured"+e,common_methods.driver);
//				}
//				reports.endTest(logger);
//			}	
//			
//			if(Flag.equalsIgnoreCase("y") && Action.equals("Select and Split"))
//			{
//				logger = reports.startTest("Spliting the record "+Sap_id+ " from request - "+Request_ID);
//				
//				try
//
//				{
//					common_methods.select_split(common_methods.driver, Sap_id, logger);
//					
//				}
//
//				catch(Exception e)
//				{
//					gm.logFail(logger, "Exception occured"+e,common_methods.driver);
//				}
//				reports.endTest(logger);
//			}	
//			
//		}
//
//		catch(Exception e)
//		{
//			gm.logFail(logger, "Exception occured"+e,common_methods.driver);
//		}
//	}
//	@DataProvider(name="XNARF_Task")
//	public Object[][] getData()
//	{
//		Object[][] c1 = gm.getExcelData(EnvironmentVariables.dataPoolPath, "XNARF_CS");
//		return c1;		
//	}
//
//	@Test(priority=3)
//	public void tear() 
//	{
//		common_methods.driver.quit();
//	}
//	@AfterClass
//	public void tearDown()
//	{
//		
//		reports.flush();
//
//	}
//
//}
