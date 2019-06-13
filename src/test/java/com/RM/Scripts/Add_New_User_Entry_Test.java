package com.RM.Scripts;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.RM.Generic.GenericMethods2;
import com.RM.Generic.common_methods;
import com.RM.POM.Add_New_User_obj;

import com.relevantcodes.extentreports.ExtentTest;

public class Add_New_User_Entry_Test 
{
	static WebDriver driver ;

	GenericMethods2 gm = new GenericMethods2();
	common_methods cm = new common_methods();
	static String exp_err_msg="Error!Please select a value from: Client,Operation Category,Fixed Schedule Name,Office Location,Employment Status,Designation,Level,Department,Organization,Reporting Manager,Seat Number";
	public static ArrayList<String > actual=new ArrayList<String > ();
	static String Success_msg="Success! Employee Created Successfully.";
	ExtentTest logger; 


	//Go to Add New User Menu
	public  void Set_Up_Add_new_Employee(WebDriver driver, ExtentTest logger) throws Exception
	{
		try
		{
			//hover on Employee Management
			WebElement Employee_Management= driver.findElement(Add_New_User_obj.Employee_Information);
			Actions action = new Actions(driver);
			action.moveToElement(Employee_Management).build().perform();
			gm.logInfo(logger, "We have hovered on Employee Management Menu");

			// Click on Add New User
			WebElement Add_New_User=driver.findElement(Add_New_User_obj.Add_New_User);
			Add_New_User.click();
			gm.logInfo(logger, "We have clicked on Add New User Menu");
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			gm.logFail(logger, "Exception occured:"+ e.getMessage(),driver);
		}
	}

	//Mandatory Fields check
	public void mandatory_Fields_check(WebDriver driver, ExtentTest logger)
	{
		try
		{
			Thread.sleep(5000);
			WebElement element0 =
					driver.findElement(By.xpath(".//*[@id='btnSave']"));
			((JavascriptExecutor)
					driver).executeScript("arguments[0].scrollIntoView();", element0); 
			Thread.sleep(1000);

			WebElement Add_user_Save=driver.findElement(Add_New_User_obj.add_new_user_Save_btn);
			Add_user_Save.click();
			gm.logInfo(logger, "Clicked on Save");

			WebElement element =
					driver.findElement(By.xpath(".//*[@id='alertsection']/div[2]"));
			((JavascriptExecutor)
					driver).executeScript("arguments[0].scrollIntoView();", element); 
			Thread.sleep(1000);

			gm.logInfo(logger, "Screenshot for Warning message",driver);

			WebElement element2 =
					driver.findElement(By.xpath(".//*[@id='alertsection']/div[12]"));
			((JavascriptExecutor)
					driver).executeScript("arguments[0].scrollIntoView();", element2); 
			Thread.sleep(1000);

			gm.logInfo(logger, "Screenshot for Warning message",driver);

			ArrayList<String> expected_err = new ArrayList<String>();
			expected_err.add("×Error! Employee ID is not filled.");
			expected_err.add("×Error! First Name is not filled.");
			expected_err.add("×Error! Last Name is not filled.");
			expected_err.add("×Error! Badge number not filled.");
			expected_err.add("×Error! Please select a value from Department.");
			expected_err.add("×Error! Please select a value from Designation.");
			expected_err.add("×Error! Please select a value from LOB.");
			expected_err.add("×Error! Please select a value from Location.");
			expected_err.add("×Error! Please select a value from Employement Status.");
			expected_err.add("×Error! Please select a value from Operation Category.");
			expected_err.add("×Error! Please select a value from Client.");
			expected_err.add("×Error! Please select a value from SOW.");


			System.out.println(expected_err.size());
			System.out.println(expected_err);


			ArrayList<String> actual_error = new ArrayList<String>();

			for (int i = 1; i <= 12; i++) 
			{			
				actual_error.add(driver.findElement(By.xpath(".//*[@id='alertsection']/div["+i+"]")).getText());	
				//System.out.println(Login.driver.findElement(By.xpath(".//*[@id='MenuPanel']/span["+i+"]")).getText());
			}
			System.out.println(actual_error.size());
			System.out.println(actual_error);

			System.out.println("Total Error Message: "+actual_error.size());

			for(int j=0;j<expected_err.size();j++)
			{

				if(expected_err.get(j).contains(actual_error.get(j)))
				{
					System.out.println(" Exist : "+actual_error.get(j));
				}
				else
				{
					System.out.println("NOT Exist : "+actual_error.get(j));
				}
			}

		}
		catch(Exception e)
		{
			gm.logFail(logger, "Exception occured:"+e.getMessage(), driver);
		}
	}



