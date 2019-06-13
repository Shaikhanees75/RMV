package com.RM.POM;

import org.openqa.selenium.By;

public class Skill_Work_Type_Obj {

	
	//Work type
	public static By work_type = By.xpath(".//*[@id='mainmenu']/li[2]/ul/li[2]/ul/li[3]/a");
	
	//add work type
	public static By Add_work_type = By.xpath(".//*[@id='btnAdd']");
	
	//Work type name
	public static By workTyoe_name = By.xpath(".//*[@id='compTitle']");
	
	//work type desc
	public static By WorkType_desc = By.xpath(".//*[@id='compDesc']");
	
	//work type group
	public static By workType_group = By.xpath(".//*[@id='WorkTypeGroups']");
	
	//industry type
	public static By industry_type = By.xpath(".//*[@id='AddWorkType']/div/div/div[2]/div/div[2]/div[2]/div/div/div/span/div/button");
	
	//tag
	public static By tag = By.xpath(".//*[@id='tag']");
	
	//active check box
	public static By active_check = By.xpath(".//*[@id='compActive']");
	
	//reset button
	public static By reset_btn  = By.xpath(".//*[@id='resetComp']");
	
	//Save button
	public static By save_btn = By.xpath(".//*[@id='saveComp']");
	
	//cancel button
	public static By cancel_btn = By.xpath(".//*[@id='AddWorkType']/div/div/div[3]/button[3]");
	
	//title_search
	public static By title_search = By.xpath(".//*[@id='1']");
			
			//search result
	public static By search_result = By.xpath(".//*[@id='fixTable']/tbody/tr[1]/td[2]");
	
	
	
	
	
	
}
