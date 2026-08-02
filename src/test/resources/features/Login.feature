Feature: Login Functionality

  Scenario: Verify Login

    Given I launch browser

    And I open application as "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When I enter on "Login##username" as "Admin"
    And I enter on "Login##password" as "admin123"
    And I click on "Login##loginButton"
    Then I waitForElementPresent on "Login##dashboard"    
    And I click on "PIM##PIM"
    And I click on "PIM##AddButton"
    And I enter on "PIM##AddEmployee_FirstName" as "Vaibhav"
    And I enter on "PIM##AddEmployee_LastName" as "Sharma"
    And I click on "PIM##AddEmployee_Save"            
    #Challenge
    
#    And I click on "PIM##LicenseExpiryDate"
    Then I waitForElementPresent on "PIM##LicenseExpiryDate" 
    And I select date "PIM##LicenseExpiryDate" as "15##June##2010" 
#    And I select date "PIM##DateofBirth" as "10##May##2001" 
#    https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
#    https://practicetestautomation.com/practice-test-login/