package com.hotelogix.smoke.frontdesk.FrontdeskHome;




import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.List;
import java.util.Set;


import org.openqa.selenium.By;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.RandomTest.RanTest;
import com.hotelogix.smoke.admin.roommanager.AddRoomsPage;
import com.hotelogix.smoke.frontdesk.Accounts.AccountsLandingPage;
import com.hotelogix.smoke.frontdesk.Payment.AccountStatementLandingPage;
import com.hotelogix.smoke.frontdesk.Report.LiveSupportLandingWindow;
import com.hotelogix.smoke.frontdesk.Report.ReportLandingPage;
import com.hotelogix.smoke.frontdesk.ReservationSearchResult.ReservationSearchResultLandingPage;
import com.hotelogix.smoke.frontdesk.SampleRestaurantPage.SampleRestaurantPage;
import com.hotelogix.smoke.frontdesk.ViewDetailsPage.EnableEditingPage;
import com.hotelogix.smoke.frontdesk.ViewDetailsPage.GroupViewDetailPage;
import com.hotelogix.smoke.frontdesk.ViewDetailsPage.ViewDetailsPage;
import com.hotelogix.smoke.frontdesk.WebReservation.WebReservationHomePage;
import com.hotelogix.smoke.genericandbase.BasePage;
import com.hotelogix.smoke.genericandbase.Constant;
import com.hotelogix.smoke.genericandbase.ExcelUtil;
import com.hotelogix.smoke.genericandbase.GenericMethods;
import com.hotelogix.smoke.login.AdminLoginPage;




