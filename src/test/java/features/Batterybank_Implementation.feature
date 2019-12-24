Feature: Verify API Status code

Scenario: Verify API Status code of given API 
    Given I make a "GET" call with URI "http://dummy.restapiexample.com/api/v1/employees" with endpoint "/1" is provided
    Then api should return "404" status code
    