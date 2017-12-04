Hotel Reservation System
------------------

For a better booking management and a presentation of the hotel, a website is the best choice.
Booking can be done in a couple of minutes and all the info can be found on the website.

Functional Requirements
-------------------------
 
 The website consists of four pages where each and one of them contains a short description
 about the hotel, a booking page where the booking can be done, a gallery where images can 
 be viewed about the hotel and on the last page the location of the hotel and contact info.

 All of these can be accessed by registering on the website where all the user information
 can be entered - Name, Phone, Address, E-mail and Password.

 On the booking page all the user has to do is enter the check-in date when the he/she will
 arrive to the hotel, a check-out date when he/she will leave and of course the number of people
 he will be with and the number of rooms. Then the booking page will try to find the best choice
 for them based on how many they are and how many rooms they want. If there are no rooms, then a
 message will appear if there are rooms or not.

 But before accessing all of these pages, a login is required. The user will be asked to enter
 the username -e-mail- and a password. After hitting the login button, this username will be checked
 if it exists in the database, if yes then the user will be redirected to the home page, otherwise
 a message will appear.

Downloadable
---------------
GIT: https://github.com/vsim1288/HotelReservationSystem

Installation
---------------
1. The project will be downloaded from GIT from the git command line or donwloaded as a zip
2. In a command line from the base directory of the project we'll run the mvn clean install
command - this will download all the dependencies
3. Next we'll run the mvn eclipse:eclipse command to convert the project into a maven eclipse
project
4. Then from the eclipse we'll import the project

Database
--------------
The dump will be opened in MySQL Workbench and executed there to build up the database with
all the data in it

Database tables explained below in the entities section

||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
The following features we're used in this project:

   MySQL database
   Hibernate framework for DB access
   RESTful web services
   JSF for the user interface
   Bootstrap
   Managed beans for supporting the JSF with additional data
   MVC framework -> Entities
                 -> DAOs for interaction with the DB
                 -> Services used for business logic
                 -> Controllers - access to the backend for all kinds of devices


Entities:
 = Booking
  * RoomId - unique identifier
  * StartDate - start of the stay at the hotel
  * EndDate - end of the stay at the hotel
  * Username - user's e-mail

 = Photos
  * PhotoId - unique identifier
  * PhotoName - photo name

 = Roles
  * RoleId - unique identifier
  * RoleName - type of user

 = Rooms
  * RoomId - room number
  * RoomTypesId - type of room
  * Occupied - is it occupied

 = Roomtypes
  * RoomTypesId - unique identifier
  * Description - short description about the room
  * NumberOfBeds - number of beds in the room

 = Userinformation
  * FirstName - name
  * LastName - name
  * Address - address
  * Phone - phone
  * Email - email used for username

 = Users
  * Username - used to login
  * Password - required for authentification
  * RoleId - role type of the user