public class FrontdeskLandingPage {
	
	
public float TotalCharge;
public String title;
public String resTitle;
public String headerDNR;


@FindBy(xpath="//input[@value='Cancel']")
public static WebElement Cancel_BT;

@FindBy(xpath="//div[@title='209']")
public static WebElement RoomsNumber_BT;

@FindBy(xpath="//input[@id='txtResFrndLookup']")
public static WebElement Search_ED;

@FindBy(xpath="//span[text()='Fg Fgfg']")
public static WebElement AutoSuggestion;

@FindBy(xpath="//input[@id='txtResFrndLookupAllChk']")
public static WebElement Search_CB;

@FindBy(xpath="//button[@id='txtResFrndLookupAllBtn-button']")
public static WebElement SearchAll_BT;

@FindBy(xpath="//a[text()='Current']")
public static WebElement Current_Link;

@FindBy(xpath="//a[@class='yuimenubaritemlabel']")
public static WebElement SampleRestaurant;

@FindBy(xpath="//button[text()='Ok']")
public static WebElement CancelDNR;

@FindBy(xpath="//h4")
public static WebElement checkinCard_title;

/*@FindBy(xpath="//div[@resrvid='2314060' and contains(@title,'69. TFbHC NLGPH')]")
public static WebElement resrvId;*/


@FindBy(xpath="//div[@id='contextmenu']//ul//li[9]/a")
public static WebElement rightClk_viewDetails;

@FindBy(xpath="//div[@title='131']")
public static WebElement RoomForDNR;

@FindBy(xpath="//div[@class='bd']//li[6]/a")
public static WebElement DNROption;










//@FindBy(xpath="//div[@resrvid='2316560' and contains(@assignedroomid,'346997')]")
//public static WebElement resrvId;

@FindBy(xpath="//div[@resrvid='4222185']")
public static WebElement resrvId;

@FindBy(xpath="//div[@id='contextmenu']//ul//li[2]/a")
public static WebElement rightClk_checkIn;

@FindBy(xpath="//div[@id='contextmenu']//ul//li[1]/a")
public static WebElement rightClk_cnclcheckin;

@FindBy(xpath="//input[@value='Close']")
public static WebElement checkinCard_closeBtn;

@FindBy(xpath="//div[@resrvid='4213444' and contains(@title,'64. Din Dayaal')]")
public static WebElement ReservID_dpk;

@FindBy(xpath="//div[@resrvid='4230208' and contains(@title,'76. sougata mondal(G) ')]")
public static WebElement GrpReservID_NoShow;

@FindBy(xpath="//div[@resrvid='4239732' and contains(@title,'27. Yamini K(G) ')]")
public static WebElement grpResrvID;

@FindBy(xpath="//div[@resrvid='4313457' and contains(@title,'25.  Nikita K(G)')]")
public static WebElement checkoutDueResrv;

@FindBy(xpath="//div[@resrvid='4052388' and contains(@title,'11. Richard Gere')]")
public static WebElement resrvId2;

@FindBy(xpath="//div[@id='contextmenu']//ul//li[7]/a")
public static WebElement rightClk_Payment;

@FindBy(xpath="//div[@resrvid='4052390' and contains(@title,'13. April Monique(G)')]")
public static WebElement grpResrvID1;

@FindBy(xpath="//div[@resrvid='4250746' and contains(@title,'30. Guest 1 Abc(G)')]")
public static WebElement grpResrvID2;

@FindBy(xpath="//div[@resrvid='4263947' and contains(@title,'22. Richard S(G)')]")
public static WebElement grpResrvID3;

@FindBy(xpath="//div[@id='contextmenu']//ul//li[10]/a")
public static WebElement grpcheckin;

@FindBy(xpath="//a[text()='Web Reservation']")
public static WebElement WebReservation_Link;

@FindBy(xpath="//a[@class='link-top-unit' and text()='Admin Console']")
public static WebElement Admin_lnk;

@FindBy(xpath="//div[@id='pnl-nav-links']//img")
public static WebElement LiveSupport_BT;

@FindBy(xpath="//div[@resrvid='2315068' and @title='60. Harry Yadav(G) ']")
public static WebElement UncheckinReserveID_G;

@FindBy(xpath="//div[@resrvid='4044070' and @title='14. Janet Fonda(G) ']")
public static WebElement UNcheckinReserveID_G;

@FindBy(xpath="//div[@resrvid='4044065' and @title='10. Ken Sue']")
public static WebElement ReserveID_TTR;

@FindBy(xpath="//div[@resrvid='2314613' and @title='59. Baba Khan(G)']")
public static WebElement ReserveID_G;

@FindBy(xpath="//a[text()='Check In']")
public  WebElement rightClk_CheckIN;

@FindBy(xpath="//button[text()='Continue to Checkin']")
public static WebElement ContinueToCheckIn_BT;

@FindBy(xpath="//div[@resrvid='2316107' and @title='66. Ramesh Khanaaa(G) ']")
public static WebElement RameshKhanna_ReserveID;

@FindBy(xpath="//a[text()='Report']")
public static WebElement Report_BT;

@FindBy(xpath="//input[@value='Perform Auto Night Audit']")
public static WebElement AutoNightAuditBtn;

@FindBy(xpath="//a[text()='Frontdesk']")
public static WebElement Frontdesk_BT;

@FindBy(xpath="//a[text()='Perform Night Audit']")
public static WebElement PerformNightAudit_Link;

@FindBy(xpath="//img[@id='hkDNRImgCal1']")
public static WebElement FromCal_DNRPopUp;

@FindBy(xpath="//img[@id='hkDNRImgCal2']")
public static WebElement ToCal_DNRPopUp;

@FindBy(xpath="//table[@id='sr-calContainerPopup_t']//tbody//a")
public static WebElement DateInCal_DNRPopUp;

@FindBy(xpath="//button[text()='Ok']")
public static WebElement OKbutton_DNRPopUp;

@FindBy(xpath="//div[@rsvstatus='DNR']")
public static WebElement DNR_Reservation;

@FindBy(xpath="//td[@id='dnrListTdId']//img[2]")
public static WebElement DeleteIcon_DNRPopUp;

@FindBy(xpath="//textarea[@id='txtDnrComment']")
public static WebElement TextBox_DNRPopUp;






@FindBy(xpath="//div[@id='hhead348284']//input")
public static WebElement Rooms_CB;

@FindBy(xpath="//div[@id='PanelQuickRes']//td")
public static WebElement addQuickResrv;

@FindBy(xpath="//div[@id='quickLinkDiv']")
public static WebElement tooltip;

@FindBy(xpath="//select[@id='noofRooms1']")
public static WebElement roomDD;

@FindBy(xpath="//a[@id='lnkQResFormSingleEnab']")
public static WebElement singleLnk;

@FindBy(xpath="//a[contains(@onclick,'Tab_GroupRes(2)')]")
public static WebElement groupLnk;

@FindBy(xpath="//a[contains(@onclick,'Tab_GroupRes(0)')]")
public static WebElement ag_corp_Lnk;

@FindBy(xpath="//select[@id='qrSelRateType']")
public static WebElement rateType;

@FindBy(xpath="//select[@id='qrSelAdult']")
public static WebElement adultDD;

@FindBy(xpath="//span[@id='btnSrShowEditDetails']")
public static WebElement viewBtn;

@FindBy(xpath="//div[@id='PanelAutoNA_h']/span")
public static WebElement nightaudit;

@FindBy(xpath="//div[@resrvid='4239763' and @title='44. Ankit singh(G)']")
public static WebElement GroupReservation_ID;

@FindBy(xpath="//div[@resrvid='4299262']")
public static WebElement GroupReservation_HarveshID;

@FindBy(xpath="//a[text()='Cancel Check In']")
public  WebElement rightClk_CancelCheckIN;

@FindBy(xpath="//div[@resrvid='4304175']")
public static WebElement GroupReservation_ForCheckIN;

@FindBy(xpath="//div[@resrvid='4306773']")
public static WebElement GroupReservation_ForTaxExempt;

@FindBy(xpath="//div[@resrvid='4064928' and @title='10. Anastasia Hue']")
public static WebElement reservID_Payment;

@FindBy(xpath="//div[@resrvid='4221090']")
public static WebElement GroupReservation_ForAddNewR;

@FindBy(xpath="//div[@resrvid='4221090']")
public static WebElement GrpReserID_Discount;

@FindBy(xpath="//div[@resrvid='4240498']")
public static WebElement GrpReservID_ManageSharer;

@FindBy(xpath="//a[text()='Accounts']")
public static WebElement Accounts_Link;

@FindBy(xpath="//a[text()='Admin Console']")
public WebElement Link_AdmineConsole;

@FindBy(xpath="//button[@id='btnSrShowEditDetails-button']")
public WebElement Btn_View;




@FindBy(xpath="//button[text()='View']")
public WebElement Link_ViewOnResDetailForm;


@FindBy(xpath=".//*[@id='panelSingleResShow']/div[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/table/tbody/tr[1]/td[2]")
public WebElement Text_RateOverViewPane;

public static String exp_msg="The room selected for Check-in is not clean. \n"+" "+
        "Do you still wish to check in ?";


@FindBy(xpath="//table/tbody/tr[3]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/table/tbody/tr[1]/td[2]")
public WebElement Text_RateViewPopup;


@FindBy(xpath="//input[@value='Perform Auto Night Audit']")
public WebElement Btn_AutoNightAudit;


public static String resvId;


@FindBy(xpath="//a[text()='Frontdesk']")
public WebElement Link_Frontdesk;

@FindBy(xpath="//ul/li[1]/div/div[1]/ul/li[4]/a")
public WebElement Link_NightAudit;

@FindBy(xpath="//a[text()='Payments']")
public WebElement Link_Payments;

@FindBy(xpath="//a[text()='Check In']")
public WebElement Link_CheckIn;

@FindBy(xpath="//a[text()='View Details']")
public WebElement Link_ViewDetails;

@FindBy(xpath="//a[text()='Group Check In']")
public WebElement Link_GroupCheckIn;

@FindBy(xpath="//div[@id='PanelAutoNA_h']/span[1]")
public WebElement Header_NightAuditPopUp;

@FindBy(xpath="//a[text()='Accounts']")
public WebElement Link_AccountsFD;

@FindBy(xpath="//a[text()='Group Check In']")
public WebElement Link_groupCheckIn;

@FindBy(xpath="//a[text()='Cancel Check In']")
public WebElement Link_CancelCheckIn;

@FindBy(xpath="//a[text()='DNR']")
public WebElement Link_DNR;

@FindBy(xpath="//div[@id='PanelTasksHKNew_h']")
public static WebElement Header_DNRPopUp;

@FindBy(xpath="//textarea[@id='txtDnrComment']")
public WebElement TxtBX_CommentsForDNR;

@FindBy(xpath="//button[@id='btnDNRSave-button']")
public WebElement Btn_SubmitDNR;











public void fn_ApplyDNRToRoom(WebElement ele,String cDNR) throws Exception{
try{
fn_rightClickOnReservation(ele);
Thread.sleep(2000);
GenericMethods.js_Click(Link_DNR);
Thread.sleep(2000);
headerDNR=GenericMethods.getText(Header_DNRPopUp).trim();
Thread.sleep(2000);
GenericMethods.js_Sendkey(TxtBX_CommentsForDNR, cDNR);
Thread.sleep(2000);
GenericMethods.js_Click(Btn_SubmitDNR);
}
catch(Exception e){
throw e;
}
}

public String fn_verifyRoomDNR(String title) throws Exception{
	WebElement ele1=null;
	String resStatus=null;
try{
	ele1=GenericMethods.driver.findElement(By.xpath("//div[@title='"+title+"']"));
    Thread.sleep(2000);
    resStatus=ele1.getAttribute("rsvstatus").toString().trim();
	
}
catch(Exception e){
throw e;
}
return resStatus;
	
}



public WebElement fn_selectRoomForDNR(String roomName) throws Exception{
	WebElement ele=null;
try{
    ele=GenericMethods.driver.findElement(By.xpath("//div[@title='"+AddRoomsPage.roomNumber+"']"));
	Thread.sleep(2000);
	String id=ele.getAttribute("id");
	Thread.sleep(2000);
	GenericMethods.driver.findElement(By.xpath("//div[@id='"+id+"']/div/input")).click();
	Thread.sleep(2000);
}
catch(Exception e){
	throw e;
}
return ele;
}

public WebElement fn_getWebElementUsingXpath(String xpathStringFormat) throws Exception{
WebElement ele=null;
try{
ele=GenericMethods.driver.findElement(By.xpath(xpathStringFormat));	
Thread.sleep(2000);
}
catch(Exception e){
	throw e;
}

return ele;
	
}


public CheckinCard fn_groupCheckIn() throws Exception{
try{

	
	GenericMethods.clickElement(Link_groupCheckIn);
	GenericMethods.ActionOnAlert("Accept");
}
catch(Exception e){
	throw e;
}
CheckinCard CC=PageFactory.initElements(GenericMethods.driver, CheckinCard.class);
return CC;

}

public GroupViewDetailPage fn_clickOnViewDetailLink() throws Exception{
try{
GenericMethods.clickElement(Link_ViewDetails);	
}
catch(Exception e){
	throw e;
}
GroupViewDetailPage GVD=PageFactory.initElements(GenericMethods.driver, GroupViewDetailPage.class);
return GVD;
}

public AccountsLandingPage fn_clickOnAccountsLink() throws Exception{
try{
GenericMethods.clickElement(Link_AccountsFD);
}
catch(Exception e){
throw e;
}
AccountsLandingPage ALP=PageFactory.initElements(GenericMethods.driver, AccountsLandingPage.class);
return ALP;

}


public ViewDetailsPage ClickOnViewDetailsLink() throws Exception{
try{
GenericMethods.clickElement(Link_ViewDetails);
}
catch(Exception e){
throw e;
}
ViewDetailsPage VDP=PageFactory.initElements(GenericMethods.driver, ViewDetailsPage.class);	
	
	return VDP;
	
}



public AccountStatementLandingPage ClickOnPayment() throws Exception{
try{
GenericMethods.clickElement(Link_Payments);	
}
catch(Exception e){
	throw e;
}
AccountStatementLandingPage ASL=PageFactory.initElements(GenericMethods.driver, AccountStatementLandingPage.class);
return ASL;

}





public String getRateFromViewPane() throws Exception{
	
		String a=null;
		try{
		String pri=GenericMethods.getText(Text_RateViewPopup);
		
		if(pri.contains(",")==true){
			String pric []=pri.split(",");
			 a=pric[0].toString().substring(3, pric[0].length()) + pric[1].toString().substring(0, pric[1].length()-1).trim();
			 TotalCharge=Float.parseFloat(a);
			System.out.println("Res Per night Price is"+ a);
			
			
		}
		else{
			
			a=pri.substring(3,pri.length()).trim();
			TotalCharge=Float.parseFloat(a);
			
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		

		return a;
	}
	
	











public ViewDetailsPage ClickOnViewlink() throws Exception{
	
	try{
		GenericMethods.clickElement(Btn_View);
	}
	catch(NoSuchElementException e){
		e.printStackTrace();
	}
	
	
	ViewDetailsPage VDP=PageFactory.initElements(GenericMethods.driver, ViewDetailsPage.class);
	return VDP;
	
}








public BasePage fn_NavigateAdmineConsole() throws Exception
{
	
GenericMethods.clickElement(Link_AdmineConsole);
/*	Actions act = new Actions(GenericMethods.driver);
	act.moveToElement(FrontdeskLandingPage.Admin_lnk).contextClick().sendKeys("T").perform();
	act.sendKeys(Keys.chord(Keys.CONTROL,Keys.TAB)).perform();
	//GenericMethods.driver.switchTo().defaultContent();
*/	BasePage BP=PageFactory.initElements(GenericMethods.driver, BasePage.class);
    return BP;

}





public void fn_clickCurrentLnk() throws Exception
{
	try
	{
	GenericMethods.clickElement(Current_Link);
	Thread.sleep(4000);
	}
	catch(NoSuchElementException e)
	{
		Thread.sleep(2000);
		GenericMethods.js_Click(Current_Link);
	}
	catch(Exception e)
	{
		throw e;
	}
}


public String verifyTitle() throws Exception
{

	
    	return GenericMethods.driver.getTitle();
	//Assert.assertEquals(GenericMethods.driver.getTitle(), "Frontdesk");

}




public void VerifyDNRPopUp() throws Exception
{
	try
	{
	Actions a=new Actions(GenericMethods.driver).contextClick(RoomForDNR);
	a.build().perform();
	a.click(DNROption).build().perform();
	//String t=GenericMethods.getText(DNRPopUpTitle);
	//Assert.assertEquals(t.contains("DNR Room#"), true);
	}
	catch(Exception e)
	{
		throw e;
	}
	catch(AssertionError e)
	{
		throw e;
	}
}


public void fn_ClickOnCancelButton() throws Exception
{
GenericMethods.clickElement(Cancel_BT);
GenericMethods.ActionOnAlert("Accept");
//GenericMethods.driver.findElement(By.xpath("//td[@id='cal1Container_t_cell16']/a")).click();
Assert.assertEquals(GenericMethods.driver.getTitle(), "Frontdesk");
}

public ReservationSearchResultLandingPage fn_SearchByReservationID(String rid) throws Exception
{
	try
	{
	Actions acobj= new Actions(GenericMethods.driver);
	Thread.sleep(2000);
	acobj.sendKeys(Search_ED, rid).build().perform();
	//GenericClass.sendKeys(Search_ED, ReservationID);
	GenericMethods.clickElement(Search_CB);
	GenericMethods.clickElement(SearchAll_BT);
	ReservationSearchResultLandingPage RSLP=PageFactory.initElements(GenericMethods.driver, ReservationSearchResultLandingPage.class);
	return RSLP;
	}
	catch(Exception e)
	{
		throw e;
	}
}

public void VerifyDNR() throws Exception
{
	try
	{
	Actions a=new Actions(GenericMethods.driver).contextClick(RoomForDNR);
	a.build().perform();
	String s=GenericMethods.getText(DNROption);
	a.click(DNROption).build().perform();
	//String t=GenericMethods.getText(DNRPopUpTitle);
	//Assert.assertEquals(t.contains("DNR Room#"), true);
	//GenericMethods.sendKeys( CommentsForDNR, "Do Not Reserve");
//	GenericMethods.clickElement(SubmitDNR);
    String s1=	GenericMethods.driver.findElement(By.xpath("//div[text()='DNR ']")).getText().trim();
    Assert.assertEquals(s1, s);
    Thread.sleep(3000);
    GenericMethods.driver.findElement(By.xpath("//div[text()='DNR ']")).click();
    GenericMethods.driver.findElement(By.xpath("//div[@class='edit_icon']/img[2]")).click();
    //GenericMethods.ActionOnAlert("Accept");
    //GenericMethods.js_Click(GenericMethods.driver.findElement(By.xpath("//div[@id='MsgBox']//button[@id='yui-gen17-button']")));
    a.click(CancelDNR).build().perform();
	}
	catch(Exception e)
	{
		throw e;
	}
	catch(AssertionError e)
	{
		throw e;
	}

}

public ViewDetailsPage fn_rightclkViewDetailsSingle(WebElement resrvId ) throws Exception
{

    Actions action = new Actions(GenericMethods.driver);
    action.contextClick(resrvId).build().perform();
    GenericMethods.clickElement(rightClk_viewDetails);
    ViewDetailsPage VDP=PageFactory.initElements(GenericMethods.driver, ViewDetailsPage.class);
    return VDP;
}


public SampleRestaurantPage ClickToSampleRestaurant() throws Exception
{
WebElement ele=GenericMethods.driver.findElement(By.xpath("//ul[@class='first-of-type']//li[3]/a"));
String str=GenericMethods.getText(ele);
if(str.equals("Sample Restaurant")||str.equals("Hlx_Restaurant"))
{
	GenericMethods.clickElement(ele);
}
SampleRestaurantPage SRL=PageFactory.initElements(GenericMethods.driver,SampleRestaurantPage.class );
return SRL;

}


public String fn_ClickCancelButton() throws Exception
{

	try
	{
GenericMethods.clickElement(Cancel_BT);
GenericMethods.Alert_Accept();
GenericMethods.clickElement(Current_Link);
//Assert.assertEquals(GenericMethods.driver.getTitle(), "Frontdesk");
	}
	catch(Exception e)
	{
		throw e;
	}
	catch(AssertionError e)
	{
		throw e;
	}
	return GenericMethods.driver.getTitle();
}


public void fn_ClickCancelButtonAlert() throws Exception
{

GenericMethods.clickElement(Cancel_BT);
GenericMethods.Alert_Accept();
Assert.assertEquals(GenericMethods.driver.getTitle(), "Frontdesk");

}


public void fn_verifyNightAuditAlert() throws InterruptedException
{
   String str=GenericMethods.getText(nightaudit);
   Assert.assertEquals(str, "Perform Night Audit");
}


public ReservationSearchResultLandingPage  fn_SearchReservationID(String rid) throws Exception
{
	
try
{
Thread.sleep(2000);
GenericMethods.js_Sendkey(Search_ED, rid);
GenericMethods.clickElement(Search_CB);
GenericMethods.clickElement(SearchAll_BT);
}
catch(Exception e){
throw e;
}
ReservationSearchResultLandingPage RSLP=PageFactory.initElements(GenericMethods.driver, ReservationSearchResultLandingPage.class);
return RSLP;
}

public CheckinCard fn_clkCheckin(WebElement ele) throws Exception
{
	try
	{
	

	GenericMethods.clickElement(Link_CheckIn);
	Thread.sleep(2000);
	GenericMethods.ActionOnAlert("Accept");
	Thread.sleep(2000);
	

	CheckinCard CC=PageFactory.initElements(GenericMethods.driver, CheckinCard.class);
	return CC;
	}
	catch(Exception e)
	{
		throw e;
	}
}


public void fn_cancelCheckin() throws Exception
{
	Actions action = new Actions(GenericMethods.driver);
	action.contextClick(resrvId).build().perform();
	Thread.sleep(1000);
	//String a=GenericMethods.GetCurrentWindowID();
	GenericMethods.clickElement(rightClk_cnclcheckin);
	GenericMethods.ActionOnAlert("Accept");
	Thread.sleep(4000);
}



public void fn_closeCheckinCard() throws Exception
{
	//String a=GenericMethods.GetCurrentWindowID();
	Actions action = new Actions(GenericMethods.driver);
	action.contextClick(resrvId).build().perform();
	GenericMethods.clickElement(rightClk_checkIn);
	GenericMethods.ActionOnAlert("Accept");
	Thread.sleep(4000);
	//GenericMethods.windowHandle(a);
	Thread.sleep(2000);
	//GenericMethods.js_Click(checkinCard_closeBtn);
	//GenericMethods.Switch_Parent_Window(a);
}

public void fn_verifyCnclCheckinPopup() throws Exception
{
	try
	{
	Actions action = new Actions(GenericMethods.driver);
	action.contextClick(resrvId).build().perform();
	GenericMethods.clickElement(rightClk_cnclcheckin);
	String str=GenericMethods.ActionOnAlert("Dismiss");
	Thread.sleep(4000);
	Assert.assertEquals(str, "Do you wish to Unassign the reservation?");
	}
	catch(AssertionError e)
	{
		throw e;
	}
	catch(Exception e)
	{
		throw e;
	}
}


public void fn_acceptCnclCheckinPopup() throws Exception
{
	try
	{
	Actions action = new Actions(GenericMethods.driver);
	action.contextClick(resrvId).build().perform();
	GenericMethods.clickElement(rightClk_cnclcheckin);
	GenericMethods.ActionOnAlert("Accept");
	Thread.sleep(4000);
	action.contextClick(resrvId).build().perform();
	String str=GenericMethods.getText(rightClk_checkIn);
	Assert.assertEquals(str, "Check In");
	}
	catch(AssertionError e)
	{
		throw e;
	}
	catch(Exception e)
	{
		throw e;
	}
	
}


public void fn_verifyCheckinPopup() throws Exception
{
	try
	{
	Actions action = new Actions(GenericMethods.driver);
	action.contextClick(resrvId).build().perform();
	GenericMethods.clickElement(rightClk_checkIn);
	String str1=GenericMethods.ActionOnAlert("Dismiss");

	Assert.assertTrue(str1.contains(exp_msg));
	}
	catch(AssertionError e)
	{
		throw e;
	}
	catch(Exception e)
	{
		throw e;
	}
}

public ViewDetailsPage fn_rightclkViewDetailsGrp() throws Exception
{
	Actions action = new Actions(GenericMethods.driver);
	action.contextClick(grpResrvID).build().perform();
	GenericMethods.clickElement(rightClk_viewDetails);
	ViewDetailsPage VDP=PageFactory.initElements(GenericMethods.driver, ViewDetailsPage.class);
    return VDP;
}

public ViewDetailsPage fn_GrpAddOn() throws Exception
{
	Actions action = new Actions(GenericMethods.driver);
	action.contextClick(GroupReservation_ID).build().perform();
	GenericMethods.clickElement(rightClk_viewDetails);
	ViewDetailsPage VDP=PageFactory.initElements(GenericMethods.driver, ViewDetailsPage.class);
    return VDP;
}



public ViewDetailsPage fn_GrpAddNewRoom() throws Exception
{
	try
	{
	Actions action = new Actions(GenericMethods.driver);
	action.contextClick(GroupReservation_ForAddNewR).build().perform();
	GenericMethods.clickElement(rightClk_viewDetails);
	Thread.sleep(3000);
	ViewDetailsPage VDP=PageFactory.initElements(GenericMethods.driver, ViewDetailsPage.class);
    return VDP;
	}
	catch(Exception e)
	{
		throw e;
	}
}

public ViewDetailsPage fn_GrpNoShow() throws Exception
{
	try
	{
	Actions action = new Actions(GenericMethods.driver);
	action.contextClick(GrpReservID_NoShow).build().perform();
	GenericMethods.clickElement(rightClk_viewDetails);
	Thread.sleep(3000);
	ViewDetailsPage VDP=PageFactory.initElements(GenericMethods.driver, ViewDetailsPage.class);
    return VDP;
	}
	catch(Exception e)
	{
		throw e;
	}
}


public ViewDetailsPage fn_GrpDiscount() throws Exception
{
	try
	{
	Actions action = new Actions(GenericMethods.driver);
	action.contextClick(GrpReserID_Discount).build().perform();
	GenericMethods.clickElement(rightClk_viewDetails);
	Thread.sleep(3000);
	ViewDetailsPage VDP=PageFactory.initElements(GenericMethods.driver, ViewDetailsPage.class);
    return VDP;
	}
	catch(Exception e)
	{
		throw e;
	}
}



public ViewDetailsPage fn_GrpManageSharer() throws Exception
{
	try
	{
	Actions action = new Actions(GenericMethods.driver);
	action.contextClick(GrpReservID_ManageSharer).build().perform();
	GenericMethods.clickElement(rightClk_viewDetails);
	Thread.sleep(3000);
	ViewDetailsPage VDP=PageFactory.initElements(GenericMethods.driver, ViewDetailsPage.class);
    return VDP;
	}
	catch(Exception e)
	{
		throw e;
	}
}


public AccountStatementLandingPage fn_NavigateAccountStmt() throws Exception
{
	try
	{
	Actions action = new Actions(GenericMethods.driver);
	action.contextClick(resrvId2).build().perform();
	GenericMethods.clickElement(rightClk_Payment);
	AccountStatementLandingPage ASP=PageFactory.initElements(GenericMethods.driver, AccountStatementLandingPage.class);
	return ASP;
	}
	catch(Exception e)
	{
		throw e;
	}
}

public AccountStatementLandingPage fn_NavigatePayment() throws Exception
{
	Actions action = new Actions(GenericMethods.driver);
	action.contextClick(ReservID_dpk).build().perform();
	GenericMethods.clickElement(rightClk_Payment);
	AccountStatementLandingPage ASP=PageFactory.initElements(GenericMethods.driver, AccountStatementLandingPage.class);
	return ASP;
}


public AccountStatementLandingPage fn_NavigatePayment1() throws Exception
{
	Actions action = new Actions(GenericMethods.driver);
	action.contextClick(ReserveID_TTR).build().perform();
	GenericMethods.clickElement(rightClk_Payment);
	AccountStatementLandingPage ASP=PageFactory.initElements(GenericMethods.driver, AccountStatementLandingPage.class);
	return ASP;
}

public AccountStatementLandingPage fn_NavigatePayment2() throws Exception
{
	try
	{
	Actions action = new Actions(GenericMethods.driver);
	action.contextClick(reservID_Payment).build().perform();
	GenericMethods.clickElement(rightClk_Payment);
	}
	catch(Exception e)
	{
		throw e;
	}
	AccountStatementLandingPage ASP=PageFactory.initElements(GenericMethods.driver, AccountStatementLandingPage.class);
	return ASP;

}


public CheckinCard fn_rightClkGrpCheckin() throws Exception
{
	try
	{
	Actions action = new Actions(GenericMethods.driver);
	action.contextClick(grpResrvID2).build().perform();
	GenericMethods.clickElement(grpcheckin);
	GenericMethods.ActionOnAlert("Accept");
	}
	catch(Exception e)
	{
		throw e;
	}
    CheckinCard CC=PageFactory.initElements(GenericMethods.driver, CheckinCard.class);
    return CC;
}

public ViewDetailsPage fn_rightclkViewDetailsGrp1() throws Exception
{
	try
	{
	Actions action = new Actions(GenericMethods.driver);
	action.contextClick(grpResrvID2).build().perform();
	GenericMethods.clickElement(rightClk_viewDetails);
	ViewDetailsPage VDP=PageFactory.initElements(GenericMethods.driver, ViewDetailsPage.class);
    return VDP;
	}
	catch(Exception e)
	{
		throw e;
	}
}

public ViewDetailsPage fn_rightClkViewDetailsGrp2() throws Exception
{
	try
	{
	Actions action = new Actions(GenericMethods.driver);
	action.contextClick(grpResrvID3).build().perform();
	GenericMethods.clickElement(rightClk_viewDetails);
	ViewDetailsPage VDP=PageFactory.initElements(GenericMethods.driver, ViewDetailsPage.class);
    return VDP;
	}
	catch(Exception e)
	{
		throw e;
	}
}

public void fn_rightClkCancelCheckinGrp() throws Exception
{
	Actions action = new Actions(GenericMethods.driver);
	action.contextClick(grpResrvID2).build().perform();
	GenericMethods.clickElement(rightClk_cnclcheckin);
	String str=GenericMethods.ActionOnAlert("Dismiss");
	Thread.sleep(4000);
	Assert.assertEquals(str, "Do you wish to Unassign the reservation?");

}


public void fn_AcceptCancelCheckinGrp() throws Exception
{
	try
	{
	Actions action = new Actions(GenericMethods.driver);
	action.contextClick(grpResrvID2).build().perform();
	GenericMethods.clickElement(rightClk_cnclcheckin);
	GenericMethods.ActionOnAlert("Accept");
	Thread.sleep(4000);
	}
	catch(Exception e)
	{
		throw e;
	}
}

public AccountStatementLandingPage fn_NavigateAccntstmtGenerateFolio() throws Exception
{
	Actions action = new Actions(GenericMethods.driver);
	action.contextClick(grpResrvID1).build().perform();
	GenericMethods.clickElement(rightClk_Payment);
	AccountStatementLandingPage ASP=PageFactory.initElements(GenericMethods.driver, AccountStatementLandingPage.class);
	return ASP;
}

public static WebReservationHomePage fn_WebReservationLink() throws Exception
{
	try
	{
    GenericMethods.clickElement(WebReservation_Link);
    WebReservationHomePage WRP = PageFactory.initElements(GenericMethods.driver, WebReservationHomePage.class);
    return WRP;
	}
	catch(Exception e)
	{
		throw e;
	}
}

public static AdminLoginPage fn_AdminLink() throws Exception
{
	GenericMethods.clickElement(Admin_lnk);
	AdminLoginPage ALO = PageFactory.initElements(GenericMethods.driver, AdminLoginPage.class);
	return ALO;
}


public BasePage fn_clkAdminLnk() throws Exception
{
	try
	{
	GenericMethods.clickElement(Admin_lnk);
	BasePage BP = PageFactory.initElements(GenericMethods.driver, BasePage.class);
	return BP;
	}
	catch(Exception e)
	{
		throw e;
	}
}

public AccountStatementLandingPage fn_NavigateAccntStmtGrp() throws Exception
{
	try
	{
	Actions action = new Actions(GenericMethods.driver);
	action.contextClick(grpResrvID3).build().perform();
	GenericMethods.clickElement(rightClk_Payment);
	AccountStatementLandingPage ASP=PageFactory.initElements(GenericMethods.driver, AccountStatementLandingPage.class);
	return ASP;
	}
	catch(Exception e)
	{
		throw e;
	}
}


public AccountStatementLandingPage fn_NavigateAccntStmtGrp1() throws Exception
{
	Actions action = new Actions(GenericMethods.driver);
	action.contextClick(checkoutDueResrv).build().perform();
	GenericMethods.clickElement(rightClk_Payment);
	AccountStatementLandingPage ASP=PageFactory.initElements(GenericMethods.driver, AccountStatementLandingPage.class);
	return ASP;
}



public LiveSupportLandingWindow fn_ClickLiveSupportButton() throws Exception
{

	 try
	 {
	   GenericMethods.clickElement(LiveSupport_BT);
       LiveSupportLandingWindow SRP = PageFactory.initElements(GenericMethods.driver, LiveSupportLandingWindow.class);
       return SRP;
	 }

	 catch(Exception e)
	 {
		 throw e;
	 }

 }



public ViewDetailsPage fn_RightclkSingles(WebElement ID, WebElement Link) throws Exception
{
	try
	{
	 //GenericMethods.clickElement(Current_Link);
    Actions action = new Actions(GenericMethods.driver);
    action.contextClick(ID).build().perform();
    GenericMethods.clickElement(Link);
    GenericMethods.ActionOnAlert("Accept");

    ViewDetailsPage VDP=PageFactory.initElements(GenericMethods.driver, ViewDetailsPage.class);
    return VDP;
	}
	catch(Exception e)
	{
		throw e;
	}
}


public ViewDetailsPage fn_RightclkSingle(WebElement ID, WebElement Link) throws Exception
{
	try
	{
	 GenericMethods.clickElement(Current_Link);
    Actions action = new Actions(GenericMethods.driver);
    Thread.sleep(3000);
    action.contextClick(ID).build().perform();
    GenericMethods.clickElement(Link);
    GenericMethods.ActionOnAlert("Accept");

    ViewDetailsPage VDP=PageFactory.initElements(GenericMethods.driver, ViewDetailsPage.class);
    return VDP;
	}
	catch(Exception e)
	{
		throw e;
	}
}

public ViewDetailsPage fn_rightclkViewDetailsSingle(WebElement ID, WebElement Link) throws Exception
{
	try
	{
	 GenericMethods.clickElement(Current_Link);
    Actions action = new Actions(GenericMethods.driver);
    action.contextClick(ID).build().perform();
    GenericMethods.clickElement(Link);

    ViewDetailsPage VDP=PageFactory.initElements(GenericMethods.driver, ViewDetailsPage.class);
    return VDP;
	}
	catch(Exception e)
	{
		throw e;
	}
	
}

public void fn_GroupCheckIN() throws Exception
{

  	 try
  	 {
  		Thread.sleep(2000);
  		GenericMethods.clickElement(ContinueToCheckIn_BT);
  	 }
  	 catch(Exception e)
  	 {
  		 throw e;
  	 }

}


public ReportLandingPage fn_ReportButton() throws Exception
{
	try
	{
	GenericMethods.clickElement(Report_BT);
    ReportLandingPage BP = PageFactory.initElements(GenericMethods.driver, ReportLandingPage.class);
	return BP;
	}
	catch(Exception e)
	{
		throw e;
	}
}


public WebReservationHomePage ClickOnWebReservation() throws Exception
{
	try
	{
GenericMethods.clickElement(WebReservation_Link);
WebReservationHomePage WRC=PageFactory.initElements(GenericMethods.driver,WebReservationHomePage.class);
return WRC;
	}
	catch(Exception e)
	{
		throw e;
	}

}


public NightAuditLandingPage fn_AutoNightAudit() throws Exception
{
	try
	{
	GenericMethods.js_Click(AutoNightAuditBtn);
	NightAuditLandingPage NAP=PageFactory.initElements(GenericMethods.driver, NightAuditLandingPage.class);
	return NAP;
	}
	catch(Exception e)
	{
		throw e;
	}
}


public void fn_AutoNightAudit1() throws Exception
{
	try
	{
	GenericMethods.js_Click(AutoNightAuditBtn);
	}
	catch(Exception e)
	{
		throw e;
	}
}


public void fn_RefreshFrontdesk() throws Exception
{


	GenericMethods.driver.navigate().refresh();
	if(Cancel_BT.isDisplayed()==true)
	{
		GenericMethods.clickElement(Cancel_BT);
		GenericMethods.ActionOnAlert("Accept");
	}
	else
	{
		System.out.println("Alert is not found");
	}

}



public NightAuditLandingPage fn_ClickPerformNightAudit_Link() throws Exception
{
  	 try
  	 {
  		GenericMethods.mouseOverElement(Frontdesk_BT);
  		GenericMethods.js_Click(PerformNightAudit_Link);


  	 }
  	 catch(Exception e)
  	 {
  		e.getMessage();
  	 }

  	 NightAuditLandingPage NAP=PageFactory.initElements(GenericMethods.driver, NightAuditLandingPage.class);
		return NAP;

}



public void fn_SetDNRDate() throws Exception
{

  	 try{
  		GenericMethods.clickElement(FromCal_DNRPopUp);
  		GenericMethods.clickElement(DateInCal_DNRPopUp);
  		GenericMethods.clickElement(ToCal_DNRPopUp);
  		GenericMethods.clickElement(DateInCal_DNRPopUp);
  		GenericMethods.sendKeys(TextBox_DNRPopUp, "Test");
  		//GenericMethods.clickElement(Submit_DNRPopUp);
  	 }catch(Exception e){
  		 throw e;
  	 }
    }

    public void fn_DeleteDNR() throws Exception{

  	 try{
  		GenericMethods.clickElement(DNR_Reservation);
  		Thread.sleep(2000);
  		GenericMethods.clickElement(DeleteIcon_DNRPopUp);
  		GenericMethods.clickElement(OKbutton_DNRPopUp);
  		Thread.sleep(5000);
  	 }catch(Exception e){
  		 throw e;
  	 }
    }




    public void fn_ValidateDNRPopUp_Title() throws Exception
    {

      	 try
      	 {
      	  // String str= GenericMethods.getText(DNR_PopUp);
      	  // Assert.assertEquals(str, "DNR Room#209");
      	 }
      	 catch(Exception e)
      	 {
      		 throw e;
      	 }
           }

    public void fn_ValidateDNR_PopUp(WebElement roomNum, WebElement link) throws Exception
    {

      	 try
      	 {
      		 GenericMethods.clickElement(Current_Link);
      		 Thread.sleep(5000);
      		 GenericMethods.clickElement(Rooms_CB);
      	     Actions action = new Actions(GenericMethods.driver);
             action.contextClick(roomNum).build().perform();

             GenericMethods.clickElement(link);
      	 }
      	 catch(Exception e)
      	 {
      		 throw e;
      	 }

    }


public BasePage fn_NavigateAdminConsole()
{
	Actions act = new Actions(GenericMethods.driver);
	act.moveToElement(FrontdeskLandingPage.Admin_lnk).contextClick().sendKeys("T").perform();
	act.sendKeys(Keys.chord(Keys.CONTROL,Keys.TAB)).perform();
	GenericMethods.driver.switchTo().defaultContent();
    BasePage BP=PageFactory.initElements(GenericMethods.driver, BasePage.class);
    return BP;

}





public void WindowScroll() throws InterruptedException
{
JavascriptExecutor jsx = (JavascriptExecutor)GenericMethods.driver;
Thread.sleep(2000);
jsx.executeScript("scroll(0, 700)");
//	  Actions action = new Actions(GenericMethods.driver);
//      action.sendKeys(Keys.PAGE_UP);

}


public void windowScrollUp()
{
	JavascriptExecutor jsx = (JavascriptExecutor)GenericMethods.driver;
	jsx.executeScript("scroll(0, -550)");

}

public  void getCountOfRooms1()
{
	   List<WebElement> rooms = GenericMethods.driver.findElements(By.xpath("//div[@id='rmtypehide44859']/div"));
	   int count = rooms.size();
	   System.out.println("Count: "+count);

	   for(int i = 0; i<count;i++)


	   {
		   String rm = rooms.get(i).getText();
		  // System.out.println(rm);
	   }
	List<WebElement> ChkBoxCount=GenericMethods.driver.findElements(By.xpath("//div[@id='rmtypehide44859']/div/div/input"));
 int count1 = ChkBoxCount.size();




WebElement abcd=ChkBoxCount.get(count1-1);
 abcd.click();

 //Code for Group booking....//

 /*

 WebElement abcd1=ChkBoxCount.get(count1-2);
 abcd1.click();

 WebElement abcd2=ChkBoxCount.get(count1-3);
 abcd2.click();

 WebElement abcd3=ChkBoxCount.get(count1-4);
 abcd3.click();


 */

//GenericMethods.js_Click(abcd);



}

public void fn_chkInclPkg() throws Exception
{

	Set<String> handles = GenericMethods.driver.getWindowHandles();

    int count = handles.size();


	Select sel=new Select(rateType);
	List<WebElement> arr=sel.getOptions();
	int count1=arr.size();
	for(int i=0;i<count;i++)
	{
		String type=arr.get(i).getText();
		if(type.equals("Sample Package FD"))
		{
			    GenericMethods.driver.findElement(By.xpath("//select[@id='qrSelRateType']//option["+i+"]")).click();
			    WebElement ele2=GenericMethods.driver.findElement(By.xpath("//input[@id='qrTxtFirstName']"));
			    GenericMethods.js_Sendkey(ele2, "res");
				WebElement ele3 = GenericMethods.driver.findElement(By.xpath("//select[@id='salutation']"));
//				System.out.println(value);
				Select select = new Select(ele3);
				select.selectByValue("Mr.");
				Thread.sleep(2000);
				WebElement ele4=GenericMethods.driver.findElement(By.xpath("//input[@id='qrTxtLastName']"));
				GenericMethods.js_Sendkey(ele4, "Sample");
				//	mouse.mouseUp(c);
				Thread.sleep(1500);
				GenericMethods.driver.findElement(By.xpath("//input[@id='qrTxtPhone']")).sendKeys("9987");
				Thread.sleep(2000);
				GenericMethods.driver.findElement(By.xpath("//input[@id='qrEmail']")).sendKeys("kk@yahoo.com");
				Thread.sleep(2000);
				GenericMethods.driver.findElement(By.xpath("//button[@id='qrBtnReserve-button']")).click();
		}

		else
		{
			fn_NavigateAdminConsole();
		}
	}
}

public void fn_clk2Rooms()
{

	   List<WebElement> rooms = GenericMethods.driver.findElements(By.xpath("//div[@id='rmtypehide44859']/div"));
	   int count = rooms.size();
	   System.out.println("Count: "+count);

	   for(int i = 0; i<count;i++)


	   {
		   String rm = rooms.get(i).getText();
		  // System.out.println(rm);
	   }
	List<WebElement> ChkBoxCount=GenericMethods.driver.findElements(By.xpath("//div[@id='rmtypehide44859']/div/div/input"));
int count1 = ChkBoxCount.size();




WebElement abcd=ChkBoxCount.get(count1-1);
abcd.click();

//Code for Group booking....//



WebElement abcd1=ChkBoxCount.get(count1-2);
abcd1.click();

}


public void fn_clk3Rooms()
{

	   List<WebElement> rooms = GenericMethods.driver.findElements(By.xpath("//div[@id='rmtypehide44859']/div"));
	   int count = rooms.size();
	   System.out.println("Count: "+count);

	   for(int i = 0; i<count;i++)


	   {
		   String rm = rooms.get(i).getText();
		  // System.out.println(rm);
	   }
	List<WebElement> ChkBoxCount=GenericMethods.driver.findElements(By.xpath("//div[@id='rmtypehide44859']/div/div/input"));
int count1 = ChkBoxCount.size();




WebElement abcd=ChkBoxCount.get(count1-1);
abcd.click();

//Code for Group booking....//



WebElement abcd1=ChkBoxCount.get(count1-2);
GenericMethods.js_Click(abcd1);

WebElement abcd2=ChkBoxCount.get(count1-3);
GenericMethods.js_Click(abcd2);


}



public void fn_SingleResrvOneNT() throws InterruptedException, AWTException 
{

	WebElement ele = GenericMethods.driver.findElement(By.xpath("//div[@id='bookingOwner']"));

	Dimension d1 = ele.getSize();
	System.out.println("Height:"+d1.height + "Width:" + d1.width);
	int Height = d1.height;
	int Width = d1.width;

	WebElement ele2 = GenericMethods.driver.findElement(By.xpath("//div[starts-with(@id,'rthead')]"));

	float WidthOfEachCell = (float) (Width/30.00);


	Point location = ele.getLocation();



	//..................aka.............................//
	Point location2 = ele2.getLocation();

	int x2 = location2.x;
	int y2 = location2.y;

	y2 = y2+81;
	System.out.println(x2);
	int x3 = x2 + 231;

	int x4 = x3+9;

	//............aka....................................//




	Dimension size = ele.getSize();
	System.out.println(location);
	System.out.println(size);
//
//	int x = location.x;
//	int y = location.y;





//...................aka.............................//

	int FromCoordinates = x3;
	int ToCoordinates= y2;
//.........................aka.....................//







//	int FromCoordinates = x+63;
//	int ToCoordinates = y+470;
	Actions builer = new Actions(GenericMethods.driver);


	Thread.sleep(10000);
//	int x1 = (int) mousePt.getX();
//	int y1 = (int) mousePt.getY();
	Robot robot = new Robot();
	Thread.sleep(5000);
	robot.mouseMove(FromCoordinates, ToCoordinates);
	Thread.sleep(1500);



	robot.mousePress(InputEvent.BUTTON1_MASK);
	//robot.mouseMove(50, 20);
    robot.mouseMove(FromCoordinates+45, ToCoordinates);
	robot.mouseRelease(InputEvent.BUTTON1_MASK);

//		Locatable locat = (Locatable) ele;
//		Mouse mouse = ((HasInputDevices) GenericMethods.driver).getMouse();
//		org.openqa.selenium.interactions.internal.Coordinates c=locat.getCoordinates();
	//	FrontdeskTest.click(c);
	//	c.onScreen();


	//	mouse.mouseDown(c);


	Thread.sleep(2000);
}




public void fn_SingleResrvTwoRoomNT() throws InterruptedException, AWTException
{

	WebElement ele = GenericMethods.driver.findElement(By.xpath("//div[@id='bookingOwner']"));

	Dimension d1 = ele.getSize();
	System.out.println("Height:"+d1.height + "Width:" + d1.width);
	int Height = d1.height;
	int Width = d1.width;

	WebElement ele2 = GenericMethods.driver.findElement(By.xpath("//div[starts-with(@id,'rthead')]"));

	float WidthOfEachCell = (float) (Width/30.00);


	Point location = ele.getLocation();



	//..................aka.............................//
	Point location2 = ele2.getLocation();

	int x2 = location2.x;
	int y2 = location2.y;

	y2 = y2+81;
	System.out.println(x2);
	int x3 = x2 + 231;

	int x4 = x3+9;

	//............aka....................................//




	Dimension size = ele.getSize();
	System.out.println(location);
	System.out.println(size);
//
//	int x = location.x;
//	int y = location.y;





//...................aka.............................//

	int FromCoordinates = x3;
	int ToCoordinates= y2;
//.........................aka.....................//







//	int FromCoordinates = x+63;
//	int ToCoordinates = y+470;
	Actions builer = new Actions(GenericMethods.driver);


	Thread.sleep(10000);
//	int x1 = (int) mousePt.getX();
//	int y1 = (int) mousePt.getY();
	Robot robot = new Robot();
	Thread.sleep(5000);
	robot.mouseMove(FromCoordinates, ToCoordinates);
	Thread.sleep(1500);



	robot.mousePress(InputEvent.BUTTON1_MASK);
	//robot.mouseMove(50, 20);
    robot.mouseMove(FromCoordinates+45, ToCoordinates);
	robot.mouseRelease(InputEvent.BUTTON1_MASK);

//		Locatable locat = (Locatable) ele;
//		Mouse mouse = ((HasInputDevices) GenericMethods.driver).getMouse();
//		org.openqa.selenium.interactions.internal.Coordinates c=locat.getCoordinates();
	//	FrontdeskTest.click(c);
	//	c.onScreen();


	//	mouse.mouseDown(c);


	Thread.sleep(2000);
}



public void fn_SingleResrv_ThreeRoomNT() throws InterruptedException, AWTException
{

	WebElement ele = GenericMethods.driver.findElement(By.xpath("//div[@id='bookingOwner']"));

	Dimension d1 = ele.getSize();
	System.out.println("Height:"+d1.height + "Width:" + d1.width);
	int Height = d1.height;
	int Width = d1.width;

	WebElement ele2 = GenericMethods.driver.findElement(By.xpath("//div[starts-with(@id,'rthead')]"));

	float WidthOfEachCell = (float) (Width/30.00);


	Point location = ele.getLocation();



	//..................aka.............................//
	Point location2 = ele2.getLocation();

	int x2 = location2.x;
	int y2 = location2.y;

	y2 = y2+81;
	System.out.println(x2);
	int x3 = x2 + 231;

	int x4 = x3+9;

	//............aka....................................//




	Dimension size = ele.getSize();
	System.out.println(location);
	System.out.println(size);
//
//	int x = location.x;
//	int y = location.y;





//...................aka.............................//

	int FromCoordinates = x3;
	int ToCoordinates= y2;
//.........................aka.....................//







//	int FromCoordinates = x+63;
//	int ToCoordinates = y+470;
	Actions builer = new Actions(GenericMethods.driver);


	Thread.sleep(10000);
//	int x1 = (int) mousePt.getX();
//	int y1 = (int) mousePt.getY();
	Robot robot = new Robot();
	Thread.sleep(5000);
	robot.mouseMove(FromCoordinates, ToCoordinates);
	Thread.sleep(1500);



	robot.mousePress(InputEvent.BUTTON1_MASK);
	//robot.mouseMove(50, 20);
    robot.mouseMove(FromCoordinates+75, ToCoordinates);
	robot.mouseRelease(InputEvent.BUTTON1_MASK);

//		Locatable locat = (Locatable) ele;
//		Mouse mouse = ((HasInputDevices) GenericMethods.driver).getMouse();
//		org.openqa.selenium.interactions.internal.Coordinates c=locat.getCoordinates();
	//	FrontdeskTest.click(c);
	//	c.onScreen();


	//	mouse.mouseDown(c);


	Thread.sleep(2000);
}


public void fn_SingleResrv_FourNT() throws InterruptedException, AWTException
{

	WebElement ele = GenericMethods.driver.findElement(By.xpath("//div[@id='bookingOwner']"));

	Dimension d1 = ele.getSize();
	System.out.println("Height:"+d1.height + "Width:" + d1.width);
	int Height = d1.height;
	int Width = d1.width;

	WebElement ele2 = GenericMethods.driver.findElement(By.xpath("//div[starts-with(@id,'rthead')]"));

	float WidthOfEachCell = (float) (Width/30.00);


	Point location = ele.getLocation();



	//..................aka.............................//
	Point location2 = ele2.getLocation();

	int x2 = location2.x;
	int y2 = location2.y;

	y2 = y2+81;
	System.out.println(x2);
	int x3 = x2 + 231;

	int x4 = x3+9;

	//............aka....................................//




	Dimension size = ele.getSize();
	System.out.println(location);
	System.out.println(size);
//
//	int x = location.x;
//	int y = location.y;





//...................aka.............................//

	int FromCoordinates = x3;
	int ToCoordinates= y2;
//.........................aka.....................//







//	int FromCoordinates = x+63;
//	int ToCoordinates = y+470;
	Actions builer = new Actions(GenericMethods.driver);


	Thread.sleep(10000);
//	int x1 = (int) mousePt.getX();
//	int y1 = (int) mousePt.getY();
	Robot robot = new Robot();
	Thread.sleep(5000);
	robot.mouseMove(FromCoordinates, ToCoordinates);
	Thread.sleep(1500);



	robot.mousePress(InputEvent.BUTTON1_MASK);
	//robot.mouseMove(50, 20);
    robot.mouseMove(FromCoordinates+94, ToCoordinates);
	robot.mouseRelease(InputEvent.BUTTON1_MASK);

//		Locatable locat = (Locatable) ele;
//		Mouse mouse = ((HasInputDevices) GenericMethods.driver).getMouse();
//		org.openqa.selenium.interactions.internal.Coordinates c=locat.getCoordinates();
	//	FrontdeskTest.click(c);
	//	c.onScreen();


	//	mouse.mouseDown(c);


	Thread.sleep(2000);
}






public void fn_fillAddQuickResrv() throws InterruptedException
{
	Set<String> handles = GenericMethods.driver.getWindowHandles();

	int count = handles.size();

    WebElement ele2=GenericMethods.driver.findElement(By.xpath("//input[@id='qrTxtFirstName']"));
    GenericMethods.js_Sendkey(ele2, "res");

	WebElement ele3 = GenericMethods.driver.findElement(By.xpath("//select[@id='salutation']"));
//	System.out.println(value);
	Select select = new Select(ele3);
	select.selectByValue("Mr.");
	Thread.sleep(2000);
	WebElement ele4=GenericMethods.driver.findElement(By.xpath("//input[@id='qrTxtLastName']"));
	GenericMethods.js_Sendkey(ele4, "Sample");
	//	mouse.mouseUp(c);
	Thread.sleep(1500);
	GenericMethods.driver.findElement(By.xpath("//input[@id='qrTxtPhone']")).sendKeys("9987");
	Thread.sleep(2000);
	GenericMethods.driver.findElement(By.xpath("//input[@id='qrEmail']")).sendKeys("kk@yahoo.com");
	Thread.sleep(2000);
	GenericMethods.driver.findElement(By.xpath("//button[@id='qrBtnReserve-button']")).click();
//	String text=GenericMethods.getText(tooltip);
//	System.out.println(text);


	//Thread.sleep(50000);
}

public void fn_verify1RoomDD()
{
	Select sel=new Select(roomDD);
	String selRMNum=sel.getFirstSelectedOption().getText();
	Assert.assertEquals(selRMNum, "1");
}



public EnableEditingPage fn_fillAddQuickSingleLnk() throws Exception
{
	Set<String> handles = GenericMethods.driver.getWindowHandles();

	int count = handles.size();

	fn_verify1RoomDD();
    WebElement ele2=GenericMethods.driver.findElement(By.xpath("//input[@id='qrTxtFirstName']"));
   GenericMethods.js_Sendkey(ele2, "res");

	WebElement ele3 = GenericMethods.driver.findElement(By.xpath("//select[@id='salutation']"));
//	System.out.println(value);
	Select select = new Select(ele3);
	select.selectByValue("Mr.");
	Thread.sleep(2000);
	WebElement ele4=GenericMethods.driver.findElement(By.xpath("//input[@id='qrTxtLastName']"));
	GenericMethods.js_Sendkey(ele4, "Sample");
	//	mouse.mouseUp(c);
	Thread.sleep(1500);
	GenericMethods.driver.findElement(By.xpath("//input[@id='qrTxtPhone']")).sendKeys("9987");
	Thread.sleep(2000);
	GenericMethods.driver.findElement(By.xpath("//input[@id='qrEmail']")).sendKeys("kk@yahoo.com");
	Thread.sleep(2000);
	//GenericMethods.driver.findElement(By.xpath("//button[@id='qrBtnReserve-button']")).click();
//	String text=GenericMethods.getText(tooltip);
//	System.out.println(text);
    GenericMethods.clickElement(singleLnk);
    EnableEditingPage EEP=PageFactory.initElements(GenericMethods.driver, EnableEditingPage.class);
    return EEP;

	//Thread.sleep(50000);
}


public EnableEditingPage fn_clkSingleLnk() throws Exception
{
    GenericMethods.clickElement(singleLnk);
    Thread.sleep(7000);
    EnableEditingPage EEP=PageFactory.initElements(GenericMethods.driver, EnableEditingPage.class);
    return EEP;

}

public EnableEditingPage fn_clkGroupLnk() throws Exception
{
    GenericMethods.clickElement(groupLnk);
    Thread.sleep(7000);
    EnableEditingPage EEP=PageFactory.initElements(GenericMethods.driver, EnableEditingPage.class);
    return EEP;

}


public EnableEditingPage fn_clkAgntCorpLnk() throws Exception
{
    GenericMethods.clickElement(ag_corp_Lnk);
    Thread.sleep(7000);
    EnableEditingPage EEP=PageFactory.initElements(GenericMethods.driver, EnableEditingPage.class);
    return EEP;

}




public EnableEditingPage fn_fillAddQuickGroupLnk() throws Exception
{
	Set<String> handles = GenericMethods.driver.getWindowHandles();

	int count = handles.size();

	fn_verify2RoomDD();
    WebElement ele2=GenericMethods.driver.findElement(By.xpath("//input[@id='qrTxtFirstName']"));
   GenericMethods.js_Sendkey(ele2, "res");

	WebElement ele3 = GenericMethods.driver.findElement(By.xpath("//select[@id='salutation']"));
//	System.out.println(value);
	Select select = new Select(ele3);
	select.selectByValue("Mr.");
	Thread.sleep(2000);
	WebElement ele4=GenericMethods.driver.findElement(By.xpath("//input[@id='qrTxtLastName']"));
	GenericMethods.js_Sendkey(ele4, "Sample");
	//	mouse.mouseUp(c);
	Thread.sleep(1500);
	GenericMethods.driver.findElement(By.xpath("//input[@id='qrTxtPhone']")).sendKeys("9987");
	Thread.sleep(2000);
	GenericMethods.driver.findElement(By.xpath("//input[@id='qrEmail']")).sendKeys("kk@yahoo.com");
	Thread.sleep(2000);
	//GenericMethods.driver.findElement(By.xpath("//button[@id='qrBtnReserve-button']")).click();
//	String text=GenericMethods.getText(tooltip);
//	System.out.println(text);
    GenericMethods.clickElement(groupLnk);
    EnableEditingPage EEP=PageFactory.initElements(GenericMethods.driver, EnableEditingPage.class);
    return EEP;

	//Thread.sleep(50000);
}


public EnableEditingPage fn_fillAddQuickAgntCorpLnk() throws Exception
{
	Set<String> handles = GenericMethods.driver.getWindowHandles();

	int count = handles.size();

	fn_verify2RoomDD();
    WebElement ele2=GenericMethods.driver.findElement(By.xpath("//input[@id='qrTxtFirstName']"));
   GenericMethods.js_Sendkey(ele2, "res");

	WebElement ele3 = GenericMethods.driver.findElement(By.xpath("//select[@id='salutation']"));
//	System.out.println(value);
	Select select = new Select(ele3);
	select.selectByValue("Mr.");
	Thread.sleep(2000);
	WebElement ele4=GenericMethods.driver.findElement(By.xpath("//input[@id='qrTxtLastName']"));
	GenericMethods.js_Sendkey(ele4, "Sample");
	//	mouse.mouseUp(c);
	Thread.sleep(1500);
	GenericMethods.driver.findElement(By.xpath("//input[@id='qrTxtPhone']")).sendKeys("9987");
	Thread.sleep(2000);
	GenericMethods.driver.findElement(By.xpath("//input[@id='qrEmail']")).sendKeys("kk@yahoo.com");
	Thread.sleep(2000);
	//GenericMethods.driver.findElement(By.xpath("//button[@id='qrBtnReserve-button']")).click();
//	String text=GenericMethods.getText(tooltip);
//	System.out.println(text);
    GenericMethods.clickElement(ag_corp_Lnk);
    EnableEditingPage EEP=PageFactory.initElements(GenericMethods.driver, EnableEditingPage.class);
    return EEP;

	//Thread.sleep(50000);
}



public void fn_fillAddQuickSeasonR() throws Exception
{
	Set<String> handles = GenericMethods.driver.getWindowHandles();

	int count = handles.size();

	fn_verify1RoomDD();
	GenericMethods.selectElementByIndex(rateType, 0);
    WebElement ele2=GenericMethods.driver.findElement(By.xpath("//input[@id='qrTxtFirstName']"));
    GenericMethods.js_Sendkey(ele2, "res");

	WebElement ele3 = GenericMethods.driver.findElement(By.xpath("//select[@id='salutation']"));
//	System.out.println(value);
	Select select = new Select(ele3);
	select.selectByValue("Mr.");
	Thread.sleep(2000);
	WebElement ele4=GenericMethods.driver.findElement(By.xpath("//input[@id='qrTxtLastName']"));
	GenericMethods.js_Sendkey(ele4, "Sample");
	//	mouse.mouseUp(c);
	Thread.sleep(1500);
	GenericMethods.driver.findElement(By.xpath("//input[@id='qrTxtPhone']")).sendKeys("9987");
	Thread.sleep(2000);
	GenericMethods.driver.findElement(By.xpath("//input[@id='qrEmail']")).sendKeys("kk@yahoo.com");
	Thread.sleep(2000);
	GenericMethods.driver.findElement(By.xpath("//button[@id='qrBtnReserve-button']")).click();
//	String text=GenericMethods.getText(tooltip);
//	System.out.println(text);


	//Thread.sleep(50000);
}

public void fn_fillAddQuickRackR() throws Exception
{
	Set<String> handles = GenericMethods.driver.getWindowHandles();

	int count = handles.size();

	fn_verify1RoomDD();
	GenericMethods.selectElementByIndex(rateType, 1);
    WebElement ele2=GenericMethods.driver.findElement(By.xpath("//input[@id='qrTxtFirstName']"));
    GenericMethods.js_Sendkey(ele2, "res");

	WebElement ele3 = GenericMethods.driver.findElement(By.xpath("//select[@id='salutation']"));
//	System.out.println(value);
	Select select = new Select(ele3);
	select.selectByValue("Mr.");
	Thread.sleep(2000);
	WebElement ele4=GenericMethods.driver.findElement(By.xpath("//input[@id='qrTxtLastName']"));
	GenericMethods.js_Sendkey(ele4, "Sample");
	//	mouse.mouseUp(c);
	Thread.sleep(1500);
	GenericMethods.driver.findElement(By.xpath("//input[@id='qrTxtPhone']")).sendKeys("9987");
	Thread.sleep(2000);
	GenericMethods.driver.findElement(By.xpath("//input[@id='qrEmail']")).sendKeys("kk@yahoo.com");
	Thread.sleep(2000);
	GenericMethods.driver.findElement(By.xpath("//button[@id='qrBtnReserve-button']")).click();
//	String text=GenericMethods.getText(tooltip);
//	System.out.println(text);


	//Thread.sleep(50000);
}



public void fn_fillAddQuickTaxPkg() throws Exception
{
	Set<String> handles = GenericMethods.driver.getWindowHandles();

	int count = handles.size();

	fn_verify1RoomDD();
	//GenericMethods.selectElementByIndex(rateType, 1);
	Select sel=new Select(rateType);
	sel.selectByVisibleText("Sample Inclusive of tax pkg FD (2N)");
    WebElement ele2=GenericMethods.driver.findElement(By.xpath("//input[@id='qrTxtFirstName']"));
    GenericMethods.js_Sendkey(ele2, "res");

	WebElement ele3 = GenericMethods.driver.findElement(By.xpath("//select[@id='salutation']"));
//	System.out.println(value);
	Select select = new Select(ele3);
	select.selectByValue("Mr.");
	Thread.sleep(2000);
	WebElement ele4=GenericMethods.driver.findElement(By.xpath("//input[@id='qrTxtLastName']"));
	GenericMethods.js_Sendkey(ele4, "Sample");
	//	mouse.mouseUp(c);
	Thread.sleep(1500);
	GenericMethods.driver.findElement(By.xpath("//input[@id='qrTxtPhone']")).sendKeys("9987");
	Thread.sleep(2000);
	GenericMethods.driver.findElement(By.xpath("//input[@id='qrEmail']")).sendKeys("kk@yahoo.com");
	Thread.sleep(2000);
	GenericMethods.driver.findElement(By.xpath("//button[@id='qrBtnReserve-button']")).click();
//	String text=GenericMethods.getText(tooltip);
//	System.out.println(text);


	//Thread.sleep(50000);
}


public void fn_fillAddQuickChocBarPkg() throws Exception
{
	Set<String> handles = GenericMethods.driver.getWindowHandles();

	int count = handles.size();

	fn_verify2RoomDD();
	//GenericMethods.selectElementByIndex(rateType, 1);
	Select sel=new Select(rateType);
	sel.selectByVisibleText("Sample Choc Bar Pkg FD (1N)");
    WebElement ele2=GenericMethods.driver.findElement(By.xpath("//input[@id='qrTxtFirstName']"));
    GenericMethods.js_Sendkey(ele2, "res");

	WebElement ele3 = GenericMethods.driver.findElement(By.xpath("//select[@id='salutation']"));
//	System.out.println(value);
	Select select = new Select(ele3);
	select.selectByValue("Mr.");
	Thread.sleep(2000);
	WebElement ele4=GenericMethods.driver.findElement(By.xpath("//input[@id='qrTxtLastName']"));
	GenericMethods.js_Sendkey(ele4, "Sample");
	//	mouse.mouseUp(c);
	Thread.sleep(1500);
	GenericMethods.driver.findElement(By.xpath("//input[@id='qrTxtPhone']")).sendKeys("9987");
	Thread.sleep(2000);
	GenericMethods.driver.findElement(By.xpath("//input[@id='qrEmail']")).sendKeys("kk@yahoo.com");
	Thread.sleep(2000);
	GenericMethods.driver.findElement(By.xpath("//button[@id='qrBtnReserve-button']")).click();
//	String text=GenericMethods.getText(tooltip);
//	System.out.println(text);


	//Thread.sleep(50000);
}

public void fn_fillAddQuickChocBarPA() throws Exception
{
	Set<String> handles = GenericMethods.driver.getWindowHandles();

	int count = handles.size();

	fn_verify2RoomDD();
	//GenericMethods.selectElementByIndex(rateType, 1);
    GenericMethods.selectElementByIndex(adultDD, 1);
	Select sel=new Select(rateType);
	sel.selectByVisibleText("Choc Bar PA Pkg (1N)");
    WebElement ele2=GenericMethods.driver.findElement(By.xpath("//input[@id='qrTxtFirstName']"));
    GenericMethods.js_Sendkey(ele2, "res");

	WebElement ele3 = GenericMethods.driver.findElement(By.xpath("//select[@id='salutation']"));
//	System.out.println(value);
	Select select = new Select(ele3);
	select.selectByValue("Mr.");
	Thread.sleep(2000);
	WebElement ele4=GenericMethods.driver.findElement(By.xpath("//input[@id='qrTxtLastName']"));
	GenericMethods.js_Sendkey(ele4, "Sample");
	//	mouse.mouseUp(c);
	Thread.sleep(1500);
	GenericMethods.driver.findElement(By.xpath("//input[@id='qrTxtPhone']")).sendKeys("9987");
	Thread.sleep(2000);
	GenericMethods.driver.findElement(By.xpath("//input[@id='qrEmail']")).sendKeys("kk@yahoo.com");
	Thread.sleep(2000);
	GenericMethods.driver.findElement(By.xpath("//button[@id='qrBtnReserve-button']")).click();
//	String text=GenericMethods.getText(tooltip);
//	System.out.println(text);


	//Thread.sleep(50000);
}



public void fn_verify2RoomDD()
{
	Select sel=new Select(roomDD);
	String selRMNum=sel.getFirstSelectedOption().getText();
	Assert.assertEquals(selRMNum, "2");
}


public void fn_verify3RoomDD()
{
	Select sel=new Select(roomDD);
	String selRMNum=sel.getFirstSelectedOption().getText();
	Assert.assertEquals(selRMNum, "3");
}


public void fn_fillAddQuickResrv2RM() throws InterruptedException
{
	Set<String> handles = GenericMethods.driver.getWindowHandles();

	int count = handles.size();
	fn_verify2RoomDD();

    WebElement ele2=GenericMethods.driver.findElement(By.xpath("//input[@id='qrTxtFirstName']"));
   GenericMethods.js_Sendkey(ele2, "res");

	WebElement ele3 = GenericMethods.driver.findElement(By.xpath("//select[@id='salutation']"));
//	System.out.println(value);
	Select select = new Select(ele3);
	select.selectByValue("Mr.");
	Thread.sleep(2000);
	WebElement ele4=GenericMethods.driver.findElement(By.xpath("//input[@id='qrTxtLastName']"));
	GenericMethods.js_Sendkey(ele4, "Sample");
	//	mouse.mouseUp(c);
	Thread.sleep(1500);
	GenericMethods.driver.findElement(By.xpath("//input[@id='qrTxtPhone']")).sendKeys("9987");
	Thread.sleep(2000);
	GenericMethods.driver.findElement(By.xpath("//input[@id='qrEmail']")).sendKeys("kk@yahoo.com");
	Thread.sleep(2000);
	GenericMethods.driver.findElement(By.xpath("//button[@id='qrBtnReserve-button']")).click();
//	String text=GenericMethods.getText(tooltip);
//	System.out.println(text);


	//Thread.sleep(50000);
}

public void fn_fillAddQuickResrvWeekPkg() throws InterruptedException
{
	Set<String> handles = GenericMethods.driver.getWindowHandles();

	int count = handles.size();
	fn_verify2RoomDD();
	Select sel=new Select(rateType);
	sel.selectByVisibleText("Sample Weekly Rate pkg FD (2N)");
    WebElement ele2=GenericMethods.driver.findElement(By.xpath("//input[@id='qrTxtFirstName']"));
   GenericMethods.js_Sendkey(ele2, "res");

	WebElement ele3 = GenericMethods.driver.findElement(By.xpath("//select[@id='salutation']"));
//	System.out.println(value);
	Select select = new Select(ele3);
	select.selectByValue("Mr.");
	Thread.sleep(2000);
	WebElement ele4=GenericMethods.driver.findElement(By.xpath("//input[@id='qrTxtLastName']"));
	GenericMethods.js_Sendkey(ele4, "Sample");
	//	mouse.mouseUp(c);
	Thread.sleep(1500);
	GenericMethods.driver.findElement(By.xpath("//input[@id='qrTxtPhone']")).sendKeys("9987");
	Thread.sleep(2000);
	GenericMethods.driver.findElement(By.xpath("//input[@id='qrEmail']")).sendKeys("kk@yahoo.com");
	Thread.sleep(2000);
	GenericMethods.driver.findElement(By.xpath("//button[@id='qrBtnReserve-button']")).click();
//	String text=GenericMethods.getText(tooltip);
//	System.out.println(text);


	//Thread.sleep(50000);
}




public void fn_fillAddQuickResrv3RM() throws InterruptedException
{
	Set<String> handles = GenericMethods.driver.getWindowHandles();

	int count = handles.size();
	fn_verify3RoomDD();

    WebElement ele2=GenericMethods.driver.findElement(By.xpath("//input[@id='qrTxtFirstName']"));
   GenericMethods.js_Sendkey(ele2, "res");

	WebElement ele3 = GenericMethods.driver.findElement(By.xpath("//select[@id='salutation']"));
//	System.out.println(value);
	Select select = new Select(ele3);
	select.selectByValue("Mr.");
	Thread.sleep(2000);
	WebElement ele4=GenericMethods.driver.findElement(By.xpath("//input[@id='qrTxtLastName']"));
	GenericMethods.js_Sendkey(ele4, "Sample");
	//	mouse.mouseUp(c);
	Thread.sleep(1500);
	GenericMethods.driver.findElement(By.xpath("//input[@id='qrTxtPhone']")).sendKeys("9987");
	Thread.sleep(2000);
	GenericMethods.driver.findElement(By.xpath("//input[@id='qrEmail']")).sendKeys("kk@yahoo.com");
	Thread.sleep(2000);
	GenericMethods.driver.findElement(By.xpath("//button[@id='qrBtnReserve-button']")).click();
//	String text=GenericMethods.getText(tooltip);
//	System.out.println(text);


	//Thread.sleep(50000);
}


public void fn_fillAddQuick3RMSeasonR() throws Exception
{
	Set<String> handles = GenericMethods.driver.getWindowHandles();

	int count = handles.size();

	fn_verify3RoomDD();
	GenericMethods.selectElementByIndex(rateType, 0);
    WebElement ele2=GenericMethods.driver.findElement(By.xpath("//input[@id='qrTxtFirstName']"));
    GenericMethods.js_Sendkey(ele2, "res");

	WebElement ele3 = GenericMethods.driver.findElement(By.xpath("//select[@id='salutation']"));
//	System.out.println(value);
	Select select = new Select(ele3);
	select.selectByValue("Mr.");
	Thread.sleep(2000);
	WebElement ele4=GenericMethods.driver.findElement(By.xpath("//input[@id='qrTxtLastName']"));
	GenericMethods.js_Sendkey(ele4, "Sample");
	//	mouse.mouseUp(c);
	Thread.sleep(1500);
	GenericMethods.driver.findElement(By.xpath("//input[@id='qrTxtPhone']")).sendKeys("9987");
	Thread.sleep(2000);
	GenericMethods.driver.findElement(By.xpath("//input[@id='qrEmail']")).sendKeys("kk@yahoo.com");
	Thread.sleep(2000);
	GenericMethods.driver.findElement(By.xpath("//button[@id='qrBtnReserve-button']")).click();
//	String text=GenericMethods.getText(tooltip);
//	System.out.println(text);


	//Thread.sleep(50000);
}

public void fn_ChkinResrv1NT() throws InterruptedException, AWTException
{

	   List<WebElement> rooms = GenericMethods.driver.findElements(By.xpath("//div[@id='rmtypehide44859']/div"));
	   int count = rooms.size();
	   System.out.println("Count: "+count);

	   for(int i = 0; i<count;i++)


	   {
		   String rm = rooms.get(i).getText();
		  // System.out.println(rm);
	   }
	//List<WebElement> ChkBoxCount=GenericMethods.driver.findElements(By.xpath("//div[@id='rmtypehide44859']/div/div/input"));
	   List<WebElement> ChkBoxCount=GenericMethods.driver.findElements(By.xpath("//div[starts-with(@id,'rthead')]"));
	   int count1 = ChkBoxCount.size();



//	   List<WebElement> ChkBoxCount1=GenericMethods.driver.findElements(By.xpath("(//div[starts-with(@id,'rthead')])[1]//input"));
//       int count2=ChkBoxCount1.size();



	   List<WebElement> ChkBoxCount2=GenericMethods.driver.findElements(By.xpath("(//div[starts-with(@id,'rmtypehide')])[2]/div"));
       int count2=ChkBoxCount2.size();

       List<WebElement> ChkBoxCount3=GenericMethods.driver.findElements(By.xpath("(//div[starts-with(@id,'rmtypehide')])[3]/div"));
       int count3=ChkBoxCount3.size();

       List<WebElement> ChkBoxCount4=GenericMethods.driver.findElements(By.xpath("(//div[starts-with(@id,'rmtypehide')])[4]/div"));
       int count4=ChkBoxCount4.size();


       int totalcount=count+count1+count2+count3+count4;

WebElement abcd=ChkBoxCount.get(count1-1);
abcd.click();

//Code for Group booking....//
//int totalCount=count+count1+count2+count3+count4;

WebElement ele = GenericMethods.driver.findElement(By.xpath("//div[@id='bookingOwner']"));

Dimension d1 = ele.getSize();
System.out.println("Height:"+d1.height + "Width:" + d1.width);
int Height = d1.height;
int Width = d1.width;

WebElement ele2 = GenericMethods.driver.findElement(By.xpath("//div[starts-with(@id,'rthead')]"));

float WidthOfEachCell = (float) (Width/30.00);
float HeightOfEachCell=(float) (Height/(totalcount));

Point location = ele.getLocation();



//..................aka.............................//
Point location2 = ele2.getLocation();

int x2 = location2.x;
int y2 = location2.y;

y2 = (int) (y2+(count1*HeightOfEachCell)+190);
System.out.println(x2);
int x3 = x2 + 231;

int x4 = x3+9;

//............aka....................................//




Dimension size = ele.getSize();
System.out.println(location);
System.out.println(size);
//
//int x = location.x;
//int y = location.y;





//...................aka.............................//

int FromCoordinates = x3;
int ToCoordinates= y2;
//.........................aka.....................//







//int FromCoordinates = x+63;
//int ToCoordinates = y+470;
Actions builer = new Actions(GenericMethods.driver);


Thread.sleep(10000);
//int x1 = (int) mousePt.getX();
//int y1 = (int) mousePt.getY();
Robot robot = new Robot();
Thread.sleep(5000);
robot.mouseMove(FromCoordinates, ToCoordinates);
Thread.sleep(1500);



robot.mousePress(InputEvent.BUTTON1_MASK);
//robot.mouseMove(50, 20);
robot.mouseMove(FromCoordinates+10, ToCoordinates);
robot.mouseRelease(InputEvent.BUTTON1_MASK);


}

//public void fn_verifyReserv() throws InterruptedException, AWTException
//{
//
//	List<WebElement> ChkBoxCount=GenericMethods.driver.findElements(By.xpath("//div[starts-with(@id,'rthead')]"));
//	   int count = ChkBoxCount.size();
//
//
//	   WebElement abcd=ChkBoxCount.get(count-1);
//	   abcd.click();
//
//
//
//	   WebElement ele = GenericMethods.driver.findElement(By.xpath("//div[@id='bookingOwner']"));
//
//	   Dimension d1 = ele.getSize();
//	   System.out.println("Height:"+d1.height + "Width:" + d1.width);
//	   int Height = d1.height;
//	   int Width = d1.width;
//
//	   //WebElement ele2 = GenericMethods.driver.findElement(By.xpath("//div[starts-with(@id,'rthead')]"));
//
//	   WebElement ele2 = GenericMethods.driver.findElement(By.xpath("//div[starts-with(@id,'rthead')]"));
//
//
//	   float WidthOfEachCell = (float) (Width/30.00);
//
//
//
//	   List<WebElement> rooms = GenericMethods.driver.findElements(By.xpath("//div[@id='rmtypehide44859']/div"));
//	   int count1 = rooms.size();
//	   System.out.println("Count: "+count1);
//
//	   for(int i = 0; i<count1;i++)
//
//
//	   {
//		   String rm = rooms.get(i).getText();
//		   if(rm.contains(SaveRoomsPage.roomNumber))
//		   {
//			   WebElement ele3=GenericMethods.driver.findElement(By.xpath("(//div[starts-with(@id,'rmtypehide')])[1]//div["+i+"]//div"));
//			   Point location2 = ele3.getLocation();
//
//			   int x2 = location2.x;
//			   int y2 = location2.y;
//
//			   System.out.println(x2);
//			   int x3 = x2 + 231;
//
//			   int x4 = x3+9;
//
//			   int FromCoordinates = x3;
//			   int ToCoordinates= y2;
//
//			   Actions builer = new Actions(GenericMethods.driver);
//
//
//			   Thread.sleep(10000);
//			   //int x1 = (int) mousePt.getX();
//			   //int y1 = (int) mousePt.getY();
//			   Robot robot = new Robot();
//			   Thread.sleep(5000);
//			   robot.mouseMove(FromCoordinates, ToCoordinates);
//			   Thread.sleep(1500);
//
//
//
//			   robot.mousePress(InputEvent.BUTTON1_MASK);
//			   //robot.mouseMove(50, 20);
//			   robot.mouseMove(FromCoordinates+10, ToCoordinates);
//			   robot.mouseRelease(InputEvent.BUTTON1_MASK);
//			   break;
//
//
//		   }
//		  // System.out.println(rm);
//	   }
//
//
//
//
//}






public void fn_clickOnNewlyCreatedReservation(){
	WebElement ele1=GenericMethods.driver.findElement(By.cssSelector("div.rs-new"));
	   Boolean b=ele1.isDisplayed();
	   System.out.println(b);
	   String ele=ele1.getAttribute("class");
	   if(b.equals(true))
	   {
		   System.out.println("Reservation has been successfully saved on tapechart");
		   ele1.click();
	   }

	   else
	   {
		   System.out.println("Reservation failed");
	   }
}




public void fn_verifyReservation() throws InterruptedException
{
	Thread.sleep(1000);
WebElement ele1=GenericMethods.driver.findElement(By.cssSelector("div.rs-new"));
Boolean b=ele1.isDisplayed();
System.out.println(b);
String ele=ele1.getAttribute("class");
Thread.sleep(1000);
resvId=ele1.getAttribute("resrvid");
Thread.sleep(1000);
title=ele1.getAttribute("title");
Thread.sleep(1000);
System.out.println("title is " + title);
if(b.equals(true)){
 System.out.println("Reservation has been successfully saved on tapechart");
}
else{
System.out.println("Reservation failed");
}
}



public WebElement  getWebElement(String rid) throws InterruptedException{
	System.out.println("Reserve ID is _ " + rid);
	Thread.sleep(2000);
	WebElement ele=GenericMethods.driver.findElement(By.xpath("//div[@resrvid='"+rid+"']"));
	resTitle=ele.getAttribute("title");
	
	return ele;
}





public void fn_rightClickOnReservation(WebElement ele) throws Exception{
try{
Thread.sleep(2000);
Actions action = new Actions(GenericMethods.driver).contextClick(ele);
Thread.sleep(1000);
action.build().perform();
}
catch(Exception e){
throw e;
}
	
}





public void fn_verifyResFromDetailPage()
{
	WebElement ele1=GenericMethods.driver.findElement(By.cssSelector("div.rs-new"));
	   Boolean b=ele1.isDisplayed();
	   System.out.println(b);
	   String ele=ele1.getAttribute("class");
	   if(b.equals(true))
	   {
		   System.out.println("Reservation has been successfully saved on tapechart");
		   ele1.click();
	   }

	   else
	   {
		   System.out.println("Reservation failed");
	   }
}


/*public ViewDetailsPage ClickOnView(){
	
	
	ViewDetailsPage VDP=PageFactory.initElements(GenericMethods.driver, ViewDetailsPage.class);
	return VDP;
	
}*/


public CheckinCard fn_verifyReservAndCheckin() throws Exception
{
   WebElement ele1=GenericMethods.driver.findElement(By.cssSelector("div.rs-new"));
   Boolean b=ele1.isDisplayed();
   System.out.println(b);
   String ele=ele1.getAttribute("class");
   if(b.equals(true))
   {
	   System.out.println("Reservation has been successfully saved on tapechart");
	   Actions obj=new Actions(GenericMethods.driver);
	   obj.contextClick(ele1).build().perform();
	   GenericMethods.clickElement(grpcheckin);
	   GenericMethods.ActionOnAlert("Accept");
   }
   else
   {
	   System.out.println("Reservation failed");
   }

Thread.sleep(6000);
CheckinCard CC=PageFactory.initElements(GenericMethods.driver, CheckinCard.class);
return CC;
}



public  ViewDetailsPage fn_clkViewBtn() throws Exception
{
   GenericMethods.clickElement(viewBtn);
   ViewDetailsPage VDP=PageFactory.initElements(GenericMethods.driver, ViewDetailsPage.class);
   return VDP;
}


public void fn_verifyAddQuickResrvTitle() throws InterruptedException
{
	Thread.sleep(2000);
   String text=GenericMethods.getText(addQuickResrv);
   Assert.assertEquals(text, "Add Quick Reservation");
}

public ViewDetailsPage fn_RightclkforViewDetailsPage(WebElement ID, WebElement Link) throws Exception
{
	 GenericMethods.clickElement(Current_Link);
    Actions action = new Actions(GenericMethods.driver);
    action.moveToElement(ID).contextClick().build().perform();
    GenericMethods.js_Click(Link);
    GenericMethods.ActionOnAlert("Accept");

    ViewDetailsPage VDP=PageFactory.initElements(GenericMethods.driver, ViewDetailsPage.class);
    return VDP;
}



public AddQuickReservationForm fn_ChkinResrv1NT(int iTestCaseRow) throws Exception
{

   List<WebElement> ele=GenericMethods.driver.findElements(By.xpath("//div[starts-with(@id,'rthead')]"));
   int RTsize=ele.size();
   for(int j=0;j<=RTsize-1;j++)
   {
       String str=ele.get(j).getText().trim();
       System.out.println(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_RoomTypeName)));
       if(str.trim().equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_RoomTypeName))))
           {
              Assert.assertEquals(str, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_RoomTypeName)));
              
            //List<WebElement> rooms = GenericClass.driver.findElements(By.xpath("(//div[starts-with(@id,'rowheaders')])["+j+"]/div/div"));

               String countOfRT =  ele.get(j).getAttribute("roomcount");
               String idRT=ele.get(j).getAttribute("id");
              
               WebElement ele1=GenericMethods.driver.findElement(By.id(idRT));
               int count=Integer.parseInt(countOfRT);
               System.out.println("Room Count: "+count);
               
               
               GenericMethods.driver.findElements(By.xpath("//input[starts-with(@id,'chk_room_')]")).get(count-1).click();
            		   
               

          
               //List<WebElement> rooms=GenericMethods.driver.findElements(By.xpath("(//div[starts-with(@id,'rowheaders')])["+j+"]//div"));
             
               //GenericMethods.driver.findElement(By.xpath("(//div[starts-with(@id,'rowheaders')])["+j+"]//div[starts-with(@id,'rhead')]/div/input"));
