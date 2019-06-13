package com.RM.Scripts;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.RM.Generic.GenericMethods2;
import com.RM.Generic.common_methods;
import com.RM.POM.XNARF_Task_Obj;
import com.relevantcodes.extentreports.ExtentTest;

public class XNARF_CS_Script {
	static WebDriver driver ;

	GenericMethods2 gm = new GenericMethods2();
	common_methods cm = new common_methods();
	static String exp_err_msg="Error!Please select a value from: Client,Operation Category,Fixed Schedule Name,Office Location,Employment Status,Designation,Level,Department,Organization,Reporting Manager,Seat Number";
	public static ArrayList<String > actual=new ArrayList<String > ();
	static String Success_msg="Success! Employee Created Successfully.";
	ExtentTest logger; 

	public void Main_Screen_Mandatory_Check(WebDriver driver,ExtentTest logger)
	{
		try
		{
			//--------------------Complete Click Mandatory Check--------------------------------//
			//Click on Complete
			WebElement Complete_Button=driver.findElement(XNARF_Task_Obj.Complete_Button);
			Complete_Button.click();
			gm.logPass(logger, "Clicked on Complete Button",driver);
			Thread.sleep(3000);


			//Verify message
			if(driver.findElements(By.xpath("html/body/div[contains(@class,'bootbox modal fade bootbox-alert in')]/div/div/div[1]/div")).size()!=0)
			{
				gm.logPass(logger, "Complete Mandatory Check Pass",driver);
				WebElement Phone_Msg= driver.findElement(By.xpath("html/body/div[contains(@class,'bootbox modal fade bootbox-alert in')]/div/div/div[1]/div"));
				String Successmsg1=Phone_Msg.getText();

				if(Successmsg1.contains("Details are not entered for"))
				{
					gm.logPass(logger, "Showing the Records to be saved mandatory",driver);					
				}				
				else
				{
					gm.logFail(logger, "Showing wrong mandatory message",driver);
				}

				//Click on Ok
				WebElement message_ok=driver.findElement(XNARF_Task_Obj.message_ok);
				message_ok.click();
			}			
			else
			{
				gm.logFail(logger, "Mandatory Check Fail",driver);
			}


			//---------------------Split Mandatory Check----------------------------------------//
			//Click on Split
			WebElement Split_Button=driver.findElement(XNARF_Task_Obj.Split_Button);
			Split_Button.click();
			gm.logPass(logger, "Clicked on Split Button",driver);

			if(driver.findElements(By.xpath("html/body/div[contains(@class,'bootbox modal fade bootbox-confirm in')]/div/div/div[1]/div")).size()!=0)
			{
				gm.logPass(logger, "Split Mandatory check Pass",driver);	
				WebElement Phone_Msg= driver.findElement(By.xpath("html/body/div[contains(@class,'bootbox modal fade bootbox-alert in')]/div/div/div[1]/div"));
				String Successmsg1=Phone_Msg.getText();

				if(Successmsg1.contains("Please select atleast one record to separate."))
				{
					gm.logPass(logger, "Showing that selecting records is mandatory",driver);	
				}
				else if(Successmsg1.contains("All record(s) are selected. Split record(s) can not be completed."))
				{
					gm.logPass(logger, "All records cannot be selected for split",driver);	
				}
				else
				{
					gm.logFail(logger, "Split Mandatory Check Showing wrong messsage",driver);	
				}
				//Click on Ok
				WebElement message_ok=driver.findElement(XNARF_Task_Obj.message_ok);
				message_ok.click();
			}
			else
			{
				gm.logFail(logger, "Split Mandatory Check Fail",driver);
			}
			//----------------------Delegate Mandatory Check------------------------------------//

			//Click on Delegate button
			WebElement Delegate_Button=driver.findElement(XNARF_Task_Obj.Delegate_Button);
			Delegate_Button.click();
			gm.logPass(logger, "We have clicked on delegate button.",driver);

			if(driver.findElements(By.xpath("html/body/div[contains(@class,'bootbox modal fade bootbox-alert in')]/div/div/div[1]/div")).size()!=0)
			{
				gm.logPass(logger, "Delegate Mandatory check pass.",driver);
				WebElement Phone_Msg= driver.findElement(By.xpath("html/body/div[8]/div/div/div[1]/div/p[1]"));
				String Successmsg1=Phone_Msg.getText();

				WebElement Phone_Msg2= driver.findElement(By.xpath("html/body/div[8]/div/div/div[1]/div/p[2]"));
				String Successmsg2=Phone_Msg2.getText();

				if(Successmsg1.contains("Select at least one record to delegate")&&Successmsg2.contains("Please Select User to Delegate"))
				{
					gm.logPass(logger, "Delegate Mandatory check showing right message",driver);	
				}
				else {
					gm.logFail(logger, "Delegate Mandatory check showing wrong message",driver);	
				}
				//Click on Ok
				WebElement message_ok=driver.findElement(XNARF_Task_Obj.message_ok);
				message_ok.click();				
			}
			else
			{
				gm.logFail(logger, "Delegate Mandatory check Fail",driver);
			}
		}


		catch(Exception e)
		{
			gm.logFail(logger, "Exception occured:"+e.getMessage(), driver);
		}

	}


}
