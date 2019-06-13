package com.RM.Scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.RM.Generic.GenericMethods2;
import com.RM.Generic.common_methods;
import com.RM.POM.XNARF_Task_Obj;
import com.relevantcodes.extentreports.ExtentTest;

public class XNARF_TF_Script {

	static WebDriver driver ;

	GenericMethods2 gm = new GenericMethods2();
	common_methods cm = new common_methods();
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
				else if(Successmsg1.contains("Please Select at least one Employee!."))
				{
					gm.logPass(logger, "Showing that atleast on record must be selected",driver);					
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

			if(driver.findElements(By.xpath("html/body/div[contains(@class,'bootbox modal fade bootbox-alert in')]/div/div/div[1]/div")).size()!=0)
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
				WebElement Phone_Msg= driver.findElement(By.xpath("html/body/div/div/div/div[1]/div/p[1]"));
				String Successmsg1=Phone_Msg.getText();

				WebElement Phone_Msg2= driver.findElement(By.xpath("html/body/div/div/div/div[1]/div/p[2]"));
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

	public void XNARF_TF_Enter(WebDriver driver, String Sap_id,String Current_SOW,String New_SOW,String Effective_date,String Access_Type,String Comments,String Locked_by,ExtentTest logger)
	{
		try {

			WebElement EmployeeId_filter= driver.findElement(XNARF_Task_Obj.EmployeeId_filter);
			EmployeeId_filter.clear();

			//Employee ID Filter
			gm.enterText(driver, XNARF_Task_Obj.EmployeeId_filter, Sap_id, "Sap_id", logger);

			//Click on enter
			driver.findElement(By.id("4")).sendKeys(Keys.RETURN);
			Thread.sleep(1000);

			//Select the record
			WebElement Employee_Id=driver.findElement(XNARF_Task_Obj.Employee_Id);
			Employee_Id.click();

			if(!Current_SOW.equals(""))
			{
				WebElement current_sow_screen= driver.findElement(XNARF_Task_Obj.current_sow_screen);
				String current_sow_screen1=current_sow_screen.getAttribute("value");
				System.out.println(current_sow_screen1);

				if(Current_SOW.equals(current_sow_screen1))
				{
					gm.logPass(logger, "Displaying right Current SOW",driver);		
				}
				else
				{
					gm.logFail(logger, "Displaying wrong Current SOW",driver);	
				}
			}
			if(!New_SOW.equals(""))
			{
				WebElement new_sow_screen= driver.findElement(XNARF_Task_Obj.new_sow_screen);
				String new_sow_screen1=new_sow_screen.getAttribute("value");
				System.out.println(new_sow_screen1);

				if(Current_SOW.equals(new_sow_screen1))
				{
					gm.logPass(logger, "Displaying right New SOW",driver);		
				}
				else
				{
					gm.logFail(logger, "Displaying wrong New SOW",driver);	
				}

			}
			if(!Effective_date.equals(""))
			{
				WebElement effective_date_screen= driver.findElement(XNARF_Task_Obj.effective_date_screen);
				String effective_date_screen1=effective_date_screen.getAttribute("value");
				System.out.println(effective_date_screen1);

				if(Effective_date.equals(effective_date_screen1))
				{
					gm.logPass(logger, "Displaying right Effective Date",driver);		
				}
				else
				{
					gm.logFail(logger, "Displaying wrong Effective Date",driver);	
				}				
			}

		
			if(!Access_Type.equals(""))
			{
				//Select Access Type
				WebElement Access_Type_drpdwn=driver.findElement(By.xpath(".//*[@id='HTMLAccesstype']/div/div/span/div/button"));
				Access_Type_drpdwn.click();
				gm.logInfo(logger, "Opening Multi select drop down");
				Thread.sleep(1000);

				String Access_Types[] = Access_Type.split(",");
				int max=Access_Types.length;
				System.out.println(max);

				boolean checked3 = driver.findElement(By.xpath(".//*[@id='HTMLAccesstype']/div/div/span/div/ul/li[1]/a/label/input")).isSelected();
				System.out.println(checked3);
				if(checked3==true)
				{
					WebElement Access_Type_abc=driver.findElement(XNARF_Task_Obj.access_type_dpdwn);
					Access_Type_abc.click();
					Thread.sleep(1000);
					gm.logInfo(logger, "Removed all selection");

				}
				else if(checked3==false) {
					WebElement Access_Type_abc=driver.findElement(XNARF_Task_Obj.access_type_dpdwn);	
					Access_Type_abc.click();
					Thread.sleep(1000);
					Access_Type_abc.click();
					gm.logInfo(logger, "Removed all selection");
				}

				//Code to select all access types separated by ","-------------------//
				for (int j=0; j<max; j++) 
				{
					System.out.println(Access_Types[j]);
					if(driver.findElements(By.xpath(".//*[@id='HTMLAccesstype']/div/div/span/div/ul/li/a/label[contains(text(),'"+Access_Types[j]+"')]/input")).size() !=0)
					{
						WebElement Required_Access_Type = driver.findElement(By.xpath(".//*[@id='HTMLAccesstype']/div/div/span/div/ul/li/a/label[contains(text(),'"+Access_Types[j]+"')]/input"));
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
				gm.logPass(logger, "Closing Multi select drop down",driver);
				Thread.sleep(1000);
			}

			//Enter Comments
			WebElement comments=driver.findElement(XNARF_Task_Obj.comments_screen);
			comments.clear();		
			gm.enterText(driver, XNARF_Task_Obj.comments_screen, Comments, "Comments", logger);


			//Click on Save
			WebElement save_button=driver.findElement(XNARF_Task_Obj.save_button);
			save_button.click();	
			Thread.sleep(1000);


			//Verify Message			
			if(driver.findElements(By.id("acceptentry")).size() !=0)
			{
				gm.logPass(logger, "Displaying Access type change Pop Up",driver);

				//Click on Accept
				WebElement accept_button=driver.findElement(XNARF_Task_Obj.accept_button);	
				accept_button.click();

				if(driver.findElements(By.xpath("html/body/div[contains(@class,'bootbox modal fade bootbox-alert in')]/div/div/div[1]/div")).size() !=0)
				{
					WebElement Phone_Msg= driver.findElement(By.xpath("html/body/div[contains(@class,'bootbox modal fade bootbox-alert in')]/div/div/div[1]/div"));
					String Successmsg1=Phone_Msg.getText();

					if(Successmsg1.contains("Saved Successfully"))
					{
						gm.logPass(logger, "Details saved successfully",driver);
					}
					//Click on Ok
					WebElement save_ok=driver.findElement(XNARF_Task_Obj.save_ok);	
					save_ok.click();
				}
			}

			else if(driver.findElements(By.xpath("html/body/div[contains(@class,'bootbox modal fade bootbox-alert in')]/div/div/div[1]/div")).size() !=0)
			{
				WebElement Phone_Msg= driver.findElement(By.xpath("html/body/div[contains(@class,'bootbox modal fade bootbox-alert in')]/div/div/div[1]/div"));
				String Successmsg1=Phone_Msg.getText();

				if(Successmsg1.contains("Saved Successfully"))
				{
					gm.logPass(logger, "Details saved successfully",driver);
				}
				//Click on Ok
				WebElement save_ok=driver.findElement(XNARF_Task_Obj.save_ok);	
				save_ok.click();
			}
			else if(driver.findElements(By.xpath(".//*[@id='alertsection']/div")).size() !=0)
			{
				WebElement Phone_Msg= driver.findElement(By.xpath(".//*[@id='alertsection']/div"));
				String Successmsg1=Phone_Msg.getText();
				if(Successmsg1.contains("Error! Please select at least one Access Type!"))
				{
					gm.logPass(logger, "User is notified that access type is Mandatory",driver);
				}
				else
				{
					gm.logFail(logger, "Displaying wromg message",driver);				
				}

				//Click on Back
				WebElement back_button=driver.findElement(XNARF_Task_Obj.back_button);	
				back_button.click();					
			}


			//-------------------Verify values from the grid------------------------------------------//
			
			EmployeeId_filter.clear();

			//Employee ID Filter
			gm.enterText(driver, XNARF_Task_Obj.EmployeeId_filter, Sap_id, "Sap_id", logger);

			//Click on enter
			driver.findElement(By.id("4")).sendKeys(Keys.RETURN);
			Thread.sleep(1000);
			
			if(!Current_SOW.equals(""))
			{
				WebElement current_sow_grid= driver.findElement(XNARF_Task_Obj.current_sow_grid);
				String current_sow_grid1=current_sow_grid.getText();
				System.out.println(current_sow_grid1);

				if(Current_SOW.equals(current_sow_grid1))
				{
					gm.logPass(logger, "Displaying right Current SOW",driver);		
				}
				else
				{
					gm.logFail(logger, "Displaying wrong Current SOW",driver);	
				}

			}
			if(!New_SOW.equals(""))
			{
				WebElement new_sow_grid= driver.findElement(XNARF_Task_Obj.new_sow_grid);
				String new_sow_grid1=new_sow_grid.getText();
				System.out.println(new_sow_grid1);

				if(Current_SOW.equals(new_sow_grid1))
				{
					gm.logPass(logger, "Displaying right New SOW",driver);		
				}
				else
				{
					gm.logFail(logger, "Displaying wrong New SOW",driver);	
				}

			}
			if(!Effective_date.equals(""))
			{
				WebElement effective_date_grid= driver.findElement(XNARF_Task_Obj.effective_date_grid);
				String effective_date_grid1=effective_date_grid.getText();
				System.out.println(effective_date_grid1);

				if(Effective_date.equals(effective_date_grid1))
				{
					gm.logPass(logger, "Displaying right Effective Date",driver);		
				}
				else
				{
					gm.logFail(logger, "Displaying wrong Effective Date",driver);	
				}				
			}

		
			if(!Access_Type.equals(""))
			{
				WebElement access_type_grid= driver.findElement(XNARF_Task_Obj.access_type_grid);
				String access_type_grid1=access_type_grid.getText();
				System.out.println(access_type_grid1);

				if(Effective_date.equals(access_type_grid1))
				{
					gm.logPass(logger, "Displaying right access type",driver);		
				}
				else
				{
					gm.logFail(logger, "Displaying wrong access type",driver);	
				}
			}
			
			if(!Comments.equals(""))
			{
				WebElement comments_grid= driver.findElement(XNARF_Task_Obj.comments_grid);
				String comments_grid1=comments_grid.getText();
				System.out.println(comments_grid1);

				if(Effective_date.equals(comments_grid1))
				{
					gm.logPass(logger, "Displaying right Comments",driver);		
				}
				else
				{
					gm.logFail(logger, "Displaying wrong Comments",driver);	
				}
			}
			
			if(!Locked_by.equals(""))
			{
				WebElement locked_by= driver.findElement(XNARF_Task_Obj.locked_by);
				String locked_by1=locked_by.getText();
				System.out.println(locked_by1);

				if(Locked_by.equals(locked_by1))
				{
					gm.logPass(logger, "Displaying right Locked By",driver);		
				}
				else
				{
					gm.logFail(logger, "Displaying wrong Locked By",driver);	
				}
			}
			
		}
		catch(Exception e)
		{
			gm.logFail(logger, "Exception occured:"+e.getMessage(), driver);
		}
	}

}
