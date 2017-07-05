package com.hotelogix.smoke.FrontdeskTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.hotelogix.smoke.admin.PriceManager.FrontDeskPackageDetailPage;
import com.hotelogix.smoke.admin.PriceManager.ListOfPackagesFrontdesk;
import com.hotelogix.smoke.admin.roommanager.AddRoomsPage;
import com.hotelogix.smoke.admin.roommanager.RoomsLandingPage;
import com.hotelogix.smoke.frontdesk.Accounts.AccountsLandingPage;
import com.hotelogix.smoke.frontdesk.Accounts.HotelLedgerLandingPage;
import com.hotelogix.smoke.frontdesk.Accounts.POSLedgerLandingPage;
import com.hotelogix.smoke.frontdesk.Accounts.POSPointLedgersListLandingPage;
import com.hotelogix.smoke.frontdesk.CashCounter.CashCounterPage;
import com.hotelogix.smoke.frontdesk.CashCounter.NightAuditPdfPage;
import com.hotelogix.smoke.frontdesk.CashCounter.NightAuditVideoPage;
import com.hotelogix.smoke.frontdesk.FrontdeskHome.AddQuickReservationForm;
import com.hotelogix.smoke.frontdesk.FrontdeskHome.FrontdeskLandingPage;
import com.hotelogix.smoke.frontdesk.FrontdeskHome.GroupReservationPage;
import com.hotelogix.smoke.frontdesk.FrontdeskHome.SingleReservationPage;
import com.hotelogix.smoke.frontdesk.FrontdeskTrialPage.FrontdeskContinueTrialPage;
import com.hotelogix.smoke.frontdesk.Payment.AccountStatementLandingPage;
import com.hotelogix.smoke.frontdesk.ReservationSearchResult.ReservationSearchResultLandingPage;
import com.hotelogix.smoke.frontdesk.SampleRestaurantPage.ConfirmOrderPage;
import com.hotelogix.smoke.frontdesk.SampleRestaurantPage.OrderFolioPage;
import com.hotelogix.smoke.frontdesk.SampleRestaurantPage.OrderFromNewTab;
import com.hotelogix.smoke.frontdesk.SampleRestaurantPage.SampleRestaurantPage;
import com.hotelogix.smoke.frontdesk.SampleRestaurantPage.TransactionListPage;
import com.hotelogix.smoke.frontdesk.ViewDetailsPage.EnableEditingPage;
import com.hotelogix.smoke.frontdesk.ViewDetailsPage.GroupEnableEditingPage;
import com.hotelogix.smoke.frontdesk.ViewDetailsPage.GroupToSingleReservationPage;
import com.hotelogix.smoke.frontdesk.ViewDetailsPage.GroupViewDetailPage;
import com.hotelogix.smoke.frontdesk.ViewDetailsPage.ViewDetailsPage;
import com.hotelogix.smoke.genericandbase.BasePage;
import com.hotelogix.smoke.genericandbase.Constant;
import com.hotelogix.smoke.genericandbase.ExcelUtil;
import com.hotelogix.smoke.genericandbase.GenericMethods;
import com.hotelogix.smoke.login.FrontdeskLoginPage;

public class Ftest {
	
	
	public WebDriver driver;
	private  String sTestCaseName;
	private int iTestCaseRow;
	public static ArrayList<String> a1=new ArrayList<String>();
	public static ArrayList<String> gd=new ArrayList<String>();
	FrontdeskContinueTrialPage FCT=new FrontdeskContinueTrialPage();
	
	
	
	@BeforeMethod
	//@org.testng.annotations.Parameters("browser")
	public void LaunchApp() throws Exception{
		
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
		iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		String br=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Browser));
	try
	{
	FrontdeskLoginPage AL = GenericMethods.fn_OpenFrontdesk(br, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_AppURL)));
	//AL.Frontdesklogin_12725();
	}catch(Exception e){
	    Thread.sleep(4000);
		System.out.println("System is showing problem during login");
		FrontdeskLoginPage AL = GenericMethods.fn_OpenFrontdesk(br, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_AppURL)));
		}
	}
	
	
	
	/*	@Test(priority=1)
	public void TC_14() throws Exception
	{
		try
		{
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
			iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			FrontdeskLoginPage AL=new FrontdeskLoginPage();
			  AL.FrontDeskLogin(iTestCaseRow);
			Thread.sleep(3000);
			FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
			CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
			Thread.sleep(3000);
			FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
			Thread.sleep(3000);
			FP.fn_ClickCancelButton();
			Thread.sleep(3000);
			String str=GenericMethods.GetCurrentWindowID();
			SampleRestaurantPage SRP=FP.ClickToSampleRestaurant();
			Thread.sleep(3000);
			GenericMethods.windowHandle(str);
			Assert.assertEquals(SRP.fn_VerifySampleRestaurantPage(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
			Thread.sleep(3000);
			SRP.fn_VerifyGroupGenerateAndConfirmOrderPage();
			Thread.sleep(3000);
			SRP.fn_TransferToRoomButton();
			GenericMethods.Switch_Parent_Window(str);
	        System.out.println("TC_14 Executed");
}
catch(Exception e){
throw e;
}
}
	
	
	@Test(priority=2)
	public void TC_15() throws Exception
	{
		try
		{
	   sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
			iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			FrontdeskLoginPage AL=new FrontdeskLoginPage();
			  AL.FrontDeskLogin(iTestCaseRow);
		FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
		CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		FP.fn_ClickCancelButton();
	    String str=GenericMethods.GetCurrentWindowID();
		LiveSupportLandingWindow LSL=FP.fn_ClickLiveSupportButton();
		GenericMethods.windowHandle(str);
		String title=LSL.fn_ValidateTitle();
		Thread.sleep(2000);
		Assert.assertEquals(title, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
		LSL.fn_ValidateAllLeaveaMessageElements();
		GenericMethods.Switch_Parent_Window(str);
	    System.out.println("TC_15 Executed");
		}
		 catch(Exception e)
		   {
		
		    throw e;
		   }
	}
	
	*/