	/*Employee Details tab*/
	//Enter Employee Details in Entry Screen
	public  ArrayList<String> Add_Employee(WebDriver driver,String Sap_id,String Prefix,String Suffix,String First_Name,
			String Middle_Name,String Last_Name,String Preferred_Name,String Badge_Number ,String Workforce_Manager,String Functional_Manager,String DOJ,String Confirmation_Status,String Confirmation_Date,
			String LOB,String Client,String SOW,String Department,String Designation,String Office_Location,String Seat_Number,String Fixed_Schedule_Name,String Level,String Employment_Status,
			String Operation_Category,String Effective_Date,ExtentTest logger) throws Exception 
	{
		ArrayList<String> actual_error1 = new ArrayList<String>();
		try
		{
			System.out.println(" Inside Add New user---> Employee Details tab");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			gm.logInfo(logger, "We are about to Enter Employee Details");

			//-------------------Enter Employee ID(SAP ID)-----------------------------------------//
			gm.enterText(driver, Add_New_User_obj.Employee_ID, Sap_id, "Sap_id", logger);
			gm.logInfo(logger, "Entered Employee ID");

			//-------------------Enter Prefix-----------------------------------------//
			gm.selectValueFromListByText(driver,  Add_New_User_obj.Prefix, Prefix, Prefix, logger);
			gm.logInfo(logger, "Prefix Selected");

			//-------------------Enter Suffix-----------------------------------------//
			gm.enterText(driver, Add_New_User_obj.Suffix, Suffix, "Suffix", logger);
			gm.logInfo(logger, "Entered Suffix");

			//-------------------Enter First Name-----------------------------------------//
			gm.enterText(driver, Add_New_User_obj.Fname, First_Name, "First_Name", logger);
			gm.logInfo(logger, "Entered First Name");


			//-------------------Enter Middle Name-----------------------------------------//
			gm.enterText(driver, Add_New_User_obj.Mname, Middle_Name, "Middle_Name", logger);
			gm.logInfo(logger, "Entered Middle Name");

			//-------------------Enter Last Name-----------------------------------------//
			gm.enterText(driver, Add_New_User_obj.Lname, Last_Name, "Last_Name", logger);
			gm.logInfo(logger, "Entered Last Name");

			//-------------------Enter Preferred Name-----------------------------------------//
			gm.enterText(driver, Add_New_User_obj.Preferred_Name, Preferred_Name, "Preferred_Name", logger);
			gm.logInfo(logger, "Entered Preferred Name");

			//-------------------Enter Badge Number-----------------------------------------//
			gm.enterText(driver, Add_New_User_obj.Badge_Number, Badge_Number, "Badge_Number", logger);
			gm.logInfo(logger, "Entered Badge Number");


			//-------------------Enter Work Force Manager-----------------------------------------//
			WebElement Workforce_manager= driver.findElement(Add_New_User_obj.Work_force_Manager_search_icon);
			Workforce_manager.click();
			gm.logInfo(logger, "Clicked On Work Force Manager Search Icon");
			Thread.sleep(1000);
			gm.enterText(driver,Add_New_User_obj.Eid_Work_force_Manager , Workforce_Manager, "Workforce_Manager", logger);
			gm.logInfo(logger, "Employee Id of the required user is entered: "+ Workforce_Manager);
			Thread.sleep(1000);
			WebElement Work_Force_Manager_srch_btn= driver.findElement(Add_New_User_obj.search_btn_Work_force_Manager);
			Work_Force_Manager_srch_btn.click();
			gm.logInfo(logger, "Clicked On WorkForce Manager Search Button");
			Thread.sleep(1000);	

			WebElement Search_Result_of_Workforce_manager= driver.findElement(Add_New_User_obj.Search_Result_of_Workforce_manager);
			Search_Result_of_Workforce_manager.click();
			gm.logInfo(logger, "Workforce Manager Selected");
			Thread.sleep(1000);


			//-------------------Enter Functional Manager-----------------------------------------//
			WebElement Functional_manager= driver.findElement(Add_New_User_obj.Functional_Manager_search_icon);
			Functional_manager.click();
			gm.logInfo(logger, "Clicked On Work Force Manager Search Icon");
			Thread.sleep(1000);

			gm.enterText(driver, Add_New_User_obj.Eid_Functional_Manager, Functional_Manager, "Functional_Manager", logger);
			gm.logInfo(logger, "Entered First Name of Functional Manager");
			Thread.sleep(1000);

			WebElement Functional_Manager_srch_btn= driver.findElement(Add_New_User_obj.search_btn_Functional_Manager);
			Functional_Manager_srch_btn.click();
			gm.logInfo(logger, "Clicked On Functional Manager Search Button");
			Thread.sleep(1000);

			WebElement Functional_Manager_srched_result= driver.findElement(Add_New_User_obj.Search_Result_of_Functional_manager);
			Functional_Manager_srched_result.click();
			gm.logInfo(logger, "Functional Manager Selected");
			Thread.sleep(1000);


			//-------------------Select DOJ-----------------------------------------//
			//Click on From date calendar
			WebElement selectDate = driver.findElement(Add_New_User_obj.Date_of_Joining);
			selectDate.click();
			gm.logInfo(logger, "We have clicked on DOJ date cleandar");
			Thread.sleep(2000);

			//Select DOJ date
			cm.ANTestDatePicker(DOJ);
			Thread.sleep(2000);

			//-------------------Confirmation status-----------------------------------------//

			if(Confirmation_Status.equalsIgnoreCase("Y"))
			{
				WebElement ConfirmationStatus= driver.findElement(Add_New_User_obj.Confirmation_Status);
				ConfirmationStatus.click();
				gm.logInfo(logger, "Clicked On Confirmation status check box");
				Thread.sleep(1000);

				WebElement Conf_Date = driver.findElement(Add_New_User_obj.Confirmation_Date);
				Conf_Date.click();
				gm.logInfo(logger, "We have clicked on DOJ date cleandar");
				Thread.sleep(2000);

				//Select confirmation date
				cm.ANTestDatePicker(Confirmation_Date);
				Thread.sleep(2000);

			}

			else {
				gm.logInfo(logger, "User confirmation status isn't selected,Confirmatin date not needed!");
			}

			//-------------------Enter LOB-----------------------------------------//
			WebElement LOB_srch= driver.findElement(Add_New_User_obj.LOB_search_icon);
			LOB_srch.click();
			gm.logInfo(logger, "Clicked On LOB Search Icon");
			Thread.sleep(2000);

			gm.enterText(driver, Add_New_User_obj.LOB_search_textbox, LOB, "LOB", logger);
			gm.logInfo(logger, "Entered LOB");

			WebElement LOB_srch_btn= driver.findElement(Add_New_User_obj.LOB_search_btn);
			LOB_srch_btn.click();
			gm.logInfo(logger, "Clicked On LOB Search Button");
			Thread.sleep(1000);

			//------------------check Entered text present  if yes then select or else display location is not present---------------//

			List<WebElement> LOB_Result=driver.findElements(Add_New_User_obj.LOB_search_result);
			System.out.println(LOB_Result);
			for (int i = 0; i <= LOB_Result.size(); i++) 
			{	
				WebElement linkElement=(driver.findElement(By.xpath(".//*[@id='organisationtreeview']/ul/li[text()='"+LOB+"']")));
				String emp_lob=linkElement.getText();
				if(emp_lob.equalsIgnoreCase(LOB))
				{
					linkElement.click();
					gm.logInfo(logger, "Searched LOB Selected");
					break;
				}	
				else
					gm.logInfo(logger, "LOB does not exist, Enter Correct LOB");
			}

			Thread.sleep(3000);
			//-------------------Enter Client-----------------------------------------//
			gm.selectValueFromListByText(driver,  Add_New_User_obj.Client, Client, Client, logger);
			gm.logInfo(logger, "Client Selected");


			//-------------------Enter SOW-----------------------------------------//
			gm.selectValueFromListByText(driver,  Add_New_User_obj.SOW, SOW, SOW, logger);
			gm.logInfo(logger, "SOW Selected");

			//-------------------Enter Department-----------------------------------------//
			gm.selectValueFromListByText(driver,  Add_New_User_obj.Department, Department, Department, logger);
			gm.logInfo(logger, "Department Selected");

			//-------------------Enter Designation-----------------------------------------//
			gm.selectValueFromListByText(driver,  Add_New_User_obj.Designation, Designation, Designation, logger);
			gm.logInfo(logger, "Designation Selected");

			//-------------------Enter Office Location-----------------------------------------//
			WebElement Ofc_location= driver.findElement(Add_New_User_obj.Office_Location_search_icon);
			Ofc_location.click();
			gm.logInfo(logger, "Clicked On Office Location Search Icon");
			Thread.sleep(2000);

			gm.enterText(driver, Add_New_User_obj.Office_Location_search_textbx,Office_Location,"Office_Location", logger);
			gm.logInfo(logger, "Entered Office Location");

			WebElement Ofc_location_srch_btn= driver.findElement(Add_New_User_obj.Office_Location_search_button);
			Ofc_location_srch_btn.click();
			gm.logInfo(logger, "Clicked On Office Location Search Button");
			Thread.sleep(1000);

			//------------------check Entered text present  if yes then select or else display location is not present---------------//

			List<WebElement> data=driver.findElements(Add_New_User_obj.Office_Location_search_result);
			System.out.println(data);
			for (int i = 0; i <= data.size(); i++) 
			{	
				WebElement linkElement=(driver.findElement(By.xpath(".//*[@id='locationtreeview']/ul/li[text()='"+Office_Location+"']")));
				String ofc_loc=linkElement.getText();
				if(ofc_loc.equalsIgnoreCase(Office_Location))
				{
					linkElement.click();
					gm.logInfo(logger, "Selected Office Location");
					break;
				}	
				else
					gm.logInfo(logger, "Location does not exist, Enter Correct Location");
			}

			//-------------------Enter Seat Number-----------------------------------------//
			WebElement Seat_No= driver.findElement(Add_New_User_obj.Seat_Number_search_icon);
			Seat_No.click();
			gm.logInfo(logger, "Clicked On Seat Number Search Icon");

			Thread.sleep(5000);

			gm.enterText(driver, Add_New_User_obj.Seat_Number_search_textbx, Seat_Number, "Seat_Number", logger);
			gm.logInfo(logger, "Entered Seat Number");

			WebElement Seat_Number_srch_btn= driver.findElement(Add_New_User_obj.Seat_Number_search_button);
			Seat_Number_srch_btn.click();
			gm.logInfo(logger, "Clicked On Seat Number Search Button");

			WebElement seat_srched= driver.findElement(Add_New_User_obj.Seat_Number_search_result);
			String seat=seat_srched.getText();

			if(Seat_Number.equalsIgnoreCase(seat))
			{
				seat_srched.click();
				gm.logInfo(logger, "Selected desired Seat No");
			}	
			else
				gm.logInfo(logger, "Seat Number not found");

			//-------------------Enter Fixed Schedule-----------------------------------------//
			gm.selectValueFromListByText(driver,  Add_New_User_obj.Fixed_Schedule_Name, Fixed_Schedule_Name, Fixed_Schedule_Name, logger);
			gm.logInfo(logger, "Fixed Schedule Selected");


			//-------------------Enter Level-----------------------------------------//
			gm.selectValueFromListByText(driver,  Add_New_User_obj.Level, Level, Level, logger);
			gm.logInfo(logger, "Level Selected");


			//-------------------Enter Employment Status-----------------------------------------//
			gm.selectValueFromListByText(driver,  Add_New_User_obj.Employment_Status, Employment_Status, Employment_Status, logger);
			gm.logInfo(logger, "Employement Status Selected");


			//-------------------Enter Operation Category-----------------------------------------//
			gm.selectValueFromListByText(driver,  Add_New_User_obj.Operation_Category, Operation_Category, Operation_Category, logger);
			gm.logInfo(logger, "Operation Category Selected");

			//-------------------Enter Effective Date-----------------------------------------//
			WebElement Eff_Date = driver.findElement(Add_New_User_obj.Effective_Date);
			Eff_Date.click();
			gm.logInfo(logger, "We have clicked on Effective date cleandar");

			//-------------------Enter Effective Date-----------------------------------------//
			cm.ANTestDatePicker(Effective_Date);
			Thread.sleep(2000);

			//-------------------Save Data--------------------------------------------------//
			WebElement Add_user_Save=driver.findElement(Add_New_User_obj.add_new_user_Save_btn);
			Add_user_Save.click();
			gm.logInfo(logger, "Clicked on Save");



			for (int i = 1; i <= 12; i++) 
			{
				if(driver.findElements(By.xpath(".//*[@id='alertsection']/div["+i+"]")).size() !=0)
				{
					actual_error1.add(driver.findElement(By.xpath(".//*[@id='alertsection']/div["+i+"]")).getText());
				}
			}

			System.out.println(actual_error1);
			System.out.println(actual_error1.size());

			//------------------------------Verifying all Validation messages-------------//
			for(int i = 0; i <=actual_error1.size(); i++)
			{
				if(actual_error1.get(i).contains("×Success! Employee Created Successfully."))
				{
					gm.logPass(logger, "Employee has been created succesfully",driver);
					break;
				}
				else if(actual_error1.get(i).contains("×Error! Employee ID is not filled."))
				{
					gm.logPass(logger, "Mandatory Field Employee ID is not filled",driver);	
				}
				else if(actual_error1.get(i).contains("×Error! First Name is not filled."))
				{
					gm.logPass(logger, "Mandatory Field First Name is not filled",driver);
				}
				else if(actual_error1.get(i).contains("×Error! Last Name is not filled."))
				{
					gm.logPass(logger, "Mandatory Field Last Name is not filled",driver);
				}
				else if(actual_error1.get(i).contains("×Error! Badge number not filled"))
				{
					gm.logPass(logger, "Mandatory Field Badge number is not filled",driver);
				}
				else if(actual_error1.get(i).contains("×Error! Please select a value from Department."))
				{
					gm.logPass(logger, "Mandatory Field Department is not filled",driver);
				}
				else if(actual_error1.get(i).contains("×Error! Please select a value from Designation."))
				{
					gm.logPass(logger, "Mandatory Field Designation is not filled",driver);
				}
				else if(actual_error1.get(i).contains("×Error! Please select a value from LOB."))
				{
					gm.logPass(logger, "Mandatory Field LOB is not filled",driver);
				}
				else if(actual_error1.get(i).contains("×Error! Please select a value from Location."))
				{
					gm.logPass(logger, "Mandatory Field Location is not filled",driver);
				}
				else if(actual_error1.get(i).contains("×Error! Please select a value from Operation Category."))
				{
					gm.logPass(logger, "Mandatory Field Operation Category is not filled",driver);
				}
				else if(actual_error1.get(i).contains("×Error! Please select a value from Client."))
				{
					gm.logPass(logger, "Mandatory Field Client is not filled",driver);
				}
				else if(actual_error1.get(i).contains("×Error! Please select a value from SOW."))
				{
					gm.logPass(logger, "Mandatory Field SOW is not filled",driver);
				}
				else if(actual_error1.get(i).contains("×Error! Seat is already in use."))
				{
					gm.logPass(logger, "Following seat selected is already being used by different user:" +Seat_Number,driver);
				}
				else if(actual_error1.get(i).contains("×Error! Employee ID can't be duplicated."))
				{
					gm.logPass(logger, "Following Employee ID is already being used by different user:" +Sap_id,driver);
				}

			}


		}
		catch(Exception e)
		{
			gm.logFail(logger, "Exception occured:"+e.getMessage(), driver);
		}
		return actual_error1;
	}

