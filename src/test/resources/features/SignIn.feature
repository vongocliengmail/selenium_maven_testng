Feature: Sign In the Pet Store page
  @SignIn
  Scenario: Sign In the Pet Store page
    Given I am accessed in to the Pet Store page site
    When I enter user name and password
    And I click Login In button
    Then I see user signed in the home page