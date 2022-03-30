package helpers;

import static constants.Constants.POSTS_URL;
import static constants.Constants.USERS_URL;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class JsonValidatorHelper {

	private static final String USERS_JSON_PATH = "users.json";
	private static final String POSTS_JSON_PATH = "posts.json";

	public static void validateJsonSchema(String url, String jsonUrl) {
		given()
				.when()
				.get(url)
				.then()
				.assertThat()
				.body(matchesJsonSchemaInClasspath(jsonUrl));
	}
}
