Feature: To check the options available for searching hotel

@smoke
Scenario: check all option are selectable for searching hotel
	When User select location option 
	And User select the hotels
	And User select the room type
	And user select the number of rooms
	And user select the check in date
	And user select the check out date
	And user select the adults per room
	And user select the children per room
	And user select the click the search button
	Then verify user is moved to next select hotel page
