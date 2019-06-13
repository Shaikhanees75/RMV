package com.RM.POM;

import org.openqa.selenium.By;

public class Skill_Competency_Obj {
	
	//competency details
public static By competency_details = By.xpath(".//*[@id='comp-type']");

//Add competency button
public static By Add_competency = By.xpath(".//*[@id='btnAdd']");

//competency name
public static By competency_name = By.xpath(".//*[@id='compTitle']");

//competency desc
public static By competency_desc = By.xpath(".//*[@id='compDesc']");

//industry type
	public static By industry_type= By.xpath("//button[@class='multiselect dropdown-toggle form-control']");
	
	//select all
	public static By select_all = By.xpath("//*[@id='AddComp']/div/div/div[2]/div/div[2]/div[1]/div/div/div/span/div/ul/li[1]/a/label/input");
	
	//validity
	public static By validity = By.xpath(".//*[@id='compValidity']");
	
	//min prof
	public static By min_prof = By.xpath(".//*[@id='minProf']");
	
	//max prof
	public static By max_prof = By.xpath(".//*[@id='maxProf']");
	
	//Active check box
	public static By Active_box = By.xpath(".//*[@id='compActive']");
	
	//add pre-requisites button
	public static By requisite_btn = By.xpath(".//*[@id='addPreReqRow']");
	
	//competency type
	public static By comptency_type = By.xpath(".//*[@id='dynamicControl']/div[1]/div[1]/div/select");
	
	
	//Competency drop down
	public static By competency = By.xpath(".//*[@id='dynamicControl']/div[1]/div[2]/div/select");
	
	//prficiency drop down
	public static By prof = By.xpath(".//*[@id='dynamicControl']/div[1]/div[3]/div/select");
	
	//delete btn
	public static By delete_btn = By.xpath(".//*[@id='dynamicControl']/div[2]/div[4]/button");
	
	//Reset btn
	public static By reset_btn= By.xpath(".//*[@id='resetComp']");
	
	//save btn
	public static By save_btn = By.xpath(".//*[@id='saveComp']");
	
	//cancel btn
	public static By cancel_btn = By.xpath(".//*[@id='AddComp']/div/div/div[3]/button[3]");
	
	//edit nbtn
	public static By edit_btn = By.xpath(".//*[@id='Edit0']");
	
	//Title
	public static By title= By.xpath(".//*[@id='1']");
	
	//first searched
	public static By search_result = By.xpath(".//*[@id='fixTable']/tbody/tr[1]/td[2]");
	
	
	
	
	

}
