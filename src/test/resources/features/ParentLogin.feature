Feature: parent Login

  Scenario Outline: Safetime login for parent

    Given I connect to the PostgreSQL database
    When Parent open the app and enters <username> and <password>
    Then Parent enters personal info <pfirstname>, <plastname>, <pphonenumber>

    Examples:
      | username                | password  | pfirstname          | plastname          | pphonenumber          |
      | parentEmail@yopmail.com | Fahri123. | <dynamic_firstname> | <dynamic_lastname> | <dynamic_phonenumber> |