/*@Test(priority=3)
public void TC_23() throws Exception{
try{
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
			iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			FrontdeskLoginPage AL=new FrontdeskLoginPage();
			  AL.FrontDeskLogin(iTestCaseRow);
			CashCounterPage CCP=FCT.fn_ClickCountinueWithTrail_BT();
			String act=CCP.YesOpenNewCounter();
			Assert.assertEquals(act, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
		    System.out.println("TC_23 Executed");
		    Reporter.log("TC_23: When 'Continue' button is clicked on Cash Counter Page,system displays a pop-up with message as:\n"
		    		+"'Please Select Counter'.",true);
		}

catch(Exception e){
throw e;
}
}


@Test(priority=4)
public void TC_24() throws Exception
{

try{
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
		iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
		  AL.FrontDeskLogin(iTestCaseRow);
		CashCounterPage CCP=FCT.fn_ClickCountinueWithTrail_BT();
		FrontdeskLandingPage FP=CCP.NoOpenNewcounter();
	Thread.sleep(4000);
		Assert.assertEquals(GenericMethods.driver.getTitle(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
	    System.out.println("TC_24 Executed");
	    Reporter.log("TC_24: When 'Default Counter(Open)' is selected from dropdown and 'Continue' button is clicked on Cash Counter Page,system redirects user to Frontdesk landing page.",true);
	}
catch(Exception e)
 {

  throw e;
 }	}

@Test(priority=5)
public void TC_25() throws Exception{
try{

		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
		iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
        AL.FrontDeskLogin(iTestCaseRow);
		CashCounterPage CCP=FCT.fn_ClickCountinueWithTrail_BT();
		String a=GenericMethods.GetCurrentWindowID();
		NightAuditVideoPage  NAV=CCP.ClickOnNightAuditVideoLink();
		GenericMethods.windowHandle(a);
		Thread.sleep(2000);
		String act=NAV.VerifyPage();
		Assert.assertEquals(act,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
		GenericMethods.driver.close();
		GenericMethods.Switch_Parent_Window(a);
        System.out.println("TC_25 Executed");
        Reporter.log("TC_25: On clicking 'How to Perform Night Audit Video!' link on Cash Counter Page,system displays a new window for Night Audit Video.",true);
}
catch(Exception e){
throw e;
}
}


@Test(priority=6)
public void TC_26() throws Exception
{
	try
	{ 
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
		iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
        AL.FrontDeskLogin(iTestCaseRow);
	    CashCounterPage CCP=FCT.fn_ClickCountinueWithTrail_BT();
	    String a=GenericMethods.GetCurrentWindowID();
	    NightAuditPdfPage NAP=CCP.ClickOnHowToUseLink();
	    GenericMethods.windowHandle(a);
	   String act= NAP.VerifyPage();
	   Thread.sleep(2000);
	   Assert.assertEquals(act, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
	   Thread.sleep(2000);
	    GenericMethods.Switch_Parent_Window(a);
	    System.out.println("TC_26 Executed");
	    Reporter.log("TC_26: On clicking 'How to use?' link on Cash Counter Page,system starts downloading process of pdf file.",true);

	}
	 catch(Exception e)
	   {
	   
	   throw e;
	   }
}



@Test(priority=7)
public void TC_27() throws Exception
{
	try
	{

		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
		iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
        AL.FrontDeskLogin(iTestCaseRow);
	    CashCounterPage CCP=FCT.fn_ClickCountinueWithTrail_BT();
	    String act= CCP.YesOpenNewCounter();
	    Assert.assertEquals(act,  ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
	    Thread.sleep(3000);
	    Reporter.log("No Counter to Select", true);
	    System.out.println("TC_27 Executed");
	    Reporter.log("TC_27: When 'Yes' radio button is clicked for 'Open New Cash Counter?' message,system does not display any counter in 'Select Your Counter' dropdown list.",true);
	}

	 catch(Exception e)
	   {
	   e.getMessage();
	   throw e;
	   
	   }
}






@Test(priority=8)
public void TC_28_29_30() throws Exception
{
	try
	{
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
		iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
        AL.FrontDeskLogin(iTestCaseRow);
		FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
		CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		String str=CCP.verify_pageHeader();
		Assert.assertEquals(str, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));

		Reporter.log("TC_28: Once a user enters login credential and clicks on 'Login' button,user gets redirected to Cash Counter Page in order to select cash counter.",true);

		FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		String str1=FP.verifyTitle();
		Assert.assertEquals(str1, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));

        Reporter.log("TC_29: On selecting 'Default Counter(Open)' and clicking 'Continue' button,user gets redirected to Frontdesk page wherein a panel to 'Perform Night Audit' apear.",true);

		String str2=FP.fn_ClickCancelButton();
		Assert.assertEquals(str1, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult3)));
	    System.out.println("TC_28_29_30 Executed");

	    Reporter.log(" TC_30: When 'Cancel' button for 'Perform Night Audit' panel is clicked,system displays an alert with message as:\n"
	    		+"'Do you wish to continue', wherein accepting that alert displays Frontdesk page (Tapechart).",true);
	}
	 catch(Exception e)
	   {
	 
	   throw e;
	   }
}



@Test(priority=9)
public void TC_31_32_33() throws Exception{
try{
	
	 sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	 ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
	 iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	 FrontdeskLoginPage AL=new FrontdeskLoginPage();
     AL.FrontDeskLogin(iTestCaseRow);
     FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	 Thread.sleep(2000);
	 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	 Thread.sleep(2000);
	 FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	 Thread.sleep(2000);
	 FP.fn_ClickCancelButton();
	 String cwid=GenericMethods.GetCurrentWindowID();
	 
	 BasePage AH= FP.fn_NavigateAdmineConsole();
	 GenericMethods.windowHandle(cwid);
	 RoomsLandingPage  RLP=AH.roomsPageNavigate();
	 AddRoomsPage ARP= RLP.click_AddRoom();
 
	 ARP.addRoomName();
     GenericMethods.Switch_Parent_Window(cwid);
	 GenericMethods.driver.navigate().refresh();
	 Thread.sleep(2000);
	 FP.fn_ClickCancelButton();
     FP.fn_clickCurrentLnk();
   
     
  
     AddQuickReservationForm AQRP  =FP.DragAndDrop();
      FP=AQRP.FillQuickResForm(iTestCaseRow);
    FP.fn_verifyReservation();
  System.out.println("TC_31_32_33 Executed");

	 Reporter.log("TC_31_32_33: Reservation created",true);
}
catch(Exception e)
  {
	
	 throw e;
  }	
	
		
	
}




@Test(priority=10)
public void TC_34() throws Exception{
	try{
	 sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	 ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
	 iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	 FrontdeskLoginPage AL=new FrontdeskLoginPage();
     AL.FrontDeskLogin(iTestCaseRow);
     FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	 Thread.sleep(2000);
	 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	 Thread.sleep(2000);
	 FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	 Thread.sleep(2000);
    FP.fn_ClickCancelButton();
    GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
	 String cwid=GenericMethods.GetCurrentWindowID();
	 
	  BasePage AH= FP.fn_NavigateAdmineConsole();
	 GenericMethods.windowHandle(cwid);
	 RoomsLandingPage  RLP=AH.roomsPageNavigate();
	 AddRoomsPage ARP= RLP.click_AddRoom();
     ARP.saveAndDuplicate();
 
     GenericMethods.Switch_Parent_Window(cwid);
	 GenericMethods.driver.navigate().refresh();
	 Thread.sleep(2000);
     FP.fn_ClickCancelButton();
     FP.fn_clickCurrentLnk();
     
  
     AddQuickReservationForm AQRP  =FP.DragAndDropFor1N(ARP.rtype);
     FP=AQRP.FillQuickResForm(iTestCaseRow);
     
     Reporter.log("Reservation for 2 rooms created for 1 night", true);
	}
	catch(Exception e){
throw e;
}
	
}




@Test(priority=11)
public void TC_35_36() throws Exception{
try{
	 sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	 ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
	 iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	 FrontdeskLoginPage AL=new FrontdeskLoginPage();
     AL.FrontDeskLogin(iTestCaseRow);
     FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	 Thread.sleep(2000);
	 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	 Thread.sleep(2000);
	 FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	 Thread.sleep(2000);
     FP.fn_ClickCancelButton();
     GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
	 String cwid=GenericMethods.GetCurrentWindowID();
	 
	  BasePage AH= FP.fn_NavigateAdmineConsole();
	 GenericMethods.windowHandle(cwid);
	 RoomsLandingPage  RLP=AH.roomsPageNavigate();
	 AddRoomsPage ARP= RLP.click_AddRoom();
     ARP.addRoomName();
 
     GenericMethods.Switch_Parent_Window(cwid);
	 GenericMethods.driver.navigate().refresh();
	 Thread.sleep(2000);
     FP.fn_ClickCancelButton();
     FP.fn_clickCurrentLnk();
     
     AddQuickReservationForm AQRP  =FP.DragAndDropFor1N(ARP.rtype);
     SingleReservationPage SRP= AQRP.FillQuickResvForm(iTestCaseRow);
     Thread.sleep(2000);
     Assert.assertEquals(GenericMethods.getText(SRP.title_SingleResPage).trim(),  ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
     FP=SRP.ClickOnReserve();
     FP.fn_verifyReservation();
    Reporter.log("Single Reservation page verified and Reserved.", true);
     
	
	
}
catch(Exception e){
throw e;
}
}

@Test(priority=12)
public void TC_37_38() throws Exception{
	try{
		 sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		 ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
		 iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		 FrontdeskLoginPage AL=new FrontdeskLoginPage();
	     AL.FrontDeskLogin(iTestCaseRow);
	     FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
		 Thread.sleep(2000);
		 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		 Thread.sleep(2000);
		 FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		 Thread.sleep(2000);
	     FP.fn_ClickCancelButton();
	     GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
		 String cwid=GenericMethods.GetCurrentWindowID();
		 BasePage AH= FP.fn_NavigateAdmineConsole();
		 GenericMethods.windowHandle(cwid);
		 RoomsLandingPage  RLP=AH.roomsPageNavigate();
		 AddRoomsPage ARP= RLP.click_AddRoom();
	     ARP.saveAndDuplicate();
	     GenericMethods.Switch_Parent_Window(cwid);
		 GenericMethods.driver.navigate().refresh();
		 Thread.sleep(2000);
	     FP.fn_ClickCancelButton();
	     FP.fn_clickCurrentLnk();
	     
	     AddQuickReservationForm AQRP  =FP.DragAndDropFor1N(ARP.rtype);
	    GroupReservationPage GRP= AQRP.FillQuickResvsForm(iTestCaseRow,AQRP.Link_GroupRes);
	     Thread.sleep(2000);
	     Assert.assertEquals(GenericMethods.getText(GRP.title_GroupResPage).trim(),  ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
	     FP=GRP.ClickOnReserve();
	     FP.fn_verifyReservation();
	     Reporter.log("Group Reservation page verified and Reserved.", true);
}
catch(Exception e){
throw e;
}	
}





@Test(priority=13)
public void TC_37_1_39() throws Exception{
	try{
		 sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		 ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
		 iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		 FrontdeskLoginPage AL=new FrontdeskLoginPage();
	     AL.FrontDeskLogin(iTestCaseRow);
	     FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
		 Thread.sleep(2000);
		 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		 Thread.sleep(2000);
		 FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		 Thread.sleep(2000);
	     FP.fn_ClickCancelButton();
	     GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
		 String cwid=GenericMethods.GetCurrentWindowID();
		 BasePage AH= FP.fn_NavigateAdmineConsole();
		 GenericMethods.windowHandle(cwid);
		 RoomsLandingPage  RLP=AH.roomsPageNavigate();
		 AddRoomsPage ARP= RLP.click_AddRoom();
	     ARP.saveAndDuplicate();
	     GenericMethods.Switch_Parent_Window(cwid);
		 GenericMethods.driver.navigate().refresh();
		 Thread.sleep(2000);
	     FP.fn_ClickCancelButton();
	     FP.fn_clickCurrentLnk();
	    
	     AddQuickReservationForm AQRP  =FP.DragAndDropFor1N(ARP.rtype);
	     GroupReservationPage GRP= AQRP.FillQuickResvsForm(iTestCaseRow,AQRP.Link_AgentCorporate);
	     Thread.sleep(2000);
	     Assert.assertEquals(GenericMethods.getText(GRP.title_GroupResPage).trim(),  ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
	     FP=GRP.ClickOnReserve();
	     FP.fn_verifyReservation();
	     Reporter.log("Group Reservation page verified and Reserved.", true);
}
catch(Exception e){
throw e;
}
}



@Test(priority=14)
public void TC_40() throws Exception{
try{
	 sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	 ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
	 iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	 FrontdeskLoginPage AL=new FrontdeskLoginPage();
     AL.FrontDeskLogin(iTestCaseRow);
     FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	 Thread.sleep(2000);
	 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	 Thread.sleep(4000);
	 FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	 Thread.sleep(2000);
     FP.fn_ClickCancelButton();
     GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
	 String cwid=GenericMethods.GetCurrentWindowID();
	 BasePage AH= FP.fn_NavigateAdmineConsole();
	 GenericMethods.windowHandle(cwid);
	 RoomsLandingPage  RLP=AH.roomsPageNavigate();
	 AddRoomsPage ARP= RLP.click_AddRoom();
     ARP.addRoomName();
    GenericMethods.Switch_Parent_Window(cwid);
	 GenericMethods.driver.navigate().refresh();
	 Thread.sleep(2000);
    FP.fn_ClickCancelButton();
    FP.fn_clickCurrentLnk();
    
    AddQuickReservationForm AQRP  =FP.DragAndDropFor3N(ARP.rtype);
    FP=AQRP.FillQuickResForm(iTestCaseRow);
    Thread.sleep(2000);
    FP.fn_verifyReservation();
    Reporter.log("Single Reervation for 3 nights on Seasionals rate Verified and reservation is Reserved.", true);
	
		
}
catch(Exception e){
throw e;
}
}


	
@Test(priority=15)
public void TC_41() throws Exception{
try{
		 sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		 ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
		 iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		 FrontdeskLoginPage AL=new FrontdeskLoginPage();
	     AL.FrontDeskLogin(iTestCaseRow);
	     FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
		 Thread.sleep(2000);
		 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		 Thread.sleep(2000);
		 FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		 Thread.sleep(2000);
	     FP.fn_ClickCancelButton();
	     GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
		 String cwid=GenericMethods.GetCurrentWindowID();
		 BasePage BP= FP.fn_NavigateAdmineConsole();
		 GenericMethods.windowHandle(cwid);
		 RoomsLandingPage  RLP=BP.roomsPageNavigate();
		 AddRoomsPage ARP= RLP.click_AddRoom();
		 RLP= ARP.addRoomName();
		 BP=RLP.ClickOnLogo();
		 ListOfPackagesFrontdesk  FPL= BP.fn_navigateFrontDskPkg();
		 boolean res= FPL.VerifyPackage(iTestCaseRow);
		 FPL.CreatePackageAndAttachToFD(iTestCaseRow, res);
		 String ti= GenericMethods.driver.getTitle();
		 GenericMethods.Switch_Parent_Window(cwid);
		 Thread.sleep(2000);
		 GenericMethods.driver.navigate().refresh();
		 Thread.sleep(2000);
	     FP.fn_ClickCancelButton();
	     FP.fn_clickCurrentLnk();
	     AddQuickReservationForm AQRP  =FP.DragAndDropFor1N(ARP.rtype);
	     String selPak=AQRP.GetSelectedPackage(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PakageName)));
	     String pkgPrice= AQRP.GetPrice();
	     AQRP.FillQuickResvsFormBySelectingPak(iTestCaseRow,selPak);
	     Thread.sleep(2000);
	     GenericMethods.switchToWindowHandle(ti);
	     FrontDeskPackageDetailPage FDP=FPL.clickOnPakEditlink(selPak);
	     String rate=FDP.getPerNightPrice(ARP.rtype);
	     Assert.assertEquals(rate.trim(), pkgPrice.trim());
	     Reporter.log("Pakage Rate verify in the reservation", true);
}
catch(Exception e){
throw e;
}
}




@Test(priority=16)
public void TC_42_43_44_45_46_47() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
FrontdeskLoginPage AL=new FrontdeskLoginPage();
AL.FrontDeskLogin(iTestCaseRow);
FrontdeskContinueTrialPage FCT=new FrontdeskContinueTrialPage();
Thread.sleep(2000);
CashCounterPage CCP=FCT.fn_ClickCountinueWithTrail_BT();
Thread.sleep(2000);
FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
Thread.sleep(2000);
FP.fn_ClickCancelButton();
GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
String cwid=GenericMethods.GetCurrentWindowID();
BasePage BP= FP.fn_NavigateAdmineConsole();
GenericMethods.windowHandle(cwid);
RoomsLandingPage  RLP=BP.roomsPageNavigate();
AddRoomsPage ARP= RLP.click_AddRoom();
RLP= ARP.addRoomName();
GenericMethods.Switch_Parent_Window(cwid);
GenericMethods.driver.navigate().refresh();
Thread.sleep(2000);
FP.fn_ClickCancelButton();
FP.fn_clickCurrentLnk();

AddQuickReservationForm AQRP  =FP.DragAndDropFor1N(ARP.rtype);
FP=AQRP.FillQuickResForm(iTestCaseRow);
FP.fn_verifyResFromDetailPage();
ViewDetailsPage VDP=FP.ClickOnViewlink();
String resId=VDP.GetResveration();
EnableEditingPage  EEP=VDP.ClickOnEnableEditing();
FP=EEP.CheckInSingleRes();
ReservationSearchResultLandingPage  RSR=FP.fn_SearchReservationID(resId);
VDP=RSR.fn_ClickOnSearchedRecord();
String resRoom=VDP.getRoomNum();
String tit=GenericMethods.driver.getTitle();
SampleRestaurantPage  SRP=VDP.ClickOnRestaurant();
Thread.sleep(2000);
GenericMethods.switchToWindowHandle("Sample Restaurant");
Thread.sleep(3000);
Assert.assertEquals(GenericMethods.driver.getTitle().trim(),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
Thread.sleep(2000);
OrderFromNewTab OFT=SRP.ClickOnNewTab();
Thread.sleep(2000);
Assert.assertEquals(GenericMethods.getText(OFT.Txt_OrderTab).trim(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
String addedProd=OFT.fn_addProduct();
OrderFolioPage  OFP=OFT.fn_transferOrderToRoom(resRoom);
System.out.println(OFT.guestName);
System.out.println(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Salutation))+" "+AQRP.fname+" "+AQRP.lname);
Assert.assertEquals(OFT.guestName.equalsIgnoreCase(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Salutation))+" "+AQRP.fname+" "+AQRP.lname),true);
TransactionListPage  TSL=OFP.fn_getFolioAndCloseTransaction();
String fnum=TSL.getFolioNumber(OFP.FNum);
Assert.assertTrue(fnum.equals(OFP.FNum));
GenericMethods.switchToWindowHandle(tit);
Thread.sleep(2000);
AccountStatementLandingPage  ASL=VDP.ClickToPayment();
String bRate=GenericMethods.getText(ASL.Txt_BookingTotal).trim();
ASL.fn_consolidateAccount("Accept");
Thread.sleep(2000);
String bRate1=GenericMethods.getText(ASL.Txt_BookingTotal).trim();
Thread.sleep(2000);
Assert.assertEquals(bRate, bRate1);
Reporter.log("Reservation made and pos transfer to room and booking total remains unchanged after consolidation", true);
}
catch(Exception e){
		throw e;
}
}



@Test(priority=17)
public void TC_48_49_51() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	FrontdeskLoginPage AL=new FrontdeskLoginPage();
	AL.FrontDeskLogin(iTestCaseRow);
	FrontdeskContinueTrialPage FCT=new FrontdeskContinueTrialPage();
	Thread.sleep(2000);
	CashCounterPage CCP=FCT.fn_ClickCountinueWithTrail_BT();
	Thread.sleep(2000);
	FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
	String cwid=GenericMethods.GetCurrentWindowID();
	BasePage BP= FP.fn_NavigateAdmineConsole();
	GenericMethods.windowHandle(cwid);
	RoomsLandingPage  RLP=BP.roomsPageNavigate();
	AddRoomsPage ARP= RLP.click_AddRoom();
	RLP= ARP.addRoomName();
	GenericMethods.Switch_Parent_Window(cwid);
	GenericMethods.driver.navigate().refresh();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	FP.fn_clickCurrentLnk();

	AddQuickReservationForm AQRP  =FP.DragAndDropFor1N(ARP.rtype);
	String Rackprice=AQRP.GetPrice();
	Thread.sleep(2000);
	Assert.assertEquals(AQRP.getAddQuickResTitle(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)).trim());
	Thread.sleep(2000);
	FP=AQRP.FillQuickResForm(iTestCaseRow);
	Thread.sleep(2000);
	FP.fn_verifyResFromDetailPage();
	ViewDetailsPage VDP=FP.ClickOnViewlink();
	String resId=VDP.GetResveration();
	EnableEditingPage EEP=VDP.ClickOnEnableEditing();
	GenericMethods.clickElement(EEP.Link_InclusionAddOns);
	EEP.fn_setAddOnsToReservation();
	System.out.println(EEP.text);
	System.out.println(GenericMethods.getText(EEP.Txt_AddedAddon));
	Thread.sleep(2000);
	Assert.assertEquals(EEP.text.trim(), GenericMethods.getText(EEP.Txt_AddedAddon).trim());
	Reporter.log("Reservation has been made and addons added", true);
}
catch(Exception e){
	throw e;	
}
	
}

@Test(priority=18)
public void TC_50() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
FrontdeskLoginPage AL=new FrontdeskLoginPage();
AL.FrontDeskLogin(iTestCaseRow);
FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
Thread.sleep(2000);
CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
Thread.sleep(2000);
FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
Thread.sleep(2000);
FP.fn_ClickCancelButton();
GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
String cwid=GenericMethods.GetCurrentWindowID();
BasePage BP= FP.fn_NavigateAdmineConsole();
GenericMethods.windowHandle(cwid);
RoomsLandingPage  RLP=BP.roomsPageNavigate();
AddRoomsPage ARP= RLP.click_AddRoom();
RLP= ARP.saveAndDuplicate();
BP=RLP.ClickOnLogo();
ListOfPackagesFrontdesk  FPL= BP.fn_navigateFrontDskPkg();
boolean res= FPL.VerifyPackage(iTestCaseRow);
FPL.CreateAndAttachPackageToFD(iTestCaseRow, res);
String ti= GenericMethods.driver.getTitle();
GenericMethods.Switch_Parent_Window(cwid);
Thread.sleep(2000);
GenericMethods.driver.navigate().refresh();
Thread.sleep(2000);
FP.fn_ClickCancelButton();
FP.fn_clickCurrentLnk();

AddQuickReservationForm AQRP  =FP.DragAndDropFor2N(ARP.rtype);
String selPak=AQRP.GetSelectedPackage(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PakageName)));
String pkgPrice= AQRP.GetPrice();
  FP=AQRP.FillQuickResvsFormBySelectingPak(iTestCaseRow,selPak);
FP.fn_verifyReservation();
Reporter.log("Reservation made over Inclusive rate of package.", true);
	
}
catch(Exception e){
	throw e;
	
}
}

@Test(priority=19)
public void TC_55_56_57_58_59_60() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	FrontdeskLoginPage AL=new FrontdeskLoginPage();
	AL.FrontDeskLogin(iTestCaseRow);
	FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	Thread.sleep(2000);
	CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	Thread.sleep(2000);
	FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
	String cwid=GenericMethods.GetCurrentWindowID();
	BasePage BP= FP.fn_NavigateAdmineConsole();
	GenericMethods.windowHandle(cwid);
	RoomsLandingPage  RLP=BP.roomsPageNavigate();
	AddRoomsPage ARP= RLP.click_AddRoom();
	RLP= ARP.addRoomName(); 
	GenericMethods.Switch_Parent_Window(cwid);
	Thread.sleep(2000);
	GenericMethods.driver.navigate().refresh();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	FP.fn_clickCurrentLnk();
	Thread.sleep(3000);
	FP.WindowScroll();
	Thread.sleep(3000);
	AddQuickReservationForm AQRP  =FP.DragAndDropFor2N(ARP.rtype);
 FP=AQRP.FillQuickResForm(iTestCaseRow);
	FP.fn_verifyReservation();
	String tit=GenericMethods.GetTitle();
	FP.fn_rightClickOnReservation(FP.getWebElement(FP.resvId));
	GenericMethods.clickElement(FP.rightClk_CheckIN);
	Thread.sleep(2000);
	
	GenericMethods.ActionOnAlert("Accept");
	Thread.sleep(2000);
	GenericMethods.switchToWindowHandle("Room Reservation Check In");
	Thread.sleep(3000); 
    System.out.println(GenericMethods.GetTitle() +"Title here");
	Assert.assertEquals(GenericMethods.GetTitle().trim(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
	GenericMethods.switchToWindowHandle(tit);
	String resStat=GenericMethods.GetWebElementAttributeValue(FP.getWebElement(FrontdeskLandingPage.resvId),"rsvstatus");
	Thread.sleep(2000);
	Assert.assertEquals(resStat, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
	FP.fn_rightClickOnReservation(FP.getWebElement(FrontdeskLandingPage.resvId));
	GenericMethods.clickElement(FP.rightClk_CancelCheckIN);
    GenericMethods.ActionOnAlert("Accept");
    Assert.assertEquals(GenericMethods.value.trim(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult3)));
	Thread.sleep(2000);
	String resStat1=GenericMethods.GetWebElementAttributeValue(FP.getWebElement(FrontdeskLandingPage.resvId),"rsvstatus");
	Thread.sleep(3000);
	Assert.assertEquals(resStat1, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult4)));
	Thread.sleep(2000);
	FP.fn_rightClickOnReservation(FP.getWebElement(FrontdeskLandingPage.resvId));
	Thread.sleep(2000);
	GenericMethods.clickElement(FP.rightClk_CheckIN);
	Reporter.log("Reservation made and checkin too.", true);
	GenericMethods.ActionOnAlert("Accept");
	Thread.sleep(2000);
	GenericMethods.switchToWindowHandle("Room Reservation Check In");
	Thread.sleep(2000);
	Assert.assertEquals(GenericMethods.GetTitle().trim(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
	GenericMethods.switchToWindowHandle(tit);
	String resStat2=GenericMethods.GetWebElementAttributeValue(FP.getWebElement(FrontdeskLandingPage.resvId),"rsvstatus");
	Thread.sleep(2000);
	Assert.assertEquals(resStat2, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
	}
catch(Exception e){
throw e;	
}
}



@Test(priority=20)
public void Tc_52_53_54() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	FrontdeskLoginPage AL=new FrontdeskLoginPage();
	AL.FrontDeskLogin(iTestCaseRow);
	FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	Thread.sleep(2000);
	CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	Thread.sleep(2000);
	FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
	String cwid=GenericMethods.GetCurrentWindowID();
	BasePage BP= FP.fn_NavigateAdmineConsole();
	GenericMethods.windowHandle(cwid);
	RoomsLandingPage  RLP=BP.roomsPageNavigate();
	AddRoomsPage ARP= RLP.click_AddRoom();
	RLP= ARP.addRoomName(); 
	GenericMethods.Switch_Parent_Window(cwid);
	Thread.sleep(2000);
	GenericMethods.driver.navigate().refresh();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	FP.fn_clickCurrentLnk();
	Thread.sleep(2000);
	

	AddQuickReservationForm AQRP  =FP.DragAndDropFor2N(ARP.rtype);
	String tprice=AQRP.GetTotalPrice();
	String perNprice=AQRP.GetPrice().trim();
	System.out.println(perNprice);
	  FP=AQRP.FillQuickResForm(iTestCaseRow);
	a1.add(AQRP.fname);
	a1.add(AQRP.lname);
	 FP.fn_verifyReservation();
	WebElement ele=FP.getWebElement(FrontdeskLandingPage.resvId);
	GenericMethods.clickElement(ele);
	ViewDetailsPage VDP=FP.ClickOnViewlink();
	EnableEditingPage EEP=VDP.ClickOnEnableEditing();
	EEP.ClickOnAddEditDetails();
	ArrayList<String> a2=EEP.getDetails();
	Thread.sleep(2000);
	Assert.assertTrue(a2.get(0).toString().equalsIgnoreCase(a1.get(0).toString()));
	Assert.assertTrue(a2.get(1).toString().equalsIgnoreCase(a1.get(1).toString()));
	ArrayList<String> a3=EEP.setDetails();
	Thread.sleep(2000);
	FP=EEP.ClickOnSaveBtnOverEnableEditing();
	GenericMethods.clickElement(ele);
	VDP=FP.ClickOnViewlink();
	EEP=VDP.ClickOnEnableEditing();
	EEP.ClickOnAddEditDetails();
	ArrayList<String> a4=EEP.getDetails();
	Thread.sleep(2000);
	Assert.assertTrue(a4.get(0).toString().equalsIgnoreCase(a3.get(2).toString()));
	Thread.sleep(2000);
	Assert.assertTrue(a4.get(1).toString().equalsIgnoreCase(a3.get(3).toString()));
	Reporter.log("Save details are verified", true);
	GenericMethods.clickElement(EEP.BtnguestInfo_Save);
	EEP.splitBookingDays();
	EEP.verifySplittedPrice(perNprice);
	Reporter.log("splited days price verified", true);
}
catch(Exception e){
throw e;
}
}
*/
	
	
	
	
@Test(priority=21)
public void TC_61_62_63() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	FrontdeskLoginPage AL=new FrontdeskLoginPage();
	AL.FrontDeskLogin(iTestCaseRow);
	FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	Thread.sleep(2000);
	CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	Thread.sleep(2000);
	FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
	String cwid=GenericMethods.GetCurrentWindowID();
	BasePage BP= FP.fn_NavigateAdmineConsole();
	GenericMethods.windowHandle(cwid);
	RoomsLandingPage  RLP=BP.roomsPageNavigate();
	AddRoomsPage ARP= RLP.click_AddRoom();
	RLP= ARP.addRoomName(); 
	GenericMethods.Switch_Parent_Window(cwid);
	Thread.sleep(2000);
	GenericMethods.driver.navigate().refresh();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	FP.fn_clickCurrentLnk();
	Thread.sleep(2000);


	AddQuickReservationForm AQRP  =FP.DragAndDropFor2N(ARP.rtype);
	AQRP.GetTotalPrice();
	String perNprice=AQRP.GetPrice().trim();
	System.out.println(perNprice);
	 FP=AQRP.FillQuickResForm(iTestCaseRow);
	String tprice=null;
    FP.fn_verifyReservation();
	WebElement ele=FP.getWebElement(FrontdeskLandingPage.resvId);
	GenericMethods.clickElement(ele);
	ViewDetailsPage VDP=FP.ClickOnViewlink();
	EnableEditingPage EEP=VDP.ClickOnEnableEditing();
	EEP.giveDiscount(iTestCaseRow);
	Reporter.log("Discount is given to the guest and verified", true);
	}
