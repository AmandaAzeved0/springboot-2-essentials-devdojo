drop table if exists anime;

create table anime(
    id BIGINT     not null  auto_increment primary key,
    NAME VARCHAR (100) NOT NULL
);

insert into anime (name) values ('BDZ' );
insert into anime (name) values ('naruto' );
insert into anime (name) values ('cawboy bebop' );
insert into anime (name) values ('steins gate' );
insert into anime (name) values ('one punch man' );
insert into anime (name) values ('death note' );