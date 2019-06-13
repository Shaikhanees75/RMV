package com.RM.Generic;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.UnreachableBrowserException;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

import com.RM.Generic.EnvironmentVariables;
import com.RM.Generic.GenericMethods2;
import com.RM.POM.Add_New_User_obj;
import com.RM.POM.Employee_Information_Obj;
import com.RM.POM.Instance_setup_Menus_obj;
import com.RM.POM.Leave_Request_Obj;
import com.RM.POM.OB_NewHire_Obj;
import com.RM.POM.Organization_Hierarchy_Obj;
import com.RM.POM.Project_Deatils_Obj;
import com.RM.POM.Time_card_obj;
import com.RM.POM.Trash_Collector_Obj;
import com.RM.POM.XNARF_Task_Obj;
import com.RM.POM.XnarfMainPage_Obj;
import com.RM.POM.Xnarf_Menus_obj;


public class common_methods 
{
	public static WebDriver driver ;
	static GenericMethods2 gm = new GenericMethods2();
	ExtentReports reports ;
	public static ExtentTest logger;
	public static String type;
	static String exp_err_msg="Error!Please select a value from: Client,Operation Category,Fixed Schedule Name,Office Location,Employment Status,Designation,Level,Department,Organization,Reporting Manager,Seat Number";
	public static ArrayList<String > actual=new ArrayList<String > ();
	static String Success_msg="Success! Your data has been submitted successfully.";
	//Open browser
	public void Open() throws InterruptedException 
	{	
		try
		{
			/*DesiredCapabilities returnCapabilities = DesiredCapabilities.internetExplorer();
			returnCapabilities.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
			returnCapabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
			System.setProperty(EnvironmentVariables.driverType, EnvironmentVariables.driverPath);
			driver = new InternetExplorerDriver(returnCapabilities);
			*/
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(EnvironmentVariables.URL);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			// Extend Reports 
			reports = new ExtentReports(EnvironmentVariables.reportPath);
			logger = reports.startTest("Browser Opened");
			gm.logInfo(logger, "RM Website Opened");
			reports.endTest(logger);
		}
		catch(UnreachableBrowserException e)
		{
			gm.logfail(logger, "Exception occured:"+e.getMessage());
		}    
	}
	
	
	//go to Single Value Masters menu
		public static void go_to_single_value_master(WebDriver driver, ExtentTest logger) throws Exception 
		{
			try
			{	
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

				//hover on Instance Setup
				WebElement Instance_setup= driver.findElement(Instance_setup_Menus_obj.Instance_setup);
				Actions action = new Actions(driver);
				action.moveToElement(Instance_setup).build().perform();
				gm.logInfo(logger, "We have hovered on Instance Setup Menu");
				
				//hover on Demographics
				WebElement Demographics= driver.findElement(Instance_setup_Menus_obj.Demographics);
				Actions action1 = new Actions(driver);
				action1.moveToElement(Demographics).build().perform();
				gm.logInfo(logger, "We have hovered on Demographics Menu");

				// Click on Single Value Master
				WebElement Single_Value_Master=driver.findElement(Instance_setup_Menus_obj.Single_Value_Master);
				Single_Value_Master.click();
				gm.logInfo(logger, "We have clicked on Single_Value_Master Menu");
			}
			catch(Exception e)
			{
				gm.logfail(logger, "Exception occured:"+e.getMessage());
			}
		}
	
	
	//go to XNARF wizard menu
	public static void go_to_Xnarf_wizard(WebDriver driver, ExtentTest logger) throws Exception 
	{
		try
		{	
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			//hover on XNARF
			WebElement Xnarf= driver.findElement(Xnarf_Menus_obj.xnarf);
			Actions action = new Actions(driver);
			action.moveToElement(Xnarf).build().perform();
			gm.logInfo(logger, "We have hovered on XNARF Menu");

			// Click on Xnarf wizard
			WebElement Xnarf_wizard=driver.findElement(Xnarf_Menus_obj.xnarf_wizard);
			Xnarf_wizard.click();
			gm.logInfo(logger, "We have clicked on Xnarf Wizard tab");
		}
		catch(Exception e)
		{
			gm.logfail(logger, "Exception occured:"+e.getMessage());
		}
	}	
	
	//go to Trash Collector Screen
	public static void go_to_Trash_Collector(WebDriver driver, ExtentTest logger) throws Exception 
	{
		try
		{	
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			//hover on Resource Planner
			WebElement ResourcePlanner= driver.findElement(Trash_Collector_Obj.resource_planner);
			Actions action = new Actions(driver);
			action.moveToElement(ResourcePlanner).build().perform();
			gm.logInfo(logger, "We have hovered on Resource Planner Menu");

			// Click on Trash Collector
			WebElement Trash_Collector=driver.findElement(Trash_Collector_Obj.trash_collector);
			Trash_Collector.click();
			gm.logInfo(logger, "We have clicked on Trash Collector tab");
		}
		catch(Exception e)
		{
			gm.logfail(logger, "Exception occured:"+e.getMessage());
		}
	}
	
	//go to organization master
	public static void go_to_organization_master() throws Exception 
	{
		try
		{	
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			//hover on Instance setup
			WebElement ResourcePlanner= driver.findElement(Organization_Hierarchy_Obj.instance_setup);
			Actions action = new Actions(driver);
			action.moveToElement(ResourcePlanner).build().perform();
			gm.logInfo(logger, "We have hovered on Instance Setup");

			// Click on Hierarchy master
			WebElement Hierarchy_master=driver.findElement(Organization_Hierarchy_Obj.hierarchy_master);
			Actions action1 = new Actions(driver);
			action1.moveToElement(Hierarchy_master).build().perform();
			gm.logInfo(logger, "We have hovered on Hierarchy master");
			
			// Click on Organization master
			WebElement Organization_Master=driver.findElement(Organization_Hierarchy_Obj.organization);
			Organization_Master.click();
			gm.logInfo(logger, "We have clicked on Organization menu");
		}
		
		catch(Exception e)
		{
			gm.logfail(logger, "Exception occured:"+e.getMessage());
		}
	}
	
	
	//go to Location master
		public static void go_to_location_master() throws Exception 
		{
			try
			{	
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

				//hover on Instance setup
				WebElement ResourcePlanner= driver.findElement(Organization_Hierarchy_Obj.instance_setup);
				Actions action = new Actions(driver);
				action.moveToElement(ResourcePlanner).build().perform();
				gm.logInfo(logger, "We have hovered on Instance Setup");

				// Click on Hierarchy master
				WebElement Hierarchy_master=driver.findElement(Organization_Hierarchy_Obj.hierarchy_master);
				Hierarchy_master.click();
				gm.logInfo(logger, "We have clicked on Hierarchy master");
				
				// Click on Organization master
				WebElement Organization_Master=driver.findElement(Organization_Hierarchy_Obj.location);
				Organization_Master.click();
				gm.logInfo(logger, "We have clicked on Location menu");
			}
			
			catch(Exception e)
			{
				gm.logfail(logger, "Exception occured:"+e.getMessage());
			}
		}
		
		
		//Go To Leave Request
		public static void go_to_leave_request() throws Exception 
		{
			try
			{	
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

				//hover on Resource Planner
				WebElement ResourcePlanner= driver.findElement(Leave_Request_Obj.resource_planner);
				Actions action = new Actions(driver);
				action.moveToElement(ResourcePlanner).build().perform();
				gm.logInfo(logger, "We have hovered on Resource Planner Menu");

				// Click on Leave Request
				WebElement Trash_Collector=driver.findElement(Leave_Request_Obj.leave_request);
				Trash_Collector.click();
				gm.logInfo(logger, "We have clicked on Leave Request tab");
				
				
			}
			
			
			catch(Exception e)
			{
				gm.logfail(logger, "Exception occured:"+e.getMessage());
			}
		}
		

