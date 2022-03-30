package apiTests;

import io.restassured.RestAssured;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static constants.Constants.POSTS_URL;
import static io.restassured.RestAssured.given;


public class CreatePost {

	File requestBodyFile = new File("src/main/resources/postPayload.json");

	@BeforeAll
	public static void setup() {
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
	}

	@Test
	public void createPost() {

		Response response = given()
				.header("Content-type", "application/json")
				.and()
				.body(requestBodyFile)
				.when()
				.post("/posts")
				.then()
				.extract().response();
		Assertions.assertEquals(201, response.statusCode());
		Assertions.assertEquals("Jane Doe", response.jsonPath().getString("userId"));
		Assertions.assertEquals("example title", response.jsonPath().getString("title"));
		Assertions.assertEquals("Veni vidi vici", response.jsonPath().getString("body"));
	}

}
