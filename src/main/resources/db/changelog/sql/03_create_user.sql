create table if not exists usr (
    id          bigserial not null,
    username    varchar(64),
    password    varchar(64),
    role        varchar(64),
    constraint pk_user_id primary key (id)
);
comment on table usr is 'Users';
comment on column usr.id is 'ID';
comment on column usr.username is 'User name';
comment on column usr.password is 'User password';
comment on column usr.role is 'User role';

insert into usr (id, username, password, role) values (1, 'admin', '12345', 'ROLE_ADMIN');
insert into usr (id, username, password, role) values (2, 'user1', '12345', 'ROLE_USER');
insert into usr (id, username, password, role) values (3, 'user2', '12345', 'ROLE_USER');
insert into usr (id, username, password, role) values (4, 'user3', '12345', 'ROLE_USER');
