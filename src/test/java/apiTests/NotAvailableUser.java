package apiTests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static constants.Constants.USERS_URL;
import static io.restassured.RestAssured.given;

public class NotAvailableUser {

	@Test
	public void getUserWithIntegerId() {
		Response response = given()
				.baseUri(USERS_URL)
				.basePath("/9999")
				.contentType(ContentType.JSON)
				.when().get()
				.then()
				.extract().response();
		Assertions.assertEquals(404, response.statusCode());
	}

	@Test
	public void getUserWithStringId() {
		Response response = given()
				.baseUri(USERS_URL)
				.basePath("/qwertyasdfg")
				.contentType(ContentType.JSON)
				.when().get()
				.then()
				.extract().response();
		Assertions.assertEquals(404, response.statusCode());
	}
}
