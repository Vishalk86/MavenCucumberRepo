package api;

import static io.restassured.RestAssured.given;

public class CreateUserAPI {

	public static void main(String[] args) 
	{
		String requestBody ="""
		        {
		            "name":"Vishal",
					"username":"QA Automation Engineer"                  
		        }
			""";
			
			given()
	        .header("Content-Type", "application/json")
	        .body(requestBody)

	        .when()
	            .post("https://jsonplaceholder.typicode.com/users")

	        .then()
	            .statusCode(201)
	            .log().all();
	}

}
