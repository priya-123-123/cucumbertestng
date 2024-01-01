package pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']") WebElement heading;
	@FindBy(xpath="//a//span[text()='Admin']") WebElement adminlink;
	
	public String getHeadingtext() {
		return heading.getText();
	}
	
	public void clickOnAdminLink() {
		adminlink.click();
	}
}
