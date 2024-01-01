package pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEmployeePage {
	public WebDriver driver;
	public AddEmployeePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@name='firstName']") WebElement firstName;
	@FindBy(xpath="//input[@placeholder='Last Name']") WebElement lastname;
	
	
	
}
