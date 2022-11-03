create view v_subscription as
select s.id          as id,
       s.user_id     as user_id,
       c.name        as city_name,
       w.temperature as temperature,
       w.humidity    as humidity
from subscription s
         left join city c on s.city_id = c.id
         left join weather w on c.id = w.city_id
         where c.visible = true;

comment on view v_subscription is 'Weather representation for users';
comment on column v_subscription.id is 'Subscription ID';
comment on column v_subscription.user_id is 'User ID';
comment on column v_subscription.city_name is 'City name';
comment on column v_subscription.temperature is 'Current temperature in city';
comment on column v_subscription.humidity is 'Current air humidity in city';
