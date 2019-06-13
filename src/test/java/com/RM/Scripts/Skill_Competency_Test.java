package com.RM.Scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.RM.Generic.GenericMethods2;
import com.RM.Generic.common_methods;
import com.RM.POM.Instance_setup_Menus_obj;
import com.RM.POM.Skill_Competency_Obj;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;



public class Skill_Competency_Test {
	
	static WebDriver driver;
	
	static GenericMethods2 gm = new GenericMethods2();
	common_methods cm = new common_methods();
	static ExtentReports reports ;
	static ExtentTest logger;
	
	
	//go to competency
	
	public  void go_to_Skill_Master_menu(WebDriver driver,ExtentTest logger)throws Exception
		{
			try{
				
			
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			// hover on Instance set up
			WebElement Instance_setup = driver.findElement(Instance_setup_Menus_obj.Instance_setup);
			Actions action = new Actions(driver);
			action.moveToElement(Instance_setup).build().perform();
			gm.logInfo(logger, "We have hovered on Instance Setup Menu", driver);
			
			//Click on Skill Master
			WebElement Skill_master = driver.findElement(Instance_setup_Menus_obj.Skill_masters);
			Actions action1 = new Actions(driver);
			action1.moveToElement(Skill_master).build().perform();
			gm.logInfo(logger, "We have hovered on Skill Masters Menu", driver);
			
			// click on competency
			WebElement competency = driver.findElement(Instance_setup_Menus_obj.competency);
			Actions action2 = new Actions(driver);
			action2.moveToElement(competency).build().perform();
			competency.click();
						
			}
			catch(Exception e)
			{
				System.out.println("msg" + e);
				gm.logfail(logger, "Exception occured:"+e.getMessage());
			}
		}
	
