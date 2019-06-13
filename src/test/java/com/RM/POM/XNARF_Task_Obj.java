package com.RM.POM;

import org.openqa.selenium.By;

public class XNARF_Task_Obj {
	// selection Wizard
	public static By xnarf = By.xpath(".//*[@id='mainmenu']/li[6]/a");

	// XNARF Task
	public static By xnarf_task = By.xpath(".//*[@id='mainmenu']/li[6]/ul/li[1]/a");

	//Pending Request
	public static By pending_request = By.xpath(".//*[@id='WorkflowTabs']/ul/li[1]/a");
	
	//Pending Task
	public static By pending_task = By.xpath(".//*[@id='WorkflowTabs']/ul/li[2]/a");
	
			//Pending Default
			public static By pending_default = By.id("PendingTasks");
			//Pending OB
			public static By pending_ob = By.id("OB1");					
			//Pending RM
			public static By pending_rm = By.id("RM1");
				
			//Pending WP
			public static By pending_wp = By.id("WP1");
			
			//Pending WP Count
			public static By pending_wp_count = By.xpath(".//*[@id='PendingTasks']/div/div/div/div/label[4]");
			//Pending WPS
			public static By pending_wps = By.id("WPS1");
			
	//Completed Task
	public static By completed_task = By.xpath(".//*[@id='WorkflowTabs']/ul/li[3]/a");
	
			//Completed Default
			public static By completed_default = By.id("CompletedTasks");
		
			//Completed OB
			public static By completed_ob = By.id("OB2");
					
			//Completed RM
			public static By completed_rm = By.id("RM2");
				
			//Completed WP
			public static By completed_wp = By.id("WP2");
			
			//Completed WPS
			public static By completed_wps = By.id("WPS2");
	
	//Completed Request
	public static By completed_request = By.xpath(".//*[@id='WorkflowTabs']/ul/li[4]/a");
	
	//Request ID Filter
	public static By requestId_filter = By.id("0");
	
	//Request ID 
	public static By request_Id = By.id("1");
	
	//------------------------------Transfer SOW Screen-------------------------------//
	
	public static By Select_All = By.id("ddlAll");
	
	public static By Select_Single = By.id("ddl0");
	
	public static By Complete_Button = By.id("completeentry");
	
	public static By Split_Button = By.id("splitTask");
	
	public static By Delegate_Button = By.id("delegateentry");

	public static By Cancel_Button = By.id("cancelentry");
	
	//Employee ID Filter
	public static By EmployeeId_filter = By.id("4");
	
	//Request ID
	public static By Employee_Id = By.id("1");
	
	//Locked By 1st Row
	public static By locked_by = By.xpath(".//*[@id='fixTable']/tbody/tr[1]/td[17]");
	
	//Status 1st Row
	public static By status = By.xpath(".//*[@id='fixTable']/tbody/tr[1]/td[18]");
	
	//Current SOW Grid
	public static By current_sow_grid = By.xpath(".//*[@id='fixTable']/tbody/tr[1]/td[10]");
	
	//New SOW Grid
	public static By new_sow_grid = By.xpath(".//*[@id='fixTable']/tbody/tr[1]/td[11]");
	
	//New Effective Date Grid
	public static By effective_date_grid = By.xpath(".//*[@id='fixTable']/tbody/tr[1]/td[13]");
	
	//New access type Grid
	public static By access_type_grid = By.xpath(".//*[@id='fixTable']/tbody/tr[1]/td[14]");
	
	//comments
	public static By comments_grid = By.xpath(".//*[@id='fixTable']/tbody/tr[1]/td[15]");

	
	//Message Pop up
	public static By message_popup = By.xpath("html/body/div[3]/div/div/div[1]/div");
	
	//Message Ok button
		public static By message_ok = By.xpath("html/body/div/div/div/div[2]/button");
	
	//Delegate dropdown
	public static By delegate_drpdwn = By.id("delegate-input");	
		
	//Current SOW Screen
	public static By current_sow_screen = By.id("functional-current_client-modal");
		
	//New SOW Screen
	public static By new_sow_screen = By.id("functional-new-client-modal");
		
	//New Effective Date Screen
	public static By effective_date_screen = By.id("effective-date-input");
		
		//Seat Number
		public static By seat_no_screen = By.id("newseat-number-sow");
		
		//New access type Screen
		public static By access_type_dpdwn = By.xpath(".//*[@id='HTMLAccesstype']/div/div/span/div/ul/li[1]/a/label/input");
		
		//comments Screen
		public static By comments_screen = By.id("functional-comments-name-modal-sow");
		
		//Save
		public static By save_button = By.id("submitentrysow");
		
		//Back button
		public static By back_button = By.id("btncancelsowwp");
		
		//Reset button
		public static By reset_button = By.id("btnResetWPSOW");
		
