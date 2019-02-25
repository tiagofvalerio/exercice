----genre table
INSERT INTO genre (created_at, updated_at, name) VALUES (now(), now(), 'POP');
INSERT INTO genre (created_at, updated_at, name) VALUES (now(), now(), 'MPB');
INSERT INTO genre (created_at, updated_at, name) VALUES (now(), now(), 'CLASSIC');
INSERT INTO genre (created_at, updated_at, name) VALUES (now(), now(), 'ROCK');

INSERT INTO album (created_at, updated_at, artist_name, name, number_of_tracks, price, genre_id) VALUES (now(), now(), 'ARTIST TEST', 'ALBUM TEST', 10, 50.00, (SELECT id FROM genre WHERE name = 'ROCK'));
INSERT INTO album (created_at, updated_at, artist_name, name, number_of_tracks, price, genre_id) VALUES (now(), now(), 'ARTIST TEST 2', 'ALBUM TEST 2', 11, 40.00, (SELECT id FROM genre WHERE name = 'ROCK'));
INSERT INTO album (created_at, updated_at, artist_name, name, number_of_tracks, price, genre_id) VALUES (now(), now(), 'ARTIST TEST 3', 'ALBUM TEST 3', 8, 37.60, (SELECT id FROM genre WHERE name = 'ROCK'));
INSERT INTO album (created_at, updated_at, artist_name, name, number_of_tracks, price, genre_id) VALUES (now(), now(), 'ARTIST TEST 4', 'ALBUM TEST 4', 15, 22.07, (SELECT id FROM genre WHERE name = 'ROCK'));
INSERT INTO album (created_at, updated_at, artist_name, name, number_of_tracks, price, genre_id) VALUES (now(), now(), 'ARTIST TEST 5', 'ALBUM TEST 5', 20, 46.00, (SELECT id FROM genre WHERE name = 'ROCK'));
INSERT INTO album (created_at, updated_at, artist_name, name, number_of_tracks, price, genre_id) VALUES (now(), now(), 'ARTIST TEST 6', 'ALBUM TEST 6', 18, 49.00, (SELECT id FROM genre WHERE name = 'ROCK'));
INSERT INTO album (created_at, updated_at, artist_name, name, number_of_tracks, price, genre_id) VALUES (now(), now(), 'ARTIST TEST 7', 'ALBUM TEST 7', 19, 30.00, (SELECT id FROM genre WHERE name = 'ROCK'));