Feature: Obtaining resources from external api

  Scenario: Obtaining resources returns a non-emtpy list
    When the route is called
    Then a non-empy list is return

  Scenario: Obtaining a specific resource returns information
    Given the person in the list
    When the route is called
    Then their information is returned

  Scenario: Obtaining nothing from a resource not available
    Given the person is not in the list
    When the route is called
    Then nothing is returned