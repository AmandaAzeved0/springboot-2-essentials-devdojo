drop table if exists anime;

create table anime(
    id BIGINT     not null  auto_increment primary key,
    NAME VARCHAR (100) NOT NULL
);