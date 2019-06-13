package com.RM.POM;

import org.openqa.selenium.By;

public class Leave_Approval_Obj {
	
	//Resource Planner
	public static By resource_planner = By.xpath(".//*[@id='mainmenu']/li/a/span[text()='Resource Planner']/..");
	
	//Leave Approval
	public static By leave_approval = By.xpath(".//*[@id='mainmenu']/li/a/span[text()='Resource Planner']/../../ul/li/a[text()='Leave Approval']");
	
	//Leave Calendar tab
	public static By leave_calendar = By.xpath(".//*[@id='render-body']/div[1]/div[3]/ul/li[1]/a");
	
	//Leave Workflow
	public static By leave_workflow = By.xpath(".//*[@id='render-body']/div[1]/div[3]/ul/li[2]/a");
	
	//User metrics tab
	public static By user_metrics= By.xpath(".//*[@id='render-body']/div[1]/div[3]/ul/li[3]/a");
	
	//Roster Calendar
	public static By roster_calendar= By.xpath(".//*[@id='render-body']/div[1]/div[3]/ul/li[4]/a");
	
	//Employee Search button
	public static By employee_search_btn= By.xpath(".//*[@id='render-body']/div[1]/div[3]/div[1]/div[2]/div[2]/button");

	//Employee ID input field
	public static By employee_id= By.xpath(".//*[@id='reporting-number-input-modal']");
	
	//First name input field
	public static By first_name= By.xpath(".//*[@id='reporting-first-name-modal']");
	
	//Employee Search
	public static By employee_search= By.xpath(".//*[@id='search-reporting-manager']");
	
	//Employee Select 
	public static By employee_select= By.xpath(".//*[@id='reporting-searched-table-modal']/tbody/tr/td[1]");
	
	//Next Calendar Year
	public static By nxt_cld_yr = By.xpath(".//*[@id='leaveCal']/div/div/div/div/div[1]/div[1]/div[3]/span");

	//Previous Calendar Year
	public static By prev_cld_yr = By.xpath(".//*[@id='leaveCal']/div/div/div/div/div[1]/div[1]/div[2]/span");
	
	//Current Month
	public static By current_month = By.xpath(".//*[@id='leaveCal']/div/div/div/div/div[1]/div[2]/div[1]");

	//Current Year
	public static By current_year = By.xpath(".//*[@id='leaveCal']/div/div/div/div/div[1]/div[1]/div[1]");

	//Previous month
	public static By prev_month = By.xpath(".//*[@id='leaveCal']/div/div/div/div/div[1]/div[2]/div[2]/span");

	//Next Month
	public static By nxt_month = By.xpath(".//*[@id='leaveCal']/div/div/div/div/div[1]/div[2]/div[3]/span");

	//Leave Workflow Leave Dropdown
	public static By leave_drpdwn= By.xpath(".//*[@id='leaveTypes']");
	
	//Comments field
	public static By commetns_field= By.xpath(".//*[@id='comm']");
	
	//Approve Leave button
	public static By approve_leave= By.xpath(".//*[@id='approveLeave']");
	
	//Deny Leave Button
	public static By deny_leave= By.xpath(".//*[@id='denyLeave']");

	//Close pop up button
	public static By close_btn= By.xpath(".//*[@id='ViewLeaveModal']/div/div/div[3]/button[4]");
	
	//Alert Message
	public static By alert_msg= By.xpath(".//*[@id='alertsectionONE']");
	
	//Menu Scroll
	public static By menu_scrl= By.xpath(".//*[@id='menuIcnSm']");
	
	
	
	
	
	
	
	
	
	

}