	/*User Details tab*/
	//Enter User Details in Entry Screen
	public  void Add_User_Details(WebDriver driver,String User_id,String User_Name,String LDAP,String Password,String Active,ExtentTest logger) throws Exception 
	{
		try
		{
			//Click on  User details tab
			WebElement User_details_tab=driver.findElement(Add_New_User_obj.User_Details_Tab);
			User_details_tab.click();
			gm.logInfo(logger, "Clicked on User Details Tab");

			//Enter User ID
			gm.enterText(driver, Add_New_User_obj.User_ID, User_id, "User_id", logger);
			gm.logInfo(logger, "Entered User ID");

			//Enter User Name
			gm.enterText(driver, Add_New_User_obj.User_Name, User_Name, "User_Name", logger);
			gm.logInfo(logger, "Entered User ID");


			//TO EDIT LDAP User and Password
			if(!LDAP.equals(""))
			{
				boolean checked = driver.findElement(By.id("LDAP")).isSelected();
				System.out.println(checked);

				if(LDAP.equalsIgnoreCase("N"))
				{
					if(checked==true)
					{
						//Uncheck IS LDAP User
						WebElement Is_LDAP_User=driver.findElement(Add_New_User_obj.Is_LDAP_User);
						Is_LDAP_User.click();
						gm.logInfo(logger, "Unchecked Is LDAP user check box");

						//Enter password Name
						if(!Password.equals(""))
						{
							gm.enterText(driver, Add_New_User_obj.Password, Password, "Password", logger);
						}
					}
					else if(checked==false)
					{
						gm.logInfo(logger, "LADP already unticked");
						if(!Password.equals(""))
						{
							gm.enterText(driver, Add_New_User_obj.Password, Password, "Password", logger);
						}
					}
				}

				else if(LDAP.equalsIgnoreCase("Y")){
					if(checked==true)
					{
						gm.logInfo(logger, "LDAP already ticked");
					}
					else if(checked==false) {
						WebElement Is_LDAP_User=driver.findElement(Add_New_User_obj.Is_LDAP_User);
						Is_LDAP_User.click();
						gm.logInfo(logger, "Checked Is LDAP user check box");
					}
				}
			}

			//Checking Active Status
			if(!Active.equals(""))
			{
				boolean checked2 = driver.findElement(By.id("active")).isSelected();
				System.out.println(checked2);

				if(Active.equalsIgnoreCase("Y"))
				{
					if(checked2==true)
					{
						gm.logInfo(logger, "User Active status is already checked");
					}
					else if(checked2==false)
					{
						WebElement Active2=driver.findElement(Add_New_User_obj.Active);
						Active2.click();
						gm.logInfo(logger, "Checking Active status to active");
					}
				}
				if(Active.equalsIgnoreCase("N"))
				{
					if(checked2==true)		
					{
						WebElement Active2=driver.findElement(Add_New_User_obj.Active);
						Active2.click();
						gm.logInfo(logger, "Checking active status to inactive");
					}
					else if(checked2==false)
					{
						gm.logInfo(logger, "User Active status is already checked");
					}
				}
			}
			if(driver.findElements(By.id("userdetailssave")).size()!=0)
			{
				//Click on Save
				WebElement User_Details_Save=driver.findElement(Add_New_User_obj.User_Details_Save);
				User_Details_Save.click();
				gm.logPass(logger, "Clicked on Save",driver);
			}
			else {
				gm.logFail(logger, "User has to save employee details before trying to save User details",driver);
			}
			ArrayList<String> Successmsg = new ArrayList<String>();
			for (int i = 1; i <= 3; i++) 
			{
				if(driver.findElements(By.xpath(".//*[@id='alertsection']/div["+i+"]")).size()!=0)
				{
					Successmsg.add(driver.findElement(By.xpath(".//*[@id='alertsection']/div["+i+"]")).getText());
				}
				else
				{
					break;
				}
			}

			System.out.println(Successmsg);
			System.out.println(Successmsg.size());

			// Check all the validations


			//------------------------------Verifying all Validation messages-------------//
			for(int i = 0; i <Successmsg.size(); i++)
			{
				if(Successmsg.get(i).contains("Success! Your data has been submitted successfully."))
				{
					gm.logPass(logger, "User is being notified that Data has been submitted successfully", driver);
					break;
				}
				else if(Successmsg.get(i).contains("Error! Please select User ID"))
				{
					gm.logPass(logger, "User is being notified that User ID isnt selcted", driver);
				}
				else if(Successmsg.get(i).contains("Error! Please select User Name"))
				{
					gm.logPass(logger, "User is being notified that User name isnt selcted", driver);

				}
				else if(Successmsg.get(i).contains("Error! Please select Password") && LDAP.equalsIgnoreCase("N"))
				{
					gm.logPass(logger, "User is notified that Password is not entered",driver);
				}
				else if(Successmsg.get(i).contains("×Error!User ID Already Exists"))
				{
					gm.logPass(logger, "User notified that the entered User ID already exists " +User_id, driver);
				}
				else {
					gm.logFail(logger, "User Details Edit Fail",driver);
				}
			}	

		}

		catch(Exception e)
		{
			gm.logFail(logger, "Exception occured:"+e.getMessage(), driver);
		}
	}