catch(Exception e){
	throw e;
}
}




@Test(priority=22)
public void TC_71_72_73_74_75_76_77_78() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	FrontdeskLoginPage AL=new FrontdeskLoginPage();
	AL.FrontDeskLogin(iTestCaseRow);
	FrontdeskContinueTrialPage FCT=new FrontdeskContinueTrialPage();
	Thread.sleep(2000);
	CashCounterPage CCP=FCT.fn_ClickCountinueWithTrail_BT();
	Thread.sleep(2000);
	FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
	String cwid=GenericMethods.GetCurrentWindowID();
	BasePage BP= FP.fn_NavigateAdmineConsole();
	GenericMethods.windowHandle(cwid);
	RoomsLandingPage  RLP=BP.roomsPageNavigate();
	AddRoomsPage ARP= RLP.click_AddRoom();
	RLP= ARP.addRoomName();
	GenericMethods.Switch_Parent_Window(cwid);
	GenericMethods.driver.navigate().refresh();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	FP.fn_clickCurrentLnk();

	AddQuickReservationForm AQRP  =FP.DragAndDropFor1N(ARP.rtype);
	FP=AQRP.FillQuickResForm(iTestCaseRow);
	FP.fn_verifyResFromDetailPage();
	ViewDetailsPage VDP=FP.ClickOnViewlink();
	String resId=VDP.GetResveration();
	EnableEditingPage  EEP=VDP.ClickOnEnableEditing();
	FP=EEP.CheckInSingleRes();
	ReservationSearchResultLandingPage  RSR=FP.fn_SearchReservationID(resId);
	VDP=RSR.fn_ClickOnSearchedRecord();
	String resRoom=VDP.getRoomNum();
	String tit=GenericMethods.driver.getTitle();
	SampleRestaurantPage  SRP=VDP.ClickOnRestaurant();
	Thread.sleep(3000);
	GenericMethods.switchToWindowHandle("Sample Restaurant");
	Thread.sleep(2000);
	Assert.assertEquals(GenericMethods.driver.getTitle().trim(),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
	Thread.sleep(2000);
	ConfirmOrderPage COP=SRP.generateOrder();
	Thread.sleep(2000);
	String orderTabText=GenericMethods.getText(COP.Text_OrderTab).trim();
	Thread.sleep(2000);
	Assert.assertEquals(orderTabText, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
	OrderFolioPage  OFP=COP.fn_transferOrderToRoom(resRoom);
	Thread.sleep(2000);
	TransactionListPage TLP=OFP.fn_getFolioAndCloseTransaction();
	Thread.sleep(2000);
	String fnum=TLP.getFolioNumber(OFP.FNum).trim();
	System.out.println(fnum);
	Thread.sleep(2000);
	GenericMethods.switchToWindowHandle("Frontdesk");
	AccountStatementLandingPage  ASL=VDP.ClickToPayment();
	Thread.sleep(2000);
	Assert.assertEquals(GenericMethods.getText(ASL.Text_AccountStatement).trim(), "ACCOUNT STATEMENT");
	ASL.fn_consolidateAccount("Accept");
	Thread.sleep(2000);
	Assert.assertEquals(GenericMethods.value, ASL.exp_msg);
	Thread.sleep(2000);
	ASL.getFolioNumberfromAccountNumber(fnum);
	Thread.sleep(2000);
	Reporter.log("Folio verified", true);
	Reporter.log("Reservation made and pos transfer to room and booking total remains unchanged after consolidation", true);
}
catch(Exception e){
	throw e;
}
}

@Test(priority=23)
public void TC_79() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	FrontdeskLoginPage AL=new FrontdeskLoginPage();
	AL.FrontDeskLogin(iTestCaseRow);
	FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	Thread.sleep(2000);
	CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	Thread.sleep(2000);
	FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
	String cwid=GenericMethods.GetCurrentWindowID();
	BasePage BP= FP.fn_NavigateAdmineConsole();
	GenericMethods.windowHandle(cwid);
	RoomsLandingPage  RLP=BP.roomsPageNavigate();
	AddRoomsPage ARP= RLP.click_AddRoom();
	RLP= ARP.addRoomName(); 
	GenericMethods.Switch_Parent_Window(cwid);
	Thread.sleep(2000);
	GenericMethods.driver.navigate().refresh();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	FP.fn_clickCurrentLnk();
	Thread.sleep(3000);
	AddQuickReservationForm AQRP  =FP.DragAndDropFor2N(ARP.rtype);
	AQRP.GetTotalPrice();
	String perNprice=AQRP.GetPrice().trim();
	System.out.println(perNprice);
	 FP=AQRP.FillQuickResForm(iTestCaseRow);
	FP.fn_verifyReservation();
	WebElement ele=FP.getWebElement(FrontdeskLandingPage.resvId);
	GenericMethods.clickElement(ele);
	FP.getRateFromViewPane();
	ViewDetailsPage VDP=FP.ClickOnViewlink();
	
	
	String resId=VDP.GetResveration();
	EnableEditingPage  EEP=VDP.ClickOnEnableEditing();
	FP=EEP.CheckInSingleRes();
	ReservationSearchResultLandingPage  RSR=FP.fn_SearchReservationID(resId);
	VDP=RSR.fn_ClickOnSearchedRecord();
	String resRoom=VDP.getRoomNum();
	String tit=GenericMethods.driver.getTitle();
	
	SampleRestaurantPage  SRP=VDP.ClickOnRestaurant();
	Thread.sleep(2000);
	GenericMethods.switchToWindowHandle("Sample Restaurant");
	ConfirmOrderPage COP=SRP.generateOrder();
	Thread.sleep(2000);

	OrderFolioPage  OFP=COP.fn_transferOrderToRoom(resRoom);
	Thread.sleep(2000);
	TransactionListPage TLP=OFP.fn_getFolioAndCloseTransaction();
	Thread.sleep(2000);
	String fnum=TLP.getFolioNumber(OFP.FNum).trim();
	System.out.println(fnum);
	Thread.sleep(2000);
	GenericMethods.switchToWindowHandle("Frontdesk");
	AccountStatementLandingPage  ASL=VDP.ClickToPayment();
	Thread.sleep(2000);
    ASL.fn_consolidateAccount("Accept");
	Thread.sleep(2000);
	ASL.getFolioNumberfromAccountNumber(fnum);
	Thread.sleep(2000);
	GenericMethods.driver.navigate().refresh();
	//ContinueNightAuditPage  CNA=ASL.ClickOnPerformNightAudit();
	//Thread.sleep(2000);
	//IgnoreCounterNightAuditPage ICNA=CNA.ClickToContinueNightAudit();
	//Thread.sleep(2000);
	//NightAuditSummaryPage  NAS=ICNA.IgnoreCounterForNightAudit();
	//Thread.sleep(2000);
	//FP=NAS.clickOnContinueToWork();
	//FP.fn_ClickCancelButton();
	GenericMethods.clickElement(FP.Btn_AutoNightAudit);
	Thread.sleep(2000);
	FP.fn_clickCurrentLnk();
	Thread.sleep(2000);
	
	WebElement ele1=FP.getWebElement(FrontdeskLandingPage.resvId);
	GenericMethods.clickElement(ele1);
	VDP=FP.ClickOnViewlink();
 ASL=VDP.ClickToPayment();
 ASL.VerifyRoomRateAndTax("Seasonal Rate");
 String roomRate=GenericMethods.ExtractTheRate(ASL.postedRoomPrice);
 System.out.println("Room Rate:" + roomRate);
 String roomTax=GenericMethods.ExtractTheRate(ASL.postedRoomTax);
 System.out.println("Room TAx: "+ roomTax);
 System.out.println(AQRP.chargePerNight+ "per nyt from AQRP");
 Assert.assertEquals(Float.parseFloat(roomRate), AQRP.chargePerNight, 0.0f);
 float tax=(FP.TotalCharge-AQRP.TotalCharge)/2;
System.out.println("system calculated tax" +tax );
Assert.assertEquals(Float.parseFloat(roomTax), tax, 0.0f);
Reporter.log("Night audit performed",true);
	
	
	}
catch(Exception e){
throw e;
}
}


@Test(priority=24)
public void TC_80_81_82_83() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	FrontdeskLoginPage AL=new FrontdeskLoginPage();
	AL.FrontDeskLogin(iTestCaseRow);
	FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	Thread.sleep(2000);
	CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	Thread.sleep(2000);
	FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
	String cwid=GenericMethods.GetCurrentWindowID();
	BasePage BP= FP.fn_NavigateAdmineConsole();
	GenericMethods.windowHandle(cwid);
	RoomsLandingPage  RLP=BP.roomsPageNavigate();
	AddRoomsPage ARP= RLP.click_AddRoom();
	RLP= ARP.addRoomName(); 
	GenericMethods.Switch_Parent_Window(cwid);
	Thread.sleep(2000);
	GenericMethods.driver.navigate().refresh();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	FP.fn_clickCurrentLnk();
	Thread.sleep(2000);
	AddQuickReservationForm AQRP  =FP.DragAndDropFor2N(ARP.rtype);
	AQRP.GetTotalPrice();
	String perNprice=AQRP.GetPrice().trim();
	System.out.println(perNprice);
	  FP=AQRP.FillQuickResForm(iTestCaseRow);
	FP.fn_verifyReservation();
	Thread.sleep(2000);
	WebElement ele=FP.getWebElement(FrontdeskLandingPage.resvId);
	GenericMethods.clickElement(ele);
	FP.getRateFromViewPane();
	ViewDetailsPage VDP=FP.ClickOnViewlink();
	String resId=VDP.GetResveration();
	EnableEditingPage  EEP=VDP.ClickOnEnableEditing();
	FP=EEP.CheckInSingleRes();
	ReservationSearchResultLandingPage  RSR=FP.fn_SearchReservationID(resId);
	VDP=RSR.fn_ClickOnSearchedRecord();
	String resRoom=VDP.getRoomNum();
	String tit=GenericMethods.driver.getTitle();
	SampleRestaurantPage  SRP=VDP.ClickOnRestaurant();
	Thread.sleep(2000);
	GenericMethods.switchToWindowHandle("Sample Restaurant");
	ConfirmOrderPage COP=SRP.generateOrder();
	Thread.sleep(2000);
    OrderFolioPage  OFP=COP.fn_transferOrderToRoom(resRoom);
	Thread.sleep(2000);
	TransactionListPage TLP=OFP.fn_getFolioAndCloseTransaction();
	Thread.sleep(2000);
	String fnum=TLP.getFolioNumber(OFP.FNum).trim();
	System.out.println(fnum);
	Thread.sleep(2000);
	GenericMethods.switchToWindowHandle("Frontdesk");
	AccountStatementLandingPage  ASL=VDP.ClickToPayment();
	Thread.sleep(2000);
    ASL.fn_consolidateAccount("Accept");
	Thread.sleep(2000);
	ASL.getFolioNumberfromAccountNumber(fnum);
	Reporter.log("Consolidate account successfully", true);
	
}
catch(Exception e){
	throw e;
}
}

@Test(priority=25)
public void TC_84_85_86_87() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	FrontdeskLoginPage AL=new FrontdeskLoginPage();
	AL.FrontDeskLogin(iTestCaseRow);
	FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	Thread.sleep(2000);
	CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	Thread.sleep(2000);
	FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
	String cwid=GenericMethods.GetCurrentWindowID();
	BasePage BP= FP.fn_NavigateAdmineConsole();
	GenericMethods.windowHandle(cwid);
	RoomsLandingPage  RLP=BP.roomsPageNavigate();
	AddRoomsPage ARP= RLP.click_AddRoom();
	RLP= ARP.addRoomName(); 
	GenericMethods.Switch_Parent_Window(cwid);
	Thread.sleep(2000);
	GenericMethods.driver.navigate().refresh();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	FP.fn_clickCurrentLnk();
	Thread.sleep(3000);
	AddQuickReservationForm AQRP  =FP.DragAndDropFor1N(ARP.rtype);
