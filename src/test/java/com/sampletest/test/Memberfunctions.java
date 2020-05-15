package com.sampletest.test;

import io.appium.java_client.MobileElement;

public class Memberfunctions extends AppTest{
	
	public void members() throws InterruptedException
	{
		CM();
		Thread.sleep(2000);
		MobileElement first_member = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView[2]");
		first_member.click();
		MobileElement first_member_TM = (MobileElement) driver.findElementById("com.freshworks.freshconnect.staging:id/toolbarTitle");
		first_member_TM.click();
    	if(first_member.getText().equals(first_member_TM.getText()))
    		;
    	
	}

}
