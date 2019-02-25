----genre table
INSERT INTO genre (created_at, updated_at, name) VALUES (now(), now(), 'POP');
INSERT INTO genre (created_at, updated_at, name) VALUES (now(), now(), 'MPB');
INSERT INTO genre (created_at, updated_at, name) VALUES (now(), now(), 'CLASSIC');
INSERT INTO genre (created_at, updated_at, name) VALUES (now(), now(), 'ROCK');

INSERT INTO album (id, created_at, updated_at, artist_name, name, number_of_tracks, price, genre_id) VALUES (1, now(), now(), 'ARTIST TEST', 'ALBUM TEST', 10, 50.00, (SELECT id FROM genre WHERE name = 'ROCK'));

INSERT INTO sale (id, created_at, updated_at, album_quantity, cash_back_amount, sale_amount, total_cash_back_amount, album_id) VALUES (1, now(), now(), 1, 5.00, 50.00, 5.00, 1);