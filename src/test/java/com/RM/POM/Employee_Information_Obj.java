package com.RM.POM;

import org.openqa.selenium.By;

public class Employee_Information_Obj {


	/*Employee Search*/
	public static By employee_search_btn = By.xpath(".//*[@id='render-body']/div[1]/div[2]/div[2]/div[2]/div/button");

	/*Employee Search*/
	public static By employee_id = By.id("empIdAdvSearch");

	/*Employee Search*/
	public static By employee_search = By.id("btnAdvSrch");

	/*Employee Search*/
	public static By employee_select =By.xpath(".//*[@id='advEmployeeTable']/tbody/tr/td[1]");

	/*Employee Search*/
	public static By search_close =By.xpath(".//*[@id='advanceSearchModal']/div/div/div[3]/button");

	/*Employee Information*/
	public static By Employee_Management = By.xpath(".//*[@id='mainmenu']/li[4]/a");

	/*Add New User*/
	public static By Employee_Information = By.xpath(".//*[@id='mainmenu']/li[4]/ul/li[1]/a");

	/*Employee ID*/
	public static By Employee_ID = By.id("empId");

	/*Prefix*/
	public static By Prefix = By.id("prefix");

	/*Suffix*/
	public static By Suffix = By.id("suffix");

	/*First Name*/
	public static By Fname = By.id("firstName");

	/*Middle Name*/
	public static By Mname = By.id("middleName");

	/*Last Name*/
	public static By Lname = By.id("lastName");

	/*Preferred Name*/
	public static By Preferred_Name = By.id("preferredname");

	/*Badge Number*/
	public static By Badge_Number = By.id("badgenumber");

	/*Work force Manager*/
	public static By Work_force_Manager_search_icon = By.xpath(".//*[@id='empInfo']/div[5]/div[1]/div/div/div/div/button[1]");
	/*Fname for Work force manager*/
	public static By Eid_Work_force_Manager= By.id("empIdMngrSearch");
	/*Search btn for Work force manager*/
	public static By search_btn_Work_force_Manager= By.id("btnAdvSrchMngr");

	/*Search Result of Work force manager*/
	public static By Search_Result_of_Workforce_manager= By.xpath(".//*[@id='advManagerTable']/tbody/tr/td[1]");
	/*Search Result of Work force manager*/
	public static By Close_of_Workforce_manager= By.xpath(".//*[@id='advanceManagerModel']/div/div/div[3]/button");

	/*Work force manager clear*/
	public static By Clear_Workforce_manager= By.xpath(".//*[@id='empInfo']/div[5]/div[1]/div/div/div/div/button[2]");
	/*Functional Manager*/
	public static By Functional_Manager_search_icon = By.xpath(".//*[@id='empInfo']/div[5]/div[2]/div/div/div/div/button[1]");
	/*Fname for Work Functional manager*/
	public static By Eid_Functional_Manager= By.id("empIdFnctSearch");
	/*Search btn for Functional manager*/
	public static By search_btn_Functional_Manager= By.id("btnAdvSrchFnct");
	/*Search Result of Functional manager*/
	public static By Search_Result_of_Functional_manager= By.xpath(".//*[@id='advFunctionalTable']/tbody/tr/td[1]");
	/*Search Result of Work Functional manager*/
	public static By Close_of_Functional_manager= By.xpath(".//*[@id='advanceFunctionalModel']/div/div/div[3]/button");
	/*Functional manager clear*/
	public static By Clear_Functional_manager= By.xpath(".//*[@id='empInfo']/div[5]/div[2]/div/div/div/div/button[2]");

	/*Date of Joining*/
	public static By Date_of_Joining = By.xpath(".//*[@id='empInfo']/div[10]/div[1]/div/div[2]/div/div/span");

	/*Confirmation Status*/
	public static By Confirmation_Status = By.id("confSts");

	/*Confirmation Date*/
	public static By Confirmation_Date = By.xpath(".//*[@id='empInfo']/div[10]/div[2]/div/div[2]/div/div/span");

	/*LOB Search Icon*/
	public static By LOB_search_icon = By.xpath(".//*[@id='empInfo']/div[6]/div[1]/div/div/div/div/button[1]");
	/*LOB search Box*/
	public static By LOB_search_textbox = By.id("input-organisation-search");
	/*LOB search button*/
	public static By LOB_search_btn= By.id("btn-organisation-search");
	/*LOB Search result*/
	public static By LOB_search_result=By.xpath(".//*[@id='organisationtreeview']/ul/li");

	/*Client*/
	public static By Client = By.id("client-input");

	/*SOW*/
	public static By SOW = By.id("sow-input");

	/*Department*/
	public static By Department = By.id("dept");
	/*Designation*/
	public static By Designation = By.id("desgn");

