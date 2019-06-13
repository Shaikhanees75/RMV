package com.RM.POM;

import org.openqa.selenium.By;

public class Organization_Hierarchy_Obj {
	
	//Instance Setup
	public static By instance_setup = By.xpath(".//*[@id='mainmenu']/li[2]/a");
	
	//Hierarchy Master
	public static By hierarchy_master= By.xpath(".//*[@id='mainmenu']/li[2]/ul/li[2]/a");
	
	//Location Master
	public static By location = By.xpath(".//*[@id='mainmenu']/li[2]/ul/li[2]/ul/li[2]/a");
	
	//Organization master
	public static By organization = By.xpath(".//*[@id='mainmenu']/li[2]/ul/li[2]/ul/li[1]/a");
	
	//Process Type Drop down
	public static By process_type = By.xpath(".//*[@id='selectMasterList']");
	
	//Expand All button
	public static By expand_all = By.xpath(".//*[@id='btnExpand']");
	
	//last node
	public static By last_node = By.xpath(".//*[@id='organizationhierarchytreeview']/ul/li[9]");
	
	//new last node
	public static By new_last_node = By.xpath(".//*[@id='organizationhierarchytreeview']/ul/li[10]");

	//Add Organization Hierarchy button
	public static By add_org_btn = By.xpath(".//*[@id='btnAddMaster']");
	
	//Edit button
	public static By edit_btn = By.xpath(".//*[@id='Edit0']");
	
	//Edit Organization Hierarchy entry
	public static By edit_org_name = By.xpath(".//*[@id='ddl2']");
	
	//Add organization hierarchy text field
	public static By add_org = By.xpath(".//*[@id='hierarchy-name-input-modal']");
	
	//Save button
	public static By save_btn= By.xpath(".//*[@id='add-hierarchy']");
	
	//Close button
	public static By close_btn= By.xpath(".//*[@id='orgHierarchy']/div/div/div[3]/button[2]");
	
	//Update button
	public static By update_btn= By.xpath(".//*[@id='UpdateTT']");
	
	//Cancel Button
	public static By cancel_btn= By.xpath(".//*[@id='trTemp']/td[1]/a[2]");
	
	//Warning message
	public static By alert_msg= By.xpath(".//*[@id='alertsection']/div");
	
	//----------------------For Organization Master-------------------//
	
	
	//Add organization hierarchy text field
	public static By add_organization = By.xpath(".//*[@id='organization-name-input-modal']");
	
	//Add Active check
	public static By add_active_chk = By.xpath(".//*[@id='organization-chk-input-modal']");
	
	//Save button
	public static By save_org_btn= By.xpath(".//*[@id='add-org']");
	
	//Close button
	public static By close_org_btn= By.xpath(".//*[@id='orgDetails']/div/div/div[3]/button[2]");
	
	//Edit Active check
	public static By edit_active_chk = By.xpath(".//*[@id='ddl7']");
	
	//Tree Span button 1
	public static By tree_span1 = By.xpath(".//*[@id='organizationhierarchytreeview']/ul/li[2]/span[2]");
	
	//Tree Span button 2
	public static By tree_span = By.xpath(".//*[@id='organizationhierarchytreeview']/ul/li[2]/span[3]");
	
}
