Feature:  Search in automationpractice.com

  Scenario: User login in automationpractice.com
  Given a user in a automationpractice.com webstore
  When the user clicks Sign in button
    And the user types "kazimirus.magnus@gmail.com" on login field
    And the user types "1234qwer" on password field
    And the user clicks on Sign in button
  Then the user go to user panel

  Scenario Outline: User login in automationpractice.com
    Given a user is on automationpractice.com webstore
    When the user clicks Sign in button
    And the user types "<textToType1>" on login field
    And the user type "<textToType2>" on password field
    And the user clicks on Sign in button
    Then the user go to user panel
    Examples:
      | textToType | searchedText |
      | test       | testowanie   |
      | bdd        | development  |