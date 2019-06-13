Feature: Login into account
Scenario: Login into account with valid credentials
Given User navigates to Stack overflow website
And User clicks on sub menu
And user enters a valid user id
And user enters a valid pswd
When user clicks on logout button
Then user is logged out