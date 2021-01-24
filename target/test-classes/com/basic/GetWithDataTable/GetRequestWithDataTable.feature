Feature: 22test DataTable

Scenario: 122.validate Get Request values with DataTable
Given Get response from bookstore application
When you request for Get response
Then user validate following in json
	| books[0].title					|  Git Pocket Guide    		                   |
	| books[1].title					|  Learning JavaScript Design Patterns		   |
	| books[2].title					|  Designing Evolvable Web APIs with ASP.NET |
Then you check if its up and running 
	
	