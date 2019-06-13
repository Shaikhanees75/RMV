package com.RM.POM;

import org.openqa.selenium.By;

public class Skill_Workflow_Obj {
	//resource planner
		public static By resource_planner = By.xpath(".//*[@id='mainmenu']/li[6]/a");
		
		//skill
		public static By skill= By.xpath("//*[@id='mainmenu']/li/ul/li/a[text()='Skill']");
		//*[@id="mainmenu"]/li[6]/ul/li[4]/a
		
		//demand
		public static By demand = By.xpath(".//*[@id='mainmenu']/li[6]/ul/li[1]/a");
	
		//skill Change request
		public static By skill_change = By.xpath("//*[@id='mainmenu']/li[6]/ul/li[4]/ul/li[1]/a");
		
		//skill Work flow
		public static By skill_workflow = By.xpath(".//*[@id='mainmenu']/li[6]/ul/li[4]/ul/li[2]/a");
		
		//competency search box
		public static By competency_search = By.xpath(".//*[@id='4']");
		
		//checkbox
		public static By check_box = By.xpath(".//*[@id='fixTable']/tbody/tr[1]/td[1]//input[@id='ddl0']");
		
		//approve btn
		public static By approve_btn = By.xpath(".//*[@id='btnApprove']");
		
		//Reject btn
		public static By reject_btn = By.xpath(".//*[@id='btnReject']");
		
		//skill approval status
		public static By skill_status = By.xpath(".//*[@id='skillApprovalTypes']");
		
	
	
	
		
		
		
		
		
		
		
		
		
		
		
	
	
	
	

}
