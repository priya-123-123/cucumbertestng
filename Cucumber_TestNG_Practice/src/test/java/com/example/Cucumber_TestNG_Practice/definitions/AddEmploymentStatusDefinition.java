package com.example.Cucumber_TestNG_Practice.definitions;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageclasses.AddEmployeePage;
import pageclasses.EmploymentStatusPage;
import pageclasses.SystemUserSearchPage;

public class AddEmploymentStatusDefinition {
	WebDriverContainer container;
	EmploymentStatusPage ep;
	SystemUserSearchPage sp;
	
    public AddEmploymentStatusDefinition(WebDriverContainer container){
       this.container = container;
    }
    

@Given("User is on Employment status page")
public void user_is_on_employment_status_page() {
   sp=new SystemUserSearchPage(container.driver);
   sp.clickonJob();
   sp.clickOnempStatus();
   ep=new EmploymentStatusPage(container.driver);
   
}

@When("I enter name  in the Name field and click on save ,success message must be displayed as {string}")
public void i_enter_in_the_name_field_and_click_on_save_success_message_must_be_displayed_as( String successmessage, io.cucumber.datatable.DataTable dataTable) {
    // Write code here that turns the phrase above into concrete actions
    // For automatic transformation, change DataTable to one of
    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
    // Double, Byte, Short, Long, BigInteger or BigDecimal.
    //
    // For other transformations you can register a DataTableType.
List<Map<String,String>> nameList=dataTable.asMaps(String.class,String.class);
    
	
	
	for (Map<String, String> data : nameList) {
		ep.clickOnAdd();
		ep.enterName(data.get("name"));
		ep.clickOnSave();
		//Assert.assertEquals(ep.getSuccessMessage(), successmessage);
		}
	
	
}





}