		//Warning message
		public static By warning_message = By.xpath(".//*[@id='alertsection']/div");
		
		//Accept pop up
		public static By accept_button = By.id("acceptentry");
		
		//Save pop up
		public static By save_ok = By.xpath("html/body/div/div/div/div[2]/button");
		
		
		//-----------------------Termination screen------------------------------------------//
		//Preferred Name
		public static By tr_preferred_name = By.id("functional-preffered-name-modal-terminate");
		
		//Current client
		public static By tr_current_client = By.id("functional-current_client-modal-terminate");
		
		//Separation Date
		public static By tr_separation_date = By.id("separation-date-input");
		
		//Last Day worked
		public static By tr_last_day = By.id("last-date-input");
		
		
		//Dynamic for Building key collected
		//.//*[@id='inlineRadioBuildingNo'][contains(@value,'No')]
		
		//Dynamic for Desk key collected
		//.//*[@id='inlineRadioDeskNo']
		
		//Badge Key Check box
		public static By tr_badge_key = By.id("inlineRadioBadgeYes");
		
		public static By tr_ph_access = By.xpath(".//*[@id='HTMLPhysicalAccesstype']/div/div/span/div/ul/li[1]/a/label/input");
		
		//Comments
		public static By tr_comments = By.id("functional-comments-name-modal-terminate");
		
		//I_Certify	
		public static By tr_iCertify = By.id("ICertifyTERMINATE");
		
		//Save
		public static By tr_save_button = By.id("submitentryterminate");
				
		//Back button
		public static By tr_back_button = By.id("btnTerminateCancel");
				
		//Reset button
		public static By tr_reset_button = By.id("btnResetWPTERMINATE");
		
		//Preferred Name
				public static By tr_preferred_name_grid = By.xpath(".//*[@id='fixTable']/tbody/tr/td[7]");
				
				//Current client
				public static By tr_current_client_grid = By.xpath(".//*[@id='fixTable']/tbody/tr/td[11]");
				
				//Separation Date
				public static By tr_separation_date_grid = By.xpath("//*[@id='fixTable']/tbody/tr/td[12]");
				
				//Last Day worked
				public static By tr_last_day_grid = By.xpath("/*[@id='fixTable']/tbody/tr/td[13]");
				
				//Physical Access removed
				public static By tr_physical_access = By.xpath("/*[@id='fixTable']/tbody/tr/td[14]");
		
				//Badge Key
				public static By tr_badge_key_grid = By.xpath("/*[@id='fixTable']/tbody/tr/td[15]");
				
				//Building key
				public static By tr_building_key_grid = By.xpath("/*[@id='fixTable']/tbody/tr/td[16]");
				
				//Desk key
				public static By tr_desk_key_grid = By.xpath("/*[@id='fixTable']/tbody/tr/td[17]");

				//Comments
				public static By tr_comments_grid = By.xpath("/*[@id='fixTable']/tbody/tr/td[19]");
				
				//Locked by 
				public static By tr_locked_by_grid = By.xpath("/*[@id='fixTable']/tbody/tr/td[21]");			

				//Status
				public static By tr_status_grid = By.xpath("/*[@id='fixTable']/tbody/tr/td[22]");
				
				//--------------------Change Seat Screen----------------------------------//
				//Preferred Name
				public static By cs_preferred_name = By.id("functional-SEATpreffered-name-modal");
				
				//Current client
				public static By cs_client_name = By.id("functional-client-name-modal");
				
				//Effective Date
				public static By cs_effective_date = By.id("functional-Effective-Date-modal");
				
				//Seat Number
				public static By cs_seat_number = By.id("functional-newseat-number-modal");
				
				//Comments
				public static By cs_comments = By.id("functional-comments-name-modal");
				
				//Save
				public static By cs_save_button = By.id("submitentry");
						
				//Back button
				public static By cs_back_button = By.id("btnBackWP");
						
				//Reset button
				public static By cs_reset_button = By.id("btnResetWP");
				
				//Preferred Name
				public static By cs_preferred_name_grid = By.xpath(".//*[@id='fixTable']/tbody/tr/td[15]");
				
				//Current client
				public static By cs_client_name_grid = By.xpath(".//*[@id='fixTable']/tbody/tr/td[14]");
				
				//Effective Date
				public static By cs_effective_date_grid = By.xpath(".//*[@id='fixTable']/tbody/tr/td[19]");
				
				//Comments
				public static By cs_comments_grid = By.xpath(".//*[@id='fixTable']/tbody/tr/td[21]");
				
				//Locked By
				public static By cs_locked_by = By.xpath(".//*[@id='fixTable']/tbody/tr/td[23]");
				
				//Locked By
				public static By cs_status = By.xpath(".//*[@id='fixTable']/tbody/tr/td[24]");
				
				
				
							
}
