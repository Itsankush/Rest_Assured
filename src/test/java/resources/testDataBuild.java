package resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

import pojo.Booking;
import pojo.bookingdates;
import pojo.user;

public class testDataBuild {

	ObjectMapper objmap = new ObjectMapper();
	Faker faker = new Faker();

	public String addUserPayLoad(String name, String job) throws JsonProcessingException {
		user u = new user();
		u.setName(faker.name().firstName());
		u.setJob(faker.job().position());

		String Userdata = objmap.writerWithDefaultPrettyPrinter().writeValueAsString(u);
		return Userdata;
	}

	public String createBookingPayLoad(String fname, String lname, int totalprice, String depositpaid,
			String additionalneeds, bookingdates bookingdates) throws JsonProcessingException {
		Booking book = new Booking();
		bookingdates date = new bookingdates();
		book.setFirstname(faker.name().firstName());
		book.setLastname(faker.name().lastName());
		book.setTotalprice(faker.number().numberBetween(0, 10000));
		book.setDepositpaid(true);
		book.setAdditionalneeds(faker.food().dish());
		date.setCheckin("2023-04-12");
		date.setCheckout("2023-04-15");
		book.setBookingdates(date);

		String Bookingdata = objmap.writerWithDefaultPrettyPrinter().writeValueAsString(book);
		return Bookingdata;
	}
}
