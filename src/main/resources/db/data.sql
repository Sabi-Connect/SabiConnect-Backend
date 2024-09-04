truncate table skilled_workers cascade;
truncate table skills cascade;
truncate table clients cascade;
truncate table address cascade;
truncate table reviews cascade;
truncate table appointments cascade;
truncate table skills cascade;


insert into address(id, area, house_number, street)values
                                                       ('101', 'Shomolu', 12, 'church road'),
                                                       ('102', 'Lekki', 32, 'inipki'),
                                                       ('103', 'Yaba', 21, 'adekunle'),
                                                       ('104', 'Ajah', 15, 'adesanya');




INSERT INTO skilled_workers (address_id, id, full_name, password, phone_number, time_updated, email, username)
VALUES
    (101, 201, 'John Doe', 'password123', '123-456-7890', NOW(), 'john.doe@example.com', 'JohnDoe'),
    (102, 202, 'Jane Smith', 'password456', '098-765-4321', NOW(), 'jane.smith@example.com', 'JaneSmith'),
    (103, 203, 'Alice Johnson', 'password789', '555-555-5555', NOW(), 'alice.johnson@example.com', 'AliceJohnson'),
    (104, 204, 'Bob Brown', 'password321', '444-444-4444', NOW(), 'bob.brown@example.com', 'BobBrown');




INSERT INTO clients (id, address_id, full_name, password, phone_number, time_updated, email)
VALUES
    (301, 101, 'Michael Scott', 'password123', '123-456-7890', NOW(), 'michael.scott@example.com'),
    (302, 102, 'Pam Beesly', 'password456', '098-765-4321', NOW(), 'pam.beesly@example.com'),
    (303, 103, 'Jim Halpert', 'password789', '555-555-5555', NOW(), 'jim.halpert@example.com'),
    (304, 104, 'Dwight Schrute', 'password321', '444-444-4444', NOW(), 'dwight.schrute@example.com');



INSERT INTO reviews (client_id, id, review_date, skilled_worker_id, review)
VALUES
    (301, 101, '2024-08-01', 201, 'Excellent work, very professional.'),
    (302, 102, '2024-08-02', 202, 'Good job, but could improve on punctuality.'),
    (303, 103, '2024-08-03', 203, 'Average service, met expectations.'),
    (304, 104, '2024-08-04', 204, 'Outstanding performance, highly recommended.');


INSERT INTO appointments (clients_id, schedule_time, skilled_workers_id, status)
VALUES
    (301, '2024-08-10 10:00:00', 201, 'ACCEPTED'),
    (302, '2024-08-11 14:00:00', 202, 'DECLINED'),
    (303, '2024-08-12 09:00:00', 203, 'CANCELLED'),
    (304, '2024-08-13 16:00:00', 204, 'SCHEDULED');




INSERT INTO skills (id, skilled_worker_id, skill_category, skill_name)
VALUES
    (101, 201, 'ELECTRICAL', 'Wiring'),
    (102, 202, 'PLUMBING', 'Pipe Fitting'),
    (103, 203, 'CARPENTRY', 'Woodworking'),
    (104, 204, 'PHOTOGRAPHY', 'Event Photography');

