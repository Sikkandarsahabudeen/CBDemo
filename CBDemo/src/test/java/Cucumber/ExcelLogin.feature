Feature: Login Feature
  Background: User Landed on login screen
@ExcelData
Scenario Outline:able to login
  Given User has to landed-on in the ecommerce website with "<username>" "<password>"
  Then Ensure the messages "<Title>"

    Examples:
      | username         | password | Title      |  |
      | dummy2@email.com | Test@123 | Let's Sho  |  |
      | dummy2@email.co  | Test@123 | Let's Shop |  |