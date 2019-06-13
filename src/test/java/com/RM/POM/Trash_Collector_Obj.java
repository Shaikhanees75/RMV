package com.RM.POM;

import org.openqa.selenium.By;

public class Trash_Collector_Obj {
	
	
	//Resource Planner
	public static By resource_planner = By.xpath(".//*[@id='mainmenu']/li[5]/a");
	
	//Trash Collector
	public static By trash_collector = By.xpath("//*[@id='mainmenu']/li[5]/ul/li[7]/a");
	
	//Organization Select
	public static By organization_select=By.xpath(".//*[@id='render-body']/div[2]/div[2]/div/div[1]/div/div/div/div/button");
	
	//Organization Search
	public static By organization_search=By.xpath(".//*[@id='input-organisation-search']");
	
	//Organization Search button
	public static By organization_search_btn=By.xpath(".//*[@id='btn-organisation-search']");
	
	
	//Leave Expiration
	public static By leave_select=By.xpath(".//*[@id='functional-LeaveExpiration-name-modal']");
	
	
	//Edit button
	public static By edit_btn=By.xpath(".//*[@id='Edit0']");

	//Leave Expiration Edit
	public static By leave_enter=By.xpath(".//*[@id='ddl3']");
	
	//Delete Button
	public static By delete_btn=By.xpath(".//*[@id='fixTable']/tbody/tr[1]/td[1]/a[2]");
	
	//Organization Filter
	public static By org_filter=By.xpath(".//*[@id='2']");
	
	//Leave Filter
	public static By leave_filter=By.xpath(".//*[@id='3']");
	
	//Save button
	public static By save_button=By.xpath(".//*[@id='completeentry']");
	
	//Update button
	public static By update_button=By.xpath(".//*[@id='UpdateTT']");
	
	//Cancel button
	public static By cancel_button=By.xpath(".//*[@id='trTemp']/td[1]/a[2]");
	
	//Warning message
	public static By warning_msg=By.xpath(".//*[@id='alertsection']/div");
	
			
}


