package com.example.Cucumber_TestNG_Practice.definitions;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageclasses.HomePage;
import pageclasses.LoginPage;
import pageclasses.SystemUserSearchPage;

public class SystemUsersSearchPageDefinition {
	
	HomePage hp;
	LoginPage lp;
	SystemUserSearchPage sp;
	
	
	WebDriverContainer container;

    public SystemUsersSearchPageDefinition(WebDriverContainer container){
       this.container = container;
    }

	@Given("User is on HRMLogin page with url {string}")
	public void user_is_on_hrm_login_page_with_url(String url) {
		 container.driver.get(url);
	}

	@When("User logged in as admin with username as {string} and password as {string}")
	public void user_logged_in_as_admin_with_username_as_and_password_as(String userName, String password) {
		lp=new LoginPage(container.driver);
	    lp.enterUsername(userName);
	    lp.enterpassword(password);
	    lp.clickOnLoginButton();
	    try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@When("User clicks on Admin link on home page")
	public void user_clicks_on_admin_link_on_home_page() {
	    hp=new HomePage(container.driver);
	    hp.getHeadingtext();
	    hp.clickOnAdminLink();
	}
	@Then("User is on Admin System users page")
	public void user_is_on_admin_system_users_page() {
	    sp=new SystemUserSearchPage(container.driver);
	    String heading = sp.getHeading();
	    Assert.assertEquals(heading, "System Users");
	}

@When("User enters {string}")
public void user_enters(String uname) {
   sp=new SystemUserSearchPage(container.driver);
   sp.enterUserName(uname);
}

@When("User selects role as {string}")
public void user_selects_role_as(String role) {
    sp.selectUserRole(role);
}

@When("User selects status as  {string}")
public void user_selects_status_as(String status) {
    sp.selectStatus(status);
}

@When("User Enters {string} and selects employee from the list")
public void user_enters_and_selects_employee_from_the_list(String empname) {
    try {
		sp.EnterAndSelectEmpName(empname);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

@When("click on Search button")
public void click_on_search_button() {
    sp.clickOnsearch();
}

@Then("User details must be displayed")
public void user_details_must_be_displayed() {
	
   Assert.assertEquals(sp.getNoOfRecordsText(),"(1) Record Found");
   
	
}




@Then("match with the searched criteria i.e {string}, {string}, {string} and {string}")
public void match_with_the_searched_criteria_i_e_and(String userName, String UserRole, String EmpName, String Status
) {
    ArrayList<String> searchdetails=sp.getsearchUserDetails();
    Assert.assertEquals(userName, searchdetails.get(1));
    Assert.assertEquals(UserRole, searchdetails.get(2));
    Assert.assertEquals(EmpName, searchdetails.get(3));
    Assert.assertEquals(Status, searchdetails.get(4));
}








	




}
