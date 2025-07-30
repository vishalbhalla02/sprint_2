#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Hotel Booking Validation

Scenario Outline: Validate hotel booking form submission
  Given I launch the Hotel Booking page
  When I enter "<FirstName>", "<LastName>", "<Email>", "<Phone>", "<CheckIn>", "<CheckOut>", "<Location>"
  Then I should see the submitted details displayed correctly

Examples:
  | FirstName | LastName | Email             | Phone      | CheckIn   | CheckOut  | Location |
  | John      | Doe      | john@test.com     | 9876543210 | 20/08/2025| 22/08/2025| City Center    |

