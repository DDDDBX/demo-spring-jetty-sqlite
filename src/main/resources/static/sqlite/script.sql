create table hibernate_sequence
(
    next_val bigint
);

create table log
(
    id          integer not null
        primary key autoincrement,
    user_ip     varchar not null,
    operation   varchar not null,
    arguments   varchar,
    description varchar,
    timestamp   bigint  not null
);

create table note
(
    id      integer not null
        constraint table_test_pk
            primary key autoincrement,
    name    varchar not null,
    message varchar
);

create unique index table_test_id_uindex
    on note (id);

create table sqlite_master
(
    type     text,
    name     text,
    tbl_name text,
    rootpage int,
    sql      text
);

create table sqlite_sequence
(
    name,
    seq
);

create table user
(
    id       integer not null
        primary key autoincrement,
    name     varchar not null
        unique,
    password varchar not null,
    email    varchar not null,
    role     integer(1) default 0 not null
);

create table wx_follower
(
    id       int     not null
        constraint wx_follow_pk
            primary key,
    app_id   int     not null,
    app_name varchar not null,
    source   varchar not null,
    time     bigint  not null,
    uid      varchar not null,
    extra    varchar
);

create unique index wx_follow_id_uindex
    on wx_follower (id);


