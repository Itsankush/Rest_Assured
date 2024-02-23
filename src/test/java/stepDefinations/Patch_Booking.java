package stepDefinations;

import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

public class Patch_Booking {

	Create_Booking data = new Create_Booking();
	Create_Token t = new Create_Token();

	@SuppressWarnings("unchecked")
	@Given("Update details of booking {string}")
	public void update_details_of_booking(String id) throws IOException {
		data.create_booking();
		String Cookie = t.create_token(id, id);
		Map<String, String> header = new HashMap<>();
		header.put("Cookie", Cookie);

		baseURI = "https://restful-booker.herokuapp.com/";

		JSONObject req = new JSONObject();
		req.put("firstname", "Ray");

		given().headers(header).contentType(ContentType.JSON).body(req.toJSONString()).when()
				.patch("booking/" + data.bookingID).then().body("firstname", equalTo("Ray")).log().body();
	}
}