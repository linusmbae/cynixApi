CREATE DATABASE cynix_database;
\c cynix_database;

CREATE TABLE men_wear(id serial PRIMARY KEY, name VARCHAR,color VARCHAR,size int,category VARCHAR);
CREATE TABLE cynix_shop(id serial PRIMARY KEY, name VARCHAR, buildingName VARCHAR, shopNumber VARCHAR, email VARCHAR, phone VARCHAR);
CREATE DATABASE cynix_test_database WITH TEMPLATE cynix_database;