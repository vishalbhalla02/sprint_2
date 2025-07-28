Feature: Ticket Booking Form Submission

  Scenario: Successful booking form submission with valid details
    Given User opens the ticket booking page
    When the user enters booking details "Delhi", "Mumbai", "ISBT", "Borivali", "2025-08-01", "06.00AM", "AC Sleeper", "Vishal Bhalla", "9876543210", "Male", "India", "123 Street, Delhi"
    And clicks on Submit button
    Then the submitted details should be shown in table
