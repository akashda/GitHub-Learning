package com.hotelogix.smoke.frontdesk.Payment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


import com.hotelogix.smoke.frontdesk.FrontdeskHome.FrontdeskLandingPage;
import com.hotelogix.smoke.frontdesk.NightAudit.ContinueNightAuditPage;
import com.hotelogix.smoke.frontdesk.NightAudit.NightAuditSummaryPage;
import com.hotelogix.smoke.frontdesk.SampleRestaurantPage.OrderFolioPage;
import com.hotelogix.smoke.genericandbase.Constant;
import com.hotelogix.smoke.genericandbase.ExcelUtil;
import com.hotelogix.smoke.genericandbase.GenericMethods;




public class AccountStatementLandingPage {

	public static String CustomChargeDescription="Item 2";

	public static String priceForCustomCharge="10";
	public static String  quantityForCustomCharge="1";
	public static String POSPoint;
	public static String item;
	public String postedRoomPrice;
	public String postedRoomTax;
	public String selProduct;
	
	
	
	



	public  String exp_msg="Consolidate Now? \n"+" Accounts Consolidate automatically at Night Audit";


	
	@FindBy(xpath="//table[@class='payment_total']/tbody/tr[2]/td[2]")
	public WebElement Txt_BookingTotal;
	
	@FindBy(xpath="//td[contains(normalize-space(text()),'ACCOUNT STATEMENT')]")
	public static WebElement PaymentPage;

	@FindBy(xpath="//input[@id='btnConsolidate']")
	public static WebElement ConsolidateAccountBtn;

	@FindBy(xpath="//input[@type='checkbox']")
	public static List<WebElement> AllThePostedItemToAccount;

	@FindBy(xpath="//table[@class='payment_total']//tbody//tr[4]//td[2]")
	public static WebElement RoomTax;



	/*@FindBy(xpath="//td[text()='Custom Charge/Allowance']")
	public static WebElement CustomChargeAllowanceTitle;*/

	@FindBy(xpath="//a[text()='Close']")
	public static WebElement CloseBtnOnPopUp;



	

	

	


	

	@FindBy(xpath="//select[@id='selPOSGuest']")
	public static WebElement ChargeToDropdown;

	@FindBy(xpath="//select[@id='selPOS']")
	public static WebElement POSPointDropdown;

	@FindBy(xpath="//select[@id='SelocTxtProduct']")
	public static WebElement  ProductDropdown;

	@FindBy(xpath="//input[@id='ocTxtQuantity']")
	public static WebElement QtyForOtherCharges;

	@FindBy(xpath="//button[@id='ocBtnSave-button']")
	public static WebElement SaveOtherCharges;

	@FindBy(xpath="//td[text()='Other Charges']")
	public static WebElement OtherChargesPopUpTitle;

	@FindBy(xpath="//a[text()='Close']")
	public static WebElement CloseBtnForOtherCharges;



	@FindBy(xpath="//input[@id='BtnPaymentsDeletLedger']")
	public static WebElement DeletePerfomaInvoiceBtn;

	@FindBy(xpath="//table[@class='payment_total']//tr[8]//td[@class='frn_total_g']")
	public static WebElement booking_bal;

	@FindBy(xpath="//input[@name='btnGenarateFolio' and @class='button-g']")
	public static WebElement generateFolioBtn;

	@FindBy(xpath="//table[@class='frn_paytbl_fllist']//tr[3]//table//td[1]//span")
	public static WebElement Nofolio;

	@FindBy(xpath="//input[@name='BtnPaymentsDeletLedger']")
	public static WebElement delPerformaInvoice;

	@FindBy(xpath="//input[@name='btnAddNewCharges']")
	public static WebElement otherCharges;

	@FindBy(xpath="//input[@name='btnGrpOtherCharge']")
	public static WebElement otherCharges1;

	@FindBy(xpath="//select[@name='selPOSGuest']")
	public static WebElement chargeTo;

	@FindBy(xpath="//select[@name='selPOSRoomOwner']")
	public static WebElement chargeToGrp;

	@FindBy(xpath="//select[@name='selPOS']")
	public static WebElement posPoint;

	@FindBy(xpath="//select[@name='SelocTxtProduct']")
	public static WebElement posProduct;

	@FindBy(xpath="//button[@id='ocBtnSave-button']")
	public static WebElement saveOtherCharge;

	@FindBy(xpath="//td[@class='front_tbl_lft']//tr//td[2]//input")
	public static List<WebElement> chkboxCount;

	@FindBy(xpath="//input[@name='btnCreateNewFolio']")
	public static WebElement routeToNewFolio;

	@FindBy(xpath="//div[@id='PanelSingleCreateNewFolio_h']")
	public static WebElement createFolioTitle;

	@FindBy(xpath="//div[@id='PanelCreateNewFolioGr_h']")
	public static WebElement createFolioTitleGrp;

	@FindBy(xpath="//input[@name='btnCustomCharges']")
	public static WebElement customChargeBtn;

	@FindBy(xpath="//input[@name='btnGrpCustomCharge']")
	public static WebElement customChrgGrp;

	@FindBy(xpath="//input[@name='ocTxtProduct' and @type='text']")
	public static WebElement description;

	@FindBy(xpath="//input[@name='price']")
    public static WebElement price;

	@FindBy(xpath="//select[@name='selGuestIds']")
	public static WebElement selGuestId;

	@FindBy(xpath="//button[@id='newFolioCreate-button']")
	public static WebElement createFolio;

	@FindBy(xpath="//input[@name='btnTransactionRoute']")
    public static WebElement routeChargesbtn;

	

	@FindBy(xpath="//div[@id='PanelRouteGroupTr_h']")
	public static WebElement RCGroup;







	@FindBy(xpath="//input[@name='amount']")
    public static WebElement amount;

  

    @FindBy(xpath="//input[@name='btnRoutePay']")
    public static WebElement routePaymentBtn;

    @FindBy(xpath="//input[@name='btnRoutePayment']")
    public static WebElement routePaymentGrp;

   

   

 

 

   

    @FindBy(xpath="//div[@id='PanelGroupRefund_h']")
    public static WebElement refundTitleGrp;

    @FindBy(xpath="//td[@class='front_tbl_lft']//tr//td[4]")
	public static List<WebElement> rowCount;

    @FindBy(xpath="//table[@class='frn_paytbl_fllist']//tr[4]//td[2]")
    public static WebElement invoiceText;

    @FindBy(xpath="//input[@name='BtnPaymentsDeletLedgerGr']")
	public static WebElement delPIGrp;

    @FindBy(xpath="(//td[@class='front_tbl_lft'])[2]//tr")
	public static List<WebElement> tbl_cnt;


    @FindBy(xpath="//input[@name='btnTaxExmptGR']")
    public static WebElement TaxExemptbtn;

    @FindBy(xpath="//div[@id='PanelEXemptTaxTrGR_h']")
    public static WebElement TaxExemptTitle;

    @FindBy(xpath="//select[@name='taxExmptReson']")
    public static WebElement TaxExemptReason;

    @FindBy(xpath="//table[@class='pnl_rates']//tr[2]//td[4]//input[2]")
    public static WebElement TECheckbox;

    @FindBy(xpath="//button[@id='txExmptSave-button']")
    public static WebElement TEBtn;

    @FindBy(xpath="//input[@name='chkshowAllgstId']")
    public static WebElement showAll;

    @FindBy(xpath="//table[@class='dont-print-me-hidden']//table//tr")
    public static List<WebElement> folioCount;

    @FindBy(xpath="//input[@name='ccChequeNo']")
    public static WebElement chequeNum;


    @FindBy(xpath="//table[@class='payment_total']//tr[8]//td[2]")
    public static WebElement totalBal;

    @FindBy(xpath="//input[@value='Check-out']")
	public static WebElement CheckOut_BT;

    @FindBy(xpath="//span[@class='lockfolio-img']")
	public  WebElement LockFolio_IMG;

    @FindBy(xpath="//span[@class='panel-link']")
    public static WebElement moreLink;

    @FindBy(xpath="//input[@id='txtRouteAmnt']")
    public static WebElement routeAmount;

	@FindBy(xpath="//a[@id='addNewAccountCode']")
	public static WebElement addnewaccnt;

	@FindBy(xpath="//input[@id='title']")
	public static WebElement acc_title;

	@FindBy(xpath="//input[@id='accountCode']")
	public static WebElement acc_code;

	@FindBy(xpath="//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only']")
	public static WebElement acc_savebtn;

	@FindBy(xpath="//div[@class='ui-dialog-buttonset']//button[2]")
	public static WebElement acc_cancelbtn;

	@FindBy(xpath="//select[@id='accountCodeId']")
	public static WebElement accountcode;

	@FindBy(xpath="(//td[@class='front_tbl_lft'])[2]//tr")
	public static List<WebElement> Discription_COUNT;

    @FindBy(xpath="//span[@class='closebtn']")
    public static WebElement closebtn;

	public static String ChequeNum;
// ------------------------------------------------------------------------------------------------------------//
	@FindBy(xpath="//td[contains(text(),'ACCOUNT STATEMENT')]")
	public WebElement Text_AccountStatement;
	
	@FindBy(xpath="//form/div/table/tbody/tr/td/table[3]/tbody/tr[3]/td/table/tbody/tr")
	public List<WebElement> Text_AccountRecords;
	
	@FindBy(xpath="//a[text()='Frontdesk']")
	public WebElement Link_Frontdesk;
	
	@FindBy(xpath="//ul/li[1]/div/div[1]/ul/li[4]/a")
	public WebElement Link_performNightAudit;
	
	
	
	@FindBy(xpath="//input[@id='btnCustomCharges']")
	public  WebElement Btn_CustomChargeBtn;
	
	@FindBy(xpath="//div[@id='PanelPaymentAddCustomCharges_h']/table/tbody/tr/td[1]")
	public WebElement Header_CustomChargeAllowance;
	
	@FindBy(xpath="//select[@id='selPOSGuest']")
	public WebElement DD_chargeToForCustomChargeAllowance;
	
	@FindBy(xpath="//select[@id='selPOS']")
	public  WebElement DD_POSDropdownInCustomChargeAllowance;
	
	@FindBy(xpath="//input[@id='ocTxtProduct']")
	public  WebElement TxtBx_DescriptionForCustomChargeAllowance;
	
	@FindBy(xpath="//input[@id='price']")
	public  WebElement TxtBx_PriceForCustomChargeAllowance;
	
	@FindBy(xpath="//input[@id='ocTxtQuantity']")
	public WebElement TxtBx_QuantityForCustomCharge;
	
	@FindBy(xpath="//input[@name='ocTxtDiscount']")
	public  WebElement Txtbx_discountForCustomCharge;
	
	@FindBy(xpath="//input[@id='discountTypePer']")
	public WebElement RB_TaxPercentageForCustomChargeAllowance;
	
	@FindBy(xpath="//input[@id='discountTypeFix']")
	public WebElement RB_TaxFixForCustomChargeAllowance;
	
	@FindBy(xpath="//button[@id='ocBtnSave-button']")
	public WebElement Btn_SaveCustomChargeAllowance;
	
	@FindBy(xpath="//input[@id='btnAddNewCharges']")
	public  WebElement Btn_OtherCharges;
	
