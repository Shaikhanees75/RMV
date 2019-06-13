package com.RM.Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.RM.Generic.GenericMethods2;
import com.RM.Generic.common_methods;
import com.RM.POM.Add_New_User_obj;
import com.RM.POM.Employee_Information_Obj;
import com.relevantcodes.extentreports.ExtentTest;

public class Employee_Information_Test {
	static WebDriver driver ;

	GenericMethods2 gm = new GenericMethods2();
	common_methods cm = new common_methods();
	static String exp_err_msg="Error!Please select a value from: Client,Operation Category,Fixed Schedule Name,Office Location,Employment Status,Designation,Level,Department,Organization,Reporting Manager,Seat Number";
	public static ArrayList<String > actual=new ArrayList<String > ();
	static String Success_msg="Success! Employee Created Successfully.";
	ExtentTest logger; 


	//Go to Employee Inforamtion
	public  void Set_Up_Employee_Inforamtion(WebDriver driver, ExtentTest logger) throws Exception
	{
		try
		{
			//hover on Employee Management
			WebElement Employee_Management= driver.findElement(Employee_Information_Obj.Employee_Management);
			Actions action = new Actions(driver);
			action.moveToElement(Employee_Management).build().perform();
			gm.logInfo(logger, "We have hovered on Employee Management Menu");

			// Click on Add New User
			WebElement Add_New_User=driver.findElement(Employee_Information_Obj.Employee_Information);
			Add_New_User.click();
			gm.logInfo(logger, "We have clicked on Employee Inforamtion Menu");
			Thread.sleep(12000);
		}
		catch(Exception e)
		{
			gm.logFail(logger, "Exception occured:"+e.getMessage(),driver);
		}
	}

	/*	//Mandatory Fields check
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

			WebElement Add_user_Save=driver.findElement(Employee_Information_Obj.Einfo_Save_btn);
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
			expected_err.add("Ã—Error! Employee ID is not filled.");
			expected_err.add("Ã—Error! First Name is not filled.");
			expected_err.add("Ã—Error! Last Name is not filled.");
			expected_err.add("Ã—Error! Badge number not filled.");
			expected_err.add("Ã—Error! Please select a value from Department.");
			expected_err.add("Ã—Error! Please select a value from Designation.");
			expected_err.add("Ã—Error! Please select a value from LOB.");
			expected_err.add("Ã—Error! Please select a value from Location.");
			expected_err.add("Ã—Error! Please select a value from Employement Status.");
			expected_err.add("Ã—Error! Please select a value from Operation Category.");
			expected_err.add("Ã—Error! Please select a value from Client.");
			expected_err.add("Ã—Error! Please select a value from SOW.");


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
	}*/


	public void Employee_Search(WebDriver driver,String Search_Sap_id,ExtentTest logger) throws Exception
	{

		try {

			//Click on employee Search pop up
			WebElement employee_search_btn=driver.findElement(Employee_Information_Obj.employee_search_btn);
			employee_search_btn.click();
			gm.logInfo(logger, "We have clicked on Employee search pop up");

			//Enter required employee ID
			gm.enterText(driver,Employee_Information_Obj.employee_id , Search_Sap_id, "Employee ID", logger);
			gm.logInfo(logger, "Employee Id of the required user is entered: "+ Search_Sap_id);

			//Click on Search button
			WebElement employee_search=driver.findElement(Employee_Information_Obj.employee_search);
			employee_search.click();
			gm.logInfo(logger, "We have clicked on Employee search");

			//Select the first employee
			WebElement employee_select=driver.findElement(Employee_Information_Obj.employee_select);
			String Searched_employee=employee_select.getText();
			System.out.println(Searched_employee);

			Thread.sleep(1000);

			if(Searched_employee.equalsIgnoreCase(Search_Sap_id))
			{
				//Select the first employee
				employee_select.click();
				gm.logInfo(logger, "We have selected the required employee");
				Thread.sleep(1000);

			}
			else {
				WebElement search_close=driver.findElement(Employee_Information_Obj.search_close);
				search_close.click();
				gm.logInfo(logger, "Clsoing search as employee not found.");
			}

			WebElement Employee_ID= driver.findElement(Employee_Information_Obj.Employee_ID);
			String Employee=Employee_ID.getAttribute("value");
			System.out.println(Employee);

			if(Employee.equalsIgnoreCase(Search_Sap_id))
			{
				gm.logPass(logger, "Required  Employee searched successfully", driver);
			}
			else
			{
				gm.logFail(logger, "Searched employee not found.", driver);
			}


		}
		catch(Exception e)
		{
			gm.logFail(logger, "Exception occured:"+e.getMessage(), driver);
		}

	}


