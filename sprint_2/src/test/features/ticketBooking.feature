Feature: Ticket Booking Form Submission

  Scenario: Successful booking form submission with valid details
    Given User opens the ticket booking page
    When the user enters booking details "Delhi", "Mumbai", "ISBT", "Borivali", "2025-08-01", "06.00AM", "AC Sleeper", "Jane Kumar", "9876543210", "Male", "India", "123 Street, Delhi"
    And clicks on Submit button
    Then the submitted details should be shown in table

    
   Scenario: Error when phone number is invalid
    Given User opens the ticket booking page
    When the user enters booking details "Delhi", "Mumbai", "ISBT", "Borivali", "2025-08-01", "06.00AM", "AC Sleeper", "Jake", "", "Male", "India", "Delhi"
    And clicks on Submit button
    Then an error message should be shown for invalid phone number

  Scenario: Error when date field is empty		
    Given User opens the ticket booking page
    When the user enters booking details "Delhi", "Mumbai", "ISBT", "Borivali", "", "06.00AM", "AC Sleeper", "Faran", "9876543210", "Male", "India", "Delhi"
    And clicks on Submit button
    Then an error message should be shown for empty date field

  Scenario Outline: Multiple valid submissions
    Given User opens the ticket booking page
    When the user enters booking details "<from>", "<to>", "<boarding>", "<dropping>", "<date>", "<time>", "<busType>", "<name>", "<phone>", "<gender>", "<country>", "<address>"
    And clicks on Submit button
    Then the submitted details should be shown in table

    Examples:
      | from  | to     | boarding | dropping | date       | time     | busType                  | name         | phone       | gender | country | address              |
      | Pune  | Nagpur | Swargate | Sitabuldi| 2025-08-12 | 10.00AM  | AC Sleeper               | Aarya K      | 9876543210  | Female | India   | Flat 101, Pune       |
      | Delhi | Jaipur | ISBT     | SindhiCmp| 2025-08-14 | 10.00PM  | Non-AC Semi-Sleeper      | Rohit Kumar  | 9123456789  | Male   | India   | Sector 15, Noida     |  