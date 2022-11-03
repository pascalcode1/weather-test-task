create table if not exists usr (
    id          bigserial not null,
    username    varchar(64),
    constraint pk_user_id primary key (id)
);
comment on table usr is 'Users';
comment on column usr.id is 'ID';
comment on column usr.username is 'User name';

insert into usr (id, username) values (1, 'user1');
insert into usr (id, username) values (2, 'user2');
SELECT setval('usr_id_seq', 2, true);
