package com.sampletest.test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class AppTest 
{
	public AppiumDriver<MobileElement> driver;
	
//.............Setup function.............
	@BeforeClass
	public void setup() throws Exception
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName","Android");
		cap.setCapability("platformName","android");
		cap.setCapability("platformVersion","6");
		cap.setCapability("udid","emulator-5554");
		cap.setCapability("appPackage","com.freshworks.freshconnect.staging");
		cap.setCapability("appActivity","com.freshworks.freshconnect.home.HomeActivity");
		cap.setCapability("noReset","true");
		System.out.println("Before Class");
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url , cap);
	}
	
	
//.............Login function.............
	public void login() throws InterruptedException 
    {
    	MobileElement domain_text = (MobileElement) driver.findElementById("com.freshworks.freshconnect.staging:id/urlEditText");
    	domain_text.clear();
    	domain_text.sendKeys("freshworks593.fconstage.io");
    	MobileElement next_button = (MobileElement) driver.findElementById("com.freshworks.freshconnect.staging:id/loginFreshConnectButton");
    	next_button.click();
    	Thread.sleep(50000);
    	MobileElement email = (MobileElement) driver.findElementByXPath("(//android.view.View[@content-desc=\"Email\"])[1]/android.widget.EditText");
    	email.sendKeys("kiran@yopmail.com");
    	MobileElement password = (MobileElement) driver.findElementByXPath("//android.view.View[@content-desc=\"Password \"]/android.view.View[2]/android.widget.EditText");
    	password.sendKeys("test1234");
    	MobileElement sign_in = (MobileElement) driver.findElementByAccessibilityId("SIGN IN");
    	sign_in.click();
    	Thread.sleep(1000);
    }
	
	
//...................CM More options in convo. page............................
	public void cmMoreOptions(String option) throws InterruptedException
	{
		MobileElement cm_more_options = (MobileElement) driver.findElementById("com.freshworks.freshconnect.staging:id/menu_header");
    	cm_more_options.click();
    	Thread.sleep(2000);
    	switch(option)
    	{
    		case "Mute" : MobileElement mute = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@text,\"Mute this discussion\")]");
    				  	  mute.click();
    				      break;
    		case "Unmute" : MobileElement unmute = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@text,\"Unmute this discussion\")]");
    					    unmute.click();
    					    break;	
    		case "Pin this conversation" : MobileElement pin_this_conversation = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@text,\"Pin this conversation\")]");
    								       pin_this_conversation.click();
    								       break;
    		case "Unpin this conversation" : MobileElement unpin_this_conversation = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@text,\"Unpin this conversation\")]");
        									 unpin_this_conversation.click();
        									 break;
    		case "Members" : MobileElement members = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@text,\"Members\")]");
        					 members.click();
        					 break;
    		case "Ticket Details" : MobileElement ticket_details = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@text,\"Ticket Details\")]");
        							ticket_details.click();
        							break;
    	}
	}
	
    
//.............Send message function..................
    public void sendMessage(String message) throws InterruptedException
    {
    	MobileElement text_area = (MobileElement) driver.findElementById("com.freshworks.freshconnect.staging:id/messageEditText");
    	//text_area.click();
    	text_area.sendKeys(message);
    	MobileElement send__button = (MobileElement) driver.findElementById("com.freshworks.freshconnect.staging:id/sendMessage");
    	send__button.click();
    	Thread.sleep(2000);
    }
    
    
//.............Naviagte up function.............
    public void backButton()
    {
    	MobileElement back_button = (MobileElement) driver.findElementByAccessibilityId("Navigate up");
    	back_button.click();
    }
    
    
