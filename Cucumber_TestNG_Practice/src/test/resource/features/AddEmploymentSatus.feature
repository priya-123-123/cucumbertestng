#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Add Employee Status
  I want to add employee status
	Background:
		Given User is on HRMLogin page with url "https://opensource-demo.orangehrmlive.com/" 
		When User logged in as admin with username as "Admin" and password as "admin123"
		When User clicks on Admin link on home page
		Then User is on Admin System users page
		
  @Regression
  Scenario: Add Employee status multiple times
    Given User is on Employment status page
    When I enter name  in the Name field and click on save ,success message must be displayed as "Successfully Saved"
    |name|
    |Full Time user5|
    |Full Time user6|
    
   
    
   
    



