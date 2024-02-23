package stepDefinations;

import static io.restassured.RestAssured.*;
import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojo.Booking;
import pojo.bookingdates;
import resources.testDataBuild;

public class Create_Booking {
	public String bookingID;
	JsonPath jp;
	String fname;
	testDataBuild data = new testDataBuild();
	String firstname;
	String lastname;
	int totalprice;
	String depositpaid;
	String additionalneeds;
	bookingdates bookingdates;
	

	@Given("Post request with <firstname> <lastname> <totalprice> <depositpaid> <additionalneeds> <bookingdates>")@Test(timeout = 4000)
	public void create_booking() throws IOException {
		baseURI="https://restful-booker.herokuapp.com";
		String res = given().
				log().body().contentType(ContentType.JSON)
				.body(data.createBookingPayLoad( firstname, lastname, totalprice, depositpaid, additionalneeds, bookingdates)).
				when()
				.post("/booking").
				then().
				statusCode(200).log().body().
				extract().response().asString();

		jp = new JsonPath(res);
		bookingID = jp.getString("bookingid");
		System.out.println(bookingID);

	}

	@Then("Verify booking is added")
	public void get_booking() throws JsonMappingException, JsonProcessingException {
		baseURI="https://restful-booker.herokuapp.com";
		Response response = given().log().body().
		when().get("/booking/" + 1).
		then().statusCode(200).extract().response();
		
		Booking booking = new ObjectMapper().readValue(response.getBody().asString(), Booking.class);
		System.out.println(booking.getFirstname());		
	}

}