	/*Employee Details tab*/
	//Enter Employee Details in Entry Screen
	public  void Edit_Employee(WebDriver driver,String Search_Sap_id,String Sap_id,String Prefix,String Suffix,String First_Name,
			String Middle_Name,String Last_Name,String Preferred_Name,String Badge_Number ,String Workforce_Manager,String Functional_Manager,String DOJ,String Confirmation_Status,String Confirmation_Date,
			String LOB,String Client,String SOW,String Department,String Designation,String Office_Location,String Seat_Number,String Fixed_Schedule_Name,String Level,String Employment_Status,
			String Operation_Category,String Effective_Date,ExtentTest logger) throws Exception 
	{

		try
		{

			System.out.println(" Inside Employee Information---> Employee Details tab");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			gm.logInfo(logger, "We are about to Enter Employee Details");

			//--------------------Verifying if its the right employee--------------//
			WebElement Employee_ID= driver.findElement(Employee_Information_Obj.Employee_ID);
			String Employee=Employee_ID.getAttribute("value");
			System.out.println(Employee);

			if(Employee.equalsIgnoreCase(Search_Sap_id))
			{
				gm.logPass(logger, "Employee details being displayed for the requied employee", driver);
				//-------------------Enter Employee ID(SAP ID)-----------------------------------------//
				if(!Sap_id.equals(""))
				{
					//Clear Existing Employee ID

					Employee_ID.clear();
					gm.enterText(driver, Employee_Information_Obj.Employee_ID, Sap_id, "Employee_ID", logger);

				}

				//-------------------Enter Prefix-----------------------------------------//
				if(!Prefix.equals(""))
				{	
					gm.selectValueFromListByText(driver,  Employee_Information_Obj.Prefix, Prefix, Prefix, logger);

				}

				//-------------------Enter Suffix-----------------------------------------//
				if(!Suffix.equals(""))
				{
					//Clear Existing Suffix
					WebElement Suffix_Clr= driver.findElement(Employee_Information_Obj.Suffix);
					Suffix_Clr.clear();

					gm.enterText(driver, Employee_Information_Obj.Suffix, Suffix, "Suffix", logger);

				}

				//-------------------Enter First Name-----------------------------------------//
				if(!First_Name.equals(""))
				{
					//Clear Existing First Name
					WebElement Fname= driver.findElement(Employee_Information_Obj.Fname);
					Fname.clear();


					gm.enterText(driver, Employee_Information_Obj.Fname, First_Name, "First_Name", logger);

				}

				//-------------------Enter Middle Name-----------------------------------------//
				if(!Middle_Name.equals(""))
				{
					//Clear Existing Middle Name
					WebElement Mname= driver.findElement(Employee_Information_Obj.Mname);
					Mname.clear();

					gm.enterText(driver, Employee_Information_Obj.Mname, Middle_Name, "Middle_Name", logger);
					gm.logInfo(logger, "Entered Middle Name");
				}

				//-------------------Enter Last Name-----------------------------------------//
				if(!Last_Name.equals(""))
				{
					//Clear Existing Last Name
					WebElement Lname= driver.findElement(Employee_Information_Obj.Lname);
					Lname.clear();

					gm.enterText(driver, Employee_Information_Obj.Lname, Last_Name, "Last_Name", logger);
					gm.logInfo(logger, "Entered Last Name");
				}


				//-------------------Enter Preferred Name-----------------------------------------//
				if(!Preferred_Name.equals(""))
				{
					//Clear Existing Preferred Name
					WebElement Preferred_Name_Clr= driver.findElement(Employee_Information_Obj.Preferred_Name);
					Preferred_Name_Clr.clear();

					gm.enterText(driver, Employee_Information_Obj.Preferred_Name, Preferred_Name, "Preferred_Name", logger);
					gm.logInfo(logger, "Entered Preferred Name");
				}

				//-------------------Enter Badge Number-----------------------------------------//
				if(!Badge_Number.equals(""))
				{
					//Clear Existing Badge Number
					WebElement Badge_Number_Clr= driver.findElement(Employee_Information_Obj.Badge_Number);
					Badge_Number_Clr.clear();

					gm.enterText(driver, Employee_Information_Obj.Badge_Number, Badge_Number, "Badge_Number", logger);
					gm.logInfo(logger, "Entered Badge Number");

				}



				//-------------------Enter Work Force Manager-----------------------------------------//
				if(!Workforce_Manager.equals(""))
				{
					WebElement Workforce_manager= driver.findElement(Employee_Information_Obj.Work_force_Manager_search_icon);
					Workforce_manager.click();
					gm.logInfo(logger, "Clicked On Work Force Manager Search Icon");
					Thread.sleep(500);
					gm.enterText(driver,Employee_Information_Obj.Eid_Work_force_Manager , Workforce_Manager, "Workforce_Manager", logger);
					gm.logInfo(logger, "Employee Id of the required user is entered: "+ Workforce_Manager);
					Thread.sleep(500);
					WebElement Work_Force_Manager_srch_btn= driver.findElement(Employee_Information_Obj.search_btn_Work_force_Manager);
					Work_Force_Manager_srch_btn.click();
					gm.logInfo(logger, "Clicked On WorkForce Manager Search Button");
					Thread.sleep(500);	

					WebElement Search_Result_of_Workforce_manager= driver.findElement(Employee_Information_Obj.Search_Result_of_Workforce_manager);
					Search_Result_of_Workforce_manager.click();
					gm.logInfo(logger, "Workforce Manager Selected");
					Thread.sleep(500);
				}
				else if(Workforce_Manager.equalsIgnoreCase("Null"))
				{
					WebElement Close_of_Workforce_manager= driver.findElement(Employee_Information_Obj.Close_of_Workforce_manager);
					Close_of_Workforce_manager.click();
					gm.logInfo(logger, "Cleared Existing Workforce Manager");
				}

				//-------------------Enter Functional Manager-----------------------------------------//
				if(!Functional_Manager.equals(""))
				{
					WebElement Functional_manager= driver.findElement(Employee_Information_Obj.Functional_Manager_search_icon);
					Functional_manager.click();
					gm.logInfo(logger, "Clicked On Work Force Manager Search Icon");
					Thread.sleep(500);

					gm.enterText(driver, Employee_Information_Obj.Eid_Functional_Manager, Functional_Manager, "Functional_Manager", logger);
					gm.logInfo(logger, "Entered First Name of Functional Manager");
					Thread.sleep(500);

					WebElement Functional_Manager_srch_btn= driver.findElement(Employee_Information_Obj.search_btn_Functional_Manager);
					Functional_Manager_srch_btn.click();
					gm.logInfo(logger, "Clicked On Functional Manager Search Button");
					Thread.sleep(500);

					WebElement Functional_Manager_srched_result= driver.findElement(Employee_Information_Obj.Search_Result_of_Functional_manager);
					Functional_Manager_srched_result.click();
					gm.logInfo(logger, "Functional Manager Selected");
					Thread.sleep(500);
				}

				else if(Functional_Manager.equalsIgnoreCase("Null"))
				{
					WebElement Clear_Functional_manager= driver.findElement(Employee_Information_Obj.Clear_Functional_manager);
					Clear_Functional_manager.click();
					gm.logInfo(logger, "Cleared Existing Functional Manager");
				}



				//-------------------Select DOJ-----------------------------------------//
				if(!DOJ.equals(""))
				{
					//Click on From date calendar
					WebElement selectDate = driver.findElement(Employee_Information_Obj.Date_of_Joining);
					selectDate.click();
					gm.logInfo(logger, "We have clicked on DOJ date cleandar");
					Thread.sleep(1000);

					//Select DOJ date
					cm.EITestDatePicker(DOJ);
					Thread.sleep(1000);
				}
				//-------------------Confirmation status-----------------------------------------//
				if(!Confirmation_Status.equals(""))
				{
					boolean checked = driver.findElement(By.id("confSts")).isSelected();
					if(Confirmation_Status.equalsIgnoreCase("Y"))
					{
						if(checked==true)
						{
							gm.logInfo(logger, "Confirmation status check box ticked");
						}
						else if(checked==false)
						{
							WebElement ConfirmationStatus= driver.findElement(Employee_Information_Obj.Confirmation_Status);
							ConfirmationStatus.click();
							gm.logInfo(logger, "Clicked On Confirmation status check box");
							Thread.sleep(1000);
						}
						if(!Confirmation_Date.equals(""))
						{
							WebElement Conf_Date = driver.findElement(Employee_Information_Obj.Confirmation_Date);
							Conf_Date.click();
							gm.logInfo(logger, "We have clicked on Confirmantion date cleandar");
							Thread.sleep(1000);

							//Select confirmation date
							cm.EITestDatePicker(Confirmation_Date);
							Thread.sleep(1000);
						}
					}
					else if(Confirmation_Status.equalsIgnoreCase("N"))
					{
						if(checked==true)
						{
							WebElement ConfirmationStatus= driver.findElement(Employee_Information_Obj.Confirmation_Status);
							ConfirmationStatus.click();
							gm.logInfo(logger, "Clicked On Confirmation status check box to uncheck");
							Thread.sleep(1000);

						}
						else if(checked==false)
						{
							gm.logInfo(logger, "Confirmation status check box already unchecked");
						}
					}	
				}

				//-------------------Enter LOB-----------------------------------------//
				if(!LOB.equals(""))
				{
					WebElement LOB_srch= driver.findElement(Employee_Information_Obj.LOB_search_icon);
					LOB_srch.click();
					gm.logInfo(logger, "Clicked On LOB Search Icon");

					gm.enterText(driver, Employee_Information_Obj.LOB_search_textbox, LOB, "LOB", logger);
					gm.logInfo(logger, "Entered LOB");

					WebElement LOB_srch_btn= driver.findElement(Employee_Information_Obj.LOB_search_btn);
					LOB_srch_btn.click();
					gm.logInfo(logger, "Clicked On LOB Search Button");

					//------------------check Entered text present  if yes then select or else display location is not present---------------//

					List<WebElement> LOB_Result=driver.findElements(Employee_Information_Obj.LOB_search_result);
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

					Thread.sleep(2000);
				}

				//-------------------Enter Client-----------------------------------------//
				if(!Client.equals(""))
				{
					gm.selectValueFromListByText(driver,  Employee_Information_Obj.Client, Client, Client, logger);

				}

				//-------------------Enter SOW-----------------------------------------//
				if(!SOW.equals(""))
				{
					gm.selectValueFromListByText(driver,  Employee_Information_Obj.SOW, SOW, SOW, logger);

				}

				//-------------------Enter Department-----------------------------------------//
				if(!Department.equals(""))
				{
					gm.selectValueFromListByText(driver,  Employee_Information_Obj.Department, Department, Department, logger);

				}
				//-------------------Enter Designation-----------------------------------------//
				if(!Designation.equals(""))
				{
					gm.selectValueFromListByText(driver,  Employee_Information_Obj.Designation, Designation, Designation, logger);

				}
				//-------------------Enter Office Location-----------------------------------------//
				if(!Office_Location.equals(""))
				{
					WebElement Ofc_location= driver.findElement(Employee_Information_Obj.Office_Location_search_icon);
					Ofc_location.click();
					gm.logInfo(logger, "Clicked On Office Location Search Icon");

					gm.enterText(driver, Employee_Information_Obj.Office_Location_search_textbx,Office_Location,"Office_Location", logger);


					WebElement Ofc_location_srch_btn= driver.findElement(Employee_Information_Obj.Office_Location_search_button);
					Ofc_location_srch_btn.click();
					gm.logInfo(logger, "Clicked On Office Location Search Button");

					//------------------check Entered text present  if yes then select or else display location is not present---------------//

					List<WebElement> data=driver.findElements(Employee_Information_Obj.Office_Location_search_result);
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

				}
				//-------------------Enter Seat Number-----------------------------------------//
				if(!Seat_Number.equals(""))
				{
					WebElement Seat_No= driver.findElement(Employee_Information_Obj.Seat_Number_search_icon);
					Seat_No.click();
					gm.logInfo(logger, "Clicked On Seat Number Search Icon");
					Thread.sleep(5000);

					gm.enterText(driver, Employee_Information_Obj.Seat_Number_search_textbx, Seat_Number, "Seat_Number", logger);


					WebElement Seat_Number_srch_btn= driver.findElement(Employee_Information_Obj.Seat_Number_search_button);
					Seat_Number_srch_btn.click();
					gm.logInfo(logger, "Clicked On Seat Number Search Button");

					WebElement seat_srched= driver.findElement(Employee_Information_Obj.Seat_Number_search_result);
					String seat=seat_srched.getText();

					if(Seat_Number.equalsIgnoreCase(seat))
					{
						seat_srched.click();
						gm.logInfo(logger, "Selected desired Seat No");
					}	
					else
						gm.logInfo(logger, "Seat Number not found");
				}

				else if(Seat_Number.equalsIgnoreCase("Null"))
				{
					WebElement Clear_Functional_manager= driver.findElement(Employee_Information_Obj.Clear_Functional_manager);
					Clear_Functional_manager.click();
					gm.logInfo(logger, "Cleared Existing Seat Number");
				}


				//-------------------Enter Fixed Schedule-----------------------------------------//
				if(!Fixed_Schedule_Name.equals(""))
				{
					gm.selectValueFromListByText(driver,  Employee_Information_Obj.Fixed_Schedule_Name, Fixed_Schedule_Name, Fixed_Schedule_Name, logger);
					gm.logInfo(logger, "Fixed Schedule Selected");
				}

				//-------------------Enter Level-----------------------------------------//
				if(!Level.equals(""))
				{
					gm.selectValueFromListByText(driver,  Employee_Information_Obj.Level, Level, Level, logger);
					gm.logInfo(logger, "Level Selected");
				}

				//-------------------Enter Employment Status-----------------------------------------//
				if(!Employment_Status.equals(""))
				{
					gm.selectValueFromListByText(driver,  Employee_Information_Obj.Employment_Status, Employment_Status, Employment_Status, logger);
					gm.logInfo(logger, "Employement Status Selected");

				}
				//-------------------Enter Operation Category-----------------------------------------//
				if(!Operation_Category.equals(""))
				{
					gm.selectValueFromListByText(driver,  Employee_Information_Obj.Operation_Category, Operation_Category, Operation_Category, logger);
					gm.logInfo(logger, "Operation Category Selected");
				}
				//-------------------Enter Effective Date-----------------------------------------//
				if(!Effective_Date.equals(""))
				{
					WebElement Eff_Date = driver.findElement(Employee_Information_Obj.Effective_Date);
					Eff_Date.click();
					gm.logInfo(logger, "We have clicked on Effective date cleandar");

					//-------------------Enter Effective Date-----------------------------------------//
					cm.EITestDatePicker(Effective_Date);
					Thread.sleep(1000);
				}

				//------------------------View History---------------------------------------------//
				WebElement viewHistoryEmployee= driver.findElement(Employee_Information_Obj.viewHistoryEmployee);
				viewHistoryEmployee.click();
				gm.logPass(logger, "History page for the searched employee", driver);

				WebElement viewHistoryClose= driver.findElement(Employee_Information_Obj.viewHistoryClose);
				viewHistoryClose.click();

				//-------------------Save Data--------------------------------------------------//
				WebElement Add_user_Save=driver.findElement(Employee_Information_Obj.Einfo_Save_btn);
				Add_user_Save.click();
				gm.logInfo(logger, "Clicked on Save");


				ArrayList<String> actual_error1 = new ArrayList<String>();
				for (int i = 1; i <= 12; i++) 
				{
					if(driver.findElements(By.xpath(".//*[@id='alertsectionEM']/div["+i+"]")).size()!=0)
					{
						actual_error1.add(driver.findElement(By.xpath(".//*[@id='alertsectionEM']/div["+i+"]")).getText());
					}
					else
					{
						break;
					}
				}

				System.out.println(actual_error1);
				System.out.println(actual_error1.size());

				//------------------------------Verifying all Validation messages-------------//
				for(int i = 0; i <actual_error1.size(); i++)
				{
					if(actual_error1.get(i).contains("Ã—Success! Your data has been submitted successfully."))
					{
						gm.logPass(logger, "Employee Deatils have been edited succesfully",driver);
						break;
					}
					else if(actual_error1.get(i).contains("Ã—Error! Employee ID is not filled."))
					{
						gm.logPass(logger, "Mandatory Field Employee ID is not filled",driver);	
					}
					else if(actual_error1.get(i).contains("Ã—Error! First Name is not filled."))
					{
						gm.logPass(logger, "Mandatory Field First Name is not filled",driver);
					}
					else if(actual_error1.get(i).contains("Ã—Error! Last Name is not filled."))
					{
						gm.logPass(logger, "Mandatory Field Last Name is not filled",driver);
					}
					else if(actual_error1.get(i).contains("Ã—Error! Badge number not filled"))
					{
						gm.logPass(logger, "Mandatory Field Badge number is not filled",driver);
					}
					else if(actual_error1.get(i).contains("Ã—Error! Please select a value from Department."))
					{
						gm.logPass(logger, "Mandatory Field Department is not filled",driver);
					}
					else if(actual_error1.get(i).contains("Ã—Error! Please select a value from Designation."))
					{
						gm.logPass(logger, "Mandatory Field Designation is not filled",driver);
					}
					else if(actual_error1.get(i).contains("Ã—Error! Please select a value from LOB."))
					{
						gm.logPass(logger, "Mandatory Field LOB is not filled",driver);
					}
					else if(actual_error1.get(i).contains("Ã—Error! Please select a value from Location."))
					{
						gm.logPass(logger, "Mandatory Field Location is not filled",driver);
					}
					else if(actual_error1.get(i).contains("Ã—Error! Please select a value from Operation Category."))
					{
						gm.logPass(logger, "Mandatory Field Operation Category is not filled",driver);
					}
					else if(actual_error1.get(i).contains("Ã—Error! Please select a value from Client."))
					{
						gm.logPass(logger, "Mandatory Field Client is not filled",driver);
					}
					else if(actual_error1.get(i).contains("Ã—Error! Please select a value from SOW."))
					{
						gm.logPass(logger, "Mandatory Field SOW is not filled",driver);
					}
					else if(actual_error1.get(i).contains("Ã—Error! Seat is already in use."))
					{
						gm.logPass(logger, "Following seat selected is already being used by different user:" +Seat_Number,driver);
					}
					else if(actual_error1.get(i).contains("Ã—Error! Employee ID can't be duplicated."))
					{
						gm.logPass(logger, "Following Employee ID is already being used by different user:" +Sap_id,driver);
					}

				}
			}

			else {
				gm.logFail(logger, "Employee details displayed is not for the required employee", driver);
			}
		}
		catch(Exception e)
		{
			gm.logFail(logger, "Exception occured:"+e.getMessage(), driver);
		}

	}

