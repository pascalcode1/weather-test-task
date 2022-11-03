create table if not exists subscription (
    id          bigserial not null,
    user_id     bigint not null,
    city_id     bigint not null,
    constraint pk_subscription_id primary key (id),
    constraint fk_subscription_user foreign key (user_id) references usr (id),
    constraint fk_subscription_city foreign key (city_id) references city (id),
    constraint unique_user_city unique (user_id, city_id)
);
comment on table subscription is 'Weather user subscriptions';
comment on column subscription.id is 'ID';
comment on column subscription.user_id is 'Subscribed user';
comment on column subscription.city_id is 'The city whose weather the user is subscribed to';

insert into subscription (id, user_id, city_id) values (1, 2, 1);
insert into subscription (id, user_id, city_id) values (2, 2, 2);
insert into subscription (id, user_id, city_id) values (3, 2, 3);
insert into subscription (id, user_id, city_id) values (4, 2, 4);
SELECT setval('subscription_id_seq', 4, true);
