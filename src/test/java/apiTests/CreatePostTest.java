package apiTests;

import baseTest.BasicTest;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static constants.Constants.POSTS_URL;
import static io.restassured.RestAssured.given;


public class CreatePostTest extends BasicTest {

	@Test
	@DisplayName("New post adding function test")
	public void createPost() {
		File requestBodyFile = new File("src/main/resources/postPayload.json");

		Response response = given()
				.filter(new AllureRestAssured())
				.baseUri(POSTS_URL)
				.contentType(ContentType.JSON)
				.body(requestBodyFile)
				.when()
				.post()
				.then().log().all()
				.extract().response();
		Assertions.assertEquals(201, response.statusCode());
		Assertions.assertEquals("Jane Doe", response.jsonPath().getString("userId"));
		Assertions.assertEquals("example title", response.jsonPath().getString("title"));
		Assertions.assertEquals("Veni vidi vici", response.jsonPath().getString("body"));
		Assertions.assertEquals(101, response.jsonPath().getInt("id"));
	}
}
