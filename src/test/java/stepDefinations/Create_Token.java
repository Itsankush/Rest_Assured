package stepDefinations;

import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

public class Create_Token {
	
	String Token;
	

	@Given("Create token using {string} & {string}")
	public String create_token(String user, String passwd) {
		System.setProperty("log4j.configurationFile", "log4j2.properties");
		Map<String, Object> token = new HashMap<>();
		token.put("username", "admin");
		token.put("password", "password123");
		baseURI = "https://restful-booker.herokuapp.com";
		String token_val = given().contentType(ContentType.JSON).body(token).when().post("/auth").then().log().body()
				.extract().body().asString();

		JsonPath jp = new JsonPath(token_val);
		String T = jp.getString("token");

		String Token = ("token=" + T);
		return Token;
	}

}
