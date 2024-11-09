Feature: Lists

  Scenario: User send request to get all lists
    Given Sent request to get lists
    Then User check response status 200

  Scenario: User send request to create a new list with body from file
    When User create a new list from file create_list.json
    Then User check response status 200

  Scenario: User send request to get a list without folders
    And User send a request to get all lists without folders
    Then User check response status 200

  Scenario: User send request to create a new list without folders
    When User send a request to create a new list without folders from file create_list.json
    Then User check response status 200

  Scenario: User send request to get a list by it's Id
    And User send a request to get a list by it's Id
    Then User check response status 200

  Scenario: User send request to update list with body from file
    When User send a request to update a list from file create_list.json
    Then User check response status 200

  Scenario: User send request to delete a list
    And Sent request to delete a list
    Then User check response status 200