		//Go To Leave approval
		public static void go_to_leave_approval() throws Exception 
		{
			try
			{	
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

				//hover on Resource Planner
				WebElement ResourcePlanner= driver.findElement(Leave_Request_Obj.resource_planner);
				Actions action = new Actions(driver);
				action.moveToElement(ResourcePlanner).build().perform();
				gm.logInfo(logger, "We have hovered on Resource Planner Menu");

				// Click on Leave Request
				WebElement LeaveApproval=driver.findElement(Leave_Request_Obj.leave_approval);
				LeaveApproval.click();
				gm.logInfo(logger, "We have clicked on Leave Approval");
				
				
			}
			
			
			catch(Exception e)
			{
				gm.logfail(logger, "Exception occured:"+e.getMessage());
			}
		}
		
		//Date Time Picker

		public void testDAtePicker(String date) throws Exception{

			try
			{
				//DAte and Time to be set in textbox
				String dateTime = date;     

				//Split the date time to get only the date part
				String date_dd_MM_yyyy[] = dateTime.split("/");

				System.out.println(date_dd_MM_yyyy[0]);
				System.out.println(date_dd_MM_yyyy[1]);
				System.out.println(date_dd_MM_yyyy[2]);

				//get the year difference between current year and year to set in calendar
				int yearDiff = Integer.parseInt(date_dd_MM_yyyy[2])- Calendar.getInstance().get(Calendar.YEAR);
				WebElement current_month = driver.findElement(Leave_Request_Obj.cntr_mnth);
				current_month.click(); 


				if(yearDiff!=0){

					//if you have to move next year

					if(yearDiff>0){

						for(int i=0;i< yearDiff;i++){

							System.out.println("Year Diff->"+i);

							WebElement nxt_yr = driver.findElement(Leave_Request_Obj.nxt_yr);
							nxt_yr.click();


						}

					}

					//if you have to move previous year

					else if(yearDiff<0){

						for(int i=0;i< (yearDiff*(-1));i++){

							System.out.println("Year Diff->"+i);

							WebElement prev_yr = driver.findElement(Leave_Request_Obj.prev_yr);
							prev_yr.click();
						}

					}

				}

				Thread.sleep(1000);

				//Get all months from calendar to select correct one

				List<WebElement> list_AllMonthToBook = driver.findElements(Leave_Request_Obj.month_table);

				list_AllMonthToBook.get(Integer.parseInt(date_dd_MM_yyyy[0])-1).click();

				Thread.sleep(1000);

				//select todays date
				WebElement Required_Date = driver.findElement(By.xpath("html/body/div[4]/div[1]/table/tbody/tr/td[not((contains(@class,'old '))or (contains(@class,'new ')))][text()='"+date_dd_MM_yyyy[1]+"']"));
				Required_Date.click();

				//get all dates from calendar to select correct one

				/*String toDay;
					WebElement FromDateLeaveCode = driver.findElement(By.xpath("html/body/div[4]/div[1]/table/tbody/tr/td[contains(@class,'today day')]"));
					toDay=FromDateLeaveCode.getText();
					System.out.println(toDay);
					Thread.sleep(1000);

					if(toDay.equalsIgnoreCase(date_dd_MM_yyyy[1])) {
						System.out.println("date is already selected");
					}
					else {

					List<WebElement> list_AllDateToBook = driver.findElements(Leave_Request_Obj.date_table);

					list_AllDateToBook.get(Integer.parseInt(date_dd_MM_yyyy[1])-1).click();

				}*/
			}
			catch(Exception e)
			{
				gm.logfail(logger, "Exception occured:"+e.getMessage());
			}
		}

	//Mandatory Fields check
	public void mandatory_Fields_check(WebDriver driver, ExtentTest logger)
	{
		try
		{
			System.out.println("inside mandatory");
			List<WebElement> mandate_element = driver.findElements(By.xpath("//label[.//i[text()='*']]"));
			for (WebElement suggestion : mandate_element)
			{
				String mandatory_fields=suggestion.getText();

				System.out.println(suggestion.getText());

				gm.logInfo(logger, "Mandatory fields are"+mandatory_fields+"\n", driver);
			}



			WebElement Save=driver.findElement(Add_New_User_obj.add_new_user_Save_btn);
			Save.click();

			WebElement alert=driver.findElement(Add_New_User_obj.Error_msg);
			String actual_msg=alert.getText();

			if(actual_msg.equalsIgnoreCase(exp_err_msg))
			{
				gm.logInfo(logger, "Please Fill all the mandatory fields having * mark", driver);
			}
			else if(actual_msg.equalsIgnoreCase(Success_msg))
			{
				gm.logInfo(logger, "Data has been submitted successfully", driver);
			}
		}
		catch(Exception e)
		{
			gm.logFail(logger, "Exception occured:"+e.getMessage(), driver);
		}
	}
	
	// Time Card
	public void TimeCardDatePicker(String date) throws Exception{

		try
		{
			//DAte and Time to be set in textbox
			String dateTime = date;     

			//Split the date time to get only the date part
			String date_dd_MM_yyyy[] = dateTime.split("/");
			
			System.out.println(date_dd_MM_yyyy[0]);
			System.out.println(date_dd_MM_yyyy[1]);
			System.out.println(date_dd_MM_yyyy[2]);
			
			//get the year difference between current year and year to set in calendar
			int yearDiff = Integer.parseInt(date_dd_MM_yyyy[2])- Calendar.getInstance().get(Calendar.YEAR);
			WebElement current_month = driver.findElement(Time_card_obj.cntr_mnth);
			current_month.click(); 


			if(yearDiff!=0){

				//if you have to move next year

				if(yearDiff>0){

					for(int i=0;i< yearDiff;i++){

						System.out.println("Year Diff->"+i);

						WebElement nxt_yr = driver.findElement(Time_card_obj.nxt_yr);
						nxt_yr.click();


					}

				}

				//if you have to move previous year

				else if(yearDiff<0){

					for(int i=0;i< (yearDiff*(-1));i++){

						System.out.println("Year Diff->"+i);

						WebElement prev_yr = driver.findElement(Time_card_obj.prev_yr);
						prev_yr.click();
					}

				}

			}

			Thread.sleep(1000);

			//Get all months from calendar to select correct one

			List<WebElement> list_AllMonthToBook = driver.findElements(Time_card_obj.month_table);

			list_AllMonthToBook.get(Integer.parseInt(date_dd_MM_yyyy[0])-1).click();

			Thread.sleep(1000);
			
			//select todays date
			WebElement Required_Date = driver.findElement(By.xpath("html/body/div[2]/div[1]/table/tbody/tr/td[not((contains(@class,'old '))or (contains(@class,'new ')))][text()='"+date_dd_MM_yyyy[1]+"']"));
			Required_Date.click();

			//get all dates from calendar to select correct one
			
			/*String toDay;
			WebElement FromDateLeaveCode = driver.findElement(By.xpath("html/body/div[4]/div[1]/table/tbody/tr/td[contains(@class,'today day')]"));
			toDay=FromDateLeaveCode.getText();
			System.out.println(toDay);
			Thread.sleep(1000);
			
			if(toDay.equalsIgnoreCase(date_dd_MM_yyyy[1])) {
				System.out.println("date is already selected");
			}
			else {

			List<WebElement> list_AllDateToBook = driver.findElements(Leave_Request_Obj.date_table);

			list_AllDateToBook.get(Integer.parseInt(date_dd_MM_yyyy[1])-1).click();

		}*/
		}
		catch(Exception e)
		{
			gm.logfail(logger, "Exception occured:"+e.getMessage());
		}
	}

	
//-----------------------------for Xnarf(DOM)-------------------------------------------------------------
	
