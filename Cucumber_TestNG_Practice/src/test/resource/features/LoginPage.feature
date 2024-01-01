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
Feature: Login to HRM Application
  I want to test if I can test login to HRM Application
 
Background:
	Given User is on HRMLogin page "https://opensource-demo.orangehrmlive.com/"

  @ValidCredentials
  Scenario: Login with valid crdentials
    When User enters username as "Admin" and password as "admin123"
    Then User should be able to login successfully and new page open
  

  @InvalidCredentials
  Scenario Outline: Login with invalid credentials
    When User enters username as "<username>" and password as "<password>"
    Then User should be able to see error message "<errorMessage>"

    Examples: 
      | username  | password | errorMessage  |
      | Admin     | admin12$$ | Invalid credentials |
      | admin$$   |  admin123 | Invalid credentials |
      | abc123    | xyz$$     | Invalid credentials |
