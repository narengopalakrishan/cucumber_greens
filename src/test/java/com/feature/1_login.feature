Feature: To check the login functionality of the adactin project 

Background: enter the URL 
	Given User is on correct URL 
	
	@smoke
Scenario Outline: Check whether login is successfull with valid credentials 
	Then Enter <fullname1> and <password1> 
	And click login button 
	Then check user is move to homepage 
	
	Examples: 
		| fullname1 | password1 |
		| narengopalakrishan     |     Naren@123 |
		
Scenario Outline: Check whether login is successfull with invalid credentials 
	Then Enter <fullname2> and <password2> 
	And click login button 
	Then check user is got error message 
	
	Examples: 
		| fullname2 | password2 |
		| narengopalakrishan     |     Qwerty@123 |
		|abcd| abcd@123|
		|Qwert|Naren@123|
		