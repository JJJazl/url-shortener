CREATE TABLE bobo_short_url.urls
(
    id  uuid PRIMARY KEY NOT NULL,
    key varchar(128)     NOT NULL unique,
    url varchar(128)     NOT NULL
);