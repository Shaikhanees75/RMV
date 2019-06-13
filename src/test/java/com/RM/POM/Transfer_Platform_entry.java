package com.RM.POM;

import org.openqa.selenium.By;

public class Transfer_Platform_entry 
{
	//Employee Name
	public static By Employee_Name = By.xpath(".//*[@id='formAddSow']/div[2]/div[1]/div/div/div/div/button");

	//Employee Name SAP ID Text Box
	public static By Employee_Name_sap_id = By.id("fullname-number-input-modal");

	//Employee Name Search Button
	public static By Employee_Name_srch_btn = By.id("search-full-name");

	//Employee Name Search Result
	public static By Employee_Name_srch_result = By.xpath(".//*[@id='fullname-searched-table-modal']/tbody/tr/td[1]");

	//Employee Name Cancel Button
	public static By Employee_Name_cancel_btn = By.xpath(".//*[@id='fullName']/div/div/div[3]/button");

	//Operation category drop down
	public static By operation_category = By.id("operation-category-input");

	//Designation 
	public static By designation = By.id("designation-input");

	//Department 
	public static By department = By.id("department-input");

	//Employment status drop down
	public static By employment_status = By.id("employement-input");	
	
	/*Reporting to */

	//Reporting to Search btn
	public static By reporting_to = By.xpath(".//*[@id='newEmployeeForm']/div[5]/div[1]/div/div/div/div/div/button[1]");

	//Reporting to SAP ID search text Box
	public static By reporting_to_sap_srch_tb = By.id("reporting-number-input-modal");

	//Reporting to  search button
	public static By reporting_to_srch_btn = By.id("search-reporting-manager");

	//Reporting to  search Result
	public static By reporting_to_srch_result = By.xpath(".//*[@id='reporting-searched-table-modal']/tbody/tr/td[1]");

	//Reporting to  Cancel button
	public static By reporting_to_Cancel_btn = By.xpath(".//*[@id='reportingManager']/div/div/div[3]/button");
	

	//Functional Reporting
	public static By Functional_Reporting = By.xpath(".//*[@id='newEmployeeForm']/div[6]/div[1]/div/div/div/div/div/button[1]");

	//Functional Reporting SAP ID Text Box
	public static By Functional_Reporting_sap_id = By.id("functional-number-input-modal");

	//Functional Reporting Search Button
	public static By Functional_Reporting_srch_btn = By.id("search-functional-manager");

	//Functional Reporting Search Result
	public static By Functional_Reporting_srch_result = By.xpath(".//*[@id='functional-searched-table-modal']/tbody/tr/td[1]");

	//Functional Reporting Cancel Button
	public static By Functional_Reporting_cancel_btn = By.xpath(".//*[@id='functionalManager']/div/div/div[3]/button");
	
	//LOB Search btn
		public static By LOB_srch = By.xpath(".//*[@id='newEmployeeForm']/div[5]/div[1]/div/div/div/div/div/button[1]");

		//LOB search text Box
		public static By LOB_srch_tb = By.id("input-organisation-search");
		
		//LOB search text Box
			public static By LOB_srch_btn = By.id("btn-organisation-search");

		//LOB Search Result
		public static By LOB_srch_result = By.xpath(".//*[@id='organisationtreeview']/ul/li");

		//LOB Close
		public static By LOB_Close = By.xpath(".//*[@id='organisation']/div/div/div[3]/button");
	
		//Client Drop Down
		public static By client_drp_dwn = By.id("client-input");

		//Sow Drop Down
		public static By sow_drp_dwn = By.id("sow-input");

		//Office Location
		public static By Ofc_location = By.xpath(".//*[@id='newEmployeeForm']/div[5]/div[2]/div/div/div/div/div/button[1]");

		//office location search textbox
		public static By Ofc_location_srch_tb = By.id("input-location-search");

		//office Location search button
		public static By Ofc_location_srch_btn = By.id("btn-location-search");

		//office location selection 
		public static By Ofc_location_selection = By.xpath(".//*[@id='locationtreeview']/ul/li");

		//office location Close button
		public static By Ofc_location_close_btn = By.xpath(".//*[@id='officeLocation']/div/div/div[3]/button");
	
		//Seat Number
		public static By Seat_Number = By.xpath("btnSeatSearch");

		//Seat Number search textbox
		public static By Seat_Number_srch_tb = By.id("input-seat-search");

		//Seat Number search button
		public static By Seat_Number_srch_btn = By.id("btn-seat-search");

		//Seat Number selection
		public static By Seat_Number_selection = By.xpath(".//*[@id='seat-table-modal']/tbody/tr[1]/td[2]");

		//Seat Number Close button
		public static By Seat_Number_Close_btn = By.xpath(".//*[@id='seatmanager']/div/div/div[3]/div[2]/button");
		
		//Level drop down
		public static By Level = By.id("level-input");
		
		//Fixed Schedule Drop Down
		public static By Fixed_Schedule_Drop_Down= By.id("fixed-schedule-name-input");
		
		//Save Button
		public static By Save_Button = By.id("submit-input-button");

		//Reset Button
		public static By Reset_button = By.id("reset-input-button");

		//Back Button
		public static By Back_button = By.id("back-input-button");

		//Next Button
		public static By Next_button = By.xpath("home-input-button");


		//Error Msg
			public static By Error_msg=By.xpath(".//*[@id='alertsection']/div");


			//Next button
			public static By next_to_task=By.id("home-input-button");

			//Edit Button
			public static By edit_btn=By.id("Edit0");

			//Create Task Button
			public static By create_task_btn=By.id("btnCreateTask");
		
		
		
		
		
		
		
		
	
}