 	public  void Complete_count() throws Exception 
 		{
	 		try
	 		{	
	 			//For Pending request count	
			WebElement Pending_Request = driver.findElement(XnarfMainPage_Obj.pending_req);
			String Pending_Request_Count = Pending_Request.getText();
			System.out.println(Pending_Request_Count);
			String Total_num=Pending_Request_Count.replaceAll("[^0-9]", "");
			int Current_Pending_Request_Count = Integer.parseInt(Total_num);
			System.out.println(Current_Pending_Request_Count);
			
		// for pending task	
			WebElement Pending_tasks = driver.findElement(XnarfMainPage_Obj.pending_tasks);
			String Pending_task_Count = Pending_tasks.getText();
			System.out.println(Pending_task_Count);
			String Total_num1=Pending_task_Count.replaceAll("[^0-9]", "");
			int Current_Pending_task_Count = Integer.parseInt(Total_num1);
			System.out.println(Current_Pending_task_Count);
			
		//for completed tasks
			WebElement completed_tasks = driver.findElement(XnarfMainPage_Obj.completed_tasks);
			String completed_tasks_Count = completed_tasks.getText();
			System.out.println(completed_tasks_Count);
			String Total_num2=completed_tasks_Count.replaceAll("[^0-9]", "");
			int Current_completed_tasks_Count = Integer.parseInt(Total_num2);
			System.out.println(Current_completed_tasks_Count);
			
		// for completed requests
			WebElement completed_request = driver.findElement(XnarfMainPage_Obj.completed_req);
			String completed_request_Count = completed_request.getText();
			System.out.println(completed_request_Count);
			String Total_num3=completed_request_Count.replaceAll("[^0-9]", "");
			int Current_completed_request_Count = Integer.parseInt(Total_num3);
			System.out.println(Current_completed_request_Count);
			Thread.sleep(3000);
			
			//-----for sub tasks count--------
			
			// For OB count	
			WebElement OB = driver.findElement(OB_NewHire_Obj.OB_btn);
			String OB_Count = OB.getText();
			System.out.println(OB_Count);
			String total_num= OB_Count.replaceAll("[^0-9]", "");
			int Current_OB_Count = Integer.parseInt(total_num);
			System.out.println(Current_OB_Count);
			
		// for RM	 
			WebElement RM = driver.findElement(OB_NewHire_Obj.RM_btn);
			String RM_Count = RM.getText();
			System.out.println(RM_Count);
			String total_num1=RM_Count.replaceAll("[^0-9]", "");
			int Current_RM_Count = Integer.parseInt(total_num1);
			System.out.println(Current_RM_Count);
			
		//for WP
			WebElement WP = driver.findElement(OB_NewHire_Obj.WP_btn);
			String WP_Count = WP.getText();
			System.out.println(WP_Count);
			String total_num2=WP_Count.replaceAll("[^0-9]", "");
			int Current_WP_Count = Integer.parseInt(total_num2);
			System.out.println(Current_WP_Count);
			
		// for WPS
			WebElement WPS = driver.findElement(OB_NewHire_Obj.WPS_btn);
			String WPS_Count = WPS.getText();
			System.out.println(WPS_Count);
			String total_num3=WPS_Count.replaceAll("[^0-9]", "");
			int Current_WPS_Count = Integer.parseInt(total_num3);
			System.out.println(Current_WPS_Count);
			Thread.sleep(3000);
			
			//--------------------------------------------------------------------
			
			// select record to be completed
			WebElement select = driver.findElement(OB_NewHire_Obj.select_all_check_box);
			select.click();
			gm.logInfo(logger, "We have selected the record to complete WP workflow", driver);
			Thread.sleep(2000);
			
			//click on complete button
			WebElement complete_btn = driver.findElement(OB_NewHire_Obj.complete_btn);
			complete_btn.click();
			gm.logPass(logger, "We have clicked on complete button", driver);
			Thread.sleep(2000);
			
			//Click on Ok button
			WebElement ok_btn1 = driver.findElement(OB_NewHire_Obj.Ok_btn);
			ok_btn1.click();
			gm.logInfo(logger, "We have clicked on OK button", driver);
			gm.logPass(logger, "We have successfully completed WPS task for Single entry");
			
			//-----------------------------------------------
			
			//For Pending request count	
			WebElement Pending_Request1 = driver.findElement(XnarfMainPage_Obj.pending_req);
			String Pending_Request_Count1 = Pending_Request1.getText();
			System.out.println(Pending_Request_Count1);
			String Actual_num=Pending_Request_Count1.replaceAll("[^0-9]", "");
			int Actual_Pending_Request_Count = Integer.parseInt(Actual_num);
			System.out.println(Actual_Pending_Request_Count);
			
		// for pending task	
			WebElement Pending_tasks1 = driver.findElement(XnarfMainPage_Obj.pending_tasks);
			String Pending_task_Count1 = Pending_tasks1.getText();
			System.out.println(Pending_task_Count1);
			String Actual_num1=Pending_task_Count1.replaceAll("[^0-9]", "");
			int Actual_Pending_task_Count = Integer.parseInt(Actual_num1);
			System.out.println(Actual_Pending_task_Count);
			
		//for completed tasks
			WebElement completed_tasks1 = driver.findElement(XnarfMainPage_Obj.completed_tasks);
			String completed_tasks_Count1 = completed_tasks1.getText();
			System.out.println(completed_tasks_Count1);
			String Actual_num2=completed_tasks_Count1.replaceAll("[^0-9]", "");
			int Actual_completed_tasks_Count = Integer.parseInt(Actual_num2);
			System.out.println(Actual_completed_tasks_Count);
			
		// for completed requests
			WebElement completed_request1 = driver.findElement(XnarfMainPage_Obj.completed_req);
			String completed_request_Count1 = completed_request1.getText();
			System.out.println(completed_request_Count1);
			String Actual_num3=completed_request_Count1.replaceAll("[^0-9]", "");
			int Actual_completed_request_Count = Integer.parseInt(Actual_num3);
			System.out.println(Actual_completed_request_Count);
			
					
			//-------
			// For OB count	
						WebElement OB1 = driver.findElement(OB_NewHire_Obj.OB_btn);
						String OB_Count1 = OB1.getText();
						System.out.println(OB_Count1);
						String actual_num= OB_Count1.replaceAll("[^0-9]", "");
						int Actual_OB_Count = Integer.parseInt(actual_num);
						System.out.println(Actual_OB_Count);
						
					// for RM	 
						WebElement RM1 = driver.findElement(OB_NewHire_Obj.RM_btn);
						String RM_Count1 = RM1.getText();
						System.out.println(RM_Count1);
						String actual_num1=RM_Count1.replaceAll("[^0-9]", "");
						int Actual_RM_Count = Integer.parseInt(actual_num1);
						System.out.println(Actual_RM_Count);
						
					//for WP
						WebElement WP1 = driver.findElement(OB_NewHire_Obj.WP_btn);
						String WP_Count1 = WP1.getText();
						System.out.println(WP_Count1);
						String actual_num2=WP_Count1.replaceAll("[^0-9]", "");
						int Actual_WP_Count = Integer.parseInt(actual_num2);
						System.out.println(Actual_WP_Count);
						
					// for WPS
						WebElement WPS1 = driver.findElement(OB_NewHire_Obj.WPS_btn);
						String WPS_Count1 = WPS1.getText();
						System.out.println(WPS_Count1);
						String actual_num3=WPS_Count.replaceAll("[^0-9]", "");
						int Actual_WPS_Count = Integer.parseInt(actual_num3);
						System.out.println(Actual_WPS_Count);
						Thread.sleep(3000);
						
			
			if((Current_completed_tasks_Count+1)== Actual_completed_tasks_Count && (Current_Pending_task_Count-1)==Actual_Pending_task_Count && (Current_OB_Count-1)==Actual_OB_Count)
			{
				gm.logPass(logger, "OB workflow has been Completed successfully", driver);
			}
			else if((Current_completed_tasks_Count+1)== Actual_completed_tasks_Count && (Current_Pending_task_Count-1)==Actual_Pending_task_Count && (Current_RM_Count-1)==Actual_RM_Count)

			{
				gm.logPass(logger, "RM workflow has been Completed successfully", driver);
			}
			else if((Current_completed_tasks_Count+1)== Actual_completed_tasks_Count && (Current_Pending_task_Count-1)==Actual_Pending_task_Count && (Current_WP_Count-1)==Actual_WP_Count)
			{
				gm.logPass(logger, "WP workflow has been Completed successfully", driver);

			}
			else if((Current_completed_tasks_Count+1)== Actual_completed_tasks_Count && (Current_Pending_task_Count-1)==Actual_Pending_task_Count && (Current_WPS_Count-1)==Actual_WPS_Count)
			{
				gm.logPass(logger, "WPS workflow has been Completed successfully", driver);

			}
			
	 		}
			catch(Exception e)
			{
				gm.logfail(logger, "Exception occured:"+e.getMessage());
			}
		}
 	
