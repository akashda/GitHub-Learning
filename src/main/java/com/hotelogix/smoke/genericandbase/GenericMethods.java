package com.hotelogix.smoke.genericandbase;







import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.dom4j.InvalidXPathException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverLogLevel;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.hotelogix.smoke.admin.WebTravelAgent.TravleAgent_LoginPage;
import com.hotelogix.smoke.frontdesk.FrontdeskHome.FrontdeskLandingPage;
import com.hotelogix.smoke.login.AdminLoginPage;
import com.hotelogix.smoke.login.EmailAccountLoginPage;
import com.hotelogix.smoke.login.WebGuestConsoleLoginPage;
import com.sun.jna.platform.FileUtils;


//import autoitx4java.AutoItX;
//
//import com.hms.hotelogix.automationframework.pages.GenericMethods.ExcelUtil;
//import com.hms.hotelogix.automationframework.pages.GenericMethods.GenericClass;
//import com.hms.hotelogix.automationframework.pages.admin.LoginPage.AdminLogin;

public class GenericMethods {



	public static Set<String> handles4;
	public static String Parent;
	public static String Child;
	public static int size;
	private static final String CHAR_LIST ="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final int RANDOM_STRING_LENGTH =5;
    public static WebDriver driver;
    public static float Rate;

    //private static final String CHAR_LIST ="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    //private static final int RANDOM_STRING_LENGTH = 8;

    private static final String Num_LIST ="0123456789";
    private static final int RANDOM_NUM_LENGTH = 4;


    //public static HomePageclass home;

    public static String Currenthandle4;


  //Random Number generator within a range.

    static int min=1;
    static int max=1000;
    public static  float tamt;

    public static int randomNumber()
    {
   	 Random rand = new Random();
   	 int randomNum = rand.nextInt((max-min)+1)+min;
   	 return randomNum;
    }



    public static boolean isEnable(String text ,WebElement element){

        boolean result =element.isEnabled();
        //System.out.println(result);
        if(result == true){
        System.out.println(text + "Element is Enable");
        }
        else{
            System.out.println(text + "Element is Disabled");
        }
        return result;
    }


    public static String Alert_Accept()
    {
    	Alert alert = driver.switchTo().alert();
    	String str = alert.getText();
    	alert.accept();
    	return str;
    }

    public static String Alert_Dismiss()
    {

    	Alert alert = driver.switchTo().alert();
    	String str = alert.getText();
    	alert.dismiss();
    	return str;


    }


    public static WebDriver fn_defaultcontentofiframe()
    {
    	driver.switchTo().defaultContent();
    	return driver;
    }

    public static WebDriver fn_switchiframe(WebElement frameval)
    {
    	//driver.switchTo().frame("xd_frame");
    			driver.switchTo().frame(frameval);
    			//WebElement frm_WE=driver.findElement(By.xpath("//div[@id='login-form']/iframe"));
    			//driver.switchTo().frame(frm_WE);
    			//driver.findElement(By.id("Username")).sendKeys("a@b.com");


    		//	driver.switchTo().defaultContent();

    			return driver;
    }

    public static  boolean isAlertPresent()
    {
        try
        {
            GenericMethods. driver.switchTo().alert();
            return true;
        }
        catch (NoAlertPresentException Ex)
        {
            return false;
        }
    }

    public static void selectElementByIndex(WebElement element, int index )
    {

        Select gender = new Select(element);
        gender.selectByIndex(index);
        //gender.selectByIndex(index);
    }