//               int count1 = size();
              /* for(WebElement rm:rooms)
               {
            	   if( rm.getText().equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_RoomNames))))
            	   {
            		 rm.click();
            	   }
               }
              */ 
               
               
              // List<WebElement> ChkBoxCount=GenericMethods.driver.findElements(By.xpath("//div[@id='rmtypehide44859']/div/div/input"));
            

            /*  WebElement abcd=rooms.get(count1-1);
               abcd.click();*/

               

                       Dimension d1 = ele1.getSize();
                       System.out.println("Height:"+d1.height + "Width:" + d1.width);
                       int Height = d1.height;
                       int Width = d1.width;
                      
                       float WidthOfEachCell = (float) (Width/30.00);
                       float HeightOfEachCell=(float) (Height/(count));

                       Point location = ele1.getLocation();
                      
                       int x2 = location.x;
                       int y2 = location.y;

                        y2 = (int) (y2+(count*HeightOfEachCell)+70);
                       System.out.println(x2);
                     
                       int x3 = x2 + 251;
                       int x4 = x3+9;
                      
                       int FromCoordinates = x3;
                       int ToCoordinates= y2;

                       Actions builer = new Actions(GenericMethods.driver);


                      Thread.sleep(10000);
                      Robot robot = new Robot();
                      Thread.sleep(5000);
                      robot.mouseMove(FromCoordinates, ToCoordinates);
                      Thread.sleep(2000);



                      robot.mousePress(InputEvent.BUTTON1_MASK);
                      robot.mouseMove(FromCoordinates+45, ToCoordinates);
                      Thread.sleep(2000);
                      robot.mouseRelease(InputEvent.BUTTON1_MASK);
                      
                      Thread.sleep(4000);
                      
                      break;

                     // break;

                   //}
                  
                 // break;
               //}
           }
       
      
   }
   AddQuickReservationForm AQRF=PageFactory.initElements(GenericMethods.driver, AddQuickReservationForm.class);
   return AQRF;
    
     
    /*//List<WebElement> ChkBoxCount=GenericMethods.driver.findElements(By.xpath("//div[@id='rmtypehide44859']/div/div/input"));
       List<WebElement> ChkBoxCount=GenericClass.driver.findElements(By.xpath("//div[starts-with(@id,'rthead')]"));
       int count1 = ChkBoxCount.size();



//       List<WebElement> ChkBoxCount1=GenericMethods.driver.findElements(By.xpath("(//div[starts-with(@id,'rthead')])[1]//input"));
//       int count2=ChkBoxCount1.size();



       List<WebElement> ChkBoxCount2=GenericClass.driver.findElements(By.xpath("(//div[starts-with(@id,'rmtypehide')])[2]/div"));
       int count2=ChkBoxCount2.size();

       List<WebElement> ChkBoxCount3=GenericClass.driver.findElements(By.xpath("(//div[starts-with(@id,'rmtypehide')])[3]/div"));
       int count3=ChkBoxCount3.size();

       List<WebElement> ChkBoxCount4=GenericClass.driver.findElements(By.xpath("(//div[starts-with(@id,'rmtypehide')])[4]/div"));
       int count4=ChkBoxCount4.size();


       int totalcount=count
               +count1+count2+count3+count4;

WebElement abcd=ChkBoxCount.get(count1-1);
abcd.click();

//Code for Group booking....//
//int totalCount=count+count1+count2+count3+count4;

WebElement ele1 = GenericClass.driver.findElement(By.xpath("//div[@id='bookingOwner']"));

Dimension d1 = ele1.getSize();
System.out.println("Height:"+d1.height + "Width:" + d1.width);
int Height = d1.height;
int Width = d1.width;

WebElement ele2 = GenericClass.driver.findElement(By.xpath("//div[starts-with(@id,'rthead')]"));

float WidthOfEachCell = (float) (Width/30.00);
float HeightOfEachCell=(float) (Height/(totalcount));

Point location = ele1.getLocation();



//..................aka.............................//
Point location2 = ele2.getLocation();

int x2 = location2.x;
int y2 = location2.y;

y2 = (int) (y2+(count1*HeightOfEachCell)+190);
System.out.println(x2);
int x3 = x2 + 231;

int x4 = x3+9;

//............aka....................................//




Dimension size = ele.getSize();
System.out.println(location);
System.out.println(size);
//
//int x = location.x;
//int y = location.y;





//...................aka.............................//

int FromCoordinates = x3;
int ToCoordinates= y2;
//.........................aka.....................//







//int FromCoordinates = x+63;
//int ToCoordinates = y+470;
Actions builer = new Actions(GenericClass.driver);


Thread.sleep(10000);
//int x1 = (int) mousePt.getX();
//int y1 = (int) mousePt.getY();
Robot robot = new Robot();
Thread.sleep(5000);
robot.mouseMove(FromCoordinates, ToCoordinates);
Thread.sleep(1500);



robot.mousePress(InputEvent.BUTTON1_MASK);
//robot.mouseMove(50, 20);
robot.mouseMove(FromCoordinates+10, ToCoordinates);
robot.mouseRelease(InputEvent.BUTTON1_MASK);
*/

}






















