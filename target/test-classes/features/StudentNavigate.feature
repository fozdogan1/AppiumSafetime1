Feature: Student Navigating the Mobile App

  Scenario Outline: The student opens the mobile app and navigates within it.
    Given The student opens the mobile app <username> and <password>
    When The student uses the navigation bar to navigate between different sections
    Then The student logs out of the app

    Examples:
      | username            | password |
      | study47@yopmail.com |Fahri123. |