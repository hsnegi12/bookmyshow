NOTE : Open ReadMe in text Edit or sublime text for better formatting and readability

##Book My Show Design Project
This is a maven project built using SpringBoot Framework.
Configuration can be found in pom.xml file at root of the project directory.

###Setting up the environment before testing
1.) Considering local testing, MySQL should be installed in local machine
2.) application.yml file needs to be configured. Path in which the same file is to be found src/main/resources.

   Configuration which needs to be addressed.
   Line number 4,
   
   4 ---> url: jdbc:mysql://localhost:3306/<Database created name>
   
   Line number 5 & 6 respectively,
   
   5 ---> username: <mySQL username>
   
   6 ---> password: <password>

### Tables inside database and relations
There are 7 tables in the database named,

1.) city

2.) user

3.) theater

4.) theater_owner

5.) movie_show

6.) ticket

7.) movie

Relation Graph between the tables,

                       movie        city
                         ^            ^
                         |            |
                         |            |
user <-- ticket --> movie_show --> theater --> theater_owner


### Requirements, their APIs & testing

Class path of all APIs - src/main/java/com/ciq/bookmyshow/resource

1.) The system should allow the registration of new movie theaters and adding new movie shows from theater owners.

a) Onboarding/add theaters owners
Class name - TheaterOwnerResource
Function - addTheaterOwner
End point - /theaterOwner/add 


b) The system should allow the registration of new movie theaters.
Class name - TheaterResource
Function - addTheaterToDB
End point - /theater/add/{cityId}/{ownerId}    (cityId of city in which theater will be)

c) adding new movie shows from theater owners
Class name - ShowResource
Function - addShow
End point - /show/add/{theaterId}/{movieId}


2.) The system should be able to list down cities where it's cinemas are located.

a) Adding a new city to list
Class name - CityResource
Function - persistCityToDB
End point - /city/add

b) List down all cities
Class name - CityResource
Function - getAllCities
End point - /city/all


3.) Upon selecting the city, the system should display the movies released in that particular city to that user.

a.) Onboarding a user
Class name - UserResource
Function - addUserToDB
End point - /user/add

b.) Get all movies
Class name - MovieResource
Function - getAllMovies
End point - /movie/all



4.) Once the user makes his choice of the movie, the system should display the cinemas running that movie and its available shows.

Class name - ShowResource
Function - getAllShowsInCityOfMovie
End point - /show/all/{cityId}/{movieId}



5.) The user should be able to select the show from a cinema and book their tickets.

Class name - TicketResource
Function - persistTicketToDB
End point - /ticket/add/{userId}/{showId}


6.) The user should be able to select multiple seats according to their choice.
Covered as part of requirement 5
Sample Request Json for the same,
{
	"seatsBooked": ["3a","3b","3c","3d"]
}

7.) The user should be able to distinguish between available seats from the booked ones.

While booking tickets show class have columns and rows of theater screen which will host the show. Show class have a field which is of array of strings data type and will hold all the booked seats which will be initially zero and with each booking it will get filled.

For logic refer to,
Class name - TicketResource
Function - persistTicketToDB

8.) No payment module required
- Ok

9.) The system should serve the tickets First In First Out manner
- Taken care of


### Scope and expectations
1.) Should use some Java framework - SpringBoot application

2.) DB Entities - src/main/java/com/ciq/bookmyshow/model

3.) Use mock data with mysql - Tested with mock data





