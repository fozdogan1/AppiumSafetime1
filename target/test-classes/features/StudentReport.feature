Feature: Student reports process
  Scenario Outline:Student report process
    Given Student sign in with <username> and <password>
    When Student navigates to report page and enters details <reportDetails>
    And submits the report
    Then The report should be successfully submitted

    Examples:
      | username            | password |
      | study47@yopmail.com |Fahri123. |