	/*Contact Details tab*/
	public  void Add_Contact_Detail(WebDriver driver,String Add_Email,String Email_Type,String Email_address,String Add_Phone,String Phone_Type,String Country_code,String Contact_no,String Extension, ExtentTest logger)
	{
		try
		{
			//Click on  Contact details tab
			WebElement contact_details_tab=driver.findElement(Add_New_User_obj.Contact_Details_Tab);
			contact_details_tab.click();
			gm.logInfo(logger, "Clicked on Contact Details Tab");


			//-------------------Email Details-----------------------------------------//

			if(Add_Email.equalsIgnoreCase("Y"))
			{
				//Click on Add button Email Details
				WebElement Email_Add_Button=driver.findElement(Add_New_User_obj.Email_Add_Button);
				Email_Add_Button.click();
				gm.logInfo(logger, "Clicked on Add Button of Email Details");

				//-------------------Select Email Type-----------------------------------------//
				gm.selectValueFromListByText(driver,  Add_New_User_obj.Email_Type, Email_Type, "Email_Type", logger);
				gm.logInfo(logger, "Email Type Selected");

				//Enter Email Address
				gm.enterText(driver, Add_New_User_obj.Email_Address, Email_address, "Email_address", logger);
				gm.logInfo(logger, "Entered Email ID");

				//Click on Save button of Email  Details
				WebElement Email_save_btn=driver.findElement(Add_New_User_obj.Email_save_btn);
				Email_save_btn.click();
				gm.logInfo(logger, "Saved Email details");
				Thread.sleep(1000);

				//Verify Email Error message			
				if(driver.findElements(By.xpath(".//*[@id='alertsectionAddEmailmanagaer']/div")).size()!=0)
				{
					// Check all the validations
					WebElement Successmsg= driver.findElement(Add_New_User_obj.Email_Msg);
					String SuccessLblMsg=Successmsg.getText();
					System.out.println(SuccessLblMsg);

					if(SuccessLblMsg.contains("Error! Kindly Enter Email Address!"))
					{
						gm.logPass(logger, "User is being notified that Email address is mandatory", driver);
					}
					else if(SuccessLblMsg.contains("Error! Kindly Enter Valid Email Address!"))
					{
						gm.logPass(logger, "User is being notified that Email Address is invalid", driver);
					}
					else if(SuccessLblMsg.contains("Error!Record lready exists for selected Email Type!"))
					{
						gm.logPass(logger, "User is being notified that Email type already in use", driver);

					}
					else {
						gm.logFail(logger, "Add Email Validation Message Fail", driver);
					}

					//Click on Add button Email Details
					WebElement Email_Close_btn=driver.findElement(Add_New_User_obj.Email_Close_btn);
					Email_Close_btn.click();
					gm.logInfo(logger, "Clicked on close button");	
				}
				else
				{
					gm.logPass(logger, "Email details has been saved successfully", driver);
				}			
			}
			else {
				gm.logPass(logger, "Email details has not been entered", driver);

			}

			if(Add_Phone.equalsIgnoreCase("Y"))
			{

				//Click on Add button Phone Details
				WebElement Phone_Add_Button=driver.findElement(Add_New_User_obj.Phone_Add_Button);
				Phone_Add_Button.click();
				gm.logInfo(logger, "Clicked on Add Button of Phone Details");

				//-------------------Select Phone Type-----------------------------------------//
				gm.selectValueFromListByText(driver,  Add_New_User_obj.Phone_type, Phone_Type, "Phone_Type", logger);
				gm.logInfo(logger, "Phone Type Selected");

				//Enter Country Code
				gm.enterText(driver, Add_New_User_obj.Country_code, Country_code, "Country_code", logger);
				gm.logInfo(logger, "Entered Country code");

				//Enter Contact Number
				gm.enterText(driver, Add_New_User_obj.Contact_number, Contact_no, "Contact_no", logger);
				gm.logInfo(logger, "Entered Contact Number");

				//Enter Extension
				gm.enterText(driver, Add_New_User_obj.Extension, Extension, "Extension", logger);
				gm.logInfo(logger, "Entered Extension");


				//Click on Save button of Phone  Details
				WebElement Phone_save_btn=driver.findElement(Add_New_User_obj.Phone_Details_Save);
				Phone_save_btn.click();
				gm.logInfo(logger, "Saved Phone details");
				Thread.sleep(1000);

				//Verify Phone Error message			
				if(driver.findElements(By.xpath(".//*[@id='alertsectionAddPHONEmanagaer']/div")).size()!=0)
				{
					// Check all the validations
					WebElement Successmsg= driver.findElement(Add_New_User_obj.Phone_Msg);
					String SuccessLblMsg=Successmsg.getText();
					System.out.println(SuccessLblMsg);

					if(SuccessLblMsg.contains("Error!Kindly Enter Country Code!"))
					{
						gm.logPass(logger, "User is being notified that Email address is mandatory", driver);
					}
					else if(SuccessLblMsg.contains("Error!Kindly Enter Contact Number!"))
					{
						gm.logPass(logger, "User is being notified that Email Address is invalid", driver);
					}
					else if(SuccessLblMsg.contains("Error!Record already exists for selected Phone Type!"))
					{
						gm.logPass(logger, "User is being notified that Email type already in use", driver);
					}
					else {
						gm.logFail(logger, "Add Phone Validation Message Fail", driver);
					}

					//Click on close Phone pop up
					WebElement Phone_Details_close=driver.findElement(Add_New_User_obj.Phone_Details_close);
					Phone_Details_close.click();
					gm.logInfo(logger, "Clicked on close button");	
				}
				else
				{
					gm.logPass(logger, "Phone details has been saved successfully", driver);
				}
			}

			else
			{
				gm.logPass(logger, "Phone deatils has not been entered", driver);
			}

			//Click on Contact Tab Save		
			if(driver.findElements(By.id("contactsave")).size()!=0)
			{
				WebElement contact_save=driver.findElement(Add_New_User_obj.contact_save);
				contact_save.click();
				gm.logInfo(logger, "Clicked on Contact details save button");	
			}
			else {
				gm.logFail(logger, "User has to save employee details before trying to save User details",driver);
			}

			//Verify Contact Tab message
			// Check all the validations
			WebElement Successmsg= driver.findElement(Add_New_User_obj.Cntact_Msg);
			String SuccessLblMsg=Successmsg.getText();
			System.out.println(SuccessLblMsg);

			if(SuccessLblMsg.contains("Error! Please enter Email Details."))
			{
				gm.logPass(logger, "User is being notified that Email Details is Mandatory", driver);
			}
			else if(SuccessLblMsg.contains("Error!Please fill User Details first!"))
			{
				gm.logPass(logger, "User is being notified that User details to be filled before entering email details", driver);
			}
			else if(SuccessLblMsg.contains("Success! Your data has been submitted successfully."))
			{
				gm.logPass(logger, "User is that contact tab has been saved successfully", driver);
			}
			else {
				gm.logFail(logger, "Contact Tab Add data fail", driver);
			}
		}

		catch(Exception e)
		{
			gm.logFail(logger, "Exception occured:"+e.getMessage(), driver);
		}

	}

