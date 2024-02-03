package genricUtilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import PomPages.AddNewCtegoryPage;
import PomPages.AddNewPageCourse;
import PomPages.AddNewUserPage;
import PomPages.CategoryPage;
import PomPages.CourseListPage;
import PomPages.HomePage;
import PomPages.UserPage;
import PomPages.loginPage;

public class BaseClass {
	protected WebDriver driver;
	protected PropertiesUtility property;
	protected javaUtility jutil;
	protected WebDriverUtility web;
	protected ExecelUtility excel;
	
	protected loginPage login;
	protected HomePage home;
	protected UserPage users;
	protected CourseListPage courseList;
	protected CategoryPage category;
	protected AddNewUserPage addUser;
	protected AddNewPageCourse addCourse;
	protected AddNewCtegoryPage addCategory;
	
	public static WebDriver sdriver;
	public static javaUtility sjutil;
	
	//@BeforeSuite
	//@BeforeTest
	@BeforeClass
	public void classSetup() {
		web = new WebDriverUtility();
		jutil = new javaUtility();
		property = new PropertiesUtility();
		excel = new ExecelUtility();
		
		property.propertiesInit(IConstantPath.PROPERTIES_FILE_PATH);
		
		driver = web.launchBrowserAndMaximize(property.readFromProperties("browser"));
		web.waitTillElementFound(Long.parseLong(property.readFromProperties("timeouts")));
		sdriver=driver;
		sjutil=jutil;
	}
	@BeforeMethod
	public void methodSetup() {
		login = new loginPage(driver);
		home = new HomePage(driver);
		users = new UserPage(driver);
		courseList = new CourseListPage(driver);
		category = new CategoryPage(driver);
		addUser = new AddNewUserPage(driver);
		addCourse = new AddNewPageCourse(driver);
		addCategory = new AddNewCtegoryPage(driver);
		
		excel.excelInit(IConstantPath.EXCEL_PATH, "Sheet1");
		
		web.navigateToApp(property.readFromProperties("url"));
		Assert.assertEquals(login.getPageHeader(), "Login");
		login.loginToApp(property.readFromProperties("username"), property.readFromProperties("password"));
		property.readFromProperties("password");
		Assert.assertEquals(home.getPageHeader(), "Home");
	}
	
	@AfterMethod
	public void methodTearDown() {
		excel.closeExcel();
		home.signOutOfApp();
	}
	@AfterClass
	public void classTearDown() {
		
		
	}
	//@AfterTest
	//@AfterSuite
	
}