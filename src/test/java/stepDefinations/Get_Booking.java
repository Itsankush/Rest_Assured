package stepDefinations;

import static io.restassured.RestAssured.*;
import io.cucumber.java.en.Given;
import static org.hamcrest.Matchers.*;

public class Get_Booking {

	// Web site:- https://restful-booker.herokuapp.com/apidoc/index.html#api-Auth

	@Given("Get Booking using Get API call")
	public void get_booking() {

		baseURI = "https://restful-booker.herokuapp.com";
		given().
		when().
			get("/booking/1").
		then().
			assertThat().
			//body("firstname", equalTo("Ajax")).
			body("lastname", equalTo("Call")).
	   		body("totalprice", equalTo(500)).
	   		body("depositpaid", equalTo(true)).
			body("bookingdates.checkin", equalTo("2023-04-12")).
			body("bookingdates.checkout", equalTo("2023-04-15")).
			body("additionalneeds", equalTo("Lunch"));
	}

}
