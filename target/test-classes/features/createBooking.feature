Feature: Create Booking Test
  @CreateBooking
  Scenario: Create Booking
    Given Post request with <firstname> <lastname> <totalprice> <depositpaid> <additionalneeds> <bookingdates>
    Then Verify booking is added
    
    