 	//Date Picker for Add New User
 		//Date Picker
 		public  void ANTestDatePicker(String date) throws Exception
 		{

 			try
 			{
 				//DAte and Time to be set in textbox
 				String dateTime = date;     

 				//Split the date time to get only the date part
 				String date_dd_MM_yyyy[] = dateTime.split("/");

 				System.out.println(date_dd_MM_yyyy[0]);
 				System.out.println(date_dd_MM_yyyy[1]);
 				System.out.println(date_dd_MM_yyyy[2]);

 				//get the year difference between current year and year to set in calendar
 				int yearDiff = Integer.parseInt(date_dd_MM_yyyy[2])- Calendar.getInstance().get(Calendar.YEAR);
 				Thread.sleep(1000);
 				WebElement current_month = driver.findElement(Add_New_User_obj.cntr_mnth);
 				current_month.click(); 


 				if(yearDiff!=0){

 					//if you have to move next year

 					if(yearDiff>0){

 						for(int i=0;i< yearDiff;i++){

 							System.out.println("Year Diff->"+i);

 							WebElement nxt_yr = driver.findElement(Add_New_User_obj.nxt_yr);
 							nxt_yr.click();


 						}

 					}

 					//if you have to move previous year

 					else if(yearDiff<0){

 						for(int i=0;i< (yearDiff*(-1));i++){

 							System.out.println("Year Diff->"+i);

 							WebElement prev_yr = driver.findElement(Add_New_User_obj.prev_yr);
 							prev_yr.click();
 						}

 					}

 				}

 				Thread.sleep(1000);

 				//Get all months from calendar to select correct one

 				List<WebElement> list_AllMonthToBook = driver.findElements(Add_New_User_obj.month_table);

 				list_AllMonthToBook.get(Integer.parseInt(date_dd_MM_yyyy[0])-1).click();

 				Thread.sleep(1000);

 				//select todays date
 				WebElement Required_Date = driver.findElement(By.xpath("html/body/div/div[1]/table/tbody/tr/td[not((contains(@class,'old '))or (contains(@class,'new ')))][text()='"+date_dd_MM_yyyy[1]+"']"));
 				Required_Date.click();

 			}
 			catch(Exception e)
 			{
 				gm.logFail(logger, "Exception occured:"+e.getMessage(),driver);
 			}
 		}

 		//Date Picker for Employee Information
 		//Date Picker
 		public void EITestDatePicker(String date) throws Exception{

 			try
 			{
 				//DAte and Time to be set in textbox
 				String dateTime = date;     

 				//Split the date time to get only the date part
 				String date_dd_MM_yyyy[] = dateTime.split("/");	
 				System.out.println(date_dd_MM_yyyy[0]);
 				System.out.println(date_dd_MM_yyyy[1]);
 				System.out.println(date_dd_MM_yyyy[2]);

 				//get the year difference between current year and year to set in calendar
 				int yearDiff = Integer.parseInt(date_dd_MM_yyyy[2])- Calendar.getInstance().get(Calendar.YEAR);
 				Thread.sleep(1000);
 				WebElement current_month = driver.findElement(Employee_Information_Obj.cntr_mnth);
 				current_month.click(); 


 				if(yearDiff!=0){

 					//if you have to move next year

 					if(yearDiff>0){

 						for(int i=0;i< yearDiff;i++){

 							System.out.println("Year Diff->"+i);

 							WebElement nxt_yr = driver.findElement(Employee_Information_Obj.nxt_yr);
 							nxt_yr.click();


 						}

 					}

 					//if you have to move previous year

 					else if(yearDiff<0){

 						for(int i=0;i< (yearDiff*(-1));i++){

 							System.out.println("Year Diff->"+i);

 							WebElement prev_yr = driver.findElement(Employee_Information_Obj.prev_yr);
 							prev_yr.click();
 						}

 					}

 				}

 				Thread.sleep(1000);

 				//Get all months from calendar to select correct one

 				List<WebElement> list_AllMonthToBook = driver.findElements(Employee_Information_Obj.month_table);

 				list_AllMonthToBook.get(Integer.parseInt(date_dd_MM_yyyy[0])-1).click();

 				Thread.sleep(1000);

 				//select todays date
 				WebElement Required_Date = driver.findElement(By.xpath("html/body/div/div[1]/table/tbody/tr/td[not((contains(@class,'old '))or (contains(@class,'new ')))][text()='"+date_dd_MM_yyyy[1]+"']"));
 				Required_Date.click();

 			}
 			catch(Exception e)
 			{
 				gm.logFail(logger, "Exception occured:"+e.getMessage(),driver);
 			}
 		}



 		//Go To XNARF Task
 		public static void go_to_xnarf_task(WebDriver driver, ExtentTest logger) throws Exception 
 		{
 			try
 			{	
 				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

 				//hover on XNARF
 				WebElement XNARF= driver.findElement(XNARF_Task_Obj.xnarf);
 				Actions action = new Actions(driver);
 				action.moveToElement(XNARF).build().perform();
 				gm.logInfo(logger, "We have hovered on XNARF Menu");

 				// Click on XNARF Task
 				WebElement xnarf_task=driver.findElement(XNARF_Task_Obj.xnarf_task);
 				xnarf_task.click();
 				gm.logInfo(logger, "We have clicked on XNARF Task Menu");

 			}

 			catch(Exception e)
 			{
 				gm.logfail(logger, "Exception occured:"+e.getMessage());
 			}
 		}


 		//Go Required Task
 		public static void go_to_required_task(WebDriver driver,String Type,String Task,String Request_ID,ExtentTest logger) throws Exception 
 		{
 			try
 			{	
 				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

 				if(Type.equalsIgnoreCase("Pending Requests"))
 				{
 					// Click on Pending Requests
 					WebElement pending_request=driver.findElement(XNARF_Task_Obj.pending_request);
 					pending_request.click();
 					gm.logInfo(logger, "We have clicked on Pending Request");


 					//Filter the Required Request
 					gm.enterText(driver,XNARF_Task_Obj.requestId_filter , Request_ID, "Request_ID", logger);

 					//Click on enter
 					driver.findElement(By.id("0")).sendKeys(Keys.RETURN);

 					if(driver.findElements(By.xpath("1")).size()!= 0)
 					{
 						// Click on Required Request
 						WebElement request_Id=driver.findElement(XNARF_Task_Obj.request_Id);
 						request_Id.click();
 						Thread.sleep(1000);
 						gm.logPass(logger, "We have clicked on Request: " + Request_ID,driver);
 					}
 					else {
 						gm.logFail(logger, "Following request ID not found " + Request_ID,driver);
 					}
 				}
 				else if(Type.equalsIgnoreCase("Pending Tasks"))
 				{
 					// Click on Pending Tasks
 					WebElement pending_task=driver.findElement(XNARF_Task_Obj.pending_task);
 					pending_task.click();
 					gm.logInfo(logger, "We have clicked on Pending Tasks");
 					Thread.sleep(1000);

 					//Click on Required Task
 					WebElement Required_Task = driver.findElement(By.id(Task+"1"));
 					Required_Task.click();
 					Thread.sleep(1000);

 					//Filter the Required Task
 					gm.enterText(driver,XNARF_Task_Obj.requestId_filter , Request_ID, "Request_ID", logger);	
 					//Click on enter
 					driver.findElement(By.id("0")).sendKeys(Keys.RETURN);
 					Thread.sleep(1000);

 					if(driver.findElements(By.id("1")).size()!= 0)
 					{
 						// Click on Task
 						WebElement request_Id=driver.findElement(XNARF_Task_Obj.request_Id);
 						request_Id.click();
 						Thread.sleep(1000);
 						gm.logPass(logger, "We have clicked on Task: " + Request_ID,driver);
 					}
 					else {
 						gm.logFail(logger, "Following Task not found " + Request_ID,driver);
 					}

 				}
 				else if(Type.equalsIgnoreCase("Completed Tasks"))
 				{
 					// Click on Completed Tasks
 					WebElement completed_task=driver.findElement(XNARF_Task_Obj.completed_task);
 					completed_task.click();
 					gm.logInfo(logger, "We have clicked on Completed Tasks");
 					Thread.sleep(1000);

 					//Click on Required Task
 					WebElement Required_Task = driver.findElement(By.id(Task+"2"));
 					Required_Task.click();
 					Thread.sleep(1000);

 					//Filter the Required Task
 					gm.enterText(driver,XNARF_Task_Obj.requestId_filter , Request_ID, "Request_ID", logger);	
 					//Click on enter
 					driver.findElement(By.id("0")).sendKeys(Keys.RETURN);
 					Thread.sleep(1000);

 					if(driver.findElements(By.id("1")).size()!= 0)
 					{
 						// Click on Task
 						WebElement request_Id=driver.findElement(XNARF_Task_Obj.request_Id);
 						request_Id.click();
 						Thread.sleep(1000);
 						gm.logPass(logger, "We have clicked on Task: " + Request_ID,driver);
 					}
 					else {
 						gm.logFail(logger, "Following Task not found " + Request_ID,driver);
 					}
 				}
 				else if(Type.equalsIgnoreCase("Completed Requests")) 
 				{
 					// Click on Completed Requests
 					WebElement completed_request=driver.findElement(XNARF_Task_Obj.completed_request);
 					completed_request.click();
 					gm.logInfo(logger, "We have clicked on Completed Requests");

 					//Click on Required Request
 					WebElement Required_Task = driver.findElement(By.xpath(Task+"2"));
 					Required_Task.click();
 					Thread.sleep(1000);

 					//Filter the Required Task
 					gm.enterText(driver,XNARF_Task_Obj.requestId_filter , Request_ID, "Request_ID", logger);	
 					//Click on enter
 					driver.findElement(By.id("0")).sendKeys(Keys.RETURN);
 					Thread.sleep(1000);

 					if(driver.findElements(By.xpath("1")).size()!= 0)
 					{
 						// Click on Task
 						WebElement request_Id=driver.findElement(XNARF_Task_Obj.request_Id);
 						request_Id.click();
 						Thread.sleep(1000);
 						gm.logPass(logger, "We have clicked on Request with ID : " + Request_ID,driver);
 					}
 					else {
 						gm.logFail(logger, "Following Request not found " + Request_ID,driver);
 					}
 				}
 			}

 			catch(Exception e)
 			{
 				gm.logfail(logger, "Exception occured:"+e.getMessage());
 			}
 		}