	/*User Details tab*/
	//Enter User Details in Entry Screen
	public void Edit_User_Details(WebDriver driver,String Search_Sap_id,String User_id,String User_Name,String LDAP,String Password,String Active, ExtentTest logger) throws Exception 
	{
		try
		{
			//--------------------Verifying if its the right employee--------------//
			WebElement Employee_ID= driver.findElement(Employee_Information_Obj.Employee_ID);
			String Employee=Employee_ID.getAttribute("value");
			System.out.println(Employee);

			if(Employee.equalsIgnoreCase(Search_Sap_id))
			{
				gm.logPass(logger, "Employee details being displayed for the requied employee", driver);

				//Click on  User details tab
				WebElement User_details_tab=driver.findElement(Employee_Information_Obj.User_Details_Tab);
				User_details_tab.click();
				gm.logInfo(logger, "Clicked on User Details Tab");
				Thread.sleep(1000);

				if(!User_id.equals(""))
				{
					//Enter User ID
					gm.enterText(driver, Add_New_User_obj.User_ID, User_id, "User_id", logger);
				}

				//Enter User Name
				if(!User_Name.equals(""))
				{
					gm.enterText(driver, Employee_Information_Obj.User_Name, User_Name, "User_Name", logger);
				}


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
							WebElement Is_LDAP_User=driver.findElement(Employee_Information_Obj.Is_LDAP_User);
							Is_LDAP_User.click();
							gm.logInfo(logger, "Unchecked Is LDAP user check box");

							//Enter password Name
							if(!Password.equals(""))
							{
								gm.enterText(driver, Employee_Information_Obj.Password, Password, "Password", logger);
							}
						}
						else if(checked==false)
						{
							gm.logInfo(logger, "LADP already unticked");
							if(!Password.equals(""))
							{
								gm.enterText(driver, Employee_Information_Obj.Password, Password, "Password", logger);
							}
						}
					}

					else if(LDAP.equalsIgnoreCase("Y")){
						if(checked==true)
						{
							gm.logInfo(logger, "LDAP already ticked");
						}
						else if(checked==false) {
							WebElement Is_LDAP_User=driver.findElement(Employee_Information_Obj.Is_LDAP_User);
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
							WebElement Active2=driver.findElement(Employee_Information_Obj.Active);
							Active2.click();
							gm.logInfo(logger, "Checking Active status to active");
						}
					}
					if(Active.equalsIgnoreCase("N"))
					{
						if(checked2==true)		
						{
							WebElement Active2=driver.findElement(Employee_Information_Obj.Active);
							Active2.click();
							gm.logInfo(logger, "Checking active status to inactive");
						}
						else if(checked2==false)
						{
							gm.logInfo(logger, "User Active status is already checked");
						}
					}
				}
				//Click on Save
				WebElement User_Details_Save=driver.findElement(Employee_Information_Obj.User_Details_Save);
				User_Details_Save.click();
				gm.logPass(logger, "Clicked on Save",driver);

