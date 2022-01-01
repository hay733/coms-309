Our mobile application, Scout, helps people explore more of what there is in Ames. Once users create their schedule, Scout will be able to find events and locations for those who want to do anything in their free time. This app will help those in boredom as well as get them to explore their city.

The backend folder holds all the springboot content for our app, Scout.
Contributors - Haylee Lawrence and Mytien Kien

Starting up SQL server in terminal:
1) in git, type in ssh [netid]@coms-309-025.cs.iastate.edu
2) type in netid password
3) type in, mysql -uroot -p
4) type in password: 46b0a8270722e265
5) type in, use scout_db
6) now you can insert sql commands like normal into terminal -> for example, show tables, will show all existing tables -> or, select * from location; will show data in location etc

Running remote server that is connected to SQL:
1) in git, type in ssh [netid]@coms-309-025.cs.iastate.edu
2) type in netid password
3) you should cd into backend folder -> cd 2_do_1/backend
4) mvn clean install
5) cd target
6) java -jar scout [press tab, it'll auto complete to insert the existing jar]
7) this will start up the remote server
8) open SQL and create a new connection
9) host name is: coms-309-025.cs.iastate.edu, username is: team2_do_1, password is: Scout_DO1_309
10) this will connect to our SQL server in mySQL
11) any changes you make in the SQL server in the terminal OR mySQL workbench, will update everything
12) can test using postman using the url: http://coms-309-025.cs.iastate.edu:8080/ [table] / [API found in IntelliJ Springboot Project]
13) must have servers running and everything for this to work



The frontend folder holds all android studio content for our app, Scout.
Contributors - Britney Yu and Sanjana Amatya


