Feature: Book a hotel with customer deatils

@smoke
Scenario: Enter the customer deatils to book a hotel

When user enter the first name
When user enter the last name
When user enter the address
When user enter the credit card number
When user enter the credit card type 
When user enter the expiry date_month
When user enter the expiry date_year
When user enter the CVV number
And user click the book button
Then verify user moved to booking confirmation page