	@FindBy(xpath="//div[@id='PanelPaymentAddNewCharges_h']/table/tbody/tr/td[1]")
	public WebElement Header_OtherCharges;
	
	@FindBy(xpath="//select[@id='selPOSGuest']")
	public WebElement DD_chargeToForOtherCharges;
	
	@FindBy(xpath="//select[@id='selPOS']")
	public WebElement DD_POSPointOtherCharges;
	
	@FindBy(xpath="//select[@id='SelocTxtProduct']")
	public WebElement DD_ProductOtherCharges;
	
	@FindBy(xpath="//input[@id='ocTxtQuantity']")
	public WebElement Txtbx_QuantityOtherCharges;
	
	@FindBy(xpath="//button[@id='ocBtnSave-button']")
	public WebElement Btn_SaveOtherCharges;
	
	@FindBy(xpath="//span[text()='No Folio Generated.']")
	public WebElement Text_NoFolioExist;
	
	@FindBy(xpath="//a[contains(text(),'PI ')]")
	public WebElement Link_ToPerfomaInvoice;
	
	@FindBy(xpath="//input[@id='btnGenarateFolio']")
	public  WebElement Btn_GenerateFolio;
	
	@FindBy(xpath="//input[contains(@value,'PI')]")
	public WebElement CB_PI;
	
	@FindBy(xpath="//input[@id='BtnPaymentsDeletLedger']")
	public WebElement Btn_DeletePerfomaInvoice;
	
	@FindBy(xpath="//input[@name='checkbox6']")
	public WebElement CB_AccountPostingMasterCB;
	
	@FindBy(xpath="//input[@id='btnCreateNewFolio']")
	public WebElement Btn_RouteToNewFolio;
	
	@FindBy(xpath="//input[starts-with(@id,'chkboxMail_')]")
	public List<WebElement> CB_GeneratedFolio;
	
	@FindBy(xpath="//div[@id='PanelSingleCreateNewFolio_h']")
	public WebElement HeaderTxt_CreateNewFolio;
	
	
	
	@FindBy(xpath="//button[@id='newFolioCreate-button']")
	public WebElement Btn_CreateNewFolio;
	
	@FindBy(xpath="//button[@id='newFolioCancel-button']")
	public WebElement Btn_CloseCreateNewFolioPopup;
	
	@FindBy(xpath="//a[@class='container-close']")
	public WebElement Link_CloseCreateNewFolioPopup;
	
	@FindBy(xpath="//form/div/table/tbody/tr/td/table[3]/tbody/tr[3]/td/table/tbody/tr")
	public List<WebElement> AllAccountStatement_row;
	
	@FindBy(xpath="//div[@id='PanelRouteTr_h']")
	public WebElement Header_routeChargesTitle;
	
	@FindBy(xpath="//input[@id='btnTransactionRoute']")
	public  WebElement Btn_RouteCharges;
	
	@FindBy(xpath="//select[@id='selGuestIds']")
	public WebElement DD_guestToRouteCharge;
	
	@FindBy(xpath="//select[@id='selGuestIds']")
	public WebElement DD_NewFolioToGuest;
	
	@FindBy(xpath="//button[@id='routeGoSave-button']")
    public  WebElement Btn_Route;
	
	@FindBy(xpath="//table[starts-with(@id,'flListTable_')]//tr")
	public List<WebElement> All_folio; 
	
	@FindBy(xpath="//select[@id='payTypesMode']")
	public WebElement DD_PayMode;
	
	@FindBy(xpath="//input[@id='btnPaymentPayNow']")
	public WebElement Btn_PayNow;
	
	@FindBy(xpath="//form/div/table/tbody/tr/td/table[3]/tbody/tr[3]/td/table/tbody/tr")
	public List<WebElement> All_PostedItemInAccountStatement;
	
	@FindBy(xpath="//input[@id='btnRoutePay']")
	public WebElement Btn_RoutePayment;
	
	 @FindBy(xpath="//div[@id='PanelRouteGroupPay_h']")
	 public WebElement Header_routePaymentTitle;
	 
	 @FindBy(xpath="//button[@id='routePayGoSave-button']")
	 public  WebElement Btn_routePaymentSave;
	 
	 @FindBy(xpath="//input[@name='btnRefundTransaction']")
	 public  WebElement Btn_Refund;
	 
	 @FindBy(xpath="//div[@id='PanelSingleRefund_h']")
	 public  WebElement Header_refundTitle;
	 
	 @FindBy(xpath="//button[@id='refundDone-button']")
	 public WebElement Btn_innerRefund;
	 
	 @FindBy(xpath="//input[@name='btnSettleFolio']")
	 public  WebElement Btn_settleFolio;
     
     @FindBy(xpath="//table[@class='payment_total']/tbody/tr[8]/td[2]")
     public WebElement Text_BalanceAmtInAcc;
     
     @FindBy(xpath="//select[@id='payTypes']")
     public WebElement DD_PayType;
     
     @FindBy(xpath="//input[@id='ccChequeNo']")
     public WebElement TxtBx_ChequeNumber;
     
     @FindBy(xpath="//input[@id='receiptNo']")
     public WebElement TxtBx_ReceiptNo;
     
     @FindBy(xpath="//input[@id='description']")
     public WebElement TxtBx_Description;
     
     @FindBy(xpath="//table[contains(@id,'flListTable_')]/tbody/tr[4]/td[6]")
     public WebElement Text_BalanceAmtInFolio;
     
     @FindBy(xpath="//table[contains(@id,'flListTable_')]/tbody/tr[4]/td[7]/span")
     public WebElement Btn_FolioLock;
     
     @FindBy(xpath="//a[starts-with(text(),'INV')]")
     public WebElement Link_InvoiceNumber;
     
     @FindBy(xpath="//td[starts-with(text(),'Seasonal Rate')]")
     public WebElement Txt_RateType;
     
  
     
     
     
     
     
	 
	public String gNameforFolio;
	public String routedGuest;
	public String selValue;
	
	

	
public WebElement fn_checkPosFolio(String folioNumToSearch){
	WebElement ele=null;
try{
 ele=GenericMethods.driver.findElement(By.xpath("//a[text()='"+folioNumToSearch+"'"));	
}
catch(Exception e){
	
}
return ele ;
}
	
public void fn_verifyFolioAndRateType(String fnum,String rateType) throws Exception{
try{
Thread.sleep(2000);	
String RateType=GenericMethods.driver.findElement(By.partialLinkText("Seasonal Rate")).getText().trim();	
Thread.sleep(2000);	
String Fnum=GenericMethods.driver.findElement(By.linkText(fnum)).getText().trim();
Thread.sleep(2000);
Assert.assertTrue(Fnum.equals(fnum));
Thread.sleep(2000);
Assert.assertTrue(RateType.startsWith(rateType));
}
catch(Exception e){
	throw e;
}
}
	
	
	
public void fn_doPaymentUsingCheque(int iTestCaseRow) throws Exception{
try{
Thread.sleep(2000);
GenericMethods.selectElement(DD_PayMode, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PayMode)));
Thread.sleep(1000);
GenericMethods.selectElement(DD_PayType, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PayType)));
Thread.sleep(1000);
GenericMethods.sendKeys(TxtBx_ChequeNumber, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ChequeNumber)));
Thread.sleep(1000);
GenericMethods.sendKeys(TxtBx_ReceiptNo, GenericMethods.generateRandomnum());
Thread.sleep(1000);
GenericMethods.sendKeys(TxtBx_Description, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Description)));
Thread.sleep(1000);
GenericMethods.clickElement(Btn_PayNow);	
	
}
catch(Exception e){
throw e;
}
}
	
	
public float fn_getChargeForPostedItem() throws Exception{
	float tamt=0.0f;
try{
	int size=AllAccountStatement_row.size();
	System.out.println(size);
	for(int i=2;i<=AllAccountStatement_row.size()-2;i=+2){
		
		
		String text=GenericMethods.driver.findElement(By.xpath("//form/div/table/tbody/tr/td/table[3]/tbody/tr[3]/td/table/tbody/tr["+size+"]/td[9]")).getText().trim();
			
			
			System.out.println("--------------------price"+text);
			
			if((text.contains(",")==true) & (text.contains(".")==true)==true){
				  
				
				
				
			
				String main []=text.split("\\.");
			String	SubMain []=main[0].toString().split("\\,");
			String inner[]=SubMain[0].split("\\s");
			
			String  whole=(inner[1] + SubMain[1] + "." + main[1]).toString();
			System.out.println(whole);
				 tamt=Float.parseFloat(whole);
				 
				
				break;
				
			}
			else if(text.contains(".")==true){
				String main []=text.split("\\.");
				String submain[]=main[0].split("\\s");
				String whole=(submain[1]+"."+main[1] ).toString();
				
				System.out.println(whole);
				 tamt=Float.parseFloat(whole);
				
				System.out.println(text);
				break;
			}
			
			
}
		
	
}
catch(Exception e){
	throw e;
}
return 0.0f;
}
	
	
public float fn_getTotalAmountfromAccountStatement() throws Exception{
	float tamt=0.0f;
try{
	int size=AllAccountStatement_row.size();
	System.out.println(size);
	for(int i=2;i<=AllAccountStatement_row.size()-2;i=+2){
		
		
		String text=GenericMethods.driver.findElement(By.xpath("//form/div/table/tbody/tr/td/table[3]/tbody/tr[3]/td/table/tbody/tr["+size+"]/td[9]")).getText().trim();
			
			
			System.out.println("--------------------price"+text);
			
			if((text.contains(",")==true) & (text.contains(".")==true)==true){
				  
				
				
				
			
				String main []=text.split("\\.");
			String	SubMain []=main[0].toString().split("\\,");
			String inner[]=SubMain[0].split("\\s");
			
			String  whole=(inner[1] + SubMain[1] + "." + main[1]).toString();
			System.out.println(whole);
				 tamt=Float.parseFloat(whole);
				 
				
				break;
				
			}
			else if(text.contains(".")==true){
				String main []=text.split("\\.");
				String submain[]=main[0].split("\\s");
				String whole=(submain[1]+"."+main[1] ).toString();
				
				System.out.println(whole);
				 tamt=Float.parseFloat(whole);
				
				System.out.println(text);
				break;
			}
			
			
}
		
		
		
	}
	catch(Exception e){
		throw e;
	}
	
	return tamt;
}
	
public float fn_verifyRoutedPayment(String pi) throws Exception {

	float Rate=0.0f;
	try{
	for(int i=4;i<=All_folio.size()-1;i++){
		String PI=GenericMethods.driver.findElement(By.xpath("//table[starts-with(@id,'flListTable_')]//tr["+i+"]/td[2]/a")).getText();
		if(PI.equals(pi)){
			String rate1=GenericMethods.driver.findElement(By.xpath("//table[starts-with(@id,'flListTable_')]//tr["+i+"]/td[5]")).getText();
			Rate=Float.parseFloat(rate1);
			break;
	}
	}
	}
	catch(Exception e){
	throw e;
	}
	return Rate;
	}	

	

		

	
	
	
	
