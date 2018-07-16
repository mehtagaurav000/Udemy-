package Application.Mobile.UIActions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

public class WifiSettingsPage {
	
	@FindBy(xpath="//android.widget.TextView[@text='Preference/3. Preference dependencies']")
	public WebElement wifiPageTitle;
	
	@FindBy(xpath="//android.widget.CheckBox")
	public WebElement wifiCheckbox;
	
	public WifiSettingsPage(AndroidDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyingWifiPageTitle()
	{
		return wifiPageTitle.getText();
		
	}
	
	public void enableWifi()
	{
		wifiCheckbox.click();
	}
	
	

}
