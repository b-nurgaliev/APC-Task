package apiTests;

import baseTest.BasicTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static constants.Constants.USERS_URL;
import static io.restassured.RestAssured.given;

public class CheckUserWebsite extends BasicTest {

	@Test
	public void checkUserWebsite(){
		Response response = given()
				.baseUri(USERS_URL)
				.basePath("/2")
				.contentType(ContentType.JSON)
				.when().get()
				.then()
				.extract().response();
		Assertions.assertEquals("anastasia.net", response.jsonPath().getString("website"));
	}
}