public String fn_routePayment(int iTestCaseRow ,int index) throws Exception{
try{
	
	
	String text1=GenericMethods.driver.findElement(By.xpath("//form/div/table/tbody/tr/td/table[3]/tbody/tr[3]/td/table/tbody/tr[2]/td[4]")).getText().trim();
	
for(int i=2;i<=All_PostedItemInAccountStatement.size()-2;i=+2){
	
	
	All_PostedItemInAccountStatement=GenericMethods.driver.findElements(By.xpath("//form/div/table/tbody/tr/td/table[3]/tbody/tr[3]/td/table/tbody/tr"));
    Thread.sleep(2000);
	
			String text=GenericMethods.driver.findElement(By.xpath("//form/div/table/tbody/tr/td/table[3]/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[4]")).getText().trim();

	if(text.startsWith("Paid by")){
	GenericMethods.driver.findElement(By.xpath("//form/div/table/tbody/tr/td/table[3]/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[2]/input")).click();
	Thread.sleep(2000);
	GenericMethods.clickElement(Btn_RoutePayment);
	Thread.sleep(2000);
	Assert.assertEquals(GenericMethods.getText(Header_routePaymentTitle).trim(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult3)).trim(), "Matched");
	Thread.sleep(2000);
	selValue=GenericMethods.selectValueFromDropdownUsingIndex(GenericMethods.driver.findElement(By.xpath("//select[@id='selGuestIds']")), index);
	GenericMethods.clickElement(Btn_routePaymentSave);
	
	break;
	
	
}
}

	
	
	
}
catch(Exception e){
	throw e;
}
return selValue;
}
	
public void doPayment(String mode) throws Exception{
try{
GenericMethods.selectElement(DD_PayMode, mode);	
Thread.sleep(2000);
GenericMethods.clickElement(Btn_PayNow);
}
catch(Exception e){
throw e;
}
}
	
	
public float VerifyRoutedCharge(String pi) throws Exception{
float Rate=0.0f;
try{
for(int i=4;i<=All_folio.size()-1;i++){
	String PI=GenericMethods.driver.findElement(By.xpath("//table[starts-with(@id,'flListTable_')]//tr["+i+"]/td[2]/a")).getText();
	if(PI.equals(pi)){
		String rate=GenericMethods.driver.findElement(By.xpath("//table[starts-with(@id,'flListTable_')]//tr["+i+"]/td[4]")).getText();
		Rate=Float.parseFloat(rate);
		
}
}
}
catch(Exception e){
throw e;
}
return Rate;
}
	
	
	
public String fn_getPI(String text) throws Exception{
	String piNum=null;
try{
piNum=text.substring(text.indexOf("(")+1, text.indexOf(")"));	
}
catch(Exception e){
throw e;
}

return piNum;
}
	
	
	
public String fn_routeCharges(int index) throws Exception{
	try{
routedGuest=GenericMethods.selectValueFromDropdownUsingIndex(DD_guestToRouteCharge, index);	
GenericMethods.clickElement(Btn_Route);

}
catch(Exception e){
throw e;
}

return routedGuest;
	
}
	
public float fn_getTotalPostedItemRatefromAccountStatement() throws Exception{
	float res=0.0f;
try{
	int size=AllAccountStatement_row.size();
	String rate=GenericMethods.driver.findElement(By.xpath("//form/div/table/tbody/tr/td/table[3]/tbody/tr[3]/td/table/tbody/tr["+size+"]/td[7]")).getText();
	String rate1=rate.substring(2, rate.length()).trim();
	System.out.println(rate1);
	String tax=GenericMethods.driver.findElement(By.xpath("//form/div/table/tbody/tr/td/table[3]/tbody/tr[3]/td/table/tbody/tr["+size+"]/td[8]")).getText();
    String tax1=tax.substring(2, tax.length()).trim();
	System.out.println(tax1);
	float Rate=Float.parseFloat(rate1);
	System.out.println(Rate);
	float Tax= Float.parseFloat(tax1);
	System.out.println(Tax);
	 res=Rate+Tax;
}
catch(Exception e){
	throw e;
}

return res;
	
}
	
public void fn_createNewFolio(int index) throws Exception{
try{
Thread.sleep(2000);
gNameforFolio=GenericMethods.selectValueFromDropdownUsingIndex(DD_NewFolioToGuest, index);
Thread.sleep(2000);
GenericMethods.clickElement(Btn_CreateNewFolio);
}
catch(Exception e){
	throw e;
}
	
}
	
	
public String VerifyOtherCharges(String str) throws Exception {
String s=null;
try{
int size=Text_AccountRecords.size();
for(int i=2;i<=size-2;i=i+2){
s=GenericMethods.driver.findElement(By.xpath("//form/div/table/tbody/tr/td/table[3]/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[4]/a")).getText();
if(s.equals(str)){
System.out.println(s + " Other Charge added ");
break;
}

	}
}
catch(Exception e){
throw e;	
}
return s;

	}
	
public void AddOtherCharge(int iTestCaseRow) throws Exception{
try{
GenericMethods.selectElement(DD_chargeToForOtherCharges, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ChargesTo)));	
Thread.sleep(2000);
GenericMethods.selectElement(DD_POSPointOtherCharges, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PosPoint)));	
Thread.sleep(2000);
selProduct=GenericMethods.selectValueFromDropdownUsingIndex(DD_ProductOtherCharges,1);
Thread.sleep(2000);
GenericMethods.js_Sendkey(TxtBx_QuantityForCustomCharge, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Quantity)));
Thread.sleep(2000);
GenericMethods.clickElement(Btn_SaveOtherCharges);
}
catch(Exception e){
throw e;
}

}
	
	
public String VerifyPostedCustomCharge(int iTestCaseRow) throws Exception{
	String item=null;
try{
	int size=Text_AccountRecords.size();
for(int i=2;i<=size-2;i=i+2){
item=GenericMethods.driver.findElement(By.xpath("//form/div/table/tbody/tr/td/table[3]/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[4]/a")).getText();
if(item.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Description)))){
	break;
	
}
}		
}
catch(Exception e){
throw e;
}
return item;
}
	
	
	
	
public void fn_addCustomCharges(int iTestCaseRow) throws Exception{
try{
GenericMethods.selectElement(DD_chargeToForCustomChargeAllowance, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ChargesTo)));
Thread.sleep(2000);
GenericMethods.selectElement(DD_POSDropdownInCustomChargeAllowance, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PosPoint)));
Thread.sleep(2000);
GenericMethods.sendKeys(TxtBx_DescriptionForCustomChargeAllowance, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Description)));	
Thread.sleep(2000);
GenericMethods.js_Sendkey(TxtBx_PriceForCustomChargeAllowance, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Price)));
Thread.sleep(2000);
GenericMethods.js_Sendkey(TxtBx_QuantityForCustomCharge, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Quantity)));
Thread.sleep(2000);
GenericMethods.clickElement(Btn_SaveCustomChargeAllowance);

}
catch(Exception e){
	throw e;
}
}
	
	
public void  VerifyRoomRateAndTax(String str) throws Exception{
try{
	int size=Text_AccountRecords.size();
for(int i=2;i<=size-2;i=i+2){
String text=GenericMethods.driver.findElement(By.xpath("//form/div/table/tbody/tr/td/table[3]/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[4]/a")).getText();
		if(text.startsWith(str)){
			postedRoomPrice=GenericMethods.driver.findElement(By.xpath("//form/div/table/tbody/tr/td/table[3]/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[7]")).getText();
			Thread.sleep(2000);
			postedRoomTax=GenericMethods.driver.findElement(By.xpath("//form/div/table/tbody/tr/td/table[3]/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[8]")).getText();
			break;
			
}
		
}
		
}
catch(Exception e){
throw e;
}
}
	
	
	
	
	
	
	
	
public ContinueNightAuditPage ClickOnPerformNightAudit() throws Exception{
try{
GenericMethods.mouseOverElement(Link_Frontdesk);
Thread.sleep(2000);
GenericMethods.clickElement(Link_performNightAudit);
}
catch(Exception e){
throw e;
}
ContinueNightAuditPage CNA=PageFactory.initElements(GenericMethods.driver, ContinueNightAuditPage.class);
return CNA;
	
}
	
