package api;

import static io.restassured.RestAssured.given;

public class UpdateUserAPI {

	public static void main(String[] args) 
	{
		int userId = 11;
		
		String requestBody ="""
		        {
		            "name":"Vishal",
					"username":"XYZ QA Automation Engineer"
			     }
			""";
			
			given()
			.pathParam("id", userId)
	        .header("Content-Type", "application/json")
	        .body(requestBody)

	        .when()
	            .put("https://jsonplaceholder.typicode.com/posts/{id}")

	        .then()
	            .statusCode(200)
	            .log().all();
	}
}
