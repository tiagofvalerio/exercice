----genre table
INSERT INTO genre (created_at, updated_at, name) VALUES (now(), now(), 'POP');
INSERT INTO genre (created_at, updated_at, name) VALUES (now(), now(), 'MPB');
INSERT INTO genre (created_at, updated_at, name) VALUES (now(), now(), 'CLASSIC');
INSERT INTO genre (created_at, updated_at, name) VALUES (now(), now(), 'ROCK');

----album table
INSERT INTO album (created_at, updated_at, artist_name, name, number_of_tracks, price, genre_id) VALUES (now(), now(), 'ARTIST TEST', 'ALBUM TEST', 10, 50.00, (SELECT id FROM genre WHERE name = 'ROCK'));
INSERT INTO album (created_at, updated_at, artist_name, name, number_of_tracks, price, genre_id) VALUES (now(), now(), 'ARTIST TEST 2', 'ALBUM TEST 2', 11, 40.00, (SELECT id FROM genre WHERE name = 'ROCK'));
INSERT INTO album (created_at, updated_at, artist_name, name, number_of_tracks, price, genre_id) VALUES (now(), now(), 'ARTIST TEST 3', 'ALBUM TEST 3', 8, 37.60, (SELECT id FROM genre WHERE name = 'ROCK'));
INSERT INTO album (created_at, updated_at, artist_name, name, number_of_tracks, price, genre_id) VALUES (now(), now(), 'ARTIST TEST 4', 'ALBUM TEST 4', 15, 22.07, (SELECT id FROM genre WHERE name = 'ROCK'));
INSERT INTO album (created_at, updated_at, artist_name, name, number_of_tracks, price, genre_id) VALUES (now(), now(), 'ARTIST TEST 5', 'ALBUM TEST 5', 20, 46.00, (SELECT id FROM genre WHERE name = 'ROCK'));
INSERT INTO album (created_at, updated_at, artist_name, name, number_of_tracks, price, genre_id) VALUES (now(), now(), 'ARTIST TEST 6', 'ALBUM TEST 6', 18, 49.00, (SELECT id FROM genre WHERE name = 'ROCK'));
INSERT INTO album (created_at, updated_at, artist_name, name, number_of_tracks, price, genre_id) VALUES (now(), now(), 'ARTIST TEST 7', 'ALBUM TEST 7', 19, 30.00, (SELECT id FROM genre WHERE name = 'ROCK'));

----sale table
INSERT INTO sale (id, created_at, updated_at, album_quantity, cash_back_amount, sale_amount, total_cash_back_amount, album_id) VALUES (1, '2019-02-25T13:00:00.000', '2019-02-25T13:00:00.000', 1, 5.00, 50.00, 5.00, 1);
INSERT INTO sale (id, created_at, updated_at, album_quantity, cash_back_amount, sale_amount, total_cash_back_amount, album_id) VALUES (2, '2019-02-25T13:01:00.000', '2019-02-25T13:01:00.000', 2, 4.00, 80.00, 8.00, 2);
INSERT INTO sale (id, created_at, updated_at, album_quantity, cash_back_amount, sale_amount, total_cash_back_amount, album_id) VALUES (3, '2019-02-25T13:02:00.000', '2019-02-25T13:02:00.000', 3, 3.70, 112.80, 11.10, 3);
INSERT INTO sale (id, created_at, updated_at, album_quantity, cash_back_amount, sale_amount, total_cash_back_amount, album_id) VALUES (4, '2019-02-25T13:03:00.000', '2019-02-25T13:03:00.000', 1, 5.00, 50.00, 5.00, 1);
INSERT INTO sale (id, created_at, updated_at, album_quantity, cash_back_amount, sale_amount, total_cash_back_amount, album_id) VALUES (5, '2019-02-25T13:04:00.000', '2019-02-25T13:04:00.000', 1, 5.00, 50.00, 5.00, 1);
INSERT INTO sale (id, created_at, updated_at, album_quantity, cash_back_amount, sale_amount, total_cash_back_amount, album_id) VALUES (6, '2019-01-01T13:00:00.000', '2019-01-01T13:00:00.000', 1, 5.00, 50.00, 5.00, 1);