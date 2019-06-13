package com.RM.POM;

import org.openqa.selenium.By;

public class Time_card_obj {
	
	//Resource Planner
	public static By resource_planner = By.xpath(".//*[@id='mainmenu']/li[5]/a");
		
	//Time Card
	public static By time_card = By.xpath(".//*[@id='mainmenu']/li[5]/ul/li[2]/a");
	
	//my time card
	public static By my_time_card = By.xpath(".//*[@id='mainmenu']/li[5]/ul/li[3]/a");
	
	//Add Date
	public static By date = By.xpath(".//*[@id='render-body']/div[2]/div[2]/div/div[1]/div[2]/div/span/img");
	
	//Go Button
	public static By go_btn = By.xpath(".//*[@id='datefilter']");
	
	//Add Time Card
	public static By add_entry = By.xpath(".//*[@id='Addentry']");
	
	//Time card SubActivity
	public static By Sub_activity = By.xpath(".//*[@id='Sbacty']");
	
	//Start time
	public static By srt_time = By.xpath(".//*[@id='timepicker1']");
	
	//End time
	public static By end_time = By.xpath(".//*[@id='timepicker2']");
	
	//Submit Button
	public static By submit_btn = By.xpath(".//*[@id='submitentry']");
	
	//pop up msg
	public static By ok_btn =  By.xpath("//button[@class='btn btn-primary']");
	
	//Edit button
	public static By edit_btn = By.xpath("//*[@id='profileaccessRS']/table/tbody/tr/td[1]/a[1]/span");
	//*[@id="profileaccessRS"]/table/tbody/tr[1]/td[1]/a[1]
	//*[@id="profileaccessRS"]/table/tbody/tr[2]/td[1]/a[1]/span
	//Delete Button
	
	public static By delete_btn = By.xpath("//*[@id='profileaccessRS']/table/tbody/tr[1]/td[1]/a[2]");
	                                        //*[@id="profileaccessRS"]/table/tbody/tr[2]/td[1]/a[2]
	
	//Confirm delete button
	public static By cnf_del_btn = By.xpath("/html/body/div[2]/div/div/div[2]/button[2]");
	                           	                            
	//Reset
	public static By reset_btn = By.xpath(".//*[@id='Reset']");
	
	//Save
	public static By save = By.xpath("//*[@id='MainSave']");
	
	//Calendar center month
	
	public static By cntr_mnth = By.xpath("html/body/div[2]/div[1]/table/thead/tr[2]/th[2]");
	
	public static By  nxt_yr= By.xpath("html/body/div[2]/div[2]/table/thead/tr[2]/th[3]");
	
	public static By  prev_yr= By.xpath("html/body/div[2]/div[2]/table/thead/tr[2]/th[1]");
	
	public static By  month_table= By.xpath("html/body/div[2]/div[2]/table/tbody/tr/td/span");
			
}
