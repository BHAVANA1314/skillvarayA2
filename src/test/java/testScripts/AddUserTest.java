package testScripts;
	import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genricUtilities.BaseClass;




	public class AddUserTest extends BaseClass{
		@Test
		public void addUserTest() {
			SoftAssert soft = new SoftAssert();
			
			home.clickUsersTab();
			soft.assertTrue(users.getPageHeader().contains("Users"));
			users.clickNewButton();
			soft.assertEquals(addUser.getPageHeader(), "Add New User");
			
			Map<String,String> map = excel.readFromExcel("Add users");
			
			addUser.setEmail(map.get("Email"));
			addUser.setPassword(map.get("Password"));
			addUser.setFirstname(map.get("FirstName"));
			addUser.setLastname(map.get("Lastname"));
			addUser.setAddress(map.get("Address"));
			addUser.setContactInfo(map.get("Contact info"));
			addUser.uploadPhoto(map.get("photo"));
			addUser.clickSave();
			
			soft.assertEquals(users.getSuccessMessage(), "Success!");
			soft.assertAll();
		}

}