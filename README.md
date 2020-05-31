# Project Name
#### [cynixApi](https://github.com/linusmbae/cynixApi.git)
# Author Name
Mbae Linus Mutugi

![alt text](https://github.com/linusmbae/cynixApi/blob/master/src/main/resources/public/images/me/me.jpg)

# Project Setup
### Database Setup
Click [here](https://www.postgresql.org/download/) to install postgreSQL if you don't have one.

for ubuntu users use the following in the terminal:

> sudo apt-get update

> sudo apt-get install postgresql postgresql-contrib libpq-dev

 ##### creating database
* open your terminal and paste the following:
> psql <destroy.sql 

* This will destroy the databases created with same name

> psql <create.sql

* This will create all tables required for the system

### cloning project

Click [here](https://github.com/linusmbae/cynixApi.git) and fork this repository to your github.

Copy the clone link.

Navigate through your local storage to your favourite directory using terminal.

Clone the App to your local storage and launch it using the inteliJ IDEA.
 
 
 # Getting things ready
 * navigate to your project and make necessary changes to the following files;
 #### path
 > CynixApi/src/main/java/App

>>  String connectionString = "jdbc:postgresql://localhost:5432/cynix_database";

>>  Sql2o sql2o = new Sql2o(connectionString, "user", "pass");

> CynixApi/src/test/java/models/dao/

* make necessary changes to the database links in the test files

>>  String connectionString = "jdbc:postgresql://localhost:5432/cynix_test_database";

>>  Sql2o sql2o = new Sql2o(connectionString, "user", "pass");

 ## Live Link
 Live Link ~ [Home](https://cynix-shop.herokuapp.com/)
 
 ### How to use app in heroku
 
 You can use postman to test the following keys.
 * Download postman [here](https://www.postman.com/downloads/) if you don't have it.
 
 Steps on how to use the API
 
 *Replace ":id" with the id you intend to use eg (https://cynix-shop.herokuapp.com/shop/1)
 
  SHOPS
 * New Shop 
 
 ![alt text](https://github.com/linusmbae/cynixApi/blob/master/src/main/resources/public/images/shop/newShop.png)
 > https://cynix-shop.herokuapp.com/shops/new (Method~Post)
* Fetch All Shops
 
 ![alt text](https://github.com/linusmbae/cynixApi/blob/master/src/main/resources/public/images/shop/allShops.png)
 > https://cynix-shop.herokuapp.com/shops (Method~get)
* Fetch Shop By Id

 ![alt text](https://github.com/linusmbae/cynixApi/blob/master/src/main/resources/public/images/shop/shopById.png)
> https://cynix-shop.herokuapp.com/shop/:id (Method~get)
* Remove Shop By Id

 ![alt text](https://github.com/linusmbae/cynixApi/blob/master/src/main/resources/public/images/shop/removeShopById.png)
> https://cynix-shop.herokuapp.com/shop/:id/remove (Method~Post)
* Clear The Database

 ![alt text](https://github.com/linusmbae/cynixApi/blob/master/src/main/resources/public/images/shop/clearShop.png)
> https://cynix-shop.herokuapp.com/shop/clear (Method~Post)

FASHIONS
* MEN'S WEAR

* New Wear

 ![alt text](https://github.com/linusmbae/cynixApi/blob/master/src/main/resources/public/images/fashions/newWear.png)
> https://cynix-shop.herokuapp.com/fashion/men/new (Method~Post)
* Fetch All Men's Wear

 ![alt text](https://github.com/linusmbae/cynixApi/blob/master/src/main/resources/public/images/fashions/getAll.png)
> https://cynix-shop.herokuapp.com/fashion/men (Method~get)
* Fetch Men's Wear By Id

 ![alt text](https://github.com/linusmbae/cynixApi/blob/master/src/main/resources/public/images/fashions/getById.png)
> https://cynix-shop.herokuapp.com/fashion/men/:id (Method~get)
* Remove Men's Wear By Id

 ![alt text](https://github.com/linusmbae/cynixApi/blob/master/src/main/resources/public/images/fashions/removeById.png)
> https://cynix-shop.herokuapp.com/fashion/men/:id/remove (Method~Post)
* Clear The Database

 ![alt text](https://github.com/linusmbae/cynixApi/blob/master/src/main/resources/public/images/fashions/clearFashions.png)
> https://cynix-shop.herokuapp.com/fashion/men/clear (Method~Post)
 
## Reach me
[Email](linusmutugi5178@gmail.com) 

# CopyRight & License
MIT License

#### Cynix-Shop-Api