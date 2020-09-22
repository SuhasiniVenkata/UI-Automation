package applications;

import org.testng.annotations.Test;

import utilities.Page;

public class Timestamps_Register extends Page {

	public Timestamps_Register() {

	}

	static Timestamps_Register sp = new Timestamps_Register();
	// Registration user successfully.
	public void Successful_Tests() {

		sp.go();
		sp.click("timestamps.registration.Home");
		sp.enter_text("timestamps.registration.UserName", "Suhasini");
		sp.clear_text("timestamps.registration.Email");
		sp.enter_text("timestamps.registration.Email", "Suhasini@gmail.com");
		sp.enter_text("timestamps.registration.Password", "np12345");
		sp.click("timestamps.registration.Done");
		sp.click("timestamps.registration.Logout");

	}
 // Registration user with invalid format
	public void Negative_Tests() {
		sp.go();
		sp.click("timestamps.registration.Home");
		sp.enter_text("timestamps.registration.UserName", "Suhasini");
		sp.enter_text("timestamps.registration.Email", "Suhasini");
		sp.AssertTest("Please include an '@' in the email address.Test_nonRegistered is missing @",
				"Please include an '@' in the email address.Test_nonRegistered is missing @");
		sp.enter_text("timestamps.registration.Password", "np12345");
		sp.click("timestamps.registration.Done");
		sp.quit();

	}

	@Test
	public static void register_new() {
		sp.Successful_Tests();
		sp.Negative_Tests();
		sp.quit();
	}

}
