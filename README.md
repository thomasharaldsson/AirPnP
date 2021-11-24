# AirPnP

Service for renting parking places around town for people who may have parking slots available, similar to AirBnB.

/Thomas, Uzair, Tommi, Mehrdad

© AirPnP AB

## How to build and run

1. build and launch application: `mvn clean install`
2. open URL in web browser e.g. [http://localhost:8080/customers/list.html](http://localhost:8080/customers/list.html)

## Example pages

Create parkingspace: [http://localhost:8080/parkingspace/create](http://localhost:8080/parkingspace/create)

## Database adminpage

In web browser open [http://localhost:8080/h2-console](http://localhost:8080/h2-console) and enter:

* JDBC URL `jdbc:h2:file:./Database`
* username: `sa`
* password:
