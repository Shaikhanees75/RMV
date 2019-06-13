package com.RM.Scripts;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.RM.Generic.GenericMethods2;
import com.RM.Generic.common_methods;
import com.RM.POM.XNARF_Task_Obj;
import com.relevantcodes.extentreports.ExtentTest;

public class XNARF_TR_Script {
	
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


		
		public void XNARF_TR_Enter(WebDriver driver, String Sap_id,String Preferred_Name,String Current_Client,String Separation_Date,String last_day,String Building_Key,String Desk_Key,String Badge,String physical_access,String Comments,String Locked_by,ExtentTest logger)
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

				if(!Preferred_Name.equals(""))
				{
					WebElement tr_preferred_name= driver.findElement(XNARF_Task_Obj.tr_preferred_name);
					String tr_preferred_name1=tr_preferred_name.getAttribute("value");
					System.out.println(tr_preferred_name1);

					if(Preferred_Name.equals(tr_preferred_name1))
					{
						gm.logPass(logger, "Displaying right Preferred Name",driver);		
					}
					else
					{
						gm.logFail(logger, "Displaying wrong Preferred Name",driver);	
					}
				}
				if(!Current_Client.equals(""))
				{
					WebElement tr_current_client= driver.findElement(XNARF_Task_Obj.tr_current_client);
					String tr_current_client1=tr_current_client.getAttribute("value");
					System.out.println(tr_current_client1);

					if(Current_Client.equals(tr_current_client1))
					{
						gm.logPass(logger, "Displaying right Current Client",driver);		
					}
					else
					{
						gm.logFail(logger, "Displaying wrong Current Client",driver);	
					}

				}
				if(!Separation_Date.equals(""))
				{
					WebElement tr_separation_date= driver.findElement(XNARF_Task_Obj.tr_separation_date);
					String tr_separation_date1=tr_separation_date.getAttribute("value");
					System.out.println(tr_separation_date1);

					if(Separation_Date.equals(tr_separation_date1))
					{
						gm.logPass(logger, "Displaying right Separation Date",driver);		
					}
					else
					{
						gm.logFail(logger, "Displaying wrong Separation Date",driver);	
					}				
				}

			
				if(!last_day.equals(""))
				{
					WebElement tr_last_day= driver.findElement(XNARF_Task_Obj.tr_last_day);
					String tr_last_day1=tr_last_day.getAttribute("value");
					System.out.println(tr_last_day1);

					if(last_day.equals(tr_last_day1))
					{
						gm.logPass(logger, "Displaying right last day",driver);		
					}
					else
					{
						gm.logFail(logger, "Displaying wrong last day",driver);	
					}
				}
				
				if(!Building_Key.equals(""))					
				{
					if(Building_Key.equals("Yes"))
					{
						WebElement Building_Key1= driver.findElement(By.xpath(".//*[@id='inlineRadioBuildingYes']"));
						Building_Key1.click();
					}
					else
					{
						WebElement Building_Key1= driver.findElement(By.xpath(".//*[@id='inlineRadioBuildingNo'][contains(@value,'"+Building_Key+"')]"));
						Building_Key1.click();
					}
					gm.logPass(logger, "Selected the requred Building Key",driver);
				}
				
				if(!Desk_Key.equals(""))					
				{
					if(Desk_Key.equals("Yes"))
					{
						WebElement Building_Key1= driver.findElement(By.xpath(".//*[@id='inlineRadioDeskYes']"));
						Building_Key1.click();
					}
					else
					{
						WebElement Building_Key1= driver.findElement(By.xpath(".//*[@id='inlineRadioDeskNo'][contains(@value,'"+Desk_Key+"')]"));
						Building_Key1.click();
					}
					gm.logPass(logger, "Selected the requred Building Key",driver);
				}
				
