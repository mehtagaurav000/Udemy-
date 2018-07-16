package Application.Mobile.TestSuites;

import java.io.IOException;

import org.junit.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Application.Mobile.UIActions.HomePage;
import Application.Mobile.UIActions.PreferencePage;
import Application.Mobile.UIActions.WifiSettingsPage;

import junit.framework.Assert;

public class TestClassMethods extends Application.Mobile.Generic.GenericMethodsClass {
	
	
	HomePage homePageObj;
	PreferencePage preferencePageObj;
	WifiSettingsPage wifiSettingsPageObj;
	
	@BeforeTest
	public void beforeClass() throws Exception
	{
		excelReader();
		settingAppPath();
		settingCapabilities();
	}
	@Test(priority=0)
	public void tc0001() throws Exception
	{
		try
		{
		System.out.println("App launched successfully");
		homePageObj=new HomePage(driver);
		//homePageObj.veryfyingHomePageTitle();
		Assert.assertEquals("API Demos", homePageObj.veryfyingHomePageTitle());
		homePageObj.clickOnPreferenceLink();
		preferencePageObj=new PreferencePage(driver);
		preferencePageObj.clickOnPreferencedependency();
		wifiSettingsPageObj=new WifiSettingsPage(driver);
		takeScreenshot("Gaurav_");
		Assert.assertEquals("Preference/3. Preference dependencies", wifiSettingsPageObj.verifyingWifiPageTitle());
		wifiSettingsPageObj.enableWifi();
		}
		catch(Exception e)
		{
			throw(e);
		}
	}
	private void takeScreenshot() {
		// TODO Auto-generated method stub
		
	}
}
