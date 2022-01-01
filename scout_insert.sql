INSERT INTO user (username, first_name, last_name, email, password, age, zip, city, state)
VALUES ("kmytien", "MyTien", "Kien", "kmytien@iastate.edu", "test1", 20, 50010, "Ames", "Iowa"),
	   ("hayleel", "Haylee", "Lawrence", "hayleel@iastate.edu", "test2", 20, 50010, "Ames", "Iowa"),
       ("britneyy", "Britney", "Yu", "britneyy@iastate.edu", "test3", 20, 50010, "Ames", "Iowa"),
       ("samatya", "Sanjana", "Amatya", "samatya@iastate.edu", "test4", 19, 50010, "Ames", "Iowa");
       
INSERT INTO location (id, name, description, address, zip, latitude, longitude, filter)
VALUES (1, "Parks Library", "A library at Iowa State University", "701 Morrill Road, Ames, Iowa", 50010, 42.027584, -93.648789, "Libraries"),
	   (2, "Ada Hayden Park", "A pretty park with a lake", "5205 Grand Ave, Ames, Iowa", 50010, 42.064430, -93.623400, "Parks"),
       (3, "North Grand Mall", "A mall located north of Ames", "2801 Grand Ave, Ames, Iowa", 50010, 42.049382, -93.621755, "Shopping Centers"),
       (4, "Great Plains Pizza", "Old school pizza, located in downtown Ames", "129 Main St #101, Ames, Iowa", 50010, 42.025138, -93.611810, "Restaurants");
       
INSERT INTO scheduled_event (id, event_name, start_time, end_time, repeating)
VALUES (1, "COM S 309 Lecture", '2021-08-23 11:00:00', '2021-12-15 11:50:00', true),
	   (2, "Work: Tutoring", '2021-08-23 16:25:00', '2021-12-15 18:00:00', true),
       (3, "COM S 230 Exam", '2021-11-04 20:15:00', '2021-11-04 21:45:00', false),
       (4, "Office Hours", '2021-08-23 18:00:00', '2021-12-15 19:00:00', true);
       
INSERT INTO activity (id, name, start_time, end_time, filter)
VALUES (1, "Dog Therapy for Dead Week", '2021-12-10 11:00:00', '2021-12-15 17:00:00', "Recreation"),
	   (2, "50% Off Pizza Dinner", '2021-11-10 11:00:00', '2021-11-10 19:00:00', "Meal Discounts"),
	   (3, "Free Coffee for Finals", '2021-12-10 11:00:00', '2021-12-15 17:00:00', "Meal Discounts"),
       (4, "Marathon with your Pet!", '2021-11-10 11:00:00', '2021-11-15 17:00:00', "Recreation");
       
INSERT INTO board (id, name, num_elements, order_num)
VALUES (1, "Pet Things", 5, 1),
	   (2, "Restaurants", 8, 2),
	   (3, "Parks in Ames", 3, 1),
       (4, "Celebrating", 2, 3);
       
INSERT INTO attend (favorite)
VALUES (1),
	   (0),
	   (0),
	   (1);
       
INSERT INTO board_activities (activities_id, board_id)
VALUES (1, 1),
	   (2, 2),
       (3, 2),
       (4, 1);
       
INSERT INTO user_boards (user_id, boards_id)
VALUES (1, 1),
	   (1, 2),
       (2, 3),
       (3, 4);
       
INSERT INTO activity_attends (activity_id, attends_id)
VALUES (1, 1),
       (2, 2),
       (3, 3),
       (4, 4);
       
INSERT INTO user_attends (user_id, attends_id)
VALUES (1, 1),
       (1, 2),
       (1, 3),
       (1, 4);
       
INSERT INTO board_activities (board_id, activities_id)
VALUES (1, 1),
       (1, 4),
       (2, 3),
       (2, 2);
       
INSERT INTO user_scheduled_events (user_id, scheduled_events_id)
VALUES (1, 1),
       (2, 2),
       (3, 3),
       (3, 4);
