package com.hotelogix.smoke.frontdesk.SampleRestaurantPage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.hotelogix.smoke.genericandbase.GenericMethods;

import junit.framework.Assert;

public class OrderFromNewTab {

	
	
	public String pName;
	public String guestName;


@FindBy(xpath="//div[@id='posContainer']/div[1]/div[2]/ul/li[1]/div/span[1]")
public static WebElement ProductToAdd;

@FindBy(xpath="//input[@id='txtSearchPOS']")
public static WebElement ProductTextBox;

@FindBy(xpath="//div[text()='Order#']")
public static WebElement newTabTitle;

@FindBy(id="roomNo")
public static WebElement RoomNumber_DD;

@FindBy(id="roomGuest")
public static WebElement RoomGuestName_DD;

@FindBy(xpath="//input[@id='txtSearchPOS']")
public static WebElement ProductName_ED;

@FindBy(xpath="//div[@class='yui-ac-bd']//ul//li[1]//div")
public static WebElement autoDropDown;

@FindBy(id="trsnToRoomGrpBnt")
public static WebElement TransferToRoom_BT;

@FindBy(xpath="//fieldset[@id='paymentTab']//tr[3]//td[1]")
public static WebElement VerifyTTRBox;

@FindBy(xpath="//select[@id='roomNo']//option")
public static List<WebElement> RoomNumberText;

@FindBy(xpath="//li[@id='##tabPOS']//table/tbody/tr/td/div")
public WebElement Txt_OrderTab;


@FindBy(xpath="//select[@id='roomNo']")
public WebElement DD_RoomNo;

@FindBy(xpath="//table[@id='tblPOSProducts']/tbody/tr[3]/td[2]")
public WebElement Txt_SelectedProduct;

@FindBy(xpath="//table[@class='paymentbox table-cellspacing-patch']/tbody/tr[4]/td[2]/span/input")
public WebElement Btn_TransferToRoom;



@FindBy(xpath="//select[@id='roomGuest']")
public WebElement DD_RoomGuest;









public String SelectAndGetProduct() throws Exception{

	String a=null;
	try
	{
		
	GenericMethods.sendKeys(ProductTextBox, "S");
    Thread.sleep(1000);
    //GenericMethods.driver.findElement(By.xpath("//div[@id='posContainer']/div[1]/div[2]/ul/li[1]/div/span[1]")).sendKeys(Keys.ENTER);
	GenericMethods.clickElement(ProductToAdd);
	GenericMethods.getText(ProductToAdd);
	GenericMethods.driver.findElement(By.xpath("//table[@id='tblPOSProducts']/tbody/tr[3]/td[2]")).click();
	 a=GenericMethods.driver.findElement(By.xpath("//table[@id='tblPOSProducts']/tbody/tr[3]/td[2]")).getText().trim();
	//Assert.assertEquals("Hlx_French Onion Soup", a);
	}
	catch(AssertionError e)
	{
		throw e;
	}
	catch(Exception e)
	{
		throw e;
	}
	
	return a;

}


public String fn_verifynewTabTitle() throws InterruptedException
{
   String text=GenericMethods.getText(newTabTitle);
   return text;
 //  Assert.assertEquals(text, "Order#");
}


public void SelectRoomNumberandGuestname() throws Exception
{
	try
	{
    Select selobj=new Select(RoomNumber_DD);
    selobj.selectByIndex(1);

    Select seobj=new Select(RoomGuestName_DD);
//    sSeobj.selectByIndex(0);
	}
	catch(Exception e)
	{
		throw e;
	}
}


public void fn_getGuestName()
{
   Select sel=new Select(RoomGuestName_DD);
   String text=sel.getFirstSelectedOption().getText();
   System.out.println(text);

}


public String fn_addProduct() throws Exception
{
	
	  GenericMethods.sendKeys(ProductName_ED, "H");
	  Thread.sleep(1000);
	  
	  GenericMethods.clickElement(autoDropDown);
	  
	  pName=GenericMethods.getText(Txt_SelectedProduct);
	  
	  return pName;
	  
	  
	/*  GenericMethods.clickElement(TransferToRoom_BT);
      Thread.sleep(3000);
      String strobj=GenericMethods.getText(VerifyTTRBox);
      Thread.sleep(3000);
      for(int i=0; i<RoomNumberText.size();i++)
      {
          WebElement wobj=RoomNumberText.get(i);
          String stro=wobj.getText();
          if(strobj.contains(stro))
          {
              System.out.println("Transfer to Room Details section is visible on page");
              break;
          }
      }*/
}


public void fn_TransferToRoomButton() throws Exception
{

    GenericMethods.clickElement(TransferToRoom_BT);
    Thread.sleep(5000);
    String strobj=GenericMethods.getText(VerifyTTRBox);
    String[] parts=strobj.split(" ");
    String value=parts[2];
    String rmnumber=value.substring(value.indexOf("(")+1, value.indexOf(")"));
    System.out.println("Transferred to room  "+rmnumber);
    Thread.sleep(3000);
    for(int i=0; i<RoomNumberText.size();i++)
    {
        WebElement wobj=RoomNumberText.get(i);
        String stro=wobj.getText();
        if(rmnumber.equals(stro))
        {
            System.out.println("Transfer to Room Details section is visible on page");
            break;
        }
     }

}

public OrderFolioPage fn_transferOrderToRoom(String roomNo) throws Exception
{
try
{
GenericMethods.selectElement(DD_RoomNo, roomNo);
Thread.sleep(2000);
Select s=new Select(DD_RoomGuest);
Thread.sleep(2000);
guestName=s.getFirstSelectedOption().getText();
Thread.sleep(2000);
GenericMethods.clickElement(Btn_TransferToRoom);
Reporter.log("Order transfer to the:"+ roomNo , true);
}
catch(Exception e)
{
throw e;
}
OrderFolioPage OFP=PageFactory.initElements(GenericMethods.driver, OrderFolioPage.class);
return OFP;
}






}
