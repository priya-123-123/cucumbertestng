package pageclasses;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="username") WebElement userNme;
	@FindBy(name="password") WebElement passw;
	@FindBy(xpath="//button[@type='submit']") WebElement loginbtn;
	@FindBy(xpath="//p[@class='oxd-text oxd-text--p oxd-alert-content-text']") WebElement errorMsg;
	
	public void enterUsername(String name) {
		userNme.sendKeys(name);
	}
	
	public void enterpassword(String pass) {
		passw.sendKeys(pass);
	}
	
	public void clickOnLoginButton() {
		loginbtn.click();
	}
	
	public String getErrorMessage() {
		return errorMsg.getText();
	}
	
	 
	

	

}
