package com.RM.POM;

import org.openqa.selenium.By;

public class Project_Deatils_Obj {

	//resource planner
		public static By instance_setup = By.xpath(".//*[@id='mainmenu']/li[3]/a");
		
	//demographics
		public static By demographics = By.xpath(".//*[@id='mainmenu']/li[3]/ul/li[1]/a");
		
	//Project master
		public static By project_masters = By.xpath(".//*[@id='mainmenu']/li[3]/ul/li[4]/a");
		
		//industry
		public static By industry = By.xpath(".//*[@id='mainmenu']/li[3]/ul/li[4]/ul/li[1]/a");
		
		//project details
		public static By project_details = By.xpath(".//*[@id='mainmenu']/li[3]/ul/li[4]/ul/li[3]/a");
		
		//add btn
		public static By add_btn = By.xpath(".//*[@id='btnAddProject']");
		
		//project name
		public static By project_name = By.xpath(".//*[@id='txtProjectName']");
		
		//client_drpdown
		public static By client_drpdown = By.xpath(".//*[@id='ddlclient']");
		
		//industry_icon
		public static By industry_icon = By.xpath(".//*[@id='projMstdetails']/div[4]/div[1]/div/div/div/div/div/button");
		
		//industry_search
		public static By industry_search= By.xpath(".//*[@id='input-industry-search']");
		
		//search_btn
		public static By search_btn = By.xpath(".//*[@id='btn-indsutry-search']");
		
		//search result .//*[@id='industrytreeview']/ul/li[text()='MS']
		
		//project_work-hrs
		public static By project_work_hrs = By.xpath(".//*[@id='workHours']");
		
		//project_type
		public static By project_type = By.xpath(".//*[@id='ddlprojtype']");
		
		//project group_icon
		public static By project_group = By.xpath(".//*[@id='#btnProjGrpSearch']");
		
		//project_group_search
		public static By project_group_search_box = By.xpath(".//*[@id='input-projgrp-search']");
		
		//project_grp_search
		public static By project_grp_search = By.xpath(".//*[@id='btn-projgrp-search']");
		
		//project_search result .//*[@id='projectgrptreeview']/ul/li[text()='Dom']
		
		//start date
		public static By start_date = By.xpath(".//*[@id='projMstdetails']/div[2]/div[2]/div/div/div/div[1]/div/span");
		
		//enddate
		public static By end_date = By.xpath(".//*[@id='projMstdetails']/div[2]/div[2]/div/div/div/div[2]/div/span/img");
		
		//active_checkbox
		public static By active_checkbox = By.xpath(".//*[@id='active']");
		
		//save-btn
		public static By save_btn = By.xpath(".//*[@id='SaveProjectDetails']");
		
		//reset btn
		public static By reset_btn = By.xpath(".//*[@id='resetDetails']");
		
		//deliver location
		public static By deliver_location = By.xpath(".//*[@id='navbody']/ul/li[2]/a");
		
		//success_msg
		public static By success_msg = By.xpath(".//*[@id='alertsection']/div/strong");
		
		public static By cntr_mnth = By.xpath("html/body/div[3]/div[1]/table/thead/tr[2]/th[2]");
		
		public static By  nxt_yr= By.xpath("html/body/div[3]/div[2]/table/thead/tr[2]/th[3]");
		
		public static By  prev_yr= By.xpath("html/body/div[3]/div[2]/table/thead/tr[2]/th[1]");
		
		public static By  month_table= By.xpath("html/body/div[3]/div[2]/table/tbody/tr/td/span");
	
		//-----------------delivery location
		//add delivery
		public static By add_location = By.xpath(".//*[@id='btnAddLocation']");
		//location_search
		public static By location_search = By.xpath(".//*[@id='input-location-search']");
		
		//loction_serach_btn
		public static By loction_serach_btn= By.xpath(".//*[@id='btn-location-search']");
		
		//search result -- .//*[@id='locationtreeview']/ul/li[text()='Mumbai']//span[@class='icon check-icon glyphicon glyphicon-unchecked']
		
		//location_save
		public static By location_save = By.xpath(".//*[@id='save-input-button']");
		
		//location_reset
		public static By location_reset = By.xpath(".//*[@id='reset-input-button']");
		
		
		//delete location
		public static By delete_location = By.xpath(".//*[@id='fixTable']/tbody/tr[1]/td[1]/a");
		
		//.//*[@id='fixTable']/tbody/tr/td[contains(text(),'Prestige Technopolis')]
	
}
