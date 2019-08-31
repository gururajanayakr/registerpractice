Feature: Login page Test
Scenario: Verify the valid Login
Given user should be in login page
When login with valid credentials
Then verify the home page