#This is written for training purpose
Feature: Login into salesforce application
 
  Scenario: Login with valid user and valid password
    Given User launch the salesforce application
    When user on "LoginPage"
    When user enters the value into text box username 
    And user enters the value into text box Password 
    Then Click on login Button
    Then verify user successfully logged in
    When user on "HomePage"
    Then verify page title "Home Page ~ Salesforce - Developer Edition"
    
  Scenario: Login with valid user and valid password
    Given User launch the salesforce application
    When user on "LoginPage"
    When user enters the value into text box username  
    Then Click on login Button
    Then Verify the Error Message
    
   Scenario: Login with valid user and valid password
    Given User launch the salesforce application
    When user on "LoginPage"
    When user enters the value into text box username  
    And user enters the value into text box Password
    Then Click on Rememberme checkbox
    Then Click on login Button
    When user on "HomePage"
    When User enter into UserMenu
    Then Click logout
    Then Verify the UserField
    
    Scenario: Login with valid user and valid password
    Given User launch the salesforce application
    When user on "LoginPage"
    When user enters the value into text box username 
    Then User Click ForgetPassword Link
    Then User Enter UserNameField
    And User Click Continue
    Then User Verify ForgetPassword Alert Message
    
    
   Scenario: Login with valid user and valid password
    Given User launch the salesforce application
    When user on "LoginPage"
    When user enters the value into text box username  
    And user enters the Wrong value into text box Password
    Then Click on login Button
    Then User Verify the Wrong Password AlertMessage
    
    