package com.RM.Main_Scripts;

import java.util.ArrayList;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.RM.Generic.EnvironmentVariables;
import com.RM.Generic.GenericMethods2;
import com.RM.Generic.common_methods;
import com.RM.Scripts.Add_New_User_Entry_Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Add_New_User_Main_Test 
{
	GenericMethods2 gm = new GenericMethods2();
	common_methods cm= new common_methods();
	Add_New_User_Entry_Test ANU = new Add_New_User_Entry_Test();
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
			logger = reports.startTest("ADD NEW USER");
		}
		catch(Exception e)
		{
			gm.logFail(logger, "Exception occured"+e,common_methods.driver);
		}
	}
 @Test(priority=1)
public void Go_to_Menu() throws Exception 
{
	try
	{
		ANU.Set_Up_Add_new_Employee(common_methods.driver, logger);
		}
	catch(Exception e)
		{
			gm.logFail(logger, "Exception occured"+e,common_methods.driver);
		}
	}

	@Test(priority=2) 
	//Shifted inside and made it key driven with Flag as y and action as mandatory check
	
	public void Mandatory_Check() throws Exception 
	{
		try
		{
			ANU.mandatory_Fields_check(common_methods.driver, logger);
		}
		catch(Exception e)
		{
			gm.logFail(logger, "Exception occured"+e,common_methods.driver);
		}
	}

	@Test(priority=2,dataProvider="Add_NEW_USER")
	public void Add_New_user_Data_Entry(String Flag,String Action,String Scenario,String Sap_id,String Prefix,String Suffix,String First_Name,
			String Middle_Name,String Last_Name,String Preferred_Name,String Badge_Number ,String Workforce_Manager,String Functional_Manager,String DOJ,String Conifrmation_Status,String Confirmation_Date,
			String LOB,String Client,String SOW,String Department,String Designation,String Office_Location,String Seat_Number,String Fixed_Schedule_Name,
			String Level,String Employment_Status,String Operation_Category,String Effective_Date,String User_id,String User_Name,String LDAP,String Password,String Active,String Add_Email,String Email_Type,String Email_address,
			String Add_Phone,String Phone_Type,String Country_code,String Contact_no,String Extension,String Add_Address,String Address_Type,String Address1,String Address2,
			String Location,String City,String State,String Country,String Zipcode,String Add_Personal_Details,String DOB,String Marital_sts,String Anniversary_date,String ADP_ID,String Enterprise_ID,String Access_Type) throws Exception 
	{
		try
		{

			if(Flag.equalsIgnoreCase("y") && Action.equals("Mandatory Check"))
			{
				logger = reports.startTest(Scenario);
				try

				{
					ANU.mandatory_Fields_check(common_methods.driver, logger);
				}

				catch(Exception e)
				{
					gm.logFail(logger, "Exception occured"+e,common_methods.driver);
				}
				reports.endTest(logger);
			}

		if(Flag.equalsIgnoreCase("y") && Action.equals("Add New User"))
		{
			logger = reports.startTest(Scenario);
				try
			
				{
				ANU.Add_Employee(common_methods.driver,Sap_id, Prefix, Suffix, First_Name, Middle_Name, Last_Name, Preferred_Name, Badge_Number, Workforce_Manager, Functional_Manager,DOJ,Conifrmation_Status,Confirmation_Date,
							LOB, Client, SOW, Department, Designation, Office_Location, Seat_Number, 
							Fixed_Schedule_Name, Level, Employment_Status, Operation_Category, Effective_Date,logger);
				}

				catch(Exception e)
				{
					gm.logFail(logger, "Exception occured"+e,common_methods.driver);
				}
			reports.endTest(logger);
		}
			else if(Flag.equalsIgnoreCase("y") && Action.equals("Add User and Detials"))
		{
				logger = reports.startTest(Scenario);
				try
				{
				ArrayList<String> actual_error1 = new ArrayList<String>();

					actual_error1=ANU.Add_Employee(common_methods.driver, Sap_id, Prefix, Suffix, First_Name, Middle_Name, Last_Name, Preferred_Name, Badge_Number, Workforce_Manager, Functional_Manager,DOJ,Conifrmation_Status,Confirmation_Date,
						LOB, Client, SOW, Department, Designation, Office_Location, Seat_Number, 
							Fixed_Schedule_Name, Level, Employment_Status, Operation_Category, Effective_Date,logger);

					if(actual_error1.get(0).contains("×Success! Employee Created Successfully.")){

						ANU.Add_User_Details(common_methods.driver,User_id, User_Name,LDAP,Password,Active,logger);
					}

					else {
						gm.logFail(logger, "User Details cannot be saved as Empoloyee couldnt be created",common_methods.driver);
					}
				}
				catch(Exception e)
				{
					gm.logFail(logger, "Exception occured"+e,common_methods.driver);
				}
				reports.endTest(logger);
			}
		else if(Flag.equalsIgnoreCase("y") && Action.equals("Add User and Other Detials"))
			{
				try
			{
					ArrayList<String> actual_error1 = new ArrayList<String>();

					actual_error1=ANU.Add_Employee(common_methods.driver, Sap_id, Prefix, Suffix, First_Name, Middle_Name, Last_Name, Preferred_Name, Badge_Number, Workforce_Manager, Functional_Manager,DOJ,Conifrmation_Status,Confirmation_Date,
							LOB, Client, SOW, Department, Designation, Office_Location, Seat_Number, 
							Fixed_Schedule_Name, Level, Employment_Status, Operation_Category, Effective_Date,logger);

					if(actual_error1.get(0).contains("×Success! Employee Created Successfully."))
					{
						ANU.Add_User_Details(common_methods.driver,User_id, User_Name,LDAP,Password,Active,logger);

						ANU.Add_other_Details(common_methods.driver,ADP_ID, Enterprise_ID, Access_Type,logger);

					}
					else {
						gm.logFail(logger, "User Details cannot be saved as Empoloyee couldnt be created",common_methods.driver);
					}
				}

				catch(Exception e)
				{
					gm.logFail(logger, "Exception occured"+e,common_methods.driver);
				}
			}

			else if(Flag.equalsIgnoreCase("y") && Action.equals("Add User and Contact Detials"))
			{
				try

				{
					ArrayList<String> actual_error1 = new ArrayList<String>();

					actual_error1=ANU.Add_Employee(common_methods.driver, Sap_id, Prefix, Suffix, First_Name, Middle_Name, Last_Name, Preferred_Name, Badge_Number, Workforce_Manager, Functional_Manager,DOJ,Conifrmation_Status,Confirmation_Date,
							LOB, Client, SOW, Department, Designation, Office_Location, Seat_Number, 
							Fixed_Schedule_Name, Level, Employment_Status, Operation_Category, Effective_Date,logger);

					if(actual_error1.get(0).contains("×Success! Employee Created Successfully."))
					{
						ANU.Add_User_Details(common_methods.driver,User_id, User_Name,LDAP,Password,Active,logger);

					ANU.Add_Contact_Detail(common_methods.driver,Add_Email,Email_Type, Email_address,Add_Phone, Phone_Type, Country_code, Contact_no, Extension/* Address_Type, Address1, Address2, Location, City,
								/*State, Country, Zipcode*/,logger);
				}
				else {
					gm.logFail(logger, "User Details cannot be saved as Empoloyee couldnt be created",common_methods.driver);
				}
				}

				catch(Exception e)
				{
					gm.logFail(logger, "Exception occured"+e,common_methods.driver);
				}
			}
			else if(Flag.equalsIgnoreCase("y") && Action.equals("Add User and ContactInfo Detials"))
			{
				logger = reports.startTest(Scenario);
				try

				{
					ArrayList<String> actual_error1 = new ArrayList<String>();

					actual_error1=ANU.Add_Employee(common_methods.driver, Sap_id, Prefix, Suffix, First_Name, Middle_Name, Last_Name, Preferred_Name, Badge_Number, Workforce_Manager, Functional_Manager,DOJ,Conifrmation_Status,Confirmation_Date,
							LOB, Client, SOW, Department, Designation, Office_Location, Seat_Number, 
							Fixed_Schedule_Name, Level, Employment_Status, Operation_Category, Effective_Date,logger);

					if(actual_error1.get(0).contains("×Success! Employee Created Successfully."))
				{
						ANU.Add_User_Details(common_methods.driver,User_id, User_Name,LDAP,Password,Active,logger);

						ANU.Add_Contact_Detail(common_methods.driver,Add_Email,Email_Type, Email_address,Add_Phone, Phone_Type, Country_code, Contact_no, Extension,logger);
						ANU.Add_ContactInfo_Details(common_methods.driver,Add_Address,Address_Type, Address1,Address2,Location,City,State,Country,Zipcode,Add_Personal_Details, DOB,Marital_sts,Anniversary_date,logger);
				}
					else {
						gm.logFail(logger, "User Details cannot be saved as Empoloyee couldnt be created",common_methods.driver);
				}
				}

				catch(Exception e)
				{
					gm.logFail(logger, "Exception occured"+e,common_methods.driver);
				}
				reports.endTest(logger);
			}

			else if(Flag.equalsIgnoreCase("y") && Action.equals("Add User Detials"))
			{
				try {
					ANU.Add_User_Details(common_methods.driver,User_id, User_Name,LDAP,Password,Active,logger);
				}
			catch(Exception e)
				{
					gm.logFail(logger, "Exception occured"+e,common_methods.driver);
				}	
			}

			else if(Flag.equalsIgnoreCase("y") && Action.equals("Add Contact Detials"))
		{
				try {

					ANU.Add_Contact_Detail(common_methods.driver,Add_Email,Email_Type, Email_address,Add_Phone, Phone_Type, Country_code, Contact_no, Extension,logger);

			}
				catch(Exception e)
				{
					gm.logFail(logger, "Exception occured"+e,common_methods.driver);
				}	
			}
			else if(Flag.equalsIgnoreCase("y") && Action.equals("Add Contact Information Details"))
			{
				try {
					ANU.Add_ContactInfo_Details(common_methods.driver,Add_Address,Address_Type, Address1,Address2,Location,City,State,Country,Zipcode,Add_Personal_Details, DOB,Marital_sts,Anniversary_date,logger);
				}
				catch(Exception e)
				{
					gm.logFail(logger, "Exception occured"+e,common_methods.driver);
				}	
			}
			else if(Flag.equalsIgnoreCase("y") && Action.equals("Add Other Detials"))
			{
				try {
					ANU.Add_other_Details(common_methods.driver,ADP_ID, Enterprise_ID, Access_Type,logger);
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
	@DataProvider(name="Add_NEW_USER")
	public Object[][] getData()
	{
		Object[][] c1 = gm.getExcelData(EnvironmentVariables.dataPoolPath, "Add_New_User");
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
