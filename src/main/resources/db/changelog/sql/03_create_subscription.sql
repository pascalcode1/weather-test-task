create table if not exists subscription (
    id          bigserial not null,
    user_id     varchar(64) not null,
    city_id     bigint not null,
    constraint pk_subscription_id primary key (id),
    constraint fk_subscription_city foreign key (city_id) references city (id),
    constraint unique_user_city unique (user_id, city_id)
);
comment on table subscription is 'Weather user subscriptions';
comment on column subscription.id is 'ID';
comment on column subscription.user_id is 'Subscribed user';
comment on column subscription.city_id is 'The city whose weather the user is subscribed to';

insert into subscription (id, user_id, city_id) values (1, '830f4e9d-b75e-443d-87fe-91bb184b29d7', 1);
insert into subscription (id, user_id, city_id) values (2, '830f4e9d-b75e-443d-87fe-91bb184b29d7', 2);
insert into subscription (id, user_id, city_id) values (3, '830f4e9d-b75e-443d-87fe-91bb184b29d7', 3);
insert into subscription (id, user_id, city_id) values (4, '830f4e9d-b75e-443d-87fe-91bb184b29d7', 4);
insert into subscription (id, user_id, city_id) values (5, '5272549a-fc21-4191-abb0-17c47925679b', 15);
SELECT setval('subscription_id_seq', 5, true);
