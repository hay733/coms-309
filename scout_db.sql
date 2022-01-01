DROP TABLE IF EXISTS attend;
DROP TABLE IF EXISTS board;
DROP TABLE IF EXISTS activity;
DROP TABLE IF EXISTS scheduled_event;
DROP TABLE IF EXISTS location;
DROP TABLE IF EXISTS user;

CREATE TABLE user (
	id 			int NOT NULL AUTO_INCREMENT,
	username 	varchar(20),
    first_name 	varchar(20),
    last_name 	varchar(20),
    email 		varchar(50),
    password 	varchar(100),
    age 		int,
    zip 		int,
    city 		varchar(25),
    state 		varchar(25),
    PRIMARY KEY (id)
);

CREATE TABLE location (
	id 			int NOT NULL AUTO_INCREMENT,
    name 		varchar(30),
    description varchar(500),
    address 	varchar(50),
    zip 		int,
    latitude 	float,
    longitude 	float,
    filter varchar(50),
    PRIMARY KEY (id)
);

-- schedule as in school schedule or events that can't be replaced
CREATE TABLE scheduled_event (
	id 			int NOT NULL AUTO_INCREMENT,
    uid 		int,
    event_name 	varchar(25),
    start_time 	datetime,
    end_time 	datetime,
    repeating 	int, #update this in intellij
    PRIMARY KEY (id),
    FOREIGN KEY (uid) REFERENCES user (id)
);

#this is a new event based on location/activity
CREATE TABLE activity (
	id 			int NOT NULL AUTO_INCREMENT,
    lid 		int,
    name 		varchar(25),
    start_time 	datetime,
    end_time 	datetime,
    filter varchar(50),
    bid int,
    PRIMARY KEY (id),
    FOREIGN KEY (lid) REFERENCES location (id),
    FOREIGN KEY (bid) REFERENCES board (id)
);

CREATE TABLE board (
	id			int NOT NULL AUTO_INCREMENT,
    uid			int,
    name		varchar(25),
    num_activities int,
    order_num int,
    PRIMARY KEY (id),
    FOREIGN KEY (uid) REFERENCES user (id)
);

#attending activity
CREATE TABLE attend (
	id 			int NOT NULL AUTO_INCREMENT,
	userID 		int,
    activityID 	int,
    favorite	int,
    PRIMARY KEY (id),
    FOREIGN KEY (userID) REFERENCES user (id),
    FOREIGN KEY (activityID) REFERENCES activity (id)
);
