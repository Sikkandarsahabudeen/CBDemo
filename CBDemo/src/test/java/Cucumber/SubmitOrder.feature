Feature: Submit the Order from outline
  Background: User Landed on login screen

  @Order
  Scenario Outline: Successfully order the product
    Given User has logged in the ecommerce website with "<username>" "<password>"
    When I ordered the product "<product>"
    And Check out the submit order "<product>"
    Then Ensure the ordered messages "<message>"

    Examples:
      | username         | password | message                 | product     |
      | dummy2@email.com | Test@123 | Thankyou for the Order. | ZARA COAT 3 |
