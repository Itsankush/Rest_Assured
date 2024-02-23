package stepDefinations;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

import resources.testDataBuild;

public class Create_User {
	String UID;
	String fname;
	JsonPath jp;
	String name;
	String job;
	testDataBuild data = new testDataBuild();

	@Given("Post request with <name> <job>")
	public void user_creation() throws JsonProcessingException {
		baseURI = "https://reqres.in";
		String res = given().log().body().contentType(ContentType.JSON).body(data.addUserPayLoad(name, job)).when()
				.post("/api/users").then().statusCode(201).log().body().extract().response().asString();

		jp = new JsonPath(res);
		UID = jp.getString("id");
		System.out.println(UID);

	}
	
	@Then("Get the user")
	public void get_user() {
		baseURI = "https://reqres.in";
		given().log().body().
		when().get("/api/users").
		then().statusCode(200).log().all();
	}

}
