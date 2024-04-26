Feature: Buy a Dog in the Pet store
  @BuyADog
  Scenario: Buy a Dog in the Pet Store page
    Given I am signed in to the Pet Store page site
    When I select the Dog item
    Then I see the list of Dogs
Scenario Outline:
    When I choose a "<type_of_dog>" in the list
    And I choose a "<gender>" dog
  Examples:
  |type_of_dog    |gender                  |
  |Chihuahua      |Adult Female Chihuahua  |
  |Bulldog        |Male Adult Bulldog	   |
