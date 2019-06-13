package com.RM.POM;

import org.openqa.selenium.By;

public class Project_Project_type_Obj {

	//resource planner
		public static By instance_setup = By.xpath(".//*[@id='mainmenu']/li[3]/a");
		
	//demographics
		public static By demographics = By.xpath(".//*[@id='mainmenu']/li[3]/ul/li[1]/a");
		
	//Project mster
		public static By project_masters = By.xpath(".//*[@id='mainmenu']/li[3]/ul/li[4]/a");
		
		//industry
		public static By industry = By.xpath(".//*[@id='mainmenu']/li[3]/ul/li[4]/ul/li[1]/a");
		
		//project type
		public static By project_type = By.xpath(".//*[@id='mainmenu']/li[3]/ul/li[4]/ul/li[5]/a");
		
		//add button
		public static By add_btn = By.xpath(".//*[@id='btnAddMaster']");
		
		//project_type-name
		public static By project_type_name = By.xpath(".//*[@id='ddl1']");
		
		//Status
		public static By status_drpdown = By.xpath(".//*[@id='ddl3']");
		
		//save btn
		public static By save_btn = By.xpath(".//*[@id='SaveNewRecord']");
		
		//cancel btn
		public static By cancel_btn = By.xpath("//a[text()='Cancel']");
		
		//edit button
		public static By edit_btn = By.xpath(".//*[@id='Edit0']");
		
		//project type search
		public static By project_type_search_box = By.xpath(".//*[@id='1']");
		
		//search result
		public static By project_type_search_result = By.xpath(".//*[@id='fixTable']/tbody/tr[1]/td[2]");
		
		//success msg
		public static By success_msg = By.xpath(".//*[@id='alertsection']/div/strong");
		
		//update button
		public static By update_btn = By.xpath(".//*[@id='UpdateTT']");
		
		
	
	
	
}