    public static WebElement ExplicitWait(WebElement ele, String xp)
    {

   WebElement elem = (new WebDriverWait(GenericMethods.driver, 25000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp)));
    ele=elem;
    return ele;
    }


    public static String GetTitle()
    {
    	String str=GenericMethods.driver.getTitle();
    	System.out.println(str);
		return str;
    }


    public static void mouseOverElement( WebElement element) {

        Actions builder = new Actions(driver);

        builder.moveToElement(element).build().perform();

        }
    //

    public static String getText(WebElement element) throws InterruptedException {
    	Thread.sleep(2000);
        return element.getText().trim();
     }

    public static void js_Sendkey(WebElement element, String id)
    {
   	    JavascriptExecutor executor = (JavascriptExecutor)driver;
   	    executor.executeScript("arguments[0].value='"+id+"';", element);
   	}


    public static void switchToWindowHandle(String title) throws Exception {
    	 try{
             Set<String> setHndlValColls=driver.getWindowHandles();
             Thread.sleep(2000);
           Iterator<String>  itHandleColls= setHndlValColls.iterator();
           Thread.sleep(2000);
           while(itHandleColls.hasNext()==true){
        	   Thread.sleep(2000);
               String hndlval=itHandleColls.next();
               Thread.sleep(1000);
               driver.switchTo().window(hndlval);
               Thread.sleep(1000);
              // String titl=driver.getTitle();
               Thread.sleep(1000);
               if(driver.getTitle().equalsIgnoreCase(title)){
            	   Thread.sleep(1000);
                  break;
               }
               }
           }catch(Exception e){
               throw e;
           }
    }

    public static void selectbyNo(WebElement element, int a )
    {

        Select gender = new Select(element);
        gender.selectByIndex(a);


    }

public static String fn_getDropdownSelectedValue(WebElement ele) throws Exception{
	String selvalue=null;
try{
Select s=new Select(ele);
selvalue=s.getFirstSelectedOption().getText();
}
catch(Exception e){
throw e;	
}
return selvalue;
}
    
    
    

    public static void switchToWindowHandleByURL( String url) {


        Set<String> handler = driver.getWindowHandles();
        for (String handlesname : handler) {


            driver.switchTo().window(handlesname);
            String var = driver.getCurrentUrl();
            if (var.contains(url))
            {
                break;
            } else {
                driver.switchTo().defaultContent();
            }
        }

    }




    public static AdminLoginPage fn_OpenAdmin(String BrowserType, String URL) throws Exception
    {
        try{
    	fn_LaunchBrowser(BrowserType);
        }catch(Exception e){
        	Thread.sleep(2000);
        	fn_LaunchBrowser(BrowserType);
        	System.out.println("We are in catch block of fn_LaunchBrowser");
        }

    	driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
       try{
        driver.get(URL);
       }catch(Exception e){
    	   Thread.sleep(2000);
    	   driver.get(URL);
   		GenericMethods.driver.navigate().refresh();

    	   System.out.println("We are in catch block of Launching URL");
       }
        AdminLoginPage ALO = PageFactory.initElements(GenericMethods.driver, AdminLoginPage.class);
        return ALO;
    }
//


public static com.hotelogix.smoke.login.FrontdeskLoginPage fn_OpenFrontdesk(String BrowserType, String URL) throws Exception{

	try{
    	fn_LaunchBrowser(BrowserType);
        }catch(Exception e){
        	Thread.sleep(2000);
        	fn_LaunchBrowser(BrowserType);
        	System.out.println("We are in catch block of fn_LaunchBrowser");
        }


	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

	try{
	driver.navigate().to(URL);
	//get(URL);
	}catch(Exception e){
		   Thread.sleep(2000);
    	   driver.get(URL);
   		GenericMethods.driver.navigate().refresh();

	}

	com.hotelogix.smoke.login.FrontdeskLoginPage FLO = PageFactory.initElements(GenericMethods.driver, com.hotelogix.smoke.login.FrontdeskLoginPage.class);
        return FLO;

    }


    public static void sendKeys( WebElement element,String sValue) throws Exception 
    {
      try{
	       if(element.isDisplayed() && element.isEnabled()==true)
	         {
		         element.clear();
		         Thread.sleep(2000);
		         element.sendKeys(sValue);
	         }
         }
catch(Exception e)
{
	throw e;
	}
    }
