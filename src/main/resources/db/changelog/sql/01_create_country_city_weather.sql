create table if not exists country (
    id          bigserial not null,
    name        varchar(64),
    constraint pk_counry_id primary key (id)
);
comment on table country is 'Countries';
comment on column country.id is 'ID';
comment on column country.name is 'Country name';

create table if not exists city (
    id          bigserial not null,
    name        varchar(64),
    country_id  integer not null,
    constraint pk_city_id primary key (id),
    constraint fk_city_country foreign key (country_id) references country (id)
);
comment on table city is 'Cities';
comment on column city.id is 'ID';
comment on column city.name is 'City name';
comment on column city.country_id is 'Country of the city';

create table if not exists weather (
    id          bigserial not null,
    temperature integer default 14,
    humidity    integer default 60,
    city_id     bigint not null,
    constraint pk_weather_id primary key (id),
    constraint fk_weather_city foreign key (city_id) references city (id),
    constraint humidity_check_range check (humidity >= 0 and humidity <= 100),
    constraint unique_city unique (city_id)
);
comment on table weather is 'Weather';
comment on column weather.id is 'ID';
comment on column weather.temperature is 'Temperature';
comment on column weather.humidity is 'Air humidity (0-100)';
comment on column weather.city_id is 'City of the weather';