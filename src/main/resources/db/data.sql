truncate table skilled_workers cascade;
truncate table skills cascade;
truncate table clients cascade;
truncate table address cascade;
truncate table reviews cascade;
truncate table appointments cascade;
truncate table skills cascade;


insert into address(id, area, house_number, street)values
    (1, 'Shomolu', 12, 'church street'),
    (2, 'Yaba', 32, 'adekunle'),
    (3, 'Epe', 21, 'adewale'),
    (4, 'Ajah', 15, 'adesanya');



INSERT INTO skilled_workers (address_id, id, first_name, last_name, password, phone_number, time_updated, email, username)
VALUES
    (1, 1, 'John', 'Doe', 'password123', '123-456-7890', NOW(), 'john.doe@example.com', 'JohnDoe'),
    (2, 3, 'Jane', 'Smith', 'password456', '098-765-4321', NOW(), 'jane.smith@example.com', 'JaneSmith'),
    (3, 4, 'Alice', 'Johnson', 'password789', '555-555-5555', NOW(), 'alice.johnson@example.com', 'AliceJohnson'),
    (4, 2, 'Bob', 'Brown', 'password321', '444-444-4444', NOW(), 'bob.brown@example.com', 'BobBrown');



INSERT INTO clients (id, address_id, first_name, last_name, password, phone_number, time_updated, email)
VALUES
    (1, 1, 'Michael', 'Scott', 'password123', '123-456-7890', NOW(), 'michael.scott@example.com'),
    (2, 2, 'Pam', 'Beesly', 'password456', '098-765-4321', NOW(), 'pam.beesly@example.com'),
    (3, 3, 'Jim', 'Halpert', 'password789', '555-555-5555', NOW(), 'jim.halpert@example.com'),
    (4, 4, 'Dwight', 'Schrute', 'password321', '444-444-4444', NOW(), 'dwight.schrute@example.com');



INSERT INTO reviews (client_id, review_date, skilled_worker_id, review)
VALUES
    (1, '2024-08-01', 1, 'Excellent work, very professional.'),
    (2, '2024-08-02', 2, 'Good job, but could improve on punctuality.'),
    (3, '2024-08-03', 3, 'Average service, met expectations.'),
    (4, '2024-08-04', 4, 'Outstanding performance, highly recommended.');



INSERT INTO appointments (clients_id, schedule_time, skilled_workers_id, status)
VALUES
    (1, '2024-08-10 10:00:00', 1, 'ACCEPTED'),
    (2, '2024-08-11 14:00:00', 2, 'DECLINED'),
    (3, '2024-08-12 09:00:00', 3, 'CANCELLED'),
    (4, '2024-08-13 16:00:00', 4, 'SCHEDULED');



INSERT INTO skills (id, skilled_worker_id, skill_category, skill_name)
VALUES
    (1, 1, 'ELECTRICAL', 'Wiring'),
    (2, 2, 'PLUMBING', 'Pipe Fitting'),
    (3, 3, 'CARPENTRY', 'Woodworking'),
    (4, 4, 'PHOTOGRAPHY', 'Event Photography');
