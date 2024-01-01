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
@Regression
Feature: Admin System User Search 
  As an Admin I want to search users using differnet search criteria.
	Background:
		Given User is on HRMLogin page with url "https://opensource-demo.orangehrmlive.com/" 
		When User logged in as admin with username as "Admin" and password as "admin123"
		When User clicks on Admin link on home page
		Then User is on Admin System users page
		
  @searchByAllFields
  Scenario Outline: Search a user by entering all fields i.e Username, User Role, Employee Name and Status
    
    When User enters "<Username>"
    And User selects role as "<User Role>"
    And User Enters "<Employee name>" and selects employee from the list
    And User selects status as  "<Status>"
    And  click on Search button
    Then User details must be displayed 
    And match with the searched criteria i.e "<Username>", "<User Role>", "<Employee name>" and "<Status>"
    
    Examples: 
      | Username         | User Role | Employee name    | Status   |
      | Anthony.Nolan |  ESS    | Anthony Nolan      | Enabled | 
      |Chenzira.Chuki |  ESS    |Chenzira Chuki|Enabled|
      |Peter.Anderson | Admin   |Peter Anderson |Enabled|
      |Sara.Tencrady  |   ESS   | Sara Tencrady |Enabled|

      