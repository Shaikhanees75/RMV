package com.RM.POM;

import org.openqa.selenium.By;

public class Xnarf_Menus_obj
{
	// selection Wizard
	public static By xnarf = By.xpath(".//*[@id='mainmenu']/li[6]/a");

	// Xnarf Task
	public static By xnarf_task = By.xpath(".//*[@id='mainmenu']/li[6]/ul/li[1]/a");

	// Xnarf Wizard
	public static By xnarf_wizard = By.xpath(".//*[@id='mainmenu']/li[6]/ul/li[2]/a");

	//all radio button for all wizard type
	public static By all_wizard_type = By.xpath("//input[@name='optradio' and @type='radio']");

	//create or upload
	public static By create_type = By.xpath("//input[@name='reqType' and @type='radio']");

	//Add New Employee Radio button
	public static By Add_employee = By.id("Employees");

	//Transfer Platform(SOW) Radio button
	public static By SOW = By.id("SOW");

	//Change Manager Radio button
	public static By Change_Manager = By.id("Manager");

	//Change Designation Radio button
	public static By Change_Designation = By.id("Designation");

	//Change Seat Radio button
	public static By Change_Seat = By.id("Seat");

	//Terminate Employee(s) Radio button
	public static By Terminate_Employee = By.id("Termination");	

	//Next button
	public static By wizard_Next = By.id("btnSelectWizard");
	
	//Add New Record
	public static By Add_New_Record = By.id("Create");

	//Upload Records Record
	public static By Upload_Record = By.id("Upload");
	
	//Back On Request Type
	public static By Req_type_Back = By.id("backToChecklist");
	
	//Next On Request Type
		public static By Req_type_Next = By.id("nextToWizard");

}