	//Enter Contact Info
	public  void Add_ContactInfo_Details(WebDriver driver,String Add_Address,String Address_Type,String Address1,String Address2,String Location,String City,String State,String Country,String Zipcode,String Add_Personal_Details,String DOB,String Marital_sts,String Anniversary_date,ExtentTest logger ) throws Exception 
	{
		try
		{
			//Click on  Contact Information tab
			WebElement Contact_Information_Tab=driver.findElement(Add_New_User_obj.Contact_Information_Tab);
			Contact_Information_Tab.click();
			gm.logInfo(logger, "Clicked on Contact Information Tab");

			if(Add_Address.equalsIgnoreCase("Y"))
			{
				//-------------------Address Details-----------------------------------------//
				//Click on Add button Address Details
				WebElement Address_Add_Button=driver.findElement(Add_New_User_obj.Address_Add_Button);
				Address_Add_Button.click();
				gm.logInfo(logger, "Clicked on Add Button of Address Details");

				//-------------------Select Address Type-----------------------------------------//
				gm.selectValueFromListByText(driver,  Add_New_User_obj.Address_Type, Address_Type, "Address_Type", logger);
				gm.logInfo(logger, "Address Type Selected");

				//Enter Address1
				gm.enterText(driver, Add_New_User_obj.Address_1, Address1, "Address1", logger);
				gm.logInfo(logger, "Entered Address1");

				//Enter Address2
				gm.enterText(driver, Add_New_User_obj.Address_2, Address2, "Address2", logger);
				gm.logInfo(logger, "Entered Address2");

				//Enter Location
				gm.enterText(driver, Add_New_User_obj.Location, Location, "Location", logger);
				gm.logInfo(logger, "Entered Location");

				//Enter City
				gm.enterText(driver, Add_New_User_obj.City, City, "City", logger);
				gm.logInfo(logger, "Entered City");

				//Enter State
				gm.enterText(driver, Add_New_User_obj.State, State, "State", logger);
				gm.logInfo(logger, "Entered State");

				//Enter Country
				gm.enterText(driver, Add_New_User_obj.Country, Country, "Country", logger);
				gm.logInfo(logger, "Entered Country");

				//Enter Zipcode
				gm.enterText(driver, Add_New_User_obj.Zipcode, Zipcode, "Zipcode", logger);
				gm.logInfo(logger, "Entered Zipcode");


				//Click on Save button of Address Details
				WebElement Address_Save_btn=driver.findElement(Add_New_User_obj.Address_Save_btn);
				Address_Save_btn.click();
				gm.logInfo(logger, "Saved Address details");

				Thread.sleep(1000);

				//Verify Address Error message			
				if(driver.findElements(By.xpath(".//*[@id='alertsectionAddAddress']/div")).size()!=0)
				{
					// Check all the validations
					WebElement Successmsg= driver.findElement(Add_New_User_obj.Address_Msg);
					String SuccessLblMsg=Successmsg.getText();
					System.out.println(SuccessLblMsg);

					if(SuccessLblMsg.contains("Error! Kindly Enter Address 1!")||SuccessLblMsg.contains("Error! Kindly Enter Address 2!")||SuccessLblMsg.contains("Error! Kindly Enter Location!")
							||SuccessLblMsg.contains("Error! Kindly Enter City Name!")||SuccessLblMsg.contains("Error! Kindly Enter State Name!")||SuccessLblMsg.contains("Error! Kindly Enter Country Name!")
							||SuccessLblMsg.contains("Error! Kindly Enter ZIP Code!"))
					{
						gm.logPass(logger, "User is being notified that all fields are mandatory", driver);
					}

					else if(SuccessLblMsg.contains("Error!Address Type already exists. Please modify or delete your entry!"))
					{
						gm.logPass(logger, "User is being notified that Address type already in use", driver);
					}
					else {
						gm.logFail(logger, "Add Address Validation Message Fail", driver);
					}

					//Click on close Address
					WebElement Address_Close_btn=driver.findElement(Add_New_User_obj.Address_Close_btn);
					Address_Close_btn.click();
					gm.logInfo(logger, "Clicked on close button");	
				}
				else
				{
					gm.logPass(logger, "Address details has been saved successfully", driver);
				}		
			}

			else
			{
				gm.logPass(logger, "Address details hasnt added", driver);
			}


			if(Add_Personal_Details.equalsIgnoreCase("Y"))
			{
				//Enter Date of Birth
				WebElement Date_of_Birth=driver.findElement(Add_New_User_obj.Date_of_Birth);
				Date_of_Birth.clear();
				Date_of_Birth.sendKeys(DOB);
				gm.logPass(logger, "Entered Date of Birth",driver);

				//-------------------Select Address Type-----------------------------------------//
				gm.selectValueFromListByText(driver,  Add_New_User_obj.Marital_Status, Marital_sts, "Marital_sts", logger);
				gm.logPass(logger, "Marital status Type Selected",driver);
				
				if(Marital_sts.equalsIgnoreCase("Married"))
					
				{
					//Enter Anniversary Date
					WebElement Anniversary_Date=driver.findElement(Add_New_User_obj.Anniversary_Date);
					Anniversary_Date.clear();
					Anniversary_Date.sendKeys(Anniversary_date);
					gm.logPass(logger, "Entered Anniversary Date",driver);
				}
			}
			else {
				gm.logPass(logger, "Personal Details arent added",driver);
			}
			
			//Click on Contact Tab Save		
			if(driver.findElements(By.id("contactinfosave")).size()!=0)
			{
				WebElement contactinfo_save=driver.findElement(Add_New_User_obj.contactinfo_save);
				contactinfo_save.click();
				gm.logInfo(logger, "Clicked on Contact Information save button");	
			}
			else {
				gm.logFail(logger, "User has to save employee details before trying to save Contact Infor Details",driver);
			}
				
				//Verify Validation Message
				// Check all the validations
				WebElement Successmsg= driver.findElement(Add_New_User_obj.contactinfo_err_msg);
				String SuccessLblMsg=Successmsg.getText();
				System.out.println(SuccessLblMsg);

				if(SuccessLblMsg.contains("Error!Kindly Select Anniversary Date.")&& Marital_sts.equalsIgnoreCase("Married"))
				{
					gm.logPass(logger, "User is being notified that Anniversary date is Mandatory", driver);
				}
				else if(SuccessLblMsg.contains("Error!Please fill User Details first!"))
				{
					gm.logPass(logger, "User is being notified that User details to be filled before entering Contact Info details", driver);
				}
				else if(SuccessLblMsg.contains("Error! Anniversary Date can not be less then Date of Birth."))
				{
					gm.logPass(logger, "User is being notified that Anniversary date cannot be less than", driver);
				}
				else if(SuccessLblMsg.contains("Success! Your data has been submitted successfully."))
				{
					gm.logPass(logger, "User is that contact tab has been saved successfully", driver);
				}
				else {
					gm.logFail(logger, "Contact Tab Add data fail", driver);
				}
		}
		catch(Exception e)
		{
			gm.logFail(logger, "Exception occured:"+e.getMessage(), driver);
		}
	}



