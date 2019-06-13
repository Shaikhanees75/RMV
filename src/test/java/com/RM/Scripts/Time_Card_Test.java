package com.RM.Scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.RM.Generic.GenericMethods2;
import com.RM.Generic.common_methods;
import com.RM.POM.Time_card_obj;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Time_Card_Test {
	
	static WebDriver driver ;
	static GenericMethods2 gm = new GenericMethods2();
	common_methods cm = new common_methods();
	static ExtentReports reports ;
	static ExtentTest logger;
	
	//Go To Time Card
	public static void go_to_time_card(WebDriver driver, ExtentTest logger) throws Exception 
	{
		try
		{	
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			//hover on Resource Planner
			WebElement ResourcePlanner= driver.findElement(Time_card_obj.resource_planner);
			Actions action = new Actions(driver);
			action.moveToElement(ResourcePlanner).build().perform();
			gm.logInfo(logger, "We have hovered over Resource Planner Menu");

			// Click on My Time Card
			WebElement my_time_card=driver.findElement(Time_card_obj.my_time_card);
			my_time_card.click();
			gm.logInfo(logger, "We have clicked on My Time Card tab");
			Thread.sleep(5000);	

		}

		catch(Exception e)
		{
			gm.logFail(logger, "Exception occured:"+e.getMessage(),driver);
		}

	}
	
	public void Add_Time_Card(WebDriver driver,String Date, String Sub_Activity,String StartTime,String EndTime,String SearchTime,ExtentTest logger) throws Exception 
	{
		try
		{
			
			if(Date.equalsIgnoreCase("Null"))
			{
				gm.logInfo(logger, "Adding time card data for the same date");
			}
			
			else
			{
			//Click on date calendar
			WebElement todate = driver.findElement(Time_card_obj.date);
			todate.click();
			gm.logInfo(logger, "We have clicked on date calendar.");

			//Select to date
			cm.TimeCardDatePicker(Date);
			gm.logInfo(logger, "We have selected the required to date: "+Date);
			
			
			//click on go
			WebElement go = driver.findElement(Time_card_obj.go_btn);
			go.click();
			gm.logInfo(logger, "We have clicked on go button");
			}
			//-------
			//Click on  Add new time card			
			WebElement AddTimeCard = driver.findElement(Time_card_obj.add_entry);
			AddTimeCard.click();
			gm.logInfo(logger, "We have clicked on Add Time Card button");
			
			if(Sub_Activity.equalsIgnoreCase("Null"))
			{
				gm.logInfo(logger, "Selecting parent activity");
				
			}
			else
			{
				//Select Sub-Activity from dropdown
				gm.selectValueFromListByText(driver, Time_card_obj.Sub_activity, Sub_Activity, "Sub_Activity", logger);
				gm.logInfo(logger, "Activity Type Selected: "+ Sub_Activity);
			}
			//-------		
			//Clear existing time
			WebElement start_time= driver.findElement(Time_card_obj.srt_time);
			start_time.clear();

			//Enter required start time
			gm.enterText(driver,Time_card_obj.srt_time , StartTime, "StartTime", logger);
			gm.logInfo(logger, "Time card start time is: "+ StartTime);

			//Clear Existing end time
			WebElement End_time= driver.findElement(Time_card_obj.end_time);
			End_time.clear();

			//Enter required end time
			gm.enterText(driver,Time_card_obj.end_time , EndTime, "EndTime", logger);
			gm.logInfo(logger, "Time card end time is: "+ EndTime);

			//Click on Submit Button
			WebElement Submit = driver.findElement(Time_card_obj.submit_btn);
			Submit.click();
			gm.logInfo(logger, "We have clicked on Submit button: ");
			Thread.sleep(5000);
			
			String SubmitLblMsg;
			String ErrorLblMsg = null;
			if(driver.findElements(By.xpath("/html/body/div[2]/div/div/div[1]/div")).size()!= 0)
			{
			//capture pop up msg
			WebElement SubmitMsg= driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div"));
			SubmitLblMsg = SubmitMsg.getText();
			System.out.println(SubmitLblMsg);
			//take screenshot		
			gm.logPass(logger, "Time card pop up msg",driver);
			gm.logInfo(logger, "Screenshot taken for pop up msg");
			
			WebElement Ok_Button = driver.findElement(Time_card_obj.ok_btn);
			Ok_Button.click();
			gm.logInfo(logger, "We have clicked on Ok button");
			Thread.sleep(2000);	
			}
			else if(driver.findElements(By.xpath("/html/body/div[3]/div/div/div[1]/div/p")).size()!= 0)
			{
				//capture pop up msg
				WebElement ErrorMsg= driver.findElement(By.xpath("/html/body/div[3]/div/div/div[1]/div/p"));
				ErrorLblMsg = ErrorMsg.getText();
				System.out.println(ErrorLblMsg);
				//take screenshot		
				gm.logPass(logger, "Time card pop up msg",driver);
				gm.logInfo(logger, "Screenshot taken for pop up msg");
				
				WebElement Ok_Button = driver.findElement(Time_card_obj.ok_btn);
				Ok_Button.click();
				gm.logInfo(logger, "We have clicked on Ok button");
				Thread.sleep(2000);
		
			 
				//Click on cancel button
				WebElement Cancel_btn = driver.findElement(By.xpath(".//*[@id='SingleEntry']/div/div/div[3]/button[2]"));
				Cancel_btn.click();
				gm.logInfo(logger, "We have Clicked on Cancel button");
			}
			//------
			Thread.sleep(5000);
			//take screenshot		
			gm.logPass(logger, "Time card pop up msg",driver);
			gm.logInfo(logger, "Screenshot taken for pop up msg");
			Thread.sleep(2000);
			//Click on Save button
			
				WebElement Save_button = driver.findElement(Time_card_obj.save);
				Save_button.click();
				gm.logInfo(logger, "We have clicked on Save button: ");
				Thread.sleep(2000);
				WebElement Success = driver.findElement(By.xpath("//*[@id='alertsection']/div/strong"));
				String SuccessLblMsg = Success.getText();
				System.out.println(SuccessLblMsg);
				gm.logPass(logger, "Time card for date:" +Date +" was created successfully" , driver);
		
		if(ErrorLblMsg.contains("End Time must be greater than Start Time."))
		{
				gm.logFail(logger,"Start time entered is greater than End time" , driver);
				//html/body/div[3]/div/div/div[1]/div/p
				//html/body/div[3]/div/div/div[1]/div/p
				//html/body/div[2]/div/div/div[1]/div
		}
		else if(ErrorLblMsg.contains("Sub-activity Start Time and End time cannot be overlapped!"))
		{
			gm.logFail(logger, "The time entered overlaps two subactivities, Kindly enter a correct instance", driver);
		}
		
		}
		catch(Exception e)
		{
			gm.logFail(logger, "Exception occured:"+e.getMessage(),driver);
		}
	
	}
	
	public void Edit_Time_Card(WebDriver driver,String Date, String Sub_Activity,String StartTime,String EndTime,String SearchTime,ExtentTest logger) throws Exception 
	{
		try
		{	

			if(Date.equalsIgnoreCase("Null"))
			{
				gm.logInfo(logger, "Editing time card data for the same date" +Date);
			}
			
			else
			{
			//Click on date calendar
			WebElement todate = driver.findElement(Time_card_obj.date);
			todate.click();
			gm.logInfo(logger, "We have clicked on date calendar.");

			//Select to date
			cm.TimeCardDatePicker(Date);
			gm.logInfo(logger, "We have selected the required to date: "+Date);
			
			
			//click on go
			WebElement go = driver.findElement(Time_card_obj.go_btn);
			go.click();
			gm.logInfo(logger, "We have clicked on go button");
			}
			
			gm.logInfo(logger, "We are about to edit time card for date :" +Date, driver);
			
			WebElement Edit_btn = driver.findElement(Time_card_obj.edit_btn);
			Edit_btn.click();
			gm.logInfo(logger, "We have clicked on Edit button: ");
			
			//Clear existing time
			WebElement start_time= driver.findElement(Time_card_obj.srt_time);
			start_time.clear();

			//Enter required start time
			gm.enterText(driver,Time_card_obj.srt_time , StartTime, "StartTime", logger);
			gm.logInfo(logger, "Time card start time is: "+ StartTime);

			//Clear Existing end time
			WebElement End_time= driver.findElement(Time_card_obj.end_time);
			End_time.clear();

			//Enter required end time
			gm.enterText(driver,Time_card_obj.end_time , EndTime, "EndTime", logger);
			gm.logInfo(logger, "Time card end time is: "+ EndTime);

			//Click on Submit Button
			WebElement Submit = driver.findElement(Time_card_obj.submit_btn);
			Submit.click();
			gm.logInfo(logger, "We have clicked on Submit button: ");
			Thread.sleep(1000);	
			
			//Click on save button
			WebElement Save_button = driver.findElement(Time_card_obj.save);
			Save_button.click();
			gm.logInfo(logger, "We have clicked on Save button: ");
			Thread.sleep(2000);
			
			WebElement Success = driver.findElement(By.xpath("//*[@id='alertsection']/div/strong"));
			String SuccessLblMsg = Success.getText();
			System.out.println(SuccessLblMsg);
			
			if (SuccessLblMsg.contains("Valid Time Card! Record Saved Successfully."))
			{
			gm.logPass(logger, "Time card for date:" +Date +" was edited successfully" , driver);
			}
			else
			{
				gm.logInfo(logger, "SUB Activity Start Time and End Time cannot be Overlap form Parent Activity. Deleting this entry", driver);
				//Click on delete button
				WebElement Delete_Button = driver.findElement(Time_card_obj.delete_btn);
				Delete_Button.click();
				gm.logInfo(logger, "We have clicked on delete button", driver);
				
		//Click on confirm delete button
				
				WebElement Confirm_Button = driver.findElement(Time_card_obj.cnf_del_btn);
				Confirm_Button.click();
				gm.logInfo(logger, "The required time card for date :" +Date + "has been deleted", driver);
				
				//Click on save button
				WebElement Save_button1 = driver.findElement(Time_card_obj.save);
				Save_button1.click();
				gm.logInfo(logger, "We have clicked on Save button: ");
			}
		}
		catch(Exception e)
		{
			gm.logFail(logger, "Exception occured:"+e.getMessage(),driver);
		}
	}
		
	public void Delete_Time_Card(WebDriver driver,String Date, String Sub_Activity,String StartTime,String EndTime,String SearchTime,ExtentTest logger) throws Exception 
			{
				try
				{	
					
					if(Date.equalsIgnoreCase("Null"))
					{
						gm.logInfo(logger, "Deleting time card data for the same date");
					}
					
					else
					{
					//Click on date calendar
					WebElement todate = driver.findElement(Time_card_obj.date);
					todate.click();
					gm.logInfo(logger, "We have clicked on date calendar.");

					//Select to date
					cm.TimeCardDatePicker(Date);
					gm.logInfo(logger, "We have selected the required to date: "+Date);
					
					
					//click on go
					WebElement go = driver.findElement(Time_card_obj.go_btn);
					go.click();
					gm.logInfo(logger, "We have clicked on go button");
					}
					
					if(driver.findElements(By.xpath("//*[@id='profileaccessRS']/table/tbody/tr/td[4][text()='"+Sub_Activity+"']/../td[5][text()='"+SearchTime+"']")).size() != 0)
					{	
						//Click on delete button
						WebElement Delete_Button = driver.findElement(By.xpath("//*[@id='profileaccessRS']/table/tbody/tr/td[4][text()='"+Sub_Activity+"']/../td[5][text()='"+SearchTime+"']/../td/a[2]"));
						Delete_Button.click();//*[@id="profileaccessRS"]/table/tbody/tr[2]/td[5]
						gm.logInfo(logger, "We have clicked on delete button", driver);
										
					}
					else
					{
					//Click on delete button
					WebElement Delete_Button = driver.findElement(Time_card_obj.delete_btn);
					Delete_Button.click();
					gm.logInfo(logger, "We have clicked on delete button", driver);
					}
			//Click on confirm delete button
					
					WebElement Confirm_Button = driver.findElement(Time_card_obj.cnf_del_btn);
					Confirm_Button.click();
					gm.logInfo(logger, "The required time card for date :" +Date + "has been deleted", driver);
					
					//Click on save button
					WebElement Save_button = driver.findElement(Time_card_obj.save);
					Save_button.click();
					gm.logInfo(logger, "We have clicked on Save button: ");
					Thread.sleep(2000);			
			gm.logPass(logger, "All Scenarios are covered");
		}
		catch(Exception e)
		{
			gm.logFail(logger, "Exception occured:"+e.getMessage(),driver);
		}
	
	}
	
}