public String getFolioNumberfromAccountNumber(String folioNum) throws Exception{
	String fnum=null;
try{
	int size=Text_AccountRecords.size()-1;
	for(int i=2;i<=size;i=+2){
		
		Thread.sleep(2000);
		
		fnum=GenericMethods.driver.findElement(By.xpath("//form/div/table/tbody/tr/td/table[3]/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[4]/span/a")).getText();
	    Thread.sleep(2000);
	    if(fnum.equals(folioNum)){
		Assert.assertEquals(fnum, folioNum);
	    break;
	    }
	}
}
catch(Exception e){
throw e;
}
return fnum;
}
	
	
	
	
	
	
	
	
	
	
public void fn_consolidateAccount(String popHandle) throws Exception
	{
		try
		{
		
		GenericMethods.clickElement(ConsolidateAccountBtn);
		GenericMethods.ActionOnAlert(popHandle);
		
		}
		
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	
	
	

	public void VerifyPaymentPage() throws Exception
	{
		try
		{
		String pp=GenericMethods.getText(PaymentPage);
		Assert.assertEquals("ACCOUNT STATEMENT", pp);

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


	public void clk_ConsolidateBtn() throws Exception
	{
		try
		{
			Thread.sleep(4000);
		GenericMethods.clickElement(ConsolidateAccountBtn);
		GenericMethods.Alert_Accept();
		}
		catch(Exception e)
		{
			throw e;
		}
	}


	public FrontdeskLandingPage fn_clkConsolidateBtn() throws Exception
	{
		GenericMethods.clickElement(ConsolidateAccountBtn);
		GenericMethods.ActionOnAlert("Accept");
		GenericMethods.clickElement(closebtn);
		FrontdeskLandingPage FLP=PageFactory.initElements(GenericMethods.driver, FrontdeskLandingPage.class);
		return FLP;

	}


	public void verifyAlert_ConsolidateBtnAccept() throws Exception
	{
		try
		{
		GenericMethods.clickElement(ConsolidateAccountBtn);
		String str=GenericMethods.ActionOnAlert("Accept");
		Assert.assertEquals(str, exp_msg);
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

public void VerifyAlertForConsolidateAccount() throws Exception{
	GenericMethods.clickElement(ConsolidateAccountBtn);
	GenericMethods.ActionOnAlert("Dismiss");
	String a=GenericMethods.value;
	System.out.println(a);
    System.out.println(exp_msg);
	int trueLen=a.length();
	int expLen=exp_msg.length();
	Assert.assertEquals(trueLen,expLen);
	Assert.assertEquals(a, exp_msg);
}

public void VerifyTransferedItem(String id,String Producttax) throws Exception
{
	try
	{
	//GenericMethods.clickElement(ConsolidateAccountBtn);
	//GenericMethods.Alert_Accept();
	Thread.sleep(2000);
	String fid=id.trim();
	Thread.sleep(2000);
	int size=GenericMethods.tr_count(tbl_cnt);
	Thread.sleep(2000);
	int count=size-2;
	Thread.sleep(2000);
	for(int i=count;i>=2;i-=2)
	{
		//System.out.println(i);
		//Thread.sleep(2000);
		String fNum=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[4]")).getText().trim();
		//Thread.sleep(2000);

		if(fNum.contains(fid))
		{
			Thread.sleep(2000);
			Assert.assertTrue(fNum.contains(fid));
			System.out.println(fid + " Folio number Posted to account statement");
			String tax=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[8]")).getText();
            Assert.assertEquals(tax, Producttax);
            break;
		}
	}
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

public void VerifyRoomTaxOnAccountStatement() throws InterruptedException{
	String a=GenericMethods.getText(RoomTax).trim();
	int size=GenericMethods.tr_count(AllThePostedItemToAccount)+2;
	for(int i=2;i<=size;i+=2){
		String tax=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[8]")).getText().trim();
		if(tax.equals(a)){
			System.out.println(tax + "  POSTED IN account section");
			break;

		}
	}

}


public void VerifyTransferedItemTax(String folioNum) throws Exception{
	GenericMethods.clickElement(ConsolidateAccountBtn);
	GenericMethods.ActionOnAlert("Accept");
	Thread.sleep(9000);
	String ftax=folioNum.trim();
	int size=GenericMethods.tr_count(tbl_cnt);
	int count=size-2;
	for(int i=count;i>=2;i-=2){
		//System.out.println(i);
		String fNum=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[4]//span//a")).getText().trim();
		if(fNum.equals(OrderFolioPage.folioId.trim()))
		{
			System.out.println(ftax + " Folio tax Posted to account statement");
			String Tax= GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[8]")).getText();
			Assert.assertEquals(Tax, OrderFolioPage.folioTax);

			break;
		}
	}
}
/*public void ClickToCustomCharge() throws Exception
{
	try
	{
	GenericMethods.clickElement(Btn_CustomChargeBtn);
	Assert.assertEquals(GenericMethods.getText(CustomChargeAllowanceTitle), "Custom Charge/Allowance");
	//GenericMethods.clickElement(CloseBtnOnPopUp);
	}
	catch(Exception e)
	{
		throw e;
	}
	catch(AssertionError e)
	{
		throw e;
	}
}*/




public void AddCustomCharge() throws Exception{
try{
		
		
		
		
	/*//GenericMethods.clickElement(CustomChargeBtn);
	Select s=new Select(DD_POSDropdownInCustomChargeAllowance);
	s.selectByVisibleText("Sample Restaurant");
	Thread.sleep(2000);
	GenericMethods.sendKeys(TxtBx_DescriptionForCustomChargeAllowance,AccountStatementLandingPage.CustomChargeDescription);
	Thread.sleep(2000);
	String ex=Keys.chord(Keys.CONTROL,"a");
	Thread.sleep(2000);
	GenericMethods.sendKeys(TxtBx_PriceForCustomChargeAllowance, ex);
	Thread.sleep(2000);
	TxtBx_PriceForCustomChargeAllowance.sendKeys(priceForCustomCharge);
	Thread.sleep(2000);
	GenericMethods.sendKeys(QuantityForCustomCharge,ex);
	Thread.sleep(2000);
	QuantityForCustomCharge.sendKeys(quantityForCustomCharge);
	Thread.sleep(2000);
	GenericMethods.clickElement(SaveCustomCharge);*/
	}
	catch(Exception e)
	{
		throw e;
	}
	
}


public void verifyAddedCustomCharge() throws Exception
{
	try
	{
	int size=GenericMethods.tr_count(AllThePostedItemToAccount)+2;
	for(int i=2;i<=size;i+=2){
		String s=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[4]//a")).getText();
		if(s.equals(AccountStatementLandingPage.CustomChargeDescription)){
			System.out.println(s + " Custom Charge added ");
			break;
		}
	}
	}
	catch(Exception e)
	{
		throw e;
	}
}








public void VerifyAlertForPIDeletion() throws Exception
{
	  GenericMethods.driver.findElement(By.xpath("//input[@id='chkboxMail_1']")).click();
	  GenericMethods.clickElement(DeletePerfomaInvoiceBtn);
	  GenericMethods.ActionOnAlert("Dismiss");
	  Assert.assertEquals(GenericMethods.value, "Do you wish to delete all Proforma Invoices?");
	}


public void fn_consolidateAcc() throws Exception
{
	try
	{
	String str1=GenericMethods.getText(booking_bal);
	GenericMethods.clickElement(ConsolidateAccountBtn);
	GenericMethods.ActionOnAlert("Accept");
	String str2=GenericMethods.getText(booking_bal);
	Assert.assertEquals(str1, str2);
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


public void fn_DeletePerformaInvoice() throws Exception
{
	try
	{
    GenericMethods.clickElement(generateFolioBtn);
    Thread.sleep(15000);
    GenericMethods.clickElement(delPerformaInvoice);
    String str=GenericMethods.ActionOnAlert("Accept");
    Assert.assertEquals(GenericMethods.value, "Do you wish to delete all Proforma Invoices?");
    String text=GenericMethods.getText(Nofolio);
    Assert.assertEquals(text, "No Folio Generated.");
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

public static String product;
public void fn_addOtherCharge() throws Exception
{
	try
	{
	GenericMethods.clickElement(otherCharges);
	Select sel=new Select(chargeTo);
	//sel.selectByVisibleText("Gaurav X");
	sel.selectByIndex(1);
	Select sel1=new Select(posPoint);
	//sel1.selectByVisibleText("Hlx_Restaurant");
	sel1.selectByIndex(1);
	Thread.sleep(3000);
	Select sel2=new Select(posProduct);
	//sel2.selectByVisibleText("Sample French Onion Soup");
	sel2.selectByIndex(1);
	product=sel2.getFirstSelectedOption().getText();
	//GenericMethods.sendKeys(discount, "2");
	Actions acobj= new Actions(GenericMethods.driver);
	//acobj.sendKeys(discount, Keys.chord(Keys.CONTROL, "a"), "2").build().perform() ;
	Thread.sleep(2000);
	GenericMethods.clickElement(saveOtherCharge);
	Thread.sleep(6000);
	}
	catch(Exception e)
	{
		throw e;
	}
}

public void fn_addOtherChargeGrp() throws Exception
{

	try
	{
		GenericMethods.clickElement(otherCharges1);
		Select sel=new Select(chargeToGrp);
		//sel.selectByVisibleText("price/C103");
		sel.selectByIndex(2);
		Select sel1=new Select(posPoint);
		//sel1.selectByVisibleText("Sample Restaurant");
		sel1.selectByIndex(1);
		Thread.sleep(3000);
		Select sel2=new Select(posProduct);
		//sel2.selectByVisibleText("Sample French Onion Soup");
		sel2.selectByIndex(1);
		product=sel2.getFirstSelectedOption().getText();
		Actions acobj= new Actions(GenericMethods.driver);
		//acobj.sendKeys(discount, Keys.chord(Keys.CONTROL, "a"), "2").build().perform() ;
		//GenericMethods.sendKeys(discount, "2");
		GenericMethods.clickElement(saveOtherCharge);
		Thread.sleep(3000);
	}
	catch(Exception e)
	{
		throw e;
	}
}


public void fn_addOtherChargeSetteFolio() throws Exception
{

	try
	{
		GenericMethods.clickElement(otherCharges1);
		Select sel=new Select(chargeToGrp);
		//sel.selectByVisibleText("fj/A105");
		sel.selectByIndex(2);
		Thread.sleep(3000);
		Select sel1=new Select(posPoint);
		//sel1.selectByVisibleText("Sample Restaurant");
		sel1.selectByIndex(1);
        Thread.sleep(4000);
		Select sel2=new Select(posProduct);
		//sel2.selectByVisibleText("Sample French Onion Soup");
		sel2.selectByIndex(1);
		Thread.sleep(4000);
		product=sel2.getFirstSelectedOption().getText();
	   // GenericMethods.sendKeys(discount, "2");
		Thread.sleep(4000);
	    GenericMethods.clickElement(saveOtherCharge);
		Thread.sleep(6000);
	}
	catch(Exception e)
	{
		throw e;
	}
}





public void fn_routeToNewFolio() throws Exception
{
	GenericMethods.clickElement(generateFolioBtn);
	Thread.sleep(15000);
	int count=GenericMethods.tr_count(chkboxCount);
    for(int i=2;i<=count;i+=2)
    {
    	String data=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[4]//a")).getText();
    	if(data.equals(product))
    	{
    		WebElement ele=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[2]"));
    		ele.click();
    		break;
    	}
    }
    GenericMethods.clickElement(routeToNewFolio);
    Thread.sleep(15000);


}



public void fn_routeToNewFolioGrp() throws Exception
{
	try
	{
	GenericMethods.clickElement(generateFolioBtn);
	Thread.sleep(15000);
	int count=GenericMethods.tr_count(tbl_cnt);
	int count1=count-2;
    for(int i=count1;i>=2;i-=2)
    {
    	String data=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[4]//a")).getText();
    	if(data.equals(product))
    	{
    		PINum=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[5]//a")).getText();
    		WebElement ele=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[2]//input"));
    		ele.click();
    		break;
    	}
    }
    GenericMethods.clickElement(routeToNewFolio);
    Thread.sleep(15000);
	}
	catch(Exception e)
	{
		throw e;
	}

}


public void fn_verifyRouteToNewFolio() throws Exception
{
	try
	{
	String text=GenericMethods.getText(createFolioTitle);
	Assert.assertEquals(text, "Create New Folio");
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


public void fn_verifyRouteToNewFolioGrp() throws Exception
{
	try
	{
	String text=GenericMethods.getText(createFolioTitleGrp);
	Assert.assertEquals(text, "Create New Folio");
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


public static String CustomCharge;




public void fn_addCustomChargesGrp() throws Exception
{
	try
	{
	GenericMethods.clickElement(customChrgGrp);
	Assert.assertEquals(GenericMethods.getText(Header_CustomChargeAllowance), "Custom Charge/Allowance");
    Select sel=new Select(chargeToGrp);
    //sel.selectByVisibleText("price/C103");
    sel.selectByIndex(2);
    Select sel1=new Select(posPoint);
   // sel1.selectByVisibleText("Sample Restaurant");
    sel1.selectByIndex(1);
    Thread.sleep(4000);
    CustomCharge=GenericMethods.generateRandomString();
    //description.click();
    GenericMethods.js_Sendkey(description, CustomCharge);
    Thread.sleep(4000);
    //price.clear();
    Actions acobj= new Actions(GenericMethods.driver);
	acobj.sendKeys(price, Keys.chord(Keys.CONTROL, "a"), "50").build().perform() ;
    //GenericMethods.sendKeys(price, "50");
   // discount.clear();
	Thread.sleep(4000);
	//acobj.sendKeys(discount, Keys.chord(Keys.CONTROL, "a"), "2").build().perform() ;
   // GenericMethods.sendKeys(discount, "2");
    GenericMethods.js_Click(saveOtherCharge);
    Thread.sleep(4000);
	}
	catch(Exception e)
	{
		throw e;
	}
}




public void fn_CustomChargetoNewFolio() throws Exception
{
	GenericMethods.js_Click(generateFolioBtn);
	Thread.sleep(25000);
	int count=GenericMethods.tr_count(tbl_cnt);
	int count1=count-2;
    for(int i=count1;i>=2;i-=2)
    {
    	String data=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[4]//a")).getText();
    	if(data.equals(CustomCharge))
    	{
    		WebElement ele=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[2]//input"));
    		ele.click();
    		break;
    	}
    }
    GenericMethods.clickElement(routeToNewFolio);
   // Thread.sleep(15000);

}

public static String routedGuestN;
public void fn_selectGuestIDToNewFolio() throws Exception
{
	Select sel=new Select(selGuestId);
	//sel.selectByVisibleText("Gaurav X (price/C102)");
	sel.selectByIndex(1);
	WebElement ele=sel.getFirstSelectedOption();
	String a=ele.getText();
	routedGuestN=a.substring(0, a.indexOf("(")).trim();
	GenericMethods.clickElement(createFolio);
	Thread.sleep(6000);
}






public void fn_selectGuestIDToNewFolioGrp() throws Exception
{
	try
	{
	Select sel=new Select(selGuestId);
	//sel.selectByVisibleText("Barkha Kapoor (price/C103)");
	sel.selectByIndex(1);
	GenericMethods.clickElement(createFolio);
	Thread.sleep(4000);
	}
	catch(Exception e)
	{
		throw e;
	}
}


public static String folioNum;
public static String PINum;
public void fn_RouteChargesGrp() throws Exception
{
	try
	{
		GenericMethods.clickElement(generateFolioBtn);
		Thread.sleep(15000);
		int count=GenericMethods.tr_count(tbl_cnt);
		int count1=count-2;
	    for(int i=count1;i>=2;i-=2)
	    {
	    	String data=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[4]//a")).getText();
	    	if(data.equals(product))
	    	{
	    		folioNum=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[4]//a[2]")).getText();
	    		PINum=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[5]//a")).getText();
	    		WebElement ele=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[2]//input"));
	    		GenericMethods.js_Click(ele);
	    		break;
	    	}
	    }
	    GenericMethods.clickElement(routeChargesbtn);
	}
	catch(Exception e)
	{
		throw e;
	}

}


public void fn_RouteCharges() throws Exception
{
	GenericMethods.js_Click(generateFolioBtn);
	Thread.sleep(25000);
	int count=GenericMethods.tr_count(tbl_cnt);
	int count1=count-2;
    for(int i=count1;i>=2;i-=2)
    {
    	String data=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[4]//a")).getText();
    	if(data.equals(CustomCharge))
    	{
    		WebElement ele=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[2]//input"));
    		ele.click();
    		break;
    	}
    }
    GenericMethods.clickElement(routeChargesbtn);
    Thread.sleep(15000);
}


public void fn_verifyRouteCharges() throws InterruptedException
{
	String text=null;
	try {
		text = GenericMethods.getText(Header_routeChargesTitle);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Assert.assertEquals(text, "Route Charges");

}

public void fn_verifyRCGrpTitle() throws Exception
{
	try
	{
	String text=GenericMethods.getText(RCGroup);
	Assert.assertEquals(text, "Route Charges");
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

public void fn_selectGuestIdRouteCharge() throws Exception
{
	Select sel=new Select(selGuestId);
	sel.selectByVisibleText("Gaurav X (PI 85)");
	GenericMethods.clickElement(Btn_Route);
	Thread.sleep(4000);
}



public void fn_selectGuestIDRouteCharge1() throws Exception
{
	//GenericMethods.clickElement(showAll);
	Select sel=new Select(selGuestId);
	List<WebElement> li=sel.getOptions();
	for(WebElement li1:li)
	{
		String PI=li1.getText();
		if(PI.contains(afterPI))
		{
			WebElement ele=GenericMethods.driver.findElement(By.xpath("//select[@name='selGuestIds']//option"));
			//GenericMethods.js_Click(ele);
			Actions actobj=new Actions(GenericMethods.driver);
			actobj.click(ele).build().perform();
			break;
		}
	}
	GenericMethods.clickElement(Btn_Route);
	Thread.sleep(4000);
}


public void fn_selectGuest2RouteCharge() throws Exception
{
	Select sel=new Select(selGuestId);
	List<WebElement> li=sel.getOptions();
	//li.size();
	for(int i=0;i<=li.size();i++)
	{
		String Guest2N=li.get(i).getText();
		if(Guest2N.contains("David"))
		{
			li.get(i).click();
		//	WebElement ele=GenericMethods.driver.findElement(By.xpath("//select[@name='selGuestIds']//option["+i+"]"));
			//GenericMethods.js_Click(ele);
//			Actions actobj=new Actions(GenericMethods.driver);
//			actobj.click(ele).build().perform();
			Thread.sleep(3000);
			break;
		}
	}
	GenericMethods.clickElement(Btn_Route);
	Thread.sleep(12000);
}



public void fn_selectGuestIdRouteChargeGrp() throws Exception
{
	GenericMethods.clickElement(showAll);
	Select sel=new Select(selGuestId);
	List<WebElement> li=sel.getOptions();
	for(WebElement li1:li)
	{
		String PI=li1.getText();
		if(PI.contains(PINum))
		{
			WebElement ele=GenericMethods.driver.findElement(By.xpath("//select[@name='selGuestIds']//option"));
			//GenericMethods.js_Click(ele);
			Actions actobj=new Actions(GenericMethods.driver);
			actobj.click(ele).build().perform();

			break;
		}
	}
	GenericMethods.clickElement(Btn_Route);
	Thread.sleep(4000);
}

public static String RouteToPI;
public void fn_selectGuest2RouteChargeGrp() throws Exception
{
	try
	{
	Thread.sleep(3000);
	GenericMethods.clickElement(showAll);
	Thread.sleep(2000);
	Select sel=new Select(selGuestId);
	List<WebElement> li=sel.getOptions();
	for(int i=0;i<=li.size();i++)
	{
		String Guest2N=li.get(i).getText();
		int a=Guest2N.indexOf("(");
		RouteToPI=Guest2N.substring(a+1,Guest2N.indexOf(")"));
		if(Guest2N.contains("Richard"))
		{
			li.get(i).click();
			//WebElement ele=GenericMethods.driver.findElement(By.xpath("//select[@name='selGuestIds']//option"));
			//GenericMethods.js_Click(ele);
			//Actions actobj=new Actions(GenericMethods.driver);
			//actobj.click(ele).build().perform();
            Thread.sleep(3000);
			break;
		}
	}
	GenericMethods.js_Click(Btn_Route);
	Thread.sleep(4000);
	}
	catch(Exception e)
	{
		throw e;
	}
}

public ReservationFolioPage fn_verifyRoutedOtherChrgeG2Grp() throws Exception
{
	try
	{
    int count1=GenericMethods.tr_count(folioCount);
    if(count1>=10)
    {
        GenericMethods.js_Click(moreLink);
        for(int i=4;i<=count1;i++)
        {
        	String actual=GenericMethods.driver.findElement(By.xpath("//table[@class='dont-print-me-hidden']//table//tr["+i+"]")).getText();
        	if(actual.contains("Richard") && actual.contains(RouteToPI))
        	{
        	  WebElement ele=GenericMethods.driver.findElement(By.xpath("//table[@class='dont-print-me-hidden']//table//tr["+i+"]//td[2]"));
        	  ele.click();

        	  //System.out.println("Charges has been successfully routed to the selected guest ID.");
        	  //Assert.assertEquals(actual, afterPI);
        	  break;
        	}
        	else
        		if(actual.contains("Group Owner")||actual.contains("Room Type"))
        		{
        			System.out.println("Header row is being displayed");
        		}
        		else

                	if(actual.contains("Richard") && actual.contains(RouteToPI))
                	{
                	  WebElement ele=GenericMethods.driver.findElement(By.xpath("//table[@class='dont-print-me-hidden']//table//tr["+i+"]//td[2]"));
                	  ele.click();

                	  //System.out.println("Charges has been successfully routed to the selected guest ID.");
                	  //Assert.assertEquals(actual, afterPI);
                	  break;
                	}
        }

    }

    else
    {
    	for(int i=4;i<=count1;i++)
        {
        	String actual=GenericMethods.driver.findElement(By.xpath("//table[@class='dont-print-me-hidden']//table//tr["+i+"]")).getText();
        	if(actual.contains("Group Owner")||actual.contains("Room Type"))

        	{
        		System.out.println("Header row is being displayed");
        	}

        	else

        	if(actual.contains("Richard"))
        	{
        	  WebElement ele=GenericMethods.driver.findElement(By.xpath("//table[@class='dont-print-me-hidden']//table//tr["+i+"]//td[2]"));
        	  ele.click();

        	  //System.out.println("Charges has been successfully routed to the selected guest ID.");
        	  //Assert.assertEquals(actual, afterPI);
        	  break;
        	}
        }

    }
      ReservationFolioPage RFP=PageFactory.initElements(GenericMethods.driver, ReservationFolioPage.class);
      return RFP;
	}
	catch(Exception e)
	{
		throw e;
	}

}




public void fn_CustomChargetoNewFolio1() throws Exception
{
	GenericMethods.clickElement(generateFolioBtn);
	Thread.sleep(15000);
	int count=GenericMethods.tr_count(tbl_cnt);
	int count2=count-2;
    for(int i=count2;i>=2;i-=2)
    {
    	String str=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[4]//a")).getText();
    	//li.add(ele.getText());
    	if(str.contains(CustomCharge))
    	{
    		WebElement ele1=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[2]//input"));
    		ele1.click();
    		break;
    	}
    }

    GenericMethods.clickElement(routeToNewFolio);
    Thread.sleep(15000);

}


public static String amt="50";
public void fn_clkPayNow() throws Exception
{
    Select sel=new Select(DD_PayMode);
    sel.selectByValue("cash");
    //Select sel1=new Select(paymentTypes);
    //sel1.selectByValue("");
    Actions acobj= new Actions(GenericMethods.driver);
	acobj.sendKeys(amount, Keys.chord(Keys.CONTROL, "a"), amt).build().perform() ;
	//amt=GenericMethods.getText(amount);
	GenericMethods.js_Click(Btn_PayNow);
	Thread.sleep(6000);
}


public static String amt1="1.00";
public void fn_clkPayNowGrp() throws Exception
{
	try
	{
    Select sel=new Select(DD_PayMode);
    sel.selectByValue("cash");
    //Select sel1=new Select(paymentTypes);
    //sel1.selectByValue("");
    Actions acobj= new Actions(GenericMethods.driver);
	acobj.sendKeys(amount, Keys.chord(Keys.CONTROL, "a"), amt1).build().perform() ;
	//amt=GenericMethods.getText(amount);
	GenericMethods.js_Click(Btn_PayNow);
	Thread.sleep(3000);
	}
	catch(Exception e)
	{
		throw e;
	}
}

public static String num=GenericMethods.generateRandomnum();
public void fn_payNowCheque() throws Exception
{

	try
	{
	    Select sel=new Select(DD_PayMode);
	   // sel.selectByValue("cheque");
	    sel.selectByIndex(2);
	    Thread.sleep(4000);
	    Select sel1=new Select(DD_PayType);
	    //sel1.selectByVisibleText("Cheque1");
	    sel1.selectByIndex(1);
	    Thread.sleep(4000);
	    Actions acobj= new Actions(GenericMethods.driver);
		acobj.sendKeys(amount, Keys.chord(Keys.CONTROL, "a"), amt1).build().perform() ;
		Thread.sleep(4000);
		GenericMethods.js_Sendkey(chequeNum,num );
        Thread.sleep(3000);
		//amt=GenericMethods.getText(amount);
		GenericMethods.js_Click(Btn_PayNow);
		Thread.sleep(3000);
	}
	catch(Exception e)
	{
		throw e;
	}

}




public void fn_makeFullPayment() throws Exception
{
	try
	{
	Select sel=new Select(DD_PayMode);
    sel.selectByValue("cheque");
    Thread.sleep(4000);
    Select sel1=new Select(DD_PayType);
    //sel1.selectByVisibleText("Cheque1");
    sel1.selectByIndex(1);
    Thread.sleep(3000);
    GenericMethods.js_Sendkey(chequeNum, num);
    Thread.sleep(3000);
    GenericMethods.js_Click(Btn_PayNow);
	Thread.sleep(3000);
	}
	catch(Exception e)
	{
		throw e;
	}
}




public void fn_clkSettleFolio() throws Exception
{
   String balance=GenericMethods.getText(totalBal);
   if(balance!="Rs 0.00")
   {
	   fn_makeFullPayment();
	   Thread.sleep(3000);
	   GenericMethods.clickElement(Btn_settleFolio);
	   Thread.sleep(3000);
   }

   else
   {


    Thread.sleep(3000);

   }

}




public void fn_clkSettleFolioAccept() throws Exception
{
	try
	{
	String balance=GenericMethods.getText(totalBal);
	   if(balance!="Rs 0.00")
	   {
		   fn_makeFullPayment();
		   Thread.sleep(4000);
		   GenericMethods.clickElement(Btn_settleFolio);
		   String str=GenericMethods.ActionOnAlert("Accept");
		   Assert.assertEquals(str, "Do you wish to settle all folios?");
	   }

	   else
	   {

		   GenericMethods.clickElement(Btn_settleFolio);
		   String str=GenericMethods.ActionOnAlert("Accept");
		   Assert.assertEquals(str, "Do you wish to settle all folios?");

	   }
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


public void fn_verifyPaidAmt() throws Exception
{
	try
	{
	int count=GenericMethods.tr_count(chkboxCount);
    for(int i=2;i<=count;i+=2)
    {
    	String str1=GenericMethods.driver.findElement(By.xpath("(//table[@class='frn_paytbl'])[2]//tbody//tr["+i+"]//td[4]")).getText();
    	//li.add(str1);
    	if(str1.contains("with Cash"))
    	{
    		String str=GenericMethods.driver.findElement(By.xpath("(//table[@class='frn_paytbl'])[2]//tbody//tr["+i+"]//td[9]")).getText();
    		if(str.contains(amt1))
    		{
    		Assert.assertTrue(str.contains(amt1));
//    		WebElement ele1=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[2]"));
//    		ele1.click();
            System.out.println("Paid amount has been successfully posted in Account Statement.");
            break;
    		}

    	}
    }
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



public void fn_verifyPaidAmtChequeGrp() throws Exception{
	try{

	JavascriptExecutor jsx = (JavascriptExecutor)GenericMethods.driver;
	jsx.executeScript("scroll(0, -550)");
	int count=GenericMethods.tr_count(chkboxCount);
    for(int i=2;i<=count;i+=2)
    {

    	//Thread.sleep(3000);
    	String str1=GenericMethods.driver.findElement(By.xpath("(//table[@class='frn_paytbl'])[2]//tbody//tr["+i+"]//td[4]")).getText();
    	//li.add(str1);
    	if(str1.contains("with Cheque ("+num+")"))
    	{
    		String str=GenericMethods.driver.findElement(By.xpath("(//table[@class='frn_paytbl'])[2]//tbody//tr["+i+"]//td[9]")).getText();
    		if(str.contains(amt1))
    		{
    		Assert.assertTrue(str.contains(amt1));
//    		WebElement ele1=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[2]"));
//    		ele1.click();
            System.out.println("Amount paid by cheque has been successfully posted in Account Statement.");
            break;
    		}

    	}
    }
	}catch(Exception e){
		throw e;
	}

}



public void fn_clkRoutePayment1() throws Exception
{
	try
	{
	int count=GenericMethods.tr_count(chkboxCount);
    for(int i=2;i<=count;i+=2)
    {
    	String str1=GenericMethods.driver.findElement(By.xpath("(//table[@class='frn_paytbl'])[2]//tbody//tr["+i+"]//td[4]")).getText();
    	//li.add(str1);
    	if(str1.contains("Paid by "+routedGuestN+" with Cash"))
    	{
    		String str=GenericMethods.driver.findElement(By.xpath("(//table[@class='frn_paytbl'])[2]//tbody//tr["+i+"]//td[5]")).getText();

    		if(str.equalsIgnoreCase(""))
    		{
    			Assert.assertTrue(str.contains(""));
    		   String str2=GenericMethods.driver.findElement(By.xpath("(//table[@class='frn_paytbl'])[2]//tbody//tr["+i+"]//td[9]")).getText();
    		   //Assert.assertTrue(str.contains(amt));
    		   if(str2.contains(amt))
    		      {
    	             Assert.assertTrue(str2.contains(amt));
    		         WebElement ele1=GenericMethods.driver.findElement(By.xpath("(//table[@class='frn_paytbl'])[2]//tbody//tr["+i+"]//td[2]//input"));
    		         ele1.click();
    		         break;
    		      }
    		}
    	}
    }

    GenericMethods.clickElement(routePaymentBtn);
    Thread.sleep(10000);
	}
	catch(Exception e)
	{
		throw e;
	}

}



public static String str1Value;



public void fn_clkRoutePaymentGrp() throws Exception
{
	try
	{
	int count=GenericMethods.tr_count(chkboxCount);
	//int count1=count-2;
    for(int i=2;i<=count;i+=2)
    {
    	String str1=GenericMethods.driver.findElement(By.xpath("(//table[@class='frn_paytbl'])[2]//tbody//tr["+i+"]//td[4]")).getText();
    	//li.add(str1);
        String[] parts=str1.split(" ");
        str1Value=parts[2]+" "+parts[3];
    	if(str1.contains("Paid by "+str1Value+" with Cash"))
    	{
    		String str=GenericMethods.driver.findElement(By.xpath("(//table[@class='frn_paytbl'])[2]//tbody//tr["+i+"]//td[5]")).getText();
    		if(str.equalsIgnoreCase(""))
    		{
    		Assert.assertTrue(str.contains(""));
    		String str2=GenericMethods.driver.findElement(By.xpath("(//table[@class='frn_paytbl'])[2]//tbody//tr["+i+"]//td[9]")).getText();
    		if(str2.contains(amt1))
    		{
    		WebElement ele1=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[2]//input"));
    		ele1.click();
    		break;
    		}
    	}

    	}
    }

    GenericMethods.clickElement(routePaymentGrp);
    Thread.sleep(15000);
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



public void fn_verifyRoutePaymentTitle() throws Exception
{
	try
	{
	String text=GenericMethods.getText(Header_routePaymentTitle);
	Assert.assertEquals(text, "Route Payment");
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

public void fn_routePaymentSave() throws Exception
{
	try
	{
	Select sel=new Select(selGuestId);
	sel.selectByVisibleText("Gaurav X (PI 85)");
	GenericMethods.clickElement(Btn_routePaymentSave);
	Thread.sleep(4000);
	}
	catch(Exception e)
	{
		throw e;
	}
}


public void fn_selectGuest2RoutePayment() throws Exception
{
	try
	{
	Select sel=new Select(selGuestId);
	List<WebElement> li=sel.getOptions();
	//li.size();
	for(int i=0;i<=li.size();i++)
	{
		String Guest2N=li.get(i).getText();
		if(Guest2N.contains("David"))
		{
			li.get(i).click();
		//	WebElement ele=GenericMethods.driver.findElement(By.xpath("//select[@name='selGuestIds']//option["+i+"]"));
			//GenericMethods.js_Click(ele);
//			Actions actobj=new Actions(GenericMethods.driver);
//			actobj.click(ele).build().perform();
			Thread.sleep(3000);
			break;
		}
	}
	Actions acobj= new Actions(GenericMethods.driver);
	acobj.sendKeys(routeAmount, Keys.chord(Keys.CONTROL, "a"), "50.00").build().perform() ;
	GenericMethods.clickElement(Btn_routePaymentSave);
	Thread.sleep(4000);
	}
	catch(Exception e)
	{
		throw e;
	}
}

public ReservationFolioPage fn_verifyRoutedPaymentChrgeG2() throws Exception
{
	try
	{
	boolean value=moreLink.isDisplayed();
	if(value==true)
	{
    GenericMethods.js_Click(moreLink);
    int count=GenericMethods.tr_count(folioCount);
    for(int i=4;i<=count;i++)
    {
    	String actual=GenericMethods.driver.findElement(By.xpath("//table[@class='dont-print-me-hidden']//table//tr["+i+"]//td[3]")).getText();
    	if(actual.contains("David"))
    	{
    	  WebElement ele=GenericMethods.driver.findElement(By.xpath("//table[@class='dont-print-me-hidden']//table//tr["+i+"]//td[2]"));
    	  ele.click();

    	  //System.out.println("Charges has been successfully routed to the selected guest ID.");
    	  //Assert.assertEquals(actual, afterPI);
    	  break;
    	}
    }
	}
	else
	{
		 int count=GenericMethods.tr_count(folioCount);
		    for(int i=4;i<=count;i++)
		    {
		    	String actual=GenericMethods.driver.findElement(By.xpath("//table[@class='dont-print-me-hidden']//table//tr["+i+"]//td[3]")).getText();
		    	if(actual.contains("David"))
		    	{
		    	  WebElement ele=GenericMethods.driver.findElement(By.xpath("//table[@class='dont-print-me-hidden']//table//tr["+i+"]//td[2]"));
		    	  ele.click();

		    	  //System.out.println("Charges has been successfully routed to the selected guest ID.");
		    	  //Assert.assertEquals(actual, afterPI);
		    	  break;
		    	}
		    }
	}
	}
	catch(Exception e)
	{
		throw e;
	}
    ReservationFolioPage RFP=PageFactory.initElements(GenericMethods.driver, ReservationFolioPage.class);
    return RFP;

}


public void fn_routePaymentGrp() throws Exception
{
	try
	{
	Select sel=new Select(selGuestId);
	//sel.selectByVisibleText("Barkha Kapoor (PI 154)");
	List<WebElement> li=sel.getOptions();
	//li.size();
	for(int i=0;i<=li.size();i++)
	{
		String Guest2N=li.get(i).getText();
		String[] parts=Guest2N.split(" ");
		String a=parts[1]+" "+parts[2];
		if(!a.equals(str1Value))
		{
			li.get(i).click();
		//	WebElement ele=GenericMethods.driver.findElement(By.xpath("//select[@name='selGuestIds']//option["+i+"]"));
			//GenericMethods.js_Click(ele);
//			Actions actobj=new Actions(GenericMethods.driver);
//			actobj.click(ele).build().perform();
			Thread.sleep(3000);
			break;
		}
	}

	String selectedGuest=sel.getFirstSelectedOption().getText();
	GenericMethods.clickElement(Btn_routePaymentSave);
	Thread.sleep(10000);
	}
	catch(Exception e)
	{
		throw e;
	}
}


public ReservationFolioPage fn_clkFolio() throws Exception
{
	try
	{
	int count=GenericMethods.tr_count(folioCount);
	if(count>10)
	{
		GenericMethods.clickElement(moreLink);
		for(int i=4;i<=count;i++)
	    {
	    	String actual=GenericMethods.driver.findElement(By.xpath("//table[@class='dont-print-me-hidden']//table//tr["+i+"]")).getText();
	    	if(actual.contains(afterPI))
	    	{
	    	  WebElement ele=GenericMethods.driver.findElement(By.xpath("//table[@class='dont-print-me-hidden']//table//tr["+i+"]//td[3]"));
	    	  GenericMethods.js_Click(ele);
	    	  Thread.sleep(4000);
	    	  //Assert.assertEquals(actual, afterPI);
	    	  break;
	    	}
	    	else
	    		if(actual.contains("Group Owner")||actual.contains("Room Type"))
		    	{
		    		System.out.println("Header row is being displayed");
		    	}
	    		else
	    	    	if(actual.contains(afterPI))
	    	    	{
	    	    	  WebElement ele=GenericMethods.driver.findElement(By.xpath("//table[@class='dont-print-me-hidden']//table//tr["+i+"]//td[3]"));
	    	    	  GenericMethods.js_Click(ele);
	    	    	  Thread.sleep(4000);
	    	    	  //Assert.assertEquals(actual, afterPI);
	    	    	  break;
	    	    	}
	    }
	}

	else
	{
		for(int i=4;i<=count;i++)
	    {
	    	String actual=GenericMethods.driver.findElement(By.xpath("//table[@class='dont-print-me-hidden']//table//tr["+i+"]")).getText();
	    	if(actual.contains("Group Owner")||actual.contains("Room Type"))
	    	{
	    		System.out.println("Header row is being displayed");
	    	}
	    	else
	    	if(actual.contains(afterPI))
	    	{
	    	  WebElement ele=GenericMethods.driver.findElement(By.xpath("//table[@class='dont-print-me-hidden']//table//tr["+i+"]//td[3]"));
	    	  GenericMethods.js_Click(ele);
	    	  Thread.sleep(4000);
	    	  //Assert.assertEquals(actual, afterPI);
	    	  break;
	    	}
	    }
	}



    ReservationFolioPage RFP=PageFactory.initElements(GenericMethods.driver, ReservationFolioPage.class);
    return RFP;
	}
	catch(Exception e)
	{
		throw e;
	}
}

public ReservationFolioPage fn_verifyRoutedCustmChrgeG2() throws Exception
{
	boolean value=moreLink.isDisplayed();
	if(value==true)
	{
    GenericMethods.js_Click(moreLink);
    int count=GenericMethods.tr_count(folioCount);
    for(int i=4;i<=count;i++)
    {
    	String actual=GenericMethods.driver.findElement(By.xpath("//table[@class='dont-print-me-hidden']//table//tr["+i+"]//td[3]")).getText();
    	if(actual.contains("David"))
    	{
    	  WebElement ele=GenericMethods.driver.findElement(By.xpath("//table[@class='dont-print-me-hidden']//table//tr["+i+"]//td[2]"));
    	  ele.click();

    	  //System.out.println("Charges has been successfully routed to the selected guest ID.");
    	  //Assert.assertEquals(actual, afterPI);
    	  break;
    	}
    }
	}
	else
	{
		 int count=GenericMethods.tr_count(folioCount);
		    for(int i=4;i<=count;i++)
		    {
		    	String actual=GenericMethods.driver.findElement(By.xpath("//table[@class='dont-print-me-hidden']//table//tr["+i+"]//td[3]")).getText();
		    	if(actual.contains("David"))
		    	{
		    	  WebElement ele=GenericMethods.driver.findElement(By.xpath("//table[@class='dont-print-me-hidden']//table//tr["+i+"]//td[2]"));
		    	  ele.click();

		    	  //System.out.println("Charges has been successfully routed to the selected guest ID.");
		    	  //Assert.assertEquals(actual, afterPI);
		    	  break;
		    	}
		    }
	}
    ReservationFolioPage RFP=PageFactory.initElements(GenericMethods.driver, ReservationFolioPage.class);
    return RFP;

}




public void fn_LockFolio() throws Exception
{
	try
	{

		int size=folioCount.size();
		String text=folioCount.get(size-1).getText();
		//boolean value=moreLink.isDisplayed();
		if(text.contains("More >>"))
		{
			GenericMethods.clickElement(moreLink);
		}
	      int count=GenericMethods.tr_count(folioCount);

		Thread.sleep(3000);
		for(int i=3;i<=count;i++)
	    {
	    	String actual=GenericMethods.driver.findElement(By.xpath("//table[@class='dont-print-me-hidden']//table//tr["+i+"]")).getText();
	    	if(actual.contains(afterPI))
	    	{
	    		Assert.assertTrue(actual.contains(afterPI));
	    	  WebElement ele=GenericMethods.driver.findElement(By.xpath("//table[@class='dont-print-me-hidden']//table//tr["+i+"]//td[7]//span"));
	    	  GenericMethods.js_Click(ele);
	    	  Thread.sleep(4000);
	    	  String msg=GenericMethods.ActionOnAlert("Accept");
	    	  Assert.assertEquals(msg, "Do you wish to Close this Folio?");
	    	  //Assert.assertEquals(actual, afterPI);
	    	  break;
	    	}
	    }

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


public void fn_verifyLockFolioPopup() throws Exception
{
	try
	{
		Thread.sleep(3000);;
	String msg=GenericMethods.ActionOnAlert("Accept");
	Assert.assertEquals(msg, "Do you wish to Close this Folio?");
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


public void fn_verifyLockedFolio() throws Exception
{
	try
	{
	int size=folioCount.size();
	String text=folioCount.get(size-1).getText();
	if(text.contains("More >>"))
	{
		GenericMethods.clickElement(moreLink);
	}

	Thread.sleep(3000);
	int count=GenericMethods.tr_count(folioCount);


		for(int i=3;i<=count;i++)
	    {
	    	String actual=GenericMethods.driver.findElement(By.xpath("//table[@class='dont-print-me-hidden']//table//tr["+i+"]")).getText();
	    	if(actual.contains("INV"))
	    	{
//	    	  WebElement ele=GenericMethods.driver.findElement(By.xpath("//table[@class='dont-print-me-hidden']//table//tr["+i+"]//td[7]//span"));
//	    	  GenericMethods.js_Click(ele);
              Assert.assertTrue(actual.contains("INV"));
              String lockValue=GenericMethods.driver.findElement(By.xpath("//table[@class='dont-print-me-hidden']//table//tr["+i+"]//td[7]//span")).getAttribute("class");
              Assert.assertEquals(lockValue, "unlockfolio-img");
	    	  System.out.println("Settled folio has been successfully locked.");
	    	  //Assert.assertEquals(actual, afterPI);
	    	  break;
	    	}
	    }
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





public void fn_clkRefundBtn() throws Exception
{
	try
	{
	GenericMethods.clickElement(generateFolioBtn);
	Thread.sleep(15000);
	int count=GenericMethods.tr_count(tbl_cnt);
	int count2=count-2;
    for(int i=count2;i>=2;i-=2)
    {
    	String data=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[4]//a")).getText();
    	if(data.equals(CustomCharge))
    	{
    		WebElement ele=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[2]//input"));
    		ele.click();
    		break;
    	}
    }
    GenericMethods.clickElement(Btn_Refund);
	}
	catch(Exception e)
	{
		throw e;
	}
}


public void fn_clkRefundBtnGrp() throws Exception
{
	try
	{
	GenericMethods.clickElement(generateFolioBtn);
	Thread.sleep(15000);
	int count=GenericMethods.tr_count(tbl_cnt);
	int count1=count-2;
    for(int i=count1;i>=2;i-=2)
    {
    	String data=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[4]")).getText();
    	if(data.contains(CustomCharge))
    	{
    		WebElement ele=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[2]//input"));
    		ele.click();
    		break;
    	}
    }
    GenericMethods.clickElement(Btn_Refund);
    Thread.sleep(15000);
	}
	catch(Exception e)
	{
		throw e;
	}
}



public void fn_clkRefund() throws Exception
{
	try
	{
	GenericMethods.clickElement(Btn_Refund);
	Thread.sleep(5000);
	}
	catch(NoSuchElementException e)
	{
		Thread.sleep(2000);
		GenericMethods.js_Click(Btn_Refund);
	}
	catch(Exception e)
	{
		throw e;
	}
}




public void fn_verifyRefundTitle() throws Exception
{
	try
	{
	String text=GenericMethods.getText(refundTitleGrp);
	Assert.assertEquals(text, "Refund");
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




public void fn_verifyRefund() throws Exception
{
	try
	{
	int count=GenericMethods.tr_count(tbl_cnt);
	int count1=count-2;
    for(int i=count1;i>=2;i-=2)
    {
    	Thread.sleep(1000);
    	String data=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[4]")).getText();
    	if(data.contains("Refund for "+CustomCharge))
    	{
//    		String data1=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[2]"));
//    		ele.click();
//    		break;
    		System.out.println("Added custom charge has been successfully refunded.");
    		break;
    	}
    }
	}
	catch(Exception e)
	{
		throw e;
	}

}


public void fn_verifyRefundGrp() throws Exception
{
	try
	{
	int count=GenericMethods.tr_count(tbl_cnt);
	int count1=count-2;
    for(int i=count1;i>=2;i-=2)
    {
    	String data=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[4]")).getText();
    	if(data.contains("Refund for "+CustomCharge))
    	{
    		Assert.assertTrue(data.contains("Refund for "+CustomCharge));
//    		String data1=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[2]"));
//    		ele.click();
//    		break;
    		System.out.println("Added custom charge has been successfully refunded.");
    		break;
    	}
    }
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


public void fn_verifyAddedCustomCharge()
{
	int count=GenericMethods.tr_count(tbl_cnt);
	int count1 =count-2;
    for(int i=count1;i>=2;i-=2)
    {
    	String data=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[4]")).getText();
    	if(data.contains(CustomCharge))
    	{
    		System.out.println("Custom charge has been addedd successfully.");
    		break;
    	}
    }
}


public static String substring1;
public static String substring2;

public void fn_getPreviousFolioNumber()
{
	//int count=GenericMethods.tr_count(chkboxCount);
     int   size1=rowCount.size();
     String text=rowCount.get(size1-2).getText();
     System.out.println(text);
     String answer = text.substring(text.indexOf("(")+1,text.indexOf(")"));
     substring1=answer.substring(7);
     System.out.println(substring1);
}


public void fn_getAfterFolioNumber()
{
	 int   size1=rowCount.size();
     String text=rowCount.get(size1-2).getText();
     System.out.println(text);
     String answer = text.substring(text.indexOf("(")+1,text.indexOf(")"));
     substring2=answer.substring(7);
     System.out.println(substring2);
     Assert.assertTrue(text.contains(product));
     if(substring1!=substring2)
     {
    	 System.out.println("Other charges have been successfully added for "+product);
     }
}

public void fn_addOtherChargeGFolio() throws Exception
{
	GenericMethods.clickElement(otherCharges1);
	Assert.assertEquals(GenericMethods.getText(OtherChargesPopUpTitle), "Other Charges");
	Select sel=new Select(chargeToGrp);
	//sel.selectByVisibleText("fj/784");
	sel.selectByIndex(2);
	Select sel1=new Select(posPoint);
	//sel1.selectByVisibleText("Sample Restaurant");
	sel1.selectByIndex(1);
	Thread.sleep(4000);
	Select sel2=new Select(posProduct);
	//sel2.selectByVisibleText("Sample French Onion Soup");
	sel2.selectByIndex(1);
	product=sel2.getFirstSelectedOption().getText();
	Actions acobj= new Actions(GenericMethods.driver);
//	acobj.sendKeys(discount, Keys.chord(Keys.CONTROL, "a"), "2").build().perform() ;
	//GenericMethods.sendKeys(discount, "2");
	GenericMethods.clickElement(saveOtherCharge);
	Thread.sleep(3000);
}


public void fn_clkGenerateFolio() throws Exception
{
	try
	{
	GenericMethods.clickElement(generateFolioBtn);
	}
	catch(NoSuchElementException e)
	{
		Thread.sleep(2000);
		GenericMethods.js_Click(generateFolioBtn);
	}
	catch(Exception e)
	{
		throw e;
	}
}


public void fn_verifyGeneratedFolio() throws Exception
{
	String text=GenericMethods.getText(invoiceText);
	Assert.assertTrue(text.contains("PI"));
	System.out.println("Folio has been generated successfully");
	WebElement ele=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl_fllist']//tr[4]//td[1]//input"));
	ele.click();
	GenericMethods.clickElement(delPIGrp);
	GenericMethods.ActionOnAlert("Accept");
}


public void fn_clkTaxExemptBtn() throws Exception
{
	try
	{
	int coun=GenericMethods.tr_count(tbl_cnt);
	int count1=coun-2;
    for(int i=count1;i>=2;i-=2)
    {
    	String data=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]")).getText();
     	if(data.contains(product))
    	{
    		//System.out.println("Other charge has been addedd successfully.");
    		WebElement ele=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[2]//input"));
    		ele.click();
    		break;
    	}
    }
     GenericMethods.clickElement(TaxExemptbtn);
	}
	catch(Exception e)
	{
		throw e;
	}
}


public void fn_verifyTaxExemptTitle() throws InterruptedException
{
	String text=GenericMethods.getText(TaxExemptTitle);
	Assert.assertTrue(text.contains("Tax Exempt Res ID#"));
}


public void fn_saveTaxExempt() throws Exception
{
    Select sel=new Select(TaxExemptReason);
    //sel.selectByVisibleText("Training");
    sel.selectByIndex(1);
    GenericMethods.clickElement(TECheckbox);
    GenericMethods.clickElement(TEBtn);
}


public void fn_verifyTaxExempted()
{
	int count=GenericMethods.tr_count(tbl_cnt);
	int count1=count-2;
    for(int i=count1;i>=2;i-=2)
    {
    	String data=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[4]")).getText();
     	if(data.contains("Exempted Tax ("+product+")"))
    	{
    		//System.out.println("Other charge has been addedd successfully.");
    		System.out.println("Tax has been successfully exempted.");
    		break;
    	}
    }
}

public static String afterPI;
public void fn_getPINum() throws Exception
{
	try
	{
	int count=GenericMethods.tr_count(tbl_cnt);
	int count1=count-2;
    for(int i=count1;i>=2;i-=2)
    {
    	String data=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[4]//a")).getText();
    	if(data.equals(product))
    	{
    		afterPI=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[5]//a")).getText();
//    		WebElement ele=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+count1+"]//td[2]//input"));
//    		GenericMethods.js_Click(ele);
    		break;
    	}
    }
	}
	catch(Exception e)
	{
		throw e;
	}
}


public void fn_getPICustomCharge()
{
	int count=GenericMethods.tr_count(tbl_cnt);
	int count1=count-2;
    for(int i=count1;i>=2;i-=2)
    {
    	String data=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[4]//a")).getText();
    	if(data.equals(CustomCharge))
    	{
    		afterPI=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[5]//a")).getText();
//    		WebElement ele=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+count1+"]//td[2]//input"));
//    		GenericMethods.js_Click(ele);
    		break;
    	}
    }
}


public static int firstNum;
public void fn_getPINum1()
{
   String[] num=afterPI.split(" ");
   firstNum = Integer.valueOf(num[1]);
   System.out.println(firstNum);

}



public void fn_afterRoutePaymentPI() throws Exception
{
	try
	{
	int count=GenericMethods.tr_count(chkboxCount);
    for(int i=2;i<=count;i+=2)
    {
    	String str1=GenericMethods.driver.findElement(By.xpath("(//table[@class='frn_paytbl'])[2]//tbody//tr["+i+"]//td[4]")).getText();
    	//li.add(str1);
    	if(str1.contains("Paid by "+str1Value+" with Cash"))
    	{
    		String str=GenericMethods.driver.findElement(By.xpath("(//table[@class='frn_paytbl'])[2]//tbody//tr["+i+"]//td[9]")).getText();
    		if(str.contains(amt1))
    		{
    		Assert.assertTrue(str.contains(amt1));
    		afterPI=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[5]//a")).getText();
    		//ele1.click();
    		break;
    		}
    	}
    }
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



public void fn_verifyRoutedFolio() throws Exception
{
	try
	{
    int count=GenericMethods.tr_count(folioCount);
    if(count>10)
    {
    	GenericMethods.clickElement(moreLink);
    	for(int i=4;i<=count;i++)
        {
        	String actual=GenericMethods.driver.findElement(By.xpath("//table[@class='dont-print-me-hidden']//table//tr["+i+"]//td[2]/a")).getText();
        	if(actual.equals(afterPI))
        	{
        	  System.out.println("Charges has been successfully routed to the selected guest ID.");
        	  Assert.assertEquals(actual, afterPI);
        	  break;
        	}
        }
    }

    else
    {
    	for(int i=4;i<=count;i++)
        {
        	String actual=GenericMethods.driver.findElement(By.xpath("//table[@class='dont-print-me-hidden']//table//tr["+i+"]//td[2]/a")).getText();
        	if(actual.equals(afterPI))
        	{
        	  System.out.println("Charges has been successfully routed to the selected guest ID.");
        	  Assert.assertEquals(actual, afterPI);
        	  break;
        	}
        }
    }
	}
	catch(Exception e)
	{
		throw e;
	}
}


public void fn_verifySettleFolioMsg() throws Exception
{
   //GenericMethods.clickElement(settleFolio);
   String text=GenericMethods.ActionOnAlert("Dismiss");
   Assert.assertEquals(text, "Do you wish to settle all folios?");

}


public void fn_ValidatePayAmount()
{

  	 try
  	 {
  		Select sel=new Select(DD_PayMode);
  	   	sel.selectByVisibleText("Cash");

  	    Select sel1=new Select(DD_PayType);
	   	sel1.selectByVisibleText("Cash");

	   	GenericMethods.sendKeys(amount, "1");
        GenericMethods.clickElement(Btn_PayNow);
  	 }
  	 catch(Exception e)
  	 {
  		// throw e;
  		 String str=e.getMessage();
  		 System.out.println(str);
  	 }

    }

public void fn_ValidateGenerateFolio_BT() throws Exception
{

  	 try
  	 {
  		GenericMethods.clickElement(generateFolioBtn);
  		GenericMethods.clickElement(CheckOut_BT);
  		GenericMethods.ActionOnAlert("Dismiss");
  		System.out.println(GenericMethods.value);
  		GenericMethods.ActionOnAlert("Dismiss");
  	 }
  	 catch(Exception e)
  	 {
  		 throw e;
  	 }

}


public void fn_ValidateLockFolio_IMG() throws Exception
{

  	 try
  	 {
  		GenericMethods.clickElement(LockFolio_IMG);
  		//GenericMethods.ActionOnAlert("Dismiss");
  		String str=GenericMethods.Alert_Dismiss();
  		Assert.assertEquals(str, "Do you wish to Close this Folio?");
  		//System.out.println(GenericMethods.value);
  	 }
  	 catch(Exception e)
  	 {
  		 throw e;
  	 }

}


public void fn_ValidatePayAmountByCheque()
{

    try{
          Select sel=new Select(DD_PayMode);
          sel.selectByVisibleText("Cheque");

          Select sel1=new Select(DD_PayType);
          sel1.selectByVisibleText("Cheque");

          ChequeNum=GenericMethods.generateRandomString();

          GenericMethods.sendKeys(chequeNum, ChequeNum);
          GenericMethods.sendKeys(amount, "1");
          GenericMethods.clickElement(Btn_PayNow);
    }
    catch(Exception e)
    {
       // throw e;
          String str=e.getMessage();
          System.out.println(str);
    }

 }

public void fn_ValidatePaidAMTby_Checqe() throws Exception{
try{

    int count=Discription_COUNT.size();
    for(int i=3; i<=count-1; i+=2){
        String str=GenericMethods.driver.findElement(By.xpath("(//td[@class='front_tbl_lft'])[2]//tr["+i+"]//td[4]")).getText();

        if(str.contains(ChequeNum)){
            String sr=GenericMethods.driver.findElement(By.xpath("(//td[@class='front_tbl_lft'])[2]//tr["+i+"]//td[9]")).getText();
            System.out.println(sr);
            Assert.assertTrue(sr.contains("1"));
            break;
        }
    }


}catch(Exception e){
    throw e;
}
}



public void fn_ClickSettleFolio_BT(String Alertcommand) throws Exception
{
    GenericMethods.clickElement(Btn_settleFolio);
    //GenericMethods.ActionOnAlert(Alertcommand);
    String str=GenericMethods.Alert_Dismiss();
    Assert.assertEquals(str, "Do you wish to settle all folios?");
}


public void fn_ClickSettleFolio_Dismiss() throws Exception
{
    GenericMethods.clickElement(Btn_settleFolio);
    //GenericMethods.ActionOnAlert(Alertcommand);
    String str=GenericMethods.Alert_Dismiss();
    Assert.assertEquals(str, "Do you wish to settle all folios?");
}


public void fn_ClickSettleFolio_Accept() throws Exception
{
	try
	{
    GenericMethods.clickElement(Btn_settleFolio);
    //GenericMethods.ActionOnAlert(Alertcommand);
    String str=GenericMethods.Alert_Accept();
    Assert.assertEquals(str, "Do you wish to settle all folios?");
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

public void scroll_windowDown()
{
	JavascriptExecutor jse = (JavascriptExecutor)GenericMethods.driver;
	jse.executeScript("window.scrollBy(0,250)", "");
}

public void windowScrollUp()
{
	JavascriptExecutor jsx = (JavascriptExecutor)GenericMethods.driver;
	jsx.executeScript("scroll(0, -550)");

}









}



