package com.RM.POM;

import org.openqa.selenium.By;

public class OB_NewHire_Obj {

	//Xnarf logo
	public static By xnarf_logo = By.xpath(".//*[@id='mainmenu']/li[6]/a");

	//Xnarf task
	public static By xnarf_task = By.xpath("//*[@id='mainmenu']/li[6]/ul/li[2]/a");
	
	//pending tasks
	public static By pending_tasks = By.xpath(".//*[@id='WorkflowTabs']/ul/li[2]/a");
	
	//Default radio button
	public static By Default_btn = By.xpath(".//*[@id='PendingTasks']/div/div/div/div/label[1]");
	
	//OB radio button
	public static By OB_btn =  By.xpath(".//*[@id='PendingTasks']/div/div/div/div/label[2]");
	
	//Rm button
	public static By RM_btn =  By.xpath(".//*[@id='PendingTasks']/div/div/div/div/label[3]");
	
	//Wp radio button
	public static By WP_btn = By.xpath(".//*[@id='PendingTasks']/div/div/div/div/label[4]");
	
	//WPS radio button
	public static By WPS_btn = By.xpath(".//*[@id='PendingTasks']/div/div/div/div/label[5]");
	
	//Request id tab
	public static By request_id = By.id("0");
	
	// 1st option appearing after search
	public static By option1 = By.id("1");

	//radio button
	public static By radio_btn = By.id("ddl0");
	
	//select all check box
	public static By select_all_check_box = By.xpath(".//*[@id='ddlAll']");
			
	// Split button
	public static By split_btn = By.id("btnSplit");
			
	//back button
	public static By back_btn =  By.xpath(".//*[@id='render-body']/div[3]/div[6]/div/button[3]");
	
	//cancel button
	public static By cancel_btn =  By.xpath(".//*[@id='cancelentry']");
	
	//Delegate button
	public static By delegate_btn =  By.xpath(".//*[@id='delegateentry']");
	
	//complete button
	public static By complete_btn =  By.xpath(".//*[@id='completeentry']");
	
	//download request button
	public static By download_btn =  By.xpath(".//*[@id='btnDownload']");
	
	//delegate to dropdown	
	public static By delegate_dropdown =  By.xpath(".//*[@id='delegate-input']");
	
	//for the record on which action needs to be performed
	public static By record_action =  By.xpath(".//*[@id='1']");
	
	//OB Wbs charges
	public static By OB_Wbs =  By.xpath(".//*[@id='WBSOb']");
	
	//phone request dropdown
	public static By Phone_request_dropdown =  By.xpath(".//*[@id='contentEntryCommon']/div[8]/div[1]/div/span/div/button");
	
	//drop down option- select all
	public static By optn_select_all =  By.xpath(".//*[@id='contentEntryCommon']/div[8]/div[1]/div/span/div/ul/li[1]/a/label/input");
	
	//request dropdown select all option
	public static By Req_select_all = By.xpath(".//*[@id='contentEntryCommon']/div[8]/div[2]/div/span/div/ul/li[1]/a/label/input");
	
	//Request drop down
	public static By request_dropdwon = By.xpath(".//*[@id='contentEntryCommon']/div[8]/div[2]/div/span/div/button");
	//job specific need
	public static By job_need_comment =  By.xpath(".//*[@id='jobdataTextareaOb']");
	
	//comments
	public static By comments =  By.xpath(".//*[@id='commentsOb']");
	
	//click anywhere
	public static By anywhere = By.xpath(".//*[@id='contentEntryCommon']/div[9]/div[2]/div/div/label");
	
	//Save button
	public static By Save_btn =  By.xpath(".//*[@id='btnSaveOB']");
	
	//Reset button
	public static By reset_btn =  By.xpath(".//*[@id='btnResetWPOB']");
	
	//office location
	public static By office_loc =  By.xpath(".//*[@id='locOb']");
	
	//search icon
	public static By Search_icon = By.xpath(".//*[@id='contentEntryCommon']/div[7]/div[1]/div/div/div/button");
	
	//Advanced search
	public static By advanced_search = By.xpath(".//*[@id='contentEntryCommon']/div[7]/div[1]/div/div/div/div/a");
		
	/*location1
	public static By loc1 = By.xpath(".//*[@id='locationtreeview']/ul/li[2]/span[2]");
	//loc2
	public static By loc2 = By.xpath(".//*[@id='locationtreeview']/ul/li[3]/span[3]");
	//loc3
	public static By loc3 = By.xpath(".//*[@id='locationtreeview']/ul/li[4]/span[4]");
	*/
	
	//loc4
	public static By loc = By.xpath(".//*[@id='locationtreeview']/ul/li[5]");//*[@id='locationtreeview']/ul/li[5]
	
	//seat search icon
	public static By seat_search_icon = By.xpath(".//*[@id='contentEntryCommon']/div[7]/div[2]/div/div/div/button");
	
	//seat advanced search 
	public static By seat_advanced_search  = By.xpath(".//*[@id='contentEntryCommon']/div[7]/div[2]/div/div/div/div/a");
	
	//training seat--- need to keep it dynamic
	//.//*[@id='seat-table-modal']/tbody/tr[17]/td[2]
	
	//tree search
	
	public static By tree_search = By.xpath(".//*[@id='input-location-search']");
	
	//tree search icon
	
	public static By tree_search_icon =  By.xpath(".//*[@id='btn-location-search']");
	
	//search seat
	public static By search_seat = By.xpath(".//*[@id='input-seat-search']");
	
	//Search button
	
	public static By search_btn = By.xpath(".//*[@id='btn-seat-search']");
	
	//ok button
	
	public static By Ok_btn = By.xpath("//button[@class='btn btn-primary']");
	
	////employee id
	public static By employee_id = By.xpath(".//*[@id='4']");
	
	//status
	public static By status = By.xpath(".//*[@id='fixTable']/tbody/tr[1]/td[9]");
	
	//completed OB 
	public static By completed_OB = By.xpath(".//*[@id='OB2']");
	
	//completed RM
	public static By completed_RM = By.xpath(".//*[@id='RM2']");
	
	//Completed WP
	public static By completed_WP = By.xpath(".//*[@id='WP2']");
	
	//cpmpleted WPS
	public static By completed_WPS = By.xpath(".//*[@id='WPS2']");
	
	
}