				if(!Badge.equals(""))					
				{
					if(Badge.equals("Yes"))
					{
						WebElement tr_badge_key= driver.findElement(XNARF_Task_Obj.tr_badge_key);
						tr_badge_key.click();
						gm.logPass(logger, "Badge collected ticked",driver);
					}
					else
					{
						gm.logPass(logger, "Badge collected not checked",driver);
					}
				
				}

				
				if(!physical_access.equals(""))
				{
					//Select Access Type
					WebElement Access_Type_drpdwn=driver.findElement(By.xpath(".//*[@id='HTMLPhysicalAccesstype']/div/div/span/div/button"));
					Access_Type_drpdwn.click();
					gm.logInfo(logger, "Opening Multi select drop down");
					Thread.sleep(1000);

					String Access_Types[] = physical_access.split(",");
					int max=Access_Types.length;
					System.out.println(max);

					boolean checked3 = driver.findElement(By.xpath(".//*[@id='HTMLPhysicalAccesstype']/div/div/span/div/ul/li[1]/a/label/input")).isSelected();
					System.out.println(checked3);
					if(checked3==true)
					{
						WebElement Access_Type_abc=driver.findElement(XNARF_Task_Obj.tr_ph_access);
						Access_Type_abc.click();
						Thread.sleep(1000);
						gm.logInfo(logger, "Removed all selection");

					}
					else if(checked3==false) {
						WebElement Access_Type_abc=driver.findElement(XNARF_Task_Obj.tr_ph_access);	
						Access_Type_abc.click();
						Thread.sleep(1000);
						Access_Type_abc.click();
						gm.logInfo(logger, "Removed all selection");
					}

					//Code to select all access types separated by ","-------------------//
					for (int j=0; j<max; j++) 
					{
						System.out.println(Access_Types[j]);
						if(driver.findElements(By.xpath(".//*[@id='HTMLPhysicalAccesstype']/div/div/span/div/ul/li/a/label[contains(text(),'"+Access_Types[j]+"')]/input")).size() !=0)
						{
							WebElement Required_Access_Type = driver.findElement(By.xpath(".//*[@id='HTMLPhysicalAccesstype']/div/div/span/div/ul/li/a/label[contains(text(),'"+Access_Types[j]+"')]/input"));
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
				gm.enterText(driver, XNARF_Task_Obj.comments_screen, Comments, "Comments", logger);


				//Click on Save
				WebElement tr_save_button=driver.findElement(XNARF_Task_Obj.tr_save_button);
				tr_save_button.click();	
				Thread.sleep(1000);

				//--------------------------------Verify Message-----------------------------------------------//				

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
				

				else if(driver.findElements(By.xpath(".//*[@id='alertsection']/div")).size() !=0)
				{
					WebElement Phone_Msg= driver.findElement(By.xpath("html/body/div[contains(@class,'bootbox modal fade bootbox-alert in')]/div/div/div[1]/div"));
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
					WebElement back_button=driver.findElement(XNARF_Task_Obj.tr_back_button);	
					back_button.click();					
				}


				//-------------------Verify values from the grid------------------------------------------//
				
				EmployeeId_filter.clear();

				//Employee ID Filter
				gm.enterText(driver, XNARF_Task_Obj.EmployeeId_filter, Sap_id, "Sap_id", logger);

				//Click on enter
				driver.findElement(By.id("4")).sendKeys(Keys.RETURN);
				Thread.sleep(1000);
				
				if(!Preferred_Name.equals(""))
				{
					WebElement tr_preferred_name= driver.findElement(XNARF_Task_Obj.tr_preferred_name_grid);
					String tr_preferred_name1=tr_preferred_name.getText();
					System.out.println(tr_preferred_name1);

					if(Preferred_Name.equals(tr_preferred_name1))
					{
						gm.logPass(logger, "Displaying right Preferred Name",driver);		
					}
					else
					{
						gm.logFail(logger, "Displaying wrong Preferred Name",driver);	
					}
				}
				if(!Current_Client.equals(""))
				{
					WebElement tr_current_client= driver.findElement(XNARF_Task_Obj.tr_current_client_grid);
					String tr_current_client1=tr_current_client.getText();
					System.out.println(tr_current_client1);

					if(Current_Client.equals(tr_current_client1))
					{
						gm.logPass(logger, "Displaying right Current Client",driver);		
					}
					else
					{
						gm.logFail(logger, "Displaying wrong Current Client",driver);	
					}

				}
				if(!Separation_Date.equals(""))
				{
					WebElement tr_separation_date= driver.findElement(XNARF_Task_Obj.tr_separation_date_grid);
					String tr_separation_date1=tr_separation_date.getText();
					System.out.println(tr_separation_date1);

					if(Separation_Date.equals(tr_separation_date1))
					{
						gm.logPass(logger, "Displaying right Separation Date",driver);		
					}
					else
					{
						gm.logFail(logger, "Displaying wrong Separation Date",driver);	
					}				
				}

			
				if(!last_day.equals(""))
				{
					WebElement tr_last_day= driver.findElement(XNARF_Task_Obj.tr_last_day_grid);
					String tr_last_day1=tr_last_day.getText();
					System.out.println(tr_last_day1);

					if(last_day.equals(tr_last_day1))
					{
						gm.logPass(logger, "Displaying right last day",driver);		
					}
					else
					{
						gm.logFail(logger, "Displaying wrong last day",driver);	
					}
				}
				
				if(!Building_Key.equals(""))					
				{
					WebElement tr_building_key_grid= driver.findElement(XNARF_Task_Obj.tr_building_key_grid);
					String tr_building_key_grid1=tr_building_key_grid.getText();
					System.out.println(tr_building_key_grid1);

					if(Building_Key.equals(tr_building_key_grid1))
					{
						gm.logPass(logger, "Displaying right Building Key",driver);		
					}
					else
					{
						gm.logFail(logger, "Displaying wrong Building Key",driver);	
					}
				}
				
				if(!Desk_Key.equals(""))					
				{
					WebElement tr_desk_key_grid= driver.findElement(XNARF_Task_Obj.tr_desk_key_grid);
					String tr_desk_key_grid1=tr_desk_key_grid.getText();
					System.out.println(tr_desk_key_grid1);

					if(Desk_Key.equals(tr_desk_key_grid1))
					{
						gm.logPass(logger, "Displaying right Desk Key",driver);		
					}
					else
					{
						gm.logFail(logger, "Displaying wrong Desk Key",driver);	
					}
				}
				
				if(!Badge.equals(""))					
				{
					WebElement tr_badge_key_grid= driver.findElement(XNARF_Task_Obj.tr_badge_key_grid);
					String tr_badge_key_grid1=tr_badge_key_grid.getText();
					System.out.println(tr_badge_key_grid1);

					if(Badge.equals(tr_badge_key_grid1))
					{
						gm.logPass(logger, "Displaying right Badge",driver);		
					}
					else
					{
						gm.logFail(logger, "Displaying wrong Badge",driver);	
					}
				
				}

				
				if(!physical_access.equals(""))
				{
					WebElement tr_physical_access= driver.findElement(XNARF_Task_Obj.tr_physical_access);
					String tr_physical_access1=tr_physical_access.getText();
					System.out.println(tr_physical_access1);

					if(Badge.equals(tr_physical_access1))
					{
						gm.logPass(logger, "Displaying right physical access",driver);		
					}
					else
					{
						gm.logFail(logger, "Displaying wrong physical access",driver);	
					}
				
				}
				
				
				if(!Comments.equals(""))
				{
					WebElement comments_grid= driver.findElement(XNARF_Task_Obj.comments_grid);
					String comments_grid1=comments_grid.getText();
					System.out.println(comments_grid1);

					if(Comments.equals(comments_grid1))
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
					WebElement tr_locked_by_grid= driver.findElement(XNARF_Task_Obj.tr_locked_by_grid);
					String tr_locked_by_grid1=tr_locked_by_grid.getText();
					System.out.println(tr_locked_by_grid1);

					if(Locked_by.equals(tr_locked_by_grid1))
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
	


