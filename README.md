Test Task Weather Service REST API.
Spring Boot, WebFlux, PostgreSQL, Liquibase, Keycloak, Swagger, JUnit, Mockito

# Руководство по быстрому запуску
1. Выполнить `docker-compose up` из директории /docker. 

2. Открыть [Swagger UI](http://localhost:8080/swagger-ui/)

3. В AuthController дернуть POST запрос /auth, подставив username и password на выбор:

|username|password| role  |
|:------:|:------:|:-----:|
|user1   | user1  | user  |
|user2   | user2  | user  |
|admin   | admin  | admin |

4. Полученный Bearer token использовать для авторизации в Swagger UI (Кнопка Authorize)
5. Использовать API. В заголовках методов в скобках указаны роли, для которых доступны эти методы.

# Еще буквы
В Docker Запускается три контейнера: Postgres (порт 5432), Keycloak (порт 8181), само приложения (порт 8080).
Образ приложения лежит на [Docker Hub](https://hub.docker.com/r/pascalcode/weather-app).

При старте Keycloak в него импортируется realm с ролями "admin", "user" и тремя пользователями.
Подразумевается, что управление пользователями осуществляется через [Админ панель Keycloak](http://localhost:8181/auth/admin/)
Логин/пароль от админки - admin/admin
