package com.RM.Scripts;



import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.RM.Generic.GenericMethods2;
import com.RM.Generic.common_methods;
import com.RM.POM.Skill_Change_Request_Obj;
import com.RM.POM.Skill_WTCG_Obj;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


public class Skill_WTCG_Test {
	
	static WebDriver driver;
	static GenericMethods2 gm = new GenericMethods2();
	common_methods cm = new common_methods();
	static ExtentReports reports ;
	static ExtentTest logger;
	
	//go to Skill change sub menu
	
	public  void go_to_Work_type_competency_group(WebDriver driver,ExtentTest logger)throws Exception
		{
			try{
				
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			// hover on Instance set up
			WebElement instance_setup = driver.findElement(Skill_WTCG_Obj.instance_setup);
			Actions action = new Actions(driver);
			action.moveToElement(instance_setup).build().perform();
			gm.logInfo(logger, "We have hovered on Resource_planner Menu", driver);
			
			
			
			// click on Skill master
						WebElement Skill_master = driver.findElement(Skill_WTCG_Obj.skill_master);
						Actions action1 = new Actions(driver);
						action1.moveToElement(Skill_master).build().perform();
						gm.logInfo(logger, "We have hovered on demand Menu", driver);
						
			
						//Click on Work type comepetency grp
						WebElement competency = driver.findElement(Skill_WTCG_Obj.competency);
						Actions action2 = new Actions(driver);
						action1.moveToElement(competency).build().perform();
						gm.logInfo(logger, "We have hovered on Skill Menu", driver);
						
						//Click on Skill change request
						WebElement wtcg = driver.findElement(Skill_WTCG_Obj.wtcg);
						wtcg.click();
						gm.logInfo(logger, "We have clicked on Skill change request sub menu", driver);
			}

			catch(Exception e)
			{
				System.out.println("Message" + e);
				gm.logFail(logger, "Exception occured"+e,cm.driver);
			}
		}

	
	public  void Add_WTCG(WebDriver driver, String Search, String Title,String Description, String Work_type,String Competency_type, String Competency, String min_prof, String max_prof,ExtentTest logger) throws Exception
	{
		try
		{
			//click on add button
			WebElement add_btn = driver.findElement(Skill_WTCG_Obj.add_btn);
			add_btn.click();
			Thread.sleep(1000);
			
			//ENTER TITLE
			gm.enterText(driver, Skill_WTCG_Obj.title, Title, "Title", logger);
			Thread.sleep(1000);
			
			//enter desc
			gm.enterText(driver, Skill_WTCG_Obj.desc, Description, "Description", logger);
			Thread.sleep(1000);
			
			//select work type
			gm.selectValueFromListByText(driver, Skill_WTCG_Obj.work_type, Work_type, "Work_type", logger);
			Thread.sleep(000);
			
			//click on delete icon
			WebElement delete_first = driver.findElement(Skill_WTCG_Obj.delete_first);
			delete_first.click();
			Thread.sleep(1000);
			
			//click on add button
			WebElement add = driver.findElement(Skill_WTCG_Obj.add_comp);
			add.click();
			Thread.sleep(1000);
			
			//select competency type
			gm.selectValueFromListByText(driver, Skill_WTCG_Obj.competency_type, Competency_type, "Competency_type", logger);
			Thread.sleep(1000);
			
			//select competency
			gm.selectValueFromListByText(driver, Skill_WTCG_Obj.competency_drp, Competency, "Competency", logger);
			Thread.sleep(2000);
			
			//select min prof
			gm.selectValueFromListByText(driver, Skill_WTCG_Obj.min_prof, min_prof, "min_prof", logger);
			Thread.sleep(2000);
			
			//select max prof
			gm.selectValueFromListByText(driver, Skill_WTCG_Obj.max_prof, max_prof, "max_prof", logger);
			Thread.sleep(1000);
			
			//Click on save button
			WebElement save_btn = driver.findElement(Skill_WTCG_Obj.save_btn);
			save_btn.click();
			Thread.sleep(3000);
			
			String success_msg = driver.findElement(Skill_WTCG_Obj.success_msg).getText();
			
			if(success_msg.contains("Success"))
				{
				 gm.logPass(logger, "Work type competency group successfully created", driver);
				  System.out.println("Test for Add WTCG passed");
				}
			
			else
				{
				  gm.logFail(logger, "Error occured-- please check the code", driver);
				}
			
			//Validation on save 
			WebElement title_search= driver.findElement(Skill_WTCG_Obj.title_search);
			gm.enterText(driver, Skill_WTCG_Obj.title_search, Search, "Search", logger);
			Thread.sleep(1000);
			title_search.sendKeys(Keys.ENTER);
			Robot key = new Robot();
			key.keyPress(KeyEvent.VK_ENTER); 
			Thread.sleep(1000);
			
			//search result validate
			String Verify = driver.findElement(Skill_WTCG_Obj.search_result).getText();
			
			if(Verify.contains(Search))
			{
				gm.logPass(logger, "Save validation successful", driver);
			}
			else
			{
				gm.logFail(logger, "Validation failed", driver);
			}
		}
		
		catch(Exception e)
		{
			gm.logFail(logger, "Exception occured"+e.getMessage(),common_methods.driver);
			System.out.println("Error is " +e);
		}	
		
	}
	