public AddQuickReservationForm fn_DragAndDrop_FD() throws InterruptedException, AWTException
{

	WebElement ele = GenericMethods.driver.findElement(By.xpath("//div[@id='bookingOwner']"));

	Dimension d1 = ele.getSize();
	System.out.println("Height:"+d1.height + "Width:" + d1.width);
	int Height = d1.height;
	int Width = d1.width;

	WebElement ele2 = GenericMethods.driver.findElement(By.xpath("//div[starts-with(@id,'rthead')]"));

	float WidthOfEachCell = (float) (Width/30.00);


	Point location = ele.getLocation();



	//..................aka.............................//
	Point location2 = ele2.getLocation();

	int x2 = location2.x;
	int y2 = location2.y;

	y2 = y2+81;
	System.out.println(x2);
	int x3 = x2 + 231;

	int x4 = x3+9;

	//............aka....................................//




	Dimension size = ele.getSize();
	System.out.println(location);
	System.out.println(size);
//
//	int x = location.x;
//	int y = location.y;





//...................aka.............................//

	int FromCoordinates = x3;
	int ToCoordinates= y2;
//.........................aka.....................//







//	int FromCoordinates = x+63;
//	int ToCoordinates = y+470;
	Actions builer = new Actions(GenericMethods.driver);


	Thread.sleep(10000);
//	int x1 = (int) mousePt.getX();
//	int y1 = (int) mousePt.getY();
	Robot robot = new Robot();
	Thread.sleep(5000);
	robot.mouseMove(FromCoordinates, ToCoordinates);
	Thread.sleep(1500);



	robot.mousePress(InputEvent.BUTTON1_MASK);
	//robot.mouseMove(50, 20);
    robot.mouseMove(FromCoordinates+45, ToCoordinates);
	robot.mouseRelease(InputEvent.BUTTON1_MASK);

//		Locatable locat = (Locatable) ele;
//		Mouse mouse = ((HasInputDevices) GenericMethods.driver).getMouse();
//		org.openqa.selenium.interactions.internal.Coordinates c=locat.getCoordinates();
	//	FrontdeskTest.click(c);
	//	c.onScreen();


	//	mouse.mouseDown(c);


	Thread.sleep(2000);
	
	AddQuickReservationForm AQRF=PageFactory.initElements(GenericMethods.driver,AddQuickReservationForm.class);
	return AQRF;
	
}











