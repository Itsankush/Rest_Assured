package stepDefinations;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	@Before("@PatchBooking")
	// Run this prerequisite before all @PatchBooking tests
	public void before_mobile_test() {
		System.out.println("Partial update started");
	}

	@After("@PatchBooking")
	// Run this prerequisite before all @PatchBooking tests
	public void after_mobile_test() {
		System.out.println("Partial update done");
	}
}