	public  void Edit_WTCG(WebDriver driver,String Search, String Title,String Description, String Work_type,String Competency_type, String Competency, String min_prof, String max_prof,ExtentTest logger) throws Exception
	{
		try
		{
			//navigate to the record to be edited
			WebElement title_search= driver.findElement(Skill_WTCG_Obj.title_search);
			gm.enterText(driver, Skill_WTCG_Obj.title_search, Search, "Search", logger);
			Thread.sleep(1000);
			title_search.sendKeys(Keys.ENTER);
			Robot key = new Robot();
			key.keyPress(KeyEvent.VK_ENTER); 
			Thread.sleep(1000);
			
			//click on Edit button
			WebElement edit = driver.findElement(Skill_WTCG_Obj.edit);
			edit.click();
			Thread.sleep(2000);
			
			//Change title
			WebElement title = driver.findElement(Skill_WTCG_Obj.title);
			title.clear();
			gm.enterText(driver, Skill_WTCG_Obj.title, Title, "Title", logger);
			
			//inactive the WTCG
			WebElement active_btn = driver.findElement(Skill_WTCG_Obj.active_btn);
			active_btn.click();
			Thread.sleep(1000);
			
			//Click on save button
			WebElement save_btn = driver.findElement(Skill_WTCG_Obj.save_btn);
			save_btn.click();
			Thread.sleep(3000);
			
			String success_msg = driver.findElement(Skill_WTCG_Obj.success_msg).getText();
			
			if(success_msg.contains("Success"))
				{
				 gm.logPass(logger, "Work type competency group successfully Edited", driver);
				  System.out.println("Test for Add WTCG passed");
				}
			
			else
				{
				  gm.logFail(logger, "Error occured-- please check the code", driver);
				}
			
			//Validation on save 
			WebElement title_search1= driver.findElement(Skill_WTCG_Obj.title_search);
			gm.enterText(driver, Skill_WTCG_Obj.title_search, Title, "Title", logger);
			Thread.sleep(1000);
			title_search1.sendKeys(Keys.ENTER);;
			Robot key1 = new Robot();
			key1.keyPress(KeyEvent.VK_ENTER); 
			Thread.sleep(1000);
			
			//search result validate
			String Verify = driver.findElement(Skill_WTCG_Obj.search_result).getText();
			
			if(Verify.contains(Title))
			{
				gm.logPass(logger, "Update validation successful", driver);
			}
			else
			{
				gm.logFail(logger, "Update Validation failed", driver);
			}
		}
			catch(Exception e)
			{
				gm.logFail(logger, "Exception occured"+e.getMessage(),common_methods.driver);
			}
		}
	}
