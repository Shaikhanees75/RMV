package com.RM.Main_Scripts;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.RM.Generic.EnvironmentVariables;
import com.RM.Generic.GenericMethods2;
import com.RM.Generic.common_methods;
import com.RM.Scripts.Employee_Information_Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Employee_Information_Main {

	GenericMethods2 gm = new GenericMethods2();
	common_methods cm= new common_methods();
	Employee_Information_Test ANU = new Employee_Information_Test();
	ExtentReports reports ;
	ExtentTest logger;

	@BeforeClass()
	public void Set_UP() throws InterruptedException 
	{
		try
		{
			//Open Browser
			cm.Open();
			Thread.sleep(15000);
			// Extend Reports 
			reports = new ExtentReports(EnvironmentVariables.reportPath);
			logger = reports.startTest("Employee Information");
		}
		catch(Exception e)
		{
			gm.logFail(logger, "Exception occured"+e,common_methods.driver);
		}
		reports.endTest(logger);
	}
	@Test(priority=1)
	public void Go_to_Menu() throws Exception 
	{
		logger = reports.startTest("Menu Navigation");
		try
		{
			ANU.Set_Up_Employee_Inforamtion(common_methods.driver, logger);
		}
		catch(Exception e)
		{
			gm.logFail(logger, "Exception occured"+e,common_methods.driver);
		}
		reports.endTest(logger);
	}


	@Test(priority=2,dataProvider="Employee_Information")
	public void Employee_Information_Entry(String Flag,String Action,String Scenario ,String Search_Sap_id,String Sap_id,String Prefix,String Suffix,String First_Name,
			String Middle_Name,String Last_Name,String Preferred_Name,String Badge_Number ,String Workforce_Manager,String Functional_Manager,String DOJ,String Conifrmation_Status,String Confirmation_Date,
			String LOB,String Client,String SOW,String Department,String Designation,String Office_Location,String Seat_Number,String Fixed_Schedule_Name,
			String Level,String Employment_Status,String Operation_Category,String Effective_Date,String User_id,String User_Name,String LDAP,String Password,String Active,String Add_Email,String Email_Type,String Email_address,
			String Add_Phone,String Phone_Type,String Country_code,String Contact_no,String Extension,String Add_Address,String Address_Type,String Address1,String Address2,
			String Location,String City,String State,String Country,String Zipcode,String Add_Personal_Details,String DOB,String Marital_sts,String Anniversary_date,String ADP_ID,String Enterprise_ID,String Access_Type,String Delegate_To,String From_date,String To_date,String DelegateActive,String Separation_type,String Termaination_Date,String LWD,String Comments,String Revoke) throws Exception 
	{
		try
		{
			
			if(Flag.equalsIgnoreCase("y") && Action.equals("Employee Search"))
			{
				logger = reports.startTest(Scenario);
				
				try

				{
					ANU.Employee_Search(common_methods.driver,Search_Sap_id, logger);
				}

				catch(Exception e)
				{
					gm.logFail(logger, "Exception occured"+e,common_methods.driver);
				}
				reports.endTest(logger);
			}

			if(Flag.equalsIgnoreCase("y") && Action.equals("Edit Employee Details"))
			{
				logger = reports.startTest(Scenario);
				try

				{
					ANU.Edit_Employee(common_methods.driver,Search_Sap_id,Sap_id, Prefix, Suffix, First_Name, Middle_Name, Last_Name, Preferred_Name, Badge_Number, Workforce_Manager, Functional_Manager,DOJ,Conifrmation_Status,Confirmation_Date,
							LOB, Client, SOW, Department, Designation, Office_Location, Seat_Number, 
							Fixed_Schedule_Name, Level, Employment_Status, Operation_Category, Effective_Date,logger);
				}

				catch(Exception e)
				{
					gm.logFail(logger, "Exception occured"+e,common_methods.driver);
				}
				reports.endTest(logger);
			}

			else if(Flag.equalsIgnoreCase("y") && Action.equals("Edit User Details"))
			{
				logger = reports.startTest(Scenario);
				try {
					ANU.Edit_User_Details(common_methods.driver,Search_Sap_id,User_id, User_Name,LDAP,Password,Active,logger);
				}
				catch(Exception e)
				{
					gm.logFail(logger, "Exception occured"+e,common_methods.driver);
				}
				reports.endTest(logger);
			}

			else if(Flag.equalsIgnoreCase("y") && Action.equals("Edit Contact Details"))
			{
				logger = reports.startTest(Scenario);
				try {
					ANU.Edit_Contact_Details(common_methods.driver,Search_Sap_id,Add_Email,Email_Type, Email_address,Add_Phone, Phone_Type, Country_code, Contact_no, Extension,logger);
				}
				catch(Exception e)
				{
					gm.logFail(logger, "Exception occured"+e,common_methods.driver);
				}	
				reports.endTest(logger);
			}
			
			
			else if(Flag.equalsIgnoreCase("y") && Action.equals("Edit Contact Information Details"))
			{
				logger = reports.startTest(Scenario);
				try {
					ANU.Edit_ContactInfo_Details(common_methods.driver,Search_Sap_id,Add_Address,Address_Type, Address1,Address2,Location,City,State,Country,Zipcode,Add_Personal_Details, DOB,Marital_sts,Anniversary_date,logger);
				}
				catch(Exception e)
				{
					gm.logFail(logger, "Exception occured"+e,common_methods.driver);
				}
				reports.endTest(logger);
			}
			
			else if(Flag.equalsIgnoreCase("y") && Action.equals("Edit Other Details"))
			{
				logger = reports.startTest(Scenario);
				try {
					ANU.Edit_other_Details(common_methods.driver,Search_Sap_id,ADP_ID, Enterprise_ID, Access_Type,logger);
				}
				catch(Exception e)
				{
					gm.logFail(logger, "Exception occured"+e,common_methods.driver);
				}
				reports.endTest(logger);
			}

			else if(Flag.equalsIgnoreCase("y") && Action.equals("Edit Delegate Details"))
			{
				logger = reports.startTest(Scenario);
				try {
					ANU.Edit_Delegate_Details(common_methods.driver,Search_Sap_id,Delegate_To,From_date,To_date,DelegateActive,logger);
				}
				catch(Exception e)
				{
					gm.logFail(logger, "Exception occured"+e,common_methods.driver);
				}
				reports.endTest(logger);
				
			}
			else if(Flag.equalsIgnoreCase("y") && Action.equals("Edit Separation Details"))
			{
				logger = reports.startTest(Scenario);
				try {
					ANU.Edit_Separation_Details(common_methods.driver,Search_Sap_id,Separation_type,Termaination_Date,LWD,Comments,Revoke,logger);
				}
				catch(Exception e)
				{
					gm.logFail(logger, "Exception occured"+e,common_methods.driver);
				}	
				reports.endTest(logger);
			}
		}

		catch(Exception e)
		{
			gm.logFail(logger, "Exception occured"+e,common_methods.driver);
		}
	}
	@DataProvider(name="Employee_Information")
	public Object[][] getData()
	{
		Object[][] c1 = gm.getExcelData(EnvironmentVariables.dataPoolPath, "Employee_Information");
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
		
		reports.flush();

	}
}
