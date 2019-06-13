package com.RM.POM;

import org.openqa.selenium.By;

public class Single_Value_Master_obj 
{
	/*Master Type Drop Down*/
	public static By Master_type = By.id("selectMasterList");
	
	/*Add Master Button*/
	public static By Add_btn = By.id("btnAddMaster");
	
	/*Search Text Box*/
	public static By Search_text_box = By.id("searchContent");
	
	/*Search Button*/
	public static By Search_btn = By.id("btnSearch");
	
	/*Searched Value*/
	public static By Searched_value = By.xpath(".//*[@id='fixTable']/tbody/tr/td[3]");
	
	/*Add Master Name*/
	public static By Add_Name = By.id("ddl2");
	
	/*Designation_Description*/
	public static By Designation_Description = By.id("ddl3");
	
	/*Designation_Description*/
	public static By Is_Holiday_Required = By.id("ddl6");
	
	/*Activity Group Desc */
	public static By Activity_Group_Desc  = By.id("ddl4");
	
	/*Active Drop Down*/
	public static By Active = By.id("ddl5");
	
	/*Save Btn*/
	public static By Save = By.id("SaveNewRecord");
	
	/*Cancel Btn*/
	public static By Cancel = By.xpath(".//*[@id='trTemp']/td[1]/a[2]");
	
	/*Edit Button*/
	public static By Edit = By.id("Edit0");
	
	/*Update Button*/
	public static By Update = By.id("UpdateTT");
	
	/*Message*/
	public static By Success_msg= By.xpath(".//*[@id='alertsection']/div");
	
	
	
	
	
	
	
	
}