public AddQuickReservationForm DragAndDropFor3N(String rtype) throws Exception{
	
	 List<WebElement> ele=GenericMethods.driver.findElements(By.xpath("//div[starts-with(@id,'rthead')]"));
	   int RTsize=ele.size();
	   for(int j=0;j<=RTsize-1;j++)
	   {
	       String str=ele.get(j).getText().trim();
	      
	       if(str.trim().equals(rtype))
	           {
	              Assert.assertEquals(str, rtype);
	              
	        
	               String countOfRT =  ele.get(j).getAttribute("roomcount");
	               String idRT=ele.get(j).getAttribute("id");
	              
	               WebElement ele1=GenericMethods.driver.findElement(By.id(idRT));
	               int count=Integer.parseInt(countOfRT);
	               System.out.println("Room Count: "+count);
	               Dimension d1 = ele1.getSize();
	                       System.out.println("Height:"+d1.height + "Width:" + d1.width);
	                       int Height = d1.height;
	                       int Width = d1.width;
	                      
	                       float WidthOfEachCell = (float) (Width/30.00);
	                       float HeightOfEachCell=(float) (Height/(count));

	                       Point location = ele1.getLocation();
	                      
	                       int x2 = location.x;
	                       int y2 = location.y;

	                        y2 = (int) (y2+(count*HeightOfEachCell)+70);
	                       System.out.println(x2);
	                     
	                       int x3 = x2 + 251;
	                       int x4 = x3+9;
	                      
	                       int FromCoordinates = x3;
	                       int ToCoordinates= y2;

	                       Actions builer = new Actions(GenericMethods.driver);


	                      Thread.sleep(10000);
	                      Robot robot = new Robot();
	                      Thread.sleep(5000);
	                      robot.mouseMove(FromCoordinates, ToCoordinates);
	                      Thread.sleep(2000);



	                      robot.mousePress(InputEvent.BUTTON1_MASK);
	                      robot.mouseMove(FromCoordinates+75, ToCoordinates);
	                      Thread.sleep(2000);
	                      robot.mouseRelease(InputEvent.BUTTON1_MASK);
	                      
	                      Thread.sleep(4000);
	                      
	                      break;
	           }
	   }
	   AddQuickReservationForm AQRF=PageFactory.initElements(GenericMethods.driver,AddQuickReservationForm.class);
	   return AQRF;
	
}