FP=AQRP.FillQuickResForm(iTestCaseRow);
	FP.fn_verifyReservation();
	Thread.sleep(2000);
	WebElement ele=FP.getWebElement(FrontdeskLandingPage.resvId);
	Thread.sleep(2000);
	FP.fn_rightClickOnReservation(ele);
	FP.fn_clkCheckin(ele);
	Thread.sleep(2000);
	WebElement ele1=FP.getWebElement(FrontdeskLandingPage.resvId);
	Thread.sleep(2000);
	FP.fn_rightClickOnReservation(ele1);
	AccountStatementLandingPage ASL=FP.ClickOnPayment();
	GenericMethods.clickElement(ASL.Btn_CustomChargeBtn);
	Assert.assertEquals(GenericMethods.getText(ASL.Header_CustomChargeAllowance).trim(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
	Reporter.log("Custom charge Allowances header verified", true);
	ASL.fn_addCustomCharges(iTestCaseRow);
	Thread.sleep(10000);
	String item=ASL.VerifyPostedCustomCharge(iTestCaseRow);
	Assert.assertEquals(item.trim(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Description)));
	Reporter.log("Posted cutom charge verified at account statement", true);
	GenericMethods.clickElement(ASL.Btn_OtherCharges);
	 Thread.sleep(2000);
	Assert.assertEquals(GenericMethods.getText(ASL.Header_OtherCharges).trim(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
    ASL.AddOtherCharge(iTestCaseRow);	
    Thread.sleep(2000);
    String itemOtherCharge=ASL.VerifyOtherCharges(ASL.selProduct);
    Thread.sleep(2000);
    System.out.println(itemOtherCharge);
    System.out.println(ASL.selProduct);
    Assert.assertEquals(itemOtherCharge.trim(), ASL.selProduct.trim());
    Reporter.log("Other charges posted and verify to Account statement ", true);
}
catch(Exception e){
throw e;
}
}



@Test(priority=26)
public void TC_88_89_90() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	FrontdeskLoginPage AL=new FrontdeskLoginPage();
	AL.FrontDeskLogin(iTestCaseRow);
	FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	Thread.sleep(2000);
	CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	Thread.sleep(2000);
	FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
	String cwid=GenericMethods.GetCurrentWindowID();
	BasePage BP= FP.fn_NavigateAdmineConsole();
	GenericMethods.windowHandle(cwid);
	RoomsLandingPage  RLP=BP.roomsPageNavigate();
	AddRoomsPage ARP= RLP.click_AddRoom();
	RLP= ARP.addRoomName(); 
	GenericMethods.Switch_Parent_Window(cwid);
	Thread.sleep(2000);
	GenericMethods.driver.navigate().refresh();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	FP.fn_clickCurrentLnk();
	Thread.sleep(3000);
	AddQuickReservationForm AQRP  =FP.DragAndDropFor1N(ARP.rtype);
	FP=AQRP.FillQuickResForm(iTestCaseRow);
	FP.fn_verifyReservation();
	Thread.sleep(2000);
	WebElement ele=FP.getWebElement(FrontdeskLandingPage.resvId);
	Thread.sleep(2000);
	FP.fn_rightClickOnReservation(ele);
	FP.fn_clkCheckin(ele);
	Thread.sleep(2000);
	WebElement ele1=FP.getWebElement(FrontdeskLandingPage.resvId);
	Thread.sleep(2000);
	FP.fn_rightClickOnReservation(ele1);
	Thread.sleep(2000);
	AccountStatementLandingPage ASL=FP.ClickOnPayment();
	GenericMethods.clickElement(ASL.Btn_OtherCharges);
	ASL.AddOtherCharge(iTestCaseRow);	
    Thread.sleep(2000);
    GenericMethods.clickElement(ASL.Btn_GenerateFolio);
    Assert.assertEquals(ASL.Link_ToPerfomaInvoice.isDisplayed(),true);
    GenericMethods.clickElement(ASL.CB_PI);
    GenericMethods.clickElement(ASL.Btn_DeletePerfomaInvoice);
    GenericMethods.ActionOnAlert("Accept");
    Thread.sleep(2000);
    Assert.assertEquals(GenericMethods.value.trim(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
    Thread.sleep(2000);
    Assert.assertEquals(ASL.Text_NoFolioExist.isDisplayed(),true);
    Reporter.log("Folio created and deleted successfully", true);
}
catch(Exception e){
	throw e;
}
} 

	
@Test(priority=27)
public void TC_92_93_94_95_96_97() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	FrontdeskLoginPage AL=new FrontdeskLoginPage();
	AL.FrontDeskLogin(iTestCaseRow);
	FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	Thread.sleep(2000);
	CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	Thread.sleep(2000);
	FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
	String cwid=GenericMethods.GetCurrentWindowID();
	BasePage BP= FP.fn_NavigateAdmineConsole();
	GenericMethods.windowHandle(cwid);
	RoomsLandingPage  RLP=BP.roomsPageNavigate();
	AddRoomsPage ARP= RLP.click_AddRoom();
	RLP= ARP.addRoomName(); 
	GenericMethods.Switch_Parent_Window(cwid);
	Thread.sleep(2000);
	GenericMethods.driver.navigate().refresh();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	FP.fn_clickCurrentLnk();
	Thread.sleep(3000);
	AddQuickReservationForm AQRP  =FP.DragAndDropFor1N(ARP.rtype);
	  FP=AQRP.FillQuickResForm(iTestCaseRow);
	FP.fn_verifyReservation();
	Thread.sleep(2000);
	WebElement ele=FP.getWebElement(FrontdeskLandingPage.resvId);
	Thread.sleep(2000);
	FP.fn_rightClickOnReservation(ele);
	FP.fn_clkCheckin(ele);
	Thread.sleep(2000);
	WebElement ele1=FP.getWebElement(FrontdeskLandingPage.resvId);
	Thread.sleep(2000);
	FP.fn_rightClickOnReservation(ele1);
	Thread.sleep(2000);
	ViewDetailsPage VDP=FP.ClickOnViewDetailsLink();
	EnableEditingPage  EEP=VDP.ClickToEnableEditingBtn();
	System.out.println("---------------------------YE H RESERVid"+FrontdeskLandingPage.resvId);
	FP=EEP.AddSecondaryGuestDetail();
	System.out.println(FrontdeskLandingPage.resvId);
	GenericMethods.driver.navigate().refresh();
	FP.fn_ClickCancelButton();
	FP.fn_clickCurrentLnk();
    System.out.println(FrontdeskLandingPage.resvId);
    Thread.sleep(2000);
	WebElement ele2=FP.getWebElement(FrontdeskLandingPage.resvId);
	Thread.sleep(2000);
	FP.fn_rightClickOnReservation(ele2);
	AccountStatementLandingPage ASL=FP.ClickOnPayment();
	GenericMethods.clickElement(ASL.Btn_CustomChargeBtn);
	ASL.fn_addCustomCharges(iTestCaseRow);	
    Thread.sleep(2000);
    GenericMethods.clickElement(ASL.Btn_GenerateFolio);
    Thread.sleep(2000);
    GenericMethods.ActionOnAlert("Accept");
    Thread.sleep(2000);
    int size=ASL.CB_GeneratedFolio.size();
    System.out.println(size);
    
    GenericMethods.clickElement(ASL.CB_AccountPostingMasterCB);
    Thread.sleep(2000);
    GenericMethods.clickElement(ASL.Btn_RouteToNewFolio);
    Assert.assertEquals(GenericMethods.getText(ASL.HeaderTxt_CreateNewFolio).trim(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
    Reporter.log("Create new folio pop up header text verified.", true);
    ASL.fn_createNewFolio(1);
    Thread.sleep(2000);
    System.out.println("ACTUAL"+ASL.CB_GeneratedFolio.size());
    System.out.println("EXPECTED"+size+1);
    
    Assert.assertEquals(ASL.CB_GeneratedFolio.size(), size+1);
    float res=ASL.fn_getTotalPostedItemRatefromAccountStatement();
    System.out.println(res);
    GenericMethods.clickElement(ASL.CB_AccountPostingMasterCB);
    GenericMethods.clickElement(ASL.Btn_RouteCharges);
    Assert.assertEquals(GenericMethods.getText(ASL.Header_routeChargesTitle).trim(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
    String guest=ASL.fn_routeCharges(1);
    String pi=ASL.fn_getPI(guest);
    Thread.sleep(2000);
    float rate=ASL.VerifyRoutedCharge(pi);
    Thread.sleep(2000);
    Assert.assertEquals(res, rate, 0.0f);
    Reporter.log("Yeah route charge verified", true);
    ASL.doPayment("Cash");
    ASL.fn_routePayment(iTestCaseRow,0);
    Thread.sleep(10000);
    float rate1=ASL. fn_getTotalAmountfromAccountStatement();
    String pi1= ASL.fn_getPI(ASL.selValue);
    float rate2=ASL.fn_verifyRoutedPayment(pi1);
    Assert.assertTrue(rate1==rate2);
    System.out.println(guest);
   Reporter.log("Route to new folio ,Route charge and Route Payment verified", true);
    
}
catch(Exception e){
throw e;		
}
}


@Test(priority=28)
public void TC_98_99() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	FrontdeskLoginPage AL=new FrontdeskLoginPage();
	AL.FrontDeskLogin(iTestCaseRow);
	FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	Thread.sleep(2000);
	CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	Thread.sleep(2000);
	FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
	String cwid=GenericMethods.GetCurrentWindowID();
	BasePage BP= FP.fn_NavigateAdmineConsole();
	GenericMethods.windowHandle(cwid);
	RoomsLandingPage  RLP=BP.roomsPageNavigate();
	AddRoomsPage ARP= RLP.click_AddRoom();
	RLP= ARP.addRoomName(); 
	GenericMethods.Switch_Parent_Window(cwid);
	Thread.sleep(2000);
	GenericMethods.driver.navigate().refresh();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	FP.fn_clickCurrentLnk();
	Thread.sleep(3000);
	AddQuickReservationForm AQRP  =FP.DragAndDropFor1N(ARP.rtype);
	   FP=AQRP.FillQuickResForm(iTestCaseRow);
	   FP.fn_verifyReservation();
	   WebElement ele=FP.getWebElement(FrontdeskLandingPage.resvId);
		Thread.sleep(2000);
	  FP.fn_rightClickOnReservation(ele);
    FP.fn_clkCheckin(ele);
	Thread.sleep(2000);
	WebElement ele1=FP.getWebElement(FrontdeskLandingPage.resvId);
	Thread.sleep(2000);
	FP.fn_rightClickOnReservation(ele1);
	AccountStatementLandingPage  ASL=FP.ClickOnPayment();
	GenericMethods.clickElement(ASL.Btn_CustomChargeBtn);
	ASL.fn_addCustomCharges(iTestCaseRow);	
	Thread.sleep(2000);
	GenericMethods.clickElement(ASL.CB_AccountPostingMasterCB);
	Thread.sleep(2000);
	GenericMethods.clickElement(ASL.Btn_Refund);
	Assert.assertEquals(GenericMethods.getText(ASL.Header_refundTitle).trim(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)).trim());
	GenericMethods.clickElement(ASL.Btn_innerRefund);
	float p=ASL.fn_getChargeForPostedItem();
	Assert.assertEquals(p, 0.0f, 0.0f);
	Reporter.log("Refund functionality working fine.",true);
}
catch(Exception e){
throw e;
}
}

	
@Test(priority=29)	
public void TC_100_101_102_103_104() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	FrontdeskLoginPage AL=new FrontdeskLoginPage();
	AL.FrontDeskLogin(iTestCaseRow);
	FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	Thread.sleep(2000);
	CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	Thread.sleep(2000);
	FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
	String cwid=GenericMethods.GetCurrentWindowID();
	BasePage BP= FP.fn_NavigateAdmineConsole();
	GenericMethods.windowHandle(cwid);
	RoomsLandingPage  RLP=BP.roomsPageNavigate();
	AddRoomsPage ARP= RLP.click_AddRoom();
	RLP= ARP.addRoomName(); 
	GenericMethods.Switch_Parent_Window(cwid);
	Thread.sleep(2000);
	GenericMethods.driver.navigate().refresh();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	FP.fn_clickCurrentLnk();
	Thread.sleep(3000);
	AddQuickReservationForm AQRP  =FP.DragAndDropFor1N(ARP.rtype);
	  FP=AQRP.FillQuickResForm(iTestCaseRow);
	FP.fn_verifyReservation();
	Thread.sleep(2000);
	WebElement ele=FP.getWebElement(FrontdeskLandingPage.resvId);
	Thread.sleep(2000);
	FP.fn_rightClickOnReservation(ele);
	FP.fn_clkCheckin(ele);
	Thread.sleep(2000);
	GenericMethods.driver.navigate().refresh();
	Thread.sleep(2000);
	GenericMethods.clickElement(FP.Btn_AutoNightAudit);
	Thread.sleep(9000);
	WebElement ele1=FP.getWebElement(FrontdeskLandingPage.resvId);
	FP.fn_rightClickOnReservation(ele1);
	AccountStatementLandingPage  ASL=FP.ClickOnPayment();
	GenericMethods.clickElement(ASL.Btn_GenerateFolio);
	float rate=GenericMethods.fn_getRateFromRateString(ASL.Text_BalanceAmtInAcc.getText());
	ASL.fn_doPaymentUsingCheque(iTestCaseRow);
	Thread.sleep(2000);
	float rate1=GenericMethods.fn_getRateFromRateString(ASL.Text_BalanceAmtInAcc.getText());
	Thread.sleep(2000);
	Thread.sleep(2000);
	Assert.assertNotEquals(rate, rate1, 0.0f);
	Thread.sleep(2000);
	String s=GenericMethods.getText(ASL.Text_BalanceAmtInFolio).trim();
	System.out.println("s is"+ s);
	GenericMethods.clickElement(ASL.Btn_settleFolio);
	GenericMethods.ActionOnAlert("Accept");
	Thread.sleep(2000);
	Assert.assertEquals(GenericMethods.value.trim(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
	Thread.sleep(2000);
	String s1=GenericMethods.getText(ASL.Text_BalanceAmtInFolio).trim();
	System.out.println("s1 is"+ s1);
	Thread.sleep(2000);
	Assert.assertNotEquals(s, s1);
	Thread.sleep(2000);
	String atr=GenericMethods.GetWebElementAttributeValue(ASL.Btn_FolioLock, "class");
	GenericMethods.clickElement(ASL.Btn_FolioLock);
	GenericMethods.ActionOnAlert("Accept");
	Thread.sleep(2000);
	String atr1=GenericMethods.GetWebElementAttributeValue(ASL.Btn_FolioLock, "class").trim();
	Assert.assertNotSame(atr, atr1);
	Thread.sleep(2000);
	Assert.assertEquals(GenericMethods.value, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
	Thread.sleep(2000);
	GenericMethods.clickElement(ASL.Btn_FolioLock);
	String atr2=GenericMethods.GetWebElementAttributeValue(ASL.Btn_FolioLock, "class").trim();
	Thread.sleep(2000);
	Assert.assertEquals(atr2, atr1);
	Reporter.log("Folio creted along with payment done and settlement and unlock not possible for the lock folio", true);
}
catch(Exception e){
throw e;
}
}
 
	
@Test(priority=30)
public void TC_105_106_107() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	FrontdeskLoginPage AL=new FrontdeskLoginPage();
	AL.FrontDeskLogin(iTestCaseRow);
	FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	Thread.sleep(2000);
	CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	Thread.sleep(2000);
	FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
	String cwid=GenericMethods.GetCurrentWindowID();
	BasePage BP= FP.fn_NavigateAdmineConsole();
	GenericMethods.windowHandle(cwid);
	RoomsLandingPage  RLP=BP.roomsPageNavigate();
	AddRoomsPage ARP= RLP.click_AddRoom();
	RLP= ARP.addRoomName(); 
	GenericMethods.Switch_Parent_Window(cwid);
	Thread.sleep(2000);
	GenericMethods.driver.navigate().refresh();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	FP.fn_clickCurrentLnk();
	Thread.sleep(3000);
	AddQuickReservationForm AQRP  =FP.DragAndDropFor4N(ARP.rtype);
	 FP=AQRP.FillQuickResForm(iTestCaseRow);
	FP.fn_verifyReservation();
	Reporter.log("4 night group booking has been made",true);
}
catch(Exception e){
	throw e;
}
}
	
		


	
	
