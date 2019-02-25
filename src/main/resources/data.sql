----genre table
INSERT INTO genre (created_at, updated_at, name) VALUES (now(), now(), 'POP');
INSERT INTO genre (created_at, updated_at, name) VALUES (now(), now(), 'MPB');
INSERT INTO genre (created_at, updated_at, name) VALUES (now(), now(), 'CLASSIC');
INSERT INTO genre (created_at, updated_at, name) VALUES (now(), now(), 'ROCK');

----sale_percentage table
----POP
INSERT INTO sale_percentage (created_at, updated_at, day_of_week, percentage, genre_uuid) 
VALUES (now(), now(), 'SUNDAY', 0.25, (SELECT id FROM genre WHERE name = 'POP'));
INSERT INTO sale_percentage (created_at, updated_at, day_of_week, percentage, genre_uuid) 
VALUES (now(), now(), 'MONDAY', 0.07, (SELECT id FROM genre WHERE name = 'POP'));
INSERT INTO sale_percentage (created_at, updated_at, day_of_week, percentage, genre_uuid) 
VALUES (now(), now(), 'TUESDAY', 0.06, (SELECT id FROM genre WHERE name = 'POP'));
INSERT INTO sale_percentage (created_at, updated_at, day_of_week, percentage, genre_uuid) 
VALUES (now(), now(), 'WEDNESDAY', 0.02, (SELECT id FROM genre WHERE name = 'POP'));
INSERT INTO sale_percentage (created_at, updated_at, day_of_week, percentage, genre_uuid) 
VALUES (now(), now(), 'THURSDAY', 0.10, (SELECT id FROM genre WHERE name = 'POP'));
INSERT INTO sale_percentage (created_at, updated_at, day_of_week, percentage, genre_uuid) 
VALUES (now(), now(), 'FRIDAY', 0.15, (SELECT id FROM genre WHERE name = 'POP'));
INSERT INTO sale_percentage (created_at, updated_at, day_of_week, percentage, genre_uuid) 
VALUES (now(), now(), 'SATURDAY', 0.20, (SELECT id FROM genre WHERE name = 'POP'));

--MPB
INSERT INTO sale_percentage (created_at, updated_at, day_of_week, percentage, genre_uuid) 
VALUES (now(), now(), 'SUNDAY', 0.30, (SELECT id FROM genre WHERE name = 'MPB'));
INSERT INTO sale_percentage (created_at, updated_at, day_of_week, percentage, genre_uuid) 
VALUES (now(), now(), 'MONDAY', 0.05, (SELECT id FROM genre WHERE name = 'MPB'));
INSERT INTO sale_percentage (created_at, updated_at, day_of_week, percentage, genre_uuid) 
VALUES (now(), now(), 'TUESDAY', 0.10, (SELECT id FROM genre WHERE name = 'MPB'));
INSERT INTO sale_percentage (created_at, updated_at, day_of_week, percentage, genre_uuid) 
VALUES (now(), now(), 'WEDNESDAY', 0.15, (SELECT id FROM genre WHERE name = 'MPB'));
INSERT INTO sale_percentage (created_at, updated_at, day_of_week, percentage, genre_uuid) 
VALUES (now(), now(), 'THURSDAY', 0.20, (SELECT id FROM genre WHERE name = 'MPB'));
INSERT INTO sale_percentage (created_at, updated_at, day_of_week, percentage, genre_uuid) 
VALUES (now(), now(), 'FRIDAY', 0.25, (SELECT id FROM genre WHERE name = 'MPB'));
INSERT INTO sale_percentage (created_at, updated_at, day_of_week, percentage, genre_uuid) 
VALUES (now(), now(), 'SATURDAY', 0.30, (SELECT id FROM genre WHERE name = 'MPB'));

--CLASSIC
INSERT INTO sale_percentage (created_at, updated_at, day_of_week, percentage, genre_uuid) 
VALUES (now(), now(), 'SUNDAY', 0.35, (SELECT id FROM genre WHERE name = 'CLASSIC'));
INSERT INTO sale_percentage (created_at, updated_at, day_of_week, percentage, genre_uuid) 
VALUES (now(), now(), 'MONDAY', 0.03, (SELECT id FROM genre WHERE name = 'CLASSIC'));
INSERT INTO sale_percentage (created_at, updated_at, day_of_week, percentage, genre_uuid) 
VALUES (now(), now(), 'TUESDAY', 0.05, (SELECT id FROM genre WHERE name = 'CLASSIC'));
INSERT INTO sale_percentage (created_at, updated_at, day_of_week, percentage, genre_uuid) 
VALUES (now(), now(), 'WEDNESDAY', 0.08, (SELECT id FROM genre WHERE name = 'CLASSIC'));
INSERT INTO sale_percentage (created_at, updated_at, day_of_week, percentage, genre_uuid) 
VALUES (now(), now(), 'THURSDAY', 0.13, (SELECT id FROM genre WHERE name = 'CLASSIC'));
INSERT INTO sale_percentage (created_at, updated_at, day_of_week, percentage, genre_uuid) 
VALUES (now(), now(), 'FRIDAY', 0.18, (SELECT id FROM genre WHERE name = 'CLASSIC'));
INSERT INTO sale_percentage (created_at, updated_at, day_of_week, percentage, genre_uuid) 
VALUES (now(), now(), 'SATURDAY', 0.25, (SELECT id FROM genre WHERE name = 'CLASSIC'));

--ROCK
INSERT INTO sale_percentage (created_at, updated_at, day_of_week, percentage, genre_uuid) 
VALUES (now(), now(), 'SUNDAY', 0.40, (SELECT id FROM genre WHERE name = 'ROCK'));
INSERT INTO sale_percentage (created_at, updated_at, day_of_week, percentage, genre_uuid) 
VALUES (now(), now(), 'MONDAY', 0.10, (SELECT id FROM genre WHERE name = 'ROCK'));
INSERT INTO sale_percentage (created_at, updated_at, day_of_week, percentage, genre_uuid) 
VALUES (now(), now(), 'TUESDAY', 0.15, (SELECT id FROM genre WHERE name = 'ROCK'));
INSERT INTO sale_percentage (created_at, updated_at, day_of_week, percentage, genre_uuid) 
VALUES (now(), now(), 'WEDNESDAY', 0.15, (SELECT id FROM genre WHERE name = 'ROCK'));
INSERT INTO sale_percentage (created_at, updated_at, day_of_week, percentage, genre_uuid) 
VALUES (now(), now(), 'THURSDAY', 0.15, (SELECT id FROM genre WHERE name = 'ROCK'));
INSERT INTO sale_percentage (created_at, updated_at, day_of_week, percentage, genre_uuid) 
VALUES (now(), now(), 'FRIDAY', 0.20, (SELECT id FROM genre WHERE name = 'ROCK'));
INSERT INTO sale_percentage (created_at, updated_at, day_of_week, percentage, genre_uuid) 
VALUES (now(), now(), 'SATURDAY', 0.40, (SELECT id FROM genre WHERE name = 'ROCK'));