public AddQuickReservationForm DragAndDropFor2N(int iTestCaseRow) throws Exception{
	
	 List<WebElement> ele=GenericMethods.driver.findElements(By.xpath("//div[starts-with(@id,'rthead')]"));
	
	   int RTsize=ele.size();
	   for(int j=0;j<=RTsize-1;j++)
	   {
	       String str=ele.get(j).getText().trim();
	       System.out.println(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_RoomTypeName)));
	       if(str.trim().equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_RoomTypeName))))
	           {
	              Assert.assertEquals(str, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_RoomTypeName)));
	              
	        
	               String countOfRT =  ele.get(j).getAttribute("roomcount");
	               String idRT=ele.get(j).getAttribute("id");
	              
	               WebElement ele1=GenericMethods.driver.findElement(By.id(idRT));
	               int count=Integer.parseInt(countOfRT);
	               System.out.println("Room Count: "+count);
	               
	               
	               GenericMethods.driver.findElements(By.xpath("//input[starts-with(@id,'chk_room_')]")).get(count-1).click();
	            		   
	               

	          
	             

	               

	                       Dimension d1 = ele1.getSize();
	                       System.out.println("Height:"+d1.height + "Width:" + d1.width);
	                       int Height = d1.height;
	                       int Width = d1.width;
	                      
	                       float WidthOfEachCell = (float) (Width/30.00);
	                       float HeightOfEachCell=(float) (Height/(count));

	                       Point location = ele1.getLocation();
	                      
	                       int x2 = location.x;
	                       int y2 = location.y;

	                        y2 = (int) (y2+(count*HeightOfEachCell)+70);
	                       System.out.println(x2);
	                     
	                       int x3 = x2 + 251;
	                       int x4 = x3+9;
	                      
	                       int FromCoordinates = x3;
	                       int ToCoordinates= y2;

	                       Actions builer = new Actions(GenericMethods.driver);


	                      Thread.sleep(10000);
	                      Robot robot = new Robot();
	                      Thread.sleep(5000);
	                      robot.mouseMove(FromCoordinates, ToCoordinates);
	                      Thread.sleep(2000);



	                      robot.mousePress(InputEvent.BUTTON1_MASK);
	                      robot.mouseMove(FromCoordinates+45, ToCoordinates);
	                      Thread.sleep(2000);
	                      robot.mouseRelease(InputEvent.BUTTON1_MASK);
	                      
	                      Thread.sleep(4000);
	                      
	                      break;
	           }
	   }
	   AddQuickReservationForm AQRF=PageFactory.initElements(GenericMethods.driver,AddQuickReservationForm.class);
	   return AQRF;
	
}