@Test(priority=31)
public void TC_108() throws Exception{
try{
         sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		 ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
		 iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		 FrontdeskLoginPage AL=new FrontdeskLoginPage();
	     AL.FrontDeskLogin(iTestCaseRow);
	     FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
		 Thread.sleep(2000);
		 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		 Thread.sleep(2000);
		 FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		 Thread.sleep(2000);
	     FP.fn_ClickCancelButton();
	     GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
		 String cwid=GenericMethods.GetCurrentWindowID();
		 BasePage BP= FP.fn_NavigateAdmineConsole();
		 GenericMethods.windowHandle(cwid);
		 RoomsLandingPage  RLP=BP.roomsPageNavigate();
		 AddRoomsPage ARP= RLP.click_AddRoom();
		 RLP= ARP.addRoomName();
		 BP=RLP.ClickOnLogo();
		 ListOfPackagesFrontdesk  FPL= BP.fn_navigateFrontDskPkg();
		 boolean res= FPL.VerifyPackage(iTestCaseRow);
		 Thread.sleep(12000);
		 FPL.CreateInclusionPackageAndAttachToFD(iTestCaseRow, res);
		 String ti= GenericMethods.driver.getTitle();
		 GenericMethods.Switch_Parent_Window(cwid);
		 Thread.sleep(2000);
		 GenericMethods.driver.navigate().refresh();
		 Thread.sleep(2000);
	     FP.fn_ClickCancelButton();
	     FP.fn_clickCurrentLnk();
	     AddQuickReservationForm AQRP  =FP.DragAndDropFor1N(ARP.rtype);
	     String selPak=AQRP.GetSelectedPackage(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PakageName)));
	     String pkgPrice= AQRP.GetPrice();
	     AQRP.FillQuickResvsFormBySelectingPak(iTestCaseRow,selPak);
	     Thread.sleep(2000);
	     GenericMethods.switchToWindowHandle(ti);
	     FrontDeskPackageDetailPage FDP=FPL.clickOnPakEditlink(selPak);
	     String rate=FDP.getPerNightPrice(ARP.rtype);
	     Assert.assertEquals(rate.trim(), pkgPrice.trim());
	     Reporter.log("Pakage Rate verify in the reservation", true);
}
catch(Exception e){
throw e;
}
}


	
@Test(priority=32)
public void TC_109() throws Exception{
try{
	 sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	 ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
	 iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	 FrontdeskLoginPage AL=new FrontdeskLoginPage();
     AL.FrontDeskLogin(iTestCaseRow);
     FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	 Thread.sleep(2000);
	 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	 Thread.sleep(2000);
	 FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	 Thread.sleep(2000);
     FP.fn_ClickCancelButton();
     GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
	 String cwid=GenericMethods.GetCurrentWindowID();
	 BasePage BP= FP.fn_NavigateAdmineConsole();
	 GenericMethods.windowHandle(cwid);
	 RoomsLandingPage  RLP=BP.roomsPageNavigate();
	 AddRoomsPage ARP= RLP.click_AddRoom();
	 RLP= ARP.addRoomName();
	 BP=RLP.ClickOnLogo();
	 ListOfPackagesFrontdesk  FPL= BP.fn_navigateFrontDskPkg();
	 boolean res= FPL.VerifyPackage(iTestCaseRow);
	 String inclusion=FPL.fn_getInclusionFromPackageNamesection(FPL.incName).trim();
	 FPL.CreateInclusionPackageAndAttachToFD(iTestCaseRow, res);
	 String ti= GenericMethods.driver.getTitle();
	 GenericMethods.Switch_Parent_Window(cwid);
	 Thread.sleep(2000);
	 GenericMethods.driver.navigate().refresh();
	 Thread.sleep(2000);
     FP.fn_ClickCancelButton();
     FP.fn_clickCurrentLnk();
     AddQuickReservationForm AQRP  =FP.DragAndDropFor1N(ARP.rtype);
     String selPak=AQRP.GetSelectedPackage(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PakageName)));
     AQRP.FillQuickResvsFormBySelectingPak(iTestCaseRow,selPak);
     FP.fn_verifyReservation();
     Thread.sleep(2000);
     String resStatus=FP.getWebElement(FrontdeskLandingPage.resvId).getAttribute("rsvstatus");
     Thread.sleep(2000);
     Assert.assertEquals(resStatus, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
     Thread.sleep(2000);
     WebElement ele1=FP.getWebElement(FrontdeskLandingPage.resvId);
	 Thread.sleep(2000);
	 FP.fn_rightClickOnReservation(ele1);
	 GenericMethods.clickElement(FP.Link_GroupCheckIn);
	 Thread.sleep(3000);
	 String resStatus1=FP.getWebElement(FrontdeskLandingPage.resvId).getAttribute("rsvstatus");
     Thread.sleep(3000);
     Assert.assertEquals(resStatus1, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
     Thread.sleep(2000);
     WebElement ele=FP.getWebElement(FrontdeskLandingPage.resvId);
     Thread.sleep(2000);
	 FP.fn_rightClickOnReservation(ele);
	 ViewDetailsPage  VDP=FP.ClickOnViewDetailsLink();
	 EnableEditingPage  EEP=VDP.ClickOnEnableEditing();
	 String s=GenericMethods.getText(EEP.Text_AddOnInclusion);
	 String inc=EEP.getAddOn(s).trim();
	 Thread.sleep(2000);
	 Assert.assertEquals(inc, inclusion);
	 Reporter.log("Group reservation has been made and Inclusion verified along with successfull checkIn",true);
}
catch(Exception e){
throw e;
}
}
	
	

	
@Test(priority=33)
public void TC_110_111_112_113_158_159_160_202_203_204_205() throws Exception{
try{
	 sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	 ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
	 iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	 FrontdeskLoginPage AL=new FrontdeskLoginPage();
     AL.FrontDeskLogin(iTestCaseRow);
     FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	 Thread.sleep(2000);
	 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	 Thread.sleep(2000);
	 FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	 Thread.sleep(2000);
     FP.fn_ClickCancelButton();
     GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
	 String cwid=GenericMethods.GetCurrentWindowID();
	 BasePage BP= FP.fn_NavigateAdmineConsole();
	 GenericMethods.windowHandle(cwid);
	 RoomsLandingPage  RLP=BP.roomsPageNavigate();
	 AddRoomsPage ARP= RLP.click_AddRoom();
	 RLP= ARP.addRoomName();
	 BP=RLP.ClickOnLogo();
	 ListOfPackagesFrontdesk  FPL= BP.fn_navigateFrontDskPkg();
	 boolean res= FPL.VerifyPackage(iTestCaseRow);
	 FPL.CreateInclusionPackageAndAttachToFD(iTestCaseRow, res);
	 String ti= GenericMethods.driver.getTitle();
	 GenericMethods.Switch_Parent_Window(cwid);
	 Thread.sleep(2000);
	 GenericMethods.driver.navigate().refresh();
	 Thread.sleep(2000);
     FP.fn_ClickCancelButton();
     FP.fn_clickCurrentLnk();
     AddQuickReservationForm AQRP  =FP.DragAndDropFor1N(ARP.rtype);
     String selPak=AQRP.GetSelectedPackage(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PakageName)));
     AQRP.FillQuickResvsFormBySelectingPak(iTestCaseRow,selPak);
     FP.fn_verifyReservation();
     Thread.sleep(2000);
     WebElement ele=FP.getWebElement(FrontdeskLandingPage.resvId);
     Thread.sleep(2000);
      FP.fn_rightClickOnReservation(ele);
     FP.fn_clkCheckin(ele);
     Thread.sleep(2000);
     WebElement ele1=FP.getWebElement(FrontdeskLandingPage.resvId);
     Thread.sleep(2000);
     FP.fn_rightClickOnReservation(ele1);
     Thread.sleep(2000);
     ViewDetailsPage  VDP= FP.ClickOnViewDetailsLink();
     String room=VDP.getRoomNum();
     String vdp=GenericMethods.driver.getTitle();
     SampleRestaurantPage  SRP=VDP.ClickOnRestaurant();
     GenericMethods.switchToWindowHandle("Sample Restaurant");
     ConfirmOrderPage COP=SRP.generateOrder();
	Thread.sleep(2000);
    OrderFolioPage  OFP=COP.fn_transferOrderToRoom(room);
	Thread.sleep(1000);
	TransactionListPage TLP=OFP.fn_getFolioAndCloseTransaction();
	String fnum=TLP.getFolioNumber(OFP.FNum).trim();
	System.out.println(fnum);
	Thread.sleep(1000);
	GenericMethods.switchToWindowHandle(vdp);
	AccountStatementLandingPage  ASL=VDP.ClickToPayment();
	Thread.sleep(2000);
    ASL.fn_consolidateAccount("Accept");
	Thread.sleep(1000);
	ASL.getFolioNumberfromAccountNumber(fnum);
	Thread.sleep(1000);
	GenericMethods.driver.navigate().refresh();
	Assert.assertEquals(GenericMethods.getText(FP.Header_NightAuditPopUp).trim(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
	GenericMethods.clickElement(FP.Btn_AutoNightAudit);
    Thread.sleep(2000);
	FP.fn_clickCurrentLnk();
	Thread.sleep(2000);
	WebElement ele2=FP.getWebElement( FrontdeskLandingPage.resvId);
	Thread.sleep(2000);
	String resStatBeforeNightAudit=ele2.getAttribute("rsvstatus");
	GenericMethods.clickElement(ele2);
	VDP=FP.ClickOnViewlink();
    ASL=VDP.ClickToPayment();
    ASL.VerifyRoomRateAndTax(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PakageName)));
    ASL.doPayment("Cash");
    Thread.sleep(2000);
    GenericMethods.clickElement(ASL.Btn_GenerateFolio);
    Thread.sleep(2000);
    GenericMethods.clickElement(ASL.Btn_settleFolio);
    Thread.sleep(2000);
    GenericMethods.ActionOnAlert("Accept");
    Thread.sleep(2000);
    GenericMethods.clickElement(ASL.Btn_FolioLock);
    Thread.sleep(2000);
    GenericMethods.ActionOnAlert("Accept");
    Thread.sleep(2000);
    String INV=GenericMethods.getText(ASL.Link_InvoiceNumber).trim();
    Thread.sleep(2000);
    GenericMethods.driver.navigate().refresh();
    GenericMethods.clickElement(FP.Btn_AutoNightAudit);
    Thread.sleep(2000);
	FP.fn_clickCurrentLnk();
	Thread.sleep(2000);
	WebElement ele3=FP.getWebElement(FrontdeskLandingPage.resvId);
	Thread.sleep(2000);
	String resStatAfterNightAudit=ele3.getAttribute("rsvstatus").trim();
	Thread.sleep(2000);
	Assert.assertEquals(resStatAfterNightAudit, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)).trim());
	AccountsLandingPage  ALP=FP.fn_clickOnAccountsLink();
	GenericMethods.switchToWindowHandle("Accounts");
	ALP.fn_ValidateAccountsPage();
	HotelLedgerLandingPage  HLLP=ALP.fn_ClickHotel();
	String inv=HLLP.fn_getInv(INV);
    Thread.sleep(2000);
    Assert.assertEquals(inv, INV);
	Thread.sleep(2000);
	POSPointLedgersListLandingPage  PPL=HLLP.fn_ClickOnPOS();
	POSLedgerLandingPage PLL=PPL.fn_ClickOnLedgerLinkForThePOS("Restaurant");
	Reporter.log("INV matched in Accounts of hotel",true);
	String posfolio=PLL.fn_VerifyPOSInvoice(fnum);
	Thread.sleep(2000);
	Assert.assertEquals(posfolio, fnum);
	Reporter.log("Invoices verified at ledgers of hotel ", true);
	
}
catch(Exception e){
throw e;
}
}
	




@Test(priority=34)
public void TC_114_115_116(){
try{
	 sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	 ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
	 iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	 FrontdeskLoginPage AL=new FrontdeskLoginPage();
     AL.FrontDeskLogin(iTestCaseRow);
     FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	 Thread.sleep(2000);
	 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	 Thread.sleep(2000);
	 FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	 Thread.sleep(2000);
     FP.fn_ClickCancelButton();
     GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
	 String cwid=GenericMethods.GetCurrentWindowID();
	 BasePage BP= FP.fn_NavigateAdmineConsole();
	 GenericMethods.windowHandle(cwid);
	 RoomsLandingPage  RLP=BP.roomsPageNavigate();
	 AddRoomsPage ARP= RLP.click_AddRoom();
	 RLP= ARP.addRoomName();
	 BP=RLP.ClickOnLogo();
	 ListOfPackagesFrontdesk  FPL= BP.fn_navigateFrontDskPkg();
	 boolean res= FPL.VerifyPackage(iTestCaseRow);
	 Thread.sleep(12000);
	 FPL.CreateWeeklyPackageAndAttachToFD(iTestCaseRow, res);
	 String ti= GenericMethods.driver.getTitle();
	 GenericMethods.Switch_Parent_Window(cwid);
	 Thread.sleep(2000);
	 GenericMethods.driver.navigate().refresh();
	 Thread.sleep(2000);
     FP.fn_ClickCancelButton();
     FP.fn_clickCurrentLnk();
     AddQuickReservationForm AQRP  =FP.DragAndDropFor2N(ARP.rtype);
     String selPak=AQRP.GetSelectedPackage(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PakageName)));
     FP=AQRP.FillQuickResvsFormBySelectingPak(iTestCaseRow,selPak);
     Thread.sleep(2000);
     FP.fn_verifyReservation();
     Thread.sleep(2000);
     WebElement ele=FP.getWebElement(FrontdeskLandingPage.resvId);
     Thread.sleep(2000);
     FP.fn_rightClickOnReservation(ele);
     ViewDetailsPage VDP=FP.ClickOnViewDetailsLink();
     EnableEditingPage EEP=VDP.ClickOnEnableEditing();  
     GenericMethods.clickElement(EEP.Link_InclusionAddOns);
     Thread.sleep(2000);
     Assert.assertEquals(GenericMethods.getText(EEP.Header_SelectAddOn), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
     Thread.sleep(1000);
     EEP.fn_setAddOnsToReservation();
     String addOn=EEP.fn_getAddOn(EEP.selectedAddOns);
     
     System.out.println("Expected"+ addOn);
     Thread.sleep(2000);
     System.out.println("Added actual "+GenericMethods.getText(EEP.Text_AddOnInclusion).trim());
     Assert.assertTrue(addOn.trim().contains(GenericMethods.getText(EEP.Text_AddOnInclusion).trim()) );
     Reporter.log("For group reservation add On Added", true);
 }
