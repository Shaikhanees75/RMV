package com.RM.POM;

import org.openqa.selenium.By;

public class Location_hierarchy_obj {

		//Instance Setup
		public static By instance_setup = By.xpath(".//*[@id='mainmenu']/li[2]/a");
		
		//Hierarchy Master
		public static By hierarchy_master= By.xpath(".//*[@id='mainmenu']/li[2]/ul/li[2]/a");
		
		//Location Master
		public static By location = By.xpath(".//*[@id='mainmenu']/li[2]/ul/li[2]/ul/li[2]/a");
		
		//Process Type Drop down
		public static By process_type = By.xpath(".//*[@id='selectMasterList']");
		
		//Expand All button
		public static By expand_all = By.xpath(".//*[@id='btnExpand']");
		
		//last node
		public static By last_node = By.xpath(".//*[@id='organizationhierarchytreeview']/ul/li[10]");
		
		//new last node
		public static By new_last_node = By.xpath(".//*[@id='organizationhierarchytreeview']/ul/li[11]");
		
		//Add location button
		public static By add_loc_btn = By.xpath(".//*[@id='btnAddMaster']");
		
		//Edit button
		public static By edit_btn = By.xpath(".//*[@id='Edit0']");
		
		//Edit Location entry
		public static By edit_loc_name = By.xpath(".//*[@id='ddl2']");
		
		//Add organization text field
		public static By add_loc = By.xpath(".//*[@id='hierarchy-name-input-modal']");
		
		//Save button
		public static By save_btn= By.xpath(".//*[@id='add-hierarchy']");
		
		//Close button
		public static By close_btn= By.xpath(".//*[@id='locHierarchy']/div/div/div[3]/button[2]");
		
		//Update button
		public static By update_btn= By.xpath(".//*[@id='UpdateTT']");
		
		//Cancel Button
		public static By cancel_btn= By.xpath(".//*[@id='trTemp']/td[1]/a[2]");
		
		//Warning message
		public static By alert_msg= By.xpath(".//*[@id='alertsection']/div");
		
		//-------------------------For Location Master------------------//
		
		//Add location master text field
		public static By add_location = By.xpath(".//*[@id='location-name-input-modal']");
		
		//Add Location Description
		public static By add_location_descrp = By.xpath(".//*[@id='location-desc-input-modal']");
				
		//Add Active check
		public static By add_active_chk = By.xpath(".//*[@id='location-chk-input-modal']");
		
		//Save button
		public static By save_org_btn= By.xpath(".//*[@id='add-loc']");
		
		//Close button
		public static By close_org_btn= By.xpath(".//*[@id='locDetails']/div/div/div[3]/button[2]");
		
		//Edit Active check
		public static By edit_active_chk = By.xpath(".//*[@id='ddl8']");
		
		//Add Location Description
		public static By edit_location_descrp = By.xpath(".//*[@id='ddl3']");
		
		
		
}

