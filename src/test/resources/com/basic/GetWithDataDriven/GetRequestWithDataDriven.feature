Feature: test datadriven22

Scenario Outline: 12.validate Get Request values with Datadriven
Given Get response from bookstore application
When you request for Get response
Then user checks data at path "<jpath>" having value "<jpathvalue>" in json
Then you check if its up and running 
Examples:
	| jpath										|  jpathvalue					                       | 
	| books[0].title					|  Git Pocket Guide    		                   |
	| books[1].title					|  Learning JavaScript Design Patterns		   |
	| books[2].title					|  Designing Evolvable Web APIs with ASP.NET |
	
	