				ArrayList<String> Successmsg = new ArrayList<String>();
				for (int i = 1; i <= 3; i++) 
				{
					if(driver.findElements(By.xpath(".//*[@id='alertsectionEM']/div["+i+"]")).size()!=0)
					{
						Successmsg.add(driver.findElement(By.xpath(".//*[@id='alertsectionEM']/div["+i+"]")).getText());
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
					else if(Successmsg.get(i).contains("Ã—Error!This user id already mapped to"))
					{
						gm.logPass(logger, "User notified that the entered User ID already exists " +User_id, driver);
					}
					else {
						gm.logFail(logger, "User Details Edit Fail",driver);
					}
				}
			}

			else {
				gm.logFail(logger, "Employee details not match the requied employee", driver);
			}
		}
		catch(Exception e)
		{
			gm.logFail(logger, "Exception occured:"+e.getMessage(), driver);
		}
	}

	/*Contact Details tab*/
	//Enter Email Details in Entry Screen
	public  void Edit_Contact_Details(WebDriver driver,String Email_Type,String Email_address,
			String Phone_Type,String Country_code,String Contact_no,String Extension,
			String Address_Type,String Address1,String Address2,String Location,String City,String State,String Country,String Zipcode,ExtentTest logger ) throws Exception 
	{
		try
		{
			//Click on  Contact details tab
			WebElement contact_details_tab=driver.findElement(Employee_Information_Obj.Contact_Details_Tab);
			contact_details_tab.click();
			gm.logInfo(logger, "Clicked on Contact Details Tab");


			//-------------------Email Details-----------------------------------------//

			//Click on Add button Email Details
			WebElement Email_Add_Button=driver.findElement(Employee_Information_Obj.Email_Add_Button);
			Email_Add_Button.click();
			gm.logInfo(logger, "Clicked on Add Button of Email Details");

			//-------------------Select Email Type-----------------------------------------//
			gm.selectValueFromListByText(driver,  Employee_Information_Obj.Email_Type, Email_Type, "Email_Type", logger);
			gm.logInfo(logger, "Email Type Selected");

			//Enter Email Address
			gm.enterText(driver, Employee_Information_Obj.Email_Address, Email_address, "Email_address", logger);
			gm.logInfo(logger, "Entered Email ID");

			//Click on Save button of Email  Details
			WebElement Email_save_btn=driver.findElement(Employee_Information_Obj.Email_save_btn);
			Email_save_btn.click();
			gm.logInfo(logger, "Saved Email details");	

			//-------------------Phone Details-----------------------------------------//

			//Click on Add button Phone Details
			WebElement Phone_Add_Button=driver.findElement(Employee_Information_Obj.Phone_Add_Button);
			Phone_Add_Button.click();
			gm.logInfo(logger, "Clicked on Add Button of Phone Details");

			//-------------------Select Phone Type-----------------------------------------//
			gm.selectValueFromListByText(driver,  Employee_Information_Obj.Phone_type, Phone_Type, "Phone_Type", logger);
			gm.logInfo(logger, "Phone Type Selected");

			//Enter Country Code
			gm.enterText(driver, Employee_Information_Obj.Country_code, Country_code, "Country_code", logger);
			gm.logInfo(logger, "Entered Country code");

			//Enter Contact Number
			gm.enterText(driver, Employee_Information_Obj.Contact_number, Contact_no, "Contact_no", logger);
			gm.logInfo(logger, "Entered Contact Number");

			//Enter Extension
			gm.enterText(driver, Employee_Information_Obj.Extension, Extension, "Extension", logger);
			gm.logInfo(logger, "Entered Extension");


			//Click on Save button of Phone  Details
			WebElement Phone_save_btn=driver.findElement(Employee_Information_Obj.Phone_Details_Save);
			Phone_save_btn.click();
			gm.logInfo(logger, "Saved Phone details");

			//-------------------Address Details-----------------------------------------//
			//Click on Add button Address Details
			WebElement Address_Add_Button=driver.findElement(Employee_Information_Obj.Address_Add_Button);
			Address_Add_Button.click();
			gm.logInfo(logger, "Clicked on Add Button of Address Details");

			//-------------------Select Address Type-----------------------------------------//
			gm.selectValueFromListByText(driver,  Employee_Information_Obj.Address_Type, Phone_Type, "Phone_Type", logger);
			gm.logInfo(logger, "Address Type Selected");

			//Enter Address1
			gm.enterText(driver, Employee_Information_Obj.Address_1, Address1, "Address1", logger);
			gm.logInfo(logger, "Entered Address1");

			//Enter Address2
			gm.enterText(driver, Employee_Information_Obj.Address_2, Address2, "Address2", logger);
			gm.logInfo(logger, "Entered Address2");

			//Enter Location
			gm.enterText(driver, Employee_Information_Obj.Location, Location, "Location", logger);
			gm.logInfo(logger, "Entered Location");

			//Enter City
			gm.enterText(driver, Employee_Information_Obj.City, City, "City", logger);
			gm.logInfo(logger, "Entered City");

			//Enter State
			gm.enterText(driver, Employee_Information_Obj.State, State, "State", logger);
			gm.logInfo(logger, "Entered State");

			//Enter Country
			gm.enterText(driver, Employee_Information_Obj.Country, Country, "Country", logger);
			gm.logInfo(logger, "Entered Country");

			//Enter Zipcode
			gm.enterText(driver, Employee_Information_Obj.Zipcode, Zipcode, "Zipcode", logger);
			gm.logInfo(logger, "Entered Zipcode");


			//Click on Save button of Phone  Details
			WebElement Address_Save_btn=driver.findElement(Employee_Information_Obj.Address_Save_btn);
			Address_Save_btn.click();
			gm.logInfo(logger, "Saved Address details");


			//Enter Date of Birth
			WebElement Date_of_Birth=driver.findElement(Employee_Information_Obj.Date_of_Birth);
			Date_of_Birth.sendKeys("08-28-1995");
			gm.logInfo(logger, "Entered Date of Birth");


			/*Main Save Button*/
			//Click on Save button of Main Screen
			WebElement contact_save=driver.findElement(Employee_Information_Obj.contact_save);
			contact_save.click();
			gm.logInfo(logger, "Saved All Contact details");

		}
		catch(Exception e)
		{
			gm.logFail(logger, "Exception occured:"+e.getMessage(), driver);
		}
	}



	/*Other Details tab*/
	//Enter Other Details in Entry Screen
	public  void Edit_other_Details(WebDriver driver,String Search_Sap_id,String ADP_ID,String Enterprise_ID,String Access_Type,ExtentTest logger) throws Exception 
	{
		try
		{

			//--------------------Verifying if its the right employee--------------//
			WebElement Employee_ID= driver.findElement(Employee_Information_Obj.Employee_ID);
			String Employee=Employee_ID.getAttribute("value");
			System.out.println(Employee);

			if(Employee.equalsIgnoreCase(Search_Sap_id))
			{
				gm.logPass(logger, "Employee details being displayed for the requied employee", driver);
				//Click on  Other details tab
				WebElement Other_details_tab=driver.findElement(Employee_Information_Obj.Other_Tab);
				Other_details_tab.click();
				gm.logInfo(logger, "Clicked on Other Details Tab");


				//Enter ADP ID
				if(!ADP_ID.equals(""))
				{
					//Clear Existing ADP_ID 
					WebElement ADP_ID_Clr= driver.findElement(Employee_Information_Obj.ADP_ID);
					ADP_ID_Clr.clear();

					gm.enterText(driver, Employee_Information_Obj.ADP_ID, ADP_ID, "ADP_ID", logger);

				}


				//Enter Enterprise ID
				if(!Enterprise_ID.equals(""))
				{	
					//Clear Existing ADP_ID 
					WebElement Enterprise_ID_Clr= driver.findElement(Employee_Information_Obj.Enterprise_ID);
					Enterprise_ID_Clr.clear();

					gm.enterText(driver, Employee_Information_Obj.Enterprise_ID, Enterprise_ID, "Enterprise_ID", logger);

				}

				if(!Access_Type.equals(""))
				{
					//Select Access Type
					WebElement Access_Type_drpdwn=driver.findElement(By.xpath(".//*[@id='otherdetails']/div[4]/div/div/div/span/div/button"));
					Access_Type_drpdwn.click();
					gm.logInfo(logger, "Opening Multi select drop down");
					Thread.sleep(1000);

					String Access_Types[] = Access_Type.split(",");
					int max=Access_Types.length;
					System.out.println(max);

					boolean checked3 = driver.findElement(By.xpath(".//*[@id='otherdetails']/div[4]/div/div/div/span/div/ul/li[1]/a/label/input")).isSelected();
					System.out.println(checked3);
					if(checked3==true)
					{
						WebElement Access_Type_abc=driver.findElement(Employee_Information_Obj.Access_Type);
						Access_Type_abc.click();
						Thread.sleep(1000);
						gm.logInfo(logger, "Removed all selection");

					}
					else if(checked3==false) {
						WebElement Access_Type_abc=driver.findElement(Employee_Information_Obj.Access_Type);	
						Access_Type_abc.click();
						Thread.sleep(1000);
						Access_Type_abc.click();
						gm.logInfo(logger, "Removed all selection");
					}

					//Code to select all access types separated by ","-------------------//
					for (int j=0; j<max; j++) 
					{
						System.out.println(Access_Types[j]);
						if(driver.findElements(By.xpath(".//*[@id='otherdetails']/div[4]/div/div/div/span/div/ul/li/a/label[contains(text(),'"+Access_Types[j]+"')]/input")).size() !=0)
						{
							WebElement Required_Access_Type = driver.findElement(By.xpath(".//*[@id='otherdetails']/div[4]/div/div/div/span/div/ul/li/a/label[contains(text(),'"+Access_Types[j]+"')]/input"));
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
				}

				//Click on Save
				WebElement Other_details_save=driver.findElement(Employee_Information_Obj.Other_details_save);
				Other_details_save.click();
				gm.logInfo(logger, "Clicked on Other Details Save Button");
				Thread.sleep(1000);

				//------------------------------Verifying all Validation messages-------------//
				ArrayList<String> Successmsg = new ArrayList<String>();
				for (int i = 1; i <= 3; i++) 
				{
					if(driver.findElements(By.xpath(".//*[@id='alertsectionEM']/div["+i+"]")).size()!=0)
					{
						Successmsg.add(driver.findElement(By.xpath(".//*[@id='alertsectionEM']/div["+i+"]")).getText());
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
						gm.logPass(logger, "User is being notified that Alternate ID isnt selcted", driver);
					}
					else if(Successmsg.get(i).contains("Error! Please select Enterprise ID"))
					{
						gm.logPass(logger, "User is being notified that Enterprise ID isnt selcted", driver);
					}	
					else
					{
						gm.logFail(logger, "Other details update failed",driver);
					}
				}
			}
			else
			{
				gm.logFail(logger, "Employee Details displayed isnt for the required employee", driver);
			}

		}
		catch(Exception e)
		{
			gm.logFail(logger, "Exception occured:"+e.getMessage(), driver);
		}
	}


	/*Contact Details tab*/
	public  void Edit_Contact_Details(WebDriver driver,String Search_Sap_id,String Add_Email,String Email_Type,String Email_address,String Add_Phone,String Phone_Type,String Country_code,String Contact_no,String Extension, ExtentTest logger)
	{
		try
		{
			//--------------------Verifying if its the right employee--------------//
			WebElement Employee_ID= driver.findElement(Employee_Information_Obj.Employee_ID);
			String Employee=Employee_ID.getAttribute("value");
			System.out.println(Employee);

			if(Employee.equalsIgnoreCase(Search_Sap_id))
			{
				gm.logPass(logger, "Employee details being displayed for the requied employee", driver);
				//Click on  Contact details tab
				WebElement contact_details_tab=driver.findElement(Employee_Information_Obj.Contact_Details_Tab);
				contact_details_tab.click();
				gm.logInfo(logger, "Clicked on Contact Details Tab");


				//-------------------Email Details-----------------------------------------//

				if(Add_Email.equalsIgnoreCase("Y"))
				{
					//Click on Add button Email Details
					WebElement Email_Add_Button=driver.findElement(Employee_Information_Obj.Email_Add_Button);
					Email_Add_Button.click();
					gm.logInfo(logger, "Clicked on Add Button of Email Details");

					//-------------------Select Email Type-----------------------------------------//
					gm.selectValueFromListByText(driver,  Employee_Information_Obj.Email_Type, Email_Type, "Email_Type", logger);
					gm.logInfo(logger, "Email Type Selected");

					//Enter Email Address
					gm.enterText(driver, Employee_Information_Obj.Email_Address, Email_address, "Email_address", logger);
					gm.logInfo(logger, "Entered Email ID");

					//Click on Save button of Email  Details
					WebElement Email_save_btn=driver.findElement(Employee_Information_Obj.Email_save_btn);
					Email_save_btn.click();
					gm.logInfo(logger, "Saved Email details");
					Thread.sleep(1000);

					//Verify Email Error message			
					if(driver.findElements(By.xpath(".//*[@id='alertsectionAddEmailmanagaer']/div")).size()!=0)
					{
						// Check all the validations
						WebElement Successmsg= driver.findElement(Employee_Information_Obj.Email_Msg);
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
						else if(SuccessLblMsg.contains("Error!Record already exists for selected Email Type!"))
						{
							gm.logPass(logger, "User is being notified that Email type already in use", driver);

						}
						else {
							gm.logFail(logger, "Add Email Validation Message Fail", driver);
						}

						//Click on Add button Email Details
						WebElement Email_Close_btn=driver.findElement(Employee_Information_Obj.Email_Close_btn);
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
					WebElement Phone_Add_Button=driver.findElement(Employee_Information_Obj.Phone_Add_Button);
					Phone_Add_Button.click();
					gm.logInfo(logger, "Clicked on Add Button of Phone Details");

					//-------------------Select Phone Type-----------------------------------------//
					gm.selectValueFromListByText(driver,  Employee_Information_Obj.Phone_type, Phone_Type, "Phone_Type", logger);
					gm.logInfo(logger, "Phone Type Selected");

					//Enter Country Code
					gm.enterText(driver, Employee_Information_Obj.Country_code, Country_code, "Country_code", logger);
					gm.logInfo(logger, "Entered Country code");

					//Enter Contact Number
					gm.enterText(driver, Employee_Information_Obj.Contact_number, Contact_no, "Contact_no", logger);
					gm.logInfo(logger, "Entered Contact Number");

					//Enter Extension
					gm.enterText(driver, Employee_Information_Obj.Extension, Extension, "Extension", logger);
					gm.logInfo(logger, "Entered Extension");


					//Click on Save button of Phone  Details
					WebElement Phone_save_btn=driver.findElement(Employee_Information_Obj.Phone_Details_Save);
					Phone_save_btn.click();
					gm.logInfo(logger, "Saved Phone details");
					Thread.sleep(1000);

					//Verify Phone Error message			
					if(driver.findElements(By.xpath(".//*[@id='alertsectionAddPHONEmanagaer']/div")).size()!=0)
					{
						// Check all the validations
						WebElement Successmsg= driver.findElement(Employee_Information_Obj.Phone_Msg);
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
						WebElement Phone_Details_close=driver.findElement(Employee_Information_Obj.Phone_Details_close);
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

				//Click on Save
				WebElement contact_save=driver.findElement(Employee_Information_Obj.contact_save);
				contact_save.click();
				gm.logInfo(logger, "Clicked on Contact details save button");	


				//Verify Contact Tab message
				// Check all the validations
				WebElement Successmsg= driver.findElement(Employee_Information_Obj.Cntact_Msg);
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
			else
			{
				gm.logFail(logger, "Employee Details displayed isnt for the required employee", driver);
			}
		}

		catch(Exception e)
		{
			gm.logFail(logger, "Exception occured:"+e.getMessage(), driver);
		}

	}


	//Enter Contact Info
	public  void Edit_ContactInfo_Details(WebDriver driver,String Search_Sap_id, String Add_Address,String Address_Type,String Address1,String Address2,String Location,String City,String State,String Country,String Zipcode,String Add_Personal_Details,String DOB,String Marital_sts,String Anniversary_date,ExtentTest logger ) throws Exception 
	{	
		try
		{
			//--------------------Verifying if its the right employee--------------//
			WebElement Employee_ID= driver.findElement(Employee_Information_Obj.Employee_ID);
			String Employee=Employee_ID.getAttribute("value");
			System.out.println(Employee);

			if(Employee.equalsIgnoreCase(Search_Sap_id))
			{
				gm.logPass(logger, "Employee details being displayed for the requied employee", driver);
				//Click on  Contact Information tab
				WebElement Contact_Information_Tab=driver.findElement(Employee_Information_Obj.Contact_Information_Tab);
				Contact_Information_Tab.click();
				gm.logInfo(logger, "Clicked on Contact Information Tab");

				if(Add_Address.equalsIgnoreCase("Y"))
				{
					//-------------------Address Details-----------------------------------------//
					//Click on Add button Address Details
					WebElement Address_Add_Button=driver.findElement(Employee_Information_Obj.Address_Add_Button);
					Address_Add_Button.click();
					gm.logInfo(logger, "Clicked on Add Button of Address Details");

					//-------------------Select Address Type-----------------------------------------//
					gm.selectValueFromListByText(driver,  Employee_Information_Obj.Address_Type, Address_Type, "Address_Type", logger);
					gm.logInfo(logger, "Address Type Selected");

					//Enter Address1
					gm.enterText(driver, Employee_Information_Obj.Address_1, Address1, "Address1", logger);
					gm.logInfo(logger, "Entered Address1");

					//Enter Address2
					gm.enterText(driver, Employee_Information_Obj.Address_2, Address2, "Address2", logger);
					gm.logInfo(logger, "Entered Address2");

					//Enter Location
					gm.enterText(driver, Employee_Information_Obj.Location, Location, "Location", logger);
					gm.logInfo(logger, "Entered Location");

					//Enter City
					gm.enterText(driver, Employee_Information_Obj.City, City, "City", logger);
					gm.logInfo(logger, "Entered City");

					//Enter State
					gm.enterText(driver, Employee_Information_Obj.State, State, "State", logger);
					gm.logInfo(logger, "Entered State");

					//Enter Country
					gm.enterText(driver, Employee_Information_Obj.Country, Country, "Country", logger);
					gm.logInfo(logger, "Entered Country");

					//Enter Zipcode
					gm.enterText(driver, Employee_Information_Obj.Zipcode, Zipcode, "Zipcode", logger);
					gm.logInfo(logger, "Entered Zipcode");


					//Click on Save button of Address Details
					WebElement Address_Save_btn=driver.findElement(Employee_Information_Obj.Address_Save_btn);
					Address_Save_btn.click();
					gm.logInfo(logger, "Saved Address details");

					Thread.sleep(1000);

					//Verify Address Error message			
					if(driver.findElements(By.xpath(".//*[@id='alertsectionAddAddress']/div")).size()!=0)
					{
						// Check all the validations
						WebElement Successmsg= driver.findElement(Employee_Information_Obj.Address_Msg);
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

						//Click on close Phone pop up
						WebElement Address_Close_btn=driver.findElement(Employee_Information_Obj.Address_Close_btn);
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
					WebElement Date_of_Birth=driver.findElement(Employee_Information_Obj.Date_of_Birth);
					Date_of_Birth.sendKeys(DOB);
					gm.logPass(logger, "Entered Date of Birth",driver);

					//-------------------Select Marital_Status----------------------------------------//
					gm.selectValueFromListByText(driver,  Employee_Information_Obj.Marital_Status, Marital_sts, "Marital_sts", logger);
					gm.logPass(logger, "Marital status Type Selected",driver);

					if(Marital_sts.equalsIgnoreCase("Married"))

					{
						//Enter Anniversary Date
						WebElement Anniversary_Date=driver.findElement(Employee_Information_Obj.Anniversary_Date);
						Anniversary_Date.sendKeys(Anniversary_date);
						gm.logPass(logger, "Entered Anniversary Date",driver);
					}
				}
				else {
					gm.logPass(logger, "Personal Details arent added",driver);
				}

				//Save
				WebElement contactinfo_save=driver.findElement(Employee_Information_Obj.contactinfo_save);
				contactinfo_save.click();
				gm.logInfo(logger, "Clicked on Contact Information save button");	

				//Verify Validation Message
				// Check all the validations
				WebElement Successmsg= driver.findElement(Employee_Information_Obj.contactinfo_err_msg);
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
			else
			{
				gm.logFail(logger, "Employee Details displayed isnt for the required employee", driver);
			}
		}
		catch(Exception e)
		{
			gm.logFail(logger, "Exception occured:"+e.getMessage(), driver);
		}

	}

	public  void Edit_Delegate_Details(WebDriver driver,String Search_Sap_id,String Delegate_To,String From_date,String To_date,String DelegateActive,ExtentTest logger)
	{
		try
		{
			//--------------------Verifying if its the right employee--------------//
			WebElement Employee_ID= driver.findElement(Employee_Information_Obj.Employee_ID);
			String Employee=Employee_ID.getAttribute("value");
			System.out.println(Employee);

			if(Employee.equalsIgnoreCase(Search_Sap_id))
			{
				gm.logPass(logger, "Employee details being displayed for the requied employee", driver);
				//Click on  Delegate Tab
				WebElement Delegate_Tab=driver.findElement(Employee_Information_Obj.Delegate_Tab);
				Delegate_Tab.click();
				gm.logInfo(logger, "Clicked on Delegate Tab");

				if(!Delegate_To.equals(""))
				{
					//Select delegate too
					WebElement Delegate_to_search= driver.findElement(Employee_Information_Obj.Delegate_to_search);
					Delegate_to_search.click();
					gm.logInfo(logger, "Clicked On Delegate_To Search Icon");
					Thread.sleep(500);
					gm.enterText(driver,Employee_Information_Obj.Delegate_To_employeeid , Delegate_To, "Delegate_To", logger);
					gm.logInfo(logger, "Employee Id of the required user is entered: "+ Delegate_To);
					Thread.sleep(500);
					WebElement Delegate_search_btn= driver.findElement(Employee_Information_Obj.Delegate_search_btn);
					Delegate_search_btn.click();
					gm.logInfo(logger, "Clicked On Delegate_To Search Button");
					Thread.sleep(500);	

					WebElement Delegate_to_select= driver.findElement(Employee_Information_Obj.Delegate_to_select);
					Delegate_to_select.click();
					gm.logInfo(logger, "Delegate_To Selected");
					Thread.sleep(500);
				}

				if(!From_date.equals(""))
				{
					//Enter From Date
					WebElement From_date_field=driver.findElement(Employee_Information_Obj.From_date_field);
					From_date_field.sendKeys(From_date);
					gm.logPass(logger, "Entered From Date",driver);
				}

				if(!To_date.equals(""))
				{
					//Enter To Date
					WebElement To_date_field=driver.findElement(Employee_Information_Obj.To_date_field);
					To_date_field.sendKeys(To_date);
					gm.logPass(logger, "Entered To date",driver);
				}

				//Checking Active Status
				if(!DelegateActive.equals(""))
				{
					boolean checked2 = driver.findElement(By.id("delegateactive")).isSelected();
					System.out.println(checked2);

					if(DelegateActive.equalsIgnoreCase("Y"))
					{
						if(checked2==true)
						{
							gm.logInfo(logger, "Delegate Active status is already checked");
						}
						else if(checked2==false)
						{
							WebElement Active2=driver.findElement(Employee_Information_Obj.active_sts);
							Active2.click();
							gm.logInfo(logger, "Checking Active status to active");
						}
					}
					if(DelegateActive.equalsIgnoreCase("N"))
					{
						if(checked2==true)		
						{
							WebElement Active2=driver.findElement(Employee_Information_Obj.active_sts);
							Active2.click();
							gm.logInfo(logger, "Checking active status to inactive");
						}
						else if(checked2==false)
						{
							gm.logInfo(logger, "Delegate Active status is already checked");
						}
					}
				}


				//Click on Save
				WebElement Delegate_save=driver.findElement(Employee_Information_Obj.Delegate_save);
				Delegate_save.click();
				gm.logPass(logger, "Clicked on Delegate Save",driver);

				ArrayList<String> Successmsg = new ArrayList<String>();
				for (int i = 1; i <= 3; i++) 
				{
					if(driver.findElements(By.xpath(".//*[@id='alertsectionEM']/div["+i+"]")).size()!=0)
					{
						Successmsg.add(driver.findElement(By.xpath(".//*[@id='alertsectionEM']/div["+i+"]")).getText());
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
					else if(Successmsg.get(i).contains("Error! Please Enter Delegate to."))
					{
						gm.logPass(logger, "User is being notified that Delegate to is Mandatory", driver);
					}
					else if(Successmsg.get(i).contains("Error! To date cannot be less than from date."))
					{
						gm.logPass(logger, "User is being notified that To date cannot be less than from date.", driver);

					}
					else {
						gm.logFail(logger, "Delegate Details Edit Fail",driver);
					}
				}
			}

			else {
				gm.logFail(logger, "Employee details not match the requied employee", driver);
			}
		}
		catch(Exception e)
		{
			gm.logFail(logger, "Exception occured:"+e.getMessage(), driver);
		}

	}
	
	public  void Edit_Separation_Details(WebDriver driver,String Search_Sap_id,String Separation_type,String Termaination_Date,String LWD,String Comments,String Revoke,ExtentTest logger)
	{
		try
		{
			//--------------------Verifying if its the right employee--------------//
			WebElement Employee_ID= driver.findElement(Employee_Information_Obj.Employee_ID);
			String Employee=Employee_ID.getAttribute("value");
			System.out.println(Employee);

			if(Employee.equalsIgnoreCase(Search_Sap_id))
			{
				gm.logPass(logger, "Employee details being displayed for the requied employee", driver);
				//Click on Separation Tab
				WebElement Separation_Tab=driver.findElement(Employee_Information_Obj.Separation_Tab);
				Separation_Tab.click();
				gm.logInfo(logger, "Clicked on Separation Tab");
				
				if(!Separation_type.equals(""))
				{
					gm.selectValueFromListByText(driver,  Employee_Information_Obj.Separation_type, Separation_type, "Separation_type", logger);
					gm.logPass(logger, "Separation Type Selected",driver);
				}
				
				if(!Termaination_Date.equals(""))
				{
					//Enter Date of Birth
					WebElement Termaination_Cldr=driver.findElement(Employee_Information_Obj.Date_of_Birth);
					Termaination_Cldr.sendKeys(Termaination_Date);
					gm.logPass(logger, "Entered Termaination Date",driver);
				}
				
				if(!LWD.equals(""))
				{
					//Enter Date of Birth
					WebElement LWD_Cldr=driver.findElement(Employee_Information_Obj.LWD_Cldr);
					LWD_Cldr.sendKeys(LWD);
					gm.logPass(logger, "Entered LWD",driver);
				}
				
				if(!Comments.equals(""))
				{
					//Enter Date of Birth
					WebElement Comment_Field=driver.findElement(Employee_Information_Obj.Comment_Field);
					Comment_Field.sendKeys(Comments);
					gm.logPass(logger, "Entered Comments",driver);
				}
				
				if(Revoke.equals("Y"))
				{
					WebElement Revoke_CheckBox=driver.findElement(Employee_Information_Obj.Revoke_CheckBox);
					Revoke_CheckBox.click();
					gm.logInfo(logger, "Clicking on revoke checkbox");
				}
				//Click on Save
				WebElement Separation_Save=driver.findElement(Employee_Information_Obj.Separation_Save);
				Separation_Save.click();
				gm.logPass(logger, "Clicked on Separation Save",driver);

				ArrayList<String> Successmsg = new ArrayList<String>();
				for (int i = 1; i <= 3; i++) 
				{
					if(driver.findElements(By.xpath(".//*[@id='alertsectionEM']/div["+i+"]")).size()!=0)
					{
						Successmsg.add(driver.findElement(By.xpath(".//*[@id='alertsectionEM']/div["+i+"]")).getText());
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
					else if(Successmsg.get(i).contains("Error! Please select a value from Separation Type."))
					{
						gm.logPass(logger, "User is being notified that Separation Type is Mandatory", driver);
					}
					else if(Successmsg.get(i).contains("Error! Separation Date must be greater than or equal to Last Day Worked."))
					{
						gm.logPass(logger, "User is being notified that Separation Date cannot be less than Last Day Worked.", driver);
					}
					else {
						gm.logFail(logger, "Separation Details Edit Fail",driver);
					}
				}				
			}
			else {
				gm.logFail(logger, "Employee details not match the requied employee", driver);
			}
		}
		catch(Exception e)
		{
			gm.logFail(logger, "Exception occured:"+e.getMessage(), driver);
		}
	}
}


