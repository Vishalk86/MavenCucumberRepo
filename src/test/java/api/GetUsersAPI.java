package api;
import static io.restassured.RestAssured.*;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetUsersAPI 
{
	public static void main(String[] args) 
	{
		given()
	    .header("x-api-key", "123456")

	.when()
	    .get("https://example.com/users")

	.then()
	    .statusCode(200);			
	}
}
