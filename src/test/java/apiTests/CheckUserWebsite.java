package apiTests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

import static constants.Constants.USERS_URL;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CheckUserWebsite {

	@Test
	public void checkUserWebsite(){
//		given()
//				.baseUri(USERS_URL)
//				.basePath("/2")
//				.contentType(ContentType.JSON)
//				.when().get()
//				.then().log().all()
//				.assertThat()
//				.statusCode(200)
//				.body("website", equalTo("anastasia.net"));
		JsonPath expectedJson = new JsonPath(new File("src/main/resources/userTwoResponse.json"));

		given()
				.baseUri(USERS_URL)
				.basePath("/2")
				.contentType(ContentType.JSON)
				.when().get()
				.then().log().all()
				.body("", equalTo(expectedJson.getMap("")));

//		Assertions.assertEquals(200, response.statusCode());
//		Assertions.assertEquals("Antonette", response.jsonPath().getString("username"));
//		Assertions.assertEquals("anastasia.net", response.jsonPath().getString("website"));

	}
}
