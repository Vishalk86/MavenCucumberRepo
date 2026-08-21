package api;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class UserAPI 
{
	public Response getUser(int userId) 
	{

        return given()
                .pathParam("id", userId)

               .when()
                .get("https://jsonplaceholder.typicode.com/users/{id}");
    }
	
	public Response createUser(String name, String username) 
	{
	    String requestBody = """
	    {
	        "name": "%s",
	        "job": "%s"
	    }
	    """.formatted(name, username);

	    return given()
	            .header("Content-Type", "application/json")
	            .header("Accept", "application/json")
	            .body(requestBody)

	        .when()
	            .post("https://jsonplaceholder.typicode.com/users");
	}
}
