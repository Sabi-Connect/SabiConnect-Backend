
-- truncate table skilledWorkers cascade;
truncate table skills cascade;
truncate table users cascade;
truncate table address cascade;

-- insert data into tables

insert into address(id)values
                           (2),
                           (3),
                           (4),
                           (5),
                           (6),
                           (7),
                           (8),
                           (9),
                           (10);

insert into users(id, first_name, last_name, username, phone_number, email, address_id, password, time_created) values
    (100, 'Fitzgerald', 'Ejidike', 'fitz94', '07012345678', 'fitzG@gmail.com', 2, 'password', '2024-07-28T18:55:06.333644100'),
    (101, 'Glory', 'David', 'chichi', '08112345678', 'chichi@gmail.com', 3, 'password', '2024-07-28T18:55:06.333644100'),
    (102, 'Meshack', 'Yaro', 'bigbird', '08012345678', 'bigbirdhq@gmail.com', 4, 'password', '2024-07-28T18:55:06.333644100'),
    (103, 'Victor', 'Msonter', 'gagnon', '09012345678', 'gagnon@gmail.com', 5, 'password', '2024-07-28T18:55:06.333644100'),
    (104, 'joseph', 'Yisa', 'cultist', '09112345678', 'cultist@gmail.com', 6, 'password', '2024-07-28T18:55:06.333644100');


-- insert into skilledWorkers(id, first_name, last_name, username, phone_number, email, address_id, time_created) values
--     (200, 'Phillip', 'Ajibola', 'bobbyjay', '07001234567', 'bobbyjay@gmail.com', 6, 'password','electrician', '2024-07-28T18:55:06.333644100'),
--     (201, 'Ayomide', 'Omoniyi', 'ayzzy', '08101234567', 'chichi@gmail.com', 7, 'password', '2024-07-28T18:55:06.333644100'),
--     (202, 'Ramon', 'Fatoye', 'jargo', '08001234567', 'jargo@gmail.com', 8, 'password', '2024-07-28T18:55:06.333644100'),
--     (203, 'Abbey', 'Bioke', 'biokes', '09001234567', 'biokes@gmail.com', 9, 'password', '2024-07-28T18:55:06.333644100'),
--     (204, 'Michael', 'Dikandu', 'banksfc', '09101234567', 'banksfc@gmail.com', 10, 'password', '2024-07-28T18:55:06.333644100');

--
-- insert into skills(id, skill_category, skilled_worker_id) values
--     (100, 'ELECTRICAL', 100),
--     (101, 'PLUMBING', 101),
--     (102, 'FASHION', 102),
--     (103, 'FASHION', 103),
--     (104, 'BARBER', 104);