 		//Task Workflow Select and Delegate
 		public static void select_delegate(WebDriver driver,String Request_ID,String Sap_id,String Delgate_To,String Locked_by,ExtentTest logger)
 		{
 			try {
 				WebElement EmployeeId_filter= driver.findElement(XNARF_Task_Obj.EmployeeId_filter);
 				EmployeeId_filter.clear();

 				//Employee ID Filter
 				gm.enterText(driver, XNARF_Task_Obj.EmployeeId_filter, Sap_id, "Sap_id", logger);

 				//Click on enter
 				driver.findElement(By.id("4")).sendKeys(Keys.RETURN);
 				Thread.sleep(1000);

 				//Select the check box
 				WebElement Select_Single=driver.findElement(XNARF_Task_Obj.Select_Single);
 				Select_Single.click();
 				gm.logPass(logger, "We have selected the required record to delegate.",driver);

 				if(!Delgate_To.equals(""))
 				{
 					//Select the required delegate to
 					gm.selectValueFromListByText(driver,  XNARF_Task_Obj.delegate_drpdwn, Delgate_To, "Delgate_To", logger);
 					gm.logInfo(logger, "Delgate_To Selected");
 				}

 				//Click on Delegate button
 				WebElement Delegate_Button=driver.findElement(XNARF_Task_Obj.Delegate_Button);
 				Delegate_Button.click();
 				gm.logPass(logger, "We have clicked on delegate button.",driver);

 				//Verify message

 				if(driver.findElements(By.xpath("html/body/div[contains(@class,'bootbox modal fade bootbox-alert in')]/div/div/div[1]/div")).size()!=0)
 				{
 					WebElement Phone_Msg= driver.findElement(By.xpath("html/body/div[contains(@class,'bootbox modal fade bootbox-alert in')]/div/div/div[1]/div"));
 					String Successmsg1=Phone_Msg.getText();

 					if(Successmsg1.contains("Saved Successfully"))
 					{
 						gm.logPass(logger, "Delegate action pass",driver);

 						//Click on Ok
 						WebElement message_ok=driver.findElement(XNARF_Task_Obj.message_ok);
 						message_ok.click();
 					}
 					else {
 						gm.logFail(logger, "Delegate action Fail",driver);

 						//Click on Ok
 						WebElement message_ok=driver.findElement(XNARF_Task_Obj.message_ok);
 						message_ok.click();
 					}
 				}
 				else {
 					gm.logFail(logger, "Delegate Action Fail",driver);

 				}

 				//Verifying Delegate

 				if(!Locked_by.equals(""))
 				{
 					String locked_by1=null;
 					
 					if(Request_ID.contains("TF")) {
 					//Collect Locked By data
 					WebElement locked_by= driver.findElement(XNARF_Task_Obj.locked_by);
 					locked_by1=locked_by.getText();
 					System.out.println(locked_by1);
 					}
 					
 					else if(Request_ID.contains("CS")) {
 						//Collect Locked By data
 						WebElement locked_by= driver.findElement(XNARF_Task_Obj.cs_locked_by);
 						locked_by1=locked_by.getText();
 						System.out.println(locked_by1);
 						}
 					else if(Request_ID.contains("TR")) {
 						//Collect Locked By data
 						WebElement locked_by= driver.findElement(XNARF_Task_Obj.tr_locked_by_grid);
 						locked_by1=locked_by.getText();
 						System.out.println(locked_by1);
 						}

 					if(locked_by1.equalsIgnoreCase(Locked_by))
 					{
 						gm.logPass(logger, "Displaying the right Locked_by: "+Locked_by+" Delegate to PASS", driver); 
 					}
 					else
 					{
 						gm.logFail(logger, "Displaying the wrong Locked_by: "+Locked_by+" Delegate to FAIL", driver); 
 					}
 				}
 			}
 			catch(Exception e)
 			{
 				gm.logfail(logger, "Exception occured:"+e.getMessage());
 			}

 		}
 		//Task Workflow Select and Complete
 		public static void select_complete(WebDriver driver,String Sap_id,ExtentTest logger)
 		{
 			try {

 				WebElement EmployeeId_filter= driver.findElement(XNARF_Task_Obj.EmployeeId_filter);
 				EmployeeId_filter.clear();

 				//Employee ID Filter
 				gm.enterText(driver, XNARF_Task_Obj.EmployeeId_filter, Sap_id, "Sap_id", logger);

 				//Click on enter
 				driver.findElement(By.id("4")).sendKeys(Keys.RETURN);
 				Thread.sleep(1000);		

 				//Select single
 				//Select the check box
 				WebElement Select_Single=driver.findElement(XNARF_Task_Obj.Select_Single);
 				Select_Single.click();
 				gm.logPass(logger, "We have selected the required record to complete.",driver);

 				//----------------------Pending Request count---------------------//
 				WebElement Pending_Request = driver.findElement(XNARF_Task_Obj.pending_request);
 				String Pending_Request_Count = Pending_Request.getText();
 				String Total_num=Pending_Request_Count.replaceAll("[^0-9]", "");
 				int Current_Pending_Request_Count = Integer.parseInt(Total_num);
 				System.out.println(Current_Pending_Request_Count);

 				//------------------Pending Task Count-----------------------------//
 				WebElement Pending_tasks = driver.findElement(XNARF_Task_Obj.pending_task);
 				String Pending_task_Count = Pending_tasks.getText();
 				String Total_num1=Pending_task_Count.replaceAll("[^0-9]", "");
 				int Current_Pending_task_Count = Integer.parseInt(Total_num1);
 				System.out.println(Current_Pending_task_Count);

 				//-------------------Pending WP Count-----------------------------//
 				WebElement WP = driver.findElement(XNARF_Task_Obj.pending_wp_count);
 				String WP_Count = WP.getText();
 				String Total_num2=WP_Count.replaceAll("[^0-9]", "");
 				int Current_WP_Count = Integer.parseInt(Total_num2);
 				System.out.println(Current_WP_Count);

 				//for completed tasks
 				WebElement completed_tasks = driver.findElement(XNARF_Task_Obj.completed_task);
 				String completed_tasks_Count = completed_tasks.getText();
 				String Total_num3=completed_tasks_Count.replaceAll("[^0-9]", "");
 				int Current_completed_tasks_Count = Integer.parseInt(Total_num3);
 				System.out.println(Current_completed_tasks_Count);

 				//for completed requests
 				WebElement completed_request = driver.findElement(XNARF_Task_Obj.completed_request);
 				String completed_request_Count = completed_request.getText();
 				String Total_num4=completed_request_Count.replaceAll("[^0-9]", "");
 				int Current_completed_request_Count = Integer.parseInt(Total_num4);
 				System.out.println(Current_completed_request_Count);

 				//Click on Complete
 				WebElement Complete_Button=driver.findElement(XNARF_Task_Obj.Complete_Button);
 				Complete_Button.click();
 				gm.logPass(logger, "Clicked on Complete Button",driver);
 				Thread.sleep(3000);

 				//Verify message
 				if(driver.findElements(By.xpath("html/body/div[contains(@class,'bootbox modal fade bootbox-alert in')]/div/div/div[1]/div")).size()!=0)
 				{
 					WebElement Phone_Msg= driver.findElement(By.xpath("html/body/div[contains(@class,'bootbox modal fade bootbox-alert in')]/div/div/div[1]/div"));
 					String Successmsg1=Phone_Msg.getText();

 					if(Successmsg1.contains("Saved Successfully"))
 					{
 						gm.logPass(logger, "Complete action pass",driver);

 						//Click on Ok
 						WebElement message_ok=driver.findElement(XNARF_Task_Obj.message_ok);
 						message_ok.click();

 						if(driver.findElements(By.xpath(".//*[@id='fixTable']/tbody/tr[1]/td[24]")).size()!=0) 
 						{
 							WebElement Phone_Msg2= driver.findElement(By.xpath(".//*[@id='fixTable']/tbody/tr[1]/td[24]"));
 							String Successmsg2=Phone_Msg2.getText();
 							if(Successmsg2.contains("Completed"))
 							{
 								gm.logPass(logger, "Records status has been changed to Completed successfully",driver);
 							}
 							else {
 								gm.logFail(logger, "Records status has not been changed to Completed successfully, Displying following: "+Successmsg2,driver);
 							}
 						}

 						else {
 							//-----------------------Verify count----------------------//
 							//----------------------New Pending Request count---------------------//
 							WebElement New_Pending_Request = driver.findElement(XNARF_Task_Obj.pending_request);
 							String New_Pending_Request_Count = New_Pending_Request.getText();
 							String New_Total_num=New_Pending_Request_Count.replaceAll("[^0-9]", "");
 							int New_Current_Pending_Request_Count = Integer.parseInt(New_Total_num);
 							System.out.println(New_Current_Pending_Request_Count);

 							//------------------New Pending Task Count-----------------------------//
 							WebElement New_Pending_tasks = driver.findElement(XNARF_Task_Obj.pending_task);
 							String New_Pending_task_Count = New_Pending_tasks.getText();
 							String New_Total_num1=New_Pending_task_Count.replaceAll("[^0-9]", "");
 							int New_Current_Pending_task_Count = Integer.parseInt(New_Total_num1);
 							System.out.println(New_Current_Pending_task_Count);

 							//-------------------New Pending WP Count-----------------------------//
 							WebElement New_WP = driver.findElement(XNARF_Task_Obj.pending_wp_count);
 							String New_WP_Count = New_WP.getText();
 							String New_Total_num2=New_WP_Count.replaceAll("[^0-9]", "");
 							int New_Current_WP_Count = Integer.parseInt(New_Total_num2);
 							System.out.println(New_Current_WP_Count);

 							//for completed tasks
 							WebElement New_completed_tasks = driver.findElement(XNARF_Task_Obj.completed_task);
 							String New_completed_tasks_Count = New_completed_tasks.getText();
 							String New_Total_num3=New_completed_tasks_Count.replaceAll("[^0-9]", "");
 							int New_Current_completed_tasks_Count = Integer.parseInt(New_Total_num3);
 							System.out.println(New_Current_completed_tasks_Count);

 							//for completed requests
 							WebElement New_completed_request = driver.findElement(XNARF_Task_Obj.completed_request);
 							String New_completed_request_Count = New_completed_request.getText();
 							String New_Total_num4=New_completed_request_Count.replaceAll("[^0-9]", "");
 							int New_Current_completed_request_Count = Integer.parseInt(New_Total_num4);
 							System.out.println(New_Current_completed_request_Count);

 							if((Current_Pending_Request_Count-1)==New_Current_Pending_Request_Count)
 							{
 								gm.logPass(logger, "Pending Request count pass", driver);
 							}
 							else {
 								gm.logFail(logger, "Pending Request count FAIL", driver);
 							}

 							if((Current_Pending_task_Count-1)==New_Current_Pending_task_Count)
 							{
 								gm.logPass(logger, "Pending Task count Pass", driver);
 							}
 							else {
 								gm.logFail(logger, "Pending Task count FAIL", driver);
 							}
 							if((Current_WP_Count-1)==New_Current_WP_Count)
 							{
 								gm.logPass(logger, "Pending WP count pass", driver);
 							}
 							else {
 								gm.logFail(logger, "Pending WP count Fail", driver);
 							}
 							if((Current_completed_tasks_Count-1)==New_Current_completed_tasks_Count)
 							{
 								gm.logPass(logger, "Pending Completed Task count pass", driver);
 							}
 							else {
 								gm.logFail(logger, "Pending Completed Task count Fail", driver);
 							}
 							if((Current_completed_request_Count-1)==New_Current_completed_request_Count)
 							{
 								gm.logPass(logger, "Pending Completed Request count pass", driver);
 							}
 							else {
 								gm.logFail(logger, "Pending Completed Request count Fail", driver);
 							}
 						}
 					}

 					else {
 						gm.logFail(logger, "Complete action Fail",driver);

 						//Click on Ok
 						WebElement message_ok=driver.findElement(XNARF_Task_Obj.message_ok);
 						message_ok.click();
 					}
 				}

 				else if(driver.findElements(By.xpath("html/body/div[4]/div/div/div[1]/div")).size()!=0)
 				{
 					WebElement Phone_Msg= driver.findElement(By.xpath("html/body/div[4]/div/div/div[1]/div"));
 					String Successmsg1=Phone_Msg.getText();

 					if(Successmsg1.contains("Few Requests are already completed.Kindly select only pending requests. Following Request(s) are Completed"))
 					{
 						gm.logPass(logger, "Displaying few selected Records are already completed.",driver);

 						//Click on Ok
 						WebElement message_ok=driver.findElement(XNARF_Task_Obj.message_ok);
 						message_ok.click();
 					}
 					else {
 						gm.logFail(logger, "Showing wrong message when few of the selected records are already completed",driver);

 						//Click on Ok
 						WebElement message_ok=driver.findElement(XNARF_Task_Obj.message_ok);
 						message_ok.click();
 					}
 				}
 				else {
 					gm.logFail(logger, "Complete Action Fail",driver);
 				}

 			}

 			catch(Exception e)
 			{
 				gm.logfail(logger, "Exception occured:"+e.getMessage());
 			}
 		}
 		//Task Workflow MultiSelect and Complete
 		public static void multiselect_complete(WebDriver driver,ExtentTest logger)
 		{
 			try {

 				WebElement EmployeeId_filter= driver.findElement(XNARF_Task_Obj.EmployeeId_filter);
 				EmployeeId_filter.clear();

 				//Click on enter
 				driver.findElement(By.id("4")).sendKeys(Keys.RETURN);
 				Thread.sleep(1000);

 				//Click on Select All
 				WebElement Select_All=driver.findElement(XNARF_Task_Obj.Select_All);
 				Select_All.click();
 				gm.logPass(logger, "Clicked on Select All check box",driver);


 				//----------------------Pending Request count---------------------//
 				WebElement Pending_Request = driver.findElement(XNARF_Task_Obj.pending_request);
 				String Pending_Request_Count = Pending_Request.getText();
 				String Total_num=Pending_Request_Count.replaceAll("[^0-9]", "");
 				int Current_Pending_Request_Count = Integer.parseInt(Total_num);
 				System.out.println(Current_Pending_Request_Count);

 				//------------------Pending Task Count-----------------------------//
 				WebElement Pending_tasks = driver.findElement(XNARF_Task_Obj.pending_task);
 				String Pending_task_Count = Pending_tasks.getText();
 				String Total_num1=Pending_task_Count.replaceAll("[^0-9]", "");
 				int Current_Pending_task_Count = Integer.parseInt(Total_num1);
 				System.out.println(Current_Pending_task_Count);

 				//-------------------Pending WP Count-----------------------------//
 				WebElement WP = driver.findElement(XNARF_Task_Obj.pending_wp_count);
 				String WP_Count = WP.getText();
 				String Total_num2=WP_Count.replaceAll("[^0-9]", "");
 				int Current_WP_Count = Integer.parseInt(Total_num2);
 				System.out.println(Current_WP_Count);

 				//for completed tasks
 				WebElement completed_tasks = driver.findElement(XNARF_Task_Obj.completed_task);
 				String completed_tasks_Count = completed_tasks.getText();
 				String Total_num3=completed_tasks_Count.replaceAll("[^0-9]", "");
 				int Current_completed_tasks_Count = Integer.parseInt(Total_num3);
 				System.out.println(Current_completed_tasks_Count);

 				//for completed requests
 				WebElement completed_request = driver.findElement(XNARF_Task_Obj.completed_request);
 				String completed_request_Count = completed_request.getText();
 				String Total_num4=completed_request_Count.replaceAll("[^0-9]", "");
 				int Current_completed_request_Count = Integer.parseInt(Total_num4);
 				System.out.println(Current_completed_request_Count);


 				//Click on Complete
 				WebElement Complete_Button=driver.findElement(XNARF_Task_Obj.Complete_Button);
 				Complete_Button.click();
 				gm.logPass(logger, "Clicked on Complete Button",driver);
 				Thread.sleep(3000); 

 				//Verify message
 				if(driver.findElements(By.xpath("html/body/div[contains(@class,'bootbox modal fade bootbox-alert in')]/div/div/div[1]/div")).size()!=0)
 				{
 					WebElement Phone_Msg= driver.findElement(By.xpath("html/body/div[contains(@class,'bootbox modal fade bootbox-alert in')]/div/div/div[1]/div"));
 					String Successmsg1=Phone_Msg.getText();
 					System.out.println(Successmsg1);

 					if(Successmsg1.contains("Saved successfully"))
 					{
 						gm.logPass(logger, "Complete action pass",driver);

 						//Click on Ok
 						WebElement message_ok=driver.findElement(XNARF_Task_Obj.message_ok);
 						message_ok.click();
 						Thread.sleep(3000); 


 						//-----------------------Verify count----------------------//
 						//----------------------New Pending Request count---------------------//
 						WebElement New_Pending_Request = driver.findElement(XNARF_Task_Obj.pending_request);
 						String New_Pending_Request_Count = New_Pending_Request.getText();
 						String New_Total_num=New_Pending_Request_Count.replaceAll("[^0-9]", "");
 						int New_Current_Pending_Request_Count = Integer.parseInt(New_Total_num);
 						System.out.println(New_Current_Pending_Request_Count);

 						//------------------New Pending Task Count-----------------------------//
 						WebElement New_Pending_tasks = driver.findElement(XNARF_Task_Obj.pending_task);
 						String New_Pending_task_Count = New_Pending_tasks.getText();
 						String New_Total_num1=New_Pending_task_Count.replaceAll("[^0-9]", "");
 						int New_Current_Pending_task_Count = Integer.parseInt(New_Total_num1);
 						System.out.println(New_Current_Pending_task_Count);

 						//-------------------New Pending WP Count-----------------------------//
 						WebElement New_WP = driver.findElement(XNARF_Task_Obj.pending_wp_count);
 						String New_WP_Count = New_WP.getText();
 						String New_Total_num2=New_WP_Count.replaceAll("[^0-9]", "");
 						int New_Current_WP_Count = Integer.parseInt(New_Total_num2);
 						System.out.println(New_Current_WP_Count);

 						//for completed tasks
 						WebElement New_completed_tasks = driver.findElement(XNARF_Task_Obj.completed_task);
 						String New_completed_tasks_Count = New_completed_tasks.getText();
 						String New_Total_num3=New_completed_tasks_Count.replaceAll("[^0-9]", "");
 						int New_Current_completed_tasks_Count = Integer.parseInt(New_Total_num3);
 						System.out.println(New_Current_completed_tasks_Count);

 						//for completed requests
 						WebElement New_completed_request = driver.findElement(XNARF_Task_Obj.completed_request);
 						String New_completed_request_Count = New_completed_request.getText();
 						String New_Total_num4=New_completed_request_Count.replaceAll("[^0-9]", "");
 						int New_Current_completed_request_Count = Integer.parseInt(New_Total_num4);
 						System.out.println(New_Current_completed_request_Count);

 						if((Current_Pending_Request_Count-1)==New_Current_Pending_Request_Count)
 						{
 							gm.logPass(logger, "Pending Request count pass", driver);
 						}
 						else {
 							gm.logFail(logger, "Pending Request count FAIL", driver);
 						}

 						if((Current_Pending_task_Count-1)==New_Current_Pending_task_Count)
 						{
 							gm.logPass(logger, "Pending Task count Pass", driver);
 						}
 						else {
 							gm.logFail(logger, "Pending Task count FAIL", driver);
 						}
 						if((Current_WP_Count-1)==New_Current_WP_Count)
 						{
 							gm.logPass(logger, "Pending WP count pass", driver);
 						}
 						else {
 							gm.logFail(logger, "Pending WP count Fail", driver);
 						}
 						if((Current_completed_tasks_Count+1)==New_Current_completed_tasks_Count)
 						{
 							gm.logPass(logger, "Pending Completed Task count pass", driver);
 						}
 						else {
 							gm.logFail(logger, "Pending Completed Task count Fail", driver);
 						}
 						if((Current_completed_request_Count+1)==New_Current_completed_request_Count)
 						{
 							gm.logPass(logger, "Pending Completed Request count pass", driver);
 						}
 						else {
 							gm.logFail(logger, "Pending Completed Request count Fail", driver);
 						}
 					}

 					else {
 						gm.logFail(logger, "Complete action Fail",driver);

 						//Click on Ok
 						WebElement message_ok=driver.findElement(XNARF_Task_Obj.message_ok);
 						message_ok.click();
 					}
 				}

 				else if(driver.findElements(By.xpath("html/body/div[4]/div/div/div[1]/div")).size()!=0)
 				{
 					WebElement Phone_Msg= driver.findElement(By.xpath("html/body/div[4]/div/div/div[1]/div"));
 					String Successmsg1=Phone_Msg.getText();

 					if(Successmsg1.contains("Few Requests are already completed.Kindly select only pending requests. Following Request(s) are Completed"))
 					{
 						gm.logPass(logger, "Displaying few selected Records are already completed.",driver);

 						//Click on Ok
 						WebElement message_ok=driver.findElement(XNARF_Task_Obj.message_ok);
 						message_ok.click();
 					}
 					else {
 						gm.logFail(logger, "Showing wrong message when few of the selected records are already completed",driver);

 						//Click on Ok
 						WebElement message_ok=driver.findElement(XNARF_Task_Obj.message_ok);
 						message_ok.click();
 					}
 				}
 				else {
 					gm.logFail(logger, "Complete Action Fail",driver);
 				}

 			}
 			catch(Exception e)
 			{
 				gm.logfail(logger, "Exception occured:"+e.getMessage());
 			}
 		}

