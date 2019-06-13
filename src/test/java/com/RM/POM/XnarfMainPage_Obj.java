package com.RM.POM;

import org.openqa.selenium.By;

public class XnarfMainPage_Obj {
	
	//Xnarf logo
			public static By xnarf_logo = By.xpath("//*[@id='mainmenu']/li[7]/a");
	
	//Xnarf task
		public static By xnarf_task = By.xpath("//*[@id='mainmenu']/li[7]/ul/li[1]/a");
	
	//TR000038 -----ye dhundna hai tujhe
	//Request id tab
		public static By request_id = By.id("0");
		
	// 1st option appearing after search
		public static By option1 = By.id("1");
	
	//radio button
		public static By radio_btn = By.id("ddl0");
		
	//delete button
		public static By delete_btn = By.id("btnDelete");
		
	// Split button
		public static By split_btn = By.id("btnSplit");
		
	//back button
		public static By back_btn =  By.xpath(".//*[@id='render-body']/div[3]/div[6]/div/button[3]");
		
	//confirm button
		public static By cnf_btn = By.xpath("html/body/div[2]/div/div/div[2]/button[2]");
		
	//Pending request
		public static By pending_req = By.xpath(".//*[@id='WorkflowTabs']/ul/li[1]/a");
		
	//pending tasks
		public static By pending_tasks = By.xpath(".//*[@id='WorkflowTabs']/ul/li[2]/a");
		
	//completed tasks
		public static By completed_tasks = By.xpath(".//*[@id='WorkflowTabs']/ul/li[3]/a");
		
	//completed requests
		public static By completed_req = By.xpath(".//*[@id='WorkflowTabs']/ul/li[4]/a");
	
	//Ok button
		public static By ok_btn = By.xpath("html/body/div[2]/div/div/div[2]/button");
	
	
		
	

}
