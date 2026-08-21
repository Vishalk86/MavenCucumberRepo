Feature: User API Testing

  
  
  Scenario: Verify Get User API
    Given I send a GET request for user 2
    And the API response status code should be 200
    And the username should be "Antonette"
    
  
  Scenario: Create a new user
    Given I create a user with name "Vishal" and username "QAVishal"
    And the API response status code should be 201
    And the response should contain the created user name "Vishal"