Feature: Student Login

  @wip
  Scenario Outline: Safetime login for student
    Given Student open the app and enters <username> and <password>
   Then Student enters personel info <sfirstname>, <slastname>
    And Student enters "pEmail" and "pPhone"
    And Student login successfully
    Examples:
      | username           | password  | sfirstname          | slastname          |
      | <dynamic_username> | Fahri123. | <dynamic_firstname> | <dynamic_lastname> |

