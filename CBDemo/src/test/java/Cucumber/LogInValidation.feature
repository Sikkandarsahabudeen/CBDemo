Feature: Submit the Order from outline
  Background: User Landed on login screen

  @Login
  Scenario Outline: Not able to login
    Given User has to landedon in the ecommerce website with "<username>" "<password>"
    Then Ensure the Title messages "<message>"

    Examples:
      | username         | password | message    |  |
      | dummy2@email.com | Test@123 | Let's Sho  |  |
      | dummy2@email.co  | Test@123 | Let's Shop |  |