//
//public static void input( WebElement element,String FieldName) {
//
////        try {
//        //    logger.info("Waiting for an element to be clickable " + element);
//            //highlightElementBorder(element);
////            WebDriverWait wait = new WebDriverWait(driver,
////                    Integer.parseInt(getConfigValues("timeOutInSeconds")));
//        //    ele = wait.until(ExpectedConditions.elementToBeClickable(element));
//           String sValue=ExcelUtil.TestCaseData.get(FieldName);
//            element.sendKeys(sValue);
//            //logger.info("Waited and send value to on element " + element);
////        } catch (Exception e) {
////            logger.info("Exception while supplying text to element"
////                    + e.getMessage());
////        }
//    }

    public static String getURL()
    {
        String url=driver.getCurrentUrl();
        return url;
    }

    public static WebDriver fn_LaunchBrowser(String BrowserType) throws Exception {

        WebDriver Driver_Object = null;
        if (BrowserType.equalsIgnoreCase("FF")
                || BrowserType.equalsIgnoreCase("Firefox")) {
        	System.setProperty("webdriver.gecko.driver",".\\Resources\\Drivers\\geckodriver.exe");
            Driver_Object = new FirefoxDriver();
        } else if (BrowserType.equalsIgnoreCase("Safari")) {
            Driver_Object = new SafariDriver();
        } else if (BrowserType.equalsIgnoreCase("chrome")|| BrowserType.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver",".\\Resources\\Drivers\\chromedriver.exe");
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--test-type");
            LoggingPreferences loggingprefs = new LoggingPreferences();
            loggingprefs.enable(LogType.BROWSER, Level.ALL);
            capabilities.setCapability(CapabilityType.LOGGING_PREFS, loggingprefs);
            capabilities.setCapability("chrome.binary", ".\\Resources\\Drivers\\chromedriver.exe");
            capabilities.setCapability("chrome.switches", Arrays.asList("--incognito"));
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            Driver_Object = new ChromeDriver(capabilities);
        } else if (BrowserType.equalsIgnoreCase("IE")|| BrowserType.equalsIgnoreCase("InternetExplorer")) {
            System.setProperty("webdriver.ie.driver",".\\Resources\\Drivers\\IEDriverServer.exe");
            InternetExplorerDriverService.Builder service = new InternetExplorerDriverService.Builder();
            service = service.withLogLevel(InternetExplorerDriverLogLevel.TRACE);
            service = service.withLogFile(new File("d:\\logs\\selenium.log"));
            //    DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
            //    ieCapabilities.setCapability("requireWindowFocus", true);
            //.setCapability("ie.ensureCleanSession", true);
            //ieCapabilities.setCapability("nativeEvents", false);
            //            ieCapabilities.setCapability(CapabilityType.BROWSER_NAME,"Internet Explorer");
            //            ieCapabilities.setCapability(CapabilityType.VERSION, "8");
            //        ieCapabilities.setCapability("ie.forceCreateProcessApi", true);
            //            ieCapabilities.setCapability("ie.browserCommandLineSwitches","-private");

            // ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
            // true);
            Driver_Object = new InternetExplorerDriver(service.build());
            // Driver_Object = new InternetExplorerDriver();
        } else if (BrowserType.equalsIgnoreCase("remote")) {
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setBrowserName("chrome");
            Driver_Object = new RemoteWebDriver(new URL(
                    "http://localhost:4446/wd/hub"), cap);
        }
        // DO NOT DELETE IT
        /*
         * else if(BrowserType.equalsIgnoreCase("bmp")){ ProjectSnappyProxy
         * objProjectSnappyProxy = ProjectSnappyProxy.getInstance();
         * System.setProperty("webdriver.chrome.driver",
         * ".\\Resources\\chromedriver.exe"); Driver_Object=new
         * ChromeDriver(objProjectSnappyProxy.getProxyDesiredCapabilties(4567));
         *
         * }
         */
//        else {
//
//            logger.info("Provided Browser Type is invalid, please check");
//        }
        Driver_Object.manage().window().maximize();
        Driver_Object.manage().timeouts().implicitlyWait(90,TimeUnit.SECONDS);
        driver=Driver_Object;
        return Driver_Object;
    }


    public static void clickElement( WebElement element) throws Exception
    {
             element.click();
    }


    public static void js_Click(WebElement element){

        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }





    public static boolean checkElementDisplay( WebElement element) throws Exception
    {
        boolean status = element.isDisplayed();
    if(status==true){
        System.out.println("Element is displaying");

    }else{
        System.out.println("Element not displayed");
    }


    Assert.assertTrue(status, "Validating Elements visibility");
    return status;

    }


    public static void selectElement(WebElement element, String a ) throws InterruptedException
    {

        Select gender = new Select(element);
        Thread.sleep(2000);
        gender.selectByVisibleText(a);
    }



    
    
