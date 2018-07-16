package Application.Mobile.UIActions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

public class HomePage {
	
	@FindBy(xpath="//android.widget.TextView[@text='API Demos']")
	public WebElement homePageTitle;
	
	@FindBy(xpath="//android.widget.TextView[@text='Preference']")
	public WebElement preferenceLink;
	
	
	public HomePage(AndroidDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String veryfyingHomePageTitle() 	
	{
		try
		{
		
		//return homePageTitle.getText();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return homePageTitle.getText();
	}
	
	public void clickOnPreferenceLink() throws Exception
	{
		try
		{
		preferenceLink.click();
		}
		catch(Exception e)
		{
			throw(e);
		}
	}

}
