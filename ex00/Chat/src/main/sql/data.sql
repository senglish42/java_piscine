INSERT INTO users (login, password) VALUES ('senglish', 'pass');
INSERT INTO users (login, password) VALUES ('senglishClone', '123');
INSERT INTO users (login, password) VALUES ('senglishForgotPass', 'whatisthepass');
INSERT INTO users (login, password) VALUES ('somenum', '123');
INSERT INTO users (login, password) VALUES ('root', 'root');

INSERT INTO rooms (owner_id, name) VALUES (1, '1room');
INSERT INTO rooms (owner_id, name) VALUES (1, '2room');
INSERT INTO rooms (owner_id, name) VALUES (3, '3room');
INSERT INTO rooms (owner_id, name) VALUES (4, '4room');
INSERT INTO rooms (owner_id, name) VALUES (5, '5room');

INSERT INTO messages (author_id, room_id, text)
VALUES (1, 1, 'the first room');
INSERT INTO messages (author_id, room_id, text)
VALUES (1, 1, 'the second msg of the first room');
INSERT INTO messages (author_id, room_id, text)
VALUES (2, 2, 'the second room');
INSERT INTO messages (author_id, room_id, text)
VALUES (3, 3, 'the third room');
INSERT INTO messages (author_id, room_id, text)
VALUES (4, 4, 'the fourth room');


INSERT INTO users_in_rooms SELECT rooms.id, rooms.owner_id FROM rooms;