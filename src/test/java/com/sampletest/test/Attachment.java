package com.sampletest.test;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;

public class Attachment extends AppTest{
	
//...........Sending attachment using camera option...........
	public void camera() throws InterruptedException
	{
		MobileElement camera = (MobileElement) driver.findElementById("com.freshworks.freshconnect.staging:id/cameraImageView");
		camera.click();
		Thread.sleep(2000);
		MobileElement shutter_button = (MobileElement) driver.findElementByAccessibilityId("Shutter button");
		shutter_button.click();
		Thread.sleep(5000);
		MobileElement Done_in_camera = (MobileElement) driver.findElementById("com.android.camera:id/btn_done");
		Done_in_camera.click();
		Thread.sleep(2000);
		MobileElement send_attach = (MobileElement) driver.findElementById("com.freshworks.freshconnect.staging:id/sendAttachmentsIcon");
		send_attach.click();
		Thread.sleep(5000);
	}
	
	
//...........Sending attachment using gallery option...........
	public void gallery() throws InterruptedException
	{
		MobileElement gallery = (MobileElement) driver.findElementById("com.freshworks.freshconnect.staging:id/gallaryImageView");
		gallery.click();
		Thread.sleep(2000);
        //MobileElement allow = (MobileElement) driver.findElementById("com.android.packageinstaller:id/permission_allow_button");
		//allow.click();
		//Thread.sleep(2000);
		MobileElement image_gallery = (MobileElement) driver.findElementById("com.freshworks.freshconnect.staging:id/attachmentChooserImageView");
		image_gallery.click();
		MobileElement Done_in_gallery = (MobileElement) driver.findElementById("com.freshworks.freshconnect.staging:id/menuAttachmentsDone");
		Done_in_gallery.click();
		Thread.sleep(1000);
		MobileElement send_attach = (MobileElement) driver.findElementById("com.freshworks.freshconnect.staging:id/sendAttachmentsIcon");
		send_attach.click();
		Thread.sleep(5000);
	}
	
	
//...........Sending multi-attachment...........	
	public void multiAttachment() throws InterruptedException
	{
		MobileElement gallery = (MobileElement) driver.findElementById("com.freshworks.freshconnect.staging:id/gallaryImageView");
		gallery.click();
		Thread.sleep(2000);
		MobileElement image_1 = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[1]/android.widget.ImageView");
		image_1.click();
		MobileElement image_2 = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[2]/android.widget.ImageView");
		image_2.click();
		MobileElement image_3 = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[3]/android.widget.ImageView");
		image_3.click();
		MobileElement image_4 = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[4]/android.widget.ImageView");
		MobileElement Deselect_all = (MobileElement) driver.findElementById("com.freshworks.freshconnect.staging:id/menuAttachmentsDeselectAll");
		Deselect_all.click();
		Thread.sleep(1000);
		image_1.click();
		Thread.sleep(1000);
		image_3.click();
		Thread.sleep(1000);
		image_4.click();
		Thread.sleep(1000);
		MobileElement Done_in_gallery = (MobileElement) driver.findElementById("com.freshworks.freshconnect.staging:id/menuAttachmentsDone");
		Done_in_gallery.click();
		Thread.sleep(1000);
		MobileElement send_attach = (MobileElement) driver.findElementById("com.freshworks.freshconnect.staging:id/sendAttachmentsIcon");
		send_attach.click();
		Thread.sleep(5000);
	}
	
	@Test
	public void sendingAttachment() throws InterruptedException
	{
		CM();
		MobileElement attach_icon = (MobileElement) driver.findElementById("com.freshworks.freshconnect.staging:id/attachmentImageButton");
		attach_icon.click();
		multiAttachment();
		/*gallery();
		attach_icon.click();
		camera();*/
		Thread.sleep(2000);
	}
}