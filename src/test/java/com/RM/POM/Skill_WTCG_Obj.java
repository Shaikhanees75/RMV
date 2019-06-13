package com.RM.POM;

import org.openqa.selenium.By;

public class Skill_WTCG_Obj {
	
	//resource planner
	public static By instance_setup = By.xpath(".//*[@id='mainmenu']/li[3]/a");
	
	//Skill master
	public static By skill_master = By.xpath(".//*[@id='mainmenu']/li/ul/li/a[text()='Skill Master']");
	
	//competency
	public static By competency = By.xpath(".//*[@id='mainmenu']/li[3]/ul/li[2]/ul/li[1]/a");
	
	//WTCG
	public static By wtcg= By.xpath(".//*[@id='mainmenu']/li/ul/li/ul/li/a[text()='Work Type Competency Group']");
	
	//add btn
	public static By add_btn= By.xpath(".//*[@id='btnAdd']");
	
	//title
	public static By title= By.xpath(".//*[@id='wtCompGroupTitle']");
	
	//description
	public static By desc= By.xpath(".//*[@id='wtCompGroupDesc']");
	
	//work type
	public static By work_type= By.id("workType");
	
	//active btn
	public static By active_btn = By.xpath(".//*[@id='compActive']");
	
	//delete button
	public static By delete_first = By.xpath(".//*[@id='dynamicControl']/div/div[5]/button");
	
	//competecncy type
	public static By competency_type= By.xpath(".//*[@id='dynamicControl']/div[2]/div[1]/div/select");
	
	//competency
	public static By competency_drp = By.xpath(".//*[@id='dynamicControl']/div[2]/div[2]/div/select");
	
	//min prof
	public static By min_prof = By.xpath(".//*[@id='dynamicControl']/div[2]/div[3]/div/select");
	
	//max prof
	public static By max_prof = By.xpath(".//*[@id='dynamicControl']/div[2]/div[4]/div/select");
	
	//delete btn
	public static By delete = By.xpath(".//*[@id='dynamicControl']/div[2]/div[5]/button");
	
	//reset button
	public static By reset = By.xpath(".//*[@id='resetWTCompGroup']");
	
	//submit
	public static By save_btn = By.xpath(".//*[@id='saveWTCompGroup']");
	
	//cancel button
	public static By cancel_btn = By.xpath(".//*[@id='AddWTCompGroup']");
	
	//edit button
	public static By edit = By.xpath(".//*[@id='Edit0']");
	
	//title search
	public static By title_search = By.xpath(".//*[@id='1']");
	
	//success msg
	public static By success_msg = By.xpath(".//*[@id='alertsection']/div/strong");
	
	//add comp
	public static By add_comp = By.xpath(".//*[@id='addPreReqRow']");
	
	//search result
	public static By search_result = By.xpath("//*[@id='fixTable']/tbody/tr[1]/td[2]");
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
