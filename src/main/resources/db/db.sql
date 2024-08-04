truncate table users cascade;
truncate table skilled_workers cascade;
truncate table skills cascade;


insert into users(id, firstName, lastName, username, phoneNumber, email, address, password, timeCreated) values
                                                                                                             (100, 'Fitzgerald', 'Ejidike', 'fitz94', '07012345678', 'fitzG@gmail.com', '911, allen avenue Ikeja Lagos', 'password', '2024-07-28T18:55:06.333644100'),
                                                                                                             (101, 'Glory', 'David', 'chichi', '08112345678', 'chichi@gmail.com', '112, airport road Ikeja, Lagos', 'password', '2024-07-28T18:55:06.333644100'),
                                                                                                             (102, 'Meshack', 'Yaro', 'bigbird', '08012345678', 'bigbirdhq@gmail.com', '312, Herbert Macauley way Yaba, Lagos', 'password', '2024-07-28T18:55:06.333644100'),
                                                                                                             (103, 'Victor', 'Msonter', 'gagnon', '09012345678', 'gagnon@gmail.com', '312, Herbert Macauley way Yaba, Lagos', 'password', '2024-07-28T18:55:06.333644100'),
                                                                                                             (104, 'joseph', 'Yisa', 'cultist', '09112345678', 'cultist@gmail.com', '304, Ozumba Mbadiwe way Victoria Island, Lagos', 'password', '2024-07-28T18:55:06.333644100');

insert into skilledWorkers(id, firstName, lastName, username, phoneNumber, email, address, timeCreated) values
                                                                                                            (200, 'Phillip', 'Ajibola', 'bobbyjay', '07012345678', 'bobbyjay@gmail.com', '404, sabo market yaba Lagos', 'password','electrician', '2024-07-28T18:55:06.333644100'),
                                                                                                            (201, 'Ayomide', 'Omoniyi', 'ayzzy', '08112345678', 'chichi@gmail.com', '47, sabo market Yaba, Lagos', 'password', '2024-07-28T18:55:06.333644100'),
                                                                                                            (202, 'Ramon', 'Fatoye', 'jargo', '08012345678', 'bigbirdhq@gmail.com', '312, Herbert Macauley way Yaba, Lagos', 'password', '2024-07-28T18:55:06.333644100'),
                                                                                                            (203, 'Victor', 'Msonter', 'gagnon', '09012345678', 'gagnon@gmail.com', '312, Herbert Macauley way Yaba, Lagos', 'password', '2024-07-28T18:55:06.333644100'),
                                                                                                            (204, 'Joseph', 'Yisa', 'cultist', '0912345678', 'cultist@gmail.com', '304, Ozumba Mbadiwe way Victoria Island, Lagos', 'password', '2024-07-28T18:55:06.333644100');

insert into skills(id, category, silled_worker_id) values
                                                       (100, 'ELECTRICAL', 200),
                                                       (101, 'PLUMBING', 201),
                                                       (102, 'FASHION', 202),
                                                       (103, 'FASHION', 103),
                                                       (10, 'BARBER', 104);
