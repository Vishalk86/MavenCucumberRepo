package stepdefinitions;

import org.testng.Assert;

import api.UserAPI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

public class UserAPISteps 
{
	Response response;
	
	UserAPI userAPI = new UserAPI();

    @Given("I send a GET request for user 2")
    public void i_send_a_get_request_for_user_2() 
    {
    	response = userAPI.getUser(2);
    }

    @And("the API response status code should be 200")
    public void the_api_response_status_code_should_be_200() 
    {
    	System.out.println(response.asPrettyString());
    	System.out.println("Status Code = " + response.getStatusCode());
    	Assert.assertEquals(response.getStatusCode(), 200);
    }
    
    @And("the username should be {string}")
    public void the_username_should_be(String expectedName) 
    {
        String actualName =
                response.jsonPath()
                        .getString("username");
        
        Assert.assertEquals(actualName, expectedName);
        System.out.println("Username! actualName = " + actualName);
    }
    
    @Given("I create a user with name {string} and username {string}")
    public void i_create_a_user_with_name_and_username(String name, String username) 
    {
        response = userAPI.createUser(name, username);
    }
    
    @And("the API response status code should be 201")
    public void the_api_response_status_code_should_be_201() 
    {
        Assert.assertEquals(response.getStatusCode(), 201);
        System.out.println("Status Code = " + response.getStatusCode());
    }
    
    @And("the response should contain the created user name {string}")
    public void the_response_should_contain_the_created_user_name(String expectedName) 
    {
        String actualName =
                response.jsonPath()
                        .getString("name");

        Assert.assertEquals(actualName, expectedName);
        System.out.println("actualName = " + actualName);
    }
    
}
