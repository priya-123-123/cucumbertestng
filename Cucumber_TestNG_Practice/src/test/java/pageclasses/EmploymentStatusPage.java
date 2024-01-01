package pageclasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class EmploymentStatusPage {
	public WebDriver driver;
	public EmploymentStatusPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@class='orangehrm-header-container']//button") WebElement Addbtn;
	@FindBy(xpath="//div[@class='oxd-input-group oxd-input-field-bottom-space']//input") WebElement Name;
	@FindBy(xpath="//button[@type='submit']") WebElement save;
	@FindBy(xpath="//div[@class='oxd-toast oxd-toast--success oxd-toast-container--toast']//p[text()='Successfully Saved']") WebElement successMessage;
	
	public void clickOnAdd() {
		Addbtn.click();
	}
	public void enterName(String name) {
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(d -> Name.isDisplayed());
		Name.clear();
		Name.sendKeys(name);
	}
	
	public void clickOnSave() {
		save.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getSuccessMessage() {
		
		return successMessage.getText();
	}
	
}
