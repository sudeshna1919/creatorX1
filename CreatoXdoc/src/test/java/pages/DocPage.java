package pages;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DocPage {

	WebDriver driver;
	
	@FindBy(xpath="//button[normalize-space()='Create a New Feature documentation']")
	WebElement create;
	
	@FindBy(tagName="select")
	WebElement selecOpt;
	
	@FindBy(id="section__title")
	WebElement title;
	
	@FindBy(id="subsection__title")
	WebElement subSection;
	
	@FindBy(id="subsubsection__title")
	WebElement subSub;
	
	@FindBy(xpath="//div[@class='ql-editor ql-blank']")
	WebElement content;
	
	@FindBy(xpath="//button[contains(@class,'AddDocMain_upload__cta__o5_gJ')]")
	WebElement upload;
	
	@FindBy(xpath="//div[@class='AddDocMain_exist_feature_section__CPnpP']")
	WebElement defaultOption;
	
	@FindBy(tagName="select")
	WebElement selectTag;
	
	@FindBy(xpath="//button[normalize-space()='Add a New sub section to a Feature documentation']")
	WebElement addNewSub;
	
	@FindBy(xpath="//h2[@class='AddDocMain_add-doc_heading__AFiND']")
	WebElement subSectionFormHeading;
	
	@FindBy(xpath="//div[@class='AddDocMain_exist_feature_section__CPnpP']//select")
	WebElement selectedOption;
	
	@FindBy(xpath="//button[normalize-space()='Upload Sub Section Documentation']")
	WebElement uploadSubSub;
	
	@FindBy(id="subsection__title")
	WebElement subSectionTitle;
	

		
	
	public DocPage(WebDriver driver) {
		 
		 this.driver = driver;  
		 
		 PageFactory.initElements(driver, this); 
	 }
	
	public void click_Create() {
		
		create.click();
	}
	
	public void write_Title(String Title) {
		
		title.sendKeys(Title);
		
	}
	
	public void sub_title(String subTitle) {
		
		subSection.sendKeys(subTitle);
	}
	
	public void sub_sub_title(String subSubTitle) {
		
		subSub.sendKeys(subSubTitle);
	}
	
	public void write_content(String contents) {
		
		content.sendKeys(contents);
	}
	
	public void uplod_doc() throws InterruptedException {
		
		Thread.sleep(2000);
		upload.click();
	}
	
	public boolean display_upload() {
		
		return upload.isDisplayed();
	}
	
	public boolean check_upload() {
		
		return !upload.isEnabled();
	
	}
	
	public boolean check_create() {
		
		return create.isDisplayed();
	}
	
	public String check_Selected_Option() {
		
		String option = defaultOption.getText();
		
		return option;
		
	}
	
	public void click_for_dropdown() {
		
		defaultOption.click();
	}
	
	public void select_option(String choosedOption) throws InterruptedException {
		
		Thread.sleep(2000);
		Select myOption = new Select(selectTag);
		
		boolean optionFound = false;
		
		for (WebElement option : myOption.getOptions()) {
            if (option.getText().equals(choosedOption)) {
            	myOption.selectByValue(choosedOption);
                optionFound = true;
                break;
            }
        }
	}
	
	public void click_add_new_Sub_Section() {
		
		addNewSub.click();
	}
	
	public boolean check_add_new_subSection() {
		
		return !addNewSub.isEnabled();
	}
	
public String select_subsectio_option(String choosedOption) {
		
	Select myOption = new Select(selectTag);
	
	boolean optionFound = false;
	
	for (WebElement option : myOption.getOptions()) {
        if (option.getText().equals(choosedOption)) {
        	myOption.selectByVisibleText(choosedOption);
            optionFound = true;
            break;
        }
    }
	
	
	String selectedOpt= myOption.getFirstSelectedOption().getText();
		
	 return selectedOpt;
	}

public String check_sub_section() throws InterruptedException {
	
	Thread.sleep(2000);
	System.out.println(subSectionFormHeading.getText());
    return subSectionFormHeading.getText();
	
}
public void write_sub_sub_Section_title(String title) {
	
	subSectionTitle.sendKeys(title);
}

public void upload_sub_sub_Section() {
uploadSubSub.click();
}

public boolean check_upload_sub_section() {
	
	return !uploadSubSub.isEnabled();
}



}
