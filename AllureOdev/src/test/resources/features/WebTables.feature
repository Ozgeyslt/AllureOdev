Feature:Web Table page
  As a user, I add a new row to the web table, and later, I edit it

  Scenario:Adding and editing a new row in the web table
    Given Click addbtn button
    And Fill in the form and submit

      | firstName | lastName | email       | age | salary | department |
      | Ayse      | Yilmaz   | xxx@mail.co | 25  | 30000  | IT         |

    When Click edit button
    And New row's first name edited
    Then New row's first column should seen new name
