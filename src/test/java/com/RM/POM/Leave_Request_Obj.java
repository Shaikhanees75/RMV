package com.RM.POM;

import org.openqa.selenium.By;

public class Leave_Request_Obj {

	//Resource Planner
	public static By resource_planner = By.xpath(".//*[@id='mainmenu']/li[5]/a");
	
	//Leave Request
	public static By leave_request = By.xpath(".//*[@id='mainmenu']/li[5]/ul/li/a[text()='Leave Request']");
	
	//Leave Approval
	public static By leave_approval = By.xpath(".//*[@id='mainmenu']/li[5]/ul/li/a[text()='Leave Approval']");
	
	//Calendar from date
	public static By from_date = By.xpath(".//*[@id='SingleEntry']/div/div/div[2]/div[1]/div[3]/div/div/span");
	
	//Calendar to date
	public static By to_date = By.xpath(".//*[@id='SingleEntry']/div/div/div[2]/div[2]/div[3]/div/div/span");
	
	//Current Month
	public static By current_month = By.xpath(".//*[@id='leaveCal']/div/div/div/div/div[1]/div[2]/div[1]");
	
	//Current Year
	public static By current_year = By.xpath(".//*[@id='leaveCal']/div/div/div/div/div[1]/div[1]/div[1]");
	
	//Previous month
	public static By prev_month = By.xpath(".//*[@id='leaveCal']/div/div/div/div/div[1]/div[2]/div[2]/span");
	
	//Next Month
	public static By nxt_month = By.xpath(".//*[@id='leaveCal']/div/div/div/div/div[1]/div[2]/div[3]/span");
	
	//Next Calendar Year
	public static By nxt_cld_yr = By.xpath(".//*[@id='leaveCal']/div/div/div/div/div[1]/div[1]/div[3]/span");
	
	//Previous Calendar Year
	public static By prev_cld_yr = By.xpath(".//*[@id='leaveCal']/div/div/div/div/div[1]/div[1]/div[2]/span");
	
	//Center of the month
	public static By cntr_mnth = By.xpath("html/body/div[4]/div[1]/table/thead/tr[2]/th[2]");
			
	//Next Year
	public static By nxt_yr = By.xpath("html/body/div[4]/div[2]/table/thead/tr[2]/th[3]");
	
	//Prev Year
	public static By prev_yr = By.xpath("html/body/div[4]/div[2]/table/thead/tr[2]/th[1]");
	
	//Apply Leave
	public static By apply_leave = By.id("ApplyLeaveCLDR");
	
	//Leave type dropdown
	public static By leave_type= By.xpath(".//*[@id='DDLLeaveType']");
	
	//Leave Start Time
	public static By start_time= By.xpath(".//*[@id='timepicker1']");
	
	//Duration per day
	public static By leave_duration=By.xpath(".//*[@id='timepicker2']");
	
	//I certify check box
	public static By i_certify =By.xpath(".//*[@id='ICertify']");
	
	//Submit button
	public static By submit_btn =By.xpath(".//*[@id='submitentry']");
	
	//Reset button
	public static By reset_btn =By.xpath(".//*[@id='SingleEntry']/div/div/div[3]/button[2]");
	
	//Close button
	public static By close_btn =By.xpath(".//*[@id='modalaaheader']/button");
	
	//Leave Workflow tab
	public static By leave_workflow = By.xpath(".//*[@id='render-body']/div[1]/div[3]/ul/li[2]/a");
	
	//Leave Calendar tab
	public static By leave_calendar = By.xpath(".//*[@id='render-body']/div[1]/div[3]/ul/li[1]/a");
	
	//User Metrics
	public static By user_metrics = By.xpath(".//*[@id='render-body']/div[1]/div[3]/ul/li[3]/a");
	
	//Month table
	public static By month_table = By.xpath(".//div[@class='datepicker datepicker-dropdown dropdown-menu datepicker-orient-left datepicker-orient-bottom']/div[@class='datepicker-months']/table/tbody/tr/td/span");
	
	//Date Table
	public static By date_table= By.xpath(".//div[@class='datepicker datepicker-dropdown dropdown-menu datepicker-orient-left datepicker-orient-bottom']/div[@class='datepicker-days']/table/tbody/tr/td[@class='day']");
	
	//Warning Message under pop up
	public static By warn_msg= By.xpath(".//*[@id='alertsection']/div");
	
	//Dynamic pop up date
	public static By dyn_pop_date= By.xpath("html/body/div[4]/div[1]/table/tbody/tr/td[@class='day'][text()='1']");
	
	//Cancel Leave Button
	public static By cancel_leave= By.xpath(".//*[@id='btnCancle']");
	
	
	//Leave Request Count
	public static By Leave_count= By.xpath(".//*[@id='leaveTypes']/option[1]");
	
	
	
	
	//-------------------- Leave Workflow ----------------------------------------//
	
	//Leave Status
	public static By leave_status = By.xpath(".//*[@id='leaveTypes']");
	
	
	
	
	
	
}
