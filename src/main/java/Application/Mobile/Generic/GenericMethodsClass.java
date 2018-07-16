package Application.Mobile.Generic;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Formatter;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import Application.Mobile.ExcelReader.ExcelReader;
import Application.Mobile.UIActions.HomePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class GenericMethodsClass{
	
	private static final int OutputType = 0;
	File f;
	File fs;
	String appFolderName;
	String apkName;
	String appiumURL;
	String deviceName;
	public AndroidDriver <AndroidElement> driver;
	
	public void excelReader() throws Exception
	{
		try
		{
		ExcelReader excel=new ExcelReader(new File(System.getProperty("user.dir")).getAbsolutePath()+"/src/main/java/Application/Mobile/Data/Excel Data.xlsx");
		appFolderName=	excel.getCellData("Mobile APP", "APP Folder name", 2);
		System.out.println("App folder anme is:"+appFolderName);
		apkName=excel.getCellData("Mobile APP", "App File Name",2);
		System.out.println("App apk file name is:"+apkName);
		appiumURL=excel.getCellData("Mobile APP", "URL", 2);
		System.out.println("Appium Url is:"+appiumURL);
		deviceName=excel.getCellData("Mobile APP", "Device Name", 2);
		}
		catch(Exception e)
		{
			throw(e);
		}
	}
	
	
	public void settingAppPath() throws Exception
	{
		try
		{
		 f= new File(appFolderName);
		 fs=new File(f,apkName);
		}
		catch(Exception e)
		{
			throw(e);
		}
	}
	
	public void settingCapabilities()
	{
		try {
		DesiredCapabilities cap= new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME ,deviceName);
		cap.setCapability(MobileCapabilityType.APP,fs.getAbsolutePath());
		driver=new AndroidDriver<AndroidElement>(new URL(appiumURL), cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		PageFactory.initElements(driver, this);
		System.out.println("Github Test");
		
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void takeScreenshot(String name) throws IOException
	{
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat date=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(org.openqa.selenium.OutputType.FILE);
		
		String reportDirectory=new File(System.getProperty("user.dir")).getAbsolutePath()+"/src/main/java/Application/Mobile/Screenshots/Screenshots/";
		String s1=date.format(cal.getTime());
		System.out.println("S1 value came as:"+s1);
		File destnFile=new File((String)reportDirectory+name+"_"+s1+".png");
		
		//File destnFile=new File((String)reportDirectory+"Name"+"_"+".png");
		
		FileUtils.copyFile(srcFile, destnFile);
		
		Reporter.log("<a href='"+destnFile.getAbsolutePath()+"'> <img src='"+destnFile.getAbsolutePath()+"'height='100' width='100'/> </a>");
		
		
	}

}
