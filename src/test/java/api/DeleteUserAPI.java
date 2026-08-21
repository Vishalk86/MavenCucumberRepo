package api;
import static io.restassured.RestAssured.given;

public class DeleteUserAPI 
{

	public static void main(String[] args) 
	{
		int userid = 10;
		
		given()
		.pathParam("id", userid)

        .when()
            .delete("https://jsonplaceholder.typicode.com/users/{id}")

        .then()
            .statusCode(200)
		    .log().all();
	}

}
