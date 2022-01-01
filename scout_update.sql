set sql_safe_updates = 0;
-- update location and activity ids
update location set activity_id = 1 where id = 1;
update activity set lid = 1 where id = 1;
update location set activity_id = 2 where id = 2;
update activity set lid = 2 where id = 2;
update location set activity_id = 3 where id = 3;
update activity set lid = 3 where id = 3;
update location set activity_id = 4 where id = 4;
update activity set lid = 4 where id = 4;

-- update board_activities
update activity set board_id = 1 where id = 1;
update activity set board_id = 2 where id = 2;
update activity set board_id = 2 where id = 3;
update activity set board_id = 1 where id = 4;

-- update board with user_ids
update board set user_id = 1 where id = 1;
update board set user_id = 1 where id = 2;
update board set user_id = 2 where id = 3;
update board set user_id = 3 where id = 4;

-- update attend with act ids
update attend set activity_id = 1 where id = 1;
update attend set activity_id = 1 where id = 2;
update attend set activity_id = 2 where id = 3;
update attend set activity_id = 3 where id = 4;

-- update attend with user ids
update attend set user_id = 1 where id = 1;
update attend set user_id = 1 where id = 2;
update attend set user_id = 1 where id = 3;
update attend set user_id = 1 where id = 4;

-- update scheduled_event with user ids
update scheduled_event set user_id = 1 where id = 1;
update scheduled_event set user_id = 2 where id = 2;
update scheduled_event set user_id = 3 where id = 3;
update scheduled_event set user_id = 3 where id = 4;

set sql_safe_updates = 1;