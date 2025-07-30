Feature: Hotel Booking

  Scenario: Book a hotel successfully
    Given the user is on the hotel booking page
    When the user enters booking details "Jane", "Kumar", "jane@gmail.com", "9876543210", "Double Room", "2", "01/01/2025", "01/02/2025", "yes", "Good", "Gateway", "hello i am the best"
    And submits the booking form
    Then the booking should be successful
	  And Close the browser
	
	Scenario: Booking fails due to missing email
  Given the user is on the hotel booking page
  When the user enters booking details "John", "Kumar", "", "9876543210", "Double Room", "2", "01/01/2025", "01/02/2025", "yes", "Good", "Gateway", "No email provided"
  And submits the booking form
  Then the booking should be unsuccessful
  And Close the browser
  
 Scenario: Booking fails due to missing full name and phone number
  Given the user is on the hotel booking page
  When the user enters booking details "", "", "Jane@gmail.com", "", "Double Room", "2", "01/01/2025", "01/02/2025", "yes", "Good", "Gateway", "Missing name and phone"
  And submits the booking form
  Then the booking should be unsuccessful due to missing required fields
  And Close the browser

	  
	
	Scenario Outline: Booking a hotel with multiple data sets
  Given the user is on the hotel booking page
  When the user enters booking details "<FirstName>", "<LastName>", "<Email>", "<Phone>", "<RoomType>", "<Guests>", "<CheckIn>", "<CheckOut>", "<Pickup>", "<Rating>", "<Location>", "<Message>"
  And submits the booking form
  Then the booking should be successful
  And Close the browser

  Examples:
    | FirstName | LastName | Email               | Phone       | RoomType     | Guests | CheckIn     | CheckOut    | Pickup | Rating | Location | Message               |
    | John      | Doe      | john@example.com    | 9876543210  | Single Room  | 1      | 01/05/2025  | 01/06/2025  | yes    | Good   | Gateway  | Testing first data    |
    | Jane      | Smith    | jane@example.com    | 8765432109  | Double Room  | 2      | 02/05/2025  | 03/05/2025  | yes    | Fair   | City Center  | Testing second data   |
	  