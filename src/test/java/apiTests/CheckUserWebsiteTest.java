package apiTests;

import baseTest.BasicTest;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static constants.Constants.USERS_URL;
import static io.restassured.RestAssured.given;

public class CheckUserWebsiteTest extends BasicTest {

	@Test
	@DisplayName("Checking that user has valid email")
	public void checkUserWebsite(){
		Response response = given()
				.filter(new AllureRestAssured())
				.baseUri(USERS_URL)
				.basePath("/2")
				.contentType(ContentType.JSON)
				.when().get()
				.then()
				.extract().response();
		Assertions.assertEquals("anastasia.net", response.jsonPath().getString("website"));
	}
}
