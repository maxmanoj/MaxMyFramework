Feature: Login page

  @LoginPage
  @regression
  Scenario: User should be able to login into the application with valid username and password
    Given I navigate to OrangeHRM Url
    When I enter valid username and password
    Then I click on Login Button
    Then I Should be able to Login into Application