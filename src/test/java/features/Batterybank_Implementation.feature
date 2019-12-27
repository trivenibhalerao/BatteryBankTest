Feature: Verify API Status code

Scenario: Verify API status code of GET API call 
Given I make a GET call with URI "http://dummy.restapiexample.com/api/v1/employees" with endpoint "/1" is provided
Then get  api should return "404" status code

Scenario: Verify API status code for POST API call 
Given I make a POST call with URI "http://dummy.restapiexample.com/api/v1" with endpoint "/create" 
Then provided following details Name : "Hello" Salary : "1232123" Age : "12" with OTP : " " 
Then post API should return "200" status code 

    