	/*Other Details tab*/
	public  void Add_other_Details(WebDriver driver,String ADP_ID,String Enterprise_ID,String Access_Type,ExtentTest logger) throws Exception 
	{
		try
		{
			//Click on  Other details tab
			WebElement Other_details_tab=driver.findElement(Add_New_User_obj.Other_Tab);
			Other_details_tab.click();
			gm.logInfo(logger, "Clicked on Other Details Tab");

			//Enter ADP ID
			gm.enterText(driver, Add_New_User_obj.ADP_ID, ADP_ID, "ADP_ID", logger);
			gm.logInfo(logger, "Entered ADP ID");

			//Enter Enterprise ID
			gm.enterText(driver, Add_New_User_obj.Enterprise_ID, Enterprise_ID, "Enterprise_ID", logger);
			gm.logInfo(logger, "Entered Enterprise ID");

			//Select Access Type
			WebElement Access_Type_drpdwn=driver.findElement(By.xpath(".//*[@id='otherdetails']/div[5]/div/div/div/span/div/button"));
			Access_Type_drpdwn.click();
			gm.logInfo(logger, "Opening Multi select drop down");
			Thread.sleep(1000);

			String Access_Types[] = Access_Type.split(",");
			int max=Access_Types.length;
			System.out.println(max);

			boolean checked3 = driver.findElement(By.xpath(".//*[@id='otherdetails']/div[5]/div/div/div/span/div/ul/li[1]/a/label/input")).isSelected();
			System.out.println(checked3);
			if(checked3==true)
			{
				WebElement Access_Type_abc=driver.findElement(Add_New_User_obj.Access_Type);
				Access_Type_abc.click();
				Thread.sleep(1000);
				gm.logInfo(logger, "Removed all selection");

			}
			else if(checked3==false) {
				WebElement Access_Type_abc=driver.findElement(Add_New_User_obj.Access_Type);	
				Access_Type_abc.click();
				Thread.sleep(1000);
				Access_Type_abc.click();
				gm.logInfo(logger, "Removed all selection");
			}

			//Code to select all access types separated by ","-------------------//
			for (int j=0; j<max; j++) 
			{
				System.out.println(Access_Types[j]);
				if(driver.findElements(By.xpath(".//*[@id='otherdetails']/div/div/div/div/span/div/ul/li/a/label[contains(text(),'"+Access_Types[j]+"')]/input")).size() !=0)
				{
					WebElement Required_Access_Type = driver.findElement(By.xpath(".//*[@id='otherdetails']/div/div/div/div/span/div/ul/li/a/label[contains(text(),'"+Access_Types[j]+"')]/input"));
					Required_Access_Type.click();
					Thread.sleep(1000);
					gm.logPass(logger, "Successfully selected the required Access type: "+Access_Types[j], driver);
				}
				else {
					gm.logFail(logger, "Following access type not found: "+Access_Types[j],driver);
				}
			}
			//Closing Multi-select drop down
			Access_Type_drpdwn.click();
			gm.logInfo(logger, "Closing Multi select drop down");
			Thread.sleep(1000);

			//Click on Save
			WebElement Other_details_save=driver.findElement(Add_New_User_obj.Other_details_save);
			Other_details_save.click();
			gm.logInfo(logger, "Clicked on Other Details Save Button");
			Thread.sleep(1000);

			//------------------------------Verifying all Validation messages-------------//
			ArrayList<String> Successmsg = new ArrayList<String>();
			for (int i = 1; i <= 3; i++) 
			{
				if(driver.findElements(By.xpath(".//*[@id='alertsection']/div["+i+"]")).size()!=0)
				{
					Successmsg.add(driver.findElement(By.xpath(".//*[@id='alertsection']/div["+i+"]")).getText());
				}
				else
				{
					break;
				}
			}

			System.out.println(Successmsg);
			System.out.println(Successmsg.size());


			//------------------------------Verifying all Validation messages-------------//
			for(int i = 0; i <Successmsg.size(); i++)
			{
				if(Successmsg.get(i).contains("Success! Your data has been submitted successfully."))
				{
					gm.logPass(logger, "User is being notified that Data has been submitted successfully", driver);
					break;
				}

				else if(Successmsg.get(i).contains("Error! Please select Alternate ID"))
				{
					gm.logPass(logger, "User is being notified that  Alternate ID isnt selcted", driver);
				}
				else if(Successmsg.get(i).contains("Error! Please select Enterprise ID"))
				{
					gm.logPass(logger, "User is being notified that Enterprise ID isnt selcted", driver);

				}	
				else
				{
					gm.logFail(logger, "Other details Add failed",driver);
				}
			}
		}
		catch(Exception e)
		{
			gm.logFail(logger, "Exception occured:"+e.getMessage(), driver);
		}
	}
}

