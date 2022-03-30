package baseTest;

import org.junit.jupiter.api.Test;
import helpers.JsonValidatorHelper;

import static constants.Constants.POSTS_URL;
import static constants.Constants.USERS_URL;


public class BasicTest {

	private static final String POSTS_JSON_PATH = "posts.json";
	private static final String USERS_JSON_PATH = "users.json";
	JsonValidatorHelper jsonValidator = new JsonValidatorHelper();

	@Test
	public void healthCheck(){
		jsonValidator.validateJsonSchema(POSTS_URL, POSTS_JSON_PATH);
		jsonValidator.validateJsonSchema(USERS_URL, USERS_JSON_PATH);
	}

}
