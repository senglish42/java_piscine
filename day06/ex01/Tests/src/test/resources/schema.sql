CREATE TABLE IF NOT EXISTS store (
                                        identifier INTEGER GENERATED BY DEFAULT AS IDENTITY,
                                        name varchar(128) NOT NULL,
                                        price integer,

                                        PRIMARY KEY (identifier)
);