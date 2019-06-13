package com.RM.POM;

import org.openqa.selenium.By;

public class Skill_Change_Request_Obj {
	
	//resource planner
	public static By resource_planner = By.xpath(".//*[@id='mainmenu']/li[6]/a");
	
	//skill
	public static By skill= By.xpath("//*[@id='mainmenu']/li/ul/li/a[text()='Skill']");
	//*[@id="mainmenu"]/li[6]/ul/li[4]/a
	
	//skill Change request
	public static By skill_change = By.xpath("//*[@id='mainmenu']/li[6]/ul/li[4]/ul/li[1]/a");
	
	//Add button
	public static By Add_btn = By.xpath("//*[@id='addPreReqRow']");
	
	//send for approval
	public static By send_aapproval = By.xpath("//*[@id='submit-input-button']");
	
	//reset button
	public static By reset_btn = By.xpath("//*[@id='reset-input-button']");
	
	//select all
	public static By select_all = By.xpath("//*[@id='dynamicControl']/div[1]/div[1]/label/span");
	
	//select 1st row
	public static By select = By.xpath("//*[@id='dynamicControl']/div[2]/div[1]/div/label/span");
	
	//Active button
	public static By active = By.xpath("//*[@id=,dynamicControl']/div[2]/div[7]/div/label/span");
	
	//delete button
	public static By delete_btn = By.xpath("//*[@id='dynamicControl']/div[2]/div[9]/button");
	
	//skill type drop down
	public static By skill_type= By.xpath("//*[@id='dynamicControl']/div[2]/div[2]/div/select");
	
	//skill drop down
	public static By skill_drp_dwn= By.xpath("//*[@id='dynamicControl']/div[2]/div[3]/div/select");
	
	//proficiency
	public static By prof = By.xpath("//*[@id='dynamicControl']/div[2]/div[4]/div/select");
	
	//Valid from
	public static By valid_frm = By.xpath("//*[@id='dynamicControl']/div[2]/div[5]/div/span/img");
	
	//valid to
	public static By valid_to = By.xpath("//*[@id='dynamicControl']/div[2]/div[6]/div[1]/span/img");
	
	//search
	public static By search = By.xpath(".//*[@id='inputSearchMenu']");
	
	//demand
	public static By demand = By.xpath(".//*[@id='mainmenu']/li[6]/ul/li[1]/a");
	
	//success message
	public static By success_msg = By.xpath(".//*[@id='alertsection']/div/strong");
	
	
	
	
	
	
	

}