////div[starts-with(@id,'rthead')]["+j+"]//[starts-with(@id,'rhead')]

public void  SelectSingleAddedRoom(int iTestCaseRow) throws Exception{
	 List<WebElement> ele=GenericMethods.driver.findElements(By.xpath("//div[starts-with(@id,'rthead')]"));
		
	   int RTsize=ele.size();
	   for(int j=0;j<=RTsize-1;j++)
	   {
		   
		   
		  
	       String str=ele.get(j).getText().trim();
	      String s= ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_RoomTypeName));
	      System.out.println(s);
	     
	       if(str.trim().equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_RoomTypeName))))
	           {
	    	   
	  List<WebElement> allRooms=GenericMethods.driver.findElements(By.xpath("//div[@class='room']"));
	  for(int i=0; i<=allRooms.size()-1; i++){
		  String title=allRooms.get(i).getAttribute("title");
		  if(title.equals(AddRoomsPage.roomNumber) || title.equals(AddRoomsPage.roomNumber) || title.equals(AddRoomsPage.roomNumber)==true){
			  List<WebElement> chebox= GenericMethods.driver.findElements(By.xpath("//input[@class='checkbox']"));
			  chebox.get(i).click();
		  }
	  }
	  
	  
	   
	    		   
	    		   
	    	   }
	    	   
	    	
	    	   
	    /*	// GenericMethods.driver.findElements(By.xpath("//div[@title='"+AddRoomsPage.roomNumber+"']")).equals(AddRoomsPage.roomNumber))
	    		 
	    		 
	    		 
	    		 
	    	
	              Assert.assertEquals(str, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_RoomTypeName)));
	              
	        
	               String countOfRT =  ele.get(j).getAttribute("roomcount");
	               String idRT=ele.get(j).getAttribute("id");
	              
	               WebElement ele1=GenericMethods.driver.findElement(By.id(idRT));
	               int count=Integer.parseInt(countOfRT);
	               System.out.println("Room Count: "+count);
	               
	               
	               
	               
	               GenericMethods.driver.findElements(By.xpath("//input[starts-with(@id,'chk_room_')]")).get(count-1).click();
	*/
	           }
	
	
	
	
}




