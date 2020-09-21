Feature:  Search in automationpractice.com

  Scenario: Search sda in automationpractice.com
  Given a user in a automationpractice.com webstore
  When the user types "blouse" in input search
    And the user clicks on search button
  Then the user should see blouse offer on search results

  Scenario Outline: Search text in automationpractice.com
    Given a user is on automationpractice.com webstore
    When the user types "<textToType>" in input search
    And the user clicks on search button
    Then the user should see blouse offer on search results
    Examples:
      | textToType | searchedText |
      | test       | testowanie   |
      | bdd        | development  |