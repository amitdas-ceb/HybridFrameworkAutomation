Feature: Sample API Tests

  Scenario: Test A Sample Get API

    Given url 'https://reqres.in/api/users?page=2'
    When method Get
    Then status 200
    Then print response