package com.RM.Scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.RM.Generic.GenericMethods2;
import com.RM.Generic.common_methods;
import com.RM.POM.Instance_setup_Menus_obj;
import com.RM.POM.Skill_Competency_Obj;
import com.RM.POM.Skill_Work_Type_Obj;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Skill_Work_Type_Test {
static WebDriver driver;
	
	static GenericMethods2 gm = new GenericMethods2();
	common_methods cm = new common_methods();
	static ExtentReports reports ;
	static ExtentTest logger;
	
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
		
		// click on work type
		WebElement work_type = driver.findElement(Skill_Work_Type_Obj.work_type);
		Actions action2 = new Actions(driver);
		action2.moveToElement(work_type).build().perform();
		work_type.click();
					
		}
		catch(Exception e)
		{
			System.out.println("msg" + e);
			gm.logfail(logger, "Exception occured:"+e.getMessage());
		}
	}

public  void Mandatory_check(WebDriver driver,ExtentTest logger) throws Exception
{
	try
	{
		// Click on Add Work type button
		WebElement Add_btn = driver.findElement(Skill_Work_Type_Obj.Add_work_type);
		Add_btn.click();
		Thread.sleep(2000);
		
		// Mandatory check Click on save button
		WebElement save_btn = driver.findElement(Skill_Work_Type_Obj.save_btn);
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
		WebElement cancel_btn = driver.findElement(Skill_Work_Type_Obj.cancel_btn);
		cancel_btn.click();
	}
	catch(Exception e)
	{
		gm.logfail(logger, "Exception occured:"+e.getMessage());
	}
}

}
