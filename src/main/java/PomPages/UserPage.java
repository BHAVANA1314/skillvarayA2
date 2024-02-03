package PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPage {
 //Declaration
	@FindBy(xpath="//h1[normalize-space())='User']")
	private WebElement pageHeader;
	
	@FindBy(xpath="//a[text()='New']")
	private WebElement newButton;
	
	//Initialization
	public UserPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Utilization
	public String getPageHeader() {
		return pageHeader.getText();
	}
	public void clickNewButton() {
		newButton.click();
	}
}