	/*Office Location search icon*/
	public static By Office_Location_search_icon = By.id("#btnSeatSearch");
	/*office location search Text box*/
	public static By Office_Location_search_textbx = By.id("input-location-search");
	/*office location search Button*/
	public static By Office_Location_search_button = By.id("btn-location-search");
	/*office location search Button*/
	public static By Office_Location_search_result = By.xpath(".//*[@id='locationtreeview']/ul/li");



	/*Seat Number search icon*/
	public static By Seat_Number_search_icon = By.id("btnSeatSearch");
	/*Seat_Number search Text box*/
	public static By Seat_Number_search_textbx = By.id("input-seat-search");
	/*Seat_Number search Button*/
	public static By Seat_Number_search_button = By.id("btn-seat-search");
	/*Seat_Number search Button*/
	public static By Seat_Number_search_result = By.xpath(".//*[@id='seat-table-modal']/tbody/tr/td[2]");
	/*Seat Number Clear*/
	public static By Seat_Number_Clear = By.id(".//*[@id='empInfo']/div[9]/div[2]/div/div/div/div/button[2]");

	/*Fixed Schedule Name*/
	public static By Fixed_Schedule_Name = By.id("fxSch");
	/*Level*/
	public static By Level = By.id("level");
	/*Employment Status*/
	public static By Employment_Status = By.id("empStatus");
	/*Operation Category*/
	public static By Operation_Category = By.id("oprCat");
	/*Effective Date*/
	public static By Effective_Date = By.xpath(".//*[@id='empInfo']/div[11]/div[2]/div/div/div/span");
	/*Save*/
	public static By Einfo_Save_btn = By.id("saveEmployee");
	/*View History*/
	public static By viewHistoryEmployee = By.id("viewHistoryEmployee");
	/*View History*/
	public static By viewHistoryClose = By.xpath(".//*[@id='history']/div/div/div/div[3]/button");

	/*Reset*/
	public static By Reset = By.id("resetEmployee");
	//Alert message
	public static By Error_msg = By.id(".//*[@id='alertsectionEM']/div[1]");


	/*Add New User ----- User Detail Tab*/
	public static By User_Details_Tab=By.xpath(".//*[@id='navbody']/ul/li[6]/a");
	/*User ID*/
	public static By User_ID = By.id("userid");
	/*User Name**/
	public static By User_Name = By.id("username");
	/*Is LDAP User*/
	public static By Is_LDAP_User = By.id("LDAP");
	/*Password*/
	public static By Password = By.id("password");
	/*Active*/
	public static By Active = By.id("active");
	/*User Detail Save*/
	public static By User_Details_Save = By.id("userdetailssave");

	/*User Detail Delete*/
	public static By User_Details_Delete = By.id("userdetailsdelete");

	/*User Warning Message*/
	public static By User_Details_reset =By.xpath(".//*[@id='userdetails']/div[7]/button[3]");

	/*User Warning Message*/
	public static By user_warn_msg =By.xpath(".//*[@id='alertsectionEM']/div[1]");



	//----------------------------- Contact Detail Tab-----------------------------//
	
	public static By Contact_Details_Tab=By.xpath(".//*[@id='navbody']/ul/li[2]/a");
	
	/*Email Details*/
	/*Add Button*/
	public static By Email_Add_Button = By.id("copyemail");
	/*Type*/
	public static By Email_Type = By.id("typeEmail");
	/*Email Address*/
	public static By Email_Address = By.id("emailID");
	/*Save Button*/
	public static By Email_save_btn = By.id("ParentEmailadd");
	/*Close Button*/
	public static By Email_Close_btn = By.xpath(".//*[@id='Emailmanager']/div/div/div[3]/div[2]/button[3]");
	/*Warning Message*/
	public static By Email_Msg = By.xpath(".//*[@id='alertsectionAddEmailmanagaer']/div");

	/*Phone Details*/
	/*Add Button*/
	public static By Phone_Add_Button = By.id("copyphone");
	/*Type*/
	public static By Phone_type = By.id("typePhone");
	/*Country Code*/
	public static By Country_code = By.id("cCode");
	/*Contact Number*/
	public static By Contact_number = By.id("cNumber");
	/*Extension*/
	public static By Extension = By.id("extn");
	/*Save*/
	public static By Phone_Details_Save = By.id("ParentPhonemanageradd");
	/*Close*/
	public static By Phone_Details_close = By.xpath(".//*[@id='Phonemanager']/div/div/div[3]/div[2]/button[3]");
	/*Warning Message*/
	public static By Phone_Msg = By.xpath(".//*[@id='alertsectionAddPHONEmanagaer']/div");
	
	//Contact details Save btn
	public static By contact_save=By.id("contactsave");
	
