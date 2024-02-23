package stepDefinations;

import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

public class Delete_Booking {

	Create_Token t = new Create_Token();

	@Given("Delete booking using {string}")
	public void delete_booking_using(String token) {
		String Cookie = t.create_token(token, token);
		Map<String, String> header = new HashMap<>();
		header.put("Cookie", Cookie);

		baseURI = "https://restful-booker.herokuapp.com/";
		given().headers(header).contentType(ContentType.JSON).when().delete("booking/105").then().log().body();

	}

}