public static String selectValueFromDropdownUsingIndex(WebElement element, int index) throws Exception{
String  selValue=null;
try{
Select s=new Select(element);
s.selectByIndex(index);	
selValue=s.getFirstSelectedOption().getText();

}
catch(Exception e){
	throw e;
}
return selValue;
}
    
    
    
    public static String jvmBitVersion(){
         return System.getProperty("sun.arch.data.model");
        }

        public static void autoit(String fileToUpload, String DialogTitle) throws InterruptedException {
            String jacobDllVersionToUse;
            if (jvmBitVersion().contains("32")){
            jacobDllVersionToUse = "jacob-1.18-M2-x86.dll";
            }
            else {
            jacobDllVersionToUse = "jacob-1.18-M2-x64.dll";
            }
            File file = new File("Lib", jacobDllVersionToUse);
//            System.out.println(LibraryLoader.JACOB_DLL_PATH+"|||||||||"+file.getAbsolutePath());
//            System.setProperty(LibraryLoader.JACOB_DLL_PATH, file.getAbsolutePath());
//            Runtime.getRuntime().loadLibrary(LibraryLoader.JACOB_DLL_PATH);
//            Runtime.getRuntime().loadLibrary(file.getAbsolutePath());
//        //    AutoItX x = new AutoItX();
//            x.winActivate(DialogTitle);
//            x.winWaitActive(DialogTitle);
//            x.ControlSetText(DialogTitle, "", "Edit1",fileToUpload) ;
//            Thread.sleep(1000);
//            x.controlClick(DialogTitle, "", "Button1") ;
//            Thread.sleep(1000);
    }

      public static int CheckBox_Count(List<WebElement> element)
     {
          List<WebElement> checkBoxes = element;
                  //driver.findElements(By.xpath("//input[@type='Checkbox']"));
          for(int i=0; i<checkBoxes.size(); i=i+1){
              checkBoxes.get(i).click();
          }
          int checkedCount=0, uncheckedCount=0;
          for(int i=0; i<checkBoxes.size(); i++){
              System.out.println(i+" checkbox is selected "+checkBoxes.get(i).isSelected());
              if(checkBoxes.get(i).isSelected()){
                  checkedCount++;
              }else{
                  uncheckedCount++;
              }
          }
      // uncheckedCount=uncheckedCount; // commented by deepak -------------
          checkedCount=checkedCount-1;
          return uncheckedCount;
     }


      public static int tr_count(List<WebElement> columnelements)
      {

      int Total_tr=columnelements.size();
      System.out.println(Total_tr);
      return Total_tr;


      }



public static String generateRandomString(){

	        StringBuffer randStr = new StringBuffer();
	        for(int i=0; i<RANDOM_STRING_LENGTH; i++){
	            int number = getRandomNumber();
	            char ch = CHAR_LIST.charAt(number);
	            randStr.append(ch);
	        }
	        return randStr.toString();
	    }

