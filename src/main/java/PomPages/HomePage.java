package PomPages;	

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class {

		//Declaration
		@FindBy(xpath = "//b[text()='Add New Category']")
		private WebElement pageHeader;
		
		@FindBy(xpath = "//input[@id='name']")
		private WebElement nameTF;
		
		@FindBy(xpath = "//button[text()=' Save' and @name='add']")
		private WebElement saveButton;
		
		//Initialization
		public HomePage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		//Utilization
		public String getPageHeader() {
			return pageHeader.getText();
		}
		public void setName(String courseName) {
			nameTF.sendKeys(courseName);
		}
		public void clickSve() {
			saveButton.click();
		}

}