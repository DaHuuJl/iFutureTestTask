

## Запуск через Docker

Увы не работает :( 

Банковский сервер стартует и работает, однако клиент почему-то не может его найти, хотя порты указаны верно.
Если перейти по ссылке, которая логируется в ошибке, то видно, что всё работает, однако клиент падает с ошибкой. 
Думал что ошибка связана с WebFlux, однако при использовании RestTemplate такая же проблема.

## Создание БД в PostgreSQL

Запустить psql или PgAdmin. Авторизоваться, после (для PgAdmin) выбрать бд `postgres` и нажать на `Query Tool` (кнопка над сервером).
Создадим базу данных:

```
CREATE DATABASE ifuture_db;
```

Создание пользователя:

```
CREATE USER owner_ifuture_db WITH PASSWORD 'owner_ifuture_db';
```

Выделение прав пользователю:

```
GRANT ALL PRIVILEGES ON DATABASE "ifuture_db" to owner_ifuture_db;
```

Или сделать пользователя суперюзером:

```
ALTER USER owner_ifuture_db WITH SUPERUSER;
```