catch(Exception e){
	
}
}

	
	
	
@Test(priority=35)
public void TC_117() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	FrontdeskLoginPage AL=new FrontdeskLoginPage();
	AL.FrontDeskLogin(iTestCaseRow);
	FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	Thread.sleep(2000);
	CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	Thread.sleep(2000);
	FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
	String cwid=GenericMethods.GetCurrentWindowID();
	BasePage BP= FP.fn_NavigateAdmineConsole();
	GenericMethods.windowHandle(cwid);
	RoomsLandingPage  RLP=BP.roomsPageNavigate();
	AddRoomsPage ARP= RLP.click_AddRoom();
	RLP= ARP.addRoomName(); 
	GenericMethods.Switch_Parent_Window(cwid);
	Thread.sleep(2000);
	GenericMethods.driver.navigate().refresh();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	FP.fn_clickCurrentLnk();
	Thread.sleep(3000);
	AddQuickReservationForm AQRP  =FP.DragAndDropFor1N(ARP.rtype);
	GroupReservationPage  GRP=AQRP.FillQuickResvsForm(iTestCaseRow,AQRP.Link_GroupRes);
	FP=GRP.ClickOnReserve();
	FP.fn_verifyReservation();
	Thread.sleep(2000);
	WebElement ele=FP.getWebElement(FrontdeskLandingPage.resvId);
	Thread.sleep(2000);
	FP.fn_rightClickOnReservation(ele);
	ViewDetailsPage  VDP=FP.ClickOnViewDetailsLink();
	Thread.sleep(2000);
	EnableEditingPage EEP=VDP.ClickOnEnableEditing();
	EEP.fn_changeBookingRate(iTestCaseRow);
	Thread.sleep(2000);
	System.out.println(EEP.newRateAfterSaving+ "Actual");
	System.out.println(EEP.newRate+"Expected");
	Thread.sleep(2000);
	Assert.assertEquals(EEP.newRateAfterSaving, EEP.newRate);
	Reporter.log("New rate verified after changing the rate for the group reservation", true);
}
catch(Exception e){
	throw e;
}
}

	
@Test(priority=36)	
public void TC_118_119() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	FrontdeskLoginPage AL=new FrontdeskLoginPage();
	AL.FrontDeskLogin(iTestCaseRow);
	FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	Thread.sleep(2000);
	CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	Thread.sleep(2000);
	FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
	String cwid=GenericMethods.GetCurrentWindowID();
	BasePage BP= FP.fn_NavigateAdmineConsole();
	GenericMethods.windowHandle(cwid);
	RoomsLandingPage  RLP=BP.roomsPageNavigate();
	AddRoomsPage ARP= RLP.click_AddRoom();
	RLP= ARP.addRoomName(); 
	GenericMethods.Switch_Parent_Window(cwid);
	Thread.sleep(2000);
	GenericMethods.driver.navigate().refresh();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	FP.fn_clickCurrentLnk();
	Thread.sleep(3000);
	AddQuickReservationForm AQRP  =FP.DragAndDropFor1N(ARP.rtype);
	GroupReservationPage  GRP=AQRP.FillQuickResvsForm(iTestCaseRow,AQRP.Link_GroupRes);
	FP=GRP.ClickOnReserve();
	FP.fn_verifyReservation();
	Thread.sleep(2000);
	WebElement ele=FP.getWebElement(FrontdeskLandingPage.resvId);
	Thread.sleep(2000);
	FP.fn_rightClickOnReservation(ele);
	GroupViewDetailPage  GVD=FP.fn_clickOnViewDetailLink();
	GroupEnableEditingPage  GEED=GVD.fn_clickOnEnableEditingBtn();
	ArrayList<String> al=GEED.getGroupResIds();
	GroupToSingleReservationPage GTS=GEED.fn_moveFromGroupToSingle(al.get(0).toString());
	GTS.fn_setExtraBed("1 Bed");
	Thread.sleep(2000);
	Assert.assertEquals(GTS.selectedBed1.trim(), "1 Bed");
	Reporter.log("Extra bed selected", true);
	GroupEnableEditingPage  GEE=GTS.fn_clickOnBackToGroupBtn();
	FP=GEE.fn_clickOnSaveBtn();
	Thread.sleep(2000);
	WebElement ele1=FP.getWebElement(FrontdeskLandingPage.resvId);
	FP.fn_rightClickOnReservation(ele1);
	GVD=FP.fn_clickOnViewDetailLink();
	GEED=GVD.fn_clickOnEnableEditingBtn();
	GTS=GEED.fn_moveFromGroupToSingle(al.get(0).toString());
	String selBed=GenericMethods.fn_getDropdownSelectedValue(GTS.DD_ExtraBed);
	Thread.sleep(2000);
	Assert.assertEquals(selBed,"1 Bed");
	Reporter.log("selected number of bed found", true);
}
catch(Exception e){
	throw e;
}
}
	
	
@Test(priority=37)
public void TC_120() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	FrontdeskLoginPage AL=new FrontdeskLoginPage();
	AL.FrontDeskLogin(iTestCaseRow);
	FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	Thread.sleep(2000);
	CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	Thread.sleep(2000);
	FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
	String cwid=GenericMethods.GetCurrentWindowID();
	BasePage BP= FP.fn_NavigateAdmineConsole();
	GenericMethods.windowHandle(cwid);
	RoomsLandingPage  RLP=BP.roomsPageNavigate();
	AddRoomsPage ARP= RLP.click_AddRoom();
	RLP= ARP.addRoomName(); 
	GenericMethods.Switch_Parent_Window(cwid);
	Thread.sleep(2000);
	GenericMethods.driver.navigate().refresh();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	FP.fn_clickCurrentLnk();
	Thread.sleep(2000);
	AddQuickReservationForm AQRP  =FP.DragAndDropFor2N(ARP.rtype);
	GroupReservationPage  GRP=AQRP.FillQuickResvsForm(iTestCaseRow,AQRP.Link_GroupRes);
	FP=GRP.ClickOnReserve();
	FP.fn_verifyReservation();

	WebElement ele=FP.getWebElement(FrontdeskLandingPage.resvId);
	Thread.sleep(2000);
	FP.fn_rightClickOnReservation(ele);
	Thread.sleep(2000);
	GroupViewDetailPage  GVD=FP.fn_clickOnViewDetailLink();
	GroupEnableEditingPage  GEED=GVD.fn_clickOnEnableEditingBtn();
	ArrayList<String> al=GEED.getGroupResIds();
	GEED.fn_addGuestDetails(al.get(0),GEED.gues1Detail);
	GEED.fn_addGuestDetails(al.get(1),GEED.gues2Detail);
	FP=GEED.fn_clickOnSaveBtn();
	System.out.println(FrontdeskLandingPage.resvId);
	WebElement ele1=FP.getWebElement(FrontdeskLandingPage.resvId);
	Thread.sleep(2000);
	FP.fn_rightClickOnReservation(ele1);
	Thread.sleep(2000);
	GVD=FP.fn_clickOnViewDetailLink();
	GEED=GVD.fn_clickOnEnableEditingBtn();
	String name=GEED.fn_getGuestName(al.get(0));
	ArrayList<String> g1Name=GEED.fn_getGuestFirstNLastName(name);
	String name1=GEED.fn_getGuestName(al.get(1));
	ArrayList<String> g2Name=GEED.fn_getGuestFirstNLastName(name1);
	Thread.sleep(2000);
	Assert.assertTrue(g1Name.get(0).toString().equalsIgnoreCase(GEED.gues1Detail.get(0).toString()));
    Thread.sleep(2000);
	Assert.assertTrue(g1Name.get(1).toString().equalsIgnoreCase(GEED.gues1Detail.get(1).toString()));
    Thread.sleep(2000);
	Assert.assertTrue(g2Name.get(2).toString().equalsIgnoreCase(GEED.gues2Detail.get(0).toString()));
	Thread.sleep(2000);
	Assert.assertTrue(g2Name.get(3).toString().equalsIgnoreCase(GEED.gues2Detail.get(1).toString()));
    Thread.sleep(2000);
	Reporter.log("Guest Detail verified", true);	
}
catch(Exception e){
	throw e;
}
}
	
	
	

@Test(priority=38)
public void TC_121_122() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	FrontdeskLoginPage AL=new FrontdeskLoginPage();
	AL.FrontDeskLogin(iTestCaseRow);
	FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	Thread.sleep(1000);
	CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	Thread.sleep(1000);
	FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	Thread.sleep(1000);
	FP.fn_ClickCancelButton();
	GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
	String cwid=GenericMethods.GetCurrentWindowID();
	BasePage BP= FP.fn_NavigateAdmineConsole();
	GenericMethods.windowHandle(cwid);
	RoomsLandingPage  RLP=BP.roomsPageNavigate();
	AddRoomsPage ARP= RLP.click_AddRoom();
	RLP= ARP.addRoomName(); 
	GenericMethods.Switch_Parent_Window(cwid);
	Thread.sleep(2000);
	GenericMethods.driver.navigate().refresh();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	FP.fn_clickCurrentLnk();
	Thread.sleep(1000);
	AddQuickReservationForm AQRP  =FP.DragAndDropFor2N(ARP.rtype);
	GroupReservationPage  GRP=AQRP.FillQuickResvsForm(iTestCaseRow,AQRP.Link_GroupRes);
	FP=GRP.ClickOnReserve();
	FP.fn_verifyReservation();
	Thread.sleep(2000);
	WebElement ele=FP.getWebElement(FrontdeskLandingPage.resvId);
	Thread.sleep(2000);
	FP.fn_rightClickOnReservation(ele);
	Thread.sleep(2000);
	GroupViewDetailPage  GVD=FP.fn_clickOnViewDetailLink();
	GVD.fn_AddEditDetails();
	Thread.sleep(2000);
	ArrayList<String> editedName=GVD.fn_getEditedFirstNamenLastName(GenericMethods.getText(GVD.Txt_groupOwnerName));
	Thread.sleep(2000);
	Assert.assertTrue(editedName.get(0).toString().equalsIgnoreCase(GVD.fname));
	Thread.sleep(2000);
	Assert.assertTrue(editedName.get(1).toString().equalsIgnoreCase(GVD.lname));
	Thread.sleep(2000);
	Assert.assertTrue(GVD.Img_forBlackListedGuest.isDisplayed());
	Thread.sleep(2000);
	Assert.assertTrue(GVD.Lable_guestAsVIP.isDisplayed());
	Reporter.log("Guest detail edited and black listed and VIP mark feature verified", true);
}
catch(Exception e){
	throw e;
}
}
	
	
	
@Test(priority=39)
public void TC_123() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	FrontdeskLoginPage AL=new FrontdeskLoginPage();
	AL.FrontDeskLogin(iTestCaseRow);
	FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	Thread.sleep(2000);
	CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	Thread.sleep(2000);
	FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
	String cwid=GenericMethods.GetCurrentWindowID();
	BasePage BP= FP.fn_NavigateAdmineConsole();
	GenericMethods.windowHandle(cwid);
	RoomsLandingPage  RLP=BP.roomsPageNavigate();
	AddRoomsPage ARP= RLP.click_AddRoom();
	RLP= ARP.addRoomName(); 
	GenericMethods.Switch_Parent_Window(cwid);
	Thread.sleep(2000);
	GenericMethods.driver.navigate().refresh();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	FP.fn_clickCurrentLnk();
	Thread.sleep(2000);
	AddQuickReservationForm AQRP  =FP.DragAndDropFor2N(ARP.rtype);
	GroupReservationPage  GRP=AQRP.FillQuickResvsForm(iTestCaseRow,AQRP.Link_GroupRes);
	FP=GRP.ClickOnReserve();
	FP.fn_verifyReservation();
	Thread.sleep(2000);
	WebElement ele=FP.getWebElement(FrontdeskLandingPage.resvId);
	Thread.sleep(2000);
	String resId=GenericMethods.fn_getResNumber(FP.resTitle);
	FP.fn_rightClickOnReservation(ele);
	FP.fn_clkCheckin(ele);
	WebElement ele1=FP.getWebElement(FrontdeskLandingPage.resvId);
	FP.fn_rightClickOnReservation(ele1);
	GroupViewDetailPage  GVD=FP.fn_clickOnViewDetailLink();
	GroupEnableEditingPage  GEED=GVD.fn_clickOnEnableEditingBtn();
	String resStat=GEED.fn_getResStatus(resId);
	Assert.assertEquals(resStat, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
	Reporter.log("Group single reservation checked IN", true);
}
catch(Exception e){
	throw e;
}
}

	
	
@Test(priority=40)
public void TC_124_125_126() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	FrontdeskLoginPage AL=new FrontdeskLoginPage();
	AL.FrontDeskLogin(iTestCaseRow);
	FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	Thread.sleep(2000);
	CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	Thread.sleep(2000);
	FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
	String cwid=GenericMethods.GetCurrentWindowID();
	BasePage BP= FP.fn_NavigateAdmineConsole();
	GenericMethods.windowHandle(cwid);
	RoomsLandingPage  RLP=BP.roomsPageNavigate();
	AddRoomsPage ARP= RLP.click_AddRoom();
	RLP= ARP.addRoomName(); 
	GenericMethods.Switch_Parent_Window(cwid);
	Thread.sleep(2000);
	GenericMethods.driver.navigate().refresh();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	FP.fn_clickCurrentLnk();
	Thread.sleep(2000);
	AddQuickReservationForm AQRP  =FP.DragAndDropFor2N(ARP.rtype);
	GroupReservationPage  GRP=AQRP.FillQuickResvsForm(iTestCaseRow,AQRP.Link_GroupRes);
	FP=GRP.ClickOnReserve();
	FP.fn_verifyReservation();
	Thread.sleep(2000);
	WebElement ele=FP.getWebElement(FrontdeskLandingPage.resvId);
	Thread.sleep(2000);
	FP.fn_rightClickOnReservation(ele);
	Thread.sleep(2000);
	FP.fn_groupCheckIn();
	Thread.sleep(2000);
	WebElement ele1=FP.getWebElement(FrontdeskLandingPage.resvId);
	String resStat=GenericMethods.GetWebElementAttributeValue(ele1, "groupstatus");
	Thread.sleep(2000);
	Assert.assertEquals(resStat, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
	Thread.sleep(2000);
	WebElement ele2=FP.getWebElement(FrontdeskLandingPage.resvId);
	Thread.sleep(2000);
	FP.fn_rightClickOnReservation(ele2);
	GenericMethods.clickElement(FP.Link_CancelCheckIn);
	GenericMethods.ActionOnAlert("Accept");
	Thread.sleep(2000);
	Assert.assertEquals(GenericMethods.value.trim(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
	WebElement ele3=FP.getWebElement(FrontdeskLandingPage.resvId);
	Thread.sleep(2000);
	String resStat1=GenericMethods.GetWebElementAttributeValue(ele3, "rsvstatus");
	Thread.sleep(2000);
	Assert.assertEquals(resStat1, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult3)));
	Reporter.log("Group reservation checkin and check out verified", true);
}
catch(Exception e){
throw e;
}
}
		
	
	
@Test(priority=41)
public void TC_127_128() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	FrontdeskLoginPage AL=new FrontdeskLoginPage();
	AL.FrontDeskLogin(iTestCaseRow);
	FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	Thread.sleep(2000);
	CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	Thread.sleep(2000);
	FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
	String cwid=GenericMethods.GetCurrentWindowID();
	BasePage BP= FP.fn_NavigateAdmineConsole();
	GenericMethods.windowHandle(cwid);
	RoomsLandingPage  RLP=BP.roomsPageNavigate();
	AddRoomsPage ARP= RLP.click_AddRoom();
	RLP= ARP.addRoomName(); 
	GenericMethods.Switch_Parent_Window(cwid);
	Thread.sleep(2000);
	GenericMethods.driver.navigate().refresh();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	FP.fn_clickCurrentLnk();
	Thread.sleep(2000);
	AddQuickReservationForm AQRP  =FP.DragAndDropFor1N(ARP.rtype);
	GroupReservationPage  GRP=AQRP.FillQuickResvsForm(iTestCaseRow,AQRP.Link_GroupRes);
	FP=GRP.ClickOnReserve();
	FP.fn_verifyReservation();
	Thread.sleep(2000);
	WebElement ele=FP.getWebElement(FrontdeskLandingPage.resvId);
	Thread.sleep(2000);
	FP.fn_rightClickOnReservation(ele);
	Thread.sleep(2000);
	GroupViewDetailPage  GVD=FP.fn_clickOnViewDetailLink();
	GroupEnableEditingPage  GEED=GVD.fn_clickOnEnableEditingBtn();
	ArrayList<String> al=GEED.getGroupResIds();
	FP=GEED.fn_CheckInSelectedGroupRes(al.get(0).toString());
	Thread.sleep(2000);
	WebElement ele1=FP.getWebElement(FrontdeskLandingPage.resvId);
	Thread.sleep(2000);
	FP.fn_rightClickOnReservation(ele1);
	Thread.sleep(2000);
	GVD=FP.fn_clickOnViewDetailLink();
	GEED=GVD.fn_clickOnEnableEditingBtn();
	String RoomStat=GEED.fn_getResStatus(al.get(0).toString());
	Thread.sleep(2000);
	Assert.assertEquals(RoomStat, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
	Reporter.log("CheckIn verified selected group reservation ", true);
	}
catch(Exception e){
throw e;
}
}

	
	