//.............reply function using swipe action.............
    public void replyAction() throws InterruptedException
    {
    	
  	  	/*.press(PointOption.point(221,1525))
  	  	.moveTo(PointOption.point(697,1521))
  	  	.release()
  	  	.perform();*/
    	MobileElement message = (MobileElement) driver.findElementByXPath("//android.widget.FrameLayout[3]/android.view.ViewGroup");
  	  	Thread.sleep(2000);
    	MobileElement reply = (MobileElement) driver.findElementByAccessibilityId("Reply");
  	  	reply.click();
  	  	sendMessage("Reply message");
    }
    
    
    public void swipeToTicketDetailsPage()
    {
    	MobileElement title = (MobileElement) driver.findElementById("com.freshworks.freshconnect.staging:id/toolbarTitleTextView");
		String discussion_title = title.getText();
    	Dimension size = driver.manage().window().getSize();
		int startx = (int) (size.width * 0.8);
		int endx = (int) (size.width * 0.05);
		int starty = size.height / 2;
		new TouchAction<>(driver).press(PointOption.point(startx, starty))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(endx, starty))
				.release().perform();
		System.out.println("Swipe action is done");
		String td_title = title.getText();
		if(discussion_title.equals(td_title))
			System.out.println("Titles are same");
		
    }
    
    
    public void swiptToBottom() throws InterruptedException
	{
    	Thread.sleep(2000);
		Dimension dim = driver.manage().window().getSize();
		int height = dim.getHeight();
		int width = dim.getWidth();
		int x = width/2;
		int starty =(int)(height*0.20) ;
		int endy = (int)(height);
		new TouchAction(driver)
		.press(PointOption.point(x,starty))
		.moveTo(PointOption.point(x,endy))
		.release()
		.perform();
		Thread.sleep(2000);
		MobileElement scroll_icon = (MobileElement) driver.findElementById("com.freshworks.freshconnect.staging:id/scrollToBottomIcon");
		scroll_icon.click();
		Thread.sleep(2000);
	}
    
    
//................CM functionalities................  
	@Test
    public void CM() throws InterruptedException
    {
    	Thread.sleep(3000);
    	//MobileElement title = (MobileElement) driver.findElementById("com.freshworks.freshconnect.staging:id/toolbarTitle");
//    	if(title.getText().equals("Team Messages"))
//    	{
//    		System.out.println("TM header is correct");
//    	}
//    	else
//    	{
//    		driver.quit();
//    	}
    	MobileElement Ham_burger = (MobileElement) driver.findElementByAccessibilityId("Navigate up");
    	Ham_burger.click();
    	Thread.sleep(1000);
    	
    	MobileElement Ham_cm = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@text,\"Contextual Discussions\")]");
    	Ham_cm.click();
    	Thread.sleep(10000);
    	
//    	if(title.getText().equals("Contextual Discussions"))
//    	{
//    		System.out.println("CM header is correct");
//    	}
//    	else
//    	{
//    		driver.quit();
//    	}
    	
    	
    	MobileElement first_ticket = (MobileElement) driver.findElementByXPath("//android.widget.FrameLayout[1]/android.view.ViewGroup[2]");
    	first_ticket.click();
    	Thread.sleep(5000);
    	
    	MobileElement unread_banner = (MobileElement) driver.findElementById("com.freshworks.freshconnect.staging:id/unReadBarTextView");
    	System.out.println(unread_banner.getText());
    	
//    	swiptToBottom();
//    	System.out.println();
//    	Dimension size = driver.manage().window().getSize();
//    	//System.out.println(size.getHeight()+" "+size.getWidth());
//		int starty = (int) (size.height * 0.8);
//		int endy = (int) (size.height * 0.2);
//		int startx = size.width / 2;
//		new TouchAction<>(driver).press(PointOption.point(startx, starty))
//				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(PointOption.point(startx, endy))
//				.release().perform();
//    	Thread.sleep(2000);
    	
//    	Dimension size = driver.manage().window().getSize();
//		int anchor = (int) (size.width * 50);
//		int startPoint = (int) (size.height * startPercentage);
//		int endPoint = (int) (size.height * endPercentage);
//		new TouchAction<>(driver).press(point(anchor, startPoint)).waitAction(waitOptions(ofMillis(1000)))
//				.moveTo(point(anchor, endPoint)).release().perform();
    	
    	
    	
    	
    	//cmMoreOptions("Members");
    	
    	
//    	MobileElement ticket = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[1]/android.widget.TextView[1][contains(@text,\"Timestamp check ticket\")]");
//    	ticket.click();
    	
    	
    	
//   	replyAction();
//    	new TouchActions(driver).longPress(first_ticket).perform();
//    	Thread.sleep(2000);
    	
//    	sendMessage("Hii!! Test Test");
//    	Thread.sleep(2000);
//    	
//    	cmMoreOptions("Ticket Details");
//    	Thread.sleep(2000);
//    	
//    	backButton();
//    	Thread.sleep(2000);
//    	
//    	ticket.click();
//    	Thread.sleep(5000);
//    	
//    	cmMoreOptions("Pin this conversation");
//    	backButton();
//    	Thread.sleep(2000);
    }
    
//..............Quit function.................
    @AfterClass
    public void quit() 
    {
    	System.out.println("After Class");
    	driver.quit();
    }
}
