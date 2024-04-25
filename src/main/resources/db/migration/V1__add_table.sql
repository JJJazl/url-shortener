CREATE TABLE bobo_short_url.urls
(
    id  bigserial PRIMARY KEY,
    key varchar(128)     NOT NULL unique,
    url varchar(128)     NOT NULL
);