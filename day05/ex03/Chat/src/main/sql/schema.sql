drop table if exists messages, users, rooms, users_in_rooms CASCADE;

create table if not exists users (
                                            id SERIAL,
                                            login varchar(128) NOT NULL,
                                            password varchar(128) NOT NULL,
                                            PRIMARY KEY (id)
);

create table if not exists rooms (
                                            id SERIAL,
                                            name VARCHAR(128) NOT NULL,
                                            owner_id INT NOT NULL,

                                            PRIMARY KEY (id),
                                            FOREIGN KEY (owner_id) REFERENCES users(id) ON DELETE CASCADE
);

create table if not exists messages (
                                               id SERIAL,
                                               author_id INT NOT NULL,
                                               room_id INT NOT NULL,
                                               text VARCHAR(128) NOT NULL,
                                               time TIMESTAMP DEFAULT NOW(),

                                               PRIMARY KEY (id),
                                               FOREIGN KEY (author_id) REFERENCES users(id) ON DELETE CASCADE,
                                               FOREIGN KEY (room_id) REFERENCES rooms(id) ON DELETE CASCADE
);

create table if not exists users_in_rooms (
                                                     room_id int NOT NULL,
                                                     user_id int NOT NULL,

                                                     PRIMARY KEY (room_id, user_id),
                                                     FOREIGN KEY (room_id) REFERENCES users(id) ON UPDATE CASCADE ON DELETE CASCADE,
                                                     FOREIGN KEY (user_id) REFERENCES rooms(id) ON UPDATE CASCADE
);