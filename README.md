# SpringCMS-Content-Management-System-
web app based on Spring framewok allowing users to manage articles and their details


Consists of three entity classes: Article, Author and Category

Uses mySQL database and store data in it.

Allows to Create, Read, Update, Delete Authors, Categories and Articles using a form displayed in one of the app views.

All forms have data validation.

After successful form submission user is redirected to the readall view which presents a list of all articles in a table.

Category readall page have additional features in form of a activate/deactivate link which changes isactive property.
Category readall page also allows searching for associated articles for given category by clicking on "show articles by this category" link included in the table.

Users can go directly from Categories page to Articles readall page cliking on the link "show all articles" at the bottom of the page.

Project encorporates two frameworks in Java: Spring and Hibernate.


