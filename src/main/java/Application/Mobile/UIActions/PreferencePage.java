package Application.Mobile.UIActions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class PreferencePage {
	
	@FindBy(xpath="//android.widget.TextView[@text='3. Preference dependencies']")
	public WebElement preferencedependency;
	
	
	public PreferencePage(AndroidDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnPreferencedependency()
	{
		preferencedependency.click();
	}

}
