@Important
Feature: validate tags

@Smoke
Scenario: 14.validate Get Request values
Given Get response from bookstore application
When you request for Get response
Then you check for title value 

@Smoke  @Regression
Scenario: 24.validate Get Request values with parameters
Given Get response from bookstore application
When you request for Get response
Then you check for title "Git Pocket Guide" at "books[0].title" value
Then you check for title "Learning JavaScript Design Patterns" at "books[1].title" value  

@Regression
Scenario: 34.validate Get Request values with parameters
Given Get response from bookstore application
When you request for Get response
Then you check for title "Designing Evolvable Web APIs with ASP.NET" at "books[2].title" value
Then you check for title "ABCD" at "books[3].title" value  

@Regression
Scenario: 4.validate Get Request values with parameters
Given Get response from bookstore application
When you request for Get response
Then you check for title "Designing Evolvable Web APIs with ASP.NET" at "books[2].title" value
Then you check for title "ABCD" at "books[3].title" value   

  