@Test(priority=42)
public void TC_129_130_131_132(){
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	FrontdeskLoginPage AL=new FrontdeskLoginPage();
	AL.FrontDeskLogin(iTestCaseRow);
	FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	Thread.sleep(2000);
	CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	Thread.sleep(2000);
	FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
	String cwid=GenericMethods.GetCurrentWindowID();
	BasePage BP= FP.fn_NavigateAdmineConsole();
	GenericMethods.windowHandle(cwid);
	RoomsLandingPage  RLP=BP.roomsPageNavigate();
	AddRoomsPage ARP= RLP.click_AddRoom();
	RLP= ARP.addRoomName(); 
	GenericMethods.Switch_Parent_Window(cwid);
	Thread.sleep(2000);
	GenericMethods.driver.navigate().refresh();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	FP.fn_clickCurrentLnk();
	Thread.sleep(2000);
	AddQuickReservationForm AQRP  =FP.DragAndDropFor1N(ARP.rtype);
	GroupReservationPage  GRP=AQRP.FillQuickResvsForm(iTestCaseRow,AQRP.Link_GroupRes);
	FP=GRP.ClickOnReserve();
	FP.fn_verifyReservation();
	Thread.sleep(2000);
	WebElement ele=FP.getWebElement(FrontdeskLandingPage.resvId);
	Thread.sleep(2000);
	FP.fn_rightClickOnReservation(ele);
	Thread.sleep(2000);
	GroupViewDetailPage  GVD=FP.fn_clickOnViewDetailLink();
	GroupEnableEditingPage  GEEP=GVD.fn_clickOnEnableEditingBtn();
	int noOfRoomBeforeadd=GEEP.CB_numberOfResPerRoom.size();
	GenericMethods.clickElement(GEEP.Btn_AddNewRoomToGroup);
	Thread.sleep(2000);
	Assert.assertEquals(GenericMethods.getText(GEEP.Header_AddNewRoom).trim(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
	Thread.sleep(2000);
	GEEP.fn_addNewRoomToGroup();
	Thread.sleep(2000);
	int noOfRoomAfteradd=GEEP.CB_numberOfResPerRoom.size();
	Thread.sleep(2000);
	Assert.assertFalse(noOfRoomBeforeadd==noOfRoomAfteradd);
	GenericMethods.clickElement(GEEP.Icon_deleteGroupRoom);
	Thread.sleep(1000);
	GenericMethods.ActionOnAlert("Accept");
	Thread.sleep(2000);
	Assert.assertEquals(GenericMethods.value.trim(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
	int noOfRoomAfterDeletion=GEEP.CB_numberOfResPerRoom.size();
	Assert.assertTrue(noOfRoomBeforeadd==noOfRoomAfterDeletion);
	Reporter.log("Room addition and deletion verified at group reservation", true);
}
catch(Exception e){
	
}
}
	
	
	
	
@Test(priority=43)
public void TC_133_134_135() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	FrontdeskLoginPage AL=new FrontdeskLoginPage();
	AL.FrontDeskLogin(iTestCaseRow);
	FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	Thread.sleep(2000);
	CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	Thread.sleep(2000);
	FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
	String cwid=GenericMethods.GetCurrentWindowID();
	BasePage BP= FP.fn_NavigateAdmineConsole();
	GenericMethods.windowHandle(cwid);
	RoomsLandingPage  RLP=BP.roomsPageNavigate();
	AddRoomsPage ARP= RLP.click_AddRoom();
	RLP= ARP.addRoomName(); 
	GenericMethods.Switch_Parent_Window(cwid);
	Thread.sleep(2000);
	GenericMethods.driver.navigate().refresh();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	FP.fn_clickCurrentLnk();
	Thread.sleep(2000);
	AddQuickReservationForm AQRP  =FP.DragAndDropFor1N(ARP.rtype);
	GroupReservationPage  GRP=AQRP.FillQuickResvsForm(iTestCaseRow,AQRP.Link_GroupRes);
	FP=GRP.ClickOnReserve();
	FP.fn_verifyReservation();	
	Thread.sleep(2000);
	WebElement ele=FP.getWebElement(FrontdeskLandingPage.resvId);
	Thread.sleep(2000);
	FP.fn_rightClickOnReservation(ele);
	Thread.sleep(2000);
	GroupViewDetailPage  GVD=FP.fn_clickOnViewDetailLink();
	GroupEnableEditingPage  GEEP=GVD.fn_clickOnEnableEditingBtn();
	ArrayList<String> al=GEEP.getGroupResIds();
	GEEP.fn_earlyCheckInSelected(al.get(0).toString());
	Thread.sleep(2000);
	Assert.assertEquals(GEEP.headerEarlyCheckIn.trim(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
	Thread.sleep(2000);
	Assert.assertEquals(GEEP.alertForEarlyCheckin.trim(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
	Thread.sleep(2000);
	WebElement ele1=FP.getWebElement(FrontdeskLandingPage.resvId);
	FP.fn_rightClickOnReservation(ele1);
	GVD=FP.fn_clickOnViewDetailLink();
    GEEP=GVD.fn_clickOnEnableEditingBtn();
	String stat=GEEP.fn_getResStatus(al.get(0).toString());
	Thread.sleep(2000);
	Assert.assertEquals(stat, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult3)));
	Reporter.log("EarlyCheckIn successfull for the group to single reservation", true);
	
	
	
}
catch(Exception e){
	throw e;
}
}
	
	
@Test(priority=44)
public void TC_136_137_138() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	FrontdeskLoginPage AL=new FrontdeskLoginPage();
	AL.FrontDeskLogin(iTestCaseRow);
	FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	Thread.sleep(2000);
	CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	Thread.sleep(2000);
	FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
	String cwid=GenericMethods.GetCurrentWindowID();
	BasePage BP= FP.fn_NavigateAdmineConsole();
	GenericMethods.windowHandle(cwid);
	RoomsLandingPage  RLP=BP.roomsPageNavigate();
	AddRoomsPage ARP= RLP.click_AddRoom();
	RLP= ARP.addRoomName(); 
	GenericMethods.Switch_Parent_Window(cwid);
	Thread.sleep(2000);
	GenericMethods.driver.navigate().refresh();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	FP.fn_clickCurrentLnk();
	Thread.sleep(2000);
	AddQuickReservationForm AQRP  =FP.DragAndDropFor1N(ARP.rtype);
	GroupReservationPage  GRP=AQRP.FillQuickResvsForm(iTestCaseRow,AQRP.Link_GroupRes);
	FP=GRP.ClickOnReserve();
	FP.fn_verifyReservation();
	Thread.sleep(2000);
	String ti=GenericMethods.fn_getResNumber(FP.title).trim();
	int id=Integer.parseInt(ti)+1;
	String ti1=String.valueOf(id);
	System.out.println(ti1 + " group another res ID");
	Thread.sleep(2000);
	WebElement ele=FP.getWebElement(FrontdeskLandingPage.resvId);
	Thread.sleep(2000);
	 String click=ele.getAttribute("title");
	 System.out.println(click +" 1st tym web clikc and title");
	 FP.fn_rightClickOnReservation(ele);
	 GroupViewDetailPage  GVD=FP.fn_clickOnViewDetailLink();
	 GroupEnableEditingPage  GEEP=GVD.fn_clickOnEnableEditingBtn();
	 ArrayList<String> al=GEEP.getGroupResIds();
	 GEEP.fn_cancelAndNoShowRes(al.get(0).toString());
	 Thread.sleep(2000);
	 WebElement eles=GenericMethods.fn_getWebElementForGroup(ti1);
     FP.fn_rightClickOnReservation(eles);
	 GVD=FP.fn_clickOnViewDetailLink();
	 GEEP=GVD.fn_clickOnEnableEditingBtn();
	 Thread.sleep(2000);
	 Assert.assertTrue(GEEP.Link_showCancelled.isDisplayed());
	 Reporter.log("No show or cancellation of reservation has been done successfully", true);
}
catch(Exception e){
	throw e;
}
}
	
		@Test(priority=45)
	public void TC_139_140_141() throws Exception{
	try{
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
		iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
		AL.FrontDeskLogin(iTestCaseRow);
		FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
		Thread.sleep(2000);
		CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		Thread.sleep(2000);
		FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		Thread.sleep(2000);
		FP.fn_ClickCancelButton();
		GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
		String cwid=GenericMethods.GetCurrentWindowID();
		BasePage BP= FP.fn_NavigateAdmineConsole();
		GenericMethods.windowHandle(cwid);
		RoomsLandingPage  RLP=BP.roomsPageNavigate();
		AddRoomsPage ARP= RLP.click_AddRoom();
		RLP= ARP.addRoomName(); 
		GenericMethods.Switch_Parent_Window(cwid);
		Thread.sleep(2000);
		GenericMethods.driver.navigate().refresh();
		Thread.sleep(2000);
		FP.fn_ClickCancelButton();
		FP.fn_clickCurrentLnk();
		Thread.sleep(2000);
		AddQuickReservationForm AQRP  =FP.DragAndDropFor1N(ARP.rtype);
		GroupReservationPage  GRP=AQRP.FillQuickResvsForm(iTestCaseRow,AQRP.Link_GroupRes);
		FP=GRP.ClickOnReserve();
		FP.fn_verifyReservation();
		Thread.sleep(2000);
		WebElement ele=FP.getWebElement(FrontdeskLandingPage.resvId);
		Thread.sleep(2000);
		FP.fn_rightClickOnReservation(ele);
		GroupViewDetailPage GVD=FP.fn_clickOnViewDetailLink();
		GroupEnableEditingPage GEEP=GVD.fn_clickOnEnableEditingBtn();
		GenericMethods.fn_DoubleClickOnWebElement(GEEP.Link_RateInRateTypeForGroup);
		GEEP.fn_GiveDiscountInStandardRateForGR();
		float givenDiscount=GenericMethods.fn_getRateFromRateString(GenericMethods.getText(GEEP.Text_givenDiscount));
	    float expDisc=Float.parseFloat(GEEP.discAmt);
	    Assert.assertEquals(givenDiscount, expDisc, 0.0f);
	    Reporter.log("Given Discount verified in Rate detail section.",true);
	    FP=GEEP.fn_clickOnSaveBtn();
	    Thread.sleep(2000);
	    WebElement ele1=FP.getWebElement(FrontdeskLandingPage.resvId);
		FP.fn_rightClickOnReservation(ele1);
		 GVD=FP.fn_clickOnViewDetailLink();
		 GEEP=GVD.fn_clickOnEnableEditingBtn();
		 float givenDiscount1=GenericMethods.fn_getRateFromRateString(GenericMethods.getText(GEEP.Text_givenDiscount));
		 Assert.assertEquals(givenDiscount1, expDisc, 0.0f);
		 Reporter.log("Given Discount verified in Rate detail section after saving the discount and reservation.",true);
	}
	catch(Exception e){
		throw e;
	}
	}
	



	
@Test(priority=46)
public void TC_142_143_144() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	FrontdeskLoginPage AL=new FrontdeskLoginPage();
	AL.FrontDeskLogin(iTestCaseRow);
	FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	Thread.sleep(2000);
	CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	Thread.sleep(2000);
	FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
	String cwid=GenericMethods.GetCurrentWindowID();
	BasePage BP= FP.fn_NavigateAdmineConsole();
	GenericMethods.windowHandle(cwid);
	RoomsLandingPage  RLP=BP.roomsPageNavigate();
	AddRoomsPage ARP= RLP.click_AddRoom();
	RLP= ARP.addRoomName(); 
	GenericMethods.Switch_Parent_Window(cwid);
	Thread.sleep(2000);
	GenericMethods.driver.navigate().refresh();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	FP.fn_clickCurrentLnk();
	Thread.sleep(2000);
	AddQuickReservationForm AQRP  =FP.DragAndDropFor1N(ARP.rtype);
	 GroupReservationPage  GRP=AQRP.FillQuickResvsForm(iTestCaseRow,AQRP.Link_GroupRes);
	 FP=GRP.ClickOnReserve();
	 FP.fn_verifyReservation();	
	 Thread.sleep(2000);
	 WebElement ele=FP.getWebElement(FrontdeskLandingPage.resvId);
	 Thread.sleep(2000);
	 FP.fn_rightClickOnReservation(ele);
	 Thread.sleep(2000);
	 GroupViewDetailPage  GVD=FP.fn_clickOnViewDetailLink();
	 GroupEnableEditingPage  GEED=GVD.fn_clickOnEnableEditingBtn();
	 ArrayList<String> al=GEED.getGroupResIds();
	 GEED.fn_addGuestDetails(al.get(0).toString(),GEED.gues1Detail);
	 GEED.fn_addGuestDetails(al.get(1).toString(),GEED.gues2Detail);
	 GroupToSingleReservationPage GTSRP=GEED.fn_moveFromGroupToSingle(al.get(0).toString());
	 GenericMethods.clickElement(GTSRP.Link_ManageSharer);
	 GTSRP.fn_addGuestDetail(GTSRP.al,"yes");
	 Thread.sleep(2000);
	 GTSRP.fn_getGuestAllDetail();
	 ArrayList<String> gname=GTSRP.fn_getGuestFirstNLastName(GTSRP.guestFullName);
	 Thread.sleep(2000);
	 Assert.assertTrue(gname.get(0).toString().equalsIgnoreCase(GTSRP.al.get(0).toString()));
	 Thread.sleep(2000);
	 Assert.assertTrue(gname.get(1).toString().equalsIgnoreCase(GTSRP.al.get(1).toString()));
	 Thread.sleep(2000);
     Assert.assertTrue(GTSRP.chargeSharerGuest.equalsIgnoreCase("yes"));
     GEED=GTSRP.fn_clickOnBackToGroupBtn();
     String gnam=GEED.fn_getGuestName(al.get(0).toString());
     ArrayList<String> name=GEED.fn_getGuestFirstNLastName(gnam);
    Assert.assertTrue(name.get(0).toString().equalsIgnoreCase(GEED.gues1Detail.get(0).toString()));
    Thread.sleep(2000);
    Assert.assertTrue(name.get(1).toString().equalsIgnoreCase(GEED.gues1Detail.get(1).toString()));
    Reporter.log("Guest detail filled and verified along with charge sharer", true);
}
catch(Exception e){
	throw e;
}
}

	
	
@Test(priority=47)
public void TC_145_146_147_148() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	FrontdeskLoginPage AL=new FrontdeskLoginPage();
	AL.FrontDeskLogin(iTestCaseRow);
	FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	Thread.sleep(2000);
	CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	Thread.sleep(2000);
	FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
	String cwid=GenericMethods.GetCurrentWindowID();
	BasePage BP= FP.fn_NavigateAdmineConsole();
	GenericMethods.windowHandle(cwid);
	RoomsLandingPage  RLP=BP.roomsPageNavigate();
	AddRoomsPage ARP= RLP.click_AddRoom();
	RLP= ARP.addRoomName(); 
	GenericMethods.Switch_Parent_Window(cwid);
	Thread.sleep(2000);
	GenericMethods.driver.navigate().refresh();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	FP.fn_clickCurrentLnk();
	Thread.sleep(2000);
	AddQuickReservationForm AQRP  =FP.DragAndDropFor2N(ARP.rtype);
	GroupReservationPage  GRP=AQRP.FillQuickResvsForm(iTestCaseRow,AQRP.Link_GroupRes);
	FP=GRP.ClickOnReserve();
	FP.fn_verifyReservation();
	Thread.sleep(2000);
	 WebElement ele=FP.getWebElement(FrontdeskLandingPage.resvId);
	 Thread.sleep(2000);
	 FP.fn_rightClickOnReservation(ele);
	 Thread.sleep(2000);
	 GroupViewDetailPage  GVD=FP.fn_clickOnViewDetailLink();
	 GroupEnableEditingPage  GEED=GVD.fn_clickOnEnableEditingBtn();
	 ArrayList<String> al=GEED.getGroupResIds();
	 String dateRange=GEED.fn_getCheckInCheckOutDates(al.get(0).toString());
	 System.out.println(dateRange);
	 String dateRange1=GEED.fn_getCheckInCheckOutDates(al.get(1).toString());
	 System.out.println(dateRange1);
	 GEED.fn_ChangeCheckInDate(al.get(0).toString(),1);
	 Thread.sleep(1000);
	 GEED.fn_ChangeCheckOutDate(al.get(1).toString(),1);
	 Thread.sleep(1000);
	 FP=GEED.fn_clickOnSaveBtn();
	 Thread.sleep(2000);
	 WebElement ele1=FP.getWebElement(FrontdeskLandingPage.resvId);
	 FP.fn_rightClickOnReservation(ele1);
     GVD=FP.fn_clickOnViewDetailLink();
	 GEED=GVD.fn_clickOnEnableEditingBtn();
	 Thread.sleep(2000);
	  String ChangedateRange=GEED.fn_getCheckInCheckOutDates(al.get(0).toString());
	 String ChangedateRange1=GEED.fn_getCheckInCheckOutDates(al.get(1).toString());
	 Thread.sleep(2000);
	 Assert.assertFalse(dateRange.equals(ChangedateRange));
	 Thread.sleep(2000);
	 Assert.assertFalse(dateRange1.equals(ChangedateRange1));
	 Reporter.log("CheckIn and checkout date changed successfully.", true);
}
catch(Exception e){
	throw e;
}
}
	
	
	
