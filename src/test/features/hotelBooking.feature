Feature: Hotel Booking

  Scenario: Book a hotel successfully
    Given the user is on the hotel booking page
    When the user enters booking details "Vishal", "Bhalla", "vishal@gmail.com", "9876543210", "Double Room", "2", "01/01/2025", "01/02/2025", "yes", "Good", "Gateway", "hello i am the best"
    And submits the booking form
    Then the booking should be successful
