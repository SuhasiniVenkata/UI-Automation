package applications;

import org.testng.annotations.Test;

import utilities.Page;

public class Timestamps_Login extends Page {

	public Timestamps_Login() {

	}

	static Timestamps_Login Login = new Timestamps_Login();
	// Registered user try to login and Edit Profile

	public void Successful_Tests() {

		Login.go();

		Login.click("timestamps.Login.Home");
		Login.enter_text("timestamps.Login.Email", "Suhasini@gmail.com");
		Login.enter_text("timestamps.Login.Password", "np12345");
		Login.click("timestamps.Login.Done");
		Login.pause(20);
		Login.click("timestamps.NewNote.Home");
		Login.enter_text("timestamps.NewNote.Title", "TestUpload");
		Login.click("timestamps.NewNote.Done");
		Login.pause(20);
		Login.click("timestamps.Login.Home");
		Login.click("timestamps.Login.Edit_Profile");
		Login.clear_text("timestamps.Login.EditUserName");
		Login.enter_text("timestamps.Login.EditUserName", "Updated Name");
		Login.clear_text("timestamps.Login.EditEmail");
		Login.enter_text("timestamps.Login.EditEmail", "Suhasini123@gmail.com");
		Login.enter_text("timestamps.registration.Password", "np12345");
		Login.click("timestamps.Login.SaveProfile");
		Login.click("timestamps.Login.Logout");
		Login.quit();
		Login.pause(20);

	}

	// Registered user try to login with edited Profile
	public void Successful_Tests1() {
		Login.go();
		Login.click("timestamps.Login.Home");
		Login.enter_text("timestamps.Login.Email", "Suhasini@gmail.com");
		Login.enter_text("timestamps.Login.Password", "np12345");
		Login.click("timestamps.Login.Done");
		Login.AssertTest("timestamps.Login.InvalidPassword", "Error on login");
		Login.enter_text("timestamps.Login.Email", "Suhasini123@gmail.com");
		Login.enter_text("timestamps.Login.Password", "np12345");
		Login.click("timestamps.Login.Done");
		Login.click("timestamps.Login.Edit_Profile");
		Login.click("timestamps.Login.SaveProfile");
		Login.click("timestamps.Login.Logout");
		Login.quit();

	}

	// Registered user try to login with invalid format
	public void negative_Tests() {
		Login.go();
		Login.click("timestamps.Login.Home");
		Login.enter_text("timestamps.Login.Email", "Suhasini@gmalil.");
		Login.get_text("timestamps.Login.Email");
		Login.click("timestamps.Login.Done");
		Login.pause(20);
		Login.enter_text("timestamps.Login.Password", "np12345");
		Login.AssertTest("timestamps.Login.Email", "'.' is used at a wrong postion in 'gmalil'");

	}

	// Non-registered user try to login
	public void negative_Tests_1() {
		Login.go();
		Login.click("timestamps.Login.Home");
		Login.enter_text("timestamps.Login.Email", "test1234@gmail.com");
		Login.enter_text("timestamps.Login.Password", "np12345");
		Login.click("timestamps.Login.Done");
		Login.pause(5);
		Login.AssertTest("timestamps.Login.InvalidPassword", "Error on login");

	}

	// Registered user try to login with incorrect password
	public void negative_Tests_2() {
		Login.go();
		Login.click("timestamps.Login.Home");
		Login.enter_text("timestamps.Login.Email", "Suhasini@gmail.com");
		Login.enter_text("timestamps.Login.Password", "Test1234");
		Login.click("timestamps.Login.Done");
		Login.pause(20);
		Login.AssertTest("timestamps.Login.InvalidPassword", "Error on login");

	}

	@Test
	public static void test() {

		Login.negative_Tests_1();
		Login.negative_Tests_2();
		Login.Successful_Tests();
		Login.Successful_Tests1();
		Login.quit();

	}

}
