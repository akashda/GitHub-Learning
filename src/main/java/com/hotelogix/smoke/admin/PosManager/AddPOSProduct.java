package com.hotelogix.smoke.admin.PosManager;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class AddPOSProduct {

	@FindBy(xpath="//input[@id='prodNameMulName_0']")
	public static WebElement SamplePOSProdTitle;

	@FindBy(xpath="//input[@name='prodCode']")
	public static WebElement POSProdID;

	@FindBy(xpath="//select[@id='posCat']")
	public static WebElement POSCategory;

	@FindBy(xpath="//input[@name='price']")
	public static WebElement Price;

	@FindBy(xpath="//select[@name='unit']")
	public static WebElement PerUnit;

	@FindBy(xpath="//input[@id='btnSave']")
	public static WebElement SavePOSP;

	@FindBy(xpath="//input[@id='btnSave']")
	public static WebElement SavePOSProduct;

	@FindBy(xpath="//select[@name='posCatId']//option")
	public static List<WebElement> productCat;

	@FindBy(xpath="//input[@name='prodNameMulName[]']")
	public static WebElement productTitle;

	@FindBy(xpath="//input[@name='prodCode']")
	public static WebElement productID;

	@FindBy(xpath="//select[@name='posCatId']")
	public static WebElement category;

	@FindBy(xpath="//input[@name='price']")
	public static WebElement price;

	@FindBy(xpath="//select[@name='unit']")
	public static WebElement Unit_drpDwn;

	@FindBy(xpath="//input[@name='Submit5']")
	public static WebElement savePOSProduct_BT;


	public List<String> verifyPOSCategory() throws Exception
	{
		try
		{
		ArrayList<String> arr=new ArrayList<String>();
		Select sel=new Select(category);
		List<WebElement> we=sel.getOptions();
		for(WebElement we1:we)
		{	
			arr.add(we1.getText());
			
		}
		return arr;
		}
		catch(Exception e)
		{
			throw e;
		}
	
	}

	public static String productName;
	
	public  void fn_fillProductDetails() throws Exception
	{
		try
		{
		productName=GenericMethods.generateRandomString();
		GenericMethods.sendKeys(productID, GenericMethods.generateRandomString());
		GenericMethods.sendKeys(productTitle,productName);
		GenericMethods.selectElementByIndex(Unit_drpDwn, 3);
		GenericMethods.clickElement(price);
		price.clear();
		GenericMethods.sendKeys(price, "102");
		GenericMethods.selectElement(category, AddEditPOSCategory.name);
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public  POSProductsList fn_addPOSProduct() throws Exception
	{
		try
		{
		fn_fillProductDetails();
		GenericMethods.clickElement(savePOSProduct_BT);

		POSProductsList pageobj=PageFactory.initElements(GenericMethods.driver, POSProductsList.class);
		return pageobj;
		}
		catch(Exception e)
		{
			throw e;
		}
	}



	public static void fn_enterPOSProdfields() throws Exception
	{
		GenericMethods.sendKeys(SamplePOSProdTitle, "Sample POS Prod Title1.1");
        GenericMethods.sendKeys(POSProdID, "21");
        GenericMethods.selectElement(POSCategory, "Sample Full Day Tour");
        Price.clear();
        GenericMethods.sendKeys(Price, "500");
        GenericMethods.selectElement(PerUnit, "Dozen");

	}

	public static AddPOSProduct fn_SavePOSProduct() throws Exception
	{
		GenericMethods.clickElement(SavePOSProduct);

		AddPOSProduct POPLP=PageFactory.initElements(GenericMethods.driver, AddPOSProduct.class);
		return POPLP;

	}

}