	/*Warning Message*/
	public static By Cntact_Msg = By.xpath(".//*[@id='alertsectionEMSaved']/div");
	
	
	//----------------------------- Contact Information Tab-----------------------------//
	
	public static By Contact_Information_Tab=By.xpath(".//*[@id='navbody']/ul/li[3]/a");

	/*Address Details*/
	/*Add Button*/
	public static By Address_Add_Button = By.id("addaddress");
	/*Type*/
	public static By Address_Type = By.id("typeAddAddress");
	/*Address1*/
	public static By Address_1 = By.id("address1");
	/*Address2*/
	public static By Address_2 = By.id("address2");
	/*Location*/
	public static By Location = By.id("location");
	/*City*/
	public static By City = By.id("city");
	/*State*/
	public static By State = By.id("state");
	/*Country*/
	public static By Country = By.id("country");
	/*Zipcode*/
	public static By Zipcode = By.id("zipcode");
	/*Save*/
	public static By Address_Save_btn = By.id("contactadd");
	/*Close*/
	public static By Address_Close_btn = By.xpath(".//*[@id='addressmanager']/div/div/div[3]/div/button[2]");
	/*Warning Message*/
	public static By Address_Msg = By.xpath(".//*[@id='alertsectionAddAddress']/div");


	/*Personal Details*/
	/*Date of Birth*/
	public static By Date_of_Birth = By.id("dobpersonal");
	/*Marital Status*/
	public static By Marital_Status = By.id("maritalStatus");
	/*Anniversary Date*/
	public static By Anniversary_Date = By.id("annDate");

	
	
	//Contact Info Save button
	public static By contactinfo_save=By.id("contactinfosave");
	
	//Conatct info error message
	public static By contactinfo_err_msg=By.xpath(".//*[@id='alertsectionContactInfoSaved']/div");

	//--------------------------Other Detail Tab-----------------------------//
	public static By Other_Tab=By.xpath(".//*[@id='navbody']/ul/li[7]/a");
	/*ADP ID*/
	public static By ADP_ID = By.id("adpid");
	/*Enterprise ID*/
	public static By Enterprise_ID = By.id("enterpriseid");
	/*Access Type*/
	public static By Access_Type = By.xpath(".//*[@id='otherdetails']/div[4]/div/div/div/span/div/ul/li[1]/a/label/input");
	/*Other Details Save*/
	public static By Other_details_save=By.id("saveaccesstypes");

	//-------------------------------------------Calendar------------------------//
	//Calendar
	//Center of the month
	public static By cntr_mnth = By.xpath("html/body/div/div[1]/table/thead/tr[2]/th[2]");

	//Next Year
	public static By nxt_yr = By.xpath("html/body/div/div[2]/table/thead/tr[2]/th[3]");

	//Prev Year
	public static By prev_yr = By.xpath("html/body/div/div[2]/table/thead/tr[2]/th[1]");

	//Month table
	public static By month_table = By.xpath("html/body/div/div[2]/table/tbody/tr/td/span");


	//-------------------------------------------Separation Tab--------------------------------------//

	public static By Separation_Tab=By.xpath(".//*[@id='navbody']/ul/li[4]/a");


	public static By Separation_type = By.id("typeAddSeparation");


	public static By Termaination_Cldr = By.id("dobseparation");


	public static By LWD_Cldr = By.id("doblastworkingday");


	public static By Comment_Field = By.id("separationcomments");


	public static By Revoke_CheckBox = By.id("revoke");


	public static By Separation_Save = By.id("separationsave");


	public static By Separation_reset = By.id(".//*[@id='separation']/div[8]/button[2]");

	//--------------------------Delegate Tab-----------------------------------------------------------//


	public static By Delegate_Tab=By.xpath(".//*[@id='navbody']/ul/li[10]/a");


	public static By Delegate_to_search = By.xpath(".//*[@id='delegate']/div[3]/div[2]/div/div/div/div/button[1]");


	public static By Delegate_To_employeeid = By.id("fullname-number-input-modal");


	public static By Delegate_search_btn = By.id("search-full-name");


	public static By Delegate_to_select = By.xpath(".//*[@id='fullname-searched-table-modal']/tbody/tr/td[1]");
	

	public static By From_date_field = By.id("dobdelegatefrom");


	public static By To_date_field = By.id("dobdelegateto");
	

	public static By From_date= By.xpath(".//*[@id='delegate']/div[4]/div[1]/div/div/div/span");


	public static By To_date = By.xpath(".//*[@id='delegate']/div[4]/div[2]/div/div/div/span");


	public static By active_sts = By.id("delegateactive");
	

	public static By Delegate_save = By.id("delegatesave");
	

	public static By Delegate_reset = By.xpath(".//*[@id='delegate']/div[7]/button[2]");


}
