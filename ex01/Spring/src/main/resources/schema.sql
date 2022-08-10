drop table if exists users CASCADE;

create table if not exists users (
                                             id SERIAL,
                                             email varchar(128) NOT NULL,
                                             PRIMARY KEY (id)
);