 		//Task Workflow Select and split
 		public static void select_split(WebDriver driver,String Sap_id,ExtentTest logger)
 		{
 			try {

 				WebElement EmployeeId_filter= driver.findElement(XNARF_Task_Obj.EmployeeId_filter);
 				EmployeeId_filter.clear();

 				//Employee ID Filter
 				gm.enterText(driver, XNARF_Task_Obj.EmployeeId_filter, Sap_id, "Sap_id", logger);

 				//Click on enter
 				driver.findElement(By.id("4")).sendKeys(Keys.RETURN);
 				Thread.sleep(1000);

 				//----------------------Pending Request count---------------------//
 				WebElement Pending_Request = driver.findElement(XNARF_Task_Obj.pending_request);
 				String Pending_Request_Count = Pending_Request.getText();
 				System.out.println(Pending_Request_Count);
 				String Total_num=Pending_Request_Count.replaceAll("[^0-9]", "");
 				int Current_Pending_Request_Count = Integer.parseInt(Total_num);
 				System.out.println(Current_Pending_Request_Count);

 				//------------------Pending Task Count-----------------------------//
 				WebElement Pending_tasks = driver.findElement(XNARF_Task_Obj.pending_task);
 				String Pending_task_Count = Pending_tasks.getText();
 				System.out.println(Pending_task_Count);
 				String Total_num1=Pending_task_Count.replaceAll("[^0-9]", "");
 				int Current_Pending_task_Count = Integer.parseInt(Total_num1);
 				System.out.println(Current_Pending_task_Count);

 				//-------------------Pending WP Count-----------------------------//
 				WebElement WP = driver.findElement(XNARF_Task_Obj.pending_wp_count);
 				String WP_Count = WP.getText();
 				System.out.println(WP_Count);
 				String Total_num2=WP_Count.replaceAll("[^0-9]", "");
 				int Current_WP_Count = Integer.parseInt(Total_num2);
 				System.out.println(Current_WP_Count);

 				//Select the check box
 				WebElement Select_Single=driver.findElement(XNARF_Task_Obj.Select_Single);
 				Select_Single.click();
 				gm.logPass(logger, "We have selected the required record to Split.",driver);

 				//Click on Split
 				WebElement Split_Button=driver.findElement(XNARF_Task_Obj.Split_Button);
 				Split_Button.click();
 				gm.logPass(logger, "Clicked on Split Button",driver);

 				//Verify message

 				if(driver.findElements(By.xpath("html/body/div[contains(@class,'bootbox modal fade bootbox-confirm in')]/div/div/div[1]/div")).size()!=0)
 				{
 					WebElement Phone_Msg= driver.findElement(By.xpath("html/body/div[contains(@class,'bootbox modal fade bootbox-confirm in')]/div/div/div[1]/div"));
 					String Successmsg1=Phone_Msg.getText();

 					if(Successmsg1.contains("Selected records are ready for Split"))
 					{
 						gm.logPass(logger, "Split action pass",driver);

 						//Click on Ok
 						WebElement message_ok=driver.findElement(By.xpath("html/body/div/div/div/div[2]/button[2]"));
 						message_ok.click();
 					}
 					else {
 						gm.logFail(logger, "Split action Fail",driver);

 						//Click on Ok
 						WebElement message_ok=driver.findElement(By.xpath("html/body/div/div/div/div[2]/button[2]"));
 						message_ok.click();
 					}
 				}
 				else {
 					gm.logFail(logger, "Split Action Fail",driver);

 				}
 				Thread.sleep(3000);
 				//-----------------------Verify count----------------------//
 				//----------------------New Pending Request count---------------------//
 				WebElement New_Pending_Request = driver.findElement(XNARF_Task_Obj.pending_request);
 				String New_Pending_Request_Count = New_Pending_Request.getText();
 				String New_Total_num=New_Pending_Request_Count.replaceAll("[^0-9]", "");
 				int New_Current_Pending_Request_Count = Integer.parseInt(New_Total_num);
 				System.out.println(New_Current_Pending_Request_Count);

 				//------------------New Pending Task Count-----------------------------//
 				WebElement New_Pending_tasks = driver.findElement(XNARF_Task_Obj.pending_task);
 				String New_Pending_task_Count = New_Pending_tasks.getText();
 				String New_Total_num1=New_Pending_task_Count.replaceAll("[^0-9]", "");
 				int New_Current_Pending_task_Count = Integer.parseInt(New_Total_num1);
 				System.out.println(New_Current_Pending_task_Count);

 				//-------------------New Pending WP Count-----------------------------//
 				WebElement New_WP = driver.findElement(XNARF_Task_Obj.pending_wp_count);
 				String New_WP_Count = New_WP.getText();
 				String New_Total_num2=New_WP_Count.replaceAll("[^0-9]", "");
 				int New_Current_WP_Count = Integer.parseInt(New_Total_num2);
 				System.out.println(New_Current_WP_Count);

 				if((Current_Pending_Request_Count+1)==New_Current_Pending_Request_Count)
 				{
 					gm.logPass(logger, "Pending Request count pass", driver);
 				}
 				else {
 					gm.logFail(logger, "Pending Request count FAIL", driver);
 				}

 				if((Current_Pending_task_Count+1)==New_Current_Pending_task_Count)
 				{
 					gm.logPass(logger, "Pending Task count Pass", driver);
 				}
 				else {
 					gm.logFail(logger, "Pending Task count FAIL", driver);
 				}
 				if((Current_WP_Count+1)==New_Current_WP_Count)
 				{
 					gm.logPass(logger, "Pending WP count pass", driver);
 				}
 				else {
 					gm.logFail(logger, "Pending WP count Fail", driver);
 				}

 			}
 			catch(Exception e)
 			{
 				gm.logfail(logger, "Exception occured:"+e.getMessage());
 			}
 		}
 		
