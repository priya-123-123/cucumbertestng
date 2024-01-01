package pageclasses;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class SystemUserSearchPage {
	public WebDriver driver;
	public SystemUserSearchPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(tagName = "h5") WebElement heading;
	@FindBy(xpath="//form//input[@class='oxd-input oxd-input--active']") WebElement username;
	@FindBy(xpath = "//label[text()='User Role']/parent::div/following-sibling::div") WebElement userRole;
	@FindBy(xpath="//input[@placeholder='Type for hints...']") WebElement empName;
	@FindBy(xpath="//label[text()='Status']/parent::div//following-sibling::div") WebElement status;
	@FindBy(xpath="//div[@role='listbox']//div//span") List<WebElement> listoptions;
	@FindBy(xpath="//button[@type='submit']") WebElement searchbtn;
	@FindBy(xpath="//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//span[@class='oxd-text oxd-text--span']") WebElement noOfRecords;
	@FindBy(xpath="//div[@role='cell']") List<WebElement> searchcellValue;
	public String getHeading() {
		return heading.getText();
	}
	
	public void enterUserName(String uname) {
		username.sendKeys(uname);
	}
	 public void EnterAndSelectEmpName(String name) throws InterruptedException{
	    	empName.sendKeys(name);
	    	Thread.sleep(5000);
	    	for (WebElement r : listoptions) {
				if(r.getText().equalsIgnoreCase(name)) {
					r.click();
					break;
				}
			}
	    	
	    }
	
	public void selectUserRole(String role) {
		userRole.click();
		for (WebElement r : listoptions) {
			if(r.getText().equalsIgnoreCase(role)) {
				r.click();
				break;
			}
		}
		
		
	}
	public void selectStatus(String st) {
		status.click();
		for (WebElement r : listoptions) {
			if(r.getText().equalsIgnoreCase(st)) {
				r.click();
				break;
			}
		}
		
		
	}
	
	public void clickOnsearch() {
		searchbtn.click();
	}
	
	public String getNoOfRecordsText() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return noOfRecords.getText();
	}
	
	public ArrayList<String> getsearchUserDetails() {
		ArrayList<String> detailsList=new ArrayList<String>();
		for(WebElement str:searchcellValue) {
			detailsList.add(str.getText());
		}
		return detailsList;
	}
	
	
	
	
	

}
