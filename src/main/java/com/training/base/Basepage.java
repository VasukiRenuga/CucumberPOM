package com.training.base;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basepage {
	
	protected WebDriver driver;
	public Basepage(WebDriver driver) {
	 this.driver =driver;
	 PageFactory.initElements(driver, this);
	}
	public WebDriver getDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
		
		}
		public WebDriver getDriver1() {
		WebDriverManager.firefoxdriver().setup();
		 WebDriver driver=new FirefoxDriver();
		 return driver;
	}
		
		/* name of the method:   setUp()
		 * BriefDescription  :   Start the Extent Report
		 *  createdby        :  Automation team 
		 *  created date     :02/05/22 
		 *  LastModified Date:02/05/22         
		 */
		
					
		/* name of the method:   getTitle
		 * BriefDescription  :   get the title of the page
		 * Arguments         :  String- actual title
		 *                      String- expected title
		 *  createdby        :  Automation team 
		 *  created date     :01/29/22 
		 *  LastModified Date:01/29/22         
		 */
		public static void getTitle(String actualtitle, String expectedTitle) {
		  if (actualtitle.equals(expectedTitle)) {
				System.out.println("Pass : User is on that page");
		  }
			else {
				System.out.println("Fail :  page is not Lunched");
				
			}
		  
		}
		/* name of the method:   waitforElement
		 * BriefDescription  :   Wait until the visibility of the element in 30 seconds
		 * Arguments         :  element-->web element
		 *  created by       :  Automation team 
		 *  created date     :  01/21/22 
		 *  LastModified Date:  01/21/22          
		 */
		
		public void waitforElement(WebElement element){

			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(element));
			
		}
		
		/* name of the method:   waitUntilAlertIsPresent
		 * BriefDescription  :   Wait until the  Alert box is present in 30 seconds
		 *  created by       :  Automation team 
		 *  created date     :  01/21/22 
		 *  LastModified Date:  01/21/22          
		 */
		public void waitUntilAlertIsPresent() {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.alertIsPresent());
			
		}
		
		
		/* name of the method:   enter text
		 * BriefDescription  :   entering textvalue for textbox
		 * Arguments         :  obj-->object
		 *                      textval--->to be entered 
		 *                      objName--->object name
		 *  createdby        :  Automation team 
		 *  created date     :01/29/22 
		 *  LastModified Date:01/29/22         
		 */
		public static void enterText(WebElement obj,String textval,String objName) throws Exception

		{
			if(obj.isDisplayed())
			{
				Thread.sleep(4000);
				obj.sendKeys(textval);
				System.out.println("pass: "+textval+"value is entered in "+objName+"field");
				//Call take screenshot function
//				logger.log(LogStatus.PASS,textval+"value is entered in "+objName+"field");
				
				
				
			}
			else
			{
				System.out.println("fail:" +objName+ "field does not exist please check application");
//				logger.log(LogStatus.FAIL,textval+objName+"field does not exist please check application");
				
				
			}
		}
		
		/* name of the method:   clickobject--->Button
		 * BriefDescription  :   clicking a button
		 * Arguments         :  obj-->object,objName--->object name
		 *  createdby        :  Automation team 
		 *  created date     :01/29/22 
		 *  LastModified Date:01/29/22          
		 */
		public static void clickObj(WebElement obj,String objName)
		{
			if(obj.isDisplayed())
			{
				obj.click();
				System.out.println("pass :" +objName + "button is clicked");
//				logger.log(LogStatus.PASS, objName+ "button is displayed ,please check the application");
				
			}
			else
			{
				System.out.println("Fail:" +objName+"button is not displayed ,please check the application");
//				logger.log(LogStatus.FAIL, objName+ "button is not displayed ,please check the application");
				
			}
		}
		
		/* name of the method:   clearElement
		 * BriefDescription  :   Clear the element
		 * Arguments         :  element-->web element
		 *  created by       :  Automation team 
		 *  created date     :  01/21/22 
		 *  LastModified Date:  01/21/22          
		 */
		public static void clearElement(WebElement element) {
			if(element.isDisplayed()) {
				element.clear();
				System.out.println("pass: element cleared");
				
			}
			else {
				System.out.println("fail: element not displayed");
				
			}
		}
	/*
	 * Name of the method: selectCheckBox
	 * Brief Description: Select the checkbox
	 * Arguments: obj --> web object, objName--> name of the object
	 * Created by: Automation team
	 * Creation Date: 01/29/22
	 * Last Modified: 01/29/22
	 * */
		public static void selectCheckBox(WebElement obj, String objName) {
			
			if(obj.isDisplayed()) {
				
				if(obj.isSelected()) {
					System.out.println("Pass: "+objName+" is already selected");
//					logger.log(LogStatus.INFO, objName + "is already selected");
					
				}else{
				obj.click();
				System.out.println("Pass: "+objName+" is selected");
//				logger.log(LogStatus.PASS, objName + "is selected");
				
			    }}
				else {
				System.out.println("Fail:"+objName+" is not present.Please chk application");	
//				logger.log(LogStatus.FAIL, objName+ " is not displayed ,please check the application");
				
			}	
		}
		
		/*
		 * Name of the method: selectDropdown
		 * Brief Description: Select the Dropdown list
		 * Arguments: obj --> web object, objName--> name of the object
		 * Created by: Automation team
		 * Creation Date: 01/29/22
		 * Last Modified: 01/29/22
		 * */
		public static void selectDropdown(WebElement obj, String objName) {
							
					if(obj.isDisplayed()) {
						obj.click();
						System.out.println("Pass: "+objName+" is  selected");
						
					}else
					{
					
						System.out.println("Fail:"+objName+" is not present.Please chk application");	
					    
				    }}
					
		/*
		 * Name of the method: dropDownGetOptions
		 * Brief Description: Select the Dropdown list
		 * Arguments: obj --> web object, objName--> name of the object
		 * Created by: Automation team
		 * Creation Date: 01/29/22
		 * Last Modified: 01/29/22
		 * */
		public static void dropDownGetOptions(WebElement element, String name) {
			Select select4 = new Select(element);
		List<WebElement> listofOptions = select4.getOptions();
		int size=listofOptions.size();
	    System.out.println("Number of elements: " +size);
	    for (WebElement webElement : listofOptions) {
	    	if(webElement.getText().equals(name)) {
	    		System.out.println("Pass: Account name is displayed in the dropdown");
	    		
		}
	    	else {
	    		System.out.println("Fail: Account name is not displayed in the dropdown");
	    		
	    	}
	    }
		}
		
		/*
		 * Name of the method: dropDownList
		 * Brief Description: Select the Dropdown list
		 * Arguments: obj --> web object, objName--> name of the object
		 * Created by: Automation team
		 * Creation Date: 01/29/22
		 * Last Modified: 01/29/22
		 * */
		public static void dropDownList(WebElement element) {
			Select select4 = new Select(element);
		    List<WebElement> listofOptions = select4.getOptions();
		    int size=listofOptions.size();
		    System.out.println("Number of elements: " +size);
	        
		}
		
		/*
		 * Name of the method: dropDownoptionsclick
		 * Brief Description: Select the Dropdown list
		 * Arguments: obj --> web object, objName--> name of the object
		 * Created by: Automation team
		 * Creation Date: 01/29/22
		 * Last Modified: 01/29/22
		 * */
		public static void dropDownoptionsclick(WebElement element, String name) {
			Select select4 = new Select(element);
		List<WebElement> listofOptions = select4.getOptions();
		int size=listofOptions.size();
		 System.out.println("Number of elements: " +size);
		for (WebElement webElement : listofOptions) {
			if(webElement.getText().equals(name))
            {
				webElement.click();
                break;
            }
			System.out.println("Pass: Account name is displayed in the dropdown");
			
				}}
		
		/*
		 * Name of the method: validateErrormsg
		 * Brief Description: to validate the error msg 
		 * Arguments: actualmsg --> name of the object, errormsg--> name of the object
		 * Created by: Automation team
		 * Creation Date: 01/29/22
		 * Last Modified: 01/29/22
		 * */
		
		public static void validateErrormessage(String actualmsg, String errormsg) {
			//Assert.assertEquals(actualmsg, errormsg);

			if(actualmsg.equalsIgnoreCase(errormsg))
			{
				System.out.println("TestCase is passed");
//				logger.log(LogStatus.PASS,  "TestCase is passed" );
				
			}else
		    {
			System.out.println("TestCase is failed");
//			logger.log(LogStatus.FAIL,  "TestCase is failed" );
		
		    }
		}

	/* name of the method:   iFrame
	 * BriefDescription  :   iframe using webelement 
	 * Arguments         :  driver--->driver 
	 *                      obj--->webelement
	 *  createdby        :  Automation team 
	 *  created date     :01/29/22 
	 *  LastModified Date:01/29/22          
	 */
	public static void switchFrame( WebDriver driver,WebElement obj) {
		 
	    if(obj.isDisplayed()) {
	     driver.switchTo().frame(obj);
	     System.out.println("Pass: we can switch to the "+obj+ " frame");
//	     logger.log(LogStatus.PASS,  "Switch to frame" );
	    
	     
	    }else {
	     System.out.println("fail: we can't switch to the "+obj+ " frame");
//	     logger.log(LogStatus.FAIL,  "Cannot Switch to frame" );
	     
	    }
	}

	/* name of the method:   switchFrameid
	 * BriefDescription  :   iframe using webelement 
	 * Arguments         :  driver--->driver 
	 *                      obj--->iframe id
	 *  createdby        :  Automation team 
	 *  created date     :01/29/22 
	 *  LastModified Date:01/29/22          
	 */

	public static void switchFrameid( WebDriver driver,String obj) {
		 
	     driver.switchTo().frame(obj);
	     System.out.println("Pass: we can switch to the "+obj+ " frame");
//	     logger.log(LogStatus.PASS,  "we can switch to the frame" );
	   
	     
	    }

	/* name of the method:   switchdefaultFrame
	 * BriefDescription  :   iframe for switching back to default frame 
	 * Arguments         :  driver--->driver 
	 *  createdby        :  Automation team 
	 *  created date     :02/13/19 
	 *  LastModified Date:02/13/19          
	 */ 
	public static void switchdefaultFrame( WebDriver driver)
	{
	driver.switchTo().defaultContent();
	System.out.println("Pass: we can switch to the "+ driver + " back to frame");
	//logger.log(LogStatus.PASS,  "we can switch back to the frame" );
	
	}

	/* name of the method:   mouseOver
	 * BriefDescription  :   mouseOver  
	 * Arguments         :  obj- webelement 
	 *  createdby        :  Automation team 
	 *  created date     :  01/29/22 
	 *  LastModified Date:  01/29/22
	 */ 

	public static void mouseOver(WebDriver driver,WebElement obj) {
		if(obj.isDisplayed()) {
	   Actions action=new Actions(driver);
	   action.moveToElement(obj).build().perform();
		System.out.println("Pass: "+obj+" is present");
//		logger.log(LogStatus.PASS,  "obj is present" );
		
		}
	 else {
			System.out.println("Fail:"+obj+" is not present.Please chk application");
//			logger.log(LogStatus.FAIL,  "obj is not present.Please chk application" );
			
		}
	}
	
	/* name of the method:   mouseHoverDoubleClick
	 * BriefDescription  :   DoubleClick  
	 * Arguments         :  obj- webelement 
	 *                         driver
	 *  createdby        :  Automation team 
	 *  created date     :  01/29/22 
	 *  LastModified Date:  01/29/22
	 */ 
	public static void mouseHoverDoubleClick(WebDriver driver, WebElement obj) {
		if(obj.isDisplayed()) {
			   Actions action=new Actions(driver);
			   action.doubleClick(obj).build().perform();
				System.out.println("Pass: "+obj+" is present");
//				logger.log(LogStatus.PASS,  "obj is present" );
				
				}
			 else {
					System.out.println("Fail:"+obj+" is not present.Please chk application");
//					logger.log(LogStatus.FAIL,  "obj is not present.Please chk application" );
					
				}

		
	}
	/* name of the method:   mouseHoverContextClick
	 * BriefDescription  :   singleclick  
	 * Arguments         :  obj- webelement 
	 *                         driver
	 *  createdby        :  Automation team 
	 *  created date     :  01/29/22 
	 *  LastModified Date:  01/29/22
	 */
	public static void mouseHoverContextClick(WebDriver driver, WebElement obj) {
		if(obj.isDisplayed()) {
			   Actions action=new Actions(driver);
			   action.contextClick(obj).build().perform();
				System.out.println("Pass: "+obj+" is present");
//				logger.log(LogStatus.PASS,  "obj is present" );
				
				}
			 else {
					System.out.println("Fail:"+obj+" is not present.Please chk application");
//					logger.log(LogStatus.FAIL,  "obj is not present.Please chk application" );
					
				}
	}

	/* name of the method:   selectbyText
	 * BriefDescription  :   selected by clicking the dropdown 
	 * Arguments         :  obj,objName- VisibleText
	 *  createdby        :  Automation team 
	 *  created date     :  01/29/22 
	 *  LastModified Date:  01/29/22
	 */ 
	public static void SelectbyText(WebElement obj, String VisibleText){
		   if(obj.isDisplayed())
		   {
			   Select selObj=new Select(obj);
	           selObj.selectByVisibleText(VisibleText);
		           System.out.println("Pass: "+VisibleText+ " is Selected by VisibleText" );
//		           logger.log(LogStatus.PASS, " is Selected by VisibleText" );
		           
		           
		   } 
		   else
		   {
		    System.out.println("Fail: "+VisibleText+ " is not available");
//		    logger.log(LogStatus.FAIL, " is not Selected by VisibleText" );
		   
		    
		   }
		   
		   
	}

	/* name of the method:   SelectByValue
	 * BriefDescription  :   selectedByValue by clicking the dropdown 
	 * Arguments         :  obj,value 
	 *  createdby        :  Automation team 
	 *  created date     :  01/29/22 
	 *  LastModified Date:  01/29/22          
	 */ 
	public static void SelectByValue(WebElement obj, String val) {
		  //if(obj.isSelected()) {
		if(obj.isDisplayed()) {
		   Select selObj=new Select(obj);
		    
		   selObj.selectByValue(val);
		  System.out.println("pass:"+val + " is selected from drop down ");
//		  logger.log(LogStatus.PASS, " is selected from drop down " );
		 
		 
		  }else {
		   System.out.println("Fail:"+val+"is not selected");
//		   logger.log(LogStatus.FAIL, " is not selected from drop down " );
		
		  }
		 }	  


	/* name of the method:   SelectByindex
	 * BriefDescription  :   selected by clicking the dropdown 
	 * Arguments         :  obj,index 
	 *  createdby        :  Automation team 
	 *  created date     :  01/29/22 
	 *  LastModified Date:  01/29/22          
	 */ 
	public static void selectByIndex(WebElement obj, int index) {
		  if(obj.isDisplayed()) {
		   Select selObj=new Select(obj);
		  selObj.selectByIndex(index);
		  
		  System.out.println("pass:"+index + " is selected from drop down ");
//		  logger.log(LogStatus.PASS, " is selected from drop down " );
		  
		  }else {
		   System.out.println("Fail:"+index+"is not selected");
//		   logger.log(LogStatus.FAIL, " is not selected from drop down " );
		  
		  }
		 }
      
	/* name of the method:   selectByVisibleText
	 * BriefDescription  :   selected by clicking the dropdown 
	 * Arguments         :  obj,VisibleText 
	 *  createdby        :  Automation team 
	 *  created date     :  01/29/22 
	 *  LastModified Date:  01/29/22          
	 */ 
	public static void selectByVisibleText(WebElement obj, String Name) {
		if(obj.isDisplayed()) {
			 Select drop = new Select(obj);
			 drop.selectByVisibleText(Name);
		 System.out.println("Pass: dropdown is selected");
		
		 }else {
		 System.out.println("Fail: dropdown is not available check your application");
		
		 }
		 }



	/*
	 * Name of the method: Radiobutton
	 * Brief Description: To click on the radio button 
	 * Arguments: obj --> web object, objName--> name of the object
	 * Created by: Automation team
	 * Creation Date: 01/29/22
	 * Last Modified: 01/29/22
	 * */
	public static void Radiobutton(WebElement obj, String objName) {
		
		if(obj.isDisplayed() ){
			obj.click();
			System.out.println("Pass: "+objName+" is clicked");
			
		}else {
			System.out.println("Fail:"+objName+" is not displayed .Please check your application");	
			
		}
	}

	/* name of the method:   switchtoAlert
	 * BriefDescription  :   Switch to alert
	 * Arguments         :  driver
	 *  createdby        :  Automation team 
	 *  created date     :  01/29/22 
	 *  LastModified Date:  01/29/22          
	 */ 
	public static void switchtoAlert(WebDriver driver) {
		 driver.switchTo().alert().accept();
		 System.out.println("Pass: alert is present and accept");
		
	}
	public String getTitleOfThePage() {
		return driver.getTitle();
	}
	
	}
	