private static int getRandomNumber() {
	        int randomInt = 0;
	        Random randomGenerator = new Random();
	        randomInt = randomGenerator.nextInt(CHAR_LIST.length());
	        if (randomInt - 1 == -1) {
	            return randomInt;
	        } else {
	            return randomInt - 1;
	        }
	    }




public static String GetCurrentWindowID(){


        String Currenthandle4 = driver.getWindowHandle();
//
            System.out.println("parent window id:"+Currenthandle4);

            return Currenthandle4;
  }

public  static void  windowHandle(String ParentID) throws InterruptedException{

           Set<String> handles4= driver.getWindowHandles();
             handles4.remove(ParentID);
             driver.switchTo().window(handles4.iterator().next());
             Thread.sleep(2000);

}



//.................. Handle the Child Window..................//
public  static String  windowHandle_admin(String ParentID) throws InterruptedException
{


       Set<String> handles4= driver.getWindowHandles();


        handles4.remove(ParentID);

//driver.switchTo().window(handles4.iterator().next());
//
//             Thread.sleep(2000);

        Iterator<String> it =handles4.iterator();
        String Child=it.next();

        driver.switchTo().window(Child);




// driver.switchTo().window(handles4.iterator().next());





                                         Thread.sleep(2000);

return Child;

}




public static void Switch_Parent_Window(String ParentID){

   driver.switchTo().window(ParentID);
   System.out.println("Yoo Back to Parent Window...");
   }


public static void Switch_Parent_Window1(String ParentID,String Child){
	  handles4.remove(Child);
driver.switchTo().window(ParentID);
System.out.println("Yoo Back to Parent Window...");
}


public static String value;
public static String ActionOnAlert(String Action){
	  try{

		   WebDriverWait wait = new WebDriverWait(driver, 2);
		   Alert alert = wait.until(ExpectedConditions.alertIsPresent());

		   value=alert.getText();
		  // System.out.println(value);
		 //  GenericClass.driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		   if(Action.equalsIgnoreCase("Accept")){
		   alert.accept();
		   System.out.println("Accepted the alert successfully.");
		   }
		   else if(Action.equalsIgnoreCase("Dismiss")){
		   alert.dismiss();
		   System.out.println("Alert is successfully Dismissed.");
		   }
		   else if(Action.equalsIgnoreCase("")){
			   System.out.println("No Action performed");
		   }
		}catch(Throwable e){
		   System.err.println("Error came while waiting for the alert popup. "+e.getMessage());
		}

	  return value;
	  }

public static  EmailAccountLoginPage fn_OpenEmailBox(String BrowserType, String URL) throws Exception{
	try
	{
	fn_LaunchBrowser(BrowserType);
	driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
    driver.get(URL);
	}
	catch(Exception e)
	{
		throw e;
	}

	EmailAccountLoginPage  EALP=PageFactory.initElements(GenericMethods.driver, EmailAccountLoginPage.class);
    return EALP;
}

public static WebGuestConsoleLoginPage fn_OpenWebGuestConsolePage(String BrowserType, String URL) throws Exception{
	fn_LaunchBrowser(BrowserType);
	driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
    driver.get(URL);
    WebGuestConsoleLoginPage WCLP=PageFactory.initElements(GenericMethods.driver,WebGuestConsoleLoginPage.class);
    return WCLP;
}


public static TravleAgent_LoginPage fn_OpenTAGuestConsolePage(String BrowserType, String URL) throws Exception{
	
	try
	{
	fn_LaunchBrowser(BrowserType);
	driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
    driver.get(URL);
    TravleAgent_LoginPage WCLP=PageFactory.initElements(GenericMethods.driver,TravleAgent_LoginPage.class);
    return WCLP;
	}
	catch(Exception e)
	{
		throw e;
	}
}

