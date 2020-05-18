package com.sampletest.test;

import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;

public class Memberfunctions extends AppTest{
	
	@Test
	public void members() throws InterruptedException
	{
		CM();
		Thread.sleep(2000);
		MobileElement first_member = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView[2]");
		String member_one = first_member.getText();
		first_member.click();
		Thread.sleep(5000);
		MobileElement first_member_TM = (MobileElement) driver.findElementById("com.freshworks.freshconnect.staging:id/toolbarTitle");
		Thread.sleep(1000);
    	if(member_one.equals(first_member_TM.getText()))
    	{
    		Thread.sleep(2000);
    		super.sendMessage("Reached TM");
    	}
    	backButton();
    	Thread.sleep(5000);
	}

}
