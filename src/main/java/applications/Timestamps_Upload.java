package applications;

import org.testng.annotations.Test;

import utilities.Page;

public class Timestamps_Upload extends Page {
	public Timestamps_Upload() {

	}

	static Timestamps_Upload Upload = new Timestamps_Upload();

	public void Successful_Tests_Delete() {
		Upload.go();
		Upload.click("timestamps.Login.Home");
		Upload.enter_text("timestamps.Login.Email", "Suhasini123@gmail.com");
		Upload.enter_text("timestamps.Login.Password", "np12345");
		Upload.click("timestamps.Login.Done");
		Upload.click("timestamps.Login.Edit_Profile");
		Upload.enter_text("timestamps.Login.EditUserName", "Updated Name");
		Upload.enter_text("timestamps.Login.EditEmail", "Suhasini123@gmail.com");
		Upload.enter_text("timestamps.registration.Password", "np12345");
		Upload.click("timestamps.Login.DeleteProfile");
		Upload.alert("timestamps.Login.AlertPopUp", "ok");
		Upload.quit();
	}

	public void Successful_Tests() {
		Upload.go();
		Upload.click("timestamps.Login.Home");
		Upload.enter_text("timestamps.Login.Email", "Suhasini123@gmail.com");
		Upload.enter_text("timestamps.Login.Password", "np12345");
		Upload.click("timestamps.Login.Done");
		Upload.click("timestamps.NewNote.Home");
		Upload.enter_text("timestamps.NewNote.Title", "My First Movie Trailer");
		Upload.click("timestamps.NewNote.Done");
		Upload.enter_text("timestamps.Upload.Upload_Link", "https://www.youtube.com/watch?v=KAOdjqyG37A");
		Upload.enter_text("timestamps.Upload.Title", "Movie Trailer");
		Upload.click("timestamps.Upload.Done");
		Upload.click("timestamps.Upload.getTime");
		Upload.enter_text("timestamps.Upload.text_body", "NewSeleniumWebDriver");
		Upload.click("timestamps.Upload.body_Done");
		Upload.pause(20);
		Upload.click("timestamps.Login.Home");
		Upload.click("timestamps.Login.ClickProfile");
		Upload.click("timestamps.Login.Logout");

	}

	public void Delete_Note() {
		Upload.go();
		Upload.click("timestamps.Login.Home");
		Upload.enter_text("timestamps.Login.Email", "Suhasini123@gmail.com");
		Upload.enter_text("timestamps.Login.Password", "np12345");
		Upload.click("timestamps.Login.Done");
		Upload.click("timestamps.NewNote.NoteLink");
		Upload.click("timestamps.NewNote.Note_edit");
		Upload.click("timestamps.NewNote.Note_Delete");
		Upload.alert("timestamps.Login.AlertPopUp", "ok");
		Upload.click("timestamps.Login.Logout");

	}

	@Test
	public static void upload() {
		Upload.Delete_Note();
		Upload.Successful_Tests();
		Upload.Successful_Tests_Delete();
		Upload.quit();

	}

}