@Test(priority=48)
public void TC_152() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	FrontdeskLoginPage AL=new FrontdeskLoginPage();
	AL.FrontDeskLogin(iTestCaseRow);
	FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	Thread.sleep(2000);
	CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	Thread.sleep(2000);
	FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
	String cwid=GenericMethods.GetCurrentWindowID();
	BasePage BP= FP.fn_NavigateAdmineConsole();
	GenericMethods.windowHandle(cwid);
	RoomsLandingPage  RLP=BP.roomsPageNavigate();
	AddRoomsPage ARP= RLP.click_AddRoom();
	RLP= ARP.addRoomName(); 
	GenericMethods.Switch_Parent_Window(cwid);
	Thread.sleep(2000);
	GenericMethods.driver.navigate().refresh();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	FP.fn_clickCurrentLnk();
	Thread.sleep(2000);
	AddQuickReservationForm AQRP  =FP.DragAndDropFor1N(ARP.rtype);
	GroupReservationPage  GRP=AQRP.FillQuickResvsForm(iTestCaseRow,AQRP.Link_GroupRes);
	FP=GRP.ClickOnReserve();
	FP.fn_verifyReservation();
	Thread.sleep(2000);
	WebElement ele=FP.getWebElement(FrontdeskLandingPage.resvId);
	Thread.sleep(2000);
	 FP.fn_rightClickOnReservation(ele);
	 GroupViewDetailPage  GVD=FP.fn_clickOnViewDetailLink();
	 GroupEnableEditingPage  GEED=GVD.fn_clickOnEnableEditingBtn();
	 GEED.fn_ChangePayTerms(iTestCaseRow);
	 Thread.sleep(2000);
	 WebElement ele1=FP.getWebElement(FrontdeskLandingPage.resvId);
	 FP.fn_rightClickOnReservation(ele1);
	 GVD=FP.fn_clickOnViewDetailLink();
	 GEED=GVD.fn_clickOnEnableEditingBtn();
	 Thread.sleep(2000);
	 Assert.assertTrue(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PayTerms)).equalsIgnoreCase(GenericMethods.getText(GEED.Text_PayTerm).trim()));
	 Reporter.log("PayTerms Verified ", true);
}
catch(Exception e){
	throw e;
}
}

	
	
	
@Test(priority=49)
public void TC_153_154() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	FrontdeskLoginPage AL=new FrontdeskLoginPage();
	AL.FrontDeskLogin(iTestCaseRow);
	FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	Thread.sleep(2000);
	CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	Thread.sleep(2000);
	FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
	String cwid=GenericMethods.GetCurrentWindowID();
	BasePage BP= FP.fn_NavigateAdmineConsole();
	GenericMethods.windowHandle(cwid);
	RoomsLandingPage  RLP=BP.roomsPageNavigate();
	AddRoomsPage ARP= RLP.click_AddRoom();
	RLP= ARP.addRoomName(); 
	GenericMethods.Switch_Parent_Window(cwid);
	Thread.sleep(2000);
	GenericMethods.driver.navigate().refresh();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	FP.fn_clickCurrentLnk();
	Thread.sleep(2000);
	WebElement ele=FP.fn_selectRoomForDNR(AddRoomsPage.roomNumber.trim());
	Thread.sleep(2000);
	String str=GenericMethods.generateRandomString();
	FP.fn_ApplyDNRToRoom(ele, str.trim());
	Thread.sleep(2000);
	String DNRStat=FP.fn_verifyRoomDNR(str.trim());
	System.out.println(DNRStat);
	Thread.sleep(1000);
	Assert.assertEquals(DNRStat, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
	Reporter.log("DNR applied to the room",true);
}
catch(Exception e){
	throw e;
}
}

@Test(priority=50)
public void TC_222(){
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	FrontdeskLoginPage AL=new FrontdeskLoginPage();
	AL.FrontDeskLogin(iTestCaseRow);
	FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	Thread.sleep(2000);
	CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	Thread.sleep(2000);
	FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
	String cwid=GenericMethods.GetCurrentWindowID();
	BasePage BP= FP.fn_NavigateAdmineConsole();
	GenericMethods.windowHandle(cwid);
	RoomsLandingPage  RLP=BP.roomsPageNavigate();
	AddRoomsPage ARP= RLP.click_AddRoom();
	RLP= ARP.addRoomName(); 
	GenericMethods.Switch_Parent_Window(cwid);
	Thread.sleep(2000);
	GenericMethods.driver.navigate().refresh();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	FP.fn_clickCurrentLnk();
	Thread.sleep(2000);
	AddQuickReservationForm AQRP  =FP.DragAndDropFor1N(ARP.rtype);
	GroupReservationPage  GRP=AQRP.FillQuickResvsForm(iTestCaseRow,AQRP.Link_GroupRes);
	FP=GRP.ClickOnReserve();
	FP.fn_verifyReservation();
	Thread.sleep(2000);
	WebElement ele=FP.getWebElement(FrontdeskLandingPage.resvId);
	Thread.sleep(2000);
	FP.fn_rightClickOnReservation(ele);
	GroupViewDetailPage  GVD=FP.fn_clickOnViewDetailLink();
	GroupEnableEditingPage  GEEP=GVD.fn_clickOnEnableEditingBtn();
	int noOfRoomBeforeadd=GEEP.CB_numberOfResPerRoom.size();
	GenericMethods.clickElement(GEEP.Btn_AddNewRoomToGroup);
	Thread.sleep(2000);
	
	Thread.sleep(2000);
	GEEP.fn_addNewRoomToGroup();
	Thread.sleep(2000);
	int noOfRoomAfteradd=GEEP.CB_numberOfResPerRoom.size();
	Thread.sleep(2000);
	GEEP.fn_clickOnSaveBtn();
	Thread.sleep(2000);
	WebElement ele1=FP.getWebElement(FrontdeskLandingPage.resvId);
	FP.fn_rightClickOnReservation(ele1);
  GVD=FP.fn_clickOnViewDetailLink();
	 GEEP=GVD.fn_clickOnEnableEditingBtn();
	 int numberOfRoomAfterSaving=GEEP.CB_numberOfResPerRoom.size();
	Thread.sleep(2000); 
	Assert.assertTrue(noOfRoomAfteradd==numberOfRoomAfterSaving);
	
	Reporter.log("Room addition functionality verified after saving group reservation.", true);
}
catch(Exception e){
	
}
}	

	
	
@Test(priority=51)
public void TC_156_157() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	FrontdeskLoginPage AL=new FrontdeskLoginPage();
	AL.FrontDeskLogin(iTestCaseRow);
	FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	Thread.sleep(2000);
	CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	Thread.sleep(2000);
	FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
	String cwid=GenericMethods.GetCurrentWindowID();
	BasePage BP= FP.fn_NavigateAdmineConsole();
	GenericMethods.windowHandle(cwid);
	RoomsLandingPage  RLP=BP.roomsPageNavigate();
	AddRoomsPage ARP= RLP.click_AddRoom();
	RLP= ARP.addRoomName(); 
	GenericMethods.Switch_Parent_Window(cwid);
	Thread.sleep(2000);
	GenericMethods.driver.navigate().refresh();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	FP.fn_clickCurrentLnk();
	Thread.sleep(2000);
	AddQuickReservationForm AQRP  =FP.DragAndDropFor1N(ARP.rtype);
	GroupReservationPage  GRP=AQRP.FillQuickResvsForm(iTestCaseRow,AQRP.Link_GroupRes);
	FP=GRP.ClickOnReserve();
	FP.fn_verifyReservation();
	 Thread.sleep(2000);
     WebElement ele=FP.getWebElement(FrontdeskLandingPage.resvId);
     FP.fn_rightClickOnReservation(ele);
     FP.fn_clkCheckin(ele);
     Thread.sleep(2000);
     WebElement ele1=FP.getWebElement(FrontdeskLandingPage.resvId);
     Thread.sleep(2000);
     FP.fn_rightClickOnReservation(ele1);
     Thread.sleep(2000);
     GroupViewDetailPage  GVD= FP.fn_clickOnViewDetailLink();
     GroupEnableEditingPage GEEP=GVD.fn_clickOnEnableEditingBtn();
     ArrayList<String> al=GEEP.getGroupResIds();
     GEEP.fn_addGuestDetails(al.get(0).toString(),GEEP.gues1Detail);
     GroupToSingleReservationPage GSRP=GEEP.fn_moveFromGroupToSingle(al.get(0).toString());
     String resRoom=GSRP.fn_getReservedRoom();
     String fd=GenericMethods.driver.getTitle();
     SampleRestaurantPage SRP=GSRP.fn_ClickOnRestaurant();
     GenericMethods.switchToWindowHandle("Sample Restaurant");
     ConfirmOrderPage COP=SRP.generateOrder();
	Thread.sleep(2000);
    OrderFolioPage  OFP=COP.fn_transferOrderToRoom(resRoom);
	Thread.sleep(1000);
	TransactionListPage TLP=OFP.fn_getFolioAndCloseTransaction();
	String fnum=TLP.getFolioNumber(OFP.FNum).trim();
	System.out.println(fnum);
	Thread.sleep(1000);
	GenericMethods.switchToWindowHandle(fd);
	AccountStatementLandingPage  ASL=GSRP.fn_clickOnPayment();
	Thread.sleep(2000);
    ASL.fn_consolidateAccount("Accept");
	Thread.sleep(1000);
	ASL.getFolioNumberfromAccountNumber(fnum);
	Reporter.log("Pos item posted to the group and verified during consolidation process", true);
}
catch(Exception e){
throw e;
}
}

	
@Test(priority=52)	
public void TC_161() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	 FrontdeskLoginPage AL=new FrontdeskLoginPage();
	 AL.FrontDeskLogin(iTestCaseRow);
	 FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	 Thread.sleep(2000);
	 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	 Thread.sleep(2000);
	 FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	 Thread.sleep(2000);
	 FP.fn_ClickCancelButton();
	 GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
	 String cwid=GenericMethods.GetCurrentWindowID();
	 BasePage BP= FP.fn_NavigateAdmineConsole();
	 GenericMethods.windowHandle(cwid);
	 RoomsLandingPage  RLP=BP.roomsPageNavigate();
	 AddRoomsPage ARP= RLP.click_AddRoom();
	 RLP= ARP.addRoomName(); 
	 GenericMethods.Switch_Parent_Window(cwid);
	 Thread.sleep(2000);
	 GenericMethods.driver.navigate().refresh();
	 Thread.sleep(2000);
	 FP.fn_ClickCancelButton();
	 FP.fn_clickCurrentLnk();
	 Thread.sleep(2000);
	 AddQuickReservationForm AQRP  =FP.DragAndDropFor1N(ARP.rtype);
	 GroupReservationPage  GRP=AQRP.FillQuickResvsForm(iTestCaseRow,AQRP.Link_GroupRes);
	 FP=GRP.ClickOnReserve();
	 FP.fn_verifyReservation();
	 Thread.sleep(2000);
     WebElement ele=FP.getWebElement(FrontdeskLandingPage.resvId);
	 Thread.sleep(1000);
     FP.fn_rightClickOnReservation(ele);
	 FP.fn_clkCheckin(ele);
	 Thread.sleep(2000);
     WebElement ele1=FP.getWebElement(FrontdeskLandingPage.resvId);
     Thread.sleep(2000);
     FP.fn_rightClickOnReservation(ele1);
     Thread.sleep(2000);
     GroupViewDetailPage  GVD= FP.fn_clickOnViewDetailLink();
     GroupEnableEditingPage GEEP=GVD.fn_clickOnEnableEditingBtn();
     ArrayList<String> al=GEEP.getGroupResIds();
     GEEP.fn_addGuestDetails(al.get(0).toString(),GEEP.gues1Detail);
     GroupToSingleReservationPage GSRP=GEEP.fn_moveFromGroupToSingle(al.get(0).toString());
     String resRoom=GSRP.fn_getReservedRoom();
     String fd=GenericMethods.driver.getTitle();
     SampleRestaurantPage SRP=GSRP.fn_ClickOnRestaurant();
     GenericMethods.switchToWindowHandle("Sample Restaurant");
     ConfirmOrderPage COP=SRP.generateOrder();
	 Thread.sleep(2000);
     OrderFolioPage  OFP=COP.fn_transferOrderToRoom(resRoom);
	 Thread.sleep(1000);
	 TransactionListPage TLP=OFP.fn_getFolioAndCloseTransaction();
	 String fnum=TLP.getFolioNumber(OFP.FNum).trim();
	 System.out.println(fnum);
	 Thread.sleep(1000);
	 GenericMethods.switchToWindowHandle(fd);
	 AccountStatementLandingPage  ASL=GSRP.fn_clickOnPayment();
	 Thread.sleep(2000);
     ASL.fn_consolidateAccount("Accept");
	 Thread.sleep(1000);
	 String af=ASL.getFolioNumberfromAccountNumber(fnum);
	 Assert.assertEquals(af.trim(), fnum.trim());
	 GenericMethods.driver.navigate().refresh();
	 Thread.sleep(2000);
	 GenericMethods.clickElement(FP.Btn_AutoNightAudit);
	 Thread.sleep(30000);
	 GenericMethods.driver.navigate().refresh();
	 Thread.sleep(2000);
	 GenericMethods.clickElement(FP.Btn_AutoNightAudit);
	 Thread.sleep(3000);
	 WebElement ele2=FP.getWebElement(FrontdeskLandingPage.resvId);
     FP.fn_rightClickOnReservation(ele2);
     ASL=FP.ClickOnPayment();
     Thread.sleep(2000);
     ASL.fn_verifyFolioAndRateType(af,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ResRateType)));
     Reporter.log("All the POS and  Room rent posted to the Account statement.", true);
}
catch(Exception e){
	throw e;
}
}

	
	
	
@Test(priority=53)
public void TC_vb() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	 FrontdeskLoginPage AL=new FrontdeskLoginPage();
	 AL.FrontDeskLogin(iTestCaseRow);
	 FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	 Thread.sleep(2000);
	 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	 Thread.sleep(2000);
	 FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	 Thread.sleep(2000);
	 FP.fn_ClickCancelButton();
	 GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
	 String cwid=GenericMethods.GetCurrentWindowID();
	 BasePage BP= FP.fn_NavigateAdmineConsole();
	 GenericMethods.windowHandle(cwid);
	 RoomsLandingPage  RLP=BP.roomsPageNavigate();
	 AddRoomsPage ARP= RLP.click_AddRoom();
	 RLP= ARP.addRoomName(); 
	 GenericMethods.Switch_Parent_Window(cwid);
	 Thread.sleep(2000);
	 GenericMethods.driver.navigate().refresh();
	 Thread.sleep(2000);
	 FP.fn_ClickCancelButton();
	 FP.fn_clickCurrentLnk();
	 Thread.sleep(2000);
	 AddQuickReservationForm AQRP  =FP.DragAndDropFor2N(ARP.rtype);
	 GroupReservationPage  GRP=AQRP.FillQuickResvsForm(iTestCaseRow,AQRP.Link_GroupRes);
	 FP=GRP.ClickOnReserve();
	 FP.fn_verifyReservation();
	 WebElement ele=FP.getWebElement(FrontdeskLandingPage.resvId);
	 Thread.sleep(1000);
     FP.fn_rightClickOnReservation(ele);
	 FP.fn_clkCheckin(ele);
	 Thread.sleep(2000);
	 WebElement ele1=FP.getWebElement(FrontdeskLandingPage.resvId);
     Thread.sleep(2000);
     FP.fn_rightClickOnReservation(ele1);
     Thread.sleep(2000);
     GroupViewDetailPage  GVD= FP.fn_clickOnViewDetailLink();
     GroupEnableEditingPage GEEP=GVD.fn_clickOnEnableEditingBtn();
     ArrayList<String> al=GEEP.getGroupResIds();
     GEEP.fn_addGuestDetails(al.get(0).toString(),GEEP.gues1Detail);
     GroupToSingleReservationPage GSRP=GEEP.fn_moveFromGroupToSingle(al.get(0).toString());
     String resRoom=GSRP.fn_getReservedRoom();
     String fd=GenericMethods.driver.getTitle();
     SampleRestaurantPage SRP=GSRP.fn_ClickOnRestaurant();
     GenericMethods.switchToWindowHandle("Sample Restaurant");
     ConfirmOrderPage COP=SRP.generateOrder();
	 Thread.sleep(2000);
     OrderFolioPage  OFP=COP.fn_transferOrderToRoom(resRoom);
	 Thread.sleep(1000);
	 TransactionListPage TLP=OFP.fn_getFolioAndCloseTransaction();
	 String fnum=TLP.getFolioNumber(OFP.FNum).trim();
	 System.out.println(fnum);
	 Thread.sleep(1000);
	 GenericMethods.switchToWindowHandle(fd);
	 GenericMethods.driver.navigate().refresh();
	 GenericMethods.clickElement(FP.Btn_AutoNightAudit);
	 WebElement ele2=FP.getWebElement(FrontdeskLandingPage.resvId);
	 Thread.sleep(1000);
     FP.fn_rightClickOnReservation(ele2);
   AccountStatementLandingPage  ASL=FP.ClickOnPayment();
   WebElement ele3=ASL.fn_checkPosFolio(fnum);
   Assert.assertTrue(ele3.isDisplayed());
   Reporter.log("POS folio number verified after night audit in Account Statement", true);
}
catch(Exception e){
throw e;

}
}	

@AfterMethod
public void closeApp() throws Exception{
	Set<String> handles = GenericMethods.driver.getWindowHandles();
	Thread.sleep(2000);
	Iterator<String> iter = handles.iterator();
	while (iter.hasNext()) {
		Thread.sleep(3000);
		GenericMethods.driver.switchTo().window(iter.next());
		Thread.sleep(3000);
		GenericMethods.driver.close();
	}
	

}





}

