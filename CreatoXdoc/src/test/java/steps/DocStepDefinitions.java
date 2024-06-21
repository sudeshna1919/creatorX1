package steps;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import pages.*;

public class DocStepDefinitions {
	
	WebDriver driver;
	
	DocPage dP;
	
	@After
	public void tearDown() {
        BasePage.quitDriver();
    }
	
	@Given("user is on add doc page")
	public void user_is_on_add_doc_page() throws IOException {
	
		BasePage.initializeWebDriver();
	
		driver = BasePage.driver;
	
		dP = new DocPage(driver);
	
    
	}

	@When("user clicks on Create a New Feature documentation")
	public void user_clicks_on_create_a_new_feature_documentation() {
    
		dP.click_Create();
	}

	@Then("user should be navigated to Add New Feature Documentation section form")
	public void user_should_be_navigated_to_add_new_feature_documentation_section_form() {
    
		Assert.assertTrue(dP.display_upload());
	}

	@And("^user enters (.*),  (.*),  (.*)  and  (.*)$")
	public void user_enters_title_sub_section_title_sub_sub_section_and_content(String title, String sub_title, String subSub_title, String content) {
    
		dP.write_Title(title);
	
		dP.sub_title(sub_title);
	
		dP.sub_sub_title(subSub_title);
	
		dP.write_content(content);
	
	
	}

	@When("user clicks on upload documentation")
	public void user_clicks_on_upload_documentation() throws InterruptedException {

		dP.uplod_doc();
	}

	@Then("user should be navigated to selection page")
	public void user_should_be_navigated_to_selection_page() throws InterruptedException {
	
		Thread.sleep(2000);
	
		Assert.assertTrue(dP.check_create());
		
		System.out.println("user should be navigated to selection page");
    
	}

	@Then("upload should be disabled")
	public void upload_should_be_disabled() {
	
		Assert.assertTrue(dP.check_upload());
		
		System.out.println("upload should be disabled");
	}

	
	@When("user clicks on Add a New subsection without selecting existing feature")
	public void user_clicks_on_add_a_new_subsection_without_selecting_existing_feature() {
	   
		dP.click_for_dropdown();
		
		dP.click_add_new_Sub_Section();
	}

	@Then("Add a New Sub section button should be disabled")
	public void Add_a_New_Sub_section_button_should_be_disabled() throws InterruptedException {
		
		String expected = "Select an existing Feature";
		
		String actual = dP.check_Selected_Option();
		
		if(actual.contains(expected)) {
		
			Assert.assertTrue(dP.check_add_new_subSection());
		}
		
		
		System.out.println("Add a New Sub section button should be disabled");
		
		
	}
	
	@When("^user selects (.*)$")
	public void user_selects_feature(String option) throws InterruptedException {
		
		
		dP.select_option(option);
	}
	
	@Then("Add a New Sub section button should be enabled")
	public void Add_a_New_Sub_section_button_should_be_enabled() throws InterruptedException {
		
		String expected = "Select an existing Feature";
		
		String actual = dP.check_Selected_Option();
		
		if(!(actual.equals(expected))) {
		
			Assert.assertFalse(dP.check_add_new_subSection());
			
		}
		
				
	}
	
	@And("clicks on Add a New Sub section button")
	public void clicks_on_Add_a_New_Sub_section_button() {
		
		dP.click_add_new_Sub_Section();
	}
	
	@Then("user should be navigated to sub section form page")
	public void user_should_be_navigated_to_sub_section_form_page() throws InterruptedException {
		
		String expected = "Add Sub section for Section Name feature";
		
		String actual = dP.check_sub_section();
		
		System.out.println(actual);
		
		Assert.assertEquals(expected, actual);
	}
	
	@And("user clicks on drop down")
	public void user_clicks_on_drop_down() throws InterruptedException {
		
		Thread.sleep(2000);
		
		dP.click_for_dropdown();
	}
	
	@Then("^user should be able to select the existing (.*)$")
	public void user_should_be_able_to_select_the_existing_subSection(String subFeature) throws InterruptedException {
		
		String actual= dP.select_subsectio_option(subFeature);
		
		String expected = subFeature;
		
		Assert.assertEquals(expected, actual);
		
	}
	
	@And("^user entered (.*)  and  (.*)$")
	public void user_entered_sub_sub_section_and_content(String subSectiontitle, String content) {
		
		dP.upload_sub_sub_Section();
		dP.write_sub_sub_Section_title(subSectiontitle);
		dP.write_content(content);
	}
	
	@When("user clicks on upload subsection documentation")
	public void user_clicks_on_upload_subsection_documentation() {
		
		dP.upload_sub_sub_Section();
	}
	
	@When("^user selected the existing (.*)$")
	public void user_selects_the_existing_subSection(String option) {
		dP.select_subsectio_option(option);
	}
	
	@Then("upload button should be disabled")
	public void upload_button_should_be_disabled() {
		
		Assert.assertTrue(dP.check_upload_sub_section());
	}

}