	public  void Mandatory_check(WebDriver driver, String Competency_details,ExtentTest logger) throws Exception
	{
		try
		{
			//select Competency details from the drop down
			gm.selectValueFromListByText(driver, Skill_Competency_Obj.competency_details, Competency_details, "Competency_details", logger);
			gm.logInfo(logger, "The following value has been selected for Competency details" +Competency_details, driver);
			
			// Click on Add competency button
			WebElement Add_btn = driver.findElement(Skill_Competency_Obj.Add_competency);
			Add_btn.click();
			Thread.sleep(2000);
			
			// Mandatory check Click on save button
			WebElement save_btn = driver.findElement(Skill_Competency_Obj.save_btn);
			save_btn.click();
			
			WebDriverWait wait = new WebDriverWait(driver,10);
			WebElement Error_msg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='alertsectionCompModal']/div")));
			//capture mandatory fields
			String Mandatory_fields= driver.findElement(By.xpath("//*[@id='alertsectionCompModal']/div")).getText();
			if(Mandatory_fields!="")
			{
				System.out.println("Test Case Passed" +Mandatory_fields);
			}
			else
			{
				System.out.println("Test case failed");
			}
			
			//click on cancel button
			WebElement cancel_btn = driver.findElement(Skill_Competency_Obj.cancel_btn);
			cancel_btn.click();
		}
		catch(Exception e)
		{
			gm.logfail(logger, "Exception occured:"+e.getMessage());
		}
	}

	public void Add_Competency(WebDriver driver, String Competency_details,String Competency_name,String Competency_desc,String Industry_type,String Validity_days,String min_prof,String max_prof,String tag,String Competency_type,String Competency,String Proficiency, ExtentTest logger)
		{
			try
				{
				WebDriverWait wait = new WebDriverWait(driver,10);
				// Click on Add button
				WebElement Add_btn = driver.findElement(Skill_Competency_Obj.Add_competency);
				wait.until(ExpectedConditions.visibilityOfElementLocated(Skill_Competency_Obj.Add_competency));
				Add_btn.click();
				gm.logInfo(logger, "Clicked on Add Competency Button" , driver);
					
			//Enter competecny name
			WebElement competency_name = driver.findElement(Skill_Competency_Obj.competency_name);
			wait.until(ExpectedConditions.visibilityOf(competency_name));
			gm.enterText(driver, Skill_Competency_Obj.competency_name, Competency_name, "Competency_name", logger);
			gm.logInfo(logger, "Entered Competency name as" + Competency_name, driver);
			
			//Enter competency description
			gm.enterText(driver, Skill_Competency_Obj.competency_desc, Competency_desc, "Competency_desc", logger);
			gm.logInfo(logger, "Entered Competency_desc as" + Competency_desc, driver);
			
			//enter validity days
			gm.enterText(driver, Skill_Competency_Obj.validity, Validity_days, "Validity_days", logger);
			gm.logInfo(logger, "Entered Validity_days as" + Validity_days, driver);
			
			//Enter min prof
			gm.enterText(driver, Skill_Competency_Obj.min_prof, min_prof, "min_prof", logger);
			
			
			//Enter max prof
			gm.enterText(driver, Skill_Competency_Obj.max_prof, max_prof, "max_prof", logger);
			gm.logInfo(logger, "Entered max_prof as" + max_prof, driver);
			
			//Select industry type
				WebElement industry_type= driver.findElement(Skill_Competency_Obj.industry_type);
				industry_type.click();
				Thread.sleep(2000);
				//click on select all
				driver.findElement(Skill_Competency_Obj.select_all).click();
				gm.logInfo(logger, "Select all option selected as an input for industry type" , driver);
				Thread.sleep(1000);
				industry_type.click();
				
				//Add pre-requisites
				
				//Click on add button
				WebElement add_btn= driver.findElement(Skill_Competency_Obj.requisite_btn);
				add_btn.click();
				Thread.sleep(2000);
				add_btn.click();
				gm.logInfo(logger, "Added 2 rows for pre-requisites" , driver);
				Thread.sleep(2000);
				//delete 1 row
											
				//enter competency type
				gm.selectValueFromListByText(driver, Skill_Competency_Obj.comptency_type, Competency_type, "Competency_type", logger);
				gm.logInfo(logger, "Selected Competency type" + Competency_type + "from the drop down", driver);
				Thread.sleep(1000);
				
				//Competency
				gm.selectValueFromListByText(driver, Skill_Competency_Obj.competency, Competency, "Competency", logger);
				gm.logInfo(logger, "Selected Competency " + Competency + "from the drop down", driver);
				Thread.sleep(1000);
				
				//proficiency
				gm.selectValueFromListByText(driver, Skill_Competency_Obj.prof, Proficiency, "Proficiency", logger);
				gm.logInfo(logger, "Selected proficiency " + Proficiency + "from the drop down", driver);
				Thread.sleep(1000);
				
				WebElement delete = driver.findElement(Skill_Competency_Obj.delete_btn);
				delete.click();
				Thread.sleep(1000);
				gm.logInfo(logger, "We have delete one row for pre-requisites", driver);
				
			//Click on save button
			WebElement save_btn = driver.findElement(Skill_Competency_Obj.save_btn);
			save_btn.click();
			
			
			// Validate success message
			String Success_msg = driver.findElement(By.xpath("//*[@id='alertsection']/div/strong")).getText();
			if(Success_msg.contains("Success"))
			{
				System.out.println("Competency was successfully created");
				
				
				//Validate the saved competency
				WebElement title= driver.findElement(Skill_Competency_Obj.title);
				gm.enterText(driver, Skill_Competency_Obj.title, Competency_name, "Competency_name", logger);
				
				title.sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				
				String Verify_save = driver.findElement(Skill_Competency_Obj.search_result).getText();
				
				if(Verify_save.equals(Competency_name))
				{
					System.out.println("The save item is seen in the grid table-- Validation successful");
				}
				else
				{
					System.out.println("Error occured while searching the save element");
				}
			}	
			else
			{
					System.out.println("Error occured while saving the Competency");
			}
			
			}
			catch(Exception e)
			{
				System.out.println("msg" + e);
				gm.logfail(logger, "Exception occured:"+e.getMessage());
			}
		}
		
	
	public void Edit_Competency(WebDriver driver, String Competency_details,String Competency_name,String Competency_desc,String Industry_type,String Validity_days,String min_prof,String max_prof,String tag,String Competency_type,String Competency,String Proficiency, ExtentTest logger)
	{
		try{
			
			//select Competency details from the drop down
			gm.selectValueFromListByText(driver, Skill_Competency_Obj.competency_details, Competency_details, "Competency_details", logger);
			gm.logInfo(logger, "The following value has been selected for Competency details" +Competency_details, driver);
			
			WebElement edit_btn = driver.findElement(Skill_Competency_Obj.edit_btn);
			edit_btn.click();
			Thread.sleep(1000);
			
			//change competency name
			WebElement competency_name = driver.findElement(Skill_Competency_Obj.competency_name);
			competency_name.clear();
			gm.enterText(driver, Skill_Competency_Obj.competency_name, Competency_name, "Competency_name", logger);
			Thread.sleep(1000);
			
			//uncheck the active checkbox
			gm.selectCheckBox(driver, Skill_Competency_Obj.Active_box, "", logger);
			Thread.sleep(1000);
			
			//click on save button
			WebElement save_btn = driver.findElement(Skill_Competency_Obj.save_btn);
			save_btn.click();
			
			//Validation for updated Competency
			WebElement title= driver.findElement(Skill_Competency_Obj.title);
			gm.enterText(driver, Skill_Competency_Obj.title, Competency_name, "Competency_name", logger);
			
			title.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			
			String Verify_save = driver.findElement(Skill_Competency_Obj.search_result).getText();
			
			if(Verify_save.equals(Competency_name))
			{
				System.out.println("The save item is seen in the grid table-- Validation successfull");
			}
			else
			{
				System.out.println("Error occured while searching the updated element");
			}
		}	
		
			
		catch(Exception e)
		{
			gm.logfail(logger, "Exception occured:"+e.getMessage());
		}
		
		
		
		
	}
	
	
	
	
}		
			
			
			
	
		
		
	

	

		
	
	


