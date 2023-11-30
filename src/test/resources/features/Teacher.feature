Feature: Safetime login
  @wip
  Scenario Outline: Safetime login for teacher
    Given Teacher open the app and enters <username> and <password>,<firstname>,<lastname>
    Then Teacher login successfully

    Examples:
      | username           | password  | firstname | lastname |
      | <dynamic_username> | Fahri123. | <dynamic_firstname>     | <dynamic_lastname>     |


