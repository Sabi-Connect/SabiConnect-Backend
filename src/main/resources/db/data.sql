
truncate table skilled_workers cascade;
truncate table skills cascade;
truncate table clients cascade;
truncate table address cascade;
truncate table reviews cascade;
truncate table appointment cascade;


-- insert data into tables

insert into address(id, area, house_number, street)values
(2, 'Downtown', '101', 'Main Street'),
(3, 'Uptown', '202', 'Second Avenue'),
(4, 'Suburb', '303', 'Third Boulevard'),
(5, 'Riverside', '404', 'Fourth Drive'),
(6, 'Greenfield', '505', 'Fifth Lane'),
(7, 'Woodland', '606', 'Sixth Road'),
(8, 'Lakeside', '707', 'Seventh Terrace'),
(9, 'Hilltop', '808', 'Eighth Crescent'),
(10, 'Oceanview', '909', 'Ninth Parkway'),
(11, 'Highland', '1001', 'Tenth Way');

insert into  clients (address_id, first_name, last_name, password, phone_number, time_updated, email)values
    (2, 'Michael', 'Scott', 'password123', '123-456-7890', NOW(), 'michael.scott@example.com'),
    (3, 'Pam', 'Beesly', 'password456', '098-765-4321', NOW(), 'pam.beesly@example.com'),
    (4, 'Jim', 'Halpert', 'password789', '555-555-5555', NOW(), 'jim.halpert@example.com'),
    (5, 'Dwight', 'Schrute', 'password321', '444-444-4444', NOW(), 'dwight.schrute@example.com');






insert into skilled_workers(id, first_name, last_name, username, phone_number, email, address_id, time_created) values

 (200, 'Phillip', 'Ajibola', 'bobbyjay', '07001234567', 'bobbyjay@gmail.com', 6,  '2024-07-28T18:55:06.333644100'),
 (201, 'Ayomide', 'Omoniyi', 'ayzzy', '08101234567', 'chichi@gmail.com', 7,  '2024-07-28T18:55:06.333644100'),
 (202, 'Ramon', 'Fatoye', 'jargo', '08001234567', 'jargo@gmail.com', 8,  '2024-07-28T18:55:06.333644100'),
 (203, 'Abbey', 'Bioke', 'biokes', '09001234567', 'biokes@gmail.com', 9,  '2024-07-28T18:55:06.333644100'),
 (204, 'Michael', 'Dikandu', 'banksfc', '09101234567', 'banksfc@gmail.com', 10, '2024-07-28T18:55:06.333644100');


-- insert into appointment  (clients, schedule_time, skilled_workers, role, status)values
--     (2, '2024-08-10 10:00:00', , 'Electrician', 'Completed'),
--     (3, '2024-08-11 14:00:00', 3, 'Plumber', 'Pending'),
--     (4, '2024-08-12 09:00:00', 4, 'Carpenter', 'Cancelled'),
--     (5, '2024-08-13 16:00:00', 5, 'Painter', 'Completed');