public AddQuickReservationForm DragAndDrop() throws InterruptedException, AWTException{
	 List<WebElement> ele=GenericMethods.driver.findElements(By.xpath("//div[starts-with(@id,'rthead')]"));

     String countOfRT =  ele.get(0).getAttribute("roomcount");
     String idRT=ele.get(0).getAttribute("id");
     
    
     WebElement ele1=GenericMethods.driver.findElement(By.id(idRT));
     int count=Integer.parseInt(countOfRT);
     
     Dimension d1 = ele1.getSize();
	      System.out.println("Height:"+d1.height + "Width:" + d1.width);
	                int Height = d1.height;
	                       int Width = d1.width;
	                      
	                       float WidthOfEachCell = (float) (Width/30.00);
	                       float HeightOfEachCell=(float) (Height/(count));

	                       Point location = ele1.getLocation();
	                      
	                       int x2 = location.x;
	                       int y2 = location.y;

	                        y2 = (int) (y2+(count*HeightOfEachCell)+70);
	                       System.out.println(x2);
	                     
	                       int x3 = x2 + 251;
	                       int x4 = x3+9;
	                      
	                       int FromCoordinates = x3;
	                       int ToCoordinates= y2;

	                       Actions builer = new Actions(GenericMethods.driver);


	                      Thread.sleep(10000);
	                      Robot robot = new Robot();
	                      Thread.sleep(5000);
	                      robot.mouseMove(FromCoordinates, ToCoordinates);
	                      Thread.sleep(2000);



	                      robot.mousePress(InputEvent.BUTTON1_MASK);
	                      robot.mouseMove(FromCoordinates+10, ToCoordinates);
	                      Thread.sleep(2000);
	                      robot.mouseRelease(InputEvent.BUTTON1_MASK);
	                      
	                      Thread.sleep(4000);
	                      
	                      
	                      AddQuickReservationForm AQRF=PageFactory.initElements(GenericMethods.driver,AddQuickReservationForm.class);
	
	return AQRF;
}



public AddQuickReservationForm DragAndDropFor2N(String rtype) throws Exception{
	
	 List<WebElement> ele=GenericMethods.driver.findElements(By.xpath("//div[starts-with(@id,'rthead')]"));
	   int RTsize=ele.size();
	   for(int j=0;j<=RTsize-1;j++)
	   {
	       String str=ele.get(j).getText().trim();
	      
	       if(str.trim().equals(rtype))
	           {
	              Assert.assertEquals(str, rtype);
	              
	        
	               String countOfRT =  ele.get(j).getAttribute("roomcount");
	               String idRT=ele.get(j).getAttribute("id");
	              
	               WebElement ele1=GenericMethods.driver.findElement(By.id(idRT));
	               int count=Integer.parseInt(countOfRT);
	               System.out.println("Room Count: "+count);
	               
	     
	                       Dimension d1 = ele1.getSize();
	                       System.out.println("Height:"+d1.height + "Width:" + d1.width);
	                       int Height = d1.height;
	                       int Width = d1.width;
	                      
	                       float WidthOfEachCell = (float) (Width/30.00);
	                       float HeightOfEachCell=(float) (Height/(count));

	                       Point location = ele1.getLocation();
	                      
	                       int x2 = location.x;
	                       int y2 = location.y;

	                        y2 = (int) (y2+(count*HeightOfEachCell)+70);
	                       System.out.println(x2);
	                     
	                       int x3 = x2 + 251;
	                       int x4 = x3+9;
	                      
	                       int FromCoordinates = x3;
	                       int ToCoordinates= y2;

	                       Actions builer = new Actions(GenericMethods.driver);


	                      Thread.sleep(10000);
	                      Robot robot = new Robot();
	                      Thread.sleep(5000);
	                      robot.mouseMove(FromCoordinates, ToCoordinates);
	                      Thread.sleep(2000);



	                      robot.mousePress(InputEvent.BUTTON1_MASK);
	                      Thread.sleep(2000);
	                      robot.mouseMove(FromCoordinates+45, ToCoordinates);
	                      Thread.sleep(2000);
	                      robot.mouseRelease(InputEvent.BUTTON1_MASK);
	                      
	                      Thread.sleep(5000);
	                      
	                      break;
	           }
	   }
	   AddQuickReservationForm AQRF=PageFactory.initElements(GenericMethods.driver,AddQuickReservationForm.class);
	   return AQRF;
	
}


public AddQuickReservationForm DragAndDropFor4N(String rtype) throws Exception{
	
	 List<WebElement> ele=GenericMethods.driver.findElements(By.xpath("//div[starts-with(@id,'rthead')]"));
	   int RTsize=ele.size();
	   for(int j=0;j<=RTsize-1;j++)
	   {
	       String str=ele.get(j).getText().trim();
	      
	       if(str.trim().equals(rtype))
	           {
	              Assert.assertEquals(str, rtype);
	              
	        
	               String countOfRT =  ele.get(j).getAttribute("roomcount");
	               String idRT=ele.get(j).getAttribute("id");
	              
	               WebElement ele1=GenericMethods.driver.findElement(By.id(idRT));
	               int count=Integer.parseInt(countOfRT);
	               System.out.println("Room Count: "+count);
	               
	     
	                       Dimension d1 = ele1.getSize();
	                       System.out.println("Height:"+d1.height + "Width:" + d1.width);
	                       int Height = d1.height;
	                       int Width = d1.width;
	                      
	                       float WidthOfEachCell = (float) (Width/30.00);
	                       float HeightOfEachCell=(float) (Height/(count));

	                       Point location = ele1.getLocation();
	                      
	                       int x2 = location.x;
	                       int y2 = location.y;

	                        y2 = (int) (y2+(count*HeightOfEachCell)+70);
	                       System.out.println(x2);
	                     
	                       int x3 = x2 + 251;
	                       int x4 = x3+9;
	                      
	                       int FromCoordinates = x3;
	                       int ToCoordinates= y2;

	                       Actions builer = new Actions(GenericMethods.driver);


	                      Thread.sleep(10000);
	                      Robot robot = new Robot();
	                      Thread.sleep(5000);
	                      robot.mouseMove(FromCoordinates, ToCoordinates);
	                      Thread.sleep(2000);



	                      robot.mousePress(InputEvent.BUTTON1_MASK);
	                      Thread.sleep(2000);
	                      robot.mouseMove(FromCoordinates+90, ToCoordinates);
	                      Thread.sleep(2000);
	                      robot.mouseRelease(InputEvent.BUTTON1_MASK);
	                      
	                      Thread.sleep(5000);
	                      
	                      break;
	                  }


	
}
	   AddQuickReservationForm AQRF=PageFactory.initElements(GenericMethods.driver,AddQuickReservationForm.class);
	   return AQRF;
}


public AddQuickReservationForm DragAndDropFor1N(String rtype) throws Exception{
	
	 List<WebElement> ele=GenericMethods.driver.findElements(By.xpath("//div[starts-with(@id,'rthead')]"));
	   int RTsize=ele.size();
	   for(int j=0;j<=RTsize-1;j++)
	   {
	       String str=ele.get(j).getText().trim();
	      
	       if(str.trim().equals(rtype))
	           {
	              Assert.assertEquals(str, rtype);
	              
	        
	               String countOfRT =  ele.get(j).getAttribute("roomcount");
	               String idRT=ele.get(j).getAttribute("id");
	              
	               WebElement ele1=GenericMethods.driver.findElement(By.id(idRT));
	               int count=Integer.parseInt(countOfRT);
	               System.out.println("Room Count: "+count);
	               
	     
	                       Dimension d1 = ele1.getSize();
	                       System.out.println("Height:"+d1.height + "Width:" + d1.width);
	                       int Height = d1.height;
	                       int Width = d1.width;
	                      
	                       float WidthOfEachCell = (float) (Width/30.00);
	                       float HeightOfEachCell=(float) (Height/(count));

	                       Point location = ele1.getLocation();
	                      
	                       int x2 = location.x;
	                       int y2 = location.y;

	                        y2 = (int) (y2+(count*HeightOfEachCell)+70);
	                       System.out.println(x2);
	                     
	                       int x3 = x2 + 251;
	                       int x4 = x3+9;
	                      
	                       int FromCoordinates = x3;
	                       int ToCoordinates= y2;

	                       Actions builer = new Actions(GenericMethods.driver);


	                      Thread.sleep(10000);
	                      Robot robot = new Robot();
	                      Thread.sleep(5000);
	                      robot.mouseMove(FromCoordinates, ToCoordinates);
	                      Thread.sleep(2000);



	                      robot.mousePress(InputEvent.BUTTON1_MASK);
	                      Thread.sleep(2000);
	                      robot.mouseMove(FromCoordinates+10, ToCoordinates);
	                      Thread.sleep(2000);
	                      robot.mouseRelease(InputEvent.BUTTON1_MASK);
	                      
	                      Thread.sleep(5000);
	                      
	                      break;
	           }
	   }
	   AddQuickReservationForm AQRF=PageFactory.initElements(GenericMethods.driver,AddQuickReservationForm.class);
	   return AQRF;
	
}



}