public static String generateRandomnum(){

    StringBuffer randStr = new StringBuffer();
    for(int i=0; i<RANDOM_NUM_LENGTH; i++){
        int number = getRandomNumbe();
        char ch = Num_LIST.charAt(number);
        randStr.append(ch);
    }
    return randStr.toString();
}

private static int getRandomNumbe() {
    int randomInt = 0;
    Random randomGenerator = new Random();
    randomInt = randomGenerator.nextInt(Num_LIST.length());
    if (randomInt - 1 == -1) {
        return randomInt;
    } else {
        return randomInt - 1;
    }
}


/*public static void getscreenshot() throws Exception
{
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
     //The below method will save the screen shot in d drive with name "screenshot.png"


        FileUtils.copyFile(scrFile, new File("C://Users//qa//Desktop//SmokeTC//Smoak//Smoak//Smoak//capture.png "+ GetTimeStampValue()));
}*/


public  static String GetTimeStampValue()throws IOException
{
    Calendar cal = Calendar.getInstance();
    Date time=cal.getTime();
    String timestamp=time.toString();
    System.out.println(timestamp);
    String systime=timestamp.replace(":", "-");
    System.out.println(systime);
    return systime;
}


public static String GetWebElementAttributeValue(WebElement ele,String attrName){
String name=null;
try{
		
	
name=ele.getAttribute(attrName);
}
catch(Exception e){
e.printStackTrace();
}
return name;
}





public static String ExtractTheRate(String rate) throws Exception{
	String a=null;

	try{
	
	
	if(rate.contains(",")==true){
		String pric []=rate.split(",");
		 a=pric[0].toString().substring(3, pric[0].length()) + pric[1].toString().substring(0, pric[1].length()-1).trim();
		 Rate=Float.parseFloat(a);
		System.out.println("Res Per night Price is"+ a);
		
		
	}
	else{
		
		a=rate.substring(3,rate.length()).trim();
		Rate=Float.parseFloat(a);
		
	}
	}
	catch(Exception e){
		e.printStackTrace();
	}
	

	return a;
}





/**
 * This method is used for getting rate from rate string.
 * @param rateString : Rate string to be extract for actual rate.
 * @return : As it returns the rate in float format from the rate String.
 */
public static float fn_getRateFromRateString(String rateString){
	
if((rateString.contains(",")==true) & (rateString.contains(".")==true)==true){
		  
		String main []=rateString.split("\\.");
	    String	SubMain []=main[0].toString().split("\\,");
	    String inner[]=SubMain[0].split("\\s");
        String  whole=(inner[1] + SubMain[1] + "." + main[1]).toString();
        System.out.println("Price is in string format:"+ whole );
		tamt=Float.parseFloat(whole);
		System.out.println("Price is in float format:"+ tamt);
}
else if(rateString.contains(".")==true){
		String main []=rateString.split("\\.");
		String submain[]=main[0].split("\\s");
		String whole=(submain[1]+"."+main[1] ).toString();
		System.out.println("Price is in string format:"+ whole );
		tamt=Float.parseFloat(whole);
		System.out.println("Price is in float format:"+ tamt);
}

return tamt;
	
}





public static String fn_getResNumber(String str) throws Exception{
String resNum=null;
try{
	String [] parts=str.split("\\.");
	resNum=parts[0];
}
catch(Exception e){
throw e;
}
return resNum; 
}



public static WebElement fn_getWebElementForGroup(String title) throws Exception{
	WebElement ele=null;
try{
	
	ele=GenericMethods.driver.findElement(By.xpath("//div[starts-with(@title,'"+title+".')]"));
	Thread.sleep(1000);
}
catch(InvalidXPathException e){
	throw e;
}
catch(Exception e){
	throw e;
}
return ele;
}




public static void fn_DoubleClickOnWebElement(WebElement eleToClick) throws Exception{
try{
Actions act=new Actions(driver);
Thread.sleep(1000);
act.doubleClick(eleToClick).build().perform();
}
catch(Exception e){
	throw e;
}
}




 
}


