package com.RM.POM;

import org.openqa.selenium.By;

public class POM_Activity {

	//instancesetup
	public static By RM_instanceSetup = By.xpath(".//*[@id='mainmenu']/li[2]/a");
	//Shift
	public static By RM_Shift = By.xpath(".//*[@id='mainmenu']/li[2]/ul/li[3]");
	//Activity
	public static By RM_Activity = By.xpath(".//*[@id='mainmenu']/li[2]/ul/li[3]/ul/li[3]/a");
	//Project 
	public static By RM_Project = By.xpath(".//*[@id='project']");
	//ActivityDrpDwn 
	public static By RM_ActivityDrpDwn = By.xpath(".//*[@id='activity']");
	//Add Activity 
	public static By RM_AddActivity = By.xpath(".//*[@id='btnCreateTask']");
	//Activity Name 
	public static By RM_ActivityName = By.xpath(".//*[@id='activity-name-modal']");
	//Activity Group 
	public static By RM_ActivityGroup = By.xpath(".//*[@id='active-duration-modal']");
	//Activity Description 
	public static By RM_ActivityDescription = By.xpath(".//*[@id='activity-desc-modal']");
	//Save 
	public static By RM_Save = By.xpath(".//*[@id='save-activity']");
	//Save Message 
	public static By RM_SaveMessage = By.xpath(".//*[@id='success']/div");
}
