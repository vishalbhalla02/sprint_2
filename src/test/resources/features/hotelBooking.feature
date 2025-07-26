Feature: Hotel Booking Validation

  Scenario: Submit valid hotel booking details
    Given user opens the hotel booking page
    When user enters valid hotel booking information
    Then booking details should be displayed successfully
