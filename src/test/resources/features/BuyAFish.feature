Feature: Buy a Fish in the Pet store
  @BuyAFish
  Scenario: Buy a Fish in the Pet Store page
    Given I am signed in to the Pet Store page site
    When I select the Fish item
    Then I see the list of Fish