 		//-----------------------------project details-------------------------------------
 		public void TimeCardDatePicker1(String date) throws Exception{

 			try
 			{
 				//DAte and Time to be set in textbox
 				String dateTime = date;     

 				//Split the date time to get only the date part
 				String date_dd_MM_yyyy[] = dateTime.split("/");
 				
 				System.out.println(date_dd_MM_yyyy[0]);
 				System.out.println(date_dd_MM_yyyy[1]);
 				System.out.println(date_dd_MM_yyyy[2]);
 				
 				//get the year difference between current year and year to set in calendar
 				int yearDiff = Integer.parseInt(date_dd_MM_yyyy[2])- Calendar.getInstance().get(Calendar.YEAR);
 				WebElement current_month = driver.findElement(Project_Deatils_Obj.cntr_mnth);
 				current_month.click(); 


 				if(yearDiff!=0){

 					//if you have to move next year

 					if(yearDiff>0){

 						for(int i=0;i< yearDiff;i++){

 							System.out.println("Year Diff->"+i);

 							WebElement nxt_yr = driver.findElement(Project_Deatils_Obj.nxt_yr);
 							nxt_yr.click();


 						}

 					}

 					//if you have to move previous year

 					else if(yearDiff<0){

 						for(int i=0;i< (yearDiff*(-1));i++){

 							System.out.println("Year Diff->"+i);

 							WebElement prev_yr = driver.findElement(Project_Deatils_Obj.prev_yr);
 							prev_yr.click();
 						}

 					}

 				}

 				Thread.sleep(1000);

 				//Get all months from calendar to select correct one

 				List<WebElement> list_AllMonthToBook = driver.findElements(Project_Deatils_Obj.month_table);

 				list_AllMonthToBook.get(Integer.parseInt(date_dd_MM_yyyy[0])-1).click();

 				Thread.sleep(1000);
 				
 				//select todays date
 				WebElement Required_Date = driver.findElement(By.xpath("html/body/div[3]/div[1]/table/tbody/tr/td[not((contains(@class,'old '))or (contains(@class,'new ')))][text()='"+date_dd_MM_yyyy[1]+"']"));
 				Required_Date.click();

 				//get all dates from calendar to select correct one
 				
 				/*String toDay;
 				WebElement FromDateLeaveCode = driver.findElement(By.xpath("html/body/div[4]/div[1]/table/tbody/tr/td[contains(@class,'today day')]"));
 				toDay=FromDateLeaveCode.getText();
 				System.out.println(toDay);
 				Thread.sleep(1000);
 				
 				if(toDay.equalsIgnoreCase(date_dd_MM_yyyy[1])) {
 					System.out.println("date is already selected");
 				}
 				else {

 				List<WebElement> list_AllDateToBook = driver.findElements(Leave_Request_Obj.date_table);

 				list_AllDateToBook.get(Integer.parseInt(date_dd_MM_yyyy[1])-1).click();

 			}*/
 			}
 			catch(Exception e)
 			{
 				gm.logfail(logger, "Exception occured:"+e.getMessage());
